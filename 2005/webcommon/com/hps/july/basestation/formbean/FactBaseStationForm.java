package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.basestation.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.siteinfo.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.constants.*;

import java.util.*;

/**
 * Форма просмотра и редактирования базовой станции
 */
public class FactBaseStationForm
	extends BaseStationForm
{
	private int  basestation;
 
	private String posname;
	private PositionAccessBean position;

	//controller
	private int controllerId;
	private StringAndInteger contrNumber=new StringAndInteger();
	private String contrname;
	private String contrposname;

	//switch
	private int switchId;
	private StringAndInteger switchNumber=new StringAndInteger();
	private String switchname;

	private StringAndInteger number=new StringAndInteger();
	private StringAndInteger prefixcellid=new StringAndInteger();
	private java.lang.String stationName;
	private java.lang.String stationType;
	private java.lang.Boolean repeater;
	private java.lang.String equipmentState;
//	private com.hps.july.persistence.ControllerAccessBean controllers;
	private StringAndShort nstoek=new StringAndShort();
	private StringAndShort e1qty=new StringAndShort();
	private String sttransp;
	private String timebackup;

	private StringAndShort netstage=new StringAndShort();//??
    
	private String contype;
    
	private String onair;
    
	private StringAndSqlDateProperty datebldbeg=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty datebldbeg2=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateassembafs=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateassembafs2=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateassemb=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateassemb2=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty datepr=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty datepr2=new StringAndSqlDateProperty();

	private StringAndSqlDateProperty datetest=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateconnect=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateonair=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty datetest2=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateconnect2=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateonair2=new StringAndSqlDateProperty();

	private StringAndBigDecimal pwrval=new StringAndBigDecimal(4,2);
	private String equipcomment=null;
    
	private String pwrcat;

	private boolean checkPosition = true;
	private java.lang.String datasource;
/**
 */
public FactBaseStationForm()
{
}
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	BaseStationAccessBean bs = (BaseStationAccessBean)bean;
	bs.setOnair(new Boolean(onair.equals(BaseStationObject.ONAIR_CHECK_Y)));
	bs.setDatasource(0);
}
public boolean canEditFact(String user) {
	try {
		int regionid = getPositionForm().getRegionProp().getInt();
		RegionAccessPermitions rap = RegionAccessPermitions.getForRegion(user,regionid);
		return rap.isEditFact();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
}
/**
 */
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws java.lang.Exception
{
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
        setBasestation(keyGen.getNextKey(TablesRef.BASESTATIONS));
		request.setAttribute("basestation", new Integer(getBasestation()));
		//for next action
        BaseStationAccessBean bean = new BaseStationAccessBean(
        /*int argStorageplace,*/ getBasestation(),
        /*Integer argDivision,*/ null,
        /*String argName,*/ getName(),
        /*String argAddress,*/ null,
        /*Integer argPosition,*/ new Integer(getPositionForm().getStorageplace()),
        /*String argType,*/ getStationType(),
        /*Boolean argRepeater,*/ getRepeater(),
        /*Integer argNumber,*/ new Integer(getNumber()),
        /*String argSName*/ getStationName()
        );

        return bean;
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		return null;
	}
}
public String editable(String name, HttpServletRequest request) {
	Object o = request.getSession().getAttribute(AppConstants.APP_HOME);
	if(o == null) {
		return "true";
	}
    int appHome = ((Integer)o).intValue();
    if (getAction().equals("View") || getAction().equals("Edit")) {
        if (name.equals("positionFields") || name.equals("stationType")) {
            DebugSupport.printlnTest("editable name=" + name + " false");
            return "false";
        }
    } else
        if (appHome == Applications.SITEINFO && name.equals("positionFields")) {
            return "false";
        }

    DebugSupport.printlnTest("editable name=" + name + " true");
    return "true";
}
public String editable(String name, javax.servlet.jsp.PageContext page) {
	int apphome = ParamsParser.getRootApp(page);
	if("View".equals(getAction()) || "Edit".equals(getAction())) {
		if("positionFileds".equals(name) || "stationType".equals(name)) {
			return "false";
		}
	} else {
		if(Applications.SITEINFO == apphome && "positionFields".equals(name)) {
			return "false";
		}
	}

    return "true";
	
	/*
	Object o = request.getSession().getAttribute(AppConstants.APP_HOME);
	if(o == null) {
		return "true";
	}
    int appHome =
        ((Integer)o).intValue();
    if (getAction().equals("View") || getAction().equals("Edit")) {

        if (name.equals("positionFields") || name.equals("stationType")) {
            DebugSupport.printlnTest("editable name=" + name + " false");
            return "false";
        }

    } else
        if (appHome == Applications.SITEINFO && name.equals("positionFields")) {
            return "false";
        }

    DebugSupport.printlnTest("editable name=" + name + " true");
    return "true";
    */
}
public void fillPositionForm(PositionAccessBean newPosition) throws Exception {
	try {
//		DebugSupport.printlnTest("FactBaseStation fillPositionForm started");
		BeanUtils.copyProperties(getPositionForm(), newPosition);
//		DebugSupport.printlnTest("FactBaseStation fillPositionForm after copyProperties");
		getPositionForm().fillRecord(newPosition);
//		DebugSupport.printlnTest("FactBaseStation fillPositionForm after getPositionForm().fillRecord(newPosition)");
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
    }
}
public void fillRecord(AbstractEntityAccessBean bean) {
    try {
        DebugSupport.printlnTest("FactBaseStationForm fillRecord started");
        BaseStationAccessBean bs = (BaseStationAccessBean) bean;
        setBasestation(bs.getStorageplace());
        PositionAccessBean pb = new PositionAccessBean(getPosition());
        pb.refreshCopyHelper();

        fillPositionForm(pb);

        if (bs.getOnair() == null || !bs.getOnair().booleanValue()) {
            onair = BaseStationObject.ONAIR_CHECK_N;
        } else {
            onair = BaseStationObject.ONAIR_CHECK_Y;
        }

		setDatasource("Внесено вручную");
        
		DebugSupport.printlnTest("FactBaseStationForm fillRecord finished");
    } catch (Exception e) {
        DebugSupport.printlnError(e, "fillRecord()", this, "fillPositionForm(getPosition());");
    }
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
public Enumeration getAntennes() {
    try {
        return new AntennaAccessBean().findByEquipmentOrderByNumAsc(new Integer(getBasestation()));
    } catch (javax.ejb.FinderException e) {
        return new java.util.Vector().elements();
    } catch (Exception e1) {
	    e1.printStackTrace(System.out);
        return new java.util.Vector().elements();
//        new com.hps.july.jdbcpersistence.lib.DebugSupport().printlnError(e1,"findAntennes()",this);
//        throw new ServletException(e1);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 17:21:57)
 * @return int
 */
public int getBasestation() {
	return basestation;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 21:20:36)
 * @return java.lang.String
 */
public java.lang.String getContrname() {
	return contrname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:57:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getContrNumber() {
	return contrNumber.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:15)
 * @return java.lang.String
 */
public java.lang.String getContrNumberFrm() {
	return contrNumber.getString();
}
public Controller getController()
	throws Exception
{
	ControllerAccessBean cntr = null;
//	if (!contrNumber.isEmpty()) {
		cntr = ControllerModel.getFromIdAndNumber(getControllerId(),getContrNumber());
		setController(cntr);
//	}
	if(cntr != null) {
		return (Controller)cntr.getEJBRef();
	} else {
		return null;
	}
}
/**
 * 
 * @return int
 */
public int getControllerId() {
	return controllerId;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 21:21:07)
 * @return java.lang.String
 */
public java.lang.String getContrposname() {
	return contrposname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:24:18)
 * @return java.lang.String
 */
public java.lang.String getContype() {
	return contype==null?BaseStationObject.CONTYPE_CHECK_OPTIC:contype;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
	try {
		if (basestation == 0) {
			basestation = ((FactBaseStationForm)request.getSession().getAttribute("FactBaseStationForm")).getBasestation();
		}
		DebugSupport.printlnTest("FactBaseStationForm getDataBean basestation=" + basestation);
		BaseStationAccessBean bean = new BaseStationAccessBean();
		bean.setInitKey_storageplace(getBasestation());
		bean.refreshCopyHelper();
		return bean;
    } catch (Exception e) {
		DebugSupport.printlnError(e,"getDataBean getBasestation()=" + getBasestation(),this);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 16:47:41)
 * @return java.lang.String
 */
public java.lang.String getDatasource() {
	return datasource;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 14:10:54)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 public StringAndSqlDateProperty datebldbeg;
    public StringAndSqlDateProperty datebldbeg2;
    public StringAndSqlDateProperty dateassembafs;
    public StringAndSqlDateProperty dateassembafs2;
    public StringAndSqlDateProperty dateassemb;
    public StringAndSqlDateProperty dateassemb2;
    public StringAndSqlDateProperty datepr;
    public StringAndSqlDateProperty datepr2;
 */
public java.sql.Date getDateassemb() {
	return dateassemb.getSqlDate();
}
public java.sql.Date getDateassemb2() {
	return dateassemb2.getSqlDate();
}
public String getDateassemb2Frm() {
	return dateassemb2.getString();
}
public java.sql.Date getDateassembafs() {
	return dateassembafs.getSqlDate();
}
public java.sql.Date getDateassembafs2() {
	return dateassembafs2.getSqlDate();
}
public String getDateassembafs2Frm() {
	return dateassembafs2.getString();
}
public String getDateassembafsFrm() {
	return dateassembafs.getString();
}
public String getDateassembFrm() {
	return dateassemb.getString();
}
public java.sql.Date getDatebldbeg() {
	return datebldbeg.getSqlDate();
}
public java.sql.Date getDatebldbeg2() {
	return datebldbeg2.getSqlDate();
}
public String getDatebldbeg2Frm() {
	return datebldbeg2.getString();
}
public String getDatebldbegFrm() {
	return datebldbeg.getString();
}
public java.sql.Date getDateconnect() {
	return dateconnect.getSqlDate();
}
public java.sql.Date getDateconnect2() {
	return dateconnect2.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 21:39:36)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateconnect2Frm() {
	return dateconnect2.getString();
}
public String getDateconnectFrm() {
	return dateconnect.getString();
}
public java.sql.Date getDateonair() {
	return dateonair.getSqlDate();
}
public java.sql.Date getDateonair2() {
	return dateonair2.getSqlDate();
}
public String getDateonair2Frm() {
	return dateonair2.getString();
}
public String getDateonairFrm() {
	return dateonair.getString();
}
public java.sql.Date getDatepr() {
	return datepr.getSqlDate();
}
public java.sql.Date getDatepr2() {
	return datepr2.getSqlDate();
}
public String getDatepr2Frm() {
	return datepr2.getString();
}
public String getDateprFrm() {
	return datepr.getString();
}
public java.sql.Date getDatetest() {
	return datetest.getSqlDate();
}
public java.sql.Date getDatetest2() {
	return datetest2.getSqlDate();
}
public String getDatetest2Frm() {
	return datetest2.getString();
}
public String getDatetestFrm() {
	return datetest.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 10:15:27)
 * @return java.lang.Short
 */
public Short getE1qty() {
	return e1qty.getShort();
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 10:15:27)
 * @return java.lang.Short
 */
public String getE1qtyFrm() {
	return e1qty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2003 21:37:25)
 * @return java.lang.String
 */
public java.lang.String getEquipcomment() {
	return equipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:50:43)
 * @return java.lang.String
 */
public java.lang.String getEquipmentState() {
	return equipmentState==null?BaseStationObject.STATE_CHECK_WORK_W:equipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return stationName;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 14:08:53)
 * @return java.lang.Short
 */
public java.lang.Short getNetstage() {
	return netstage.getShort();
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 9:54:23)
 * @return java.lang.Short
 */
public String getNetstageFrm() {
	return netstage.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 9:54:23)
 * @return java.lang.Short
 */
public Short getNstoek() {
	return nstoek.getShort();
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 9:54:23)
 * @return java.lang.Short
 */
public String getNstoekFrm() {
	return nstoek.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:05:22)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public int getNumber() {
	return number.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:05:22)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getNumberFrm() {
	return number.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:53:21)
 * @return java.lang.Boolean
 */
public String getOnair() {
	return onair==null?BaseStationObject.ONAIR_CHECK_N:onair;
}
public Position getPosition()
	throws Exception
{
	DebugSupport.printlnTest("FactBaseStationForm getPosition started");
	//DebugSupport.printlnTest("FactBaseStationForm getPosition getPositionForm().getStorageplace()="+position.getStorageplace());
	if (position == null) {
		position = new PositionAccessBean();
		position.setInitKey_storageplace(getPositionForm().getStorageplace());
		position.refreshCopyHelper();
	}
	DebugSupport.printlnTest("FactBaseStationForm getPosition finished position.getStorageplace()="+position.getStorageplace());
	return (Position) position.getEJBRef();
}
public Integer getPrefixcellid() {
	return prefixcellid.getInteger();
}
public String getPrefixcellidFrm() {
	return prefixcellid.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:49:43)
 * @return java.lang.String
 */
public java.lang.String getPwrcat() {
	return pwrcat;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:45:38)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPwrval() {
	return pwrval.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:45:38)
 * @return java.lang.String
 */
public java.lang.String getPwrvalFrm() {
	return pwrval.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:03:05)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getRepeater() {
	return repeater==null?Boolean.FALSE:repeater;
}
public Iterator getRepeaters() {
	try {
		return new CDBCEquipmentObject().listBSRepeaters(new Integer(getBasestation())).listIterator();
	} catch (Exception e1) {
		e1.printStackTrace(System.out);
		return new java.util.ArrayList().iterator();
	}
}
/**
 * Выдаёт список секторов для текущей базовой станции
 * @return java.util.Iterator - коллекция CDBCRowObject
 */
public Iterator getSectors() {
	CDBCEquipmentObject o = new CDBCEquipmentObject();
	CDBCResultSet rs = o.findBaseStationSectors(new Integer(getBasestation()), new Integer(1));
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {

int state=getAction().equals("View")?APPStates.BS_FVIEW:APPStates.BS_FEdit;


	
    DebugSupport.printlnTest(
        "FactBaseStationForm getState()="
            + state);

    return state;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:26:16)
 * @return java.lang.String
 */
public java.lang.String getStationName() {
	return stationName;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:02:21)
 * @return java.lang.String
 */
public java.lang.String getStationType() {
	return stationType;
}
public Switch getSwitch()
	throws Exception
{
	SwitchAccessBean sw = null;
	if (!switchNumber.isEmpty()) {
		sw = SwitchModel.getFromIdAndNumber(getSwitchId(),getSwitchNumber());
		setSwitch(sw);
	}
	if(sw != null) {
		return (Switch)sw.getEJBRef();
	} else {
		return null;
	}
}
/**
 * 
 * @return int
 */
public int getSwitchId() {
	return switchId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSwitchname() {
	return switchname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getSwitchNumber() {
	return switchNumber.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:54)
 * @return java.lang.String
 */
public java.lang.String getSwitchNumberFrm() {
	return switchNumber.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:34:42)
 * @return java.lang.String
 */
public java.lang.String getTimebackup() {
	return timebackup;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
//    setPosition(null);	    
    getPositionForm().initRecord(request);

    fillPositionForm(request);//for siteinfo

    setContrNumberFrm("");
    contrname = "";
    contrposname = "";
    setContype("");
    setDateassemb(null);
    setDateassemb2(null);
    setDateassembafs(null);
    setDateassembafs2(null);
    setDatebldbeg(null);
    setDatebldbeg2(null);
    setDateconnect(null);
    setDateconnect2(null);
    setDateonair(null);
    setDateonair2(null);
    setDatepr(null);
    setDatepr2(null);
    setDatetest(null);
    setDatetest2(null);
    setE1qtyFrm("");
    setName("");
    setNetstageFrm("");
    setNstoekFrm("");
    setNumberFrm("");
    setPwrcat("");
    setPwrvalFrm("");
    setStationName("");
    setStationType("");
    setSwitchNumberFrm("");
    setSwitchname("");
    setTimebackup("");
    setCheckPosition(true);
    setOnair(BaseStationObject.ONAIR_CHECK_N);
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2003 10:55:38)
 * @return boolean
 */
public boolean isCheckPosition() {
	return checkPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (14.04.2003 22:31:31)
 * @return boolean
 * @param id java.lang.String
 */
public boolean isEditable(String id,HttpServletRequest request) {
	return editable(id,request).equals("true");
}
public boolean isEditable(String id,javax.servlet.jsp.PageContext context) {
	return editable(id,context).equals("true");
}
/**
 * Insert the method's description here.
 * Creation date: (22.03.2003 19:22:19)
 */
public void prepareCopy(javax.servlet.http.HttpServletRequest request)
{
	try{
		//setPositionForm(null);
		getPositionForm().initRecord(request);
		setNumberFrm("");
		setStationName("");
	} catch(Exception e) {
		e.printStackTrace();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 17:21:57)
 * @param newBasestation int
 */
public void setBasestation(int newBasestation) {
	basestation = newBasestation;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2003 10:55:38)
 * @param newCheckPosition boolean
 */
public void setCheckPosition(boolean newCheckPosition) {
	checkPosition = newCheckPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 21:20:36)
 * @param newContrname java.lang.String
 */
public void setContrname(java.lang.String newContrname) {
	contrname = newContrname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:15)
 * @param newContrNumberFrm java.lang.String
 */
public void setContrNumberFrm(java.lang.String newContrNumberFrm) {
	contrNumber.setString(newContrNumberFrm);
}
public void setController(ControllerAccessBean newController) throws Exception {
	if (newController == null) {
	    controllerId = 0;
	    contrNumber.setString("");
	    contrposname = "";
	    contrname = "";
	}
	else {
	    controllerId = newController.getStorageplace();
	    contrNumber.setInteger(new Integer(newController.getNumber()));
		contrname = newController.getControllerName();
	    contrposname = newController.getPosition().getName();
	}
}
/**
 * 
 * @param newControllerId int
 */
public void setControllerId(int newControllerId) {
	controllerId = newControllerId;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 21:21:07)
 * @param newContrposname java.lang.String
 */
public void setContrposname(java.lang.String newContrposname) {
	contrposname = newContrposname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:24:18)
 * @param newContype java.lang.String
 */
public void setContype(java.lang.String newContype) {
	contype = newContype;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 16:47:41)
 * @param newDatasource java.lang.String
 */
public void setDatasource(java.lang.String newDatasource) {
	datasource = newDatasource;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 14:10:54)
 * @param newDateassemb com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateassemb(java.sql.Date newDate) {
	dateassemb.setSqlDate(newDate);
}
public void setDateassemb2(java.sql.Date newDate) {
	dateassemb2.setSqlDate(newDate);
}
public void setDateassemb2Frm(String newDate) {
	dateassemb2.setString(newDate);
}
public void setDateassembafs(java.sql.Date newDate) {
	dateassembafs.setSqlDate(newDate);
}
public void setDateassembafs2(java.sql.Date newDate) {
	dateassembafs2.setSqlDate(newDate);
}
public void setDateassembafs2Frm(String newDate) {
	dateassembafs2.setString(newDate);
}
public void setDateassembafsFrm(String newDate) {
	dateassembafs.setString(newDate);
}
public void setDateassembFrm(String newDate) {
	dateassemb.setString(newDate);
}
public void setDatebldbeg(java.sql.Date newDate) {
	datebldbeg.setSqlDate(newDate);
}
public void setDatebldbeg2(java.sql.Date newDate) {
	datebldbeg2.setSqlDate(newDate);
}
public void setDatebldbeg2Frm(String newDate) {
	datebldbeg2.setString(newDate);
}
public void setDatebldbegFrm(String newDate) {
	datebldbeg.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 21:39:36)
 * @param newDateconnect com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateconnect(java.sql.Date newDateconnect) {
	dateconnect.setSqlDate(newDateconnect);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 21:39:36)
 * @param newDateconnect com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateconnect2(java.sql.Date newDateconnect) {
	dateconnect2.setSqlDate(newDateconnect);
}
public void setDateconnect2Frm(String newDate) {
	dateconnect2.setString(newDate);
}
public void setDateconnectFrm(String newDate) {
	dateconnect.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 21:39:36)
 * @param newDateonair com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateonair(java.sql.Date newDateonair) {
	dateonair.setSqlDate(newDateonair);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 21:39:36)
 * @param newDateonair com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateonair2(java.sql.Date newDateonair) {
	dateonair2.setSqlDate(newDateonair);
}
public void setDateonair2Frm(String newDate) {
	dateonair2.setString(newDate);
}
public void setDateonairFrm(String newDate) {
	dateonair.setString(newDate);
}
public void setDatepr(java.sql.Date newDate) {
	datepr.setSqlDate(newDate);
}
public void setDatepr2(java.sql.Date newDate) {
	datepr2.setSqlDate(newDate);
}
public void setDatepr2Frm(String newDate) {
	datepr2.setString(newDate);
}
public void setDateprFrm(String newDate) {
	datepr.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 21:39:36)
 * @param newDatetest com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDatetest(java.sql.Date newDatetest) {
	datetest.setSqlDate(newDatetest);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 21:39:36)
 * @param newDatetest com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDatetest2(java.sql.Date newDatetest) {
	datetest2.setSqlDate(newDatetest);
}
public void setDatetest2Frm(String newDate) {
	datetest2.setString(newDate);
}
public void setDatetestFrm(String newDate) {
	datetest.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 10:15:27)
 * @param newE1qty java.lang.Short
 */
public void setE1qty(java.lang.Short newE1qty) {
	e1qty.setShort(newE1qty);
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 10:15:27)
 * @param newE1qty java.lang.Short
 */
public void setE1qtyFrm(String newE1qty) {
	e1qty.setString(newE1qty);
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2003 21:37:25)
 * @param newEquipcomment java.lang.String
 */
public void setEquipcomment(java.lang.String newEquipcomment) {
	equipcomment = newEquipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:50:43)
 * @param newEquipmentState java.lang.String
 */
public void setEquipmentState(java.lang.String newEquipmentState) {
	equipmentState = newEquipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	stationName = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 14:08:53)
 * @param newNetstage java.lang.Short
 */
public void setNetstage(java.lang.Short newNetstage) {
	netstage.setShort(newNetstage);
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 9:54:23)
 * @return java.lang.Short
 */
public void setNetstageFrm(String ns) throws Exception {
    netstage.setString(ns);
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 9:54:23)
 * @param newNstoek java.lang.Short
 */
public void setNstoek(java.lang.Short newNstoek) {
	nstoek.setShort(newNstoek);
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 9:54:23)
 * @return java.lang.Short
 */
public void setNstoekFrm(String ns) throws Exception {
    nstoek.setString(ns);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:05:22)
 * @param newNumber com.hps.july.web.util.StringAndIntegerProperty
 */
public void setNumber(int newNumber) {
	number.setInteger(new Integer(newNumber));
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:05:22)
 * @param newNumber com.hps.july.web.util.StringAndIntegerProperty
 */
public void setNumber(Integer newNumber) {
	number.setInteger(newNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:05:22)
 * @param newNumber com.hps.july.web.util.StringAndIntegerProperty
 */
public void setNumberFrm(String newNumber) {
	number.setString(newNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:53:21)
 * @param newOnair java.lang.Boolean
 */
public void setOnair(String newOnair) {
	onair = newOnair;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 18:18:31)
 * @param newPosition com.hps.july.persistence.Position
 */
public void setPosition(PositionAccessBean newPosition) throws Exception {
	position = newPosition;
}
public void setPrefixcellid(Integer newNumber) {
	prefixcellid.setInteger(newNumber);
}
public void setPrefixcellidFrm(String newNumber) {
	prefixcellid.setString(newNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:49:43)
 * @param newPwrcat java.lang.String
 */
public void setPwrcat(java.lang.String newPwrcat) {
	pwrcat = newPwrcat;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:45:38)
 * @param newPwrval java.math.BigDecimal
 */
public void setPwrval(java.math.BigDecimal newPwrval) {
	pwrval.setBigDecimal(newPwrval);
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:45:38)
 * @param newPwrvalFrm java.lang.String
 */
public void setPwrvalFrm(java.lang.String newPwrvalFrm) {
	pwrval.setString(newPwrvalFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:03:05)
 * @param newRepeater java.lang.Boolean
 */
public void setRepeater(java.lang.Boolean newRepeater) {
	repeater = newRepeater;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @param newName java.lang.String
 */
public void setStationName(java.lang.String newName) {
    stationName = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 22:02:21)
 * @param newStationType java.lang.String
 */
public void setStationType(java.lang.String newStationType) {
	stationType = newStationType.trim().length()==0?null:newStationType;
}
/**
 * Insert the method's description here.
 * Creation date: (11.03.2003 17:21:57)
 * @param newBasestation int
 */
public void setStorageplace(int newBasestation) {
	basestation = newBasestation;
}
public void setSwitch(SwitchAccessBean newSwitch) throws Exception {
	if (newSwitch == null) {
		setSwitchId(0);
	    setSwitchNumberFrm("");
	    setSwitchname("");
	} else {
		setSwitchId(newSwitch.getStorageplace());
		setSwitchNumber(new Integer(newSwitch.getNumber()));
		setSwitchname(PositionModel.getPositionFullName(newSwitch.getPosition()));
	}
}
/**
 * 
 * @param newSwitchId int
 */
public void setSwitchId(int newSwitchId) {
	switchId = newSwitchId;
}
/**
 * 
 * @param newSwitchname java.lang.String
 */
public void setSwitchname(java.lang.String newSwitchname) {
	switchname = newSwitchname;
}
public void setSwitchNumber(Integer newSwitchNumber) {
	switchNumber.setInteger(newSwitchNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:54)
 * @param newSwitchNumberFrm java.lang.String
 */
public void setSwitchNumberFrm(java.lang.String newSwitchNumberFrm) {
	switchNumber.setString(newSwitchNumberFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 21:34:42)
 * @param newTimebackup java.lang.String
 */
public void setTimebackup(java.lang.String newTimebackup) {
	timebackup = newTimebackup;
}
public void validateValues(ActionErrors errors)
	throws Exception
{
	//position
	if (isCheckPosition()) {
		try {
//			DebugSupport.printlnTest("FactBaseStation validateValues position=" + position);
			position = null;
			getPosition();
			//if(position==null)throw new Exception();
		} catch (Exception ex) {
			DebugSupport.printlnError(ex, "FactBaseStation validateValues position");
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.position"));
		}
	}

    if (number.isEmpty() || !number.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.number"));
	}

	if ((getName() == null) || (getName().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.basestation.name"));
	}

	if (stationType == null || stationType.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.basestation.type"));
    }

	if(BaseStationObject.TYPE_CHECK_DAMPS_D.equals(stationType)) {
		// Должен быть установлен коммутатор и не должно быть контроллера
		try {
			getSwitch();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.switch"));
		}
		setController(null);
	} else if(BaseStationObject.TYPE_CHECK_DCS_C.equals(stationType) ||	BaseStationObject.TYPE_CHECK_GSM_G.equals(stationType) || BaseStationObject.TYPE_CHECK_GSM_S.equals(stationType)) {
		// Должен быть установлен контроллер и коммутатор взят из контроллера
		try {
			Controller c = getController();
			if(c != null) {
				Switch s = c.getSwitch();
				if(s != null) {
					setSwitch(new SwitchAccessBean(s));
				}
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.controller"));
		}
	    try {
	        getSwitch();
	    } catch (Exception ex) {
			ex.printStackTrace(System.out);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.switch"));
	    }
	}

	if (!e1qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.e1qty"));
	}
	
	if (!nstoek.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.nstoek"));
	}

	if (!pwrval.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.pwrval", pwrval.formatMessage()));
	}

	if (!netstage.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.netstage"));
	}

    if (!errors.empty())
        throw new ValidationException();
}
}
