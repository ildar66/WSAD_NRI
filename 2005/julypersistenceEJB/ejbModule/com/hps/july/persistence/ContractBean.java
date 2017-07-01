package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Контракт на поставку оборудования
 */
public class ContractBean extends DocumentBean {
	public java.sql.Date finishDate;
	public String name;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.sql.Date startDate;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink baseAgreementLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink supplyTypeLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink cardsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink controllerLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink currencyLink = null;
	public java.lang.Integer baseAgreement_baseagreement;
	public java.lang.Integer controller_worker;
	public java.lang.Integer currency_currency;
	public java.math.BigDecimal sum;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink storageCardLink = null;
	public java.lang.Integer supplyType_supplyType;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink i13nActPositionLink = null;
	public java.lang.Integer worker_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink workerLink = null;
	public String contractState;
	public String textFileName;
	public String timelineFileName;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("timelineFileName", getTimelineFileName());
		h.put("currencyKey", getCurrencyKey());
		h.put("sum", getSum());
		h.put("startDate", getStartDate());
		h.put("textFileName", getTextFileName());
		h.put("baseAgreementKey", getBaseAgreementKey());
		h.put("workerKey", getWorkerKey());
		h.put("contractState", getContractState());
		h.put("controllerKey", getControllerKey());
		h.put("finishDate", getFinishDate());
		h.put("supplyTypeKey", getSupplyTypeKey());
		h.put("name", getName());
		h.put("blankindex", new Integer(getBlankindex()));
		h.put("parentdocument", getParentdocument());
		h.put("blanknumber", getBlanknumber());
		h.put("operator", getOperator());
		h.put("toKey", getToKey());
		h.put("processDestination", getProcessDestination());
		h.put("fromKey", getFromKey());
		h.put("showtouser", new Boolean(getShowtouser()));
		h.put("contragentKey", getContragentKey());
		h.put("storageManagerKey", getStorageManagerKey());
		h.put("document", new Integer(getDocument()));
		h.put("insuranceact", getInsuranceact());
		h.put("isautodoc", new Boolean(getIsautodoc()));
		h.put("blankdate", getBlankdate());
		h.put("documentState", getDocumentState());
		h.put("ownerKey", getOwnerKey());
		h.put("to2", getTo2());
		h.put("processSource", getProcessSource());
		h.put("insuranseMan", getInsuranseMan());
		h.put("insurancedate", getInsurancedate());
		h.put("needapprove", new Boolean(getNeedapprove()));
		h.put("projectid", getProjectid());
		h.put("prjstatus", getPrjstatus());
		h.put("visualtype", getVisualtype());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localTimelineFileName =
			(java.lang.String) h.get("timelineFileName");
		java.math.BigDecimal localSum = (java.math.BigDecimal) h.get("sum");
		java.sql.Date localStartDate = (java.sql.Date) h.get("startDate");
		java.lang.String localTextFileName =
			(java.lang.String) h.get("textFileName");
		java.lang.String localContractState =
			(java.lang.String) h.get("contractState");
		java.sql.Date localFinishDate = (java.sql.Date) h.get("finishDate");
		java.lang.String localName = (java.lang.String) h.get("name");
		Integer localBlankindex = (Integer) h.get("blankindex");
		java.lang.Integer localParentdocument =
			(java.lang.Integer) h.get("parentdocument");
		java.lang.String localBlanknumber =
			(java.lang.String) h.get("blanknumber");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.lang.Boolean localProcessDestination =
			(java.lang.Boolean) h.get("processDestination");
		Boolean localShowtouser = (Boolean) h.get("showtouser");
		Integer localDocument = (Integer) h.get("document");
		java.lang.String localInsuranceact =
			(java.lang.String) h.get("insuranceact");
		Boolean localIsautodoc = (Boolean) h.get("isautodoc");
		java.sql.Date localBlankdate = (java.sql.Date) h.get("blankdate");
		java.lang.String localDocumentState =
			(java.lang.String) h.get("documentState");
		java.lang.Integer localTo2 = (java.lang.Integer) h.get("to2");
		java.lang.Boolean localProcessSource =
			(java.lang.Boolean) h.get("processSource");
		java.lang.String localInsuranseMan =
			(java.lang.String) h.get("insuranseMan");
		java.sql.Date localInsurancedate =
			(java.sql.Date) h.get("insurancedate");
		Boolean localNeedapprove = (Boolean) h.get("needapprove");
		java.lang.Integer localProjectid =
			(java.lang.Integer) h.get("projectid");
		java.lang.String localPrjstatus = (java.lang.String) h.get("prjstatus");
		java.lang.Integer localVisualtype =
			(java.lang.Integer) h.get("visualtype");

