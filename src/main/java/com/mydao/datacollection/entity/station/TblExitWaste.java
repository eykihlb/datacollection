package com.mydao.datacollection.entity.station;

import java.math.BigDecimal;
import java.util.Date;

public class TblExitWaste extends TblExitWasteKey {
    private Short lanetype;

    private Long laneappver;

    private Date logintime;

    private Date triggertime;

    private Date workdate;

    private Short shiftid;

    private Integer operatorid;

    private Short groupid;

    private Long cardsn;

    private Long cardcounter;

    private Long cardid;

    private Integer cardboxid;

    private Long paycardid;

    private Long obuid;

    private BigDecimal paycardtransn;

    private BigDecimal paycardbalance;

    private BigDecimal tac;

    private Short paycardrebate;

    private Long psamid;

    private BigDecimal psamtradesn;

    private Short vtype;

    private Short pvclass;

    private Short bvclass;

    private Short vclass;

    private Short autovclass;

    private String autovlp;

    private String vlp;

    private Short axlenum;

    private Long autoaxistype;

    private Long axistype;

    private String autoaxisinfo;

    private String axisinfo;

    private Integer totalweight;

    private Integer limitweight;

    private Integer overweightrate;

    private Short paytype;

    private String dealstatus;

    private String devstatus;

    private Short vcnt;

    private String keypressinfo;

    private Integer assueentry;

    private Integer entrystation;

    private Short entrylane;

    private Date entrytime;

    private Short entrywastesn;

    private Integer entryoperatorid;

    private Short entryvclass;

    private Short entryvtype;

    private Long entryaxistype;

    private String entryvlp;

    private Long entrypsamid;

    private Long overtime;

    private Long tolldistance;

    private Long realdistance;

    private BigDecimal baseentrymoney;

    private BigDecimal basemoney;

    private BigDecimal overweightmoney;

    private BigDecimal freemoney;

    private BigDecimal unpaymoney;

    private BigDecimal cashmoney;

    private BigDecimal storemoney;

    private BigDecimal tallymoney;

    private BigDecimal unipaymoney;

    private BigDecimal cardcostmoney;

    private BigDecimal storebalancemoney;

    private Long invoiceid;

    private Short invoicecnt;

    private Long tollver;

    private Long tollratever;

    private String flagstationinfo;

    private Short freetype;

    private String freearea;

    private Short splitnum;

    private String splitinfo;

    private Long verifycode;

    private Short modifyflag;

    private Long spare1;

    private Long spare2;

    private Long spare3;

    private String spare4;

    private Short transflag;

    private String issuerid;

    private String cardnetid;

    private String cardid2;

    private String paycardid2;

    private String terminalid;

    private Short keyversion;

    private Date uploadtime;

    private String obuid2;

    private Short transtype;

    private String isupload;

    private String imagepath;

    private String laneno;

    private String imagepath2;

    public Short getLanetype() {
        return lanetype;
    }

    public void setLanetype(Short lanetype) {
        this.lanetype = lanetype;
    }

    public Long getLaneappver() {
        return laneappver;
    }

