package com.hps.july.inventory.formbean;

import javax.ejb.ObjectNotFoundException;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import org.apache.struts.upload.*;
import java.io.*;
import java.util.*;

import com.hps.july.inventory.sessionbean.*;

/**
 * Форма составления строк по базе данных для документа "Акт демонтажа на позиции"
 */
public class DemountFFDB extends com.hps.july.web.util.EditForm {
	private int document;
	private java.sql.Date blankdate;
	private String blanknumber;
	private int blankindex;
	private int owner;
	private String ownername;
	private int position;
	private String positionname;
	private int complect;
	private String complectname;
	private String documentState;
	private String totype;
	private int worker;
	private String workername;
	private int supplier;
	private String suppliername;
	private String supplierfio;

	private int neworder;
public DemountFFDB() {
}
	public ProcessingPositionError addPosition2Document(Integer argPosition) throws java.rmi.RemoteException {
		try {
			DocumentPositionAccessBean position = new DocumentPositionAccessBean();
			position.setInitKey_docposition( argPosition.intValue() );
			position.refreshCopyHelper();
			DocumentAccessBean documentbean = position.getDocument();
//System.out.println("DFFDB/addPosition2Document:ProcessSource:"+documentbean.getProcessSource());
			if( documentbean.getProcessSource() != null && documentbean.getProcessSource().booleanValue() ) {
//System.out.println("DFFDB/addPosition2Document:CounterPolicy:"+position.getResource().getCountpolicy());
				if( position.getResource().getCountpolicy().equals("S") ) {
					//find corresponding storagecard
					StorageCardAccessBean card = (new StorageCardAccessBean()).findBySerial( position.getSerialnumber() );
					//must be the same storage
					if( card.getCurrentstorageKey().storageplace != documentbean.getFromKey().storageplace ) {
						ProcessingPositionError error = new ProcessingPositionError();
						error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
						error.setStorage( card.getCurrentstorageKey().storageplace );
						return error;
					}
					//must be the same resource
					if( card.getResourceKey().resource != position.getResourceKey().resource ) {
						ProcessingPositionError error = new ProcessingPositionError();
						error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
						error.setResource( position.getResourceKey().resource );
						return error;
					}
					AgregateContentAccessBean ac = new AgregateContentAccessBean();
					Enumeration en = ac.findAgregateContentByAgregate(new StorageCardKey(card.getStoragecard()));
//System.out.println("DFFDB/addPosition2Document/AgrElements:"+en.hasMoreElements());
					while(en.hasMoreElements()) {
						AgregateContentAccessBean agr = (AgregateContentAccessBean)en.nextElement();//parts.getAgregateContentAccessBean(i);
						StorageCardAccessBean sc = agr.getParts();
						if(sc.getClosed() != null && !sc.getClosed().booleanValue()) {
//System.out.println("DFFDB/addPosition2Document/AddPart:"+sc.getStoragecard());
							int nextKey = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
							DocumentPositionAccessBean pos = constructDocumentPosition(sc, documentbean, nextKey, position, neworder++, agr);
						}
					}
				}
			}
		} catch( Exception e ) {
			e.printStackTrace();
			throw new java.rmi.RemoteException( "While adding position to document.", e );
		}
		return null;
	}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	// create document positions by storagecards
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

	Enumeration en;
	en = (new StorageCardAccessBean()).findStorageCardByQBE3(
			new Integer(complect),
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, "",
			Boolean.FALSE, "",
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, "",
			Boolean.TRUE,
			new Integer(0),
			new Integer(document),
			Boolean.TRUE, new Integer(0),
			Boolean.FALSE, "",
			new Integer(1)
		);

	StorageCardAccessBean card;
	int i = 1;
	neworder = 1;
	DocumentPositionAccessBean pfind = new DocumentPositionAccessBean();
	DocumentPositionAccessBean p;
	boolean create = false;

	try {
		p = pfind.findMaxOrderPosition(new Integer(document));
		neworder = p.getOrder() + 1;
	} catch(Exception e) {
		neworder = 1;
	}

