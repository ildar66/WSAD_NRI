package com.hps.july.inventory.formbean;

import java.sql.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.inventory.sessionbean.ProcessorFacadeAccessBean;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * Абстрактный базовый класс для форм документов.
 *
 * Базовая функциональность формы производит удалении связанных с документом
 * строк, ссылок и пр.
 */
public abstract class DocumentForm
	extends com.hps.july.web.util.EditForm
{
	private Boolean children;

	private String processState;
	private Boolean warnProc;
	private boolean isautodoc;

	private String _username;
	private boolean _isadmin;

	private java.util.Vector storages = new java.util.Vector();
	private boolean useStorageCombo;
	
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	if(("View".equals(getAction()) || "Edit".equals(getAction()))
		&& getProcessState() != null && !"".equals(getProcessState()))
	{
		try {
			com.hps.july.cdbc.objects.CDBCInventoryDocumentError cdbcIDER;
			cdbcIDER = new com.hps.july.cdbc.objects.CDBCInventoryDocumentError();

			cdbcIDER.clearDocumentErrors(getDocumentId());
			
			ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
//System.out.println("PROCESS DOC#:"+getDocumentId()+", Action:"+getProcessState()+", WARN:"+warnProc);
			boolean wp = warnProc != null && warnProc.booleanValue();
			if("P".equals(getProcessState())) {
				processor.processDocument(getDocumentId(),false,wp);
				warnProc = null;
				setAction("View");
			} else
			if("C".equals(getProcessState())) {
				setAction("View");
				processor.cancelDocument(getDocumentId());
				setAction("Edit");
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw e;
		}
		processState = null;
	}
}
public void beforeDelete(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception 
{
	try {
		DocumentsLinkAccessBean lf = new DocumentsLinkAccessBean();
		Enumeration el = lf.findDocumentsLinkFromByDocumentfrom(new DocumentKey(getDocumentId().intValue()));
		while(el.hasMoreElements()) {
			DocumentsLinkAccessBean _a = (DocumentsLinkAccessBean)el.nextElement();
			_a.refreshCopyHelper();
			_a.getEJBRef().remove();
		}
			
		el = lf.findDocumentsLinkToByDocumentTo(new DocumentKey(getDocumentId().intValue()));
		while(el.hasMoreElements()) {
			DocumentsLinkAccessBean _a = (DocumentsLinkAccessBean)el.nextElement();
			_a.refreshCopyHelper();
			_a.getEJBRef().remove();
		}
		Enumeration en = getDocumentPositions();
//		log("Has positions :"+en.hasMoreElements());
		while(en.hasMoreElements()) {
			AbstractEntityAccessBean v = (AbstractEntityAccessBean)en.nextElement();
			v.refreshCopyHelper();
			if(v.getEJBRef() instanceof DocumentPosition) {
				((DocumentPosition)v.getEJBRef()).setAgregate(null);
				((DocumentPosition)v.getEJBRef()).setAgregateSerial(null);
			}
//			log("Position unagregated");
		}
		en = getDocumentPositions();
		while(en.hasMoreElements()) {
			AbstractEntityAccessBean v = (AbstractEntityAccessBean)en.nextElement();
			v.refreshCopyHelper();
			if(v.getEJBRef() instanceof DocumentPosition) {
				((DocumentPosition)v.getEJBRef()).setAgregate(null);
			}
			v.getEJBRef().remove();
//			log("Position removed");
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public void fillRecord(AbstractEntityAccessBean bean) {
	warnProc = null;
	com.hps.july.cdbc.objects.CDBCDocuments cd = new com.hps.july.cdbc.objects.CDBCDocuments();
	warnProc = new Boolean(cd.hasDocumentWarnings(getDocumentId()));
	if("Delete".equals(getAction())) {
		try {
			Enumeration en = getDocumentPositions();
			children = new Boolean(en.hasMoreElements());
		} catch(Exception e) {
			children = null;
		}
		log("Children = "+children);
	}
}
public boolean get_Isadmin() {
	return _isadmin;
}
public java.lang.String get_Username() {
	return _username;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public java.lang.Boolean getChildren() {
	return children;
}
public abstract Integer getDocumentId();
public Enumeration getDocumentPositions()
	throws Exception
{
	DocumentPositionAccessBean fb = new DocumentPositionAccessBean();
	return fb.findDocPositionsByDocOrderByOrderAsc(getDocumentId());
}
public boolean getIsautodoc() {
	return isautodoc;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getProcessState() {
	return processState;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 16:12:27)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getStorages() {
	return storages.elements();
}
public boolean getUseStorageCombo() {
	return useStorageCombo;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getWarnProc() {
	return warnProc;
}
public void initCollections(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setRequestParams(request);
	try {
		java.util.Vector ar = new java.util.Vector();
		com.hps.july.cdbc.objects.CDBCDocuments d = new com.hps.july.cdbc.objects.CDBCDocuments();
		com.hps.july.cdbc.lib.CDBCResultSet rs = d.listStoragesFor(new Boolean(_isadmin),_username);
		useStorageCombo = false;
		if(rs.getRowsCount() < 32) {
			useStorageCombo = true;
		}
		java.util.Iterator it = rs.listIterator();
		while(it.hasNext()) {
			com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
			com.hps.july.inventory.valueobject.StorageVO vo = new com.hps.july.inventory.valueobject.StorageVO(
				ro.getColumn("storageplace").asObject(),
				ro.getColumn("spname").asString()
			);
			ar.add(vo);
		}
//System.out.println("Storages: get "+rs.getRowsCount());
		storages = ar;
	} catch(Exception e) {
		storages = new java.util.Vector();
	}
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	super.initRecord(request);
	setWarnProc(null);
	setIsautodoc(false);
}
public void log(String logstring) {
	//System.out.println("DocumentForm:"+logstring);
}
public void setChildren(java.lang.Boolean newChildren) {
	children = newChildren;
}
public void setIsautodoc(boolean newIsautodoc) {
	isautodoc = newIsautodoc;
}
/**
 * 
 * @param newProcessState java.lang.String
 */
public void setProcessState(java.lang.String newProcessState) {
	processState = newProcessState;
}
public void setRequestParams(HttpServletRequest request)
{
	_isadmin = request.isUserInRole("administrator");
	_username = request.getRemoteUser();
//System.out.println("USER: "+_username+" ADMIN:"+_isadmin);
}
/**
 * 
 * @param newWarnProc java.lang.Boolean
 */
public void setWarnProc(java.lang.Boolean newWarnProc) {
//System.out.println("SETWARN:"+newWarnProc);
	warnProc = newWarnProc;
}
}