    public void setLaneappver(Long laneappver) {
        this.laneappver = laneappver;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getTriggertime() {
        return triggertime;
    }

    public void setTriggertime(Date triggertime) {
        this.triggertime = triggertime;
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public Short getShiftid() {
        return shiftid;
    }

    public void setShiftid(Short shiftid) {
        this.shiftid = shiftid;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public Short getGroupid() {
        return groupid;
    }

    public void setGroupid(Short groupid) {
        this.groupid = groupid;
    }

    public Long getCardsn() {
        return cardsn;
    }

    public void setCardsn(Long cardsn) {
        this.cardsn = cardsn;
    }

    public Long getCardcounter() {
        return cardcounter;
    }

    public void setCardcounter(Long cardcounter) {
        this.cardcounter = cardcounter;
    }

    public Long getCardid() {
        return cardid;
    }

    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }

    public Integer getCardboxid() {
        return cardboxid;
    }

    public void setCardboxid(Integer cardboxid) {
        this.cardboxid = cardboxid;
    }

    public Long getPaycardid() {
        return paycardid;
    }

    public void setPaycardid(Long paycardid) {
        this.paycardid = paycardid;
    }

    public Long getObuid() {
        return obuid;
    }

    public void setObuid(Long obuid) {
        this.obuid = obuid;
    }

    public BigDecimal getPaycardtransn() {
        return paycardtransn;
    }

    public void setPaycardtransn(BigDecimal paycardtransn) {
        this.paycardtransn = paycardtransn;
    }

    public BigDecimal getPaycardbalance() {
        return paycardbalance;
    }

    public void setPaycardbalance(BigDecimal paycardbalance) {
        this.paycardbalance = paycardbalance;
    }

    public BigDecimal getTac() {
        return tac;
    }

    public void setTac(BigDecimal tac) {
        this.tac = tac;
    }

    public Short getPaycardrebate() {
        return paycardrebate;
    }

    public void setPaycardrebate(Short paycardrebate) {
        this.paycardrebate = paycardrebate;
    }

    public Long getPsamid() {
        return psamid;
    }

    public void setPsamid(Long psamid) {
        this.psamid = psamid;
    }

    public BigDecimal getPsamtradesn() {
        return psamtradesn;
    }

    public void setPsamtradesn(BigDecimal psamtradesn) {
        this.psamtradesn = psamtradesn;
    }

    public Short getVtype() {
        return vtype;
    }

    public void setVtype(Short vtype) {
        this.vtype = vtype;
    }

    public Short getPvclass() {
        return pvclass;
    }

    public void setPvclass(Short pvclass) {
        this.pvclass = pvclass;
    }

    public Short getBvclass() {
        return bvclass;
    }

    public void setBvclass(Short bvclass) {
        this.bvclass = bvclass;
    }

    public Short getVclass() {
        return vclass;
    }

    public void setVclass(Short vclass) {
        this.vclass = vclass;
    }

    public Short getAutovclass() {
        return autovclass;
    }

    public void setAutovclass(Short autovclass) {
        this.autovclass = autovclass;
    }

    public String getAutovlp() {
        return autovlp;
    }

    public void setAutovlp(String autovlp) {
        this.autovlp = autovlp == null ? null : autovlp.trim();
    }

    public String getVlp() {
        return vlp;
    }

    public void setVlp(String vlp) {
        this.vlp = vlp == null ? null : vlp.trim();
    }

    public Short getAxlenum() {
        return axlenum;
    }

    public void setAxlenum(Short axlenum) {
        this.axlenum = axlenum;
    }

    public Long getAutoaxistype() {
        return autoaxistype;
    }

    public void setAutoaxistype(Long autoaxistype) {
        this.autoaxistype = autoaxistype;
    }

    public Long getAxistype() {
        return axistype;
    }

    public void setAxistype(Long axistype) {
        this.axistype = axistype;
    }

    public String getAutoaxisinfo() {
        return autoaxisinfo;
    }

    public void setAutoaxisinfo(String autoaxisinfo) {
        this.autoaxisinfo = autoaxisinfo == null ? null : autoaxisinfo.trim();
    }

    public String getAxisinfo() {
        return axisinfo;
    }

    public void setAxisinfo(String axisinfo) {
        this.axisinfo = axisinfo == null ? null : axisinfo.trim();
    }

    public Integer getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(Integer totalweight) {
        this.totalweight = totalweight;
    }

    public Integer getLimitweight() {
        return limitweight;
    }

    public void setLimitweight(Integer limitweight) {
        this.limitweight = limitweight;
    }

    public Integer getOverweightrate() {
        return overweightrate;
    }

    public void setOverweightrate(Integer overweightrate) {
        this.overweightrate = overweightrate;
    }

    public Short getPaytype() {
        return paytype;
    }

    public void setPaytype(Short paytype) {
        this.paytype = paytype;
    }

    public String getDealstatus() {
        return dealstatus;
    }

    public void setDealstatus(String dealstatus) {
        this.dealstatus = dealstatus == null ? null : dealstatus.trim();
    }

    public String getDevstatus() {
        return devstatus;
    }

    public void setDevstatus(String devstatus) {
        this.devstatus = devstatus == null ? null : devstatus.trim();
    }

    public Short getVcnt() {
        return vcnt;
    }

    public void setVcnt(Short vcnt) {
        this.vcnt = vcnt;
    }

    public String getKeypressinfo() {
        return keypressinfo;
    }

    public void setKeypressinfo(String keypressinfo) {
        this.keypressinfo = keypressinfo == null ? null : keypressinfo.trim();
    }

    public Integer getAssueentry() {
        return assueentry;
    }

    public void setAssueentry(Integer assueentry) {
        this.assueentry = assueentry;
    }

    public Integer getEntrystation() {
        return entrystation;
    }

    public void setEntrystation(Integer entrystation) {
        this.entrystation = entrystation;
    }

    public Short getEntrylane() {
        return entrylane;
    }

    public void setEntrylane(Short entrylane) {
        this.entrylane = entrylane;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Short getEntrywastesn() {
        return entrywastesn;
    }

    public void setEntrywastesn(Short entrywastesn) {
        this.entrywastesn = entrywastesn;
    }

    public Integer getEntryoperatorid() {
        return entryoperatorid;
    }

    public void setEntryoperatorid(Integer entryoperatorid) {
        this.entryoperatorid = entryoperatorid;
    }

    public Short getEntryvclass() {
        return entryvclass;
    }

    public void setEntryvclass(Short entryvclass) {
        this.entryvclass = entryvclass;
    }

    public Short getEntryvtype() {
        return entryvtype;
    }

    public void setEntryvtype(Short entryvtype) {
        this.entryvtype = entryvtype;
    }

    public Long getEntryaxistype() {
        return entryaxistype;
    }

    public void setEntryaxistype(Long entryaxistype) {
        this.entryaxistype = entryaxistype;
    }

    public String getEntryvlp() {
        return entryvlp;
    }

    public void setEntryvlp(String entryvlp) {
        this.entryvlp = entryvlp == null ? null : entryvlp.trim();
    }

    public Long getEntrypsamid() {
        return entrypsamid;
    }

    public void setEntrypsamid(Long entrypsamid) {
        this.entrypsamid = entrypsamid;
    }

    public Long getOvertime() {
        return overtime;
    }

    public void setOvertime(Long overtime) {
        this.overtime = overtime;
    }

    public Long getTolldistance() {
        return tolldistance;
    }

    public void setTolldistance(Long tolldistance) {
        this.tolldistance = tolldistance;
    }

    public Long getRealdistance() {
        return realdistance;
    }

    public void setRealdistance(Long realdistance) {
        this.realdistance = realdistance;
    }

    public BigDecimal getBaseentrymoney() {
        return baseentrymoney;
    }

    public void setBaseentrymoney(BigDecimal baseentrymoney) {
        this.baseentrymoney = baseentrymoney;
    }

    public BigDecimal getBasemoney() {
        return basemoney;
    }

    public void setBasemoney(BigDecimal basemoney) {
        this.basemoney = basemoney;
    }

    public BigDecimal getOverweightmoney() {
        return overweightmoney;
    }

    public void setOverweightmoney(BigDecimal overweightmoney) {
        this.overweightmoney = overweightmoney;
    }

    public BigDecimal getFreemoney() {
        return freemoney;
    }

    public void setFreemoney(BigDecimal freemoney) {
        this.freemoney = freemoney;
    }

    public BigDecimal getUnpaymoney() {
        return unpaymoney;
    }

    public void setUnpaymoney(BigDecimal unpaymoney) {
        this.unpaymoney = unpaymoney;
    }

    public BigDecimal getCashmoney() {
        return cashmoney;
    }

    public void setCashmoney(BigDecimal cashmoney) {
        this.cashmoney = cashmoney;
    }

    public BigDecimal getStoremoney() {
        return storemoney;
    }

    public void setStoremoney(BigDecimal storemoney) {
        this.storemoney = storemoney;
    }

    public BigDecimal getTallymoney() {
        return tallymoney;
    }

    public void setTallymoney(BigDecimal tallymoney) {
        this.tallymoney = tallymoney;
    }

    public BigDecimal getUnipaymoney() {
        return unipaymoney;
    }

    public void setUnipaymoney(BigDecimal unipaymoney) {
        this.unipaymoney = unipaymoney;
    }

    public BigDecimal getCardcostmoney() {
        return cardcostmoney;
    }

    public void setCardcostmoney(BigDecimal cardcostmoney) {
        this.cardcostmoney = cardcostmoney;
    }

    public BigDecimal getStorebalancemoney() {
        return storebalancemoney;
    }

    public void setStorebalancemoney(BigDecimal storebalancemoney) {
        this.storebalancemoney = storebalancemoney;
    }

    public Long getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Long invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Short getInvoicecnt() {
        return invoicecnt;
    }

    public void setInvoicecnt(Short invoicecnt) {
        this.invoicecnt = invoicecnt;
    }

    public Long getTollver() {
        return tollver;
    }

    public void setTollver(Long tollver) {
        this.tollver = tollver;
    }

    public Long getTollratever() {
        return tollratever;
    }

    public void setTollratever(Long tollratever) {
        this.tollratever = tollratever;
    }

    public String getFlagstationinfo() {
        return flagstationinfo;
    }

    public void setFlagstationinfo(String flagstationinfo) {
        this.flagstationinfo = flagstationinfo == null ? null : flagstationinfo.trim();
    }

    public Short getFreetype() {
        return freetype;
    }

    public void setFreetype(Short freetype) {
        this.freetype = freetype;
    }

    public String getFreearea() {
        return freearea;
    }

    public void setFreearea(String freearea) {
        this.freearea = freearea == null ? null : freearea.trim();
    }

    public Short getSplitnum() {
        return splitnum;
    }

    public void setSplitnum(Short splitnum) {
        this.splitnum = splitnum;
    }

    public String getSplitinfo() {
        return splitinfo;
    }

    public void setSplitinfo(String splitinfo) {
        this.splitinfo = splitinfo == null ? null : splitinfo.trim();
    }

    public Long getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(Long verifycode) {
        this.verifycode = verifycode;
    }

    public Short getModifyflag() {
        return modifyflag;
    }

    public void setModifyflag(Short modifyflag) {
        this.modifyflag = modifyflag;
    }

    public Long getSpare1() {
        return spare1;
    }

    public void setSpare1(Long spare1) {
        this.spare1 = spare1;
    }

    public Long getSpare2() {
        return spare2;
    }

    public void setSpare2(Long spare2) {
        this.spare2 = spare2;
    }

    public Long getSpare3() {
        return spare3;
    }

    public void setSpare3(Long spare3) {
        this.spare3 = spare3;
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4 == null ? null : spare4.trim();
    }

    public Short getTransflag() {
        return transflag;
    }

    public void setTransflag(Short transflag) {
        this.transflag = transflag;
    }

    public String getIssuerid() {
        return issuerid;
    }

    public void setIssuerid(String issuerid) {
        this.issuerid = issuerid == null ? null : issuerid.trim();
    }

    public String getCardnetid() {
        return cardnetid;
    }

    public void setCardnetid(String cardnetid) {
        this.cardnetid = cardnetid == null ? null : cardnetid.trim();
    }

    public String getCardid2() {
        return cardid2;
    }

    public void setCardid2(String cardid2) {
        this.cardid2 = cardid2 == null ? null : cardid2.trim();
    }

    public String getPaycardid2() {
        return paycardid2;
    }

    public void setPaycardid2(String paycardid2) {
        this.paycardid2 = paycardid2 == null ? null : paycardid2.trim();
    }

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid == null ? null : terminalid.trim();
    }

    public Short getKeyversion() {
        return keyversion;
    }

    public void setKeyversion(Short keyversion) {
        this.keyversion = keyversion;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getObuid2() {
        return obuid2;
    }

    public void setObuid2(String obuid2) {
        this.obuid2 = obuid2 == null ? null : obuid2.trim();
    }

    public Short getTranstype() {
        return transtype;
    }

    public void setTranstype(Short transtype) {
        this.transtype = transtype;
    }

    public String getIsupload() {
        return isupload;
    }

    public void setIsupload(String isupload) {
        this.isupload = isupload == null ? null : isupload.trim();
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public String getLaneno() {
        return laneno;
    }

    public void setLaneno(String laneno) {
        this.laneno = laneno == null ? null : laneno.trim();
    }

    public String getImagepath2() {
        return imagepath2;
    }

    public void setImagepath2(String imagepath2) {
        this.imagepath2 = imagepath2 == null ? null : imagepath2.trim();
    }
}