package com.mydao.datacollection.dao.server;


import com.mydao.datacollection.entity.server.ConsumeWaste;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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
    List<ConsumeWaste> selectRecords();

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

    List<ConsumeWaste> seletList();
    List<ConsumeWaste> selectPlate();
    ConsumeWaste selectById(Long id);
    List<ConsumeWaste> groupByID();

    int updateByPrimaryKeySelective(ConsumeWaste record);

    List<ConsumeWaste> findList01();
    List<ConsumeWaste> findList02();
    List<ConsumeWaste> findList03();
    List<ConsumeWaste> findList04();
    List<ConsumeWaste> findList05();
    List<ConsumeWaste> findList06();
    List<ConsumeWaste> findList07();
    List<ConsumeWaste> findList08();
    List<ConsumeWaste> findList09();
    List<ConsumeWaste> findList10();
    List<ConsumeWaste> findList11();
    List<ConsumeWaste> findList12();
    List<ConsumeWaste> findcourse02();
    List<ConsumeWaste> adasdasd();

    Integer updatecarclass0();
    Integer updatecarclass1();
    Integer updatecourse();
    Integer updateFreetype();
}