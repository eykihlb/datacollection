package com.mydao.datacollection.dao.server;


import com.mydao.datacollection.entity.server.ConsumeWaste;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsumeWasteMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective01(ConsumeWaste record);
    int insertSelective02(ConsumeWaste record);
    int insertSelective03(ConsumeWaste record);
    int insertSelective04(ConsumeWaste record);
    int insertSelective05(ConsumeWaste record);
    int insertSelective06(ConsumeWaste record);
    int insertSelective07(ConsumeWaste record);
    int insertSelective08(ConsumeWaste record);
    int insertSelective09(ConsumeWaste record);
    int insertSelective10(ConsumeWaste record);
    int insertSelective11(ConsumeWaste record);
    int insertSelective12(ConsumeWaste record);

    int insertByBatch01(List<ConsumeWaste> list);
    int insertByBatch02(List<ConsumeWaste> list);
    int insertByBatch03(List<ConsumeWaste> list);
    int insertByBatch04(List<ConsumeWaste> list);
    int insertByBatch05(List<ConsumeWaste> list);
    int insertByBatch06(List<ConsumeWaste> list);
    int insertByBatch07(List<ConsumeWaste> list);
    int insertByBatch08(List<ConsumeWaste> list);
    int insertByBatch09(List<ConsumeWaste> list);
    int insertByBatch10(List<ConsumeWaste> list);
    int insertByBatch11(List<ConsumeWaste> list);
    int insertByBatch12(List<ConsumeWaste> list);

    ConsumeWaste selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumeWaste record);
}