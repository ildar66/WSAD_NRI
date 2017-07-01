package com.hps.july.basestation.formbean;

import org.apache.struts.action.*;
import java.util.Enumeration;
import javax.servlet.http.*;
import java.math.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.sitedoc.valueobject.*;

/**
 * Форма редактирования контроллера
 */
public class ControllerForm extends EquipmentPForm {
	private StringAndInteger number = new StringAndInteger();
	private int switchId;
	private StringAndInteger switchcode = new StringAndInteger();
	private java.lang.String switchname;
	private SwitchAccessBean switchbean;
	private ResourceAccessBean resource;
	private StringAndInteger resourcecode = new StringAndInteger();
	private String resourcename;
	private String resourcemodel;
	private String resourcefullname;
	private StringAndIntegerProperty qtyshell = new StringAndIntegerProperty();
	private StringAndIntegerProperty mfs_num = new StringAndIntegerProperty();
	private StringAndIntegerProperty omcr_num = new StringAndIntegerProperty();
	private java.lang.String contype;
	private java.lang.String lac_numbers;
	private StringAndIntegerProperty trxfr_qty_max = new StringAndIntegerProperty();
	private StringAndBigDecimalProperty trx_use_percent = new StringAndBigDecimalProperty();
	private StringAndIntegerProperty atr_qty_max = new StringAndIntegerProperty();
	private StringAndIntegerProperty trxfr_qty = new StringAndIntegerProperty();
	private StringAndIntegerProperty trxhr_qty = new StringAndIntegerProperty();
	private StringAndIntegerProperty atr_qty = new StringAndIntegerProperty();
	private StringAndIntegerProperty aint_qty = new StringAndIntegerProperty();
	private StringAndIntegerProperty hway_qty_voice = new StringAndIntegerProperty();
	private StringAndIntegerProperty hway_qty_grps = new StringAndIntegerProperty();
	private java.lang.String verpo;
public ControllerForm() {
	//setState(APPStates.CONTROLLER_EDIT);
}
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
    throws Exception
{
	try {
		ContrAddInfoAccessBean ca = new ContrAddInfoAccessBean();
		ContrParamsAccessBean cp = new ContrParamsAccessBean();
		Enumeration encai = ca.findContrAddInfosByController(new StoragePlaceKey(getStorageplace()));
		while(encai.hasMoreElements()) {
			ContrAddInfoAccessBean cao = (ContrAddInfoAccessBean)encai.nextElement();
			Enumeration en = cp.findByEquipmentAndActdateOrderByParamlevelAsc(new Integer(getStorageplace()),cao.getAct_date());
			while(en.hasMoreElements()) {
				ContrParamsAccessBean c = (ContrParamsAccessBean)en.nextElement();
				c.getEJBRef().remove();
			}
			cao.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.controller.delete_nested_records");
	}

	SiteDocObject.deleteDocuments(getStorageplace());
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	try {
		ControllerAccessBean cb = (ControllerAccessBean)bean;
		cb.setSwitch(getSwitch());
	} catch(Exception e) {
		throw new UpdateValidationException("error.controllerform.update");
	}
}
public boolean checkUnique(ActionErrors errors)
{
	/*
	try {
		ControllerAccessBean cf = new ControllerAccessBean();
		Enumeration en = cf.findByNN(getNumber(),getName(),getPlanstate(),getPositionId());
		if(en.hasMoreElements()) {
			ControllerAccessBean cb = (ControllerAccessBean)en.nextElement();
			errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.SwitchForm.unique",getPosTitle(cb)));
		}
		return true;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
	*/
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	super.constructBean(request);
	
	DebugSupport.printlnTest("SwitchForm constructBean getPositionId()=" + getPositionId()); 
	
	setStorageplace(new KeyGeneratorAccessBean().getNextKey(TablesRef.CONTROLLERS));
	
    return new ControllerAccessBean(
		getStorageplace(),	// argStorageplace int
		null,				// argDivision java.lang.Integer
		getName(),			// argName java.lang.String
		null,				// argAddress java.lang.String
		getPositionId(),	// argPosition java.lang.Integer
		new Integer(getNumber()),	// argNumber java.lang.Integer
		getName()				// argCName java.lang.String
	);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:47:11)
 */
private ResourceAccessBean constructResource() throws Exception {
	if (!resourcecode.isEmpty() && resourcecode.isOk()) {
		resource = new ResourceAccessBean();
		resource.setInitKey_resource(resourcecode.getInt());
		resource.refreshCopyHelper();
		return resource;
	}
	return null;
	
}
private SwitchAccessBean constructSwitch()
	throws java.lang.Exception
{
	SwitchAccessBean bean = null;
	if (switchcode.isOkAndNotEmpty()) {
		try {
			SwitchAccessBean switchById = SwitchModel.getSwitchById(getSwitchId());
//System.out.println("SWCH_FORM:switchById:"+switchById);
			SwitchAccessBean switchByNumber = SwitchModel.getSwitchByNumber(getSwitchcode());
//System.out.println("SWCH_FORM:switchByNumber:"+switchByNumber);
			if(switchById != null) {
				if(switchByNumber != null) {
					if(switchById.getNumber() == switchByNumber.getNumber()) {
//System.out.println("SWCH_FORM:numbers is equal");
						setSwitchParams(switchById);
						bean = switchById;
					} else {
						setSwitchParams(switchByNumber);
						bean = switchByNumber;
					}
				} else {
					setSwitchParams(switchById);
					bean = switchById;
				}
			} else {
				if(switchByNumber != null) {
					setSwitchParams(switchByNumber);
					bean = switchByNumber;
				} else {
					throw new Exception("Switch not Found!!!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	} else {
//System.out.println("SWCH_FORM:switchcode is not ok");
	}
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
//	ControllerAccessBean c = (ControllerAccessBean)bean;
//	c.getResource();
//	c.getSwitch();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:44:23)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getAint_qty() {
	return aint_qty.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:44:23)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getAint_qtyFrm() {
	return aint_qty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:40:03)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getAtr_qty() {
	return atr_qty.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:28:04)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getAtr_qty_max() {
	return atr_qty_max.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:28:04)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getAtr_qty_maxFrm() {
	return atr_qty_max.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:40:03)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getAtr_qtyFrm() {
	return atr_qty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:11:11)
 * @return java.lang.String
 */
public java.lang.String getContype() {
	return contype;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	try {
		ControllerAccessBean bean = new ControllerAccessBean();
		bean.setInitKey_storageplace(getStorageplace());
		bean.refreshCopyHelper();

		return bean;
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:51:01)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getHway_qty_grps() {
	return hway_qty_grps.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:51:01)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getHway_qty_grpsFrm() {
	return hway_qty_grps.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:48:17)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getHway_qty_voice() {
	return hway_qty_voice.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:48:17)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getHway_qty_voiceFrm() {
	return hway_qty_voice.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:18:55)
 * @return java.lang.String
 */
public java.lang.String getLac_numbers() {
	return lac_numbers;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2003 14:28:47)
 * @return java.lang.String
 */
public String getListAttributeName() {
	return "ControllerListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:59:38)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getMfs_num() {
	return mfs_num.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:59:38)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getMfs_numFrm() {
	return mfs_num.getString();
}
public int getNumber() {
    return number.getInt();
}
public String getNumberFrm() {
    return number.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:03:40)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getOmcr_num() {
	return omcr_num.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:03:40)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getOmcr_numFrm() {
	return omcr_num.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:55:19)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getQtyshell() {
	return qtyshell.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:55:19)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getQtyshellFrm() {
	return qtyshell.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:36:07)
 * @return com.hps.july.persistence.PositionAccessBean
 */
public Resource getResource() throws Exception {
	ResourceAccessBean bean = constructResource();
	return bean != null ? (Resource) bean.getEJBRef(): null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:42:21)
 * @return java.lang.String
 */
public String getResourcecodeFrm() {
	return resourcecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2003 14:21:32)
 * @return java.lang.String
 */
public java.lang.String getResourcefullname() {
	return resourcefullname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public int getState() {
	if(super.getState() == 0) {
		return APPStates.CONTROLLER_EDIT;
	} else {
		return super.getState();
	}
}
public Switch getSwitch() throws Exception {
	SwitchAccessBean bean = constructSwitch();
System.out.println("SWCH_FORM:getSwitch("+bean+")");
	return bean != null ? (Switch) bean.getEJBRef(): null;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 10:51:29)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getSwitchcode() {
	return switchcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 10:51:29)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getSwitchcodeFrm() {
	return switchcode.getString();
}
/**
 * 
 * @return int
 */
public int getSwitchId() {
	return switchId;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 10:58:06)
 * @return java.lang.String
 */
public java.lang.String getSwitchname() {
	return switchname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:24:35)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getTrx_use_percent() {
	return trx_use_percent.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:24:35)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getTrx_use_percentFrm() {
	return trx_use_percent.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:31:38)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getTrxfr_qty() {
	return trxfr_qty.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:21:06)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getTrxfr_qty_max() {
	return trxfr_qty_max.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:21:06)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getTrxfr_qty_maxFrm() {
	return trxfr_qty_max.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:31:38)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getTrxfr_qtyFrm() {
	return trxfr_qty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:34:59)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getTrxhr_qty() {
	return trxhr_qty.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:34:59)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getTrxhr_qtyFrm() {
	return trxhr_qty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 12:06:59)
 * @return java.lang.String
 */
public java.lang.String getVerpo() {
	return verpo;
}
public void initRecord(HttpServletRequest request) throws Exception {
	super.initRecord(request);
	number = new StringAndInteger();
	switchcode = new StringAndInteger();
	setSwitchname("");
	switchbean = null;
	resource = null;
	resourcecode = new StringAndInteger();
	setResourcename("");
	setResourcemodel("");
	setResourcefullname("");
	qtyshell = new StringAndIntegerProperty();
	mfs_num = new StringAndIntegerProperty();
	omcr_num = new StringAndIntegerProperty();
	setContype("");
	setLac_numbers("");
	trxfr_qty_max = new StringAndIntegerProperty();
	trx_use_percent = new StringAndBigDecimalProperty();
	atr_qty_max = new StringAndIntegerProperty();
	trxfr_qty = new StringAndIntegerProperty();
	trxhr_qty = new StringAndIntegerProperty();
	atr_qty = new StringAndIntegerProperty();
	aint_qty = new StringAndIntegerProperty();
	hway_qty_voice = new StringAndIntegerProperty();
	hway_qty_grps = new StringAndIntegerProperty();
	setVerpo("");
	setSwitchId(0);

	Object blist = request.getSession().getAttribute("ControllerListForm");
	if(blist != null && blist instanceof ControllerListForm) {
		ControllerListForm bl = (ControllerListForm)blist;
		Integer[] regs = bl.getRegionsSelector().getRegioncodes();
		if(regs != null && regs.length > 0) {
			getPositionForm().setRegioncode(""+regs[0]);
		}
		Integer[] nzc = bl.getRegionsSelector().getNetzonecodes();
		if(nzc != null && nzc.length > 0) {
			getPositionForm().setNetzonecode(nzc[0]);
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:44:23)
 * @param newAint_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAint_qty(Integer newAint_qty) {
	aint_qty.setInteger(newAint_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:44:23)
 * @param newAint_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAint_qtyFrm(String newAint_qty) {
	aint_qty.setString(newAint_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:40:03)
 * @param newAtr_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAtr_qty(Integer newAtr_qty) {
	atr_qty.setInteger(newAtr_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:28:04)
 * @param newAtr_qty_max com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAtr_qty_max(Integer newAtr_qty_max) {
	atr_qty_max.setInteger(newAtr_qty_max);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:28:04)
 * @param newAtr_qty_max com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAtr_qty_maxFrm(String newAtr_qty_max) {
	atr_qty_max.setString(newAtr_qty_max);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:40:03)
 * @param newAtr_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAtr_qtyFrm(String newAtr_qty) {
	atr_qty.setString(newAtr_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:11:11)
 * @param newContype java.lang.String
 */
public void setContype(java.lang.String newContype) {
	contype = newContype;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:51:01)
 * @param newHway_qty_grps com.hps.july.web.util.StringAndIntegerProperty
 */
public void setHway_qty_grps(Integer newHway_qty_grps) {
	hway_qty_grps.setInteger(newHway_qty_grps);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:51:01)
 * @param newHway_qty_grps com.hps.july.web.util.StringAndIntegerProperty
 */
public void setHway_qty_grpsFrm(String newHway_qty_grps) {
	hway_qty_grps.setString(newHway_qty_grps);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:48:17)
 * @param newHway_qty_voice com.hps.july.web.util.StringAndIntegerProperty
 */
public void setHway_qty_voice(Integer newHway_qty_voice) {
	hway_qty_voice.setInteger(newHway_qty_voice);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:48:17)
 * @param newHway_qty_voice com.hps.july.web.util.StringAndIntegerProperty
 */
public void setHway_qty_voiceFrm(String newHway_qty_voice) {
	hway_qty_voice.setString(newHway_qty_voice);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:18:55)
 * @param newLac_numbers java.lang.String
 */
public void setLac_numbers(java.lang.String newLac_numbers) {
	lac_numbers = newLac_numbers;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:59:38)
 * @param newMfs_num com.hps.july.web.util.StringAndIntegerProperty
 */
public void setMfs_num(Integer newMfs_num) {
	mfs_num.setInteger(newMfs_num);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:59:38)
 * @param newMfs_num com.hps.july.web.util.StringAndIntegerProperty
 */
public void setMfs_numFrm(String newMfs_num) {
	mfs_num.setString(newMfs_num);
}
public void setNumber(int arg) {
    number.setInt(arg);
}
public void setNumberFrm(String arg) {
    number.setString(arg);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:03:40)
 * @param newOmcr_num com.hps.july.web.util.StringAndIntegerProperty
 */
public void setOmcr_num(Integer newOmcr_num) {
	omcr_num.setInteger(newOmcr_num);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:03:40)
 * @param newOmcr_num com.hps.july.web.util.StringAndIntegerProperty
 */
public void setOmcr_numFrm(String newOmcr_num) {
	omcr_num.setString(newOmcr_num);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:55:19)
 * @param newQtyshell com.hps.july.web.util.StringAndIntegerProperty
 */
public void setQtyshell(Integer newQtyshell) {
	qtyshell.setInteger(newQtyshell);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:55:19)
 * @param newQtyshell com.hps.july.web.util.StringAndIntegerProperty
 */
public void setQtyshellFrm(String newQtyshell) {
	qtyshell.setString(newQtyshell);
}
public void setResource(ResourceAccessBean res) throws Exception {
	if (res == null) {
		resourcecode.setInteger(null);
		resourcename = null;
		resourcemodel = null;
		resourcefullname = null;
		return;
	}
	try {
		resourcecode.setInt(res.getResource());
		resourcename = res.getName();
		resourcemodel = res.getModel();
		resourcefullname = res.getName() + " " + res.getModel();
		DebugSupport.printlnTest("ControllerForm setResource() res.getResource()=" + res.getResource());
		DebugSupport.printlnTest("ControllerForm setResource() getResourceFrm()=" + getResourcecodeFrm());
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:43:04)
 */
public void setResourcecodeFrm(String res) {
	resourcecode.setString(res);
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2003 14:21:32)
 * @param newResourcefullname java.lang.String
 */
public void setResourcefullname(java.lang.String newResourcefullname) {
	resourcefullname = newResourcefullname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 11:06:19)
 * @param newSwitchbean com.hps.july.persistence.SwitchAccessBean
 */
public void setSwitch(SwitchAccessBean newSwitchbean) throws Exception {
System.out.println("SWCH_FORM:setSwitch("+newSwitchbean+")");
	if (newSwitchbean == null) {
		setSwitchcode(null);
		setSwitchname("");
		setSwitchId(0);
	} else {
		setSwitchcode(new Integer(newSwitchbean.getNumber()));
		try {
//			setSwitchname(newSwitchbean.getPosition().getName());
			String name = newSwitchbean.getName();
			PositionAccessBean b = newSwitchbean.getPosition();
			String posname = b.getName();
			String id = "";
			if(b.getGsmid() != null) {
				id += "D" + b.getGsmid()+" ";
			}
			if(b.getDampsid() != null) {
				id += "A" + b.getDampsid()+" ";
			}
			setSwitchname(name+" / "+((id != null && !"".equals(id))?id:"")+posname);
		} catch(Exception e) {
			setSwitchname("?");
		}
		setSwitchId(newSwitchbean.getStorageplace());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 10:51:29)
 * @param newSwitchcode com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSwitchcode(Integer newSwitchcode) {
	switchcode.setInteger(newSwitchcode);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 10:51:29)
 * @param newSwitchcode com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSwitchcodeFrm(String newSwitchcode) {
	switchcode.setString(newSwitchcode);
}
/**
 * 
 * @param newSwitchId int
 */
public void setSwitchId(int newSwitchId) {
	switchId = newSwitchId;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 10:58:06)
 * @param newSwitchname java.lang.String
 */
public void setSwitchname(java.lang.String newSwitchname) {
	switchname = newSwitchname;
}
protected void setSwitchParams(SwitchAccessBean bean)
	throws Exception
{
	if(bean != null) {
		setSwitchname(bean.getPosition().getName());
		setSwitchId(bean.getStorageplace());
		setSwitchcode(new Integer(bean.getNumber()));
		switchbean = bean;
	} else {
		setSwitchname("");
		setSwitchId(0);
		setSwitchcodeFrm("");
		switchbean = null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:24:35)
 * @param newTrx_use_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setTrx_use_percent(BigDecimal newTrx_use_percent) {
	trx_use_percent.setBigDecimal(newTrx_use_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:24:35)
 * @param newTrx_use_percent com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setTrx_use_percentFrm(String newTrx_use_percent) {
	trx_use_percent.setString(newTrx_use_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:31:38)
 * @param newTrxfr_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTrxfr_qty(Integer newTrxfr_qty) {
	trxfr_qty.setInteger(newTrxfr_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:21:06)
 * @param newTrxfr_qty_max com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTrxfr_qty_max(Integer newTrxfr_qty_max) {
	trxfr_qty_max.setInteger(newTrxfr_qty_max);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:21:06)
 * @param newTrxfr_qty_max com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTrxfr_qty_maxFrm(String newTrxfr_qty_max) {
	trxfr_qty_max.setString(newTrxfr_qty_max);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:31:38)
 * @param newTrxfr_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTrxfr_qtyFrm(String newTrxfr_qty) {
	trxfr_qty.setString(newTrxfr_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:34:59)
 * @param newTrxhr_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTrxhr_qty(Integer newTrxhr_qty) {
	trxhr_qty.setInteger(newTrxhr_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 12:34:59)
 * @param newTrxhr_qty com.hps.july.web.util.StringAndIntegerProperty
 */
public void setTrxhr_qtyFrm(String newTrxhr_qty) {
	trxhr_qty.setString(newTrxhr_qty);
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 12:06:59)
 * @param newVerpo java.lang.String
 */
public void setVerpo(java.lang.String newVerpo) {
	verpo = newVerpo;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	super.validateValues(errors);
	
	if (getNumberFrm() == null || "".equals(getNumberFrm())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.controller.number"));
	}
	
	if (!switchcode.isEmpty()) { 
		if (!switchcode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.switch"));
			setSwitchname("");
		} else {
			try {
				constructSwitch();
			} catch (Exception e) {
				setSwitchname("");
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.switch"));
			}
		}
	}
	
	if (!resourcecode.isEmpty()) {
		if (!resourcecode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.resource"));
			setResourcefullname("");
		} else {
			try {
				constructResource();
			} catch (Exception e) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.resource"));
					setResourcefullname("");
				}
			}
		}
	}
		
	if (!qtyshell.isEmpty() && !qtyshell.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.qtyshell"));
	}
		
	if (!mfs_num.isEmpty() && !mfs_num.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.mfsnum"));
	}
		
	if (!omcr_num.isEmpty() && !omcr_num.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.omcrnum"));
	}

	if (!trxfr_qty_max.isEmpty() && !trxfr_qty_max.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.trxfr_qty_max"));
	}

	if (!trx_use_percent.isEmpty() && !trx_use_percent.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.trx_use_percent"));
	}
	
	if (!atr_qty_max.isEmpty() && !atr_qty_max.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.atr_qty_max"));
	}

	if (!trxfr_qty.isEmpty() && !trxfr_qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.trxfr_qty"));
	}
		
	if (!trxhr_qty.isEmpty() && !trxhr_qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.trxhr_qty"));
	}
		
	if (!atr_qty.isEmpty() && !atr_qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.atr_qty"));
	}
		
	if (!aint_qty.isEmpty() && !aint_qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.aint_qty"));
	}
	
	if (!hway_qty_voice.isEmpty() && !hway_qty_voice.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.hway_qty_voice"));
	}
		
	if (!hway_qty_grps.isEmpty() && !hway_qty_grps.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.controller.hway_qty_grps"));
	}
	
	if (!errors.empty()) throw new ValidationException();

	checkEntityUnique(errors);
}
}
