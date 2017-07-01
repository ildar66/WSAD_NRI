package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.persistence.*;
/**
 *  Form-Bean.
 * "Связи счетов по абоненстским договорам".
 * Creation date: (17.07.2003 10:59:40)
 * @author: Sergey Gourov
 */
public class AbonentBillLinkForm extends com.hps.july.web.util.EditForm {
	private int idrecord;
	private int resourcecode;
	private java.lang.String idresbilling;
	private java.lang.String billresname;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:44)
 */
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {
	LeaseResBil2NRIAccessBean lrbBean = (LeaseResBil2NRIAccessBean) getDataBean(request);
	lrbBean.setLeaseResBil(null);
	lrbBean.commitCopyHelper();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	ResourceAccessBean resourceBean = new ResourceAccessBean();
	resourceBean.setInitKey_resource(getResourcecode());
	resourceBean.refreshCopyHelper();
	
	LeaseResBil2NRIAccessBean lrbBean = (LeaseResBil2NRIAccessBean) getDataBean(request);
	lrbBean.setLeaseResBil((Resource) resourceBean.getEJBRef());
	lrbBean.commitCopyHelper();
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 10:59:40)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		setResourcecode(((LeaseResBil2NRIAccessBean) bean).getLeaseResBilKey().resource);
	} catch (Exception e) {
		e.printStackTrace();
		setResourcecode(0);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 10:59:40)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:21:34)
 * @return java.lang.String
 */
public java.lang.String getBillresname() {
	return billresname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 10:59:40)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseResBil2NRIAccessBean bean = new LeaseResBil2NRIAccessBean();
	bean.setInitKey_idrecord(getIdrecord());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:03:01)
 * @return int
 */
public int getIdrecord() {
	return idrecord;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:19:37)
 * @return java.lang.String
 */
public java.lang.String getIdresbilling() {
	return idresbilling;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:18:53)
 * @return int
 */
public int getResourcecode() {
	return resourcecode;
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();
		
		return (new ResourceAccessBean()).findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 10:59:40)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_BILL_LINK_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:21:34)
 * @param newBillresname java.lang.String
 */
public void setBillresname(java.lang.String newBillresname) {
	billresname = newBillresname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:03:01)
 * @param newIdrecord int
 */
public void setIdrecord(int newIdrecord) {
	idrecord = newIdrecord;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:19:37)
 * @param newIdresbilling java.lang.String
 */
public void setIdresbilling(java.lang.String newIdresbilling) {
	idresbilling = newIdresbilling;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 11:18:53)
 * @param newResourcecode int
 */
public void setResourcecode(int newResourcecode) {
	resourcecode = newResourcecode;
}
}
