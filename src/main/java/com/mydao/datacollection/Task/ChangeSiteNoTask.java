package com.mydao.datacollection.Task;

import com.mydao.datacollection.dao.server.ConsumeWasteMapper;
import com.mydao.datacollection.dao.station.SiteInfoMapper;
import com.mydao.datacollection.entity.server.ConsumeWaste;
import com.mydao.datacollection.entity.station.SiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChangeSiteNoTask {

    @Autowired
    private SiteInfoMapper siteInfoMapper;
    @Autowired
    private ConsumeWasteMapper consumeWasteMapper;

    @Value(value="${sitecfg.month}")
    private Integer m;

    @Async
    public void changeSiteNo(){

        do {
            try {
                List<ConsumeWaste> cl = new ArrayList<>();
                switch (m){
                    case 1:
                        cl = consumeWasteMapper.findList01();
                        break;
                    case 2:
                        System.out.println("--------------");
                        consumeWasteMapper.updatecarclass0();
                        consumeWasteMapper.updatecarclass1();
                        consumeWasteMapper.updatecourse();
                        break;
                    case 3:
                        cl = consumeWasteMapper.findList03();
                        break;
                    case 4:
                        cl = consumeWasteMapper.findList04();
                        break;
                    case 5:
                        cl = consumeWasteMapper.findList05();
                        break;
                    case 6:
                        cl = consumeWasteMapper.findList06();
                        break;
                    case 7:
                        cl = consumeWasteMapper.findList07();
                        break;
                    case 8:
                        cl = consumeWasteMapper.findList08();
                        break;
                    case 9:
                        cl = consumeWasteMapper.findList09();
                        break;
                    case 10:
                        cl = consumeWasteMapper.findList10();
                        break;
                    case 11:
                        cl = consumeWasteMapper.findList11();
                        break;
                    case 12:
                        cl = consumeWasteMapper.findList12();
                        break;
                    default:
                        break;
                }
                Thread.sleep(10000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
}
