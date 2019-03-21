package com.mydao.datacollection.entity.station;

public class ParamNewJoureny {
    private String id;

    private String enstationid;

    private String exstationid;

    private String distance;

    private String mintime;

    private String maxtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEnstationid() {
        return enstationid;
    }

    public void setEnstationid(String enstationid) {
        this.enstationid = enstationid == null ? null : enstationid.trim();
    }

    public String getExstationid() {
        return exstationid;
    }

    public void setExstationid(String exstationid) {
        this.exstationid = exstationid == null ? null : exstationid.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getMintime() {
        return mintime;
    }

    public void setMintime(String mintime) {
        this.mintime = mintime == null ? null : mintime.trim();
    }

    public String getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(String maxtime) {
        this.maxtime = maxtime == null ? null : maxtime.trim();
    }
}