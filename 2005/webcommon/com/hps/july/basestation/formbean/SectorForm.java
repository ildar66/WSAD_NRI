package com.hps.july.basestation.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.basestation.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;

/**
 * Форма редактирования сектора
 */
public class SectorForm extends BSEquipmentForm {
	private StringAndInteger idsect=new StringAndInteger();   
	private Boolean hasflt; //has filtr
	private Boolean haslna;
	private Boolean hasbuster;
	private Boolean ddk;
	private String conf;
	private String namesect;
	private String numsect;
	private String cellid;
	private String cellname;
	private StringAndShort band=new StringAndShort();
	private StringAndInteger portabis=new StringAndInteger();
	private String numpo;
	private StringAndBigDecimal azimut = new StringAndBigDecimal(6,2);
	private String btsnumber;
	private String conabis;

	private String lett;

	private Integer lac;

	private StringAndInteger trxnum=new StringAndInteger();
	private StringAndInteger trxnum2=new StringAndInteger();
	private StringAndInteger trxovrnum=new StringAndInteger();

	private StringAndBigDecimal txpwr=new StringAndBigDecimal(6,2);
	//public java.math.BigDecimal txpwr2;
	private StringAndBigDecimal txpwr2=new StringAndBigDecimal(6,2);
	private StringAndBigDecimal txovrsetpwr= new StringAndBigDecimal(6,2);

	private Boolean ishr;
	private Boolean capgprs;

	private String equipcomment;

    private Boolean byhand;
	private java.lang.String datasource;
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:46:22)
 */
public SectorForm() {
	super();
	
	}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(
    AbstractEntityAccessBean bean,
    javax.servlet.http.HttpServletRequest request)
    throws Exception {

    SectorObject.deleteAntennaLinks(getIdsect());
    
}
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	SectorAccessBean bs = (SectorAccessBean)bean;
	bs.setDatasource(0);
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    setIdsect(keyGen.getNextKey(TablesRef.SECTORS));
//DebugSupport.printlnTest("getBand()="+getBand());
    
    SectorAccessBean bean = new SectorAccessBean(
    /*int argIdsect,*/ getIdsect(),
    /*int argEquipment,*/ getEquipment().getStorageplace(),
    /*String argNamesect,*/ getNamesect(),
    /*short argBand,*/ getBand(),
    /*String argNumsect*/ getNumsect());

    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2003 14:58:21)
 */
