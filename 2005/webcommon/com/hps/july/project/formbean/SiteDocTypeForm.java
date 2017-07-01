package com.hps.july.project.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import org.apache.struts.action.*;
import java.math.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования типа документа.
 * Creation date: (25.09.2002 19:26:04)
 * 
 */
public class SiteDocTypeForm extends EditForm {

private int sitedoctype;
private String sitedoctypetxt;
public static final String field_sitedoctypetxt="sitedoctypetxt";

private String sitedoctypename;
public static final String field_sitedoctypename="sitedoctypename";

public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {

    

    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    sitedoctype = keygen.getNextKey(TablesRef.SITEDOCTYPES);

    SiteDocTypeAccessBean bean =
        new SiteDocTypeAccessBean(sitedoctype, sitedoctypename);

    

    return bean;
}
public int getApplication() {
    return com.hps.july.constants.Applications.PROJECT;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {

    SiteDocTypeAccessBean bean = new SiteDocTypeAccessBean();
    try {
        bean.setInitKey_sitedoctype(sitedoctype);
        bean.refreshCopyHelper();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2003 15:51:29)
 * @return int
 */
public int getSitedoctype() {
	return sitedoctype;
}
public String getSitedoctypename(){
return sitedoctypename;
}
public String getSitedoctypetxt(){
return sitedoctypetxt;
}
public int getState() {
return com.hps.july.project.APPStates.SiteDocTypeForm;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2003 15:51:29)
 * @param newSitedoctype int
 */
public void setSitedoctype(int newSitedoctype) {
	sitedoctype = newSitedoctype;
}
public void setSitedoctypename(String arg){
sitedoctypename=arg;
}
public void setSitedoctypetxt(String arg){
sitedoctypetxt=arg;
}
public void validateValues(ActionErrors errors) throws Exception {
    try {
        //valid condition for sitedoctypetxt
    } catch (Exception e) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.SiteDocTypeForm.sitedoctypetxt"));
    }
    try {
        //valid condition for sitedoctypename
        if (sitedoctypename == null || sitedoctypename.trim().length() == 0)
            throw new Exception();
    } catch (Exception e) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.SiteDocTypeForm.sitedoctypename"));
    }
    if (!errors.empty())
        throw new ValidationException();
}
}
