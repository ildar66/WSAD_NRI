package com.hps.july.basestation.formbean;

import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;

/**
 * Форма редактирования мощьности каналов
 */
public class ShowChanalPowerForm
	extends EditForm
{
	private com.hps.july.basestation.valueobject.ChanalPowers[] chanalPower900;
	private int positionNum;
	private String positionName;
	private String address;
	private int basestationNum;
	private String basestationName;
	private com.hps.july.basestation.valueobject.ChanalPowers[] chanalPower1800;
	private int basestation;

	public java.util.ArrayList range = new ArrayList();
	public java.util.ArrayList range1800 = new ArrayList();
	private java.util.ArrayList r900;
	private java.util.ArrayList r1800;
public ShowChanalPowerForm() {
	super();
	chanalPower900 = null;
	chanalPower1800 = null;
	setAction("Add");
}
public void checkRangeSize(java.util.ArrayList arList, int index) {
	int asize = arList.size();
	if (asize < (index+1)) {
		for (int i=0; i < index+1 - asize; i++) {
			arList.add(new RangeAllow());
		}
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:20:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception
{
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public int getApplication() {
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 11:38:26)
 * @return int
 */
public int getBasestation() {
	return basestation;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @return java.lang.String
 */
public java.lang.String getBasestationName() {
	return basestationName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @return int
 */
public int getBasestationNum() {
	return basestationNum;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 14:21:46)
 * @return com.hps.july.basestation.valueobject.ChanalPowers[]
 */
public com.hps.july.basestation.valueobject.ChanalPowers[] getChanalPower1800() {
	return chanalPower1800;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 19:22:05)
 * @return com.hps.july.basestation.formbean.ChanalPower[]
 */
public com.hps.july.basestation.valueobject.ChanalPowers[] getChanalPower900() {
	return chanalPower900;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:12:41)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @return java.lang.String
 */
public java.lang.String getPositionName() {
	return positionName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @return int
 */
public int getPositionNum() {
	return positionNum;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 13:43:58)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getR1800() {
	return r1800;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 13:43:30)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getR900() {
	return r900;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 18:19:16)
 * @return java.util.ArrayList
 */
public RangeAllow getRange(int index) {
	checkRangeSize(range, index);
	System.err.println("900 >>>>>>>>>>>>>> " + index + ">>>>>>" + range.get(index));
	return (RangeAllow)range.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 18:19:36)
 * @return java.util.ArrayList
 */
public RangeAllow getRange1800(int index) {
	checkRangeSize(range1800, index);
	System.err.println("1800 >>>>>>>>>>>>>> " + index + ">>>>>>" + range1800.get(index));
	return (RangeAllow)range1800.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 18:19:36)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getRange1800All() {
	return range1800;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 18:19:16)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getRangeAll() {
	return range;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public int getState() {
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 11:38:26)
 * @param newBasestation int
 */
public void setBasestation(int newBasestation) {
	basestation = newBasestation;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @param newBasestationName java.lang.String
 */
public void setBasestationName(java.lang.String newBasestationName) {
	basestationName = newBasestationName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @param newBasestationNum int
 */
public void setBasestationNum(int newBasestationNum) {
	basestationNum = newBasestationNum;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 14:21:46)
 * @param newChanalPower1800 com.hps.july.basestation.valueobject.ChanalPowers[]
 */
public void setChanalPower1800(com.hps.july.basestation.valueobject.ChanalPowers[] newChanalPower1800) {
	chanalPower1800 = newChanalPower1800;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 19:22:05)
 * @param newChanalPower com.hps.july.basestation.formbean.ChanalPower[]
 */
public void setChanalPower900(com.hps.july.basestation.valueobject.ChanalPowers[] newChanalPower) {
	chanalPower900 = newChanalPower;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @param newPositionName java.lang.String
 */
public void setPositionName(java.lang.String newPositionName) {
	positionName = newPositionName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 10:20:45)
 * @param newPositionNum int
 */
public void setPositionNum(int newPositionNum) {
	positionNum = newPositionNum;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 13:43:58)
 * @param newR1800 java.util.ArrayList
 */
public void setR1800(java.util.ArrayList newR1800) {
	r1800 = newR1800;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 13:43:30)
 * @param newR900 java.util.ArrayList
 */
public void setR900(java.util.ArrayList newR900) {
	r900 = newR900;
}
}
