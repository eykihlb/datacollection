package com.mydao.datacollection.Task;

import com.mydao.datacollection.dao.server.ConsumeWasteMapper;
import com.mydao.datacollection.dao.server.HourSumMapper;
import com.mydao.datacollection.dao.station.DataTransactionMapper;
import com.mydao.datacollection.dao.station.ParamNewJourenyMapper;
import com.mydao.datacollection.dao.station.SiteInfoMapper;
import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.server.HourSum;
import com.mydao.datacollection.entity.station.DataTransaction;
import com.mydao.datacollection.entity.station.ParamNewJoureny;
import com.mydao.datacollection.entity.station.SiteInfo;
import com.mydao.datacollection.service.DataTransactionService;
import com.mydao.datacollection.utils.DateUtil;
import com.mydao.datacollection.utils.NetUtils;
import com.mydao.datacollection.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MTCDataForSiteTask {

    @Autowired
    private DataTransactionMapper dataTransactionMapper;

    @Autowired
    private DataTransactionService dataTransactionService;

    @Autowired
    private SiteInfoMapper siteInfoMapper;

    @Autowired
    private ParamNewJourenyMapper paramNewJourenyMapper;

    @Value(value = "${sitecfg.datatime}")
    private String datatime;
    @Value(value = "${sitecfg.netno}")
    private String netno;
    @Value(value = "${sitecfg.siteno}")
    private String siteno;
    @Value(value = "${sitecfg.fnetno}")
    private String fnetno;
    @Value(value = "${sitecfg.fsiteno}")
    private String fsiteno;
    @Value(value = "${sitecfg.sitetype}")
    private String sitetype;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH");

    @Async
    public void misDate() throws Exception{
        System.out.println("MTC");
        do {
            try {
                if (NetUtils.isReachable("10.65.1.11")){
                    List<DataTransaction> l = dataTransactionMapper.selectMissDate();
                    for (DataTransaction d : l) {
                        System.out.println(d.getMissdate());
                        dataTransaction(s.parse(d.getMissdate()));
                    }
                    Thread.sleep(300000);
                }else {
                    System.out.println("网络重连中。。。");
                    Thread.sleep(300000);
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("在哪里跌倒就从哪里爬起来。。。");
            }
        }while (true);
    }
    public void dataTransaction(Date date) throws Exception{
        Map<String,Object> mm = DateUtil.getDaysHours(date);
        DecimalFormat df = new DecimalFormat("#.000");
        List<SiteInfo> sl = siteInfoMapper.findList();
        List<DataTransaction> list;
        ConsumeWaste c;
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("netSiteNo",netno+siteno);
        paramMap.put("beginDays",mm.get("start").toString());
        paramMap.put("endDays",mm.get("end").toString());
        do {
            list = dataTransactionMapper.selectByDays(paramMap);
            System.out.println(list.size()+"---"+new Date());
            for (DataTransaction d : list) {
                int month = DateUtil.getMouth(sdf.parse(DateUtil.getBeforeDate(date,0).get("beginDays").toString()));
                c = new ConsumeWaste();
                c.setAxlecount((int)d.getFareaxles());//总轴数
                c.setActualpay(d.getPrixpartial());//实收
                c.setCarclass("01".equals(d.getClassno())?"0":"02".equals(d.getClassno())?"0":"03".equals(d.getClassno())?"0":"04".equals(d.getClassno())?"0":"05".equals(d.getClassno())?"1":"06".equals(d.getClassno())?"1":"07".equals(d.getClassno())?"1":"08".equals(d.getClassno())?"1":"09".equals(d.getClassno())?"1":"2");//车型
                c.setCarplate(d.getParvehicleplate().equals("...")?"无结果":d.getParvehicleplate().equals("无车牌")?"无结果":d.getParvehicleplate().length()<7?"无结果":d.getParvehicleplate());//车牌号
                c.setCartype(d.getClassno());//车种
                c.setAxletype(c.getCarclass().equals("1") ? StringUtils.getStr(d.getAxletypeandweight()) : "");//轴型及轴重
                ParamNewJoureny pp = new ParamNewJoureny();
                if(sitetype.equals("1")){
                    pp.setEnstationid(netno+siteno);
                }else{
                    pp.setEnstationid(d.getEntrynetno()+d.getEntrysiteno());
                }
                pp.setExstationid(netno+siteno);
                ParamNewJoureny p = paramNewJourenyMapper.selectDis(pp);
                String dis = "";
                if (p!=null){
                    dis = p.getDistance();
                }
                if (dis!=""&&dis!=null){
                    c.setCourse(df.format(Double.parseDouble(dis)));//里程ssssssssss
                }else{
                    c.setCourse("0.000");//里程
                }
                if (sitetype.equals("1")){
                    c.setEntrynetno("00000");//入口路网
                    c.setEntryplazano("00");//入口站
                }else{
                    boolean flag = true;
                    for (SiteInfo s : sl) {
                        if (s.getNetSiteNo().equals((c.getEntrynetno()+c.getEntryplazano()))){
                            c.setEntrynetno(s.getFullNetNo().substring(0,5));//入口路网
                            c.setEntryplazano(s.getFullNetNo().substring(5,7));//入口站
                            flag = false;
                        }
                    }
                    if (flag){
                        c.setEntrynetno("00000");
                        c.setEntryplazano("00");
                    }
                }
                c.setEntrytime(sdf.format(d.getEntrydate()));//入口时间
                c.setExitlane(d.getLaneno());//出口车道
                c.setExittime(sdf.format(d.getTransactiondate()));//出口时间
                c.setFreetype(d.getMopno().equals("17")?"2":d.getMopno().equals("49")?"3":d.getMopno().equals("18")?"4":d.getMopno().equals("34")?"9":d.getMopno().equals("35")?"A":d.getMopno().equals("23")?"B":"1");//免费车辆类型代码
                c.setIsetc("0");//是否ETC
                c.setIsgreed(d.getMopno().equals("34")?"1":"0");//是否绿通车
                c.setNetno(fnetno);//出口路网
                c.setPlazano(fsiteno);//出口站
                c.setObu("");//ETC电子标签OBU编号
                c.setWeightcount(d.getFareweight().toString());//车货总重
                c.setWeightlimit(d.getLimitweight());//限重
                c.setOverloadweightrate(String.valueOf(((Double.parseDouble(c.getWeightcount())-c.getWeightlimit().doubleValue())/c.getWeightlimit().doubleValue()*100>0?(Double.parseDouble(c.getWeightcount())-c.getWeightlimit().doubleValue())/c.getWeightlimit().doubleValue()*100:0)));//超限率
                c.setPaytype(d.getPrixpartial().equals("0.00")?"2":d.getCpucardtype().equals("00") ? "0" : d.getCpucardtype().equals("30") ? "3" : d.getCpucardtype().equals("31") ? "3" : "1");//支付方式
                c.setSendflag("0");//报送标志
                c.setSendtime(new Date());//报送时间
                c.setTokenstationlist("");//路径标识
                c.setTollfare(d.getPrixtotal());//应收
                c.setUploadtime(new Date());
                c.setHoursumid(fnetno+fsiteno+d.getLaneno()+c.getExittime().replaceAll("-","").replaceAll(" ","").substring(0,10));
                dataTransactionService.updateByMonth(month,c,list.size());
                //标记记录为已上传
                d.setUploadflag("1");
                dataTransactionMapper.updateRecord(d);
                //新增/更新小时汇总
                dataTransactionService.saveOrUpdateHourSum(c);
            }
        }while (list.size()==100);
        System.out.println("完成MTC数据传输！");
    }

    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(Double.parseDouble("0")));
    }
}
