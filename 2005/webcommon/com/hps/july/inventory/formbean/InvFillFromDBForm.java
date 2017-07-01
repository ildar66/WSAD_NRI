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

/**
 * Форма заполнения документа "Акт инвентаризации на позиции" по состоянию базы данных
 */
public class InvFillFromDBForm extends com.hps.july.web.util.EditForm {
	private int doc;
	private java.sql.Date blankdate;
	private String blanknumber;
	private int blankindex;
	private String storagename;
	private String agregatename;
	private String orgname;
	private String type;
	private String documentState;
	private String positionname;
	private int storage;
	private int owner;
	private int agregate;
public InvFillFromDBForm() {
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	// create document positions by storagecards
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

	Enumeration en;
//	if("A".equals(type)) {
//		en = (new StorageCardAccessBean()).findByMainAgregateOrderByResourceAsc(new Integer(agregate));
//	} else {
//		en = (new StorageCardAccessBean()).findStorageCardByQBE(
//			new Integer(storage),
//		    Boolean.FALSE, new Integer(0),
//		    Boolean.FALSE, new Integer(0),
//		    Boolean.FALSE, new Integer(0),
//		    Boolean.FALSE, new Integer(0),
//		    Boolean.FALSE, "",
//		    Boolean.FALSE, "",
//		    Boolean.FALSE, new Integer(0),
//		    Boolean.FALSE, "",
//			new Integer(1)
//		);
		en = (new StorageCardAccessBean()).findStorageCardByQBE3(
			new Integer(storage),
			Boolean.FALSE, new Integer(0),
			("A".equals(type))?Boolean.TRUE:Boolean.FALSE,new Integer(agregate),
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, "",
			Boolean.FALSE, "",
			Boolean.FALSE, new Integer(0),
			Boolean.FALSE, "",
			("A".equals(type))?Boolean.FALSE:Boolean.TRUE,
			new Integer(0),
			new Integer(doc),
			("A".equals(type))?Boolean.TRUE:Boolean.FALSE, new Integer(agregate),
			Boolean.FALSE, "",
			new Integer(1)
		);
//	}

	StorageCardAccessBean card;
	int i = 1;
	int neworder = 1;
	DocumentPositionAccessBean pfind = new DocumentPositionAccessBean();
	DocumentPositionAccessBean p;
	boolean create = false;

	try {
		p = pfind.findMaxOrderPosition(new Integer(doc));
		neworder = p.getOrder() + 1;
	} catch(Exception e) {
		neworder = 1;
	}

	while(en.hasMoreElements()) {
		card = (StorageCardAccessBean)en.nextElement();
		if(card.getClosed().booleanValue()) continue;
		String policy = card.getResource().getCountpolicy();
		create = false;
		if("S".equals(policy)) {
			try {
				Enumeration enu = pfind.findByDocumentQBE(new Integer(doc),"S",card.getSerialnumber(),Boolean.FALSE,new Integer(0),new Integer(0));
				if(!enu.hasMoreElements()) { create = true; }
			} catch(ObjectNotFoundException e) {
				create = true;
			}
		} else if("P".equals(policy)) {
			try {
				Enumeration enu = pfind.findByDocumentQBE(new Integer(doc),"P",card.getParty(),Boolean.FALSE,new Integer(0),new Integer(0));
				if(!enu.hasMoreElements()) { create = true; }
			} catch(Exception e) {
				create = true;
			}
		} else if("B".equals(policy)) {
			try {
				Enumeration enu = pfind.findByDocumentQBE(new Integer(doc),"B","",Boolean.TRUE,new Integer(card.getResource().getResource()),new Integer(0));
				if(!enu.hasMoreElements()) { create = true; }
			} catch(Exception e) {
				create = true;
			}
		}
		if(!create) continue;
		I13nActPositionAccessBean newpos = new I13nActPositionAccessBean(
			keyGen.getNextKey("tables.docpositions"),
			new Integer(card.getResource().getResource()),
			new Integer(owner),
			new Integer(doc),
			neworder++,
			card.getQty(),
			card.getPrice(),
			card.getBoxed(),
			card.getBoxed(),
			card.getBroken(),
			card.getBroken(),
			"N",
			Boolean.FALSE,
			Boolean.FALSE
		);
		if("S".equals(policy)) {
			newpos.setIsfictserial(card.getIsfictserial());
			if(card.getIsfictserial()) {
				newpos.setSerialnumber(null);
			} else {
				newpos.setSerialnumber(card.getSerialnumber());
			}
			newpos.setRealserial(null);
		} else {
			newpos.setIsfictserial(false);
			newpos.setSerialnumber(null);
			newpos.setRealserial(null);
		}
/*
		newpos.setIsfictserial(card.getIsfictserial());
		if(card.getIsfictserial()) {
			newpos.setSerialnumber(null);
			newpos.setRealserial(null);
		} else {
			newpos.setSerialnumber(card.getSerialnumber());
			newpos.setRealserial(null);
		}
*/
		newpos.setManufserial(card.getManufserial());
		newpos.setParty(card.getParty());
		newpos.setConfiguration(card.getConfiguration());
		if(card.getContract() != null) {
			card.getContract().refreshCopyHelper();
			newpos.setContract((Contract)card.getContract().getEJBRef());
		}
//		newpos.setOldplace(card.getPlace());
		newpos.setNewplace(card.getPlace());
		newpos.setNote(card.getNotes());
		newpos.setNotes(card.getNotes());
		newpos.setQty(card.getQty());
		newpos.commitCopyHelper();
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return null;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAgregatename() {
	return agregatename;
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
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
{
	return null;
}
public int getDoc() {
	return doc;
}
public java.lang.String getDocumentState() {
	return documentState;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
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
public java.lang.String getPositionname() {
	return positionname;
}
public int getState() {
	return com.hps.july.inventory.APPStates.INVFILLFDB;
}
/**
 * 
 * @return int
 */
public int getStorage() {
	return storage;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 17:53:26)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	// gets document and fillin data with it
	if(doc > 0) {
		I13nActAccessBean d = new I13nActAccessBean();
		d.setInitKey_document(doc);
		d.refreshCopyHelper();
		blanknumber = d.getBlanknumber();
		blankindex = d.getBlankindex();
		blankdate = d.getBlankdate();
		owner = d.getOwner().getOrganization();
		orgname = d.getOwner().getName();
		type = d.getType();
		documentState = d.getDocumentState();
		storage = d.getTo().getStorageplace();
		EquipmentSetAccessBean equ = new EquipmentSetAccessBean(d.getTo().getEJBRef());
		storagename = com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(equ);
		PositionAccessBean position = equ.getPosition();
		String positionid = "";
		if(position.getDampsid() != null) {
			positionid = positionid + "A" + position.getDampsid() + " ";
		}
		if(position.getGsmid() != null) {
			positionid = positionid + "D" + position.getGsmid() + " ";
		}
		positionname = positionid + position.getName();
		if("A".equals(type) && d.getAgregate() != null)
		{
			agregatename = 
				d.getAgregate().getResource().getName() + " " + 
				d.getAgregate().getResource().getModel();
			if(d.getAgregate().getConfiguration() != null) {
				agregatename += ", "+d.getAgregate().getConfiguration();
			}
			agregatename += "; S/N:"+d.getAgregate().getSerialnumber();
			agregate = d.getAgregate().getStoragecard();
		} else {
			agregatename = "";
			agregate = 0;
		}
	}
}
/**
 * 
 * @param newAgregatename java.lang.String
 */
public void setAgregatename(java.lang.String newAgregatename) {
	agregatename = newAgregatename;
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
public void setDoc(int newDoc) {
	doc = newDoc;
}
public void setDocumentState(java.lang.String newDocumentState) {
	documentState = newDocumentState;
}
/**
 * 
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
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
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * 
 * @param newStorage int
 */
public void setStorage(int newStorage) {
	storage = newStorage;
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
/**
 * 
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	//!!!\\ CHECK HERE FOR RIGHT storage, owner and so on 
	initRecord(null);

	Enumeration en;
	en = (new StorageCardAccessBean()).findStorageCardByQBE3(
		new Integer(storage),
		Boolean.FALSE, new Integer(0),
		("A".equals(type))?Boolean.TRUE:Boolean.FALSE,new Integer(agregate),
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE, "",
		Boolean.FALSE, "",
		Boolean.FALSE, new Integer(0),
		Boolean.FALSE, "",
		("A".equals(type))?Boolean.FALSE:Boolean.TRUE,
		new Integer(0),
		new Integer(doc),
		("A".equals(type))?Boolean.TRUE:Boolean.FALSE, new Integer(agregate),
		Boolean.FALSE, "",
		new Integer(1)
	);
	if(!en.hasMoreElements()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fillfromdb.norecordstocopy",storagename));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
