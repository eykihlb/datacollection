package com.mydao.datacollection.dao.station;


import com.mydao.datacollection.entity.station.ParamNewJoureny;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ParamNewJourenyMapper {
    ParamNewJoureny selectDis(ParamNewJoureny p);
}