package com.hps.july.basestation.formbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.hps.july.web.util.*;

public class ReportProtocolSfoForm
	extends EditForm
{
	private String sfonumber;
public ReportProtocolSfoForm() {
	setAction("Add");
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Возвращает список ролей, которым разрешено редактирование.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("AllAuthenticated");
	return roles;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSfonumber() {
	return sfonumber;
}
public int getState() {
	return com.hps.july.basestation.APPStates.SFO_PROTOCOL;
}
/**
 * 
 * @param newSfonumber java.lang.String
 */
public void setSfonumber(java.lang.String newSfonumber) {
	sfonumber = newSfonumber;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
}
}
