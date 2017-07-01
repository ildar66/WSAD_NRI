package com.hps.july.sitedoc.formbean;

import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.ValidationException;

import com.hps.july.sitedoc.valueobject.*;
import com.hps.july.sitedoc.*;
import com.hps.july.jdbcpersistence.lib.*;

import com.hps.july.web.util.*;
import com.hps.july.commonbean.*;
import java.util.*;

/**
 * Форма связывания файла с документом
 */ 
public class SiteDocFileForm extends EditForm  {
    private int sitedocfile;
    private StringAndSqlDateProperty sitedocfiledate =
        new StringAndSqlDateProperty();
    private byte[] sitedocfilebody;
    private String note;

    private org.apache.struts.upload.FormFile sitedocfilebodyFrm;
    private String sitedocfilename;

    private People man;
public void afterUpdate(
    com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean,
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {
    if (sitedocfilebodyFrm != null) {

     updateSitedocfilebody(((SiteDocFileAccessBean)bean).getSitedocfile());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
		SiteDocFileAccessBean fileBean=(SiteDocFileAccessBean) bean;
		fileBean.setSitedocfiledate(new java.sql.Date(System.currentTimeMillis()));
		fileBean.commitCopyHelper();
		
		}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {

    SiteDocForm siteDocForm =
        (SiteDocForm) request.getSession().getAttribute("SiteDocForm");

    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    sitedocfile = keygen.getNextKey(TablesRef.SITEDOCFILES);

    SiteDocFileAccessBean bean =
        new SiteDocFileAccessBean( sitedocfile,siteDocForm.getSitedoc());

    

    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
    try {
        SiteDocFileAccessBean fileBean = (SiteDocFileAccessBean) bean;

        SiteDocFileBLOBAccessBean bodyBean = new SiteDocFileBLOBAccessBean();
        bodyBean.setInitKey_sitedocfile(fileBean.getSitedocfile());
        bodyBean.refreshCopyHelper();
        sitedocfilebody = bodyBean.getSitedocfilebody();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEDOC;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {

    SiteDocFileAccessBean bean = new SiteDocFileAccessBean();
    try {
        bean.setInitKey_sitedocfile(sitedocfile);
        bean.refreshCopyHelper();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 18:04:56)
 * @return com.hps.july.persistence.ProjectAction
 */
public People getMan()throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 18:54:49)
 * @return java.lang.String
 */
public java.lang.String getNote() {
	return note;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 9:42:37)
 * @return int
 */
public int getSitedocfile() {
	return sitedocfile;
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 19:16:01)
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getSitedocfilebodyFrm() {
	
	
	return sitedocfilebodyFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 18:42:01)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getSitedocfiledateFrm() {
    return sitedocfiledate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 19:12:57)
 * @return java.lang.String
 */
public java.lang.String getSitedocfilename() {
	return sitedocfilename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return APPStates.SiteDocFileForm;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {
    sitedocfiledate = new StringAndSqlDateProperty();
    //projectactionCode = new StringAndIntegerProperty();
    note = "";
    sitedocfilebody = null;
    sitedocfilebodyFrm = null;
    sitedocfilename = null;


    setAction(request.getParameter("action"));
DebugSupport.printlnTest("!!!!!!SiteDocFileForm action="+getAction() );
   
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 18:04:56)
 * @param newProjectAction com.hps.july.persistence.ProjectAction
 */
public void setMan(PeopleAccessBean man)
    throws Exception {
    

   

}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 18:54:49)
 * @param newNotes java.lang.String
 */
public void setNote(java.lang.String newNotes) {
	note = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 9:42:37)
 * @param newSitedocfile int
 */
public void setSitedocfile(int newSitedocfile) {
	sitedocfile = newSitedocfile;
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 19:22:25)
 * @param newDocbody byte[]
 */
public void setSitedocfilebody(byte[] newDocbody) {
    sitedocfilebody = newDocbody;
    if (sitedocfilebodyFrm == null)
        sitedocfilebodyFrm = null;
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 19:16:01)
 * @param newDocbodyFrm org.apache.struts.upload.FormFile
 */
public void setSitedocfilebodyFrm(org.apache.struts.upload.FormFile bodyFrm)
    throws Exception {
    sitedocfilebodyFrm = bodyFrm;

    if (sitedocfilebodyFrm.getFileName().trim().length() > 0) {
        sitedocfilebody = sitedocfilebodyFrm.getFileData();
        sitedocfilename = sitedocfilebodyFrm.getFileName();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 18:42:01)
 * @param newDocdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setSitedocfiledate(java.sql.Date date) {
    sitedocfiledate.setSqlDate(date);
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 18:42:01)
 * @param newDocdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setSitedocfiledateFrm(String dateFrm) {
    sitedocfiledate.setString(dateFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 19:12:57)
 * @param newDocname java.lang.String
 */
public void setSitedocfilename(java.lang.String newDocname) {
	sitedocfilename = newDocname;
	if(sitedocfilename==null) sitedocfilebodyFrm=null;
	
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 19:22:25)
 * @param newDocbody byte[]
 */
public void updateSitedocfilebody(int id) throws Exception {
    try {
        SiteDocFileBLOBAccessBean blobBean = new SiteDocFileBLOBAccessBean();
        blobBean.setInitKey_sitedocfile(id);
        blobBean.refreshCopyHelper();
        blobBean.setSitedocfilebody(sitedocfilebody);
        blobBean.commitCopyHelper();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
public void validateValues(ActionErrors errors) throws Exception {
 

    if(sitedocfilebody==null||sitedocfilebody.length==0||sitedocfilename==null||sitedocfilename.trim().length()==0) {
		sitedocfilename=null;
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SiteDocFile.error.file"));
	}

    if (!errors.empty())
        throw new ValidationException();
}
}
