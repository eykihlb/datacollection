package com.mydao.datacollection.service;

import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.station.DataTransaction;

import java.util.List;
import java.util.Map;

public interface DataTransactionService {
    List<DataTransaction> selectByDays(Map<String,Object> map);
    List<DataTransaction> selectMissDate();
    Integer updateRecord(DataTransaction dataTransaction);

    Integer updateByMonth(int month,ConsumeWaste c,int listSize) throws Exception ;

    Integer saveOrUpdateHourSum(ConsumeWaste c);
}
