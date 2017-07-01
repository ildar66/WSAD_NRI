package com.hps.july.siteinfo.formbean;

import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
 * Форма редактирования суперрегиона
 */
public class SuperRegionForm extends com.hps.july.web.util.EditForm {
	private int supregid;
	private String supregname;
	private StringAndIntegerProperty supregcode = new StringAndIntegerProperty();
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws java.lang.Exception
{
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setSupregid(keyGen.getNextKey(TablesRef.SUPERREGIONS));
    SuperRegionAccessBean bean = new SuperRegionAccessBean(getSupregid(),getSupregname(),getSupregcode());	
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	SuperRegionAccessBean bean = new SuperRegionAccessBean();
	bean.setInitKey_supregid( getSupregid() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.SREGIONEDIT;
}
public int getSupregcode() {
	if(supregcode.getInteger() != null) {
		return supregcode.getInteger().intValue();
	} else {
		return 0;
	}
}
public String getSupregcodeFrm() {
	return supregcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 22:00:24)
 * @return int
 */
public int getSupregid() {
	return supregid;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 22:00:24)
 * @return java.lang.String
 */
public java.lang.String getSupregname() {
	return supregname;
}
public void setSupregcode(int newSupregcode) {
	supregcode.setInteger(new Integer(newSupregcode));
}
public void setSupregcodeFrm(String newSupregcode) {
	supregcode.setString(newSupregcode);
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 22:00:24)
 * @param newSupregid int
 */
public void setSupregid(int newSupregid) {
	supregid = newSupregid;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 22:00:24)
 * @param newSupregname java.lang.String
 */
public void setSupregname(java.lang.String newSupregname) {
	supregname = newSupregname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getSupregname() == null) || (getSupregname().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.superregregion.name"));
	}

	if (supregcode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.superregregion.supregcode"));
	} else if (!supregcode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.superregregion.supregcode"));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
