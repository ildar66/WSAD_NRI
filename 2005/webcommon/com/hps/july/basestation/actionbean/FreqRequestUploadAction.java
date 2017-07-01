package com.hps.july.basestation.actionbean;

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
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;

/**
 * Получение и запись в базу документа excel - Заявка на частоты.
 * Creation date: (20.01.2004 19:14:24)
 * @author: Dmitry Dneprov
 */
public class FreqRequestUploadAction
	extends com.hps.july.web.util.AbstractDocumentUploadAction
{
/**
 * Метод сохраняет полученные данные в БД
 * Возвращает null если всё в порядке, иначе строку с ошибкой которая показывается клиенту
 */
public String storeInDatabase(org.apache.struts.action.ActionMapping mapping, com.hps.july.web.util.DocumentUploadForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
	String result = "error";
	// form.getDocumentid() - refers to position code
	if (!form.isEmpty()) {

		int siteDoc = 0;
		// try to find corresponding document
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		CDBCResultSet rs = sdo.findFrequencyLicenceByFN(new Integer(form.getDocumentid()));
		if (rs.getRowsCount() > 0) {
			ListIterator it = rs.listIterator();
			CDBCRowObject ro = (CDBCRowObject)it.next();
			Integer freqPerm = (Integer)ro.getColumn("freqpermid").asObject();
			int typeZajavka = AppUtils.getNamedValueInt("FreqLicenceStart");
			Integer sitedoc = sdo.findEtapDocByType(new Integer(typeZajavka), freqPerm);
			if (sitedoc != null) {
				siteDoc = sitedoc.intValue();
				result = null;
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
