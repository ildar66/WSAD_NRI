package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.inventory.valueobject.*;

/**
 * Форма списка серийных номеров строки документа "Внешний приходный ордер" с серийным учётом оборудования
 */
public class ExternalSerialListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcemodel;
	private String resourcename;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty outerQty;
	private String configuration;

	private StringAndIntegerProperty outerDocPosition;
public ExternalSerialListForm() {
	order = new StringAndIntegerProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = null;
	resourcename = null;
	qty = new StringAndBigDecimalProperty();
	outerQty = new StringAndBigDecimalProperty();
	
	outerDocPosition = new StringAndIntegerProperty();

	this.setFinderMethodName( "findInWayBillPositionByOuterDocPosition" );
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.InWayBillPositionAccessBean";
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 19:36:08)
 * @return java.lang.String
 */
public java.lang.String getConfiguration() {
	return configuration;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:26:35)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	try {
		return new Object[] {
			new com.hps.july.persistence.OuterDocPositionKey(outerDocPosition.getInteger().intValue())
		};
	} catch(NullPointerException npe) {
		return new Object[] {
			new com.hps.july.persistence.OuterDocPositionKey(0)
		};
	}
}
public java.lang.Integer getOrder() {
	return order.getInteger();
}
public String getOrderstr() {
	return order.getString();
}
public java.lang.Integer getOuterDocPosition() {
	return outerDocPosition.getInteger();
}
public String getOuterDocPositionstr() {
	return outerDocPosition.getString();
}
public java.math.BigDecimal getOuterQty() {
	return outerQty.getBigDecimal();
}
public String getOuterQtystr() {
	return outerQty.getString();
}
public java.math.BigDecimal getQty() {
	return qty.getBigDecimal();
}
public String getQtystr() {
	return qty.getString();
}
public java.lang.Integer getResource() {
	return resource.getInteger();
}
public String getResourcecode() {
	return resource.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 16:59:37)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 16:59:37)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public ActionForward initBrowse(ActionMapping mapping, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	throws java.io.IOException, javax.servlet.ServletException
{
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.EOSLIST);
    ExternalSerialListForm aform = this;
    try {
		OuterDocPositionAccessBean ab = new OuterDocPositionAccessBean();
		ab.setInitKey_outerDocPosition(aform.getOuterDocPosition().intValue());
		ab.refreshCopyHelper();
		OuterDocPositionValue value = new OuterDocPositionValue(
			ab,	1, new java.math.BigDecimal(0.0d), new java.math.BigDecimal(0.0d)
		);
		aform.setOuterQty(ab.getOuterQty());
		InWayBillPositionAccessBean bean = new InWayBillPositionAccessBean();
		java.util.Enumeration en = bean.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(ab.getOuterDocPosition()));
		while(en.hasMoreElements()) {
			InWayBillPositionAccessBean pos = (InWayBillPositionAccessBean)en.nextElement();
			value.add(pos.getQty(),pos.getPrice());
		}
		aform.setQty(value.getQty());
		aform.setOrder(new Integer(value.getOrder()));
	    aform.setResource(new Integer(ab.getResource().getResource()));
	    aform.setResourcemodel(ab.getResource().getModel());
	    aform.setResourcename(ab.getResource().getName());
	    aform.setConfiguration(ab.getConfiguration());
    } catch(Exception e) {
	    aform.setOrder(new Integer(0));
	    aform.setResourcecode("");
	    aform.setResourcemodel("");
	    aform.setResourcename("");
	}
	return super.initBrowse(mapping,request,response);
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 19:36:08)
 * @param newConfiguration java.lang.String
 */
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
}
public void setOrder(java.lang.Integer newNumber) {
	order.setInteger(newNumber);
}
public void setOrderstr(String newNumber)
{
	order.setString(newNumber);
}
public void setOuterDocPosition(java.lang.Integer newNumber) {
	outerDocPosition.setInteger(newNumber);
}
public void setOuterDocPositionstr(String newNumber)
{
	outerDocPosition.setString(newNumber);
}
public void setOuterQty(java.math.BigDecimal newDecimal) {
	outerQty.setBigDecimal(newDecimal);
}
public void setOuterQtystr(String newDecimal)
{
	outerQty.setString(newDecimal);
}
public void setQty(java.math.BigDecimal newDecimal) {
	qty.setBigDecimal(newDecimal);
}
public void setQtystr(String newDecimal)
{
	qty.setString(newDecimal);
}
public void setResource(java.lang.Integer newNumber) {
	resource.setInteger(newNumber);
}
public void setResourcecode(String newNumber)
{
	resource.setString(newNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 16:59:37)
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 16:59:37)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
}
