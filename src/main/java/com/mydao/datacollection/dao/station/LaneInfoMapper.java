package com.mydao.datacollection.dao.station;


import com.mydao.datacollection.entity.station.LaneInfo;

import java.util.List;

public interface LaneInfoMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(LaneInfo record);

    LaneInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LaneInfo record);

    List<LaneInfo> findList();
}