package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;

/**
 * ‘орма добавлени€/удалени€ оборудовани€ в набор по которому производитс€ инвентаризаци€ на складе
 */
public class I13nActRessetForm extends I13nRessetForm {
/**
 * I13nActRessetForm constructor comment.
 */
public I13nActRessetForm() {
	super();
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	I13nActRessetListForm f = (I13nActRessetListForm)request.getSession().getAttribute("I13nActRessetListForm");
	setDocument(new Integer(f.getDocument()));
	I13nActResourceSetAccessBean bean = new I13nActResourceSetAccessBean(
		getDocument(),
		getResourceint()
	);
	return bean;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	I13nActRessetListForm f = (I13nActRessetListForm)request.getSession().getAttribute("I13nActRessetListForm");
	setDocument(new Integer(f.getDocument()));
	I13nActResourceSetAccessBean bean = new I13nActResourceSetAccessBean();
	bean.setInitKey_i13nAct_document(getDocument());
	bean.setInitKey_resource_resource(getResourceint());
	return bean;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITIRAS;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	I13nActRessetListForm f = (I13nActRessetListForm)request.getSession().getAttribute( "I13nActRessetListForm" );
	setDocument(new Integer(f.getDocument()));
}
}
