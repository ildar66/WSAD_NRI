package com.hps.july.basestation.formbean;

import com.hps.july.trailcom.beans.HopAccessBean;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.trailcom.beans.Sitedoc2HopsAccessBean;
import com.hps.july.basestation.valueobject.EtaptypeVO;
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
 * Форма редактирования документов по этапам получения частотного разрешения
 */
public class EtapDocForm
	extends DocForm
{
	private EtapDocValueObject vo = new EtapDocValueObject();
	private StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty expiredate = new StringAndSqlDateProperty();

	private boolean hasExpiredate;
	private boolean hasComlinelinks;
	private boolean hasPaycheck;

	private int[] comlines;

	private ArrayList etaptypeslist = null;
	private String hasComArr = "";
	private String hasExpArr = "";
	private String hasPayArr = "";
public EtapDocForm() {
	super();
	vo = new EtapDocValueObject();
}
/**
 * @deprecated
 */
public void createComlineLinks()
	throws UpdateValidationException
{
	if(comlines != null) {
		try {
			for(int i = 0; i < comlines.length; i++) {
System.out.println("ETAP: COMcreate("+getSitedoc()+","+comlines[i]+")");
				Sitedoc2HopsAccessBean b = new Sitedoc2HopsAccessBean(getSitedoc(),comlines[i]);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.etapform.createcomlinelinks");
		}
	}
}
/**
 * @deprecated
 */
public void deleteComlineLinks()
	throws UpdateValidationException
{
	try {
		Sitedoc2HopsAccessBean f = new Sitedoc2HopsAccessBean();
		Enumeration en = f.findSitedoc2HopsBySitedoc(new Integer(getSitedoc()));
		while(en.hasMoreElements()) {
			Sitedoc2HopsAccessBean b = (Sitedoc2HopsAccessBean)en.nextElement();
			b.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.etapform.deletecomlinelinks");
	}
}
/**
 * @deprecated
 */
public static void deleteEtapDocument(int sitedoc)
	throws UpdateValidationException
{
	try {
		SiteDocFileAccessBean sdf = new SiteDocFileAccessBean();
		Enumeration en = sdf.findBySitedocOrderBySitedocAsc(new Integer(sitedoc));
		while(en.hasMoreElements()) {
			SiteDocFileAccessBean s = (SiteDocFileAccessBean)en.nextElement();
			s.getEJBRef().remove();
		}
	} catch(Exception e) {
		throw new UpdateValidationException("error.etapform.cantdeletefiles");
	}

	try {
		Sitedoc2HopsAccessBean f = new Sitedoc2HopsAccessBean();
		Enumeration en = f.findSitedoc2HopsBySitedoc(new Integer(sitedoc));
		while(en.hasMoreElements()) {
			Sitedoc2HopsAccessBean b = (Sitedoc2HopsAccessBean)en.nextElement();
			b.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.etapform.deletecomlinelinks");
	}

	try {
		SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
		bean.deleteEtapDoc(sitedoc);
	} catch(Exception e) {
		throw new UpdateValidationException("error.etapform.delete");
	}
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
public int[] getComlines() {
	return comlines;
}
public Iterator getComlinesList() {
	try {
		CDBCResultSet rs = (new CDBCSitedocsObject()).findFrequencyLicenceComlines(new Integer(vo.getFreqpermid()));
		return rs.listIterator();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return new ArrayList().iterator();
	}
}
public ListIterator getEtapTypesList() {
	if(etaptypeslist == null) {
		initEtapTypesList();
	}
	return etaptypeslist.listIterator();
}
/**
 * 
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public com.hps.july.web.util.StringAndSqlDateProperty getExpiredate() {
	return expiredate;
}
public ListIterator getFilesList() {
	try {
		CDBCSitedocsObject o = new CDBCSitedocsObject();
		CDBCResultSet rs = o.findDocFiles(new Integer(vo.getSitedoc()));
		return rs.listIterator();
	} catch(Exception e) {
		return new ArrayList().listIterator();
	}
}
public int getFreqpermid() {
	return vo.getFreqpermid();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHasComArr() {
	return hasComArr;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHasExpArr() {
	return hasExpArr;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHasPayArr() {
	return hasPayArr;
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
	return com.hps.july.basestation.APPStates.ETAP_FORM;
}
public com.hps.july.persistence2.EtapDocValueObject getVo() {
	return vo;
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	initEtapTypesList();
}
public void initEtapTypesList() {
	hasComArr = "var comlinks = new Array();\n";
	hasExpArr = "var expdate = new Array();\n";
	hasPayArr = "var paycheck = new Array();\n";
	etaptypeslist = new ArrayList();
	try {
		CDBCSitedocsObject o = new CDBCSitedocsObject();
		CDBCResultSet rs = o.findEtapTypes(Boolean.FALSE, "", new Integer(1));
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			EtaptypeVO vo = new EtaptypeVO(ro);
			etaptypeslist.add(vo);
			hasComArr += "comlinks["+vo.getEtaptypeid()+"]='"+ro.getColumn("havehopslink").asString()+"';\n";
			hasExpArr += "expdate["+vo.getEtaptypeid()+"]='"+ro.getColumn("haveendtime").asString()+"';\n";
			hasPayArr += "paycheck["+vo.getEtaptypeid()+"]='"+ro.getColumn("havepaycheck").asString()+"';\n";
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
	FreqLicenceHistoryListForm frm = (FreqLicenceHistoryListForm)request.getSession().getAttribute("FreqLicenceHistoryListForm");
	vo = new EtapDocValueObject();
	vo.setFreqpermid(frm.getFreqpermid());
	super.initRecord(request);
}
public boolean isComlineLinked(int pref) {
	boolean r = false;
	if(comlines != null) {
		for(int i = 0; i < comlines.length && !r; i++) {
			r = comlines[i] == pref;
		}
	}
	return r;
}
public boolean isHasComlinelinks() {
	return hasComlinelinks;
}
public boolean isHasExpiredate() {
	return hasExpiredate;
}
/**
 * 
 * @return boolean
 */
public boolean isHasPaycheck() {
	return hasPaycheck;
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
//	FreqLicenceHistoryListForm frm = (FreqLicenceHistoryListForm)request.getSession().getAttribute("FreqLicenceHistoryListForm");
//	vo.setFreqpermid(frm.getFreqpermid());
	try {
		SitedocFacadeAccessBean loader = new SitedocFacadeAccessBean();
		vo = loader.findEtapDocByPrimaryKey(getSitedoc());
		setSitedoc(vo.getSitedoc());
		blankdate.setSqlDate(vo.getBlankdate());
		expiredate.setSqlDate(vo.getExpiredate());

		EtapTypeAccessBean et = new EtapTypeAccessBean();
		et.setInitKey_etaptypeid(vo.getEtaptypeid());
		et.refreshCopyHelper();
		hasExpiredate = et.getHaveendtime();
		hasComlinelinks = et.getHavehopslink();

		if(vo.getEquiplink() == null) {
			vo.setEquiplink("-");
		}
//		if(hasComlinelinks) {
//			CDBCSitedocsObject sdo = new CDBCSitedocsObject();
//			comlines = sdo.findEtapComlines(new Integer(getSitedoc()), new Integer(vo.getFreqpermid()));

			ArrayList l = new ArrayList();
			Sitedoc2HopsAccessBean s2h = new Sitedoc2HopsAccessBean();
//			Etap2HopAccessBean s2h = new Etap2HopAccessBean();
//			Enumeration en = s2h.findBySitedocAndPermid(new Integer(getSitedoc()), new Integer(vo.getFreqpermid()));
			Enumeration en = s2h.findSitedoc2HopsBySitedoc(new Integer(getSitedoc()));
			while(en.hasMoreElements()) {
				Sitedoc2HopsAccessBean s = (Sitedoc2HopsAccessBean)en.nextElement();
				l.add(new Integer(s.getHopKey().hopsid));
			}
			comlines = new int[l.size()];
			for(int i = 0; i < comlines.length; i++) {
				comlines[i] = ((Integer)l.get(i)).intValue();
			}
System.out.println("LOAD ETAP: comlines:"+comlines.length);
//		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	initEtapTypesList();
}
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	setUser(request);
	SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
	try {
		bean.deleteEtapDoc(getSitedoc());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException(e.getMessage());
	}
	return null;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	setUser(request);
	SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
	vo.setBlankdate(blankdate.getSqlDate());
	if(hasExpiredate) {
		vo.setExpiredate(expiredate.getSqlDate());
	} else {
		vo.setExpiredate(null);
	}
	vo.setSitedoc(getSitedoc());
	try {
		bean.createEtapDoc(vo, (hasComlinelinks?comlines:null));
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException(e.getMessage());
	}

	try {
		CDBCSitedocsObject so = new CDBCSitedocsObject();
		CDBCResultSet rs = so.findEtap2ComlineTriggers(new Integer(getSitedoc()),new Integer(vo.getFreqpermid()));
		Iterator it = rs.listIterator();
		CDBCRowObject ro = null;
		while(it.hasNext()) {
			ro = (CDBCRowObject)it.next();
			int hops = ((Number)ro.getColumn("hopsid").asObject()).intValue();
			String newState = ro.getColumn("resultstate").asString();
			if(newState == null || "".equals(newState)) {
				newState = "0";
			}
			try {
				HopAccessBean h = new HopAccessBean();
				h.setInitKey_hopsid(hops);
				h.refreshCopyHelper();
				h.setPermstatus(newState);
				h.commitCopyHelper();
			} catch(Exception e) {
				System.out.println("Can't update Hop["+hops+"] due to exception: "+e.getClass().getName()+" MSG:"+e.getMessage());
			}
		}
	} catch(Exception ee) {
		ee.printStackTrace(System.out);
	}

	return null;
}
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	setUser(request);
	SitedocFacadeAccessBean bean = new SitedocFacadeAccessBean();
	vo.setBlankdate(blankdate.getSqlDate());
	vo.setExpiredate(expiredate.getSqlDate());
	vo.setSitedoc(getSitedoc());
	try {
		bean.updateEtapDoc(getVo(),(hasComlinelinks?comlines:null));
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException(e.getMessage());
	}
	return null;
}
/**
 * 
 * @param newComlines int[]
 */
public void setComlines(int[] newComlines) {
	comlines = newComlines;
}
public void setFreqpermid(int newFreqpermid) {
	vo.setFreqpermid(newFreqpermid);
}
/**
 * 
 * @param newHasComlinelinks boolean
 */
public void setHasComlinelinks(boolean newHasComlinelinks) {
	hasComlinelinks = newHasComlinelinks;
}
/**
 * 
 * @param newHasExpiredate boolean
 */
public void setHasExpiredate(boolean newHasExpiredate) {
	hasExpiredate = newHasExpiredate;
}
/**
 * 
 * @param newHasPaycheck boolean
 */
public void setHasPaycheck(boolean newHasPaycheck) {
	hasPaycheck = newHasPaycheck;
}
public void validateValues(ActionErrors errors)
	throws Exception 
{
	if(vo.getBlanknumber() == null || "".equals(vo.getBlanknumber().trim())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.blanknumber.empty"));
	} else if(vo.getBlanknumber().length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.blanknumber.length"));
	}

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.blankdate.empty"));
	} else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.blankdate.format"));
	}

	try {
		EtapTypeAccessBean et = new EtapTypeAccessBean();
		et.setInitKey_etaptypeid(vo.getEtaptypeid());
		et.refreshCopyHelper();
		hasExpiredate = et.getHaveendtime();
		hasComlinelinks = et.getHavehopslink();
		hasPaycheck = et.getHavepaycheck();
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.etaptype.notfound"));
	}
/*
	try {
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		Integer r = sdo.findEtapDocByType(new Integer(vo.getEtaptypeid()),new Integer(getFreqpermid()));
		if(r != null && (r.intValue() != getSitedoc())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.alreadyexists"));
		}
	} catch(Exception e) {
	}
*/
	// check expiredate
	if(hasExpiredate) {
		// Проверять только если у "Типа документа" есть необходимость в дате
		if(expiredate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.expiredate.empty"));
		} else if(!expiredate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.expiredate.format"));
		}
	} else {
		expiredate.setString("");
	}

	// check comment CHAR(255)
	if(vo.getComment() != null) {
		vo.setComment(vo.getComment().trim());
		if(vo.getComment().length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.сomment.length"));
		} else if("".equals(vo.getComment())) {
			vo.setComment(null);
		}
	}

	if(hasComlinelinks) {
		// Проверить наличие выбранных линий связи
		if(comlines == null || comlines.length < 1) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.etapform.needcomlines"));
		}
		// Проверить поле "документ связан"
		if(vo.getEquiplink() != null) {
			if(!"A".equals(vo.getEquiplink()) && !"B".equals(vo.getEquiplink())) {
				vo.setEquiplink(null);
			}
		}
	} else {
		vo.setEquiplink(null);
	}

	if(!hasPaycheck) {
		vo.setHavepay(null);
	}

	if(!errors.empty()) {
		throw new ValidationException();
	}
}
}
