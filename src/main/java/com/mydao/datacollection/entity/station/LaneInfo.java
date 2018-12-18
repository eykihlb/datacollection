package com.mydao.datacollection.entity.station;

public class LaneInfo {
    private String id;

    private String laneNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLaneNo() {
        return laneNo;
    }

    public void setLaneNo(String laneNo) {
        this.laneNo = laneNo == null ? null : laneNo.trim();
    }
}