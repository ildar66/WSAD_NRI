package com.hps.july.inventory.formbean;

import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода строки документа "Акт замены/модернизации на позиции"
 */
public class ChangePPositionForm
	extends AbstractChangePositionForm
{
// @TODO: Не готовы поля в базе для этих выборок.
//        В настоящее время используется лукап где показываются только реальные серийные номера.
//	private String invnum;
//	private Boolean fictionSerial = Boolean.FALSE;
public ChangePPositionForm() {
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ChangePForm aform = (ChangePForm)request.getSession().getAttribute( "ChangePForm" );
	setDocument(new Integer(aform.getDocument()));
	return super.constructBean(request);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ChangePForm aform = (ChangePForm)request.getSession().getAttribute( "ChangePForm" );
	setDocument(new Integer(aform.getDocument()));
	setStorageplace(aform.getComplect());
	return super.getDataBean(request);
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHPP;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ChangePForm form = (ChangePForm)request.getSession().getAttribute("ChangePForm");
	setDocument(new Integer(form.getDocument()));
	setStorageplace(form.getComplect());
}
}
