package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма добавления/удаления оборудования в набор по которому производится инвентаризация на позиции
 */
public class I13nRessetForm extends com.hps.july.web.util.EditForm {
	public static final	java.math.BigDecimal ONE = new java.math.BigDecimal(1.0d);
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	
	private StringAndIntegerProperty document;
public I13nRessetForm() {
	document = new StringAndIntegerProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	I13nRessetListForm f = (I13nRessetListForm)request.getSession().getAttribute("I13nRessetListForm");
	setDocument(new Integer(f.getDocument()));
	I13nActResourceSetAccessBean bean = new I13nActResourceSetAccessBean(
		getDocument(),
		resource.getInteger()
	);
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		I13nActResourceSetAccessBean nbean = (I13nActResourceSetAccessBean)bean;
		resource.setInteger(new Integer(nbean.getResource().getResource()));
		resourcename = nbean.getResource().getName();
		resourcemodel = nbean.getResource().getModel();
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:11:56)
 * @return java.lang.Integer
 */
public Contract getContract() {
	return null;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	I13nRessetListForm f = (I13nRessetListForm)request.getSession().getAttribute("I13nRessetListForm");
	setDocument(new Integer(f.getDocument()));
	I13nActResourceSetAccessBean bean = new I13nActResourceSetAccessBean();
	bean.setInitKey_i13nAct_document(document.getInteger());
	bean.setInitKey_resource_resource(resource.getInteger());
	return bean;
}
public Integer getDocument() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 15:16:29)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getOrganizations() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public Resource getResource() {
	if(resource.isEmpty()) {
		return null;
	}
	
	try {
		ResourceAccessBean bean = new ResourceAccessBean();
		bean.setInitKey_resource(resource.getInteger().intValue());
		bean.refreshCopyHelper();
		return (Resource)bean.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getResourcecode() {
	return resource.getString();
}
public Integer getResourceint() {
	return resource.getInteger();
}
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:02:52)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITIRS;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	I13nRessetListForm f = (I13nRessetListForm)request.getSession().getAttribute( "I13nRessetListForm" );
	setDocument(new Integer(f.getDocument()));
}
public void setDocument(Integer newDocument) {
	document.setInteger(newDocument);
}
public void setDocumentstr(String newDocument) {
	document.setString(newDocument);
}
public void setResource(ResourceAccessBean newResource) {
	try {
		resource.setInteger(new Integer(newResource.getResource()));
		resourcename = newResource.getName();
		resourcemodel = newResource.getModel();
	} catch(Exception e) {
		resource.setInteger(new Integer(0));
		resourcename = "?";
		resourcemodel = "?";
	}
}
public void setResourcecode(String newResource) {
	resource.setString(newResource);
}
public void setResourceint(Integer newResource) {
	resource.setInteger(newResource);
}
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	// Check document and its state.
	try {
		I13nActAccessBean docum = new I13nActAccessBean();
		docum.setInitKey_document(getDocument().intValue());
		docum.refreshCopyHelper();
		if("2".equals(docum.getDocumentState())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.resset.change"));
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resset.document"));
	}

	if (!errors.empty())
		throw new ValidationException();

	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resset.resource"));
	} else {
		try {
			ResourceAccessBean bean = new ResourceAccessBean();
			bean.setInitKey_resource(resource.getInteger().intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resset.resource"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
