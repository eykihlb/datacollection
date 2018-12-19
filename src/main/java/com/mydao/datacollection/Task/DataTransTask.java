package com.mydao.datacollection.Task;

import com.mydao.datacollection.dao.server.ConsumeWasteMapper;
import com.mydao.datacollection.dao.server.HourSumMapper;
import com.mydao.datacollection.dao.station.ConstLaneMapper;
import com.mydao.datacollection.dao.station.DataTransactionMapper;
import com.mydao.datacollection.dao.station.LaneInfoMapper;
import com.mydao.datacollection.dao.station.SiteInfoMapper;
import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.server.HourSum;
import com.mydao.datacollection.entity.station.DataTransaction;
import com.mydao.datacollection.entity.station.LaneInfo;
import com.mydao.datacollection.entity.station.SiteInfo;
import com.mydao.datacollection.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DataTransTask {

    @Autowired
    private ConsumeWasteMapper consumeWesteMapper;

    @Autowired
    private DataTransactionMapper dataTransactionMapper;

    @Autowired
    private ConstLaneMapper constLaneMapper;

    @Autowired
    private LaneInfoMapper laneInfoMapper;

    @Autowired
    private SiteInfoMapper siteInfoMapper;

    @Autowired
    private HourSumMapper hourSumMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH");

    @Scheduled(cron = "0 0 11 * * ?")
    public void startTask() throws Exception{
        List<DataTransaction> missList = dataTransactionMapper.selectMissDate();
        for (DataTransaction dataTransaction:missList) {
            System.out.println("数据传输中。。。" + sdf.format(new Date()));
            dataTransaction(s.parse(dataTransaction.getMissdate()));
        }
    }
    public void dataTransaction(Date date) throws Exception{
        List<Map<String,Object>> dmap = DateUtil.getHours(sdf.parse(DateUtil.getBeforeDate(date,0).get("endDays").toString()));
        List<SiteInfo> siteInfoList = siteInfoMapper.findList();
        List<LaneInfo> laneInfoList = laneInfoMapper.findList();
        List<DataTransaction> list = new ArrayList<>();
        HourSum hs = new HourSum();
        ConsumeWaste c = new ConsumeWaste();
        int records = 0;
        Map<String,Object> paramMap = new HashMap<>();
        for (Map<String,Object> map : dmap) {//小时
            for (SiteInfo siteInfo : siteInfoList) {//站
                for (LaneInfo laneInfo : laneInfoList) {//车道
                    paramMap.put("netSiteNo",siteInfo.getNetSiteNo());
                    paramMap.put("beginDays",map.get("beginHours").toString());
                    paramMap.put("endDays",map.get("endHours").toString());
                    paramMap.put("laneNo",laneInfo.getLaneNo());
                    //查询站/车道/小时交易数据
                    do {
                        list = dataTransactionMapper.selectByDays(paramMap);
                        for (DataTransaction d : list) {
                            //处理中
                            d.setUploadflag("2");
                            int f = 0;
                            do {
                                try {
                                    dataTransactionMapper.updateUploadFlag(d);
                                    f = 1;
                                }catch (Exception e){
                                    System.out.println("处理状态更新失败！");
                                    f = 0;
                                }
                            }while (f==0);
                        }

                        //插入小时汇总
                        hs.setNetno(siteInfo.getFullNetNo().substring(0,5));
                        hs.setPlazano(siteInfo.getNetSiteNo().substring(5,7));
                        hs.setExitlane(laneInfo.getLaneNo());
                        hs.setSumhour(ss.format(ss.parse(map.get("beginHours").toString())));
                        hs.setCheckflag("0");
                        hs.setUploadtime(new Date());
                        hs.setTotaltraffic(0);
                        hs.setId(UUID.randomUUID().toString().replaceAll("_",""));
                        HourSum hh = hourSumMapper.selectList(hs);
                        if (hh==null){
                            int g = 0;
                            do {
                                try {
                                    hourSumMapper.insertSelective(hs);
                                    g = 1;
                                }catch (Exception e){
                                    System.out.println("小时记录插入失败！");
                                    g = 0;
                                }
                            }while (g==0);
                        }else{
                            hs = hh;
                        }
                        for (DataTransaction d : list) {
                            int m = DateUtil.getMouth(sdf.parse(DateUtil.getBeforeDate(date,0).get("beginDays").toString()));
                            c = new ConsumeWaste();
                            c.setAxlecount((int)d.getFareaxles());//总轴数
                            c.setActualpay(d.getPrixpartial());//实收
                            c.setCarclass("01".equals(d.getClassno())?"0":"02".equals(d.getClassno())?"0":"03".equals(d.getClassno())?"0":"04".equals(d.getClassno())?"0":"05".equals(d.getClassno())?"1":"06".equals(d.getClassno())?"1":"07".equals(d.getClassno())?"1":"08".equals(d.getClassno())?"1":"09".equals(d.getClassno())?"1":"2");//车型
                            c.setCarplate(d.getParvehicleplate().equals("...")?"无结果":d.getParvehicleplate().equals("无车牌")?"无结果":d.getParvehicleplate().length()<7?"无结果":d.getParvehicleplate());//车牌号
                            c.setCartype(d.getMopno());//车种
                            c.setAxletype(c.getCarclass().equals("1") ? getStr(d.getAxletypeandweight()) : "");//轴型及轴重
                            c.setCourse(d.getDistance().toString());//里程
                            if (siteInfo.getSitetype().equals("1")){
                                c.setEntrynetno("00000");//入口路网
                                c.setEntryplazano("00");//入口站
                            }else{
                                c.setEntrynetno(siteInfo.getFullNetNo().substring(0,5));//入口路网
                                c.setEntryplazano(siteInfo.getFullNetNo().substring(5,7));//入口站
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

                            int result = 0;
                            int b = 0;
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
                                    b++;
                                    System.out.println("SQLSERVER连接失败，正在尝试重连。。。。。"+b);
                                    Thread.sleep(10000);
                                }
                            }while (result == 0 && list.size() != 0 && b<=5);

                            //上传成功/失败之后更新交易数据状态
                            if (result == 0){
                                d.setUploadflag("9");//失败
                            }else{
                                d.setUploadflag("1");//成功
                                records = hs.getTotaltraffic() + 1;
                                //更新小时汇总车流量
                                int  v = 0;
                                do {
                                    try {
                                        hs.setTotaltraffic(records);
                                        hourSumMapper.updateByPrimaryKeySelective(hs);
                                        v = 1;
                                    }catch (Exception e){
                                        System.out.println("更新小时汇总记录数失败！");
                                        v = 0;
                                    }
                                }while (v==0);
                            }

                            int h = 0;
                            do {
                                try {
                                    dataTransactionMapper.updateRecord(d);
                                    h = 1;
                                }catch (Exception e){
                                    System.out.println("更新交易处理状态失败！");
                                    h = 0;
                                }
                            }while (h == 0);

                            //更新外键ID
                            int x = 0;
                            do {
                                try {
                                    c.setHoursumid(hs.getId());
                                    consumeWesteMapper.updateByPrimaryKeySelective(c);
                                    x = 1;
                                }catch (Exception e){
                                    System.out.println("更新外键失败！");
                                    x = 0;
                                }
                            }while (x==0);
                        }
                    }while (list.size()==100);
                }
            }
        }
        System.out.println("完成数据传输！");
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
}
