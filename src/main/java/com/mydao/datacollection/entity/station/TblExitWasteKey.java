package com.mydao.datacollection.entity.station;

import java.util.Date;

public class TblExitWasteKey {
    private Date exittime;

    private Integer exitstationid;

    private Short exitlaneid;

    private Short exitwastesn;

    public Date getExittime() {
        return exittime;
    }

    public void setExittime(Date exittime) {
        this.exittime = exittime;
    }

    public Integer getExitstationid() {
        return exitstationid;
    }

    public void setExitstationid(Integer exitstationid) {
        this.exitstationid = exitstationid;
    }

    public Short getExitlaneid() {
        return exitlaneid;
    }

    public void setExitlaneid(Short exitlaneid) {
        this.exitlaneid = exitlaneid;
    }

    public Short getExitwastesn() {
        return exitwastesn;
    }

    public void setExitwastesn(Short exitwastesn) {
        this.exitwastesn = exitwastesn;
    }
}