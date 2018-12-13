package com.mydao.datacollection.entity.station;

import java.math.BigDecimal;

public class ConstLane extends ConstLaneKey {
    private String lanetype;

    private String cflag;

    private String ipaddress;

    private BigDecimal lanefx;

    private String lanefxDesc;

    public String getLanetype() {
        return lanetype;
    }

    public void setLanetype(String lanetype) {
        this.lanetype = lanetype == null ? null : lanetype.trim();
    }

    public String getCflag() {
        return cflag;
    }

    public void setCflag(String cflag) {
        this.cflag = cflag == null ? null : cflag.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public BigDecimal getLanefx() {
        return lanefx;
    }

    public void setLanefx(BigDecimal lanefx) {
        this.lanefx = lanefx;
    }

    public String getLanefxDesc() {
        return lanefxDesc;
    }

    public void setLanefxDesc(String lanefxDesc) {
        this.lanefxDesc = lanefxDesc == null ? null : lanefxDesc.trim();
    }
}