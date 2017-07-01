package com.hps.july.basestation.formbean;

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
 * Форма редактирования параметров решения ГКРЧ
 */
public class GKRCHForm
	extends DocForm
{
	// Дубликаты дат для поддержки безопасного ввода
	private StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty expiredate = new StringAndSqlDateProperty();

	private GKRCHDocValueObject vo = new GKRCHDocValueObject();
	private Integer[] resources = new Integer[] {};
	private Hashtable resfreqtable = new Hashtable();

	private Integer[] regions = null;
public GKRCHForm() {
	super();
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public StringAndSqlDateProperty getBlankdate() {
	return blankdate;
}
public Iterator getEnteredRegionsList() {
	try {
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		CDBCResultSet rs = sdo.findGKRCHRegions(new Integer(getSitedoc()));
		return rs.listIterator();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		ArrayList r = new ArrayList();
		return r.iterator();
	}
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
public Integer[] getRegions() {
	if(regions == null) {
		return new Integer[] { new Integer(0) };
	} else {
		return regions;
	}
}
public Iterator getRegionsList() {
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findAllViewEditRegions(getUsername(),isAdmin(),false/*!"View".equals(getAction())*/);
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			try {
				com.hps.july.siteinfo.valueobject.RegionVO rob = new com.hps.july.siteinfo.valueobject.RegionVO(
						((Integer)ro.getColumn("regionid").asObject()).intValue(),
						((Integer)ro.getColumn("supregid").asObject()).intValue(),
						ro.getColumn("regname").asString()
				);
				r.add(rob);
			} catch(Exception e) {}
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	if(regions != null) {
		Collections.sort(r,new com.hps.july.siteinfo.valueobject.RegionsComparator(regions));
	}
System.out.println("RL.R.LEN:"+r.size());
	return r.iterator();
}
public String getResfreq(int index)
{
	return (String)resfreqtable.get(String.valueOf(index));
}
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
	return com.hps.july.basestation.APPStates.GKRCH_FORM;
}
public GKRCHDocValueObject getVo() {
	return vo;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
	super.initRecord(request);
	vo = new GKRCHDocValueObject();
	blankdate.setString("");
	expiredate.setString("");
	regions = new Integer[] {};
	resources = null;
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
	// Загрузка данных документов ГКРЧ
	try {
		SitedocFacadeAccessBean loader = new SitedocFacadeAccessBean();
		vo = loader.findGKRCHDocByPrimaryKey(getSitedoc());
		blankdate.setSqlDate(vo.getBlankdate());
		expiredate.setSqlDate(vo.getExpiredate());
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	// Ищем регионы документа
	try {
		ArrayList arr = new ArrayList();
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		CDBCResultSet rs = sdo.findGKRCHRegions(new Integer(getSitedoc()));
		Iterator it = rs.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			arr.add((Integer)ro.getColumn("regionid").asObject());
		}
		regions = new Integer[arr.size()];
		for(int i = 0; i < arr.size(); i++) {
			regions[i] = (Integer)arr.get(i);
		}
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
		bean.deleteGKRCHDoc(getSitedoc());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.gkrch.form.filespresent");
	}
	return null;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	setUser(request);
	SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
System.out.println("BEFORE GKRCH Insert");
	if(resources != null && resources.length > 0) {
		for(int i = 0; i < resources.length; i++) {
			System.out.println("RES["+i+"]:"+resources[i]);
		}
	} else {
		System.out.println("RES is empty");
	}
	if(regions != null && regions.length > 0) {
		for(int i = 0; i < regions.length; i++) {
			System.out.println("RG["+i+"]:"+regions[i]);
		}
	} else {
		System.out.println("RG is empty");
	}
	System.out.println("Blankdate:"+getBlankdate().getSqlDate());
	System.out.println("Expiredate:"+getExpiredate().getSqlDate());
	getVo().setBlankdate(getBlankdate().getSqlDate());
	getVo().setExpiredate(getExpiredate().getSqlDate());
	bean.createGKRCHDoc(getVo(), convert2DocResourcesInt(resources,resfreqtable), convertLInt(regions));
System.out.println("AFTER GKRCH Insert");
	return null;
}
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	setUser(request);
	SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
	System.out.println("BEFORE GKRCH Update");
	getVo().setBlankdate(getBlankdate().getSqlDate());
	getVo().setExpiredate(getExpiredate().getSqlDate());
	bean.updateGKRCHDoc(getVo(), convert2DocResourcesInt(resources,resfreqtable), convertLInt(regions));
//	createRegionLink(getSitedoc(),regions);
//	createResourceLink(getSitedoc(),resources);
	System.out.println("AFTER GKRCH Update");
	return null;
}
public void setRegions(Integer[] newRegions) {
	regions = newRegions;
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
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.blanknumber.empty"));
	} else if(vo.getBlanknumber().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.blanknumber.length"));
	}

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.blankdate.empty"));
	} else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.blankdate.format"));
	}

	// check resources
	if(resources == null || resources.length < 1) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.resources.empty"));
	}

	// check resource frequency ranges
/*
	// check freqrange CHAR(40)
	if(vo.getFreqrange() == null || "".equals(vo.getFreqrange().trim())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.freqrange.empty"));
	} else if(vo.getFreqrange().length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.freqrange.length"));
	}
*/
	// check regions
	if(regions == null || regions.length < 1) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.regions.empty"));
	}

	// check expiredate
	if(expiredate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.expiredate.empty"));
	} else if(!expiredate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.expiredate.format"));
	}

	// check restrictions CHAR(255)
	if(vo.getRestrictions() != null) {
		vo.setRestrictions(vo.getRestrictions().trim());
		if(vo.getRestrictions().length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.restrictions.length"));
		} else if("".equals(vo.getRestrictions())) {
			vo.setRestrictions(null);
		}
	}

	// check comment CHAR(255)
	if(vo.getComment() != null) {
		vo.setComment(vo.getComment().trim());
		if(vo.getComment().length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.gkrchform.сomment.length"));
		} else if("".equals(vo.getComment())) {
			vo.setComment(null);
		}
	}

	// check files
	
	if(!errors.empty()) {
		throw new ValidationException();
	}
}
}
