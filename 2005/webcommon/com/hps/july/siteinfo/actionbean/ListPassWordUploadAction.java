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
 * Обработчик загрузки списка прохода
 * @author: Dmitry Dneprov
 */
public class ListPassWordUploadAction extends PassWordUploadAction {
/**
 * Insert the method's description here.
 * Creation date: (24.02.2004 17:52:54)
 */
public void fillFields(SiteDocAccessBean sdocab) {
	GregorianCalendar gc = new GregorianCalendar();
	gc.set(gc.DAY_OF_MONTH, 31);
	gc.set(gc.MONTH, 11);
	sdocab.setExpiredate(new java.sql.Date(gc.getTime().getTime()));
}
/**
 * Checks for document presence.
 * made static to be easily called from JSP
 * Creation date: (19.02.2004 13:49:59)
 * @return int
 */
public static int findDocumentDate(int posId, int docTypeCode, java.sql.Date argDocDate) {
        // Find document to replace
        int siteDoc = 0;
        try {
	        Enumeration enum = new SiteDocAccessBean().findByPosition(new Integer(posId), new Integer(2));
	        while (enum.hasMoreElements()) {
	            SiteDocAccessBean siteDocBean = (SiteDocAccessBean)enum.nextElement();
	            if (docTypeCode == siteDocBean.getSiteDocTypeKey().sitedoctype) {
		            if ( (siteDocBean.getBlankdate().getDay() == argDocDate.getDay()) &&
			            (siteDocBean.getBlankdate().getMonth() == argDocDate.getMonth()) &&
			            (siteDocBean.getBlankdate().getYear() == argDocDate.getYear()) ) {
		                siteDoc = siteDocBean.getSitedoc();
		                break;
		            }
	            }
	        }
        } catch (Exception e) {
	        e.printStackTrace(System.out);
        }
        return siteDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2004 17:39:03)
 * @return int
 */
public int getCurrentDocument(int posId, int docTypeCode, java.sql.Date argDocDate) {
	return findDocumentDate(posId, docTypeCode, argDocDate); 
}
/**
 * Returns type of document - named value constant.
 * Creation date: (05.02.2004 16:15:02)
 * @return java.lang.String
 */
public java.lang.String getDocType() {
	return "PassListDocType";
}
}
