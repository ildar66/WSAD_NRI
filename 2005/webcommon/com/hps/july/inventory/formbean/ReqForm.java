package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;

/**
 * Форма ввода и редактирования шапки документа "Требование"
 */
public class ReqForm
	extends DocumentForm
{
	private StringAndIntegerProperty owner;
	private String ownername;

	private StringAndIntegerProperty division;
	private String divisionname;
	
	private StringAndIntegerProperty storage;
	private String storagename;

	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	
	private StringAndSqlDateProperty blankdate;
	
	private String type;
	
	private StringAndIntegerProperty organization;
	private String organizationname;

	private String insuranseMan;

	private String nAvto;

	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;
	
	private String dState;

	private StringAndIntegerProperty checker; 
	private String checkername;
	private String checkertitle;

	private StringAndIntegerProperty sender; 
	private String sendername;
	private String sendertitle;

	private StringAndIntegerProperty document;
	private StringAndIntegerProperty expedition;
	private Integer company;

	private Integer copydoc;
public ReqForm() {
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	document = new StringAndIntegerProperty();
	dState = "1";
	expedition = new StringAndIntegerProperty();
	insuranseMan = "";
	nAvto = "";
	division = new StringAndIntegerProperty();
	divisionname = "";
	position = new StringAndIntegerProperty();
	positionname = "";
	organization = new StringAndIntegerProperty();
	organizationname = "";	
	storage = new StringAndIntegerProperty();
	storagename = "";
	checker = new StringAndIntegerProperty();
	checkername = "";
	checkertitle = "";
	sender = new StringAndIntegerProperty();
	sendername = "";
	sendertitle = "";
	type = "P";
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";
	company = new Integer(1);
	owner = new StringAndIntegerProperty();
	ownername = "";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	if(copydoc != null) {
		// find Request document positions and copy it all.
		try {
			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			int poskey;

			Enumeration poss = (new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc(copydoc);

			while(poss.hasMoreElements()) {
				DocumentPositionAccessBean pos = (DocumentPositionAccessBean)poss.nextElement();
				poskey = keyGen.getNextKey("tables.docpositions");
				DocumentPositionAccessBean newpos = new DocumentPositionAccessBean(
					poskey,
					new Integer(pos.getResource().getResource()),
					new Integer(pos.getOwner().getOrganization()),
					document.getInteger(),
					pos.getOrder(),
					pos.getQty(),
					pos.getPrice(),
					pos.getSourceBoxed(),
					pos.getResultBoxed(),
					pos.getSourceBroken(),
					pos.getResultBroken(),
					pos.getSourceClosed(),
					pos.getResultClosed()
				);
				newpos.setConfiguration(pos.getConfiguration());
				newpos.commitCopyHelper();
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.reqpos.complectcreation");
		}
	}
	super.afterUpdate(bean,request); // Support for document calculation
	if("Add".equals(getAction())) {
		setAction("Edit");
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	RequestAccessBean ab = (RequestAccessBean)bean;
	ExpeditionAccessBean exp = null;

	try {
		exp = findExpedition();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		exp = constructExpedition();
	}
	
	ab.setFrom((Expedition)exp.getEJBRef());
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));

	// find owner by division
	RequestAccessBean bean = new RequestAccessBean(
		getDocument(),
		owner.getInteger(), // owner
		null, // from
		storage.getInteger(), // to
		blankdate.getSqlDate(),
		getBlankindex(),
		blanknumber,
		"1",
		Boolean.FALSE,
		Boolean.FALSE,
		division.getInteger()
	);
	return bean;
}
public WorkerAccessBean constructChecker() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(checker.getInteger().intValue());
	bean.refreshCopyHelper();
	setCheckername(bean.getMan().getFullName());
	setCheckertitle(bean.getPosition().getName());
	return bean;
}
public ExpeditionAccessBean constructExpedition() throws Exception {
	if(!"P".equals(type) && !"W".equals(type)) {
		throw new UpdateValidationException("error.invalid.internal.type");
	}
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	ExpeditionAccessBean exp = new ExpeditionAccessBean(
		keyGen.getNextKey("tables.storageplaces"), null, "", ""
	);
	if("P".equals(type)) {
		OrganizationAccessBean o = new OrganizationAccessBean();
		o.setInitKey_organization(organization.getInteger().intValue());
		o.refreshCopyHelper();
		exp.setOrganization((Organization)o.getEJBRef());
		exp.setExpeditor(null);
		exp.setName(o.getName());
	} else if("W".equals(type)) {
		WorkerAccessBean w = new WorkerAccessBean();
		w.setInitKey_worker(worker.getInteger().intValue());
		w.refreshCopyHelper();
		exp.setOrganization(null);
		exp.setExpeditor((Worker)w.getEJBRef());
		exp.setName(w.getMan().getLastname());
	}
	exp.commitCopyHelper();
	return exp;
}
public PositionAccessBean constructPosition() throws java.lang.Exception {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace(position.getInteger().intValue());
	bean.refreshCopyHelper();
	setPosition(bean);
	return bean;
}
public WorkerAccessBean constructSender() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(sender.getInteger().intValue());
	bean.refreshCopyHelper();
	setSendername(bean.getMan().getFullName());
	setSendertitle(bean.getPosition().getName());
	return bean;
}
public WorkerAccessBean constructWorker() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorkername(bean.getMan().getFullName());
	setWorkertitle(bean.getPosition().getName());
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	RequestAccessBean ab = (RequestAccessBean)bean;
	try {
		OrganizationAccessBean o = ab.getOwner();
		if(o != null) {
			owner.setInteger(new Integer(o.getOrganization()));
			ownername = o.getName();
		}
		DivisionAccessBean d = ab.getDivisionRequester();
		if(d != null) {
			division.setInteger(new Integer(d.getDivision()));
			divisionname = d.getName();
		}
		StoragePlaceAccessBean s = ab.getTo();
		if(s != null) {
			storage.setInteger(new Integer(s.getStorageplace()));
			storagename = s.getName();
		}
		// Expedition
		s = ab.getFrom();
		if(s != null) {
			try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(s.getStorageplace());
				exp.refreshCopyHelper();
				if(exp.getExpeditor() != null) {
					worker.setInteger(new Integer(exp.getExpeditor().getWorker()));
					workername = exp.getExpeditor().getMan().getFullName();
					workertitle = exp.getExpeditor().getPosition().getName();
					type = "W";
					setOrganizationcode("");
					setOrganizationname("");
				} else
				if(exp.getOrganization() != null) {
					organization.setInteger(new Integer(exp.getOrganization().getOrganization()));
					organizationname = exp.getOrganization().getName();
					type = "P";
					setWorkercode("");
					setWorkername("");
					setWorkertitle("");
				}
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
		WorkerAccessBean w = ab.getChecker();
		if(w != null) {
			checker.setInteger(new Integer(w.getWorker()));
			checkername = w.getMan().getFullName();
			checkertitle = w.getPosition().getName();
		}
		PositionAccessBean p = ab.getPosition();
		if(p != null) {
			setPosition(p);
		}

		// find link
		DocumentsLinkAccessBean dla = new DocumentsLinkAccessBean();
		Enumeration en = dla.findByTypeAndDocFrom("O",document.getInteger());
		if(en.hasMoreElements()) {
			DocumentsLinkAccessBean dl = (DocumentsLinkAccessBean)en.nextElement();
			// get sender
			if("2".equals(dl.getDocumentTo().getDocumentState())) {
				w = dl.getDocumentTo().getStorageManager();
				if(w != null) {
					sender.setInteger(new Integer(w.getWorker()));
					sendername = w.getMan().getFullName();
					sendertitle = w.getPosition().getName();
				}
			}
		}
	} catch(Exception e) {
	}
/*
	try {
		find InternalOutBill by Req
	} catch(Exception e) {
	}
*/
}
public ExpeditionAccessBean findExpedition() throws java.lang.Exception {
	ExpeditionAccessBean fexp = new ExpeditionAccessBean();
	Enumeration en;
	ExpeditionAccessBean exp;
	if("P".equals(type)) {
		en = fexp.findExpeditionByOrganization(new OrganizationKey(organization.getInteger().intValue()));
		if(en.hasMoreElements()) {
			ExpeditionAccessBean e = (ExpeditionAccessBean)en.nextElement();
			exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(e.getStorageplace());
			exp.refreshCopyHelper();
		} else {
			throw new Exception();
		}
	} else if("W".equals(type)) {
		en = fexp.findExpeditionByExpeditor(new WorkerKey(worker.getInteger().intValue()));
		if(en.hasMoreElements()) {
			ExpeditionAccessBean e = (ExpeditionAccessBean)en.nextElement();
			exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(e.getStorageplace());
			exp.refreshCopyHelper();
		} else {
			throw new Exception();
		}
	} else {
		throw new UpdateValidationException("error.invalid.internal.type");
	}
	if(en.hasMoreElements()) {
		throw new Exception("error.update.internal.expedition");
	}
	return exp;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
public String getBlankdatestr() {
	return blankdate.getString();
}
public int getBlankindex() {
	if(!blankindex.isEmpty() && blankindex.isOk())
		return blankindex.getInteger().intValue();
	else
		return 0;
}
public String getBlankindexFrm() {
	return blankindex.getString();
}
public String getBlanknumber() {
	return blanknumber;
}
public Worker getChecker() {
	try {
		return (Worker)constructChecker().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getCheckercode() {
	return checker.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCheckername() {
	return checkername;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCheckertitle() {
	return checkertitle;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getCompany() {
	return company;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getCopydoc() {
	return copydoc;
}
public Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	RequestAccessBean bean = new RequestAccessBean();
	bean.setInitKey_document(getDocument());
	return bean;
}
public java.lang.String getDivisioncode() {
	return division.getString();
}
public Integer getDivisionKey() {
	return division.getInteger();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDivisionname() {
	return divisionname;
}
public Division getDivisionRequester() {
	if(!division.isEmpty() && division.isOk()) {
		try {
			DivisionAccessBean bean = new DivisionAccessBean();
			bean.setInitKey_division(division.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Division)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public int getDocument() {
	if(document.getInteger() != null)
		return document.getInteger().intValue();
	else
		return 0;
}
public Integer getDocumentId() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
public java.lang.String getdState() {
	try{
		RequestAccessBean bean = new RequestAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
public java.lang.String getDState() {
	try{
		RequestAccessBean bean = new RequestAccessBean();
		bean.setInitKey_document(getDocument());
		bean.refreshCopyHelper();
		return bean.getDocumentState();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "1";
	}
}
public String getExpeditionstr() {
	return expedition.getString();
}
public java.lang.String getInsuranseMan() {
	return insuranseMan;
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listRequestItems(new Integer(getDocument()),new Integer(1));
	return rs.listIterator();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNAvto() {
	return nAvto;
}
public String getOrganizationcode() {
	return organization.getString();
}
public java.lang.String getOrganizationname() {
	return organizationname;
}
public Organization getOwner() {
	if(!owner.isEmpty() && owner.isOk()) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Organization)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public String getOwnercode() {
	return owner.getString();
}
public Integer getOwnerKey() {
	return owner.getInteger();
}
public java.lang.String getOwnername() {
	return ownername;
}
public Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
public Position getPosition() {
	try {
		return (Position)constructPosition().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getPositioncode() {
	return position.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 11:14:23)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
public Integer getPositionKey() {
	return position.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public Boolean getReadonly() {
	return new Boolean(!("1".equals(getDState()) && !getIsautodoc()));
}
public Integer getSender() {
	return sender.getInteger();
}
public String getSendercode() {
	return sender.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSendername() {
	return sendername;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSendertitle() {
	return sendertitle;
}
public Worker getSSender() {
	try {
		return (Worker)constructSender().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITREQ;
}
public String getStoragecode() {
	return storage.getString();
}
public Integer getStorageKey() {
	return storage.getInteger();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
public StoragePlace getTo() {
	if(!storage.isEmpty() && storage.isOk()) {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
			return (StoragePlace)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public java.lang.String getType() {
	return type;
}
public java.lang.String getWorkercode() {
	return worker.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	document = new StringAndIntegerProperty();
	dState = "1";
	expedition = new StringAndIntegerProperty();
	insuranseMan = "";
	nAvto = "";
	division = new StringAndIntegerProperty();
	divisionname = "";
	position = new StringAndIntegerProperty();
	positionname = "";
	organization = new StringAndIntegerProperty();
	organizationname = "";	
	storage = new StringAndIntegerProperty();
	storagename = "";
	checker = new StringAndIntegerProperty();
	checkername = "";
	checkertitle = "";
	sender = new StringAndIntegerProperty();
	sendername = "";
	sendertitle = "";
	type = "P";
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";
	company = new Integer(1);
	owner = new StringAndIntegerProperty();
	ownername = "";

	
	ReqListForm aform = (ReqListForm)request.getSession().getAttribute("ReqListForm");
	setDocumentstr("");
	if(aform.getDateto() != null) {
		setBlankdate(aform.getDateto());
	}

	if(Boolean.FALSE.equals(aform.getIsdivision())) {
		setDivisioncode(aform.getDivisioncode());
		setDivisionname(aform.getDivisionname());
	}

	if(aform.getIsposition() != null && !aform.getIsposition().booleanValue()) {
		setPositioncode(aform.getPositioncode());
		setPositionid(aform.getPositionid());
		setPositionname(aform.getPositionname());
	}
	
	if("P".equals(aform.getType())) {
		setOrganizationcode(aform.getOrganizationcode());
		setOrganizationname(aform.getOrganizationname());
		setWorkercode("");
		setWorkername("");
		setWorkertitle("");
		setType("P");
	} else
	if("W".equals(aform.getType())) {
		setOrganizationcode("");
		setOrganizationname("");
		setWorkercode(aform.getWorkercode());
		setWorkername(aform.getWorkername());
		setWorkertitle(aform.getWorkertitle());
		setType("W");
	}

	if(copydoc != null) {
		try {
			RequestAccessBean req = new RequestAccessBean();
			req.setInitKey_document(copydoc.intValue());
			req.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(this,req);
			fillRecord(req);
			setBlanknumber("");
			setBlankdate(new java.sql.Date((new java.util.Date()).getTime()));
		} catch(Exception e) {
			copydoc = null;
		}
	}
}
public void setBlankdate(java.sql.Date newDate) {
	blankdate.setSqlDate(newDate);
}
public void setBlankdatestr(String newBlankdate) {
	blankdate.setString(newBlankdate);
}
public void setBlankindex(int newBlankindex) {
	blankindex.setInteger(new Integer(newBlankindex));
}
public void setBlankindexFrm(String newBlankindex) {
	blankindex.setString(newBlankindex);
}
public void setBlanknumber(String newNumber) {
	blanknumber = newNumber;
}
public void setCheckercode(String newNumber) {
	checker.setString(newNumber);
}
/**
 * 
 * @param newCheckername java.lang.String
 */
public void setCheckername(java.lang.String newCheckername) {
	checkername = newCheckername;
}
/**
 * 
 * @param newCheckertitle java.lang.String
 */
public void setCheckertitle(java.lang.String newCheckertitle) {
	checkertitle = newCheckertitle;
}
/**
 * 
 * @param newCompany java.lang.Integer
 */
public void setCompany(java.lang.Integer newCompany) {
	company = newCompany;
}
/**
 * 
 * @param newCopydoc java.lang.Integer
 */
public void setCopydoc(java.lang.Integer newCopydoc) {
	copydoc = newCopydoc;
}
public void setDivisioncode(String newNumber) {
	division.setString(newNumber);
}
/**
 * 
 * @param newDivisionname java.lang.String
 */
public void setDivisionname(java.lang.String newDivisionname) {
	divisionname = newDivisionname;
}
public void setDocument(int newDocument) {
	document.setInteger(new Integer(newDocument));
}
public void setDocumentstr(String newDocument) {
	document.setString(newDocument);
}
public void setExpeditionstr(String newDocument) {
	expedition.setString(newDocument);
}
public void setInsuranseMan(java.lang.String newInsuranseMan) {
	insuranseMan = newInsuranseMan;
}
/**
 * 
 * @param newNAvto java.lang.String
 */
public void setNAvto(java.lang.String newNAvto) {
	nAvto = newNAvto;
}
public void setOrganizationcode(String newNumber) {
	organization.setString(newNumber);
}
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
public void setOwnercode(String newNumber) {
	owner.setString(newNumber);
}
public void setOwnername(java.lang.String newOrganizationname) {
	ownername = newOrganizationname;
}
public void setPosition(PositionAccessBean pos) {
	try {
		position.setInteger(new Integer(pos.getStorageplace()));
		positionname = pos.getName();
		positionid = "";
		if(pos.getGsmid() != null) {
			positionid = positionid + "D" + pos.getGsmid();
		}
		positionid = positionid + " ";
		if(pos.getDampsid() != null) {
			positionid = positionid + "A" + pos.getDampsid();
		}
	} catch(Exception e) {
		positionname = "";
		positionid = "";
	}
}
public void setPositioncode(String newPosition) {
	position.setString(newPosition);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 11:14:23)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
public void setSender(Integer newNumber) {
	sender.setInteger(newNumber);
}
/**
 * 
 * @param newSendername java.lang.String
 */
public void setSendername(java.lang.String newSendername) {
	sendername = newSendername;
}
/**
 * 
 * @param newSendertitle java.lang.String
 */
public void setSendertitle(java.lang.String newSendertitle) {
	sendertitle = newSendertitle;
}
public void setStoragecode(String newNumber) {
	storage.setString(newNumber);
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:21:05)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setWorkercode(java.lang.String newWorkercode) {
	worker.setString(newWorkercode);
}
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(document.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.document"));
		}
		else if(!document.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.document"));
		}
	}

	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.owner"));
	} else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.owner"));
	} else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.owner"));
		}
	}

	if(division.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.division"));
	}
	else if(!division.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.division"));
	}
	else {
		try {
			DivisionAccessBean bean = new DivisionAccessBean();
			bean.setInitKey_division(division.getInteger().intValue());
			bean.refreshCopyHelper();
			setDivisionname(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.division"));
		}
	}

	if(storage.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.storage"));
	}
	else if(!storage.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.storage"));
	}
	else {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.storage"));
		}
	}

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.blankdate"));
	}

	if(blanknumber.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} 

	if(blanknumber != null && !"".equals(blanknumber)) {
		if(blanknumber.length() > 40) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.blanknumber"));
		}
	} else {
		blanknumber = "";
	}
	if(blankindex.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} else if(!blankindex.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.invalid"));
	}

	if("P".equals(type)) {
		if(organization.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.organization"));
		}
		else if(!organization.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.organization"));
		}
		else {
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(organization.getInteger().intValue());
				bean.refreshCopyHelper();
				setOrganizationname(bean.getName());
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.renter"));
			}
		}
		if((insuranseMan == null) || ("".equals(insuranseMan))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.insuranceman"));
		}
	} else if("W".equals(type)) {
		if(worker.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.worker"));
		}
		else if(!worker.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.worker"));
		}
		else {
			try {
				constructWorker();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.worker"));
			}
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.type"));
	}
	
	if(!position.isEmpty()) {
		if(!position.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.position"));
		} else {
			try {
				PositionAccessBean bean = constructPosition();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.position"));
			}
		}
	}

	if(checker.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.checker"));
	}
	else if(!checker.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.cheker"));
	}
	else {
		try {
			constructChecker();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.checker"));
		}
	}

	/*
	if(sender.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.req.sender"));
	}
	else if(!sender.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.sender"));
	}
	else {
		try {
			constructSender();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.req.sender"));
		}
	}
	*/
	
	if(!"1".equals(dState) && !"2".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.req.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
