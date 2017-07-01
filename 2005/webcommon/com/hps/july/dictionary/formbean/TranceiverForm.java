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
import com.hps.july.util.*;
import java.util.*;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import org.apache.struts.action.*;

/**
 * Форма редактирования оборудования трансивера
 */
public class TranceiverForm extends ResourceForm {
	
	private String navt; // L - from Local List, R - from Resources List
	private StringAndShort band = new StringAndShort();
	private Boolean doubletrx;

/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 17:11:54)
 */
public TranceiverForm() {
	super();
	fuse();	
}
private void fuse(){
	setBoxable(Boolean.FALSE);
	setComplectpart(Boolean.FALSE);
}
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {}
/**
 * Метод вызывается после добавления/изменения основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */

public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
}

/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	TRXResourceAccessBean bean = new TRXResourceAccessBean(
		getResource(),
		getName(), getModel(), getNotes(),
		getComplect(), getCountpolicy(),
		getBoxable(), getPriceable(), getComplectpart(),
		getActive(), getResourcesubtype(), getDoubletrx().booleanValue()
	);
	return bean;
}

public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	try {
		TRXResourceAccessBean tr = (TRXResourceAccessBean)bean;
		setResourcesubtype(tr.getSubtype_resourcesubtype().intValue());
		if(tr.getManufid() != null) {
			setManufid(tr.getManufid());
			setManufacturername(CDBCResourcesObject.getManufnameByManufid(tr.getManufid()));
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}

public Short getBand() {
	return band.getShort();
}
public String getBandFrm() {
	return band.getString();
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
	TRXResourceAccessBean bean = new TRXResourceAccessBean();
    bean.setInitKey_resource(getResource());
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return java.lang.Boolean
 */
public Boolean getDoubletrx() {
	return doubletrx;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return java.lang.String
 */
public java.lang.String getNavt() {
	return navt;
}

public int getState() {
	return com.hps.july.dictionary.APPStates.EDIT_TRANCEIVER;
}

public Enumeration getUsedBands(){
	Vector v = new Vector();
	v.add("900"); v.add("900");
	v.add("1800"); v.add("1800");
	return v.elements();
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
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newBandwidth com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBand(Short newBand) {
	band.setShort(newBand);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newBandwidth com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBandFrm(String newBand) {
	band.setString(newBand);
}

/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newIslinear java.lang.Boolean
 */
public void setDoubletrx(Boolean newDoubletrx) {
	doubletrx = newDoubletrx;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newNavt java.lang.String
 */
public void setNavt(java.lang.String newNavt) {
	navt = newNavt;
}

public void validateValues(ActionErrors errors) throws Exception 
{
	super.validateValues(errors);
}
}