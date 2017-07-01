package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Акт замены при ремонте"
 */
public class ChangeEPositionListForm
	extends AbstractChangePositionListForm
{
	private String organizationname;
	private String workername;
	private String workertitle;
	private int expedition;
	private String type;
public ChangeEPositionListForm() {
	organizationname = null;
	workername = null;
	workertitle = null;
	type = "A";
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:50:46)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("TechStuff");
	roles.add("siteExploitor");
	roles.add("siteStation");
	roles.add("siteTransport");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 12:35:33)
 * @return int
 */
public int getExpedition() {
	return expedition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:05:27)
 * @return java.lang.String
 */
public java.lang.String getOrganizationname() {
	return organizationname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 18:26:08)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 12:35:33)
 * @param newExpedition int
 */
public void setExpedition(int newExpedition) {
	expedition = newExpedition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:05:27)
 * @param newOrganizationname java.lang.String
 */
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 18:26:08)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
}