private void fillBaseStation() throws Exception {
    try {
        SectorAccessBean sector = new SectorAccessBean();
        sector.setInitKey_idsect(getIdsect());
        sector.refreshCopyHelper();

        setBaseStation(sector.getEquipment());
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	if(numsect != null && numsect.length() > 0) {
		lett = String.valueOf(numsect.charAt(numsect.length()-1));
		cellid = numsect;
/*
		if(numsect.length() > 1) {
			cellid = numsect.substring(0,numsect.length()-1);
		} else {
			cellid = "";
		}
*/
	} else {
		lett = "";
		cellid = "";
	}
	try {
		if(!"D".equals(getBaseStation().getStationType())) {
		    cellname = ""+String.valueOf(getBaseStation().getNumber()) + lett;
		} else {
			cellname = cellid;
		}
	} catch(Exception e) {
		cellname = "???";
		e.printStackTrace(System.out);
	}
	setDatasource("Внесено вручную");
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAddrRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("siteProjector");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAllRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	return roles;
}
public java.math.BigDecimal getAzimut() {
	return azimut.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:41:36)
 * @return java.lang.String
 */
public String getAzimutFrm() {
	return azimut.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:43:01)
 * @return short
 */
public short getBand() throws Exception {

    return band.getshort();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:43:01)
 * @return short
 */
public String getBandFrm() throws Exception {
	 return band.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:53:42)
 * @return java.lang.String
 */
public java.lang.String getBtsnumber() {
	return btsnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2003 13:57:17)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getByhand() {
	return byhand;
}
/**
 * Insert the method's description here.
 * Creation date: (06.04.2003 13:49:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCapgprs() {
	return capgprs;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCellid() {
	return cellid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCellname() {
	return cellname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.04.2003 18:07:36)
 * @return java.lang.String
 */
public java.lang.String getConabis() {
	return conabis;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:20:21)
 * @return java.lang.String
 */
public java.lang.String getConf() {
	return conf==null?SectorObject.CONF_CHECK_1:conf;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
    try {
        SectorAccessBean bean = new SectorAccessBean();
        bean.setInitKey_idsect(getIdsect());
        bean.refreshCopyHelper();
        return bean;
    } catch (Exception e) {
        DebugSupport.printlnError(e, "getDataBean", this);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 17:25:11)
 * @return java.lang.String
 */
public java.lang.String getDatasource() {
	return datasource;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDdk() {
	return ddk==null?Boolean.FALSE:ddk;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2003 20:39:26)
 * @return java.lang.String
 */
public java.lang.String getEquipcomment() {
	return equipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public BaseStation getEquipment() throws Exception {
	return (BaseStation)getBaseStation().getEJBRef();
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHasbuster() {
	return hasbuster==null?Boolean.FALSE:hasbuster;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHasflt() {
	return hasflt==null?Boolean.FALSE:hasflt;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHaslna() {
	return haslna==null?Boolean.FALSE:haslna;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 16:57:13)
 * @return int
 */
public int getId_sect() {
	return  idsect.getInt();
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 16:57:13)
 * @return int
 */
public int getIdsect() {
	return  idsect.getInt();
}
/**
 * Insert the method's description here.
 * Creation date: (06.04.2003 13:49:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIshr() {
	return ishr;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getLac() {
	return lac;
}
public String getLachdx() {
	if(lac != null) {
		return LACConverter.toHdx(lac.intValue());
	} else {
		return "";
	}
}
public String getLachex() {
	if(lac != null) {
		return LACConverter.toHex(lac.intValue());
	} else {
		return "";
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLett() {
	return lett;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:59:03)
 * @return java.lang.String
 */
public java.lang.String getNamesect() {
	return namesect;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:30:09)
 * @return java.lang.String
 */
public java.lang.String getNumpo() {
	return numpo;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:01:23)
 * @return java.lang.String
 */
public java.lang.String getNumsect() {
	return numsect;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getPortabis() {
	return portabis.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getPortabisFrm() {
	return portabis.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getTrxnum() {
	return trxnum.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getTrxnum2() {
	return trxnum2.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getTrxnum2Frm() {
	return trxnum2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getTrxnumFrm() {
	return trxnum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getTrxovrnum() {
	return trxovrnum.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getTrxovrnumFrm() {
	return trxovrnum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:41:36)
 * @return java.lang.String
 */
public java.math.BigDecimal getTxovrsetpwr() {
	return txovrsetpwr.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:41:36)
 * @return java.lang.String
 */
public String getTxovrsetpwrFrm() {
	return txovrsetpwr.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:41:36)
 * @return java.lang.String
 */
public java.math.BigDecimal getTxpwr() {
	return txpwr.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:41:36)
 * @return java.lang.String
 */
public java.math.BigDecimal getTxpwr2() {
	return txpwr2.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:41:36)
 * @return java.lang.String
 */
public String getTxpwr2Frm() {
	return txpwr2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:41:36)
 * @return java.lang.String
 */
public String getTxpwrFrm() {
	return txpwr.getString() ;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {

    try {
        super.initRecord(request); //refresh baseStation

        if (getBaseStation().getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D)) {
            namesect = "";
            numsect = "";
            cellid = "";
            cellname = "";
        } else {
            namesect = getBaseStation().getName();
            numsect = "";
            if(getBaseStation().getPrefixcellid() != null) {
	            cellid = String.valueOf(getBaseStation().getPrefixcellid());
            } else {
	            cellid = "";
            }
            
            cellname = String.valueOf(getBaseStation().getNumber());
        }

        if (band.isEmpty()) {
            if (getBaseStation().getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D)) {
                band.setShort(BaseStationObject.BAND_CHECK_DAMPS_800);
            } else {
                band.setShort(new Short(BaseStationObject.BAND_CHECK_GSM_900));
            }

        }
        btsnumber = "BTS_";

        ishr = Boolean.FALSE;
        capgprs = Boolean.FALSE;

        setAzimutFrm("");
        setDdk(Boolean.FALSE);
        setIdsect(0);

        trxnum = new StringAndInteger();
        trxnum2 = new StringAndInteger();
        trxovrnum = new StringAndInteger();

        txpwr = new StringAndBigDecimal(6, 2);
        //public java.math.BigDecimal txpwr2;
        txpwr2 = new StringAndBigDecimal(6, 2);
        txovrsetpwr = new StringAndBigDecimal(6, 2);

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 15:58:16)
 */
public void prepareCopy(javax.servlet.http.HttpServletRequest request) {
    try {
        if (getBaseStation()
            .getStationType()
            .equals(BaseStationObject.TYPE_CHECK_DAMPS_D)) {

            namesect = "";
            numsect = "";
        } else {
            namesect = getBaseStation().getName() + "_";
            numsect = getBaseStation().getNumber() + "";
        }
        setState(APPStates.SECT_COPY);
        DebugSupport.printlnTest("!!!!SectorForm prepareCopy state=" + getState());
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 15:58:16)
 */
public void prepareEdit(javax.servlet.http.HttpServletRequest request) {
   
setState(APPStates.SECT_EDIT);
DebugSupport.printlnTest("!!!!SectorForm prepareEdit state="+getState());        
 
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setAzimut(java.math.BigDecimal arg) {

azimut.setBigDecimal(arg);
	
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setAzimutFrm(String arg) {
azimut.setString(arg);
	
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:43:01)
 * @param newBand short
 */
public void setBand(short newBand) {
	band.setShort(newBand);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:43:01)
 * @param newBand short
 */
public void setBandFrm(String newBand) {
    band.setString(newBand);
   // DebugSupport.printlnTest(
     //   "setBandFrm(" + newBand + ") band.getshort" + band.getshort());
}
public void setBtsnumber(java.lang.String newBtsnumber) {
	if(newBtsnumber == null) {
		btsnumber = "";
	} else {
		btsnumber = newBtsnumber;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2003 13:57:17)
 * @param newByhand java.lang.Boolean
 */
public void setByhand(java.lang.Boolean newByhand) {
	byhand = newByhand;
}
/**
 * Insert the method's description here.
 * Creation date: (06.04.2003 13:49:33)
 * @param newCapgprs java.lang.Boolean
 */
public void setCapgprs(java.lang.Boolean newCapgprs) {
	capgprs = newCapgprs;
}
/**
 * 
 * @param newCellid java.lang.String
 */
public void setCellid(java.lang.String newCellid) {
	cellid = newCellid;
}
/**
 * 
 * @param newCellname java.lang.String
 */
public void setCellname(java.lang.String newCellname) {
	cellname = newCellname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.04.2003 18:07:36)
 * @param newConabis java.lang.String
 */
public void setConabis(java.lang.String newConabis) {
	conabis = newConabis;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:20:21)
 * @param newConf java.lang.String
 */
public void setConf(java.lang.String newConf) {
	conf = newConf;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 17:25:11)
 * @param newDatasource java.lang.String
 */
public void setDatasource(java.lang.String newDatasource) {
	datasource = newDatasource;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @param newHasflt java.lang.Boolean
 */
public void setDdk(java.lang.Boolean ddk_) {
	ddk = ddk_;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2003 20:39:26)
 * @param newEquipcomment java.lang.String
 */
public void setEquipcomment(java.lang.String newEquipcomment) {
	equipcomment = newEquipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @param newBaseStation com.hps.july.persistence.BaseStationAccessBean
 */
public void setEquipment(
    com.hps.july.persistence.BaseStationAccessBean newBaseStation)
    throws Exception {
    try {
        setBaseStation(newBaseStation);
        setBscode(new Integer(getBaseStation().getStorageplace()));
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @param newHasbuster java.lang.Boolean
 */
public void setHasbuster(java.lang.Boolean newHasbuster) {
	hasbuster = newHasbuster;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @param newHasflt java.lang.Boolean
 */
public void setHasflt(java.lang.Boolean newHasflt) {
	hasflt = newHasflt;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 22:32:40)
 * @param newHaslna java.lang.Boolean
 */
public void setHaslna(java.lang.Boolean newHaslna) {
	haslna = newHaslna;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 17:03:45)
 * @param i int
 */
public void setIdsect(int i) throws Exception {
	idsect.setInt(i);
	//fillBaseStation();
	}
/**
 * Insert the method's description here.
 * Creation date: (06.04.2003 13:49:33)
 * @param newIshr java.lang.Boolean
 */
public void setIshr(java.lang.Boolean newIshr) {
	ishr = newIshr;
}
/**
 * 
 * @param newLac java.lang.Integer
 */
public void setLac(java.lang.Integer newLac) {
	lac = newLac;
}
/**
 * 
 * @param newLett java.lang.String
 */
public void setLett(java.lang.String newLett) {
	lett = newLett;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 11:59:03)
 * @param newNamesect java.lang.String
 */
public void setNamesect(java.lang.String newNamesect) {
	namesect = newNamesect;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:30:09)
 * @param newNumpo java.lang.String
 */
public void setNumpo(java.lang.String newNumpo) {
	numpo = newNumpo;
}
public void setNumsect(java.lang.String newNumsect) {
	numsect = newNumsect;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setPortabis(Integer newPortabis) {
	portabis.setInteger(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setPortabisFrm(String newPortabis) {
	portabis.setString(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setTrxnum(Integer newPortabis) {
	trxnum.setInteger(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setTrxnum2(Integer newPortabis) {
	trxnum2.setInteger(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setTrxnum2Frm(String newPortabis) {
	trxnum2.setString(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setTrxnumFrm(String newPortabis) {
	trxnum.setString(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setTrxovrnum(Integer newPortabis) {
	trxovrnum.setInteger(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 12:26:14)
 * @param newPortabis com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setTrxovrnumFrm(String newPortabis) {
	trxovrnum.setString(newPortabis);
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setTxovrsetpwr(java.math.BigDecimal arg) {

txovrsetpwr.setBigDecimal(arg);
	
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setTxovrsetpwrFrm(String arg) {
txovrsetpwr.setString(arg);
	
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setTxpwr(java.math.BigDecimal arg) {

txpwr.setBigDecimal(arg);
	
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setTxpwr2(java.math.BigDecimal arg) {

txpwr2.setBigDecimal(arg);
	
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setTxpwr2Frm(String arg) {
txpwr2.setString(arg);
	
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2003 13:42:39)
 * @param arg java.lang.String
 */
public void setTxpwrFrm(String arg) {
txpwr.setString(arg);
	
}
public void validateValues(ActionErrors errors) throws Exception {
	if("Add".equals(getAction())) {
		if(getCellid() == null || getCellid().length() == 0) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid"));
		} else if(getCellid().length() > 5) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid.length"));
		} else if(getLett() == null || getLett().length() == 0) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.lett"));
		} else if(getLett().length() > 1 || !Character.isDigit(getLett().charAt(0))) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.lett.length"));
		} else {
			numsect = getCellid() + getLett();
		}
	} else {
		if(getCellid() == null || getCellid().length() == 0) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid"));
		} else if(getCellid().length() > 5) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid.length"));
		} else {
			numsect = getCellid();
		}
	}
    if ((getNamesect() == null) || (getNamesect().length() == 0)) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.namesect"));
    }

//    if ((getNumsect() == null) || (getNumsect().length() == 0)) {
//        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.numsect"));
//    } //else if(getNumsect) {

    
	if(azimut.isEmpty()||!azimut.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.azimut",azimut.formatMessage()));
	} else if(azimut.getBigDecimal().doubleValue() < 0.0d || azimut.getBigDecimal().doubleValue() > 360.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.azimut.range"));
	}
      
	if(!this.trxnum.isOk()) {
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.trxnum"));
    }

	if(!this.trxnum2.isOk()) {
	    errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.SectorForm.trxnum2"));
    }

	if(!this.trxovrnum.isOk()) {
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.trxovrnum"));
    }
       
	if (!txovrsetpwr.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txovrsetpwr",txovrsetpwr.formatMessage()));
	}

	if(!txpwr.isEmpty()) {
	    if (!txpwr.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txpwr",txpwr.formatMessage()));
		} else if(txpwr.getBigDecimal().signum() < 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txpwr.less"));
		}
	}

	if(!txpwr2.isEmpty()) {
	    if (!txpwr2.isOk()) {
 	       errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txsetpwr",txpwr2.formatMessage()));
		} else if(txpwr2.getBigDecimal().signum() < 0) {
 	       errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txsetpwr.less"));
		}
	}

	if(!this.portabis.isOk()) {
       errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.portabis"));
	}

	if(btsnumber == null) {
		btsnumber = "";
	}
	
    if (!errors.empty())
        throw new ValidationException();
}
}
