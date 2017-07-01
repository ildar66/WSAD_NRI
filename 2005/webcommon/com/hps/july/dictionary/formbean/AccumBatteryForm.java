/*
 * Created on 31.03.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.cdbc.lib.CDBCColumnObject;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.*;
import com.hps.july.dictionary.valueobject.TranceiverVO;
import com.hps.july.jdbcpersistence.lib.StringAndShort;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.applets.Captions;
import com.hps.july.util.*;
import java.util.*;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import org.apache.struts.action.*;

/**
 * @author AAErmolov
 *
 * Форма редактирования оборудования аккумуляторной батареи
 * 
 */
public class AccumBatteryForm extends ResourceForm {
	private StringAndBigDecimalProperty voltage = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty capacity = new StringAndBigDecimalProperty();
	private String accutype;
	private StringAndIntegerProperty accucount = new StringAndIntegerProperty();
	
	private String navt;

	public AccumBatteryForm() {
		super();
		fuse();	
	}
	private void fuse(){
		setBoxable(Boolean.FALSE);
		setComplectpart(Boolean.FALSE);
	}

	public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {}

	public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {}

	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		AccumBatteryResourceAccessBean bean = new AccumBatteryResourceAccessBean(
			getResource(),
			getName(), getModel(), getNotes(),
			getComplect(), getCountpolicy(),
			getBoxable(), getPriceable(), getComplectpart(),
			getActive(), getResourcesubtype()//, false
		);
		return bean;
	}

	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
		//super.fillRecord(bean);
		try {
			AccumBatteryResourceAccessBean acr = (AccumBatteryResourceAccessBean)bean;
			setResourcesubtype(acr.getSubtype_resourcesubtype().intValue());
			if(acr.getManufid() != null) {
				setManufid(acr.getManufid());
				setManufacturername(CDBCResourcesObject.getManufnameByManufid(acr.getManufid()));
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.EDIT_ACCUMBATTERY;
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
		javax.servlet.http.HttpServletRequest request) {
		AccumBatteryResourceAccessBean bean = new AccumBatteryResourceAccessBean();
		bean.setInitKey_resource(getResource());
		return bean;
	}
	public java.lang.String getNavt() {
		return navt;
	}
	public void setNavt(java.lang.String newNavt) {
		navt = newNavt;
	}
	public BigDecimal getVoltage() {
		return voltage.getBigDecimal();
	}
	public String getVoltageFrm() {
		return voltage.getString();
	}
	public BigDecimal getCapacity() {
		return capacity.getBigDecimal();
	}
	public String getCapacityFrm() {
		return capacity.getString();
	}
	public String getAccutype() {
		return accutype;
	}
	public Integer getAccucount() {
		return accucount.getInteger();
	}
	public String getAccucountFrm() {
		return accucount.getString();
	}
	public void setVoltage(BigDecimal newVoltage) {
		voltage.setBigDecimal(newVoltage);
	}

	public void setVoltageFrm(String newVoltage) {
		voltage.setString(newVoltage);
	}
	public void setCapacity(BigDecimal newCapacity) {
		capacity.setBigDecimal(newCapacity);
	}

	public void setCapacityFrm(String newCapacity) {
		capacity.setString(newCapacity);
	}
	public void setAccutype(String newAccutype) {
		accutype = newAccutype;
	}

	public void setAccucount(Integer newAccucount) {
		accucount.setInteger(newAccucount);
	}

	public void setAccucountFrm(String newAccucount) {
		accucount.setString(newAccucount);
	}

	public void initRecord(javax.servlet.http.HttpServletRequest request)
	{
		ResourcesCommonListForm frm = (ResourcesCommonListForm)request.getSession().getAttribute("ResourcesCommonListForm");
		setResourcesubtype(com.hps.july.util.AppUtils.getNamedValueInt("Dict_SIMPLERES"));
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		try{
			setResource(keyGen.getNextKey("tables.resources"));
		}
		catch (Exception e){
		}
	}
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
	}
}


