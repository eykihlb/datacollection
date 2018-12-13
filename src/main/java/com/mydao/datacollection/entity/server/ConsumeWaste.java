package com.mydao.datacollection.entity.server;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumeWaste {
    private Integer id;

    private String entrynetno;

    private String entryplazano;

    private String entrytime;

    private String netno;

    private String plazano;

    private String exittime;

    private String exitlane;

    private String carplate;

    private String cartype;

    private String carclass;

    private String course;

    private Integer axlecount;

    private String axletype;

    private String weightcount;

    private Integer weightlimit;

    private String overloadweightrate;

    private String isgreed;

    private String freetype;

    private String tokenstationlist;

    private String isetc;

    private String obu;

    private String paytype;

    private BigDecimal tollfare;

    private BigDecimal actualpay;

    private Date uploadtime;

    private Date sendtime;

    private String sendflag;

    private String hoursumid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntrynetno() {
        return entrynetno;
    }

    public void setEntrynetno(String entrynetno) {
        this.entrynetno = entrynetno == null ? null : entrynetno.trim();
    }

    public String getEntryplazano() {
        return entryplazano;
    }

    public void setEntryplazano(String entryplazano) {
        this.entryplazano = entryplazano == null ? null : entryplazano.trim();
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime == null ? null : entrytime.trim();
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

    public String getExittime() {
        return exittime;
    }

    public void setExittime(String exittime) {
        this.exittime = exittime == null ? null : exittime.trim();
    }

    public String getExitlane() {
        return exitlane;
    }

    public void setExitlane(String exitlane) {
        this.exitlane = exitlane == null ? null : exitlane.trim();
    }

    public String getCarplate() {
        return carplate;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate == null ? null : carplate.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getCarclass() {
        return carclass;
    }

    public void setCarclass(String carclass) {
        this.carclass = carclass == null ? null : carclass.trim();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course == null ? null : course.trim();
    }

    public Integer getAxlecount() {
        return axlecount;
    }

    public void setAxlecount(Integer axlecount) {
        this.axlecount = axlecount;
    }

    public String getAxletype() {
        return axletype;
    }

    public void setAxletype(String axletype) {
        this.axletype = axletype == null ? null : axletype.trim();
    }

    public String getWeightcount() {
        return weightcount;
    }

    public void setWeightcount(String weightcount) {
        this.weightcount = weightcount == null ? null : weightcount.trim();
    }

    public Integer getWeightlimit() {
        return weightlimit;
    }

    public void setWeightlimit(Integer weightlimit) {
        this.weightlimit = weightlimit;
    }

    public String getOverloadweightrate() {
        return overloadweightrate;
    }

    public void setOverloadweightrate(String overloadweightrate) {
        this.overloadweightrate = overloadweightrate == null ? null : overloadweightrate.trim();
    }

    public String getIsgreed() {
        return isgreed;
    }

    public void setIsgreed(String isgreed) {
        this.isgreed = isgreed == null ? null : isgreed.trim();
    }

    public String getFreetype() {
        return freetype;
    }

    public void setFreetype(String freetype) {
        this.freetype = freetype == null ? null : freetype.trim();
    }

    public String getTokenstationlist() {
        return tokenstationlist;
    }

    public void setTokenstationlist(String tokenstationlist) {
        this.tokenstationlist = tokenstationlist == null ? null : tokenstationlist.trim();
    }

    public String getIsetc() {
        return isetc;
    }

    public void setIsetc(String isetc) {
        this.isetc = isetc == null ? null : isetc.trim();
    }

    public String getObu() {
        return obu;
    }

    public void setObu(String obu) {
        this.obu = obu == null ? null : obu.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public BigDecimal getTollfare() {
        return tollfare;
    }

    public void setTollfare(BigDecimal tollfare) {
        this.tollfare = tollfare;
    }

    public BigDecimal getActualpay() {
        return actualpay;
    }

    public void setActualpay(BigDecimal actualpay) {
        this.actualpay = actualpay;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendflag() {
        return sendflag;
    }

    public void setSendflag(String sendflag) {
        this.sendflag = sendflag == null ? null : sendflag.trim();
    }

    public String getHoursumid() {
        return hoursumid;
    }

    public void setHoursumid(String hoursumid) {
        this.hoursumid = hoursumid == null ? null : hoursumid.trim();
    }
}