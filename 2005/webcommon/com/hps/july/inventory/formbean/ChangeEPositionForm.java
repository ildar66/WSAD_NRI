package com.hps.july.inventory.formbean;

import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования строки документа "Акт замены при ремонте"
 */
public class ChangeEPositionForm
	extends AbstractChangePositionForm
{
public ChangeEPositionForm() {
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ChangeEForm aform = (ChangeEForm)request.getSession().getAttribute( "ChangeEForm" );
	setDocument(aform.getDocumentId());
	return super.constructBean(request);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ChangeEForm aform = (ChangeEForm)request.getSession().getAttribute( "ChangeEForm" );
	setDocument(aform.getDocumentId());
	setStorageplace(aform.getExpedition());
	return super.getDataBean(request);
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHEP;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ChangeEForm form = (ChangeEForm)request.getSession().getAttribute("ChangeEForm");
	setDocument(form.getDocumentId());
	setStorageplace(form.getExpedition());
}
}
