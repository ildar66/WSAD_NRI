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
 * Форма ввода и редактирования шапки документа "Внешний приходный ордер"
 */
public class ExternalForm
	extends DocumentForm
{
	private StringAndIntegerProperty owner;
	private String ownername;
	private StringAndIntegerProperty storage;
	private String storagename;
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private StringAndSqlDateProperty blankdate;
	private String cordocnum;
	private StringAndSqlDateProperty cordocdate;
	private String gtdnumber;
	private StringAndSqlDateProperty gtddate;
	private StringAndIntegerProperty supplier; // -> Organization
	private String suppliername;
	private String supplyCondition;
	private StringAndIntegerProperty contract; // -> Contract
//	private String contractnum;
	private String contractname;
	private StringAndIntegerProperty currency; // -> Currency
	private String currencyname;
	private String dState; // values: '1','2' 
	private StringAndIntegerProperty fromw; // -> Worker
	private String fromwname;
	private String fromwtitle;
	private StringAndIntegerProperty fromo;
	private String fromoname;
	private StringAndIntegerProperty worker; // -> Worker
	private String workername;
	private String workertitle;

	private StringAndIntegerProperty document;
	private StringAndIntegerProperty expedition;

	private Integer linkkey;

	private String insuranseMan;
	private String fromtype;
	private String representtype;
public ExternalForm() {
	owner = new StringAndIntegerProperty();
	ownername = "";
	storage = new StringAndIntegerProperty();
	storagename = "";
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	cordocnum = "";
	cordocdate = new StringAndSqlDateProperty();
	gtdnumber = "";
	gtddate = new StringAndSqlDateProperty();
	supplier = new StringAndIntegerProperty();
	suppliername = "";
	supplyCondition = "P";
	contract = new StringAndIntegerProperty();
	contractname = "";
	currency = new StringAndIntegerProperty();
	currencyname = "";
	dState = "1";
	fromw = new StringAndIntegerProperty();
	fromwname = "";
	fromwtitle = "";
	fromo = new StringAndIntegerProperty();
	fromoname = "";
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";

	document = new StringAndIntegerProperty();
	expedition = new StringAndIntegerProperty();
	fromtype = "W"; // W - man, I - insuranseMan
	representtype = "R";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	// add DocumentLinks ( from = contract, to = document, type = 'I' )
	if(!contract.isEmpty()) {
		DocumentsLinkAccessBean docl = new DocumentsLinkAccessBean();
		Enumeration links = docl.findByTypeAndDocTo("I",document.getInteger());
		while(links.hasMoreElements()) {
			DocumentsLinkAccessBean link = (DocumentsLinkAccessBean)links.nextElement();
			link.refreshCopyHelper();
			link.getEJBRef().remove();
		}
		// now create new link
		DocumentsLinkAccessBean nlink = new DocumentsLinkAccessBean("I",contract.getInteger(),document.getInteger());
		nlink.commitCopyHelper();
		/*
		if(links.hasMoreElements()) {
			DocumentsLinkAccessBean link = (DocumentsLinkAccessBean)links.nextElement();
			if(links.hasMoreElements()) {
				throw new UpdateValidationException("error.update.external.documentslink");
			}
			link.setDocumentfrom_document(contract.getInteger());
			link.commitCopyHelper();
		} else {
			docl = new DocumentsLinkAccessBean("I",contract.getInteger(),document.getInteger());
			docl.commitCopyHelper();
		}
		*/
	} else {
		// Remove contract
	}

//System.out.println("Check process state ");
	super.afterUpdate(bean,request); // Support for document calculation
	if("Add".equals(getAction())) {
		setAction("Edit");
	}
}
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception 
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
		
		Enumeration eo = getDocumentPositions();
		while(eo.hasMoreElements()) {
			OuterDocPositionAccessBean odp = (OuterDocPositionAccessBean)eo.nextElement();
			odp.refreshCopyHelper();
			Enumeration es = //odp.getInWayBillPosition();
				(new InWayBillPositionAccessBean()).findInWayBillPositionByOuterDocPosition((OuterDocPositionKey)odp.__getKey());
			while(es.hasMoreElements()) {
				InWayBillPositionAccessBean s = (InWayBillPositionAccessBean)es.nextElement();
				s.refreshCopyHelper();
				s.getEJBRef().remove();
			}
			odp.getEJBRef().remove();
		}
	} catch(NullPointerException npe) {
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	super.beforeUpdate(bean,request);
	InwayBillAccessBean ab = (InwayBillAccessBean)bean;
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	if("W".equals(representtype)) {
		ab.setRepresentative(getRepresentative());
	} else if("R".equals(representtype)) {
		ab.setInsuranseMan(getInsuranseMan());
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));
	InwayBillAccessBean bean = new InwayBillAccessBean(
		getDocument(),
		owner.getInteger(),
		null, // will be set in beforeUpdate() method on "Add" action
		storage.getInteger(),
		blankdate.getSqlDate(),
		getBlankindex(),
		blanknumber,
		dState,
		Boolean.FALSE,
		Boolean.TRUE,
		currency.getInteger()
	);
	return bean;
}
public WorkerAccessBean constructRepresentative() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(fromw.getInteger().intValue());
	bean.refreshCopyHelper();
	setFromwname(bean.getMan().getFullName());
	setFromwtitle(bean.getPosition().getName());
	return bean;
}
public WorkerAccessBean constructStorageManager() throws java.lang.Exception {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker(worker.getInteger().intValue());
	bean.refreshCopyHelper();
	setWorkername(bean.getMan().getFullName());
	setWorkertitle(bean.getPosition().getName());
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	InwayBillAccessBean ab = (InwayBillAccessBean)bean;
	try {
		OrganizationAccessBean o = ab.getContragent();
		if(o != null) {
			supplier.setInteger(new Integer(o.getOrganization()));
			suppliername = o.getName();
		}
		CurrencyAccessBean c = ab.getCurrency();
		if(c != null) {
			currency.setInteger(new Integer(c.getCurrency()));
			currencyname = c.getShortname();
		}
		o = ab.getOwner();
		if(o != null) {
			owner.setInteger(new Integer(o.getOrganization()));
			ownername = o.getName();
		}
		StoragePlaceAccessBean s = ab.getTo();
		if(s != null) {
			storage.setInteger(new Integer(s.getStorageplace()));
			storagename = s.getName();
		}
		try {
			// find DocumentsLink
			DocumentsLinkAccessBean dlink = new DocumentsLinkAccessBean();
			Enumeration en = dlink.findByTypeAndDocTo("I",document.getInteger());
			ContractAccessBean cont = null;
			if(en.hasMoreElements()) {
				cont = new ContractAccessBean();
				cont.setInitKey_document(((DocumentsLinkAccessBean)en.nextElement()).getDocumentfromKey().document);
				cont.refreshCopyHelper();
			}
			if(cont != null) {
				contract.setInteger(new Integer(cont.getDocument()));
				contractname = cont.getName() + ((cont.getBlanknumber() != null)?(" "+cont.getBlanknumber()):"");
			}
		} catch(Exception e) {
			contractname = "";
		}
		WorkerAccessBean w = ab.getStorageManager();
		if(w != null) {
			worker.setInteger(new Integer(w.getWorker()));
			workername = w.getMan().getFullName();
			workertitle = w.getPosition().getName();
		}
		setRepresenttype(ab.getRepresenttype());
		if("W".equals(getRepresenttype())) {
			w = ab.getRepresentative();
			if(w != null) {
				fromw.setInteger(new Integer(w.getWorker()));
				fromwname = w.getMan().getFullName();
				fromwtitle = w.getPosition().getName();
			}
		} else if("R".equals(getRepresenttype())) {
			insuranseMan = ab.getInsuranseMan();
		}
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 11:01:42)
 * @return java.sql.Date
 */
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
public String getContractcode() {
	return contract.getString();
}
public String getContractname() {
	return contractname;
}
public java.lang.String getContractnum() {
	return ""; //contractnum;
}
public Organization getContragent() {
	if(!supplier.isEmpty() && supplier.isOk()) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(supplier.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Organization)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 11:01:42)
 * @return java.sql.Date
 */
public java.sql.Date getCordocdate() {
	return (cordocnum != null && !"".equals(cordocnum))?cordocdate.getSqlDate():null;
}
public String getCordocdatestr() {
	return cordocdate.getString();
}
public String getCordocnum() {
	return cordocnum;
}
public Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public Currency getCurrency() {
	if(!currency.isEmpty() && currency.isOk()) {
		try {
			CurrencyAccessBean bean = new CurrencyAccessBean();
			bean.setInitKey_currency(currency.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Currency)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public String getCurrencycode() {
	return currency.getString();
}
public String getCurrencyname() {
	return currencyname;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	InwayBillAccessBean bean = new InwayBillAccessBean();
	bean.setInitKey_document(getDocument());
	return bean;
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
public Enumeration getDocumentPositions()
	throws Exception
{
	OuterDocPositionAccessBean fo = new OuterDocPositionAccessBean();
	return fo.findOuterDocPositionByInWayBill(new DocumentKey(getDocumentId().intValue()));
}
public String getDocumentstr() {
	return document.getString();
}
public java.lang.String getdState() {
	try{
		InwayBillAccessBean bean = new InwayBillAccessBean();
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
		InwayBillAccessBean bean = new InwayBillAccessBean();
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
public String getFromocode() {
	return fromo.getString();
}
public String getFromoname() {
	return fromoname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 11:02:34)
 * @return java.lang.String
 */
public java.lang.String getFromtype() {
	return fromtype;
}
public String getFromwcode() {
	return fromw.getString();
}
public String getFromwname() {
	return fromwname;
}
public String getFromwtitle() {
	return fromwtitle;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 11:01:42)
 * @return java.sql.Date
 */
public java.sql.Date getGtddate() {
	return (gtdnumber != null && !"".equals(gtdnumber))?gtddate.getSqlDate():null;
}
public String getGtddatestr() {
	return gtddate.getString();
}
public String getGtdnumber() {
	return gtdnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 10:29:04)
 * @return java.lang.String
 */
public java.lang.String getInsuranseMan() {
	return insuranseMan;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getLinkkey() {
	return linkkey;
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listExternalStorageInItems(getDocumentId(),new Integer(1));
	return rs.listIterator();
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
public String getOwnername() {
	return owner.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 11:40:25)
 * @return java.util.Enumeration
 */
public Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
public Worker getRepresentative() {
	try {
		return (Worker)constructRepresentative().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 10:56:26)
 * @return java.lang.String
 */
public java.lang.String getRepresenttype() {
	return representtype;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEO;
}
public String getStoragecode() {
	return storage.getString();
}
public Integer getStorageKey() {
	return storage.getInteger();
}
public Worker getStorageManager() {
	try {
		return (Worker)constructStorageManager().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getStoragename() {
	return storagename;
}
public String getSuppliercode() {
	return supplier.getString();
}
public String getSuppliername() {
	return suppliername;
}
public java.lang.String getSupplyCondition() {
	return supplyCondition;
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
public String getWorkercode() {
	return worker.getString();
}
public String getWorkername() {
	return workername;
}
public String getWorkertitle() {
	return workertitle;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	document.setInteger(null);
	owner.setInteger(null); ownername = "";
	storage.setInteger(null); storagename = "";
	blanknumber = ""; blankindex.setInteger(null);
	blankdate.setSqlDate(null);	cordocnum = "";
	cordocdate.setSqlDate(null); gtdnumber = ""; gtddate.setSqlDate(null);
	supplier.setInteger(null); suppliername = ""; 
	supplyCondition = "P";
	contract.setInteger(null); contractname = "";
	currency.setInteger(null);
	currencyname = "";
	dState = "1";
	fromw.setInteger(null);
	fromwname = "";
	fromwtitle = "";
	fromo.setInteger(null);
	fromoname = "";
	worker.setInteger(null); // -> Worker
	workername = "";
	workertitle = "";

	document.setInteger(null);
	expedition.setInteger(null);

	linkkey = null;

	insuranseMan = "";
	fromtype = "W";
	representtype = "R";
	
	ExternalListForm aform = (ExternalListForm)request.getSession().getAttribute("ExternalListForm");
	if(Boolean.FALSE.equals(aform.getIsowner())) {
		setOwnercode(aform.getOwnercode());
		setOwnername(aform.getOwnername());
	}
	if(Boolean.FALSE.equals(aform.getIssupplier())) {
		setSuppliercode(aform.getSuppliercode());
		setSuppliername(aform.getSuppliername());
	}
	setStoragecode(aform.getStoragecode());
	storagename = aform.getStoragename();
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
public void setContractcode(String newNumber) {
	contract.setString(newNumber);
}
public void setContractname(String newName) {
	contractname = newName;
}
public void setContractnum(java.lang.String newContractnum) {
//	contractnum = newContractnum;
}
public void setCordocdate(java.sql.Date newDate) {
	cordocdate.setSqlDate(newDate);
}
public void setCordocdatestr(String newDate) {
	cordocdate.setString(newDate);
}
public void setCordocnum(String newNumber) {
	cordocnum = newNumber;
}
public void setCurrencycode(String newNumber) {
	currency.setString(newNumber);
}
public void setCurrencyname(String newName) {
	currencyname = newName;
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
public void setFromocode(String newNumber) {
	fromo.setString(newNumber);
}
public void setFromoname(String newName) {
	fromoname = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 11:02:34)
 * @param newFromtype java.lang.String
 */
public void setFromtype(java.lang.String newFromtype) {
	fromtype = newFromtype;
}
public void setFromwcode(String newNumber) {
	fromw.setString(newNumber);
}
public void setFromwname(String newName) {
	fromwname = newName;
}
public void setFromwtitle(String newTitle) {
	fromwtitle = newTitle;
}
public void setGtddate(java.sql.Date newDate) {
	gtddate.setSqlDate(newDate);
}
public void setGtddatestr(String newDate) {
	gtddate.setString(newDate);
}
public void setGtdnumber(String newNumber) {
	gtdnumber = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2003 10:29:04)
 * @param newInsuranseMan java.lang.String
 */
public void setInsuranseMan(java.lang.String newInsuranseMan) {
	insuranseMan = newInsuranseMan;
}
/**
 * 
 * @param newLinkkey java.lang.Integer
 */
public void setLinkkey(java.lang.Integer newLinkkey) {
	linkkey = newLinkkey;
}
public void setOwnercode(String newNumber) {
	owner.setString(newNumber);
}
public void setOwnername(String newName) {
	ownername = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 10:56:26)
 * @param newRepresenttype java.lang.String
 */
public void setRepresenttype(java.lang.String newRepresenttype) {
	representtype = newRepresenttype;
}
public void setStoragecode(String newNumber) {
	storage.setString(newNumber);
}
public void setSuppliercode(String newNumber) {
	supplier.setString(newNumber);
}
public void setSuppliername(String newName) {
	suppliername = newName;
}
public void setSupplyCondition(java.lang.String newSupplyCondition) {
	supplyCondition = newSupplyCondition;
}
public void setWorkercode(String newNumber) {
	worker.setString(newNumber);
}
public void setWorkername(String newName) {
	workername = newName;
}
public void setWorkertitle(String newTitle) {
	workertitle = newTitle;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if("Edit".equals(getAction()) || "Delete".equals(getAction())) {
		if(document.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.document"));
		}
		else if(!document.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.document"));
		}
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

	if(blanknumber.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} 

	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.blankdate"));
	}

	if(cordocnum != null && (cordocnum.length() > 20)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.cordocnum"));
	}

	if(gtdnumber != null && (gtdnumber.length() > 20)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.gtdnumber"));
	}

	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.owner"));
	}
	else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.owner"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.external.owner"));
		}
	}

	if(storage.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.storage"));
	}
	else if(!storage.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.storage"));
	}
	else {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
			storagename = bean.getName();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.external.storage"));
		}
	}

	if(supplier.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.supplier"));
	}
	else if(!supplier.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.supplier"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(supplier.getInteger().intValue());
			bean.refreshCopyHelper();
			setSuppliername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.external.supplier"));
		}
	}

	if(!"P".equals(supplyCondition) && !"T".equals(supplyCondition)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.supplycond"));
	}

	if(!contract.isEmpty()) {
		if(!contract.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.contract"));
		} else {
			try {
				ContractAccessBean bean = new ContractAccessBean();
				bean.setInitKey_document(contract.getInteger().intValue());
				bean.refreshCopyHelper();
				contractname = bean.getName() + ((bean.getBlanknumber() != null)?(" "+bean.getBlanknumber()):"");
				if(bean.getCurrency().getCurrency() != currency.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.contract.currency"));
				}
				if(bean.getContragent().getOrganization() != supplier.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.contract.supplier"));
				}
				if(bean.getOwner().getOrganization() != owner.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.contract.owner"));
				}
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.external.contract"));
			}
		}
	}

	if(currency.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.currency"));
	}
	else if(!currency.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.currency"));
	}
	else {
		try {
			CurrencyAccessBean bean = new CurrencyAccessBean();
			bean.setInitKey_currency(currency.getInteger().intValue());
			bean.refreshCopyHelper();
			setCurrencyname(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.external.currency"));
		}
	}

	if("W".equals(getRepresenttype())) {
		if(fromw.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.from"));
		} else if(!fromw.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.from"));
		} else {
			try {
				constructRepresentative();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.external.from"));
			}
		}
	} else if("R".equals(getRepresenttype())) {
		if(insuranseMan == null || "".equals(insuranseMan)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.insuranseman"));
		} else if(insuranseMan.length() > 80) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.insuranseman"));
		}
	} else {
		//System.out.println("*#* RepresentType: "+representtype);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.representtype"));
	}

	if(worker.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.external.worker"));
	}
	else if(!fromw.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.worker"));
	}
	else {
		try {
			constructStorageManager();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.external.worker"));
		}
	}

	if(!"1".equals(dState) && !"2".equals(dState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.external.state"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
