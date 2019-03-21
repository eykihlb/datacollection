package com.mydao.datacollection.dao.station;


import com.mydao.datacollection.entity.station.DataTransaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataTransactionMapper {
    List<DataTransaction> selectByHours(Map<String,Object> map);
    List<DataTransaction> selectByDays(Map<String,Object> map);
    List<DataTransaction> selectMissDate();
    Integer updateRecord(DataTransaction dataTransaction);
    Integer count(Map<String,Object> map);
    Integer updateBatch(List<DataTransaction> list);
    Integer updateUploadFlag(DataTransaction dataTransaction);
    DataTransaction selectPlate(Map<String,Object> map);
    int insertSelective(DataTransaction dataTransaction);
}