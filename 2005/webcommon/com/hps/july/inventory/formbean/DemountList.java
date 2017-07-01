package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка документов "Акты демонтажа на позиции"
 */
public class DemountList
	extends BrowseForm
{
	private Boolean isowner;
	private StringAndIntegerProperty owner;
//	private String ownername;
	
	private Boolean isposition;
	private StringAndIntegerProperty position;
	private String positionid;
	private String positionname;

	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	
	private String type;
	
	private StringAndIntegerProperty provider;
	private String providername;
	
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private int ordering;
	private Integer sortType = new Integer(1);
public DemountList() {
	setLastVisited(true);
	isowner = Boolean.FALSE;
	owner = new StringAndIntegerProperty();

	isposition = Boolean.FALSE;
	position = new StringAndIntegerProperty();
	positionid = "";
	positionname = "";

	datefrom = new StringAndSqlDateProperty();
	datefrom.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	dateto = new StringAndSqlDateProperty();
	dateto.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));

	type = "A";

	provider = new StringAndIntegerProperty();
	providername = "";

	worker = new StringAndIntegerProperty();
	workername = "";
	
	this.setFinderMethodName( "listDemountDocuments" );
	try {
		java.util.Enumeration eno = getOwners();
		if (eno.hasMoreElements()) {
			try {
				OrganizationAccessBean org = (OrganizationAccessBean)eno.nextElement();
				owner.setInteger(new Integer(org.getOrganization()));
			} catch (Exception ex) {
			}
		}
	} catch(Exception e) {
	}
	sortType = new Integer(4);
}
public java.sql.Date getDatefrom() {
	return datefrom.getSqlDate();
}
public String getDatefromstr() {
	return datefrom.getString();
}
public java.sql.Date getDateto() {
	return dateto.getSqlDate();
}
public String getDatetostr() {
	return dateto.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:14:47)
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
public java.lang.Object[] getFilterParams() {
	String s = super.getFinderMethodName();
	try {
		sortType = new Integer(Integer.parseInt(s));
	} catch (Exception e) {
	}
	return new Object[] { 
		Boolean.TRUE.equals(isowner)?Boolean.FALSE:Boolean.TRUE, (owner.getInteger() == null)?new Integer(0):owner.getInteger(),
		Boolean.TRUE, getDatefrom(), getDateto(),
		Boolean.TRUE.equals(isposition)?Boolean.FALSE:Boolean.TRUE, (position.getInteger() == null)?new Integer(0):position.getInteger(),
		(type != null)?type:"",
		(provider.getInteger() == null)?new Integer(0):provider.getInteger(),
		(worker.getInteger() == null)?new Integer(0):worker.getInteger(),
		sortType
	};
}
public String getFinderMethodName() {
	return "listDemountDocuments";
}
public java.lang.Boolean getIsowner() {
	return isowner;
}
public java.lang.Boolean getIsposition() {
	return isposition;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 13:00:43)
 * @return int
 */
public int getOrdering() {
	return ordering;
}
public String getOwnercode() {
	return owner.getString();
}
public int getOwnerKey() {
	if(owner.getInteger() != null) {
		return owner.getInteger().intValue();
	} else {
		return -1;
	}
}
public java.util.Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public String getPositioncode() {
	return position.getString();
}
public java.lang.String getPositionid() {
	return positionid;
}
public java.lang.String getPositionname() {
	return positionname;
}
public Integer getProvider() {
	return provider.getInteger();
}
public String getProvidercode() {
	return provider.getString();
}
public java.lang.String getProvidername() {
	return providername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
public Integer getWorker() {
	return worker.getInteger();
}
public String getWorkercode() {
	return worker.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public void setDatefrom(java.sql.Date newDate) {
	datefrom.setSqlDate(newDate);
}
public void setDatefromstr(String newDate) {
	datefrom.setString(newDate);
}
public void setDateto(java.sql.Date newDate) {
	dateto.setSqlDate(newDate);
}
public void setDatetostr(String newDate) {
	dateto.setString(newDate);
}
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
public void setIsposition(java.lang.Boolean newIsposition) {
	isposition = newIsposition;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 13:00:43)
 * @param newOrdering int
 */
public void setOrdering(int newOrdering) {
	ordering = newOrdering;
}
public void setOwnercode(String newOwner) {
	owner.setString(newOwner);
}
public void setPositioncode(java.lang.String newNumber) {
	position.setString(newNumber);
}
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
public void setProvidercode(String newProvider) {
	provider.setString(newProvider);
}
public void setProvidername(java.lang.String newProvidername) {
	providername = newProvidername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setWorkercode(String newWorker) {
	worker.setString(newWorker);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if(getProvider() != null) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(getProvider().intValue());
			bean.refreshCopyHelper();
			setProvidername(bean.getName());
		} catch(Exception e) {
		}
	}
	if(getWorker() != null) {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(getWorker().intValue());
			bean.refreshCopyHelper();
			setWorkername(bean.getMan().getFullName());
			setWorkertitle(bean.getPosition().getName());
		} catch(Exception e) {
		}
	}
	if(getPositioncode() != null) {
		try {
			int pc = Integer.parseInt(getPositioncode());
			PositionAccessBean p = new PositionAccessBean();
			p.setInitKey_storageplace(pc);
			p.refreshCopyHelper();
			setPositionname(p.getName());
			String positionid = "";
			if(p.getGsmid() != null) {
				positionid = positionid + "D" + p.getGsmid();
			}
			positionid = positionid + " ";
			if(p.getDampsid() != null) {
				positionid = positionid + "A" + p.getDampsid();
			}
			setPositionid(positionid);
		} catch(Exception e) {
		}
	}
}
}
