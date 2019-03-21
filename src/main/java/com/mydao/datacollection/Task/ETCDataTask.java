package com.mydao.datacollection.Task;

import com.mydao.datacollection.dao.server.ConsumeWasteMapper;
import com.mydao.datacollection.dao.server.HourSumMapper;
import com.mydao.datacollection.dao.station.SiteInfoMapper;
import com.mydao.datacollection.dao.station.TblExitWasteMapper;
import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.server.HourSum;
import com.mydao.datacollection.entity.station.TblExitWaste;
import com.mydao.datacollection.service.DataTransactionService;
import com.mydao.datacollection.utils.DateUtil;
import com.mydao.datacollection.utils.NetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ETCDataTask {

    @Autowired
    private ConsumeWasteMapper consumeWesteMapper;

    @Autowired
    private HourSumMapper hourSumMapper;

    @Autowired
    private DataTransactionService dataTransactionService;

    @Autowired
    private TblExitWasteMapper tblExitWasteMapper;

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

    @Async
    public void startTran() throws Exception{
        System.out.println("ETC");
        do {
            try {
                if (NetUtils.isReachable("10.65.1.11")){
                    dataTransaction();
                    Thread.sleep(300000);
                }else{
                    System.out.println("网络重连中。。。");
                    Thread.sleep(300000);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("报错了没关系，从头再来。。。。。。");
            }
        }while (true);
    }

    public void dataTransaction() throws Exception{
        List<TblExitWaste> list;
        ConsumeWaste c;
        DecimalFormat df = new DecimalFormat("#.000");
            do {
                list = tblExitWasteMapper.selectList();
                System.out.println(list.size());
                for (TblExitWaste d : list) {
                    int month = DateUtil.getMouth(d.getExittime());
                    c = new ConsumeWaste();
                    c.setAxlecount((int)d.getAxlenum());//总轴数
                    c.setActualpay(d.getBasemoney().subtract(d.getFreemoney()));//实收
                    c.setCarclass(d.getVclass()==1?"0":2==d.getVclass()?"0":3==d.getVclass()?"0":4==d.getVclass()?"0":11==d.getVclass()?"1":12==d.getVclass()?"1":13==d.getVclass()?"1":14==d.getVclass()?"1":15==d.getVclass()?"1":"2");//车型
                    if (d.getVlp()!=null){
                        c.setCarplate(d.getVlp().equals("...")?"无结果":d.getVlp().equals("无车牌")?"无结果":d.getVlp());//车牌号
                    }else{
                        c.setCarplate("无结果");
                    }
                    c.setCartype(d.getVclass().toString());//车种
                    c.setAxletype("");//轴型及轴重
                    c.setCourse(df.format(d.getTolldistance().doubleValue()/1000));//里程
                    if (c.getCourse().equals(".000")){
                        c.setCourse("0.000");
                    }
                    if (sitetype.equals("1")){
                        c.setEntrynetno("00000");//入口路网
                        c.setEntryplazano("00");//入口站
                    }else{
                        if (d.getEntrystation()<1000000){
                            c.setEntrynetno("00000");//入口路网
                            c.setEntryplazano("00");//入口站
                        }else {
                            if (d.getEntrystation().toString().length()<7){
                                c.setEntrynetno("00000");//入口路网
                                c.setEntryplazano("00");//入口站
                            }else{
                                c.setEntrynetno(d.getEntrystation().toString().substring(0,5));//入口路网
                                c.setEntryplazano(d.getEntrystation().toString().substring(5,7));//入口站
                            }
                        }
                    }
                    c.setEntrytime(sdf.format(d.getEntrytime()));//入口时间
                    c.setExitlane(d.getExitlaneid().toString());//出口车道
                    c.setExittime(sdf.format(d.getExittime()));//出口时间
                    c.setFreetype("1");//免费车辆类型代码
                    c.setIsetc("1");//是否ETC
                    c.setIsgreed("0");//是否绿通车
                    if (d.getExitstationid()<1000000){
                        c.setNetno("00000");//入口路网
                        c.setPlazano("00");//入口站
                    }else {
                        c.setNetno(fnetno);//出口路网
                        c.setPlazano(fsiteno);//出口站
                    }
                    c.setObu(d.getObuid().toString());//ETC电子标签OBU编号
                    c.setWeightcount(d.getTotalweight().toString());//车货总重
                    c.setWeightlimit(d.getLimitweight());//限重
                    c.setOverloadweightrate(d.getOverweightrate().toString());//超限率
                    c.setPaytype("0".equals(d.getPaytype())?"0":"22".equals(d.getPaytype())?"1":"23".equals(d.getPaytype())?"1":"2");//支付方式
                    c.setSendflag("0");//报送标志
                    c.setSendtime(new Date());//报送时间
                    c.setTokenstationlist("");//路径标识
                    c.setTollfare(d.getBasemoney());//应收
                    c.setUploadtime(new Date());
                    c.setHoursumid(fnetno+fsiteno+d.getExitlaneid()+c.getExittime().replaceAll("-","").replaceAll(" ","").substring(0,10));
                    dataTransactionService.updateByMonth(month,c,list.size());
                    //标记记录为已上传
                    d.setIsupload("8");
                    tblExitWasteMapper.updateByPrimaryKeySelective(d);
                    //新增/更新小时汇总
                    dataTransactionService.saveOrUpdateHourSum(c);
                }
            }while (list.size()==100);
        System.out.println("完成ETC数据传输！");
    }
}
