package com.mydao.datacollection.dao.station;

import com.mydao.datacollection.entity.station.ConstLane;
import com.mydao.datacollection.entity.station.ConstLaneKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConstLaneMapper {
    int deleteByPrimaryKey(ConstLaneKey key);

    int insertSelective(ConstLane record);

    ConstLane selectByPrimaryKey(ConstLaneKey key);

    int updateByPrimaryKeySelective(ConstLane record);

    List<ConstLane> selectExitLaneNo();
}