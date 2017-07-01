package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка документов "Акты инвентаризации по позиции"
 */
public class ContractorInventoryList
	extends BrowseForm
{
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	private Integer owner;
	private String ownername;
	private Integer position;
	private String positionid;
	private String positionname;
	private Boolean showallowner;
	private Boolean showallstorage;
	private Integer order;

	private Integer sortType = new Integer(1);
	private StringAndIntegerProperty contractor = new StringAndIntegerProperty();
	private java.lang.String contractorname;
	private java.lang.String type;
public ContractorInventoryList() {
	this.setFinderMethodName( "listPositionInventoryDocuments" );
	setLastVisited(true);
	
	datefrom = new StringAndSqlDateProperty();
	dateto = new StringAndSqlDateProperty();
	setShowallstorage(Boolean.TRUE);
	order = new Integer(1);
	owner = new Integer(0);
	position = null;
	type="A";
	setDatefrom(new java.sql.Date(System.currentTimeMillis()));
	setDateto(new java.sql.Date(System.currentTimeMillis()));
	setShowallowner(Boolean.FALSE);

	try {
		java.util.Enumeration en = getOrganizations();
		if(en.hasMoreElements()) {
			OrganizationAccessBean o = (OrganizationAccessBean)en.nextElement();
			setOwner(new Integer(o.getOrganization()));
			setOwnername(o.getName());
		}
	} catch(Exception e) {
	}
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public Integer getContractor() {
	return contractor.getInteger();
}
public String getContractorcode() {
	return contractor.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getContractorname() {
	return contractorname;
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
 * Creation date: (10.09.2002 11:28:22)
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
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	String s = super.getFinderMethodName();
	try {
		sortType = Integer.valueOf(s);
	} catch (NumberFormatException e) {
	}

	return new Object[] {
		Boolean.TRUE, getDatefrom(), getDateto(),
		(getShowallowner() != null && getShowallowner().booleanValue())?Boolean.FALSE:Boolean.TRUE, 
		(getOwner() != null)?getOwner():new Integer(0),
		(getShowallstorage() != null && getShowallstorage().booleanValue())?Boolean.FALSE:Boolean.TRUE,
		(getPosition() != null)?getPosition():new Integer(0),
		(getType() != null && getType().equals("P"))?Boolean.TRUE:Boolean.FALSE,
		(getContractorcode() != null)?new Integer(getContractorcode()):new Integer(0),
		sortType
	};
}
public String getFinderMethodName() {
	return "listContractorDocuments";
}
public static String getIDPosition(PositionAccessBean p) {
	String id = "";
	try {
		if(p.getGsmid() != null) {
			id = "D" + p.getGsmid() + " ";
		}
		if(p.getDampsid() != null) {
			id = id + "A" + p.getDampsid() + " ";
		}
	} catch(Exception e) {
	}
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:54:57)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2002 14:05:43)
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
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 16:25:18)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 16:24:07)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 15:38:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 15:38:13)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:05:46)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowallowner() {
	return showallowner;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:06:08)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowallstorage() {
	return showallstorage;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 17:38:00)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 12:12:12)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
public void log(String arg) {
    //System.out.println("*#* PosListForm."+arg);
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 13:24:28)
 * @param newContractor com.hps.july.web.util.StringAndIntegerProperty
 */
public void setContractor(com.hps.july.web.util.StringAndIntegerProperty newContractor) {
	contractor = newContractor;
}
public void setContractorcode(String newContractor) {
	contractor.setString(newContractor);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @param newRentername java.lang.String
 */
public void setContractorname(java.lang.String newContractorname) {
	contractorname = newContractorname;
}
public void setDatefrom(java.sql.Date newDatefrom) {
	datefrom.setSqlDate(newDatefrom);
	log("setDatefrom("+newDatefrom+")");
}
public void setDatefromstr(String newDatefrom) {
	datefrom.setString(newDatefrom);
	log("setDatefromstr("+newDatefrom+")");
}
public void setDateto(java.sql.Date newDateto) {
	dateto.setSqlDate(newDateto);
	log("setDateto("+newDateto+")");
}
public void setDatetostr(String newDateto) {
	dateto.setString(newDateto);
	log("setDatetostr("+newDateto+")");
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:54:57)
 * @param newOrder java.lang.Integer
 */
public void setOrder(java.lang.Integer newOrder) {
	order = newOrder;
	log("setOrder("+newOrder+")");
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 16:26:05)
 * @param newPlace java.lang.Integer
 */
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
	log("setOwner("+newOwner+")");
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 16:24:07)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
	log("setOwnername("+newOwnername+")");
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 15:38:13)
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
	log("setPosition("+newPosition+")");
}
/**
 * 
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 15:38:13)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
	log("setPositionname("+newPositionname+")");
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:05:46)
 * @param newShowallowner java.lang.Boolean
 */
public void setShowallowner(java.lang.Boolean newShowallowner) {
	showallowner = newShowallowner;
	log("setShowallowner("+newShowallowner+")");
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2002 18:06:08)
 * @param newShowallstorage java.lang.Boolean
 */
public void setShowallstorage(java.lang.Boolean newShowallstorage) {
	showallstorage = newShowallstorage;
	log("setShowallstorage("+newShowallstorage+")");
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 12:12:12)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void validateValues(ActionErrors errors)
	throws Exception 
{
	if(getShowallstorage() != null && !getShowallstorage().booleanValue()) {
		try {
			PositionAccessBean p = new PositionAccessBean();
			p.setInitKey_storageplace(getPosition().intValue());
			p.refreshCopyHelper();
			setPositionid(getIDPosition(p));
			setPositionname(p.getName());
			setPosition(new Integer(p.getStorageplace()));
		} catch(Exception e) {
			setPositionid("");
			setPositionname("");
		}
	}
	/*if(getShowallcomplect() != null && !getShowallcomplect().booleanValue() && getComplect() != null) {
		try {
			EquipmentSetAccessBean b = new EquipmentSetAccessBean();
			b.setInitKey_storageplace(getComplect().intValue());
			b.refreshCopyHelper();
			setPositionid(getIDPosition(b.getPosition()));
			setPositionname(b.getPosition().getName());
			setPosition(new Integer(b.getPosition().getStorageplace()));
			//setComplectname(com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(b));
		} catch(Exception e) {
			//setPosition(new Integer(0));
			//setPositionid("");
			//setPositionname("");
			setComplectname("");
		    //e.printStackTrace(System.out);
		}
	}*/

	//	if (!errors.empty()) throw new ValidationException();
}
}
