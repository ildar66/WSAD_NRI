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
 * Форма списка частотных разрешений
 */
public class FrequencyLicenceListForm
	extends com.hps.july.web.util.BrowseForm
{
	private RegionsSelector regionsSelector = new RegionsSelector();
    private String reqFilter;
    private String licenceFilter;
	private String expFilter;
	private boolean byfilenumber;
	private String fileNumber;
    
	private String username;
	private boolean admin;
public FrequencyLicenceListForm() {
	super();
	reqFilter = "*";
	licenceFilter = "*";
	expFilter = "*";
	setLastVisited(true);
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getExpFilter() {
	return expFilter;
}
public java.lang.String getFileNumber() {
	return fileNumber;
}
public Object[] getFilterParams() {
	return new Object[] {
		new Boolean(!regionsSelector.isAllSuperregions()), regionsSelector.getSuperregioncodes(),
		new Boolean(!regionsSelector.isAllRegions()), regionsSelector.getRegioncodes(),
		new Boolean(byfilenumber), fileNumber != null ? fileNumber : "",
		reqFilter != null ? reqFilter : "",
		licenceFilter != null ? licenceFilter : "",
		expFilter != null ? expFilter : "",
		new Boolean(admin), username != null ? username : "",
		getOrder()
	};
}
public java.lang.String getFinderMethodName() {
	return "findFrequencyLicenceDocuments";
}
public Boolean getIsAdmin() {
	return Boolean.TRUE;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLicenceFilter() {
	return licenceFilter;
}
public Integer getOrder() {
	try {
		return new Integer(Integer.parseInt(super.getFinderMethodName()));
	} catch(Exception e) {
		return new Integer(1);
	}
}
public com.hps.july.siteinfo.valueobject.RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getReqFilter() {
	return reqFilter;
}
public String getResourcesList(Object freqpermid) {
TimeCounter tc = new TimeCounter("Resources List");
	String r = "";
	if(freqpermid != null && freqpermid instanceof Integer) {
		CDBCResultSet rs = (new CDBCSitedocsObject()).findFrequencyLicenceEquipment((Integer)freqpermid);
		Iterator it = rs.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			r += ro.getColumn("model").asString();
			if(it.hasNext()) {
				r += ", ";
			}
		}
	}
tc.finish(" finish ");
	return r;
}
public int getState() {
	return com.hps.july.basestation.APPStates.FREQLICENCE_LIST;
}
public java.lang.String getUsername() {
	return username;
}
public boolean isAdmin() {
	return admin;
}
/**
 * 
 * @return boolean
 */
public boolean isByfilenumber() {
	return byfilenumber;
}
public void setAdmin(boolean newAdmin) {
	admin = newAdmin;
}
/**
 * 
 * @param newByfilenumber boolean
 */
public void setByfilenumber(boolean newByfilenumber) {
	byfilenumber = newByfilenumber;
}
/**
 * 
 * @param newExpFilter java.lang.String
 */
public void setExpFilter(java.lang.String newExpFilter) {
	expFilter = newExpFilter;
}
/**
 * 
 * @param newFileNumber java.lang.String
 */
public void setFileNumber(java.lang.String newFileNumber) {
	fileNumber = newFileNumber;
}
/**
 * 
 * @param newLicenceFilter java.lang.String
 */
public void setLicenceFilter(java.lang.String newLicenceFilter) {
	licenceFilter = newLicenceFilter;
}
/**
 * 
 * @param newReqFilter java.lang.String
 */
public void setReqFilter(java.lang.String newReqFilter) {
	reqFilter = newReqFilter;
}
public void setUsername(java.lang.String newUsername) {
	username = newUsername;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	if (!errors.empty())
		throw new ValidationException();
}
}
