package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма для указания параметров печати серии инвентарных номеров 
 */
public class BarParamsForm
	extends ReportForm
{
	private java.lang.String startnum;
	private StringAndIntegerProperty printcount;
	private StringAndIntegerProperty repeatcount;
	private java.lang.String serie;
	private int serid;
	private java.lang.String sprefix;
public BarParamsForm() {
	printcount = new StringAndIntegerProperty();
	repeatcount = new StringAndIntegerProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:54:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getPrintcount() {
	return printcount.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:56:20)
 * @return java.lang.String
 */
public java.lang.String getPrintcountFrm() {
	return printcount.getString();
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
 * Creation date: (13.11.2002 16:21:50)
 * @return int
 */
public int getSerid() {
	return serid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 16:10:37)
 * @return java.lang.String
 */
public java.lang.String getSerie() {
	return serie;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 16:10:20)
 * @return java.lang.String
 */
public java.lang.String getSprefix() {
	return sprefix;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:53:16)
 * @return java.lang.String
 */
public java.lang.String getStartnum() {
	return startnum;
}
public int getState() {
	return com.hps.july.inventory.APPStates.BARPARAMS;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	InventoryNumbersAccessBean abean = new InventoryNumbersAccessBean();
	abean.setInitKey_serid(getSerid());
	abean.refreshCopyHelper();
	setSerie(abean.getSerprefix() + abean.getSerstart() + " - " + abean.getSerprefix() + abean.getSerend());
	setStartnum(abean.getSerstart());
	StringAndIntegerProperty anum = new StringAndIntegerProperty();
	anum.setString(abean.getSerstart());
	int serstart = anum.getInteger().intValue();
	anum.setString(abean.getSerend());
	int serend = anum.getInteger().intValue();
	setPrintcount(new Integer(serend-serstart+1));
	setRepeatcount(new Integer(1));
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:54:09)
 * @param newPrintcount java.lang.Integer
 */
public void setPrintcount(java.lang.Integer newPrintcount) {
	printcount.setInteger(newPrintcount);
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:56:20)
 * @param newPrintcountFrm java.lang.String
 */
public void setPrintcountFrm(java.lang.String newPrintcountFrm) {
	printcount.setString(newPrintcountFrm);
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
 * Creation date: (13.11.2002 16:21:50)
 * @param newSerid int
 */
public void setSerid(int newSerid) {
	serid = newSerid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 16:10:37)
 * @param newSerie java.lang.String
 */
public void setSerie(java.lang.String newSerie) {
	serie = newSerie;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 16:10:20)
 * @param newSprefix java.lang.String
 */
public void setSprefix(java.lang.String newSprefix) {
	sprefix = newSprefix;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 11:53:16)
 * @param newStartnum java.lang.String
 */
public void setStartnum(java.lang.String newStartnum) {
	startnum = newStartnum;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
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
	  
	if (!errors.empty())
		throw new ValidationException();

	// Set prefix for printing
	setSprefix(abean.getSerprefix());

}
}
