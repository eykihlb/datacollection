package com.mydao.datacollection.dao.server;


import com.mydao.datacollection.entity.server.HourSum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HourSumMapper {

    int deleteByPrimaryKey(String id);

    int insertSelective(HourSum record);

    HourSum selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HourSum record);

    Integer updateByHours(HourSum record);

    int insertBatch(List<HourSum> list);

    HourSum selectList(HourSum record);
}