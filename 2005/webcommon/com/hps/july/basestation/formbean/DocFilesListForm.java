package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import javax.servlet.http.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Форма списка файлов для документов на различное оборудование
 */
public class DocFilesListForm
	extends com.hps.july.web.util.BrowseForm
{
	private int sitedoc;
	private String blanknumber;
	private StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
	private String doctype;
public DocFilesListForm() {
	super();
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
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDoctype() {
	return doctype;
}
public Object[] getFilterParams() {
	return new Object[] {
		new Integer(sitedoc)
	};
}
public java.lang.String getFinderMethodName() {
	return "findDocFiles";
}
public Integer getOrder() {
	return new Integer(1);
}
/**
 * 
 * @return int
 */
public int getSitedoc() {
	return sitedoc;
}
public int getState() {
	return com.hps.july.basestation.APPStates.FREQLICENCE_LIST;
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
 * @param newDoctype java.lang.String
 */
public void setDoctype(java.lang.String newDoctype) {
	doctype = newDoctype;
}
/**
 * 
 * @param newSitedoc int
 */
public void setSitedoc(int newSitedoc) {
	sitedoc = newSitedoc;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	try {
		SiteDocAccessBean sda = new SiteDocAccessBean();
		sda.setInitKey_sitedoc(sitedoc);
		sda.refreshCopyHelper();
		blankdate.setSqlDate(sda.getBlankdate());
		blanknumber = sda.getBlanknumber();
//		sda.getExpiredate();
		doctype = sda.getSiteDocType().getSitedoctypename();
	} catch(Exception e) {
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
