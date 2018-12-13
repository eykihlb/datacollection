package com.mydao.datacollection.entity.station;

import java.math.BigDecimal;
import java.util.Date;

public class DataTransaction {
    private String netno;

    private String siteno;

    private String laneno;

    private String lanetype;

    private String lanemode;

    private String cetc;

    private String jobno;

    private Date jobbegin;

    private String squadno;

    private String staffno;

    private String staffname;

    private Date transactiondate;

    private String transactionno;

    private String indxno;

    private String obstcsc;

    private String obsmop;

    private String obssequence;

    private String obspassage;

    private String classno;

    private String farenetno;

    private String faresiteno;

    private String entrynetno;

    private String entrysiteno;

    private String entrylanetype;

    private String entrylaneno;

    private String entrystaffno;

    private String entryclassno;

    private String entryvehicleplate;

    private Date entrydate;

    private String entryjobno;

    private String entrymopno;

    private String mopno;

    private String ticketno;

    private String faretblversion;

    private BigDecimal prixtotal;

    private BigDecimal prixpartial;

    private String mopdetail;

    private String codeoctal;

    private String tcscno;

    private String tcscversion;

    private String cartridgeno;

    private String tcscorderno;

    private String cartridgecycleno;

    private String paycscno;

    private String exitvehicleplate;

    private String parvehicleplate;

    private String processtype;

    private String coverweight;

    private String invoicetype;

    private String equipstatus;

    private String cflag;

    private String fareclassno;

    private String shiftno;

    private String imagefile;

    private String routeno;

    private Short fareaxles;

    private Integer detectweight;

    private Integer overweight;

    private String overweighttype;

    private String entryaxles;

    private Integer entryweight;

    private Integer entryoverweight;

    private String entryoverweighttype;

    private String entryparvehicleplate;

    private String picturecomment;

    private String picturecomment2;

    private String weightmode;

    private String parvehicleplatecolor;

    private Short distance;

    private BigDecimal computerate;

    private Integer fareweight;

    private BigDecimal overweightfare;

    private Short axlegroups;

    private String axlegroup1type;

    private Integer axlegroup1weight;

    private String axlegroup2type;

    private Integer axlegroup2weight;

    private String axlegroup3type;

    private Integer axlegroup3weight;

    private String axlegroup4type;

    private Integer axlegroup4weight;

    private String axlegroup5type;

    private Integer axlegroup5weight;

    private String axlegroup6type;

    private Integer axlegroup6weight;

    private String axlegroup7type;

    private Integer axlegroup7weight;

    private String axlegroup8type;

    private Integer axlegroup8weight;

    private String axlegroup9type;

    private Integer axlegroup9weight;

    private Short speed;

    private Short acceleration;

    private String fareaxlegroup1type;

    private String fareaxlegroup2type;

    private String fareaxlegroup3type;

    private String fareaxlegroup4type;

    private String fareaxlegroup5type;

    private String fareaxlegroup6type;

    private String fareaxlegroup7type;

    private String fareaxlegroup8type;

    private String fareaxlegroup9type;

    private Date weightddhm;

    private Short entryaxlegroups;

    private String entryaxlegroup1type;

    private String entryaxlegroup2type;

    private String entryaxlegroup3type;

    private String entryaxlegroup4type;

    private String entryaxlegroup5type;

    private String entryaxlegroup6type;

    private String entryaxlegroup7type;

    private String entryaxlegroup8type;

    private String entryaxlegroup9type;

    private String picturecommenttype;

    private Short detectaxles;

    private String isoverload;

    private String isspecialtrunk;

    private Integer limitweight;

    private Integer fareaxlegroup1weight;

    private Integer fareaxlegroup2weight;

    private Integer fareaxlegroup3weight;

    private Integer fareaxlegroup4weight;

    private Integer fareaxlegroup5weight;

    private Integer fareaxlegroup6weight;

    private Integer fareaxlegroup7weight;

    private Integer fareaxlegroup8weight;

    private Integer fareaxlegroup9weight;

    private Integer entryaxlegroup1weight;

    private Integer entryaxlegroup2weight;

    private Integer entryaxlegroup3weight;

    private Integer entryaxlegroup4weight;

    private Integer entryaxlegroup5weight;

    private Integer entryaxlegroup6weight;

    private Integer entryaxlegroup7weight;

    private Integer entryaxlegroup8weight;

    private Integer entryaxlegroup9weight;

    private Short fareaxlegroups;

    private Integer discountfare;

    private String cpucardnetwork;

    private String cpucardno;

    private String cpucardtype;

    private Integer flagstanum;

    private String flagsta;

    private BigDecimal byField1;

    private String qrtransid;

    private String qrpayfare;

    private String qrpaytype;

    private String cflag1;

    private String cflag2;

    private String axletypeandweight;

    private String uploadflag;

    private String missdate;

    public String getMissdate() {
        return missdate;
    }

    public void setMissdate(String missdate) {
        this.missdate = missdate;
    }

    public String getUploadflag() {
        return uploadflag;
    }

    public void setUploadflag(String uploadflag) {
        this.uploadflag = uploadflag;
    }

    public String getAxletypeandweight() {
        return axletypeandweight;
    }
    public void setAxletypeandweight(String axletypeandweight) {
        this.axletypeandweight = axletypeandweight;
    }

    public String getNetno() {
        return netno;
    }

    public void setNetno(String netno) {
        this.netno = netno == null ? null : netno.trim();
    }

    public String getSiteno() {
        return siteno;
    }

    public void setSiteno(String siteno) {
        this.siteno = siteno == null ? null : siteno.trim();
    }

    public String getLaneno() {
        return laneno;
    }

    public void setLaneno(String laneno) {
        this.laneno = laneno == null ? null : laneno.trim();
    }

    public String getLanetype() {
        return lanetype;
    }

    public void setLanetype(String lanetype) {
        this.lanetype = lanetype == null ? null : lanetype.trim();
    }

    public String getLanemode() {
        return lanemode;
    }

    public void setLanemode(String lanemode) {
        this.lanemode = lanemode == null ? null : lanemode.trim();
    }

    public String getCetc() {
        return cetc;
    }

    public void setCetc(String cetc) {
        this.cetc = cetc == null ? null : cetc.trim();
    }

    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno == null ? null : jobno.trim();
    }

    public Date getJobbegin() {
        return jobbegin;
    }

    public void setJobbegin(Date jobbegin) {
        this.jobbegin = jobbegin;
    }

    public String getSquadno() {
        return squadno;
    }

    public void setSquadno(String squadno) {
        this.squadno = squadno == null ? null : squadno.trim();
    }

    public String getStaffno() {
        return staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno == null ? null : staffno.trim();
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public String getTransactionno() {
        return transactionno;
    }

    public void setTransactionno(String transactionno) {
        this.transactionno = transactionno == null ? null : transactionno.trim();
    }

    public String getIndxno() {
        return indxno;
    }

    public void setIndxno(String indxno) {
        this.indxno = indxno == null ? null : indxno.trim();
    }

    public String getObstcsc() {
        return obstcsc;
    }

    public void setObstcsc(String obstcsc) {
        this.obstcsc = obstcsc == null ? null : obstcsc.trim();
    }

    public String getObsmop() {
        return obsmop;
    }

    public void setObsmop(String obsmop) {
        this.obsmop = obsmop == null ? null : obsmop.trim();
    }

    public String getObssequence() {
        return obssequence;
    }

    public void setObssequence(String obssequence) {
        this.obssequence = obssequence == null ? null : obssequence.trim();
    }

    public String getObspassage() {
        return obspassage;
    }

    public void setObspassage(String obspassage) {
        this.obspassage = obspassage == null ? null : obspassage.trim();
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno == null ? null : classno.trim();
    }

    public String getFarenetno() {
        return farenetno;
    }

    public void setFarenetno(String farenetno) {
        this.farenetno = farenetno == null ? null : farenetno.trim();
    }

    public String getFaresiteno() {
        return faresiteno;
    }

    public void setFaresiteno(String faresiteno) {
        this.faresiteno = faresiteno == null ? null : faresiteno.trim();
    }

    public String getEntrynetno() {
        return entrynetno;
    }

    public void setEntrynetno(String entrynetno) {
        this.entrynetno = entrynetno == null ? null : entrynetno.trim();
    }

    public String getEntrysiteno() {
        return entrysiteno;
    }

    public void setEntrysiteno(String entrysiteno) {
        this.entrysiteno = entrysiteno == null ? null : entrysiteno.trim();
    }

    public String getEntrylanetype() {
        return entrylanetype;
    }

    public void setEntrylanetype(String entrylanetype) {
        this.entrylanetype = entrylanetype == null ? null : entrylanetype.trim();
    }

    public String getEntrylaneno() {
        return entrylaneno;
    }

    public void setEntrylaneno(String entrylaneno) {
        this.entrylaneno = entrylaneno == null ? null : entrylaneno.trim();
    }

    public String getEntrystaffno() {
        return entrystaffno;
    }

    public void setEntrystaffno(String entrystaffno) {
        this.entrystaffno = entrystaffno == null ? null : entrystaffno.trim();
    }

    public String getEntryclassno() {
        return entryclassno;
    }

    public void setEntryclassno(String entryclassno) {
        this.entryclassno = entryclassno == null ? null : entryclassno.trim();
    }

    public String getEntryvehicleplate() {
        return entryvehicleplate;
    }

    public void setEntryvehicleplate(String entryvehicleplate) {
        this.entryvehicleplate = entryvehicleplate == null ? null : entryvehicleplate.trim();
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getEntryjobno() {
        return entryjobno;
    }

    public void setEntryjobno(String entryjobno) {
        this.entryjobno = entryjobno == null ? null : entryjobno.trim();
    }

    public String getEntrymopno() {
        return entrymopno;
    }

    public void setEntrymopno(String entrymopno) {
        this.entrymopno = entrymopno == null ? null : entrymopno.trim();
    }

    public String getMopno() {
        return mopno;
    }

    public void setMopno(String mopno) {
        this.mopno = mopno == null ? null : mopno.trim();
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno == null ? null : ticketno.trim();
    }

    public String getFaretblversion() {
        return faretblversion;
    }

    public void setFaretblversion(String faretblversion) {
        this.faretblversion = faretblversion == null ? null : faretblversion.trim();
    }

    public BigDecimal getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(BigDecimal prixtotal) {
        this.prixtotal = prixtotal;
    }

    public BigDecimal getPrixpartial() {
        return prixpartial;
    }

    public void setPrixpartial(BigDecimal prixpartial) {
        this.prixpartial = prixpartial;
    }

    public String getMopdetail() {
        return mopdetail;
    }

    public void setMopdetail(String mopdetail) {
        this.mopdetail = mopdetail == null ? null : mopdetail.trim();
    }

    public String getCodeoctal() {
        return codeoctal;
    }

    public void setCodeoctal(String codeoctal) {
        this.codeoctal = codeoctal == null ? null : codeoctal.trim();
    }

    public String getTcscno() {
        return tcscno;
    }

    public void setTcscno(String tcscno) {
        this.tcscno = tcscno == null ? null : tcscno.trim();
    }

    public String getTcscversion() {
        return tcscversion;
    }

    public void setTcscversion(String tcscversion) {
        this.tcscversion = tcscversion == null ? null : tcscversion.trim();
    }

    public String getCartridgeno() {
        return cartridgeno;
    }

    public void setCartridgeno(String cartridgeno) {
        this.cartridgeno = cartridgeno == null ? null : cartridgeno.trim();
    }

    public String getTcscorderno() {
        return tcscorderno;
    }

    public void setTcscorderno(String tcscorderno) {
        this.tcscorderno = tcscorderno == null ? null : tcscorderno.trim();
    }

    public String getCartridgecycleno() {
        return cartridgecycleno;
    }

    public void setCartridgecycleno(String cartridgecycleno) {
        this.cartridgecycleno = cartridgecycleno == null ? null : cartridgecycleno.trim();
    }

    public String getPaycscno() {
        return paycscno;
    }

    public void setPaycscno(String paycscno) {
        this.paycscno = paycscno == null ? null : paycscno.trim();
    }

    public String getExitvehicleplate() {
        return exitvehicleplate;
    }

    public void setExitvehicleplate(String exitvehicleplate) {
        this.exitvehicleplate = exitvehicleplate == null ? null : exitvehicleplate.trim();
    }

    public String getParvehicleplate() {
        return parvehicleplate;
    }

    public void setParvehicleplate(String parvehicleplate) {
        this.parvehicleplate = parvehicleplate == null ? null : parvehicleplate.trim();
    }

    public String getProcesstype() {
        return processtype;
    }

    public void setProcesstype(String processtype) {
        this.processtype = processtype == null ? null : processtype.trim();
    }

    public String getCoverweight() {
        return coverweight;
    }

    public void setCoverweight(String coverweight) {
        this.coverweight = coverweight == null ? null : coverweight.trim();
    }

    public String getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype == null ? null : invoicetype.trim();
    }

    public String getEquipstatus() {
        return equipstatus;
    }

    public void setEquipstatus(String equipstatus) {
        this.equipstatus = equipstatus == null ? null : equipstatus.trim();
    }

    public String getCflag() {
        return cflag;
    }

    public void setCflag(String cflag) {
        this.cflag = cflag == null ? null : cflag.trim();
    }

    public String getFareclassno() {
        return fareclassno;
    }

    public void setFareclassno(String fareclassno) {
        this.fareclassno = fareclassno == null ? null : fareclassno.trim();
    }

    public String getShiftno() {
        return shiftno;
    }

    public void setShiftno(String shiftno) {
        this.shiftno = shiftno == null ? null : shiftno.trim();
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile == null ? null : imagefile.trim();
    }

    public String getRouteno() {
        return routeno;
    }

    public void setRouteno(String routeno) {
        this.routeno = routeno == null ? null : routeno.trim();
    }

    public Short getFareaxles() {
        return fareaxles;
    }

    public void setFareaxles(Short fareaxles) {
        this.fareaxles = fareaxles;
    }

    public Integer getDetectweight() {
        return detectweight;
    }

    public void setDetectweight(Integer detectweight) {
        this.detectweight = detectweight;
    }

    public Integer getOverweight() {
        return overweight;
    }

    public void setOverweight(Integer overweight) {
        this.overweight = overweight;
    }

    public String getOverweighttype() {
        return overweighttype;
    }

    public void setOverweighttype(String overweighttype) {
        this.overweighttype = overweighttype == null ? null : overweighttype.trim();
    }

    public String getEntryaxles() {
        return entryaxles;
    }

    public void setEntryaxles(String entryaxles) {
        this.entryaxles = entryaxles == null ? null : entryaxles.trim();
    }

    public Integer getEntryweight() {
        return entryweight;
    }

    public void setEntryweight(Integer entryweight) {
        this.entryweight = entryweight;
    }

    public Integer getEntryoverweight() {
        return entryoverweight;
    }

    public void setEntryoverweight(Integer entryoverweight) {
        this.entryoverweight = entryoverweight;
    }

    public String getEntryoverweighttype() {
        return entryoverweighttype;
    }

    public void setEntryoverweighttype(String entryoverweighttype) {
        this.entryoverweighttype = entryoverweighttype == null ? null : entryoverweighttype.trim();
    }

    public String getEntryparvehicleplate() {
        return entryparvehicleplate;
    }

    public void setEntryparvehicleplate(String entryparvehicleplate) {
        this.entryparvehicleplate = entryparvehicleplate == null ? null : entryparvehicleplate.trim();
    }

    public String getPicturecomment() {
        return picturecomment;
    }

    public void setPicturecomment(String picturecomment) {
        this.picturecomment = picturecomment == null ? null : picturecomment.trim();
    }

    public String getPicturecomment2() {
        return picturecomment2;
    }

    public void setPicturecomment2(String picturecomment2) {
        this.picturecomment2 = picturecomment2 == null ? null : picturecomment2.trim();
    }

    public String getWeightmode() {
        return weightmode;
    }

    public void setWeightmode(String weightmode) {
        this.weightmode = weightmode == null ? null : weightmode.trim();
    }

    public String getParvehicleplatecolor() {
        return parvehicleplatecolor;
    }

    public void setParvehicleplatecolor(String parvehicleplatecolor) {
        this.parvehicleplatecolor = parvehicleplatecolor == null ? null : parvehicleplatecolor.trim();
    }

    public Short getDistance() {
        return distance;
    }

    public void setDistance(Short distance) {
        this.distance = distance;
    }

    public BigDecimal getComputerate() {
        return computerate;
    }

    public void setComputerate(BigDecimal computerate) {
        this.computerate = computerate;
    }

    public Integer getFareweight() {
        return fareweight;
    }

    public void setFareweight(Integer fareweight) {
        this.fareweight = fareweight;
    }

    public BigDecimal getOverweightfare() {
        return overweightfare;
    }

    public void setOverweightfare(BigDecimal overweightfare) {
        this.overweightfare = overweightfare;
    }

    public Short getAxlegroups() {
        return axlegroups;
    }

    public void setAxlegroups(Short axlegroups) {
        this.axlegroups = axlegroups;
    }

    public String getAxlegroup1type() {
        return axlegroup1type;
    }

    public void setAxlegroup1type(String axlegroup1type) {
        this.axlegroup1type = axlegroup1type == null ? null : axlegroup1type.trim();
    }

    public Integer getAxlegroup1weight() {
        return axlegroup1weight;
    }

    public void setAxlegroup1weight(Integer axlegroup1weight) {
        this.axlegroup1weight = axlegroup1weight;
    }

    public String getAxlegroup2type() {
        return axlegroup2type;
    }

    public void setAxlegroup2type(String axlegroup2type) {
        this.axlegroup2type = axlegroup2type == null ? null : axlegroup2type.trim();
    }

    public Integer getAxlegroup2weight() {
        return axlegroup2weight;
    }

    public void setAxlegroup2weight(Integer axlegroup2weight) {
        this.axlegroup2weight = axlegroup2weight;
    }

    public String getAxlegroup3type() {
        return axlegroup3type;
    }

    public void setAxlegroup3type(String axlegroup3type) {
        this.axlegroup3type = axlegroup3type == null ? null : axlegroup3type.trim();
    }

    public Integer getAxlegroup3weight() {
        return axlegroup3weight;
    }

    public void setAxlegroup3weight(Integer axlegroup3weight) {
        this.axlegroup3weight = axlegroup3weight;
    }

    public String getAxlegroup4type() {
        return axlegroup4type;
    }

    public void setAxlegroup4type(String axlegroup4type) {
        this.axlegroup4type = axlegroup4type == null ? null : axlegroup4type.trim();
    }

    public Integer getAxlegroup4weight() {
        return axlegroup4weight;
    }

    public void setAxlegroup4weight(Integer axlegroup4weight) {
        this.axlegroup4weight = axlegroup4weight;
    }

    public String getAxlegroup5type() {
        return axlegroup5type;
    }

    public void setAxlegroup5type(String axlegroup5type) {
        this.axlegroup5type = axlegroup5type == null ? null : axlegroup5type.trim();
    }

    public Integer getAxlegroup5weight() {
        return axlegroup5weight;
    }

    public void setAxlegroup5weight(Integer axlegroup5weight) {
        this.axlegroup5weight = axlegroup5weight;
    }

    public String getAxlegroup6type() {
        return axlegroup6type;
    }

    public void setAxlegroup6type(String axlegroup6type) {
        this.axlegroup6type = axlegroup6type == null ? null : axlegroup6type.trim();
    }

    public Integer getAxlegroup6weight() {
        return axlegroup6weight;
    }

    public void setAxlegroup6weight(Integer axlegroup6weight) {
        this.axlegroup6weight = axlegroup6weight;
    }

    public String getAxlegroup7type() {
        return axlegroup7type;
    }

    public void setAxlegroup7type(String axlegroup7type) {
        this.axlegroup7type = axlegroup7type == null ? null : axlegroup7type.trim();
    }

    public Integer getAxlegroup7weight() {
        return axlegroup7weight;
    }

    public void setAxlegroup7weight(Integer axlegroup7weight) {
        this.axlegroup7weight = axlegroup7weight;
    }

    public String getAxlegroup8type() {
        return axlegroup8type;
    }

    public void setAxlegroup8type(String axlegroup8type) {
        this.axlegroup8type = axlegroup8type == null ? null : axlegroup8type.trim();
    }

    public Integer getAxlegroup8weight() {
        return axlegroup8weight;
    }

    public void setAxlegroup8weight(Integer axlegroup8weight) {
        this.axlegroup8weight = axlegroup8weight;
    }

    public String getAxlegroup9type() {
        return axlegroup9type;
    }

    public void setAxlegroup9type(String axlegroup9type) {
        this.axlegroup9type = axlegroup9type == null ? null : axlegroup9type.trim();
    }

    public Integer getAxlegroup9weight() {
        return axlegroup9weight;
    }

    public void setAxlegroup9weight(Integer axlegroup9weight) {
        this.axlegroup9weight = axlegroup9weight;
    }

    public Short getSpeed() {
        return speed;
    }

    public void setSpeed(Short speed) {
        this.speed = speed;
    }

    public Short getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Short acceleration) {
        this.acceleration = acceleration;
    }

    public String getFareaxlegroup1type() {
        return fareaxlegroup1type;
    }

    public void setFareaxlegroup1type(String fareaxlegroup1type) {
        this.fareaxlegroup1type = fareaxlegroup1type == null ? null : fareaxlegroup1type.trim();
    }

    public String getFareaxlegroup2type() {
        return fareaxlegroup2type;
    }

    public void setFareaxlegroup2type(String fareaxlegroup2type) {
        this.fareaxlegroup2type = fareaxlegroup2type == null ? null : fareaxlegroup2type.trim();
    }

    public String getFareaxlegroup3type() {
        return fareaxlegroup3type;
    }

    public void setFareaxlegroup3type(String fareaxlegroup3type) {
        this.fareaxlegroup3type = fareaxlegroup3type == null ? null : fareaxlegroup3type.trim();
    }

    public String getFareaxlegroup4type() {
        return fareaxlegroup4type;
    }

    public void setFareaxlegroup4type(String fareaxlegroup4type) {
        this.fareaxlegroup4type = fareaxlegroup4type == null ? null : fareaxlegroup4type.trim();
    }

    public String getFareaxlegroup5type() {
        return fareaxlegroup5type;
    }

    public void setFareaxlegroup5type(String fareaxlegroup5type) {
        this.fareaxlegroup5type = fareaxlegroup5type == null ? null : fareaxlegroup5type.trim();
    }

    public String getFareaxlegroup6type() {
        return fareaxlegroup6type;
    }

    public void setFareaxlegroup6type(String fareaxlegroup6type) {
        this.fareaxlegroup6type = fareaxlegroup6type == null ? null : fareaxlegroup6type.trim();
    }

    public String getFareaxlegroup7type() {
        return fareaxlegroup7type;
    }

    public void setFareaxlegroup7type(String fareaxlegroup7type) {
        this.fareaxlegroup7type = fareaxlegroup7type == null ? null : fareaxlegroup7type.trim();
    }

    public String getFareaxlegroup8type() {
        return fareaxlegroup8type;
    }

    public void setFareaxlegroup8type(String fareaxlegroup8type) {
        this.fareaxlegroup8type = fareaxlegroup8type == null ? null : fareaxlegroup8type.trim();
    }

    public String getFareaxlegroup9type() {
        return fareaxlegroup9type;
    }

    public void setFareaxlegroup9type(String fareaxlegroup9type) {
        this.fareaxlegroup9type = fareaxlegroup9type == null ? null : fareaxlegroup9type.trim();
    }

    public Date getWeightddhm() {
        return weightddhm;
    }

    public void setWeightddhm(Date weightddhm) {
        this.weightddhm = weightddhm;
    }

    public Short getEntryaxlegroups() {
        return entryaxlegroups;
    }

    public void setEntryaxlegroups(Short entryaxlegroups) {
        this.entryaxlegroups = entryaxlegroups;
    }

    public String getEntryaxlegroup1type() {
        return entryaxlegroup1type;
    }

    public void setEntryaxlegroup1type(String entryaxlegroup1type) {
        this.entryaxlegroup1type = entryaxlegroup1type == null ? null : entryaxlegroup1type.trim();
    }

    public String getEntryaxlegroup2type() {
        return entryaxlegroup2type;
    }

    public void setEntryaxlegroup2type(String entryaxlegroup2type) {
        this.entryaxlegroup2type = entryaxlegroup2type == null ? null : entryaxlegroup2type.trim();
    }

    public String getEntryaxlegroup3type() {
        return entryaxlegroup3type;
    }

    public void setEntryaxlegroup3type(String entryaxlegroup3type) {
        this.entryaxlegroup3type = entryaxlegroup3type == null ? null : entryaxlegroup3type.trim();
    }

    public String getEntryaxlegroup4type() {
        return entryaxlegroup4type;
    }

    public void setEntryaxlegroup4type(String entryaxlegroup4type) {
        this.entryaxlegroup4type = entryaxlegroup4type == null ? null : entryaxlegroup4type.trim();
    }

    public String getEntryaxlegroup5type() {
        return entryaxlegroup5type;
    }

    public void setEntryaxlegroup5type(String entryaxlegroup5type) {
        this.entryaxlegroup5type = entryaxlegroup5type == null ? null : entryaxlegroup5type.trim();
    }

    public String getEntryaxlegroup6type() {
        return entryaxlegroup6type;
    }

    public void setEntryaxlegroup6type(String entryaxlegroup6type) {
        this.entryaxlegroup6type = entryaxlegroup6type == null ? null : entryaxlegroup6type.trim();
    }

    public String getEntryaxlegroup7type() {
        return entryaxlegroup7type;
    }

    public void setEntryaxlegroup7type(String entryaxlegroup7type) {
        this.entryaxlegroup7type = entryaxlegroup7type == null ? null : entryaxlegroup7type.trim();
    }

    public String getEntryaxlegroup8type() {
        return entryaxlegroup8type;
    }

    public void setEntryaxlegroup8type(String entryaxlegroup8type) {
        this.entryaxlegroup8type = entryaxlegroup8type == null ? null : entryaxlegroup8type.trim();
    }

    public String getEntryaxlegroup9type() {
        return entryaxlegroup9type;
    }

    public void setEntryaxlegroup9type(String entryaxlegroup9type) {
        this.entryaxlegroup9type = entryaxlegroup9type == null ? null : entryaxlegroup9type.trim();
    }

    public String getPicturecommenttype() {
        return picturecommenttype;
    }

    public void setPicturecommenttype(String picturecommenttype) {
        this.picturecommenttype = picturecommenttype == null ? null : picturecommenttype.trim();
    }

    public Short getDetectaxles() {
        return detectaxles;
    }

    public void setDetectaxles(Short detectaxles) {
        this.detectaxles = detectaxles;
    }

    public String getIsoverload() {
        return isoverload;
    }

    public void setIsoverload(String isoverload) {
        this.isoverload = isoverload == null ? null : isoverload.trim();
    }

    public String getIsspecialtrunk() {
        return isspecialtrunk;
    }

    public void setIsspecialtrunk(String isspecialtrunk) {
        this.isspecialtrunk = isspecialtrunk == null ? null : isspecialtrunk.trim();
    }

    public Integer getLimitweight() {
        return limitweight;
    }

    public void setLimitweight(Integer limitweight) {
        this.limitweight = limitweight;
    }

    public Integer getFareaxlegroup1weight() {
        return fareaxlegroup1weight;
    }

    public void setFareaxlegroup1weight(Integer fareaxlegroup1weight) {
        this.fareaxlegroup1weight = fareaxlegroup1weight;
    }

    public Integer getFareaxlegroup2weight() {
        return fareaxlegroup2weight;
    }

    public void setFareaxlegroup2weight(Integer fareaxlegroup2weight) {
        this.fareaxlegroup2weight = fareaxlegroup2weight;
    }

    public Integer getFareaxlegroup3weight() {
        return fareaxlegroup3weight;
    }

    public void setFareaxlegroup3weight(Integer fareaxlegroup3weight) {
        this.fareaxlegroup3weight = fareaxlegroup3weight;
    }

    public Integer getFareaxlegroup4weight() {
        return fareaxlegroup4weight;
    }

    public void setFareaxlegroup4weight(Integer fareaxlegroup4weight) {
        this.fareaxlegroup4weight = fareaxlegroup4weight;
    }

    public Integer getFareaxlegroup5weight() {
        return fareaxlegroup5weight;
    }

    public void setFareaxlegroup5weight(Integer fareaxlegroup5weight) {
        this.fareaxlegroup5weight = fareaxlegroup5weight;
    }

    public Integer getFareaxlegroup6weight() {
        return fareaxlegroup6weight;
    }

    public void setFareaxlegroup6weight(Integer fareaxlegroup6weight) {
        this.fareaxlegroup6weight = fareaxlegroup6weight;
    }

    public Integer getFareaxlegroup7weight() {
        return fareaxlegroup7weight;
    }

    public void setFareaxlegroup7weight(Integer fareaxlegroup7weight) {
        this.fareaxlegroup7weight = fareaxlegroup7weight;
    }

    public Integer getFareaxlegroup8weight() {
        return fareaxlegroup8weight;
    }

    public void setFareaxlegroup8weight(Integer fareaxlegroup8weight) {
        this.fareaxlegroup8weight = fareaxlegroup8weight;
    }

    public Integer getFareaxlegroup9weight() {
        return fareaxlegroup9weight;
    }

    public void setFareaxlegroup9weight(Integer fareaxlegroup9weight) {
        this.fareaxlegroup9weight = fareaxlegroup9weight;
    }

    public Integer getEntryaxlegroup1weight() {
        return entryaxlegroup1weight;
    }

    public void setEntryaxlegroup1weight(Integer entryaxlegroup1weight) {
        this.entryaxlegroup1weight = entryaxlegroup1weight;
    }

    public Integer getEntryaxlegroup2weight() {
        return entryaxlegroup2weight;
    }

    public void setEntryaxlegroup2weight(Integer entryaxlegroup2weight) {
        this.entryaxlegroup2weight = entryaxlegroup2weight;
    }

    public Integer getEntryaxlegroup3weight() {
        return entryaxlegroup3weight;
    }

    public void setEntryaxlegroup3weight(Integer entryaxlegroup3weight) {
        this.entryaxlegroup3weight = entryaxlegroup3weight;
    }

    public Integer getEntryaxlegroup4weight() {
        return entryaxlegroup4weight;
    }

    public void setEntryaxlegroup4weight(Integer entryaxlegroup4weight) {
        this.entryaxlegroup4weight = entryaxlegroup4weight;
    }

    public Integer getEntryaxlegroup5weight() {
        return entryaxlegroup5weight;
    }

    public void setEntryaxlegroup5weight(Integer entryaxlegroup5weight) {
        this.entryaxlegroup5weight = entryaxlegroup5weight;
    }

    public Integer getEntryaxlegroup6weight() {
        return entryaxlegroup6weight;
    }

    public void setEntryaxlegroup6weight(Integer entryaxlegroup6weight) {
        this.entryaxlegroup6weight = entryaxlegroup6weight;
    }

    public Integer getEntryaxlegroup7weight() {
        return entryaxlegroup7weight;
    }

    public void setEntryaxlegroup7weight(Integer entryaxlegroup7weight) {
        this.entryaxlegroup7weight = entryaxlegroup7weight;
    }

    public Integer getEntryaxlegroup8weight() {
        return entryaxlegroup8weight;
    }

    public void setEntryaxlegroup8weight(Integer entryaxlegroup8weight) {
        this.entryaxlegroup8weight = entryaxlegroup8weight;
    }

    public Integer getEntryaxlegroup9weight() {
        return entryaxlegroup9weight;
    }

    public void setEntryaxlegroup9weight(Integer entryaxlegroup9weight) {
        this.entryaxlegroup9weight = entryaxlegroup9weight;
    }

    public Short getFareaxlegroups() {
        return fareaxlegroups;
    }

    public void setFareaxlegroups(Short fareaxlegroups) {
        this.fareaxlegroups = fareaxlegroups;
    }

    public Integer getDiscountfare() {
        return discountfare;
    }

    public void setDiscountfare(Integer discountfare) {
        this.discountfare = discountfare;
    }

    public String getCpucardnetwork() {
        return cpucardnetwork;
    }

    public void setCpucardnetwork(String cpucardnetwork) {
        this.cpucardnetwork = cpucardnetwork == null ? null : cpucardnetwork.trim();
    }

    public String getCpucardno() {
        return cpucardno;
    }

    public void setCpucardno(String cpucardno) {
        this.cpucardno = cpucardno == null ? null : cpucardno.trim();
    }

    public String getCpucardtype() {
        return cpucardtype;
    }

    public void setCpucardtype(String cpucardtype) {
        this.cpucardtype = cpucardtype == null ? null : cpucardtype.trim();
    }

    public Integer getFlagstanum() {
        return flagstanum;
    }

    public void setFlagstanum(Integer flagstanum) {
        this.flagstanum = flagstanum;
    }

    public String getFlagsta() {
        return flagsta;
    }

    public void setFlagsta(String flagsta) {
        this.flagsta = flagsta == null ? null : flagsta.trim();
    }

    public BigDecimal getByField1() {
        return byField1;
    }

    public void setByField1(BigDecimal byField1) {
        this.byField1 = byField1;
    }

    public String getQrtransid() {
        return qrtransid;
    }

    public void setQrtransid(String qrtransid) {
        this.qrtransid = qrtransid == null ? null : qrtransid.trim();
    }

    public String getQrpayfare() {
        return qrpayfare;
    }

    public void setQrpayfare(String qrpayfare) {
        this.qrpayfare = qrpayfare == null ? null : qrpayfare.trim();
    }

    public String getQrpaytype() {
        return qrpaytype;
    }

    public void setQrpaytype(String qrpaytype) {
        this.qrpaytype = qrpaytype == null ? null : qrpaytype.trim();
    }

    public String getCflag1() {
        return cflag1;
    }

    public void setCflag1(String cflag1) {
        this.cflag1 = cflag1 == null ? null : cflag1.trim();
    }

    public String getCflag2() {
        return cflag2;
    }

    public void setCflag2(String cflag2) {
        this.cflag2 = cflag2 == null ? null : cflag2.trim();
    }
}