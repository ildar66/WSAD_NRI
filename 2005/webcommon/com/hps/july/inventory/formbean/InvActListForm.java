package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма всписка документов "Акты инвентаризации на складе"
 */
public class InvActListForm
	extends BaseStorageListForm
{
//	private StringAndSqlDateProperty datefrom;
//	private StringAndSqlDateProperty dateto;
//	private java.lang.Integer owner;
//	private java.lang.String ownername;
//	private java.lang.Integer place;
//	private java.lang.Integer placename;
//	private java.lang.Boolean showallowner;
//	private java.lang.Boolean showallstorage;
//	private java.lang.Integer order;
//	private Integer sortType = new Integer(1);
public InvActListForm() {
	super();
	this.setFinderMethodName( "4" );
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getDatefrom(), getDateto(),
		getIsowner().booleanValue()?Boolean.FALSE:Boolean.TRUE, getOwner().getInteger() != null?getOwner().getInteger():new Integer(0),
		getIsstorage().booleanValue()?Boolean.FALSE:Boolean.TRUE, getStorage().getInteger() != null?getStorage().getInteger():new Integer(0),
		get_isadmin(), (get_username() != null?get_username():""),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listStorageInventoryDocuments";
}
public ActionForward initBrowse(ActionMapping mapping, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	throws java.io.IOException, javax.servlet.ServletException
{
	ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.IVALIST);
	return super.initBrowse(mapping,request,response);
}
}
