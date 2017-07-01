package com.hps.july.basestation.formbean;

import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.ValidationException;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.*;

import com.hps.july.web.util.*;
import com.hps.july.commonbean.*;
import java.util.*;

/**
 * Форма связывания файла с документом разрешения ГКРЧ
 */ 
public class SitedocFileForm extends EditForm  {
	private String blanknumber;
	private String doctype;
	private StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
    private int sitedocfile;
    private StringAndSqlDateProperty sitedocfiledate = new StringAndSqlDateProperty();
    private byte[] sitedocfilebody;
    private String note;

    private org.apache.struts.upload.FormFile sitedocfilebodyFrm;
    private String sitedocfilename;

    private String delete;
    private int[] selfiles;

    private int sitedoc;
public void afterUpdate(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	if (sitedocfilebodyFrm != null) {
		updateSitedocfilebody(((SiteDocFileAccessBean)bean).getSitedocfile());
	}
System.out.println("SDFName(afterUpdate):"+sitedocfilename);
}
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	SiteDocFileAccessBean fileBean=(SiteDocFileAccessBean) bean;
	fileBean.setSitedocfiledate(new java.sql.Date(System.currentTimeMillis()));
	fileBean.commitCopyHelper();
System.out.println("SDFName(beforeUpdate):"+sitedocfilename);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    sitedocfile = keygen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.SITEDOCFILES);

    SiteDocFileAccessBean bean = new SiteDocFileAccessBean(sitedocfile,sitedoc);
	return bean;
}
public void deleteSelected()
{
	if(selfiles != null) {
		for(int i = 0; i < selfiles.length; i++) {
			try {
				SiteDocFileAccessBean file = new SiteDocFileAccessBean();
				file.setInitKey_sitedocfile(selfiles[i]);
				file.refreshCopyHelper();
				file.getEJBRef().remove();
			} catch(Exception e) {
				System.out.println("Can't delete SITEDOCFILE#"+selfiles[i]+", reason:"+e.getClass().getName()+" msg:"+e.getMessage());
			}
		}
	}
}
public void fillDocParams()
{
	try {
		SiteDocAccessBean bean = new SiteDocAccessBean();
		bean.setInitKey_sitedoc(sitedoc);
		bean.refreshCopyHelper();
		blankdate.setSqlDate(bean.getBlankdate());
		blanknumber = bean.getBlanknumber();
		if(bean.getSiteDocType() != null) {
			doctype = bean.getSiteDocType().getSitedoctypename();
		} else {
			doctype = "???";
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
/*
    try {
        SiteDocFileAccessBean fileBean = (SiteDocFileAccessBean) bean;

        SiteDocFileBLOBAccessBean bodyBean = new SiteDocFileBLOBAccessBean();
        bodyBean.setInitKey_sitedocfile(fileBean.getSitedocfile());
        bodyBean.refreshCopyHelper();
        sitedocfilebody = bodyBean.getSitedocfilebody();
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
*/
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public com.hps.july.web.util.StringAndSqlDateProperty getBlankdate() {
	return blankdate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
{
	fillDocParams();
	SiteDocFileAccessBean bean = new SiteDocFileAccessBean();
	try {
		bean.setInitKey_sitedocfile(sitedocfile);
		bean.refreshCopyHelper();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
    try {
		SiteDocFileBLOBAccessBean bodyBean = new SiteDocFileBLOBAccessBean();
        bodyBean.setInitKey_sitedocfile(sitedocfile);
        bodyBean.refreshCopyHelper();
        sitedocfilebody = bodyBean.getSitedocfilebody();
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
	return bean;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDelete() {
	return delete;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDoctype() {
	return doctype;
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
 * 
 * @return int[]
 */
public int[] getSelfiles() {
	return selfiles;
}
/**
 * 
 * @return int
 */
public int getSitedoc() {
	return sitedoc;
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
	return APPStates.SITEDOC_FILE;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	fillDocParams();
	sitedocfiledate = new StringAndSqlDateProperty();
	note = "";
	sitedocfilebody = null;
	sitedocfilebodyFrm = null;
	sitedocfilename = null;
	setAction(request.getParameter("action"));
}
/**
 * 
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
/**
 * 
 * @param newDelete java.lang.String
 */
public void setDelete(java.lang.String newDelete) {
	delete = newDelete;
}
/**
 * 
 * @param newDoctype java.lang.String
 */
public void setDoctype(java.lang.String newDoctype) {
	doctype = newDoctype;
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
 * 
 * @param newSelfiles int[]
 */
public void setSelfiles(int[] newSelfiles) {
	selfiles = newSelfiles;
}
/**
 * 
 * @param newSitedoc int
 */
public void setSitedoc(int newSitedoc) {
	sitedoc = newSitedoc;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 9:42:37)
 * @param newSitedocfile int
 */
public void setSitedocfile(int newSitedocfile) {
	sitedocfile = newSitedocfile;
}
public void setSitedocfilebody(byte[] newDocbody) {
    sitedocfilebody = newDocbody;
//    if (sitedocfilebodyFrm == null)
//        sitedocfilebodyFrm = null;
}
/**
 * Insert the method's description here.
 * Creation date: (31.12.2002 19:16:01)
 * @param newDocbodyFrm org.apache.struts.upload.FormFile
 */
public void setSitedocfilebodyFrm(org.apache.struts.upload.FormFile bodyFrm)
	throws Exception
{
    sitedocfilebodyFrm = bodyFrm;
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
//	if(sitedocfilename==null) sitedocfilebodyFrm=null;
	
}
public void updateSitedocfilebody(int id) throws Exception {
    try {
        SiteDocFileBLOBAccessBean blobBean = new SiteDocFileBLOBAccessBean();
        blobBean.setInitKey_sitedocfile(id);
        blobBean.refreshCopyHelper();
        blobBean.setSitedocfilebody(sitedocfilebody);
        blobBean.commitCopyHelper();
    } catch (Exception e) {
        e.printStackTrace(System.out);
        throw e;
    }
}
public void validateValues(ActionErrors errors)
	throws Exception
{
    if (sitedocfilebodyFrm != null && sitedocfilebodyFrm.getFileName().trim().length() > 0) {
        sitedocfilebody = sitedocfilebodyFrm.getFileData();
        sitedocfilename = sitedocfilebodyFrm.getFileName();
System.out.println("SDFName:"+sitedocfilename);
    }

	if("Add".equals(getAction())) {
		if(sitedocfilebodyFrm == null || sitedocfilebodyFrm.getFileSize() < 1) {
			sitedocfilename=null;
		    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrch.file"));
		}
	} else {
	    if(sitedocfilename==null||sitedocfilename.trim().length()==0) {
		    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrch.file"));
		}
	}
System.out.println("SDFName(Validate):"+sitedocfilename);
    if (!errors.empty())
        throw new ValidationException();
}
}
