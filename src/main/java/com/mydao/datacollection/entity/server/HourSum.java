package com.mydao.datacollection.entity.server;

import java.util.Date;

public class HourSum {
    private String id;

    private String netno;

    private String plazano;

    private String sumhour;

    private String exitlane;

    private Integer totaltraffic;

    private String checkflag;

    private Date uploadtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNetno() {
        return netno;
    }

    public void setNetno(String netno) {
        this.netno = netno == null ? null : netno.trim();
    }

    public String getPlazano() {
        return plazano;
    }

    public void setPlazano(String plazano) {
        this.plazano = plazano == null ? null : plazano.trim();
    }

    public String getSumhour() {
        return sumhour;
    }

    public void setSumhour(String sumhour) {
        this.sumhour = sumhour == null ? null : sumhour.trim();
    }

    public String getExitlane() {
        return exitlane;
    }

    public void setExitlane(String exitlane) {
        this.exitlane = exitlane == null ? null : exitlane.trim();
    }

    public Integer getTotaltraffic() {
        return totaltraffic;
    }

    public void setTotaltraffic(Integer totaltraffic) {
        this.totaltraffic = totaltraffic;
    }

    public String getCheckflag() {
        return checkflag;
    }

    public void setCheckflag(String checkflag) {
        this.checkflag = checkflag == null ? null : checkflag.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
}