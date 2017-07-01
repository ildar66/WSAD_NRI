package com.hps.july.basestation.formbean;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.persistence2.*;
import java.util.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * Форма редактирования параметров сертификата на оборудования РРЛ
 */
public class RRLForm
	extends DocForm
{
	// Дубликаты дат для поддержки безопасного ввода
	private StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty expiredate = new StringAndSqlDateProperty();
	private StringAndIntegerProperty organization = new StringAndIntegerProperty();
	private String orgname;

	private RRLDocValueObject vo = new RRLDocValueObject();
	private Integer[] resources;
	private Hashtable resfreqtable = new Hashtable();
public RRLForm() {
	super();
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public StringAndSqlDateProperty getBlankdate() {
	return blankdate;
}
public StringAndSqlDateProperty getExpiredate() {
	return expiredate;
}
public ListIterator getFilesList() {
	try {
		CDBCSitedocsObject o = new CDBCSitedocsObject();
		CDBCResultSet rs = o.findGKRCHFiles(new Integer(vo.getSitedoc()));
		return rs.listIterator();
	} catch(Exception e) {
		return new ArrayList().listIterator();
	}
}
public StringAndIntegerProperty getOrganization() {
	return organization;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
public String getResfreq(int index)
{
	return (String)resfreqtable.get(String.valueOf(index));
}
/**
 * 
 * @return int[]
 */
public Integer[] getResources() {
	return resources;
}
public ListIterator getResourcesList() {
	try {
		CDBCSitedocsObject o = new CDBCSitedocsObject();
		CDBCResultSet rs = o.findDocsResources(new Integer(vo.getSitedoc()));
		return rs.listIterator();
	} catch(Exception e) {
		return new ArrayList().listIterator();
	}
}
public int getState() {
	return com.hps.july.basestation.APPStates.RRL_FORM;
}
public RRLDocValueObject getVo() {
	return vo;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
	super.initRecord(request);
	vo = new RRLDocValueObject();
	blankdate.setString("");
	expiredate.setString("");
	organization.setString("");
	orgname = "";
	resources = null;
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
	// Загрузка данных документов ГКРЧ
	try {
		SitedocFacadeAccessBean loader = new SitedocFacadeAccessBean();
		vo = loader.findRRLDocByPrimaryKey(getSitedoc());
		blankdate.setSqlDate(vo.getBlankdate());
		expiredate.setSqlDate(vo.getExpiredate());
		OrganizationAccessBean o = new OrganizationAccessBean();
		o.setInitKey_organization(vo.getOrganization());
		o.refreshCopyHelper();
		organization.setInteger(new Integer(vo.getOrganization()));
		orgname = o.getName();
		expiredate.getSqlDate().compareTo(new Date());
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	setUser(request);
	try {
		SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
		bean.deleteRRLDoc(getSitedoc());
	} catch(Exception e) {
		throw new UpdateValidationException("error.rrlform.filespresent");
	}
	return null;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	setUser(request);
	SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
System.out.println("BEFORE RRL Insert");
	if(resources != null && resources.length > 0) {
		for(int i = 0; i < resources.length; i++) {
			System.out.println("RES["+i+"]:"+resources[i]);
		}
	} else {
		System.out.println("RES is empty");
	}
	System.out.println("Blankdate:"+getBlankdate().getSqlDate());
	System.out.println("Expiredate:"+getExpiredate().getSqlDate());
	getVo().setBlankdate(getBlankdate().getSqlDate());
	getVo().setExpiredate(getExpiredate().getSqlDate());
	getVo().setOrganization(getOrganization().getInteger().intValue());

	try {
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		if (getVo().getSitedoc() == 0)
			getVo().setSitedoc(keygen.getNextKey("tables.sitedocs"));
		bean.createRRLDoc(getVo(), convert2DocResourcesInt(resources,resfreqtable));
System.out.println("AFTER RRL Insert");
		setAction("Edit");
		ParamsParser.setState(request,getApplication(),getState());
		return "main";
	} catch(Exception e) {
		throw new UpdateValidationException("error.rrlform.create");
	}
}
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	setUser(request);
	SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
	System.out.println("BEFORE RRL Update");
	getVo().setBlankdate(getBlankdate().getSqlDate());
	getVo().setExpiredate(getExpiredate().getSqlDate());
	getVo().setOrganization(getOrganization().getInteger().intValue());
	bean.updateRRLDoc(getVo(), convert2DocResourcesInt(resources,resfreqtable));
//	createResourceLink(getSitedoc(),resources);
	System.out.println("AFTER RRL Update");
	return null;
}
/**
 * 
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
public void setResfreq(int index, String value) {
System.out.println("RRLForm.setResfreq(INT:"+index+","+value+")");
	if(value != null) {
		resfreqtable.put(""+index,value);
	}
}
public void setResources(Integer[] newResources) {
	resources = newResources;
}
public void validateValues(ActionErrors errors)
	throws Exception 
{
	if(vo.getBlanknumber() == null || "".equals(vo.getBlanknumber().trim())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.blanknumber.empty"));
	} else if(vo.getBlanknumber().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.blanknumber.length"));
	}

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.blankdate.empty"));
	} else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.blankdate.format"));
	}

	// check resources
	if(resources == null || resources.length < 1) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.resources.empty"));
	}

	// check resource frequency ranges
	
	// check expiredate
	if(expiredate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.expiredate.empty"));
	} else if(!expiredate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.expiredate.format"));
	}

	if(organization.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.organization.empty"));
	} else if(!organization.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.organization.invalid"));
	} else {
		try {
			OrganizationAccessBean o = new OrganizationAccessBean();
			o.setInitKey_organization(organization.getInteger().intValue());
			o.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlform.organization.absent"));
		}
	}

	// check files
	
	if(!errors.empty()) {
		throw new ValidationException();
	}
}
}
