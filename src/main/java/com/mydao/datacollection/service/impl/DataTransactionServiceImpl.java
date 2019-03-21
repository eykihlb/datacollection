package com.mydao.datacollection.service.impl;

import com.mydao.datacollection.dao.server.ConsumeWasteMapper;
import com.mydao.datacollection.dao.server.HourSumMapper;
import com.mydao.datacollection.dao.station.DataTransactionMapper;
import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.server.HourSum;
import com.mydao.datacollection.entity.station.DataTransaction;
import com.mydao.datacollection.service.DataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DataTransactionServiceImpl implements DataTransactionService {

    @Autowired
    private DataTransactionMapper dataTransactionMapper;
    @Autowired
    private ConsumeWasteMapper consumeWasteMapper;
    @Autowired
    private HourSumMapper hourSumMapper;

    @Override
    public Integer saveOrUpdateHourSum(ConsumeWaste c) {
        HourSum hs = hourSumMapper.selectByPrimaryKey(c.getHoursumid());
        if (hs!=null){
            hs.setTotaltraffic(hs.getTotaltraffic()+1);
            return  hourSumMapper.updateByPrimaryKeySelective(hs);
        }else{
            hs = new HourSum();
            hs.setTotaltraffic(1);
            hs.setUploadtime(new Date());
            hs.setCheckflag("0");
            hs.setExitlane(c.getExitlane());
            hs.setPlazano(c.getPlazano());
            hs.setNetno(c.getNetno());
            hs.setSumhour(c.getExittime().substring(0,13));
            hs.setId(c.getHoursumid());
            try {
                return hourSumMapper.insertSelective(hs);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public List<DataTransaction> selectByDays(Map<String, Object> map) {
        return dataTransactionMapper.selectByDays(map);
    }

    @Override
    public List<DataTransaction> selectMissDate() {
        return dataTransactionMapper.selectMissDate();
    }

    @Override
    public Integer updateRecord(DataTransaction dataTransaction) {
        return dataTransactionMapper.updateRecord(dataTransaction);
    }

    @Override
    public Integer updateByMonth(int month, ConsumeWaste c,int listSize) throws Exception {
        int result = 0;
        int b = 0;
        do {
            try {
                switch (month){
                    case 1:
                        result = consumeWasteMapper.insertSelective01(c);
                        break;
                    case 2:
                        result = consumeWasteMapper.insertSelective02(c);
                        break;
                    case 3:
                        result = consumeWasteMapper.insertSelective03(c);
                        break;
                    case 4:
                        result = consumeWasteMapper.insertSelective04(c);
                        break;
                    case 5:
                        result = consumeWasteMapper.insertSelective05(c);
                        break;
                    case 6:
                        result = consumeWasteMapper.insertSelective06(c);
                        break;
                    case 7:
                        result = consumeWasteMapper.insertSelective07(c);
                        break;
                    case 8:
                        result = consumeWasteMapper.insertSelective08(c);
                        break;
                    case 9:
                        result = consumeWasteMapper.insertSelective09(c);
                        break;
                    case 10:
                        result = consumeWasteMapper.insertSelective10(c);
                        break;
                    case 11:
                        result = consumeWasteMapper.insertSelective11(c);
                        break;
                    case 12:
                        result = consumeWasteMapper.insertSelective12(c);
                        break;
                    default:
                        break;
                }
            }catch (Exception ee){
                b++;
                System.out.println("SQLSERVER连接失败，正在尝试重连。。。。。"+ee.getMessage());
                Thread.sleep(10000);
            }
        }while (result == 0 && listSize != 0 && b<=5);
        return null;
    }
}
