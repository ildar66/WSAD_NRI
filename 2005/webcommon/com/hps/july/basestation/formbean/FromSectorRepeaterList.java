package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import com.hps.july.basestation.*;

/**
 * Форма списка репитеров сектора
 */
public class FromSectorRepeaterList
	extends EquipmentListForm
{
	private int idsect;
	private String position;
	private String zone;
	private String address;
	private String number;
	private String donornumber;
	private String name;
	private String donorname;
	private String type;
	private int positionId;
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 15:08:58)
 * @return java.lang.String
 */
public String actionName() {
	return "ShowFromSectorRepeaterList.do";
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 15:08:58)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.RepiterAccessBean";
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getDonorname() {
	return donorname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getDonornumber() {
	return donornumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 15:08:58)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { Boolean.TRUE, new Integer(getIdsect()), new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE";
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 15:37:01)
 * @return int
 */
public int getIdsect() {
	return idsect;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2003 17:54:53)
 * @return int
 */
public int getPositionId() {
	return positionId;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 15:08:58)
 * @return int
 */
public int getState() {
	return APPStates.FROMSECTOR_REPEATER_LIST;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @return java.lang.String
 */
public java.lang.String getZone() {
	return zone;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 17:49:43)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void prepare(javax.servlet.http.HttpServletRequest request) {
	super.prepare(request);
	
	try {
		SectorAccessBean sectorBean = new SectorAccessBean();
		sectorBean.setInitKey_idsect(getIdsect());
		sectorBean.refreshCopyHelper();

		if(sectorBean.getEquipment() != null) {
			if(sectorBean.getEquipment().getPosition() != null) {
				setPosition(sectorBean.getEquipment().getPosition().getName());
				setPositionId(sectorBean.getEquipment().getPositionKey().storageplace);
				setZone(sectorBean.getEquipment().getPosition().getNetZone().getName());
				setAddress(sectorBean.getEquipment().getPosition().getAddress());
				//setPlanstate(sectorBean.getEquipment().getPosition().getPlanstate());
			}
			setNumber(Integer.toString(sectorBean.getEquipment().getNumber()));
			setName(sectorBean.getEquipment().getName());
			setType(sectorBean.getEquipment().getStationType());
		}	
		setDonornumber(sectorBean.getNumsect());
		setDonorname(sectorBean.getNamesect());
	} catch (Exception e) {
		e.printStackTrace();
		setPosition(null);
		setPositionId(0);
		setZone(null);
		setAddress(null);
		setNumber(null);
		setName(null);
		setType(null);
		setDonornumber(null);
		setDonorname(null);
//		setPlanstate("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newDonorname java.lang.String
 */
public void setDonorname(java.lang.String newDonorname) {
	donorname = newDonorname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newDonornumber java.lang.String
 */
public void setDonornumber(java.lang.String newDonornumber) {
	donornumber = newDonornumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 15:37:01)
 * @param newIdsect int
 */
public void setIdsect(int newIdsect) {
	idsect = newIdsect;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newPosition java.lang.String
 */
public void setPosition(java.lang.String newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2003 17:54:53)
 * @param newPositionId int
 */
public void setPositionId(int newPositionId) {
	positionId = newPositionId;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2003 17:59:54)
 * @param newZone java.lang.String
 */
public void setZone(java.lang.String newZone) {
	zone = newZone;
}
}