		if (h.containsKey("timelineFileName"))
			setTimelineFileName((localTimelineFileName));
		if (h.containsKey("sum"))
			setSum((localSum));
		if (h.containsKey("startDate"))
			setStartDate((localStartDate));
		if (h.containsKey("textFileName"))
			setTextFileName((localTextFileName));
		if (h.containsKey("contractState"))
			setContractState((localContractState));
		if (h.containsKey("finishDate"))
			setFinishDate((localFinishDate));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("blankindex"))
			setBlankindex((localBlankindex).intValue());
		if (h.containsKey("parentdocument"))
			setParentdocument((localParentdocument));
		if (h.containsKey("blanknumber"))
			setBlanknumber((localBlanknumber));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("processDestination"))
			setProcessDestination((localProcessDestination));
		if (h.containsKey("showtouser"))
			setShowtouser((localShowtouser).booleanValue());
		if (h.containsKey("document"))
			setDocument((localDocument).intValue());
		if (h.containsKey("insuranceact"))
			setInsuranceact((localInsuranceact));
		if (h.containsKey("isautodoc"))
			setIsautodoc((localIsautodoc).booleanValue());
		if (h.containsKey("blankdate"))
			setBlankdate((localBlankdate));
		if (h.containsKey("documentState"))
			setDocumentState((localDocumentState));
		if (h.containsKey("to2"))
			setTo2((localTo2));
		if (h.containsKey("processSource"))
			setProcessSource((localProcessSource));
		if (h.containsKey("insuranseMan"))
			setInsuranseMan((localInsuranseMan));
		if (h.containsKey("insurancedate"))
			setInsurancedate((localInsurancedate));
		if (h.containsKey("needapprove"))
			setNeedapprove((localNeedapprove).booleanValue());
		if (h.containsKey("projectid"))
			setProjectid((localProjectid));
		if (h.containsKey("prjstatus"))
			setPrjstatus((localPrjstatus));
		if (h.containsKey("visualtype"))
			setVisualtype((localVisualtype));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getBaseAgreementLink());
	links.addElement(getCurrencyLink());
	links.addElement(getStorageCardLink());
	links.addElement(getSupplyTypeLink());
	links.addElement(getI13nActPositionLink());
	links.addElement(getControllerLink());
	links.addElement(getWorkerLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	baseAgreementLink = null;
	currencyLink = null;
	storageCardLink = null;
	supplyTypeLink = null;
	i13nActPositionLink = null;
	controllerLink = null;
	workerLink = null;
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCards(com.hps.july.persistence.StorageCard aCards) throws java.rmi.RemoteException {
	this.getCardsLink().addElement(aCards);
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addI13nActPosition(com.hps.july.persistence.I13nActPosition anI13nActPosition) throws java.rmi.RemoteException {
	this.getI13nActPositionLink().addElement(anI13nActPosition);
}
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
	this.getStorageCardLink().addElement(aStorageCard);
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Integer argCurrency, String argName, Integer argWorker, 
		Integer argController, java.sql.Date argStartDate, java.sql.Date argFinishDate, 
		java.math.BigDecimal argSum, Integer argSupplyType, Integer argBaseAgreement ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argBlankDate, argBlankindex, "1" );
	
	_initLinks();
	// All CMP fields should be initialized here.
	finishDate = null;
	name = null;
	startDate = null;
	baseAgreement_baseagreement = argBaseAgreement;
	controller_worker = null;
	currency_currency = null;
	sum = null;
	supplyType_supplyType = argSupplyType;
	worker_worker = null;
	contractState = null;
	textFileName = null;
	timelineFileName = null;

	currency_currency = argCurrency;
	name = argName;
	worker_worker = argWorker;
	controller_worker = argController;
	startDate = argStartDate;
	finishDate = argFinishDate;
	sum = PersistenceUtil.dec(argSum,2);
	contractState = argState;
	blanknumber = argBlankNumber;
}
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.BaseAgreement getBaseAgreement() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.BaseAgreement)this.getBaseAgreementLink().value();
}
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.BaseAgreementKey getBaseAgreementKey() {
	com.hps.july.persistence.BaseAgreementKey temp = null;
	temp = new com.hps.july.persistence.BaseAgreementKey();
	boolean baseAgreement_NULLTEST = true;
	baseAgreement_NULLTEST &= (baseAgreement_baseagreement == null);
	temp.baseagreement = ((baseAgreement_baseagreement == null) ? 0 : baseAgreement_baseagreement.intValue());
	if (baseAgreement_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getBaseAgreementLink() {
	if (baseAgreementLink == null)
		baseAgreementLink = new ContractToBaseAgreementLink(this);
	return baseAgreementLink;
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCards() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getCardsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getCardsLink() {
	if (cardsLink == null)
		cardsLink = new ContractToCardsLink(this);
	return cardsLink;
}
/**
 * Getter method for contractState
 */
public java.lang.String getContractState() {
	return contractState;
}
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getController() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getControllerLink().value();
}
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getControllerKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean controller_NULLTEST = true;
	controller_NULLTEST &= (controller_worker == null);
	temp.worker = ((controller_worker == null) ? 0 : controller_worker.intValue());
	if (controller_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getControllerLink() {
	if (controllerLink == null)
		controllerLink = new ContractToControllerLink(this);
	return controllerLink;
}
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getCurrencyLink().value();
}
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrencyKey() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean currency_NULLTEST = true;
	currency_NULLTEST &= (currency_currency == null);
	temp.currency = ((currency_currency == null) ? 0 : currency_currency.intValue());
	if (currency_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCurrencyLink() {
	if (currencyLink == null)
		currencyLink = new ContractToCurrencyLink(this);
	return currencyLink;
}
/**
 * Getter method for finishDate
 * @return java.sql.Date
 */
public java.sql.Date getFinishDate() {
	return finishDate;
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nActPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getI13nActPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getI13nActPositionLink() {
	if (i13nActPositionLink == null)
		i13nActPositionLink = new ContractToI13nActPositionLink(this);
	return i13nActPositionLink;
}
/**
 * Getter method for name
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Getter method for startDate
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getStorageCardLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getStorageCardLink() {
	if (storageCardLink == null)
		storageCardLink = new ContractToStorageCardLink(this);
	return storageCardLink;
}
/**
 * Getter method for sum
 */
public java.math.BigDecimal getSum() {
	return sum;
}
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SupplyType getSupplyType() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.SupplyType)this.getSupplyTypeLink().value();
}
/**
 * This method was generated for supporting the association named Contract2SupplyType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SupplyTypeKey getSupplyTypeKey() {
	com.hps.july.persistence.SupplyTypeKey temp = null;
	temp = new com.hps.july.persistence.SupplyTypeKey();
	boolean supplyType_NULLTEST = true;
	supplyType_NULLTEST &= (supplyType_supplyType == null);
	temp.supplyType = ((supplyType_supplyType == null) ? 0 : supplyType_supplyType.intValue());
	if (supplyType_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getSupplyTypeLink() {
	if (supplyTypeLink == null)
		supplyTypeLink = new ContractToSupplyTypeLink(this);
	return supplyTypeLink;
}
/**
 * Getter method for textFileName
 */
public java.lang.String getTextFileName() {
	return textFileName;
}
/**
 * Getter method for timelineFileName
 */
public java.lang.String getTimelineFileName() {
	return timelineFileName;
}
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getWorker() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getWorkerLink().value();
}
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getWorkerKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean worker_NULLTEST = true;
	worker_NULLTEST &= (worker_worker == null);
	temp.worker = ((worker_worker == null) ? 0 : worker_worker.intValue());
	if (worker_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getWorkerLink() {
	if (workerLink == null)
		workerLink = new ContractToWorkerLink(this);
	return workerLink;
}
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetBaseAgreementKey(com.hps.july.persistence.BaseAgreementKey inKey) {
	boolean baseAgreement_NULLTEST = (inKey == null);
	if (baseAgreement_NULLTEST) baseAgreement_baseagreement = null; else baseAgreement_baseagreement = (new Integer(inKey.baseagreement));
}
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetControllerKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean controller_NULLTEST = (inKey == null);
	if (controller_NULLTEST) controller_worker = null; else controller_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean currency_NULLTEST = (inKey == null);
	if (currency_NULLTEST) currency_currency = null; else currency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named Contract2SupplyType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSupplyTypeKey(com.hps.july.persistence.SupplyTypeKey inKey) {
	boolean supplyType_NULLTEST = (inKey == null);
	if (supplyType_NULLTEST) supplyType_supplyType = null; else supplyType_supplyType = (new Integer(inKey.supplyType));
}
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetWorkerKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean worker_NULLTEST = (inKey == null);
	if (worker_NULLTEST) worker_worker = null; else worker_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCards(com.hps.july.persistence.StorageCard aCards) {
	this.getCardsLink().secondaryAddElement(aCards);
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nActPosition(com.hps.july.persistence.I13nActPosition anI13nActPosition) {
	this.getI13nActPositionLink().secondaryAddElement(anI13nActPosition);
}
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryAddElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCards(com.hps.july.persistence.StorageCard aCards) {
	this.getCardsLink().secondaryRemoveElement(aCards);
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nActPosition(com.hps.july.persistence.I13nActPosition anI13nActPosition) {
	this.getI13nActPositionLink().secondaryRemoveElement(anI13nActPosition);
}
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryRemoveElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetBaseAgreement(com.hps.july.persistence.BaseAgreement aBaseAgreement) throws java.rmi.RemoteException {
	this.getBaseAgreementLink().secondarySet(aBaseAgreement);
}
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetController(com.hps.july.persistence.Worker aController) throws java.rmi.RemoteException {
	this.getControllerLink().secondarySet(aController);
}
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException {
	this.getCurrencyLink().secondarySet(aCurrency);
}
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSupplyType(com.hps.july.persistence.SupplyType aSupplyType) throws java.rmi.RemoteException {
	this.getSupplyTypeLink().secondarySet(aSupplyType);
}
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetWorker(com.hps.july.persistence.Worker aWorker) throws java.rmi.RemoteException {
	this.getWorkerLink().secondarySet(aWorker);
}
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setBaseAgreement(com.hps.july.persistence.BaseAgreement aBaseAgreement) throws java.rmi.RemoteException {
	this.getBaseAgreementLink().set(aBaseAgreement);
}
/**
 * Setter method for contractState
 */
public void setContractState(java.lang.String newValue) {
	this.contractState = newValue;
}
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setController(com.hps.july.persistence.Worker aController) throws java.rmi.RemoteException {
	this.getControllerLink().set(aController);
}
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException {
	this.getCurrencyLink().set(aCurrency);
}
/**
 * Setter method for finishDate
 * @param newValue java.sql.Date
 */
public void setFinishDate(java.sql.Date newValue) {
	this.finishDate = newValue;
}
/**
 * Setter method for name
 * @param newValue java.lang.String
 */
public void setName(java.lang.String newValue) {
	this.name = newValue;
}
/**
 * Setter method for startDate
 * @param newValue java.sql.Date
 */
public void setStartDate(java.sql.Date newValue) {
	this.startDate = newValue;
}
/**
 * Setter method for sum
 */
public void setSum(java.math.BigDecimal newValue) {
	this.sum = PersistenceUtil.dec(newValue,2);
}
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSupplyType(com.hps.july.persistence.SupplyType aSupplyType) throws java.rmi.RemoteException {
	this.getSupplyTypeLink().set(aSupplyType);
}
/**
 * Setter method for textFileName
 */
public void setTextFileName(java.lang.String newValue) {
	this.textFileName = newValue;
}
/**
 * Setter method for timelineFileName
 */
public void setTimelineFileName(java.lang.String newValue) {
	this.timelineFileName = newValue;
}
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setWorker(com.hps.july.persistence.Worker aWorker) throws java.rmi.RemoteException {
	this.getWorkerLink().set(aWorker);
}
}
