package com.mydao.datacollection.dao.station;


import com.mydao.datacollection.entity.station.SiteInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SiteInfoMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(SiteInfo record);

    SiteInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SiteInfo record);
    List<SiteInfo> findList();
}