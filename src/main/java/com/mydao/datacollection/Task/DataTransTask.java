package com.mydao.datacollection.Task;

import com.mydao.datacollection.dao.station.DataTransactionMapper;
import com.mydao.datacollection.dao.station.SiteInfoMapper;
import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.station.DataTransaction;
import com.mydao.datacollection.entity.station.SiteInfo;
import com.mydao.datacollection.service.DataTransactionService;
import com.mydao.datacollection.utils.DateUtil;
import com.mydao.datacollection.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DataTransTask {

    @Autowired
    private DataTransactionMapper dataTransactionMapper;

    @Autowired
    private DataTransactionService dataTransactionService;

    @Autowired
    private SiteInfoMapper siteInfoMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

    //@PostConstruct
    public void misDate() throws Exception{
        do {
            try {
                List<DataTransaction> l = dataTransactionMapper.selectMissDate();
                for (DataTransaction d : l) {
                    dataTransaction(s.parse(d.getMissdate()));
                }
                Thread.sleep(300000);
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("在哪里跌倒就从哪里爬起来。。。");
            }
        }while (true);
    }
    public void dataTransaction(Date date) throws Exception{
        List<SiteInfo> siteInfoList = siteInfoMapper.findList();
        Map<String,Object> mm = DateUtil.getDaysHours(date);
        List<DataTransaction> list;
        ConsumeWaste c;
        Map<String,Object> paramMap = new HashMap<>();
        for (SiteInfo siteInfo : siteInfoList) {//站
            paramMap.put("netSiteNo",siteInfo.getNetSiteNo());
            paramMap.put("beginDays",mm.get("start").toString());
            paramMap.put("endDays",mm.get("end").toString());
            do {
                list = dataTransactionMapper.selectByDays(paramMap);
                System.out.println(siteInfo.getNetSiteNo()+ "----------" +sdf.format(date)+"------"+list.size());
                for (DataTransaction d : list) {
                    int month = DateUtil.getMouth(sdf.parse(DateUtil.getBeforeDate(date,0).get("beginDays").toString()));
                    c = new ConsumeWaste();
                    c.setAxlecount((int)d.getFareaxles());//总轴数
                    c.setActualpay(d.getPrixpartial());//实收
                    c.setCarclass("01".equals(d.getClassno())?"0":"02".equals(d.getClassno())?"0":"03".equals(d.getClassno())?"0":"04".equals(d.getClassno())?"0":"05".equals(d.getClassno())?"1":"06".equals(d.getClassno())?"1":"07".equals(d.getClassno())?"1":"08".equals(d.getClassno())?"1":"09".equals(d.getClassno())?"1":"2");//车型
                    c.setCarplate(d.getParvehicleplate().equals("...")?"无结果":d.getParvehicleplate().equals("无车牌")?"无结果":d.getParvehicleplate().length()<7?"无结果":d.getParvehicleplate());//车牌号
                    c.setCartype(d.getClassno());//车种
                    c.setAxletype(c.getCarclass().equals("1") ? StringUtils.getStr(d.getAxletypeandweight()) : "");//轴型及轴重
                    c.setCourse(d.getDistance().toString());//里程
                    if (siteInfo.getSitetype().equals("1")){
                        c.setEntrynetno("00000");//入口路网
                        c.setEntryplazano("00");//入口站
                    }else{
                        for (SiteInfo s : siteInfoList) {
                            if((d.getEntrynetno()+d.getEntrysiteno()).equals(s.getNetSiteNo())){
                                c.setEntrynetno(s.getFullNetNo().substring(0,5));//入口路网
                                c.setEntryplazano(s.getFullNetNo().substring(5,7));//入口站
                            }else{
                                c.setEntrynetno("00000");//入口路网
                                c.setEntryplazano("00");//入口站
                            }
                        }
                    }
                    c.setEntrytime(sdf.format(d.getEntrydate()));//入口时间
                    c.setExitlane(d.getLaneno());//出口车道
                    c.setExittime(sdf.format(d.getTransactiondate()));//出口时间
                    c.setFreetype(d.getMopno().equals("17")?"2":d.getMopno().equals("49")?"3":d.getMopno().equals("18")?"4":d.getMopno().equals("34")?"9":d.getMopno().equals("35")?"A":d.getMopno().equals("23")?"B":"1");//免费车辆类型代码
                    c.setIsetc("0");//是否ETC
                    c.setIsgreed(d.getMopno().equals("34")?"1":"0");//是否绿通车
                    c.setNetno(siteInfo.getFullNetNo().substring(0,5));//出口路网
                    c.setPlazano(siteInfo.getFullNetNo().substring(5,7));//出口站
                    c.setObu("");//ETC电子标签OBU编号
                    c.setWeightcount(d.getFareweight().toString());//车货总重
                    c.setWeightlimit(d.getLimitweight());//限重
                    c.setOverloadweightrate(String.valueOf(((Double.parseDouble(c.getWeightcount())-c.getWeightlimit().doubleValue())/c.getWeightlimit().doubleValue()*100>0?(Double.parseDouble(c.getWeightcount())-c.getWeightlimit().doubleValue())/c.getWeightlimit().doubleValue()*100:0)));//超限率
                    c.setPaytype(d.getPrixpartial().equals("0.00")?"2":d.getCpucardtype().equals("00") ? "0" : "1");//支付方式
                    c.setSendflag("0");//报送标志
                    c.setSendtime(new Date());//报送时间
                    c.setTokenstationlist("");//路径标识
                    c.setTollfare(d.getPrixtotal());//应收
                    c.setUploadtime(new Date());
                    c.setHoursumid(siteInfo.getFullNetNo()+d.getLaneno()+c.getExittime().replaceAll("-","").replaceAll(" ","").substring(0,10));
                    dataTransactionService.updateByMonth(month,c,list.size());
                    //标记记录为已上传
                    d.setUploadflag("1");
                    dataTransactionMapper.updateRecord(d);
                    //新增/更新小时汇总
                    dataTransactionService.saveOrUpdateHourSum(c);
                }
            }while (list.size()==100);
        }
        System.out.println("完成数据传输！");
    }
}