package com.hps.july.persistence2;

import java.util.Enumeration;
import com.hps.july.trailcom.beans.Sitedoc2HopsAccessBean;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;

/**
 * Логика работы с документами
 * This is a Session Bean Class
 */
public class SitedocFacadeBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
    private final static String GKRCHDOCTYPE = "GKRCHDOCTYPE";
    private final static String RRLDOCTYPE = "RRLDOCTYPE";
private void createComlineLinks(int sitedoc, int[] comlines)
	throws Exception
{
	if(comlines != null) {
		try {
			for(int i = 0; i < comlines.length; i++) {
System.out.println("ETAP: COMcreate("+sitedoc+","+comlines[i]+")");
				Sitedoc2HopsAccessBean b = new Sitedoc2HopsAccessBean(sitedoc,comlines[i]);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new Exception("error.etapform.createcomlinelinks");
		}
	}
}
private void createEtapComlineLinks(int sitedoc, int[] comlines, int freqpermid,boolean unused)
	throws Exception
{
	if(comlines != null) {
		try {
			for(int i = 0; i < comlines.length; i++) {
System.out.println("ETAP: COMcreate("+comlines[i]+","+sitedoc+","+freqpermid+")");
				Etap2HopAccessBean b = new Etap2HopAccessBean(comlines[i],sitedoc,freqpermid);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new Exception("error.etapform.createcomlinelinks");
		}
	}
}
/**
 * Создание документа по этапу прохождения заявки на частотное разрешение.
 * Creation date: (21.06.2004 11:49:05)
 */
public void createEtapDoc(EtapDocValueObject argObj, int[] comlines)
	throws Exception
{
	try {
		//System.out.println("CREATEETAPDOC: #1, sitedoc=" + argObj.getSitedoc());
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		if (argObj.getSitedoc() <= 0)
			argObj.setSitedoc(keygen.getNextKey("tables.sitedocs"));
		//System.out.println("CREATEETAPDOC: #2, sitedoc=" + argObj.getSitedoc());
		SiteDocAccessBean sdoc = new SiteDocAccessBean(argObj.getSitedoc(), getRRLSiteDocType(),  getMan());
		sdoc.setBlanknumber(argObj.getBlanknumber());
		sdoc.setBlankdate(argObj.getBlankdate());
		sdoc.setExpiredate(argObj.getExpiredate());
		sdoc.setComment(argObj.getComment());
		sdoc.commitCopyHelper();
		EtapDocAccessBean adddoc = new EtapDocAccessBean(argObj.getSitedoc(), argObj.getEtaptypeid(), argObj.getFreqpermid());
		adddoc.setEquiplink(argObj.getEquiplink());
		adddoc.setHavepay(argObj.getHavepay());
		adddoc.commitCopyHelper();
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error creating EtapDoc");
		e.printStackTrace(System.out);
		throw new Exception("error.etapform.create");
	}
	if(comlines != null) {
		createComlineLinks(argObj.getSitedoc(), comlines/*, argObj.getFreqpermid()*/);
	}
}
/**
 * Создания решения ГКРЧ без связей с регионами и ресурсами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void createGKRCHDoc(GKRCHDocValueObject argObj) throws java.rmi.RemoteException {
	createGKRCHDoc(argObj, null, null);
}
/**
 * Создания решения ГКРЧ со связями с регионами и ресурсами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void createGKRCHDoc(GKRCHDocValueObject argObj, DocResourceValueObject [] argResources, int [] argRegions) throws java.rmi.RemoteException {
	try {
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		if (argObj.getSitedoc() == 0)
			argObj.setSitedoc(keygen.getNextKey("tables.sitedocs"));
		SiteDocAccessBean sdoc = new SiteDocAccessBean(argObj.getSitedoc(), getGKRCHSiteDocType(),  getMan());
		sdoc.setBlanknumber(argObj.getBlanknumber());
		sdoc.setBlankdate(argObj.getBlankdate());
		sdoc.setExpiredate(argObj.getExpiredate());
		sdoc.setComment(argObj.getComment());
		sdoc.commitCopyHelper();
		GKRCHDocAccessBean gkrchdoc = new GKRCHDocAccessBean(argObj.getSitedoc());
		gkrchdoc.setRestrictions(argObj.getRestrictions());
		gkrchdoc.commitCopyHelper();
		createResourceLink(argObj.getSitedoc(), argResources);
		createRegionLink(argObj.getSitedoc(), argRegions);
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error creating GKRCHDoc");
		e.printStackTrace(System.out);
	}
}
/**
 * Создание связи с регионами.
 * Creation date: (21.06.2004 12:51:49)
 * @param argSiteDoc int
 * @param argRegions int[]
 */
private void createRegionLink(int argSiteDoc, int[] argRegions) {
	if (argRegions != null) {
		for (int i = 0; i < argRegions.length; i++) {
			try {
				Sitedoc2RegionAccessBean sd2r = new Sitedoc2RegionAccessBean(argRegions [i], argSiteDoc);
			} catch (Exception e) {
				// Rollback transaction
				getSessionContext().setRollbackOnly();
				System.out.println("Cannot link sitedoc to region");
				e.printStackTrace(System.out);
				break;
			}
		}
	}
}
/**
 * Создание связи с ресурсами.
 * Creation date: (21.06.2004 12:51:49)
 * @param argSiteDoc int
 * @param argResources int[]
 */
private void createResourceLink(int argSiteDoc, DocResourceValueObject[] argResources) {
	if (argResources != null) {
		for (int i = 0; i < argResources.length; i++) {
			try {
				Sitedoc2ResourceAccessBean sd2r = new Sitedoc2ResourceAccessBean(argResources[i].getResource(), argSiteDoc);
				sd2r.setFreqrange(argResources[i].getFreqrange());
				sd2r.commitCopyHelper();
			} catch (Exception e) {
				// Rollback transaction
				getSessionContext().setRollbackOnly();
				System.out.println("Cannot link sitedoc to resource");
				e.printStackTrace(System.out);
				break;
			}
		}
	}
}
/**
 * Создание сертификата на оборудование RRL без связей с ресурсами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void createRRLDoc(RRLDocValueObject argObj) throws java.rmi.RemoteException {
	createRRLDoc(argObj, null);
}
/**
 * Создание сертификата на оборудование RRL со связями с ресурсами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void createRRLDoc(RRLDocValueObject argObj, DocResourceValueObject[] argResources) throws java.rmi.RemoteException {
	try {
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		if (argObj.getSitedoc() == 0)
			argObj.setSitedoc(keygen.getNextKey("tables.sitedocs"));
		SiteDocAccessBean sdoc = new SiteDocAccessBean(argObj.getSitedoc(), getRRLSiteDocType(),  getMan());
		sdoc.setBlanknumber(argObj.getBlanknumber());
		sdoc.setBlankdate(argObj.getBlankdate());
		sdoc.setExpiredate(argObj.getExpiredate());
		sdoc.commitCopyHelper();
		RRLDocsAccessBean adddoc = new RRLDocsAccessBean(argObj.getSitedoc(), argObj.getOrganization());
		adddoc.commitCopyHelper();
		createResourceLink(argObj.getSitedoc(), argResources);
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error creating RRLDoc");
		e.printStackTrace(System.out);
	}
}
private void deleteComlineLinks(int sitedoc)
	throws Exception
{
	try {
		Sitedoc2HopsAccessBean f = new Sitedoc2HopsAccessBean();
		Enumeration en = f.findSitedoc2HopsBySitedoc(new Integer(sitedoc));
		while(en.hasMoreElements()) {
			Sitedoc2HopsAccessBean b = (Sitedoc2HopsAccessBean)en.nextElement();
			b.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new Exception("error.etapform.deletecomlinelinks");
	}
}
private void deleteEtapComlineLinks(int sitedoc, int freqpermid,boolean unused)
	throws Exception
{
	try {
		Etap2HopAccessBean f = new Etap2HopAccessBean();
		Enumeration en = f.findBySitedocAndPermid(new Integer(sitedoc), new Integer(freqpermid));
		while(en.hasMoreElements()) {
			Etap2HopAccessBean b = (Etap2HopAccessBean)en.nextElement();
			b.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new Exception("error.etapform.deletecomlinelinks");
	}
}
/**
 * Удаление этапа прохождения заявки на частотное разрешение
 * Creation date: (21.06.2004 11:49:05)
 */
public void deleteEtapDoc(int argSiteDoc)
	throws Exception
{
	try {
		SiteDocFileAccessBean sdf = new SiteDocFileAccessBean();
		Enumeration en = sdf.findBySitedocOrderBySitedocAsc(new Integer(argSiteDoc));
		while(en.hasMoreElements()) {
			SiteDocFileAccessBean s = (SiteDocFileAccessBean)en.nextElement();
			s.getEJBRef().remove();
		}
	} catch(Exception e) {
		throw new Exception("error.etapform.cantdeletefiles");
	}

	EtapDocAccessBean adddoc = null;
	try {
		adddoc = new EtapDocAccessBean();
		adddoc.setInitKey_sitedoc(argSiteDoc);
		adddoc.refreshCopyHelper();
	} catch(Exception e) {
		throw new Exception("error.etapform.cantfindetap");
	}

	if(adddoc != null) {
		deleteComlineLinks(argSiteDoc/*,adddoc.getFreqpermid()*/);
	}

	try {
		adddoc.getEJBRef().remove();
		SiteDocAccessBean sdoc = new SiteDocAccessBean();
		sdoc.setInitKey_sitedoc(argSiteDoc);
		sdoc.refreshCopyHelper();
		sdoc.getEJBRef().remove();
	} catch(Exception e) {
		throw new Exception("error.etapform.delete");
	}
}
/**
 * Удаление решения ГКРЧ
 * Creation date: (21.06.2004 11:49:05)
 */
public void deleteGKRCHDoc(int argSiteDoc) throws Exception {
	deleteResourcesLink(argSiteDoc);
	deleteRegionLink(argSiteDoc);
	GKRCHDocAccessBean gkrchdoc = new GKRCHDocAccessBean();
	gkrchdoc.setInitKey_sitedoc(argSiteDoc);
	gkrchdoc.refreshCopyHelper();
	gkrchdoc.getEJBRef().remove();
	SiteDocAccessBean sdoc = new SiteDocAccessBean();
	sdoc.setInitKey_sitedoc(argSiteDoc);
	sdoc.refreshCopyHelper();
	sdoc.getEJBRef().remove();
}
/**
 * Удаление связи с регионами.
 * Creation date: (21.06.2004 12:51:49)
 * @param argSiteDoc int
 */
private void deleteRegionLink(int argSiteDoc) {
	try {
		java.util.Enumeration en = new Sitedoc2RegionAccessBean().findAllBySitedoc(argSiteDoc);
		while (en.hasMoreElements()) {
			Sitedoc2RegionAccessBean sd = (Sitedoc2RegionAccessBean)en.nextElement();
			sd.getEJBRef().remove();
		}
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error deleting sitedoc2region link");
		e.printStackTrace(System.out);
	}
}
/**
 * Удаление связи документа с ресурсами.
 * Creation date: (21.06.2004 12:51:49)
 * @param argSiteDoc int
 */
private void deleteResourcesLink(int argSiteDoc) {
	try {
		java.util.Enumeration en = new Sitedoc2ResourceAccessBean().findAllBySitedoc(argSiteDoc);
		while (en.hasMoreElements()) {
			Sitedoc2ResourceAccessBean sd = (Sitedoc2ResourceAccessBean)en.nextElement();
			sd.getEJBRef().remove();
		}
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error deleting sitedoc2resource link");
		e.printStackTrace(System.out);
	}
}
/**
 * Удаление сертификата на оборудование RRL
 * Creation date: (21.06.2004 11:49:05)
 */
public void deleteRRLDoc(int argSiteDoc) throws Exception {
	deleteResourcesLink(argSiteDoc);
	RRLDocsAccessBean adddoc = new RRLDocsAccessBean();
	adddoc.setInitKey_sitedoc(argSiteDoc);
	adddoc.refreshCopyHelper();
	adddoc.getEJBRef().remove();
	SiteDocAccessBean sdoc = new SiteDocAccessBean();
	sdoc.setInitKey_sitedoc(argSiteDoc);
	sdoc.refreshCopyHelper();
	sdoc.getEJBRef().remove();
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * Поиск этапа прохождения заявки на частотное разрешение по коду документа.
 * Creation date: (21.06.2004 11:49:05)
 */
public EtapDocValueObject findEtapDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException {
	EtapDocValueObject result = new EtapDocValueObject();
	result.setSitedoc(argSiteDoc);
	try {
		SiteDocAccessBean sdoc = new SiteDocAccessBean();
		sdoc.setInitKey_sitedoc(argSiteDoc);
		sdoc.refreshCopyHelper();
		result.setBlanknumber(sdoc.getBlanknumber());
		result.setBlankdate(sdoc.getBlankdate());
		result.setExpiredate(sdoc.getExpiredate());
		result.setComment(sdoc.getComment());
		EtapDocAccessBean adddoc = new EtapDocAccessBean();
		adddoc.setInitKey_sitedoc(argSiteDoc);
		adddoc.refreshCopyHelper();
		result.setEtaptypeid(adddoc.getEtaptypeid());
		result.setFreqpermid(adddoc.getFreqpermid());
		result.setEquiplink(adddoc.getEquiplink());
		result.setHavepay(adddoc.getHavepay());
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error finding EtapDoc");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Поиск решения ГКРЧ по коду документа.
 * Creation date: (21.06.2004 11:49:05)
 */
public GKRCHDocValueObject findGKRCHDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException {
	GKRCHDocValueObject result = new GKRCHDocValueObject();
	result.setSitedoc(argSiteDoc);
	try {
		SiteDocAccessBean sdoc = new SiteDocAccessBean();
		sdoc.setInitKey_sitedoc(argSiteDoc);
		sdoc.refreshCopyHelper();
		result.setBlanknumber(sdoc.getBlanknumber());
		result.setBlankdate(sdoc.getBlankdate());
		result.setExpiredate(sdoc.getExpiredate());
		result.setComment(sdoc.getComment());
		GKRCHDocAccessBean gkrchdoc = new GKRCHDocAccessBean();
		gkrchdoc.setInitKey_sitedoc(argSiteDoc);
		gkrchdoc.refreshCopyHelper();
//		result.setFreqrange(gkrchdoc.getFreqrange());
		result.setRestrictions(gkrchdoc.getRestrictions());
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error finding GKRCHDoc");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Поиск сертификата RRL по коду документа.
 * Creation date: (21.06.2004 11:49:05)
 */
public RRLDocValueObject findRRLDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException {
	RRLDocValueObject result = new RRLDocValueObject();
	result.setSitedoc(argSiteDoc);
	try {
		SiteDocAccessBean sdoc = new SiteDocAccessBean();
		sdoc.setInitKey_sitedoc(argSiteDoc);
		sdoc.refreshCopyHelper();
		result.setBlanknumber(sdoc.getBlanknumber());
		result.setBlankdate(sdoc.getBlankdate());
		result.setExpiredate(sdoc.getExpiredate());
		RRLDocsAccessBean adddoc = new RRLDocsAccessBean();
		adddoc.setInitKey_sitedoc(argSiteDoc);
		adddoc.refreshCopyHelper();
		result.setOrganization(adddoc.getOrganization());
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error finding RRLDoc");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Определение типа документа по константе.
 * Creation date: (21.06.2004 12:37:15)
 * @return int
 */
public int getGKRCHSiteDocType() {
	int result = 0;
	NamedValueAccessBean nab = new NamedValueAccessBean();
	try {
		nab.setInitKey_id(GKRCHDOCTYPE);
		nab.refreshCopyHelper();
		result = nab.getIntvalue();
	} catch (Exception e) {
		System.out.println("Cannot read constant " + GKRCHDOCTYPE);
	}
	return result;
}
/**
 * Определение физ. лица, создавщего документ.
 * Creation date: (21.06.2004 12:43:01)
 * @return int
 */
private int getMan() {
	int result = 0;
	Integer oper = OperatorObject.getOperatorCode(getSessionContext().getCallerIdentity().getName());
	OperatorAccessBean oab = new OperatorAccessBean();
	try {
		oab.setInitKey_operator(oper.intValue());
		oab.refreshCopyHelper();
		result = oab.getManKey().man;
	} catch (Exception e) {
		System.out.println("Cannot determine operator");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Определение типа документа по константе.
 * Creation date: (21.06.2004 12:37:15)
 * @return int
 */
public int getRRLSiteDocType() {
	int result = 0;
	NamedValueAccessBean nab = new NamedValueAccessBean();
	try {
		nab.setInitKey_id(RRLDOCTYPE);
		nab.refreshCopyHelper();
		result = nab.getIntvalue();
	} catch (Exception e) {
		System.out.println("Cannot read constant " + RRLDOCTYPE);
	}
	return result;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
/**
 * Обновление этапа прохождения заявки на частотное разрешение.
 * Creation date: (21.06.2004 11:49:05)
 */
public void updateEtapDoc(EtapDocValueObject argObj, int[] comlines)
	throws Exception
{
	try {
		SiteDocAccessBean sdoc = new SiteDocAccessBean();
		sdoc.setInitKey_sitedoc(argObj.getSitedoc());
		sdoc.refreshCopyHelper();
		sdoc.setBlanknumber(argObj.getBlanknumber());
		sdoc.setBlankdate(argObj.getBlankdate());
		sdoc.setExpiredate(argObj.getExpiredate());
		sdoc.setComment(argObj.getComment());
		sdoc.commitCopyHelper();
		EtapDocAccessBean adddoc = new EtapDocAccessBean();
		adddoc.setInitKey_sitedoc(argObj.getSitedoc());
		adddoc.refreshCopyHelper();
		adddoc.setEtaptypeid(argObj.getEtaptypeid());
		adddoc.setFreqpermid(argObj.getFreqpermid());
		adddoc.setEquiplink(argObj.getEquiplink());
		adddoc.setHavepay(argObj.getHavepay());
		adddoc.commitCopyHelper();
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error updating EtapDoc");
		e.printStackTrace(System.out);
	}

	deleteComlineLinks(argObj.getSitedoc()/*,argObj.getFreqpermid()*/);

	if(comlines != null) {
		createComlineLinks(argObj.getSitedoc(), comlines/*, argObj.getFreqpermid()*/);
	}
}
/**
 * Обновление решения ГКРЧ без обновления связей с ресурсами и регионами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void updateGKRCHDoc(GKRCHDocValueObject argObj) throws java.rmi.RemoteException {
	try {
		SiteDocAccessBean sdoc = new SiteDocAccessBean();
		sdoc.setInitKey_sitedoc(argObj.getSitedoc());
		sdoc.refreshCopyHelper();
		sdoc.setBlanknumber(argObj.getBlanknumber());
		sdoc.setBlankdate(argObj.getBlankdate());
		sdoc.setExpiredate(argObj.getExpiredate());
		sdoc.setComment(argObj.getComment());
		sdoc.commitCopyHelper();
		GKRCHDocAccessBean gkrchdoc = new GKRCHDocAccessBean();
		gkrchdoc.setInitKey_sitedoc(argObj.getSitedoc());
		gkrchdoc.refreshCopyHelper();
//		gkrchdoc.setFreqrange(argObj.getFreqrange());
		gkrchdoc.setRestrictions(argObj.getRestrictions());
		gkrchdoc.commitCopyHelper();
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error updating GKRCHDoc");
		e.printStackTrace(System.out);
	}
}
/**
 * Обновление решения ГКРЧ и связей с ресурсами и регионами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void updateGKRCHDoc(GKRCHDocValueObject argObj, DocResourceValueObject[] argResources, int [] argRegions) throws java.rmi.RemoteException {
	updateGKRCHDoc(argObj);
	deleteResourcesLink(argObj.getSitedoc());
	deleteRegionLink(argObj.getSitedoc());
	createResourceLink(argObj.getSitedoc(), argResources);
	createRegionLink(argObj.getSitedoc(), argRegions);
}
/**
 * Обновление сертификата на оборудование RRL без обновления связей с ресурсами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void updateRRLDoc(RRLDocValueObject argObj) throws java.rmi.RemoteException {
	try {
		SiteDocAccessBean sdoc = new SiteDocAccessBean();
		sdoc.setInitKey_sitedoc(argObj.getSitedoc());
		sdoc.refreshCopyHelper();
		sdoc.setBlanknumber(argObj.getBlanknumber());
		sdoc.setBlankdate(argObj.getBlankdate());
		sdoc.setExpiredate(argObj.getExpiredate());
		sdoc.commitCopyHelper();
		RRLDocsAccessBean adddoc = new RRLDocsAccessBean();
		adddoc.setInitKey_sitedoc(argObj.getSitedoc());
		adddoc.refreshCopyHelper();
		adddoc.setOrganization(argObj.getOrganization());
		adddoc.commitCopyHelper();
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error updating RRLDoc");
		e.printStackTrace(System.out);
	}
}
/**
 * Обновление сертификата на оборудование RRL и связей с ресурсами.
 * Creation date: (21.06.2004 11:49:05)
 */
public void updateRRLDoc(RRLDocValueObject argObj, DocResourceValueObject[] argResources) throws java.rmi.RemoteException {
	updateRRLDoc(argObj);
	deleteResourcesLink(argObj.getSitedoc());
	createResourceLink(argObj.getSitedoc(), argResources);
}
}
