package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.persistence2.*;
import java.util.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * Базовая форма для документов
 */
public class DocForm
	extends EditForm
{
	private int sitedoc;
	private int[] selfiles;
	private String username;
	private boolean admin;
public DocForm() {
	super();
}
protected DocResourceValueObject[] convert2DocResourcesInt(Integer[] array, Hashtable resfreq)
{
	if(array != null) {
		DocResourceValueObject[] l = new DocResourceValueObject[array.length];
		for(int i = 0; i < array.length; i++) {
			Object rf = resfreq.get(String.valueOf(array[i].intValue()));
			String rfs = null;
			if(rf != null && rf instanceof String) {
				rfs = (String)rf;
			}
			l[i] = new DocResourceValueObject(array[i].intValue(), rfs);
		}
		return l;
	} else {
		return null;
	}
}
protected int[] convertLInt(Integer[] array)
{
	if(array != null) {
		int[] l = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			l[i] = array[i].intValue();
		}
		return l;
	} else {
		return null;
	}
}
public void deleteSelected()
{
	System.out.println("DELETE SELECTED FILES!");
	if(selfiles != null) {
		for(int i = 0; i < selfiles.length; i++) {
			try {
				SiteDocFileAccessBean file = new SiteDocFileAccessBean();
				file.setInitKey_sitedocfile(selfiles[i]);
				file.refreshCopyHelper();
				file.getEJBRef().remove();
				System.out.println("Deleted file id:"+selfiles[i]);
			} catch(Exception e) {
				System.out.println("Can't delete SITEDOCFILE#"+selfiles[i]+", reason:"+e.getClass().getName()+" msg:"+e.getMessage());
			}
		}
	} else {
		System.out.println("SELFILES is NULL");
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public int[] getSelfiles() {
	return selfiles;
}
public int getSitedoc() {
	return sitedoc;
}
public int getState() {
	return com.hps.july.basestation.APPStates.RRL_FORM;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getUsername() {
	return username;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	sitedoc = -1;
}
/**
 * 
 * @return boolean
 */
public boolean isAdmin() {
	return admin;
}
public static boolean isExpired(java.sql.Date d)
{
	boolean res = true;
	if(d != null) {
		java.util.Date c = new java.util.Date();
		if(d.getYear() > c.getYear()) {
			res = false;
		} else if(d.getYear() == c.getYear()) {
			if(d.getMonth() > c.getMonth()) {
				res = false;
			} else if(d.getMonth() == c.getMonth()) {
				if(d.getDate() >= c.getDate()) {
					res = false;
				}
			}
		}
	}
	return res;
}
public void setSelfiles(int[] newSelfiles) {
	selfiles = newSelfiles;
}
public void setSitedoc(int newSitedoc) {
	sitedoc = newSitedoc;
}
public void setUser(javax.servlet.http.HttpServletRequest request)
{
	username = request.getRemoteUser();
	admin = request.isUserInRole("administrator");
}
}
