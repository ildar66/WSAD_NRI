package com.hps.july.basestation.formbean;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.hps.july.jdbcpersistence.lib.*;
/**
 * Ôמנלא הכÿ ןמטסךא מעקועשג ןמ םמלונף פאיכא
 * Creation date: (10.08.2004 17:28:35)
 */
public class ReportFinderForm extends ActionForm {
	private StringAndInteger filenumber = new StringAndInteger();
	private java.lang.String action;
/**
 * Insert the method's description here.
 * Creation date: (13.08.2004 11:25:28)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 18:02:04)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 17:29:07)
 * @return int
 */
public int getFilenumber() {
	return filenumber.getInt();
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 17:34:05)
 * @return java.lang.String
 */
public java.lang.String getFilenumberFrm() {
	return filenumber.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 18:09:25)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.REPORT_HAVEPLAN_LOOKUP;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2004 11:25:28)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 17:29:07)
 * @param newFilenumber int
 */
public void setFilenumber(int newFilenumber) {
	filenumber.setInt(newFilenumber);
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 17:34:05)
 * @param newFilenumberFrm java.lang.String
 */
public void setFilenumberFrm(java.lang.String newFilenumberFrm) {
	filenumber.setString(newFilenumberFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 17:30:53)
 * @return org.apache.struts.action.ActionErrors
 * @param mapping org.apache.struts.action.ActionMapping
 */
public void validateValues(ActionErrors errors) throws com.hps.july.web.util.ValidationException {
	if(filenumber.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reports.haveplan.filenumber"));
	} else if(!filenumber.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reports.haveplan.filenumber"));
	}
	if (!errors.empty())
		throw new com.hps.july.web.util.ValidationException();
}
}
