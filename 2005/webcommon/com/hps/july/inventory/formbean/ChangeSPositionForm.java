package com.hps.july.inventory.formbean;

import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования строки документа "Акт замены/модернизации на складе"
 */
public class ChangeSPositionForm
	extends AbstractChangePositionForm
{
public ChangeSPositionForm() {
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ChangeSForm aform = (ChangeSForm)request.getSession().getAttribute( "ChangeSForm" );
	setDocument(aform.getDocumentId());
	return super.constructBean(request);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ChangeSForm aform = (ChangeSForm)request.getSession().getAttribute( "ChangeSForm" );
	setDocument(aform.getDocumentId());
	setStorageplace(aform.getStorage());
	return super.getDataBean(request);
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHSP;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ChangeSForm form = (ChangeSForm)request.getSession().getAttribute("ChangeSForm");
	setDocument(form.getDocumentId());
	setStorageplace(form.getStorage());
}
}
