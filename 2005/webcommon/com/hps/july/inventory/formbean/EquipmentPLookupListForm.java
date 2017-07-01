package com.hps.july.inventory.formbean;

import com.hps.july.persistence.StorageAccessBean;

/**
 * Форма выбора устройства на позиции
 */
public class EquipmentPLookupListForm
	extends com.hps.july.web.util.BrowseForm {
	public static final String SERIAL = "S";
	public static final String PARTIAL = "P";
	public static final String BULK = "B";

	private java.lang.Integer restype;
	private java.lang.String restypename;
	private java.lang.Integer ressbtype;
	private java.lang.String ressbtypename;
	private java.lang.String policy;
	private java.lang.String serialnum;
	private java.lang.String partialnum;
	private java.lang.Integer order;
	private java.lang.Integer position;
	private java.lang.String positionname;
	private java.lang.String positionid;
	private java.lang.Integer complect;
	private java.lang.String complectname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public EquipmentPLookupListForm() {
	this.setFinderMethodName( "findByResourceQBE" );
	restype = new Integer(0);
	restypename = "";
	ressbtype = new Integer(0);
	ressbtypename = "";
	position = new Integer(0);
	positionname = "";
	positionid = "";
	complect = new Integer(0);
	complectname = "";
	policy = SERIAL;
	serialnum = "";
	partialnum = "";
	order = new Integer(1);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		(getRessbtype() != null)?getRessbtype():new Integer(0),
		(getPosition() != null)?getPosition():new Integer(0),
		(getPolicy() != null)?getPolicy():SERIAL,
		(getSerialnum() != null)?getSerialnum():"",
		(getPartialnum() != null)?getPartialnum():"",
		getOrder()
	};
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:54:56)
 * @return java.lang.String
 */
public java.lang.String getPartialnum() {
	return partialnum;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:54:42)
 * @return java.lang.String
 */
public java.lang.String getPolicy() {
	return policy;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 15:53:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 15:53:59)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 15:53:59)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 */
public Integer getRessbtype() {
	return ressbtype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:53:28)
 * @return java.lang.String
 */
public java.lang.String getRessbtypename() {
	return ressbtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:33)
 * @return int
 */
public Integer getRestype() {
	return restype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:46)
 * @return java.lang.String
 */
public java.lang.String getRestypename() {
	return restypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:54:42)
 * @return java.lang.String
 */
public java.lang.String getSerialnum() {
	return serialnum;
}
/**
 * Insert the method's description here.
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
 * Creation date: (21.05.2002 16:17:06)
 * @param newOrder java.lang.Integer
 */
public void setOrder(java.lang.Integer newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:54:56)
 * @param newPartialnum java.lang.String
 */
public void setPartialnum(java.lang.String newPartialnum) {
	partialnum = newPartialnum;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:54:42)
 * @param newPolicy java.lang.String
 */
public void setPolicy(java.lang.String newPolicy) {
	policy = newPolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 15:53:59)
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 15:53:59)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 15:53:59)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:58)
 * @param newRessbtype int
 */
public void setRessbtype(Integer newRessbtype) {
	ressbtype = newRessbtype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:53:28)
 * @param newRessbtypename java.lang.String
 */
public void setRessbtypename(java.lang.String newRessbtypename) {
	ressbtypename = newRessbtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:33)
 * @param newRestype int
 */
public void setRestype(Integer newRestype) {
	restype = newRestype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:46)
 * @param newRestypename java.lang.String
 */
public void setRestypename(java.lang.String newRestypename) {
	restypename = newRestypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:54:42)
 * @param newSerialnum java.lang.String
 */
public void setSerialnum(java.lang.String newSerialnum) {
	serialnum = newSerialnum;
}
}
