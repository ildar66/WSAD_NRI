package com.hps.july.basestation.formbean;

import com.hps.july.commonbean.*;
import com.hps.july.persistence2.*;
import javax.servlet.http.*;
import com.hps.july.basestation.valueobject.Validator;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import java.math.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * ‘орма редактировани€ параметров типа этапа
 */
public class EtapTypeForm
	extends com.hps.july.web.util.EditForm
{
	private int etaptypeid;
	private String ettypename;
	private boolean haveendtime;
	private boolean havehopslink;
	private boolean havepaycheck;
public void afterDelete(HttpServletRequest request)
	throws Exception
{
/*
	try {
		SiteDocTypeAccessBean stb = new SiteDocTypeAccessBean();
		stb.setInitKey_sitedoctype(getEtaptypeid());
		stb.refreshCopyHelper();
		stb.getEJBRef().remove();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.etaptype.delete.cantdelsdtype");
	}
*/
}
public void afterUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
/*
	try {
		SiteDocTypeAccessBean stb = new SiteDocTypeAccessBean();
		stb.setInitKey_sitedoctype(getEtaptypeid());
		stb.refreshCopyHelper();
		stb.setSitedoctypename(getEttypename());
		stb.commitCopyHelper();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.etaptype.update.cantupdatesdtype");
	}
*/
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws Exception
{
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setEtaptypeid(keyGen.getNextKey("tables.sitedoctypes"));
	/*
	SiteDocTypeAccessBean stb = new SiteDocTypeAccessBean(
		getEtaptypeid(),
		getEttypename()
	);
	stb.commitCopyHelper();
	*/
	EtapTypeAccessBean bean = new EtapTypeAccessBean(
		getEtaptypeid(),
		getEttypename(),
		isHaveendtime()
	);
	return bean;
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request)
{
	EtapTypeAccessBean bean = new EtapTypeAccessBean();
	bean.setInitKey_etaptypeid(getEtaptypeid());
	return bean;
}
public int getEtaptypeid() {
	return etaptypeid;
}
public java.lang.String getEttypename() {
	return ettypename;
}
public boolean getHaveendtime() {
	return haveendtime;
}
public boolean getHavehopslink() {
	return havehopslink;
}
public boolean getHavepaycheck() {
	return havepaycheck;
}
public int getState() {
	return com.hps.july.basestation.APPStates.ETAPTYPE_FORM;
}
public boolean isHaveendtime() {
	return haveendtime;
}
/**
 * 
 * @return boolean
 */
public boolean isHavepaycheck() {
	return havepaycheck;
}
public boolean isHopslink() {
	return havehopslink;
}
public void setEtaptypeid(int newEtaptypeid) {
	etaptypeid = newEtaptypeid;
}
public void setEttypename(java.lang.String newEttypename) {
	ettypename = newEttypename;
}
public void setHaveendtime(boolean newHaveendtime) {
	haveendtime = newHaveendtime;
}
public void setHavehopslink(boolean newHavehopslink) {
	havehopslink = newHavehopslink;
}
/**
 * 
 * @param newHavepaycheck boolean
 */
public void setHavepaycheck(boolean newHavepaycheck) {
	havepaycheck = newHavepaycheck;
}
public void setHopslink(boolean newHavehopslink) {
	havehopslink = newHavehopslink;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if(ettypename == null || "".equals(ettypename)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etaptype.ettypename.empty"));
	} else if(ettypename.length() > 80) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etaptype.ettypename.length"));
	}
	
	if(!errors.empty())
		throw new ValidationException();
}
}