	while(en.hasMoreElements()) {
		card = (StorageCardAccessBean)en.nextElement();
		if(card.getClosed().booleanValue()) continue;
		String policy = card.getResource().getCountpolicy();
		create = true;
 		int code = keyGen.getNextKey("tables.docpositions");
		DocumentPositionAccessBean newpos = new DocumentPositionAccessBean(
			code,
			new Integer(card.getResource().getResource()),
			new Integer(card.getOwner().getOrganization()),
			new Integer(document),
			neworder++,
			card.getQty(),
			card.getPrice(),
			card.getBoxed(),
			card.getBoxed(),
			card.getBroken(),
			card.getBroken(),
			Boolean.FALSE,
			Boolean.FALSE
		);

		newpos.setIsfictserial(card.getIsfictserial());
		newpos.setSerialnumber(card.getSerialnumber());
		newpos.setRealserial(null);

		newpos.setParty(card.getParty());
		newpos.setConfiguration(card.getConfiguration());
		newpos.setNewplace(card.getPlace());
		newpos.setNotes(card.getNotes());
		newpos.setQty(card.getQty());
		newpos.commitCopyHelper();

		ProcessingPositionError err = addPosition2Document(new Integer(code));
		/*if ((err != null) && (err.getErrorCode() != 0))
			System.out.println("DFFDB:COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());*/
		
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return null;
}
public DocumentPositionAccessBean constructDocumentPosition(StorageCardAccessBean sc, DocumentAccessBean doc, int newDocposition, DocumentPositionAccessBean position, int order, AgregateContentAccessBean agr)
	throws Exception
{
	if(position != null) position.refreshCopyHelper();

	DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
		newDocposition, 
		new Integer(sc.getResourceKey().resource), new Integer(sc.getOwnerKey().organization), 
		new Integer(doc.getDocument()), 
		order, agr.getQty(), sc.getPrice(), sc.getBoxed(), position.getResultBoxed(), sc.getBroken(), 
		position.getResultBroken(), sc.getClosed(), position.getResultClosed() );
	pos.setParty( sc.getParty() );
	pos.setIsfictserial(sc.getIsfictserial());
	if(sc.getIsfictserial()) {
		pos.setSerialnumber(sc.getSerialnumber());
		pos.setRealserial(sc.getSerialnumber());
	} else {
		pos.setSerialnumber(sc.getSerialnumber());
		pos.setRealserial("");
	}
	pos.setConfiguration( sc.getConfiguration() );
	pos.setAgregate( (DocumentPosition)(position.getEJBRef()) );
	pos.commitCopyHelper();
	return pos;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	InternalOutBillAccessBean d = (InternalOutBillAccessBean)bean;
	try {
		blanknumber = d.getBlanknumber();
		blankindex = d.getBlankindex();
		blankdate = d.getBlankdate();
		owner = d.getOwner().getOrganization();
		ownername = d.getOwner().getName();
		documentState = d.getDocumentState();
		
		complect = d.getFrom().getStorageplace();
		
		EquipmentSetAccessBean equ = new EquipmentSetAccessBean(d.getFrom().getEJBRef());
		complectname = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(equ);
		PositionAccessBean position = equ.getPosition();
		String positionid = "";
		if(position.getDampsid() != null) {
			positionid = positionid + "A" + position.getDampsid() + " ";
		}
		if(position.getGsmid() != null) {
			positionid = positionid + "D" + position.getGsmid() + " ";
		}
		positionname = positionid + position.getName();
		ExpeditionAccessBean ep = new ExpeditionAccessBean();
		ep.setInitKey_storageplace(d.getTo().getStorageplace());
		ep.refreshCopyHelper();
		if(ep.getExpeditor() != null) {
			totype = "W";
			worker = ep.getExpeditor().getWorker();
			workername = ep.getExpeditor().getMan().getFullName();
		}
		if(ep.getOrganization() != null) {
			totype = "P";
			supplier = ep.getOrganization().getOrganization();
			suppliername = ep.getOrganization().getName();
			supplierfio = d.getInsuranseMan();
		}
		
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getBlankdate() {
	return blankdate;
}
/**
 * 
 * @return int
 */
public int getBlankindex() {
	return blankindex;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * 
 * @return int
 */
public int getComplect() {
	return complect;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
{
	return null;
}
/**
 * 
 * @return int
 */
public int getDocument() {
	return document;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDocumentState() {
	return documentState;
}
/**
 * 
 * @return int
 */
public int getOwner() {
	return owner;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * 
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public int getState() {
	return com.hps.july.inventory.APPStates.DISM_FFDB;
}
/**
 * 
 * @return int
 */
public int getSupplier() {
	return supplier;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSupplierfio() {
	return supplierfio;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSuppliername() {
	return suppliername;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getTotype() {
	return totype;
}
/**
 * 
 * @return int
 */
public int getWorker() {
	return worker;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 17:53:26)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	if(document > 0) {
		InternalOutBillAccessBean d = new InternalOutBillAccessBean();
		d.setInitKey_document(document);
		d.refreshCopyHelper();
		fillRecord(d);
	}
}
/**
 * 
 * @param newBlankdate java.sql.Date
 */
public void setBlankdate(java.sql.Date newBlankdate) {
	blankdate = newBlankdate;
}
/**
 * 
 * @param newBlankindex int
 */
public void setBlankindex(int newBlankindex) {
	blankindex = newBlankindex;
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
 * @param newComplect int
 */
public void setComplect(int newComplect) {
	complect = newComplect;
}
/**
 * 
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * 
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * 
 * @param newDocumentState java.lang.String
 */
public void setDocumentState(java.lang.String newDocumentState) {
	documentState = newDocumentState;
}
/**
 * 
 * @param newOwner int
 */
public void setOwner(int newOwner) {
	owner = newOwner;
}
/**
 * 
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * 
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * 
 * @param newSupplier int
 */
public void setSupplier(int newSupplier) {
	supplier = newSupplier;
}
/**
 * 
 * @param newSupplierfio java.lang.String
 */
public void setSupplierfio(java.lang.String newSupplierfio) {
	supplierfio = newSupplierfio;
}
/**
 * 
 * @param newSuppliername java.lang.String
 */
public void setSuppliername(java.lang.String newSuppliername) {
	suppliername = newSuppliername;
}
/**
 * 
 * @param newTotype java.lang.String
 */
public void setTotype(java.lang.String newTotype) {
	totype = newTotype;
}
/**
 * 
 * @param newWorker int
 */
public void setWorker(int newWorker) {
	worker = newWorker;
}
/**
 * 
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	initRecord(null);

	Enumeration en;
	en = (new StorageCardAccessBean()).findStorageCardByQBE3(
		new Integer(complect),
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE,new Integer(0),
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE, "",
		Boolean.FALSE, "",
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE, "",
		Boolean.TRUE,
		new Integer(0),
		new Integer(document),
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE, "",
		new Integer(1)
	);
	if(!en.hasMoreElements()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fillfromdb.norecordstocopy",positionname + ", "+complectname));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
