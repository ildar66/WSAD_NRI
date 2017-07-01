package com.hps.july.siteinfo.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import java.sql.*;
import javax.sql.*;
import javax.transaction.*;
import javax.naming.*;
import java.io.*;

/**
 * CardPass WORD upload action.
 * Creation date: (20.01.2004 19:14:24)
 * @author: Dmitry Dneprov
 */
public abstract class PassWordUploadAction
	extends com.hps.july.web.util.AbstractDocumentUploadAction
{
public void fillFields(SiteDocAccessBean sdocab) {
}
/**
 * Проверяет наличие документа
 * @return int код документа
 */
public static int findDocument(int posId, int docTypeCode) {
        // Find document to replace
        int siteDoc = 0;
        try {
	        Enumeration enum = new SiteDocAccessBean().findByPosition(new Integer(posId), new Integer(2));
	        while (enum.hasMoreElements()) {
	            SiteDocAccessBean siteDocBean = (SiteDocAccessBean)enum.nextElement();
	            if (docTypeCode == siteDocBean.getSiteDocTypeKey().sitedoctype) {
	                siteDoc = siteDocBean.getSitedoc();
	                break;
	            }
	        }
        } catch (Exception e) {
	        e.printStackTrace(System.out);
        }
        return siteDoc;
}
public int getCurrentDocument(int posId, int docTypeCode, java.sql.Date argDocDate) {
	return findDocument(posId, docTypeCode);
}
public abstract String getDocType();
/**
 * Метод сохраняет полученные данные в БД
 * Возвращает null если всё в порядке, иначе строку с ошибкой которая показывается клиенту
 */
public String storeInDatabase(org.apache.struts.action.ActionMapping mapping, com.hps.july.web.util.DocumentUploadForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
	String result = null;
	// form.getDocumentid() - refers to position code
	if (!form.isEmpty()) {

        int docTypeCode = AppUtils.getNamedValueInt(getDocType());

        int siteDoc = getCurrentDocument(form.getDocumentid(), docTypeCode, new java.sql.Date(new java.util.Date().getTime()));

        if (siteDoc == 0) {
	        try {
		        // Determine operator
		        int iman = new OperatorAccessBean().findByLogin(request.getRemoteUser()).getMan().getMan();
	        	// Document header not found - create it
	        	siteDoc = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.SITEDOCS);
	        	SiteDocAccessBean sdocab = new SiteDocAccessBean(siteDoc, docTypeCode, iman);
	        	sdocab.setBlanknumber("1");
	        	sdocab.setBlankdate(new java.sql.Date(new java.util.Date().getTime()));
	        	fillFields(sdocab);
	        	sdocab.commitCopyHelper();

	        	// Add link to position
	        	Sitedoc2SplaceAccessBean link = new Sitedoc2SplaceAccessBean(siteDoc, form.getDocumentid());
	        	
	        } catch (Exception e) {
		        e.printStackTrace(System.out);
	        	result = "error";
	        }
        }
        
        String name = null;
        if (siteDoc != 0) {
	        try {
	            SiteDocFileAccessBean ff = new SiteDocFileAccessBean();
	            Enumeration en = ff.findBySitedocOrderBySitedocDesc(new Integer(siteDoc));
	            //System.out.println("SD #1:");
	            if (en.hasMoreElements()) {
	                //System.out.println("SD #2:");
	                SiteDocFileAccessBean temp = (SiteDocFileAccessBean) en.nextElement();
	                temp.refreshCopyHelper();
	                int sdFileCode = temp.getSitedocfile();
	            	//System.out.println("SD #3, code: " + sdFileCode);
	                SiteDocFileBLOBAccessBean blob = new SiteDocFileBLOBAccessBean();
	                blob.setInitKey_sitedocfile(sdFileCode);
	                blob.refreshCopyHelper();
	            	//System.out.println("SD #4:");
					blob.setSitedocfilebody(form.getFilebody().getFileData());
					temp.setSitedocfilename(form.getFilename());
					temp.commitCopyHelper();
					blob.commitCopyHelper();
	            	//System.out.println("SD #5:");
	            } else {
		            // Attachment not found - create it
	        		int siteDocfile = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.SITEDOCFILES);
	            	ff = new SiteDocFileAccessBean(siteDocfile, siteDoc);
	            	ff.setSitedocfiledate(new java.sql.Date(new java.util.Date().getTime()));
	            	ff.setSitedocfilename(form.getFilename());
	            	ff.commitCopyHelper();
	                SiteDocFileBLOBAccessBean blob = new SiteDocFileBLOBAccessBean();
	                blob.setInitKey_sitedocfile(siteDocfile);
	                blob.refreshCopyHelper();
					blob.setSitedocfilebody(form.getFilebody().getFileData());
					blob.commitCopyHelper();
	            }
	        } catch (Exception e) {
		        e.printStackTrace(System.out);
	        	result = "error";
	        }
        }
	}
	return result;
}
}
