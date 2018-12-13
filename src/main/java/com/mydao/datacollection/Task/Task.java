package com.mydao.datacollection.Task;

import com.mydao.datacollection.dao.station.ConstLaneMapper;
import com.mydao.datacollection.dao.server.ConsumeWasteMapper;
import com.mydao.datacollection.dao.station.DataTransactionMapper;
import com.mydao.datacollection.dao.server.HourSumMapper;
import com.mydao.datacollection.entity.station.ConstLane;
import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.station.DataTransaction;
import com.mydao.datacollection.entity.server.HourSum;
import com.mydao.datacollection.utils.DateUtil;
import com.mydao.datacollection.utils.NetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Task {

    @Autowired
    private ConsumeWasteMapper consumeWesteMapper;

    @Autowired
    private DataTransactionMapper dataTransactionMapper;

    @Autowired
    private ConstLaneMapper constLaneMapper;

    @Autowired
    private HourSumMapper hourSumMapper;

    @Value("${current.netno}")
    private String netNo;

    @Value("${current.siteno}")
    private String siteNO;

    @Value("${current.isopen}")
    private String isOpen;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(cron = "0 11 2/2 * * ?")
    public void chuanshu() throws Exception{
        System.out.println("网络状态检测中。。。。。");
        while (!NetUtils.isReachable("10.65.1.11")){
            System.out.println("网络连接失败，正在尝试重连。。。。。");
            Thread.sleep(30000);
        }
        //获取站出口车道
        List<ConstLane> constLaneList = constLaneMapper.selectExitLaneNo();
        System.out.println("已连接，数据传输开始！时间：" + sdf.format(new Date()));
        //正常数据处理
        days(new Date(),"1",constLaneList);
        //查询缺漏数据
        List<DataTransaction> list = dataTransactionMapper.selectMissDate();
        for (DataTransaction d : list) {
            System.out.println(d.getMissdate()+"日遗漏数据，开始补传。。。。。");
            //缺漏补传
            days(sdf.parse(d.getMissdate()+" 00:00:00"),"0",constLaneList);
        }
        System.out.println("数据传输完成！时间：" + sdf.format(new Date()));
    }
    private void days(Date date,String flag,List<ConstLane> constLaneList) throws Exception{
        //小时汇总明细
        List<DataTransaction> hourList = null;
        //Map 临时存储小时汇总ID和时间
        List<Map<String,Object>> tempList = new ArrayList<>();
        Map<String,Object> tempMap = null;
        List<Map<String,Object>> dmap = new ArrayList<>();
        if (flag.equals("1")){
            System.out.println("小时数据汇总中。。。");
            dmap = DateUtil.getHours(sdf.parse(DateUtil.getBeforeDate(date,1).get("endDays").toString()));
        }else{
            System.out.println("小时数据补传中。。。");
            dmap = DateUtil.getHours(sdf.parse(s.format(date)+" 23:00:00"));
        }
        int a = 0;
        List<HourSum> hlist = null;
        for (Map<String,Object> map : dmap) {
            hlist = new ArrayList<>();
            for (ConstLane c : constLaneList) {
                map.put("laneNo",c.getLaneno());
                HourSum h = new HourSum();
                //查询单车道小时交易数据
                hourList = dataTransactionMapper.selectByHours(map);
                a+=hourList.size();
                h.setTotaltraffic(hourList.size());
                h.setUploadtime(new Date());
                h.setCheckflag("0");
                h.setSumhour(map.get("beginHours").toString());
                h.setId(UUID.randomUUID().toString().replaceAll("-",""));
                h.setExitlane(c.getLaneno());
                h.setPlazano(siteNO);
                h.setNetno(netNo);
                hlist.add(h);
                //缺漏数据处理
                if (!"0".equals(flag)){
                    hourSumMapper.updateByHours(h);
                }
            }
            //正常数据处理
            if ("1".equals(flag)) {
                int d = 0;
                do {
                    try {
                        d = hourSumMapper.insertBatch(hlist);
                    }catch (Exception e){
                        System.out.println("SQLSERVER连接失败，正在尝试重连。。。。。");
                        Thread.sleep(30000);
                    }
                }while (d == 0);
                if (d>0){
                    for (HourSum hs : hlist) {
                        tempMap = new HashMap<>();
                        tempMap.put("id",hs.getId());
                        tempMap.put("laneno",hs.getExitlane());
                        tempMap.put("beginHours",map.get("beginHours"));
                        tempMap.put("endHours",map.get("endHours"));
                        //临时数据，用以关联月汇总数据
                        tempList.add(tempMap);
                    }
                }
            }
        }
        System.out.println("Done! 记录数："+ a);
        ConsumeWaste c = new ConsumeWaste();
        //每日数据详细列表
        List<DataTransaction> dataTransactionsList = null;
        if (flag.equals("1")){
            System.out.println("月汇总数据传输。。。");
            dataTransactionsList = dataTransactionMapper.selectByDays(DateUtil.getBeforeDate(date,1));
        }else{
            System.out.println("月汇总数据补传。。。");
            dataTransactionsList = dataTransactionMapper.selectByDays(DateUtil.getBeforeDate(date,0));
        }
        int m = 0;
        if (flag.equals("1")){
            m = DateUtil.getMouth(sdf.parse(DateUtil.getBeforeDate(date,1).get("beginDays").toString()));
        }else{
            m = DateUtil.getMouth(sdf.parse(DateUtil.getBeforeDate(date,0).get("beginDays").toString()));
        }
        for (DataTransaction d : dataTransactionsList) {
            c.setAxlecount((int)d.getFareaxles());//总轴数
            c.setActualpay(d.getPrixpartial());//实收
            c.setCarclass("01".equals(d.getClassno())?"0":"02".equals(d.getClassno())?"0":"03".equals(d.getClassno())?"0":"04".equals(d.getClassno())?"0":"05".equals(d.getClassno())?"1":"06".equals(d.getClassno())?"1":"07".equals(d.getClassno())?"1":"08".equals(d.getClassno())?"1":"09".equals(d.getClassno())?"1":"2");//车型
            c.setCarplate(d.getParvehicleplate());//车牌号
            c.setCartype(d.getMopno());//车种
            c.setAxletype(c.getCarclass().equals("1") ? getStr(d.getAxletypeandweight()) : "");//轴型及轴重
            c.setCourse(d.getDistance().toString());//里程
            if (isOpen.equals("1")){
                c.setEntrynetno("00000");//入口路网
                c.setEntryplazano("00");//入口站
            }else{
                c.setEntrynetno(d.getEntrynetno());//入口路网
                c.setEntryplazano(d.getEntrysiteno());//入口站
            }
            c.setEntrytime(sdf.format(d.getEntrydate()));//入口时间
            c.setExitlane(d.getLaneno());//出口车道
            c.setExittime(sdf.format(d.getTransactiondate()));//出口时间
            c.setFreetype(d.getMopno().equals("17")?"2":d.getMopno().equals("49")?"3":d.getMopno().equals("18")?"4":d.getMopno().equals("34")?"9":d.getMopno().equals("35")?"A":d.getMopno().equals("23")?"B":"1");//免费车辆类型代码
            for (Map<String,Object> map : tempList) {
                if (d.getTransactiondate().compareTo(sdf.parse(map.get("beginHours").toString()))>=0 && d.getTransactiondate().compareTo(sdf.parse(map.get("endHours").toString())) <= 0 && d.getLaneno().equals(map.get("laneno").toString())){
                    c.setHoursumid(map.get("id").toString());//小时汇总ID
                }
            }
            c.setIsetc("0");//是否ETC
            c.setIsgreed(d.getMopno().equals("34")?"1":"0");//是否绿通车
            c.setNetno(d.getNetno());//出口路网
            c.setPlazano(d.getSiteno());//出口站
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
            //获取数据对应月份
            int result = 0;
            do {
                try {
                    //数据传入相对应月份的表中
                    switch (m){
                        case 1:
                            result = consumeWesteMapper.insertSelective01(c);
                            break;
                        case 2:
                            result = consumeWesteMapper.insertSelective02(c);
                            break;
                        case 3:
                            result = consumeWesteMapper.insertSelective03(c);
                            break;
                        case 4:
                            result = consumeWesteMapper.insertSelective04(c);
                            break;
                        case 5:
                            result = consumeWesteMapper.insertSelective05(c);
                            break;
                        case 6:
                            result = consumeWesteMapper.insertSelective06(c);
                            break;
                        case 7:
                            result = consumeWesteMapper.insertSelective07(c);
                            break;
                        case 8:
                            result = consumeWesteMapper.insertSelective08(c);
                            break;
                        case 9:
                            result = consumeWesteMapper.insertSelective09(c);
                            break;
                        case 10:
                            result = consumeWesteMapper.insertSelective10(c);
                            break;
                        case 11:
                            result = consumeWesteMapper.insertSelective11(c);
                            break;
                        case 12:
                            result = consumeWesteMapper.insertSelective12(c);
                            break;
                        default:
                            break;
                    }
                }catch (Exception ee){
                    System.out.println("SQLSERVER连接失败，正在尝试重连。。。。。");
                    Thread.sleep(30000);
                }
            }while (result == 0 && dataTransactionsList.size() != 0);
        }

        System.out.println("Done! 记录数："+ dataTransactionsList.size());
        System.out.println("开始更新交易记录。。。。。");
        int b = 0;
        do {
            try {
                for (DataTransaction d : dataTransactionsList) {
                    b += dataTransactionMapper.updateRecord(d);
                }
            }catch (Exception ee){
                System.out.println("ORACLE连接失败，正在尝试重连。。。。。");
                Thread.sleep(30000);
            }
        }while (b == 0 && dataTransactionsList.size() != 0);
        System.out.println("Done！记录数："+b);
    }

    private String getStr(String str){
        if (str == "" || str == null){
            return  "";
        }
        String result = "";
        int len = str.trim().length();
        for (int i = 0 ; i < len/7 ; i++){
            result += str.substring(i*6,i*6+7).substring(0,1) == "0" ? "1": str.substring(i*6,i*6+7).substring(0,1) +"|"+str.substring(i*6,i*6+7).substring(1,7)+"+";
        }
        return result.substring(0,result.length()-1);
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void timeTask(){
        System.out.println(sdf.format(new Date()));
    }

}
