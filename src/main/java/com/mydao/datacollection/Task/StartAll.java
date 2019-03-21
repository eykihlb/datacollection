package com.mydao.datacollection.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartAll {

    @Autowired
    private ETCDataTask eTCDataTask;
    @Autowired
    private MTCDataForSiteTask mtcDataForSiteTask;
    @Autowired
    private ChangeSiteNoTask changeSiteNoTask;

    @PostConstruct
    public void startAll() throws Exception{

        eTCDataTask.startTran();

        mtcDataForSiteTask.misDate();

        //changeSiteNoTask.changeSiteNo();
    }
}
