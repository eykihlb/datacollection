package com.mydao.datacollection.dao.station;

import com.mydao.datacollection.entity.station.TblExitWaste;
import com.mydao.datacollection.entity.station.TblExitWasteKey;

import java.util.List;

public interface TblExitWasteMapper {


    TblExitWaste selectByPrimaryKey(TblExitWasteKey key);

    int updateByPrimaryKeySelective(TblExitWaste record);

    List<TblExitWaste> selectList();

    List<String> selectMissDate();
}