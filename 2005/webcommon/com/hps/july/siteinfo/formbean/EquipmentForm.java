package com.hps.july.siteinfo.formbean;

import com.hps.july.cdbc.objects.*;
import com.hps.july.persistence2.*;
import javax.ejb.EJBObject;
import com.hps.july.trailcom.beans.*;
import java.util.*;
import com.hps.july.siteinfo.valueobject.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.lib.*;

/**
 * Форма редактирования оборудования на позиции
 */
public class EquipmentForm extends com.hps.july.web.util.EditForm {
	
	private java.lang.Integer poscode;
	private java.lang.String posname;
	private java.lang.String complectType;
	private java.lang.String switchType;
	private java.lang.String name;
	private StringAndIntegerProperty number;
	private int storageplace;
	private java.lang.String stationName;
	private java.lang.String stationType;
	private java.lang.Boolean repeater;
	private java.lang.String comEquipmentType;
	private java.lang.String controllerName;
	private java.lang.String otherEquipmentType;
	private java.lang.String equipmentState;
	private StringAndIntegerProperty contrcode;
	private java.lang.String contrname;
	private StringAndIntegerProperty switchcode;
	private java.lang.String switchname;
	private StringAndIntegerProperty comlinecode;
	private java.lang.String comlinename;
	private java.lang.String comlinename2;
	private java.lang.String posid;
	private StringAndIntegerProperty contrNumber;
	private StringAndIntegerProperty switchNumber;
	private java.lang.String contrposname;
	private java.lang.String switchposname;
	private String equipcomment;
	private StringAndIntegerProperty resourcecodeFrm;
	private String resourcefullname;

	public com.hps.july.persistence.PositionAccessBean positions;
	private com.hps.july.persistence.ControllerAccessBean controllers;
	private com.hps.july.persistence.SwitchAccessBean switches;
	private com.hps.july.trailcom.beans.HopAccessBean hop;
	private ResourceAccessBean resource;

	private String osinvname;

	private String beenet_action = "S";
	private String beenet;
	private String beenet_new;
	private StringAndIntegerProperty beenet_new_categid = new StringAndIntegerProperty();
public EquipmentForm() {
	complectType = "N";
	poscode = new Integer(0);
	posname = "";
	name = "";
	number = new StringAndIntegerProperty();
	contrcode = new StringAndIntegerProperty();
	switchcode = new StringAndIntegerProperty();
	comlinecode = new StringAndIntegerProperty();
	contrNumber = new StringAndIntegerProperty();
	switchNumber = new StringAndIntegerProperty();
	storageplace = 0;
	switchType = "1";
	stationType = "D";
	stationName = "";
	comEquipmentType = "R";
	controllerName = "";
	otherEquipmentType = "B";
	equipmentState = "W";

	resourcecodeFrm = new StringAndIntegerProperty();
	resourcefullname = "";
	resource = null;
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) 
	throws Exception
{
	super.afterUpdate(bean,request);
	CDBCBeenetObject bn = new CDBCBeenetObject();
	Integer equ = new Integer(getStorageplace());
	if("S".equals(beenet_action)) {
		// Удалить связи данного оборудования со старыми бинетами.
		bn.deleteEquipmentLinks(equ);
		// Добавить новую связь бинет с этим оборудованием
		bn.updateEquipmentBeenet(beenet,new Integer(getStorageplace()));
	} else
	if("C".equals(beenet_action)) {
		// Удалить связи данного оборудования
		// Добавить новый бинет
		// Добавить связи с новым бинетом
		bn.deleteEquipmentLinks(equ);
		BeenetFacadeAccessBean bf = new BeenetFacadeAccessBean();
		bf.createBeenet(beenet_new,beenet_new_categid.getInteger().intValue(),getPoscode().intValue(),new int[] { getStorageplace() } );
	}
}
/**
 * Метод вызывается перед удалением основной записи.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	CDBCEquipmentObject eo = new CDBCEquipmentObject();
	eo.deleteComEquipment2Beenet(new Integer(getStorageplace()));
	super.beforeDelete(bean,request);
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) 
	throws Exception
{
	super.beforeUpdate(bean,request);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	EquipmentListForm aform = (EquipmentListForm)request.getSession().getAttribute( "EquipmentListForm" );
	setPoscode(new Integer(aform.getStorageplace()));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setStorageplace(keyGen.getNextKey("tables.storageplaces"));
	AbstractEntityAccessBean bean = null;
	if ("A".equals(complectType))
    	bean = new BaseStationAccessBean(getStorageplace(), null, getName(), "", getPoscode(), getStationType(), getRepeater(), new Integer(getNumber()), getStationName()); 
	if ("B".equals(complectType))
    	bean = new ComEquipmentAccessBean(getStorageplace(), null, getName(), "", getPoscode() );
	if ("C".equals(complectType))
    	bean = new ControllerAccessBean(getStorageplace(), null, getName(), "", getPoscode(), new Integer(getNumber()), getControllerName() ); 
	if ("D".equals(complectType))
    	bean = new SwitchAccessBean(getStorageplace(), null, getName(), "", getPoscode(), getSwitchType(), new Integer(getNumber())); 
	if ("E".equals(complectType))
    	bean = new OtherEquipmentAccessBean(getStorageplace(), null, getName(), "", getPoscode(), getOtherEquipmentType() ); 
	if ("F".equals(complectType))
    	bean = new WLANAccessBean(getStorageplace(), null, getName(), "", getPoscode()); 
	return bean;
}
public HopAccessBean constructComlines() throws Exception {

	if (hop == null) {	
		// Construct workers bean
		if (!comlinecode.isEmpty()) 
			if (comlinecode.isOk()) {
				hop = new HopAccessBean();
				hop.setInitKey_hopsid(comlinecode.getInteger().intValue());
				hop.refreshCopyHelper();
			}
	}
	return hop;
}
public ControllerAccessBean constructControllers() throws Exception {

	if (controllers == null) {	
		// Construct workers bean
		if (!contrNumber.isEmpty()) 
			if (contrNumber.isOk()) {
				ControllerAccessBean cntrs = new ControllerAccessBean();
				Enumeration en = cntrs.findByQBE(Boolean.TRUE, getContrNumber(), Boolean.FALSE, "", Boolean.FALSE, new Integer(0), new Integer(1));
				if (en.hasMoreElements())
				  controllers = (ControllerAccessBean)en.nextElement();
			}
	}
	return controllers;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public PositionAccessBean constructPositions() throws Exception {

	if (positions == null) {	
		// Construct workers bean
		if (poscode != null) {
			positions = new PositionAccessBean();
			positions.setInitKey_storageplace(poscode.intValue());
			positions.refreshCopyHelper();
		}
	}
	return positions;
}
public ResourceAccessBean constructResource() throws Exception {

	resource = new ResourceAccessBean();
	resource.setInitKey_resource(resourcecodeFrm.getInteger().intValue());
	resource.refreshCopyHelper();
	
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public ResourceAccessBean constructResoure() throws Exception {

	//if (hop == null) {	
		//// Construct workers bean
		//if (!comlinecode.isEmpty()) 
			//if (comlinecode.isOk()) {
				//hop = new HopAccessBean();
				//hop.setInitKey_hopsid(comlinecode.getInteger().intValue());
				//hop.refreshCopyHelper();
			//}
	//}
	//return hop;
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public SwitchAccessBean constructSwitches() throws Exception {

	if (switches == null) {	
		// Construct workers bean
		if (!switchNumber.isEmpty()) 
			if (switchNumber.isOk()) {
				SwitchAccessBean swchs = new SwitchAccessBean();
				Enumeration en = swchs.findByQBE(Boolean.TRUE, getSwitchNumber(), Boolean.FALSE, "", new Integer(1));
				if (en.hasMoreElements())
				  switches = (SwitchAccessBean)en.nextElement();
			}
	}
	return switches;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	CDBCBeenetObject bn = new CDBCBeenetObject();
	CDBCResultSet rs = bn.findEquipmentBeeNets(new Integer(getStorageplace()),new Integer(1));
	Iterator it = rs.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		beenet = ro.getColumn("beenetid").asString();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBeenet() {
	return beenet;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBeenet_action() {
	return beenet_action;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBeenet_new() {
	return beenet_new;
}
public java.lang.Integer getBeenet_new_categid() {
	return beenet_new_categid.getInteger();
}
public java.lang.String getBeenet_new_categidFrm() {
	return beenet_new_categid.getString();
}
public Iterator getBeenetCategories() {
	CDBCBeenetObject co = new CDBCBeenetObject();
	com.hps.july.cdbc.lib.CDBCResultSet rs = co.findBeeNetCategories();
	return rs.listIterator();
}
public Iterator getBeenets() {
	CDBCBeenetObject co = new CDBCBeenetObject();
	com.hps.july.cdbc.lib.CDBCResultSet rs = co.findPositionBeeNets(getPoscode(),new Integer(1));
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getBsRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteStation");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("siteProjector");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 12:25:02)
 * @return java.lang.String
 */
public java.lang.String getComEquipmentType() {
	return comEquipmentType;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Hop getComline() throws Exception {

	HopAccessBean bean = constructComlines();
	if (bean != null)
	  return (Hop)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:25:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getComlinecode() {
	return comlinecode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:28:54)
 * @return java.lang.String
 */
public java.lang.String getComlinecodeFrm() {
	return comlinecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:25:47)
 * @return java.lang.String
 */
public java.lang.String getComlinename() {
	return comlinename;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:28:35)
 * @return java.lang.String
 */
public java.lang.String getComlinename2() {
	return comlinename2;
}
public Iterator getComlines() {
	CDBCComlinesObject co = new CDBCComlinesObject();
	com.hps.july.cdbc.lib.CDBCResultSet rs = co.findComEquipmentComlines(new Integer(getStorageplace()),getPoscode());
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 17:32:21)
 * @return java.lang.String
 */
public java.lang.String getComplectType() {
	return complectType;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getComRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:28)
 * @return java.lang.Integer
 */
public java.lang.Integer getContrcode() {
	return contrcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:59)
 * @return java.lang.String
 */
public java.lang.String getContrcodeFrm() {
	return contrcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:43)
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
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Controller getController() throws Exception {

	ControllerAccessBean bean = constructControllers();
	if (bean != null)
	  return (Controller)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 12:48:19)
 * @return java.lang.String
 */
public java.lang.String getControllerName() {
	return controllerName;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 10:52:22)
 * @return java.lang.String
 */
public java.lang.String getContrposname() {
	return contrposname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	EquipmentSetAccessBean ebean = new EquipmentSetAccessBean();
	ebean.setInitKey_storageplace( getStorageplace() );
	try {
		ebean.refreshCopyHelper();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	EquipmentObject bean = new EquipmentObject(ebean);
	setComplectType(bean.getEquipmentType());
	return bean.getEquipmentSet();
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2003 21:41:06)
 * @return java.lang.String
 */
public java.lang.String getEquipcomment() {
	return equipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 18:10:57)
 * @return java.lang.String
 */
public java.lang.String getEquipmentState() {
	return equipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:06:50)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:08:03)
 * @return int
 */
public int getNumber() {
	return number.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 9:36:03)
 * @return java.lang.String
 */
public java.lang.String getNumberFrm() {
	return number.getString();
}
public java.lang.String getOsinvname() {
	if(getComEquipmentType() != null && "O".equals(getComEquipmentType())) {
		return osinvname;
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 12:59:58)
 * @return java.lang.String
 */
public java.lang.String getOtherEquipmentType() {
	return otherEquipmentType;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getOtherRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getPoscode() {
	return poscode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 18:09:43)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public com.hps.july.persistence.Position getPosition() throws Exception {

	PositionAccessBean bean = constructPositions();
	if (bean != null)
	  return (com.hps.july.persistence.Position)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:46)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 10:16:51)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getRepeater() {
	return repeater;
}
public com.hps.july.persistence.Resource getResource() throws Exception {
	
	ResourceAccessBean bean = null;
	if(!resourcecodeFrm.isEmpty() && resourcecodeFrm.isOk()) {
		bean = constructResource();
	}
	if (bean != null)
	  return (com.hps.july.persistence.Resource)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (01.10.2003 17:28:15)
 * @return String
 */
public String getResourcecodeFrm() {
	return resourcecodeFrm.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (01.10.2003 17:28:15)
 * @return java.lang.String
 */
public java.lang.String getResourcefullname() {
	return resourcefullname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.EDITEQU;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 9:58:16)
 * @return java.lang.String
 */
public java.lang.String getStationName() {
	return stationName;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 9:58:34)
 * @return java.lang.String
 */
public java.lang.String getStationType() {
	return stationType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:13:39)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Switch getSwitch() throws Exception {

	SwitchAccessBean bean = constructSwitches();
	if (bean != null)
	  return (Switch)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:50:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getSwitchcode() {
	return switchcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:51:14)
 * @return java.lang.String
 */
public java.lang.String getSwitchcodeFrm() {
	return switchcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:51:27)
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
 * Creation date: (18.07.2002 10:52:38)
 * @return java.lang.String
 */
public java.lang.String getSwitchposname() {
	return switchposname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:06:16)
 * @return java.lang.String
 */
public java.lang.String getSwitchType() {
	return switchType;
}
public String getType() {
	String type=null;
	
	if("A".equals(complectType)) {
    	type = "BaseStation"; 
	} else if ("B".equals(complectType)) {
    	type = "ComEquipment"; 
	} else if ("C".equals(complectType)) {
    	type = "Controller"; 
	} else if ("D".equals(complectType)) {
    	type="Switch"; 
	} else if ("E".equals(complectType)) {
    	type="OtherEquipment";
	} else if("F".equals(complectType)) {
    	type = "WLAN";
	} else if("R".equals(complectType)) {
		type = "Repeater";
	}
System.out.println("   ["+type+"]    |");
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	EquipmentListForm aform = (EquipmentListForm)request.getSession().getAttribute( "EquipmentListForm" );
	setPoscode(new Integer(aform.getStorageplace()));
	setPosid(aform.getPosid());
	setPosname(aform.getPosname());
}
/**
 * 
 * @param newBeenet java.lang.String
 */
public void setBeenet(java.lang.String newBeenet) {
	beenet = newBeenet;
}
/**
 * 
 * @param newBeenet_action java.lang.String
 */
public void setBeenet_action(java.lang.String newBeenet_action) {
	beenet_action = newBeenet_action;
}
/**
 * 
 * @param newBeenet_new java.lang.String
 */
public void setBeenet_new(java.lang.String newBeenet_new) {
	beenet_new = newBeenet_new;
}
public void setBeenet_new_categid(java.lang.Integer newId) {
	beenet_new_categid.setInteger(newId);
}
public void setBeenet_new_categidFrm(String newId) {
	beenet_new_categid.setString(newId);
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 12:25:02)
 * @param newComEquipmentType java.lang.String
 */
public void setComEquipmentType(java.lang.String newComEquipmentType) {
	comEquipmentType = newComEquipmentType;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setComline(HopAccessBean newComline) throws Exception {
	try {
		if (newComline == null) {
			//comlinecode.setInteger( new java.lang.Integer(0) );
			comlinecode.setString("");
			comlinename = "";
			comlinename2 = "";
		} else {
			comlinecode.setInteger(new Integer(newComline.getHopsid()));

			EquipmentSetAccessBean equip1 = new EquipmentSetAccessBean();
			equip1.setInitKey_storageplace(newComline.getEquipmentid_enda());
			equip1.refreshCopyHelper();
			comlinename = equip1.getPosition().getName();

			EquipmentSetAccessBean equip2 = new EquipmentSetAccessBean();
			equip2.setInitKey_storageplace(newComline.getEquipmentid_endb());
			equip2.refreshCopyHelper();
			comlinename2 = equip2.getPosition().getName();

			//comlinename = newComline.getPosition().getName();
			//comlinename2 = newComline.getDestinationposition().getName();
		}

	} catch (Exception e) {
		System.out.println("Error in EquipmentForm.setComline");
		e.printStackTrace(System.out);
		throw e;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:25:32)
 * @param newComlinecode java.lang.Integer
 */
public void setComlinecode(java.lang.Integer newComlinecode) {
	comlinecode.setInteger(newComlinecode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:28:54)
 * @param newComlinecodeFrm java.lang.String
 */
public void setComlinecodeFrm(java.lang.String newComlinecodeFrm) {
	comlinecode.setString(newComlinecodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:25:47)
 * @param newComlinename java.lang.String
 */
public void setComlinename(java.lang.String newComlinename) {
	comlinename = newComlinename;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 16:28:35)
 * @param newComlinename2 java.lang.String
 */
public void setComlinename2(java.lang.String newComlinename2) {
	comlinename2 = newComlinename2;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 17:32:21)
 * @param newComplectType java.lang.String
 */
public void setComplectType(java.lang.String newComplectType) {
	complectType = newComplectType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:28)
 * @param newContrcode java.lang.Integer
 */
public void setContrcode(java.lang.Integer newContrcode) {
	contrcode.setInteger(newContrcode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:59)
 * @param newContrcodeFrm java.lang.String
 */
public void setContrcodeFrm(java.lang.String newContrcodeFrm) {
	contrcode.setString(newContrcodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:43)
 * @param newContrname java.lang.String
 */
public void setContrname(java.lang.String newContrname) {
	contrname = newContrname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:57:53)
 * @param newContrNumber java.lang.Integer
 */
public void setContrNumber(java.lang.Integer newContrNumber) {
	contrNumber.setInteger(newContrNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:15)
 * @param newContrNumberFrm java.lang.String
 */
public void setContrNumberFrm(java.lang.String newContrNumberFrm) {
	contrNumber.setString(newContrNumberFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setController(ControllerAccessBean newController) throws Exception {
	if (newController == null) {
	    contrcode.setInteger( new java.lang.Integer(0) );
	    contrNumber.setString("");
	    contrposname = "";
	    contrname = "";
	}
	else {
		contrcode.setInteger( new Integer(newController.getStorageplace()) );
	    contrNumber.setInteger(new Integer(newController.getNumber()));
		contrname = newController.getControllerName();
	    contrposname = newController.getPosition().getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 12:48:19)
 * @param newControllerName java.lang.String
 */
public void setControllerName(java.lang.String newControllerName) {
	controllerName = newControllerName;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 10:52:22)
 * @param newContrposname java.lang.String
 */
public void setContrposname(java.lang.String newContrposname) {
	contrposname = newContrposname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2003 21:41:06)
 * @param newEquipcomment java.lang.String
 */
public void setEquipcomment(java.lang.String newEquipcomment) {
	equipcomment = newEquipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 18:10:57)
 * @param newEquipmentState java.lang.String
 */
public void setEquipmentState(java.lang.String newEquipmentState) {
	equipmentState = newEquipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:06:50)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:08:03)
 * @param newNumber int
 */
public void setNumber(int newNumber) {
	number.setInteger(new Integer(newNumber));
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 9:36:03)
 * @param newNumberFrm java.lang.String
 */
public void setNumberFrm(java.lang.String newNumberFrm) {
	number.setString(newNumberFrm);
}
/**
 * 
 * @param newOsinvname java.lang.String
 */
public void setOsinvname(java.lang.String newOsinvname) {
	osinvname = newOsinvname;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 12:59:58)
 * @param newOtherEquipmentType java.lang.String
 */
public void setOtherEquipmentType(java.lang.String newOtherEquipmentType) {
	otherEquipmentType = newOtherEquipmentType;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:26)
 * @param newPoscode java.lang.Integer
 */
public void setPoscode(java.lang.Integer newPoscode) {
	poscode = newPoscode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 18:09:43)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setPosition(PositionAccessBean newPosition) throws Exception {
	if (newPosition == null) {
	    poscode = new java.lang.Integer(0);
	    posid = "";
	    posname = "";
	}
	else {
		poscode = new Integer(newPosition.getStorageplace());
		posid = "";
		if (newPosition.getGsmid() != null)
			posid = "D" + newPosition.getGsmid() + " ";
		if (newPosition.getDampsid() != null)
			posid = posid + "A" + newPosition.getDampsid();
			
		posname = newPosition.getName();
		if ((newPosition.getDampsname() != null) && (newPosition.getDampsname().length() > 0) )
			posname = posname + " / " + newPosition.getDampsname();
		
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:46)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 10:16:51)
 * @param newRepeater java.lang.Boolean
 */
public void setRepeater(java.lang.Boolean newRepeater) {
	repeater = newRepeater;
}
public void setResource(ResourceAccessBean newResource)
	throws Exception
{
	try {
		if (newResource == null) {
		    resourcecodeFrm.setInteger( null );
	 		resourcefullname = "";
		} else {
			resourcecodeFrm.setInteger( new Integer(newResource.getResource()) );
			resourcefullname = newResource.getName();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.10.2003 17:28:15)
 * @param newResourcecodeFrm com.hps.july.web.util.StringAndIntegerProperty
 */
public void setResourcecodeFrm(String newResourcecodeFrm) {
	resourcecodeFrm.setString(newResourcecodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (01.10.2003 17:28:15)
 * @param newResourcefullname java.lang.String
 */
public void setResourcefullname(java.lang.String newResourcefullname) {
	resourcefullname = newResourcefullname;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 9:58:16)
 * @param newStationName java.lang.String
 */
public void setStationName(java.lang.String newStationName) {
	stationName = newStationName;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 9:58:34)
 * @param newStationType java.lang.String
 */
public void setStationType(java.lang.String newStationType) {
	stationType = newStationType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:13:39)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setSwitch(SwitchAccessBean newSwitch) throws Exception {
	if (newSwitch == null) {
	    switchcode.setInteger( new java.lang.Integer(0) );
	    switchNumber.setString("");
	    switchname = "";
	    switchposname = "";
	}
	else {
		switchcode.setInteger( new Integer(newSwitch.getStorageplace()) );
		switchNumber.setInteger(new Integer(newSwitch.getNumber()));
		switchname = newSwitch.getName();
	    switchposname = newSwitch.getPosition().getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:50:59)
 * @param newSwitchcode java.lang.Integer
 */
public void setSwitchcode(java.lang.Integer newSwitchcode) {
	switchcode.setInteger(newSwitchcode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:51:14)
 * @param newSwitchcodeFrm java.lang.String
 */
public void setSwitchcodeFrm(java.lang.String newSwitchcodeFrm) {
	switchcode.setString(newSwitchcodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:51:27)
 * @param newSwitchname java.lang.String
 */
public void setSwitchname(java.lang.String newSwitchname) {
	switchname = newSwitchname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:37)
 * @param newSwitchNumber java.lang.Integer
 */
public void setSwitchNumber(java.lang.Integer newSwitchNumber) {
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
 * Creation date: (18.07.2002 10:52:38)
 * @param newSwitchposname java.lang.String
 */
public void setSwitchposname(java.lang.String newSwitchposname) {
	switchposname = newSwitchposname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 19:06:16)
 * @param newSwitchType java.lang.String
 */
public void setSwitchType(java.lang.String newSwitchType) {
	switchType = newSwitchType;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ("N".equals(getComplectType()) || (getComplectType() == null))
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.equipment.complecttype"));
	else {
		//if ((getName() == null) || (getName().length() == 0))
		//  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.equipment.name"));
		  
	    if ( "A".equals(getComplectType()) ) {
		    //setName("base station");
		    setName(getStationName());
			if ((getStationType() == null) || !( "D".equals(getStationType()) || "S".equals(getStationType()) ||
				"C".equals(getStationType()) || "G".equals(getStationType()) ) )
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.type"));
			if (number.isEmpty())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.basestation.number"));
			else if (!number.isOk())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.number"));
			if ((getStationName() == null) || (getStationName().length() == 0))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.basestation.name"));
			  
			try {
				if (!contrNumber.isEmpty())
					if (contrNumber.isOk())
						constructControllers();
					else
				  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.controller"));
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.controller"));
				else
				  throw ex;
			}
			
			try {
				if (!switchNumber.isEmpty())
					if (switchNumber.isOk())
						constructSwitches();
					else
				  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.switch"));
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.switch"));
				else
				  throw ex;
			}
			
	    }
	    
		if ( "B".equals(getComplectType()) ) {
			//setName("comequipment");
			if ( (getName() == null) || (getName().length() == 0) ) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.comequipment.name"));
		    }
		    
			if ((getComEquipmentType() == null) || !( "R".equals(getComEquipmentType()) || "O".equals(getComEquipmentType()) || "A".equals(getComEquipmentType())) ) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.type"));
			}

			if(!resourcecodeFrm.isEmpty()){
				if(!resourcecodeFrm.isOk()){
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.resource"));
				} else {
					try{
						constructResource();
					}catch(Exception ex){
						if (ErrorProcessor.isRecordNotExistException(ex))
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.resource"));
						else
							throw ex;
					}
				}
			}

			// Проверка номера бинет
			if("S".equals(beenet_action)) {
				CDBCBeenetObject bn = new CDBCBeenetObject();
				if(beenet != null && "".equals(beenet.trim())) {
					beenet = null;
				}
				if(beenet != null) {
					if(!bn.isBeenetExist(beenet)) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.choosebeenet"));
					}
				}
			} else
			if("C".equals(beenet_action)) {
				CDBCBeenetObject bn = new CDBCBeenetObject();
				if(beenet_new != null && !"".equals(beenet_new.trim())) {
					if(bn.isBeenetExist(beenet_new)) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.duplicatebeenet"));
					}
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.enterbeenet"));
				}
				if(beenet_new_categid.getInteger() == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.enterbeenetcateg"));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.beenetaction"));
			}
			
			//try {
				//if (!comlinecode.isEmpty())
					//if (comlinecode.isOk())
						//constructComlines();
					//else
				  		//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.comline"));
			//} catch (Exception ex) {
				//if (ErrorProcessor.isRecordNotExistException(ex))
				  //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.comequipment.comline"));
				//else
				  //throw ex;
			//}
			  
	    }
	    
	    if ( "C".equals(getComplectType()) ) {
		    //setName("controller");
		    setName(getControllerName());
			if (number.isEmpty())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.controller.number"));
			else if (!number.isOk())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.number"));
			if ((getControllerName() == null) || (getControllerName().length() == 0))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.controller.name"));
			  
			try {
				if (!switchNumber.isEmpty())
					if (switchNumber.isOk())
						constructSwitches();
					else
				  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.switch"));
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.switch"));
				else
				  throw ex;
			}
			  
	    }
	    
	    if ( "D".equals(getComplectType()) ) {
		    //setName("switch");
		    if ( (getName() == null) || (getName().length() == 0) )
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.switch.name"));
			if (number.isEmpty())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.switch.number"));
			else if (!number.isOk())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.switch.number"));
			if ((getSwitchType() == null) || !( "1".equals(getSwitchType()) || "2".equals(getSwitchType()) ) )
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.switch.type"));
	    }
		  
		if ( "E".equals(getComplectType()) ) {
			setName("other");
	    }
	    
		if ( "F".equals(getComplectType()) ) {
			if (number.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.wlan.number"));
			} else if (!number.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.wlan.number"));
			}

			if ( (getName() == null) || (getName().length() == 0) ) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.wlan.name"));
			}
		}
		  
		try {
			if (getPoscode() != null) {
				constructPositions();
			}
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.equipment.position"));
			else
			  throw ex;
		}
		
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
