package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import java.util.*;

/**
 * Форма для указания параметров печати этикетки со штрих кодом
 */
public class BarSParamsForm extends ReportForm {
	private StringAndIntegerProperty repeatcount;
	private java.lang.String serial;
public BarSParamsForm() {
	repeatcount = new StringAndIntegerProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:54:45)
 * @return java.lang.Integer
 */
public java.lang.Integer getRepeatcount() {
	return repeatcount.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:56:42)
 * @return java.lang.String
 */
public java.lang.String getRepeatcountFrm() {
	return repeatcount.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 17:31:34)
 * @return java.lang.String
 */
public java.lang.String getSerial() {
	return serial;
}
public int getState() {
	return com.hps.july.inventory.APPStates.SERPARAMS;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setSerial("");
	setRepeatcount(new Integer(1));
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:54:45)
 * @param newRepeatcount java.lang.Integer
 */
public void setRepeatcount(java.lang.Integer newRepeatcount) {
	repeatcount.setInteger(newRepeatcount);
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:56:42)
 * @param newRepeatcountFrm java.lang.String
 */
public void setRepeatcountFrm(java.lang.String newRepeatcountFrm) {
	repeatcount.setString(newRepeatcountFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 17:31:34)
 * @param newSerial java.lang.String
 */
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	// Check for presence in cards
	StorageCardAccessBean crd = new StorageCardAccessBean();
	Enumeration sers = crd.findBySerie(getSerial(), getSerial());
	if (!sers.hasMoreElements()) {
		sers = crd.findByPartie(getSerial(), getSerial());
		if (!sers.hasMoreElements())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.notexists"));
	}
	/*
	InventoryNumbersAccessBean abean = new InventoryNumbersAccessBean();
	abean.setInitKey_serid(getSerid());
	abean.refreshCopyHelper();
	StringAndIntegerProperty anum = new StringAndIntegerProperty();
	anum.setString(abean.getSerstart());
	int serstart = anum.getInteger().intValue();
	anum.setString(abean.getSerend());
	int serend = anum.getInteger().intValue();

	anum.setString(getStartnum());
	int prstart = anum.getInteger().intValue();
	int prend = prstart + getPrintcount().intValue() - 1;
	
	if ( (prstart < serstart) || (prstart > serend) ||
		 (prend < serstart) || (prend > serend) )
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.printint"));

	*/
	 
	if (!errors.empty())
		throw new ValidationException();
		
}
}
