package com.hps.july.persistence;

import java.rmi.RemoteException;
//import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Организация
 */
public class OrganizationBean implements EntityBean {
	public String accauntmanagerinfo;
	public String directorinfo;
	private javax.ejb.EntityContext entityContext = null;
	public String fax;
	public String inn;
	public Boolean isprovider;
	public Boolean isrenter;
	public Boolean issupplier;
	public String legaladdress;
	public String name;
	public String okonh;
	public String okpo;
	public int organization;
	public String phisicaladdress;
	public String phone;
	private final static long serialVersionUID = 3206093459760846163L;
	public String shortname;
	public java.lang.Integer company_company;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink companyLink = null;
	public Boolean bank;
	public String swift;
	public String koraccount;
	public String bik;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink accountLink = null;
	public String organizationType;
	public String bossPosition;
	public String zip;
	public String contactList;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink documentPositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink storageCardLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink expeditionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink contragentDocumentLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink contagentDocumentLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink ownedDocumentLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink renteePositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink searchesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leasePayRule4orgtopayLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink projectsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink pIEMxranPlatinumsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink vcprojectsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink positionResponsibleWorkerLink = null;
	public String kpp;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink workersLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink carsLink = null;
	/**
	 * Implementation field for persistent attribute: ischannalrenter
	 */
	public java.lang.Boolean ischannalrenter;
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = new java.util.Vector();
		links.add(getExpeditionLink());
		links.add(getOwnedDocumentLink());
		links.add(getAccountLink());
		links.add(getContagentDocumentLink());
		links.add(getWorkersLink());
		links.add(getDocumentPositionLink());
		links.add(getProjectsLink());
		links.add(getRenteePositionLink());
		links.add(getSearchesLink());
		links.add(getPositionResponsibleWorkerLink());
		links.add(getCarsLink());
		links.add(getLeasePayRule4orgtopayLink());
		links.add(getVcprojectsLink());
		links.add(getCompanyLink());
		links.add(getPIEMxranPlatinumsLink());
		links.add(getStorageCardLink());
		return links;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _initLinks() {
		expeditionLink = null;
		ownedDocumentLink = null;
		accountLink = null;
		contagentDocumentLink = null;
		workersLink = null;
		documentPositionLink = null;
		projectsLink = null;
		renteePositionLink = null;
		searchesLink = null;
		positionResponsibleWorkerLink = null;
		carsLink = null;
		leasePayRule4orgtopayLink = null;
		vcprojectsLink = null;
		companyLink = null;
		pIEMxranPlatinumsLink = null;
		storageCardLink = null;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _removeLinks()
		throws java.rmi.RemoteException, javax.ejb.RemoveException {
		java.util.List links = _getLinks();
		for (int i = 0; i < links.size(); i++) {
			try {
				((com.ibm.ivj.ejb.associations.interfaces.Link) links.get(i))
					.remove();
			} catch (javax.ejb.FinderException e) {
			} //Consume Finder error since I am going away
		}
	}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAccount(com.hps.july.persistence.Account anAccount) throws java.rmi.RemoteException {
	this.getAccountLink().addElement(anAccount);
}
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException {
	this.getCarsLink().addElement(aCars);
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addContagentDocument(com.hps.july.persistence.Document aContagentDocument) throws java.rmi.RemoteException {
	this.getContagentDocumentLink().addElement(aContagentDocument);
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addContragentDocument(com.hps.july.persistence.Document aContragentDocument) throws java.rmi.RemoteException {
	this.getContragentDocumentLink().addElement(aContragentDocument);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
	this.getDocumentPositionLink().addElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addExpedition(com.hps.july.persistence.Expedition anExpedition) throws java.rmi.RemoteException {
	this.getExpeditionLink().addElement(anExpedition);
}
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeasePayRule4orgtopay(com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay) throws java.rmi.RemoteException {
	this.getLeasePayRule4orgtopayLink().addElement(aLeasePayRule4orgtopay);
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addOwnedDocument(com.hps.july.persistence.Document anOwnedDocument) throws java.rmi.RemoteException {
	this.getOwnedDocumentLink().addElement(anOwnedDocument);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) throws java.rmi.RemoteException {
	this.getPositionResponsibleWorkerLink().addElement(aPositionResponsibleWorker);
}
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException {
	this.getProjectsLink().addElement(aProjects);
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addRenteePosition(com.hps.july.persistence.Position aRenteePosition) throws java.rmi.RemoteException {
	this.getRenteePositionLink().addElement(aRenteePosition);
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
	this.getStorageCardLink().addElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addVcprojects(com.hps.july.persistence.Project aVcprojects) throws java.rmi.RemoteException {
	this.getVcprojectsLink().addElement(aVcprojects);
}
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException {
	this.getWorkersLink().addElement(aWorkers);
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argOrganization int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argOrganization) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	organization = argOrganization;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argOrganization int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argOrganization, String argName, Boolean argIsSupplier, Boolean argIsProvider, 
	Boolean argIsRenter, Boolean argBank ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	accauntmanagerinfo = null;
	directorinfo = null;
	fax = null;
	inn = null;
	isprovider = null;
	isrenter = null;
	issupplier = null;
	legaladdress = null;
	name = null;
	okonh = null;
	okpo = null;
	organization = 0;
	phisicaladdress = null;
	phone = null;
	shortname = null;
	company_company = null;
	bank = null;
	swift = null;
	koraccount = null;
	bik = null;
	organizationType = null;
	bossPosition = null;
	zip = null;
	contactList = null;

	organization = argOrganization;
	name = argName;
	issupplier = argIsSupplier;
	isprovider = argIsProvider;
	isrenter = argIsRenter;
	ischannalrenter = Boolean.FALSE;
	bank = argBank;
	kpp = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argOrganization int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argOrganization, String argName, Boolean argIsSupplier, Boolean argIsProvider, 
	Boolean argIsRenter, Boolean argIsChannalRenter, Boolean argBank ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	accauntmanagerinfo = null;
	directorinfo = null;
	fax = null;
	inn = null;
	isprovider = null;
	isrenter = null;
	issupplier = null;
	legaladdress = null;
	name = null;
	okonh = null;
	okpo = null;
	organization = 0;
	phisicaladdress = null;
	phone = null;
	shortname = null;
	company_company = null;
	bank = null;
	swift = null;
	koraccount = null;
	bik = null;
	organizationType = null;
	bossPosition = null;
	zip = null;
	contactList = null;

	organization = argOrganization;
	name = argName;
	issupplier = argIsSupplier;
	isprovider = argIsProvider;
	isrenter = argIsRenter;
	ischannalrenter = argIsChannalRenter;
	bank = argBank;
	kpp = null;
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argOrganization int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argOrganization) throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	//_removeLinks();
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {}
/**
 * Getter method for accauntmanagerinfo
 * @return java.lang.String
 */
public java.lang.String getAccauntmanagerinfo() {
	return accauntmanagerinfo;
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAccount() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAccountLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAccountLink() {
	if (accountLink == null)
		accountLink = new OrganizationToAccountLink(this);
	return accountLink;
}
/**
 * Getter method for bank
 */
public java.lang.Boolean getBank() {
	return bank;
}
/**
 * Getter method for bik
 */
public java.lang.String getBik() {
	return bik;
}
/**
 * Getter method for bossPosition
 */
public java.lang.String getBossPosition() {
	return bossPosition;
}
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCars() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getCarsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getCarsLink() {
	if (carsLink == null)
		carsLink = new OrganizationToCarsLink(this);
	return carsLink;
}
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Company getCompany() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Company)this.getCompanyLink().value();
}
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CompanyKey getCompanyKey() {
	com.hps.july.persistence.CompanyKey temp = null;
	temp = new com.hps.july.persistence.CompanyKey();
	boolean company_NULLTEST = true;
	company_NULLTEST &= (company_company == null);
	temp.company = ((company_company == null) ? 0 : company_company.intValue());
	if (company_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCompanyLink() {
	if (companyLink == null)
		companyLink = new OrganizationToCompanyLink(this);
	return companyLink;
}
/**
 * Getter method for contactList
 */
public java.lang.String getContactList() {
	return contactList;
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getContagentDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getContagentDocumentLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getContagentDocumentLink() {
	if (contagentDocumentLink == null)
		contagentDocumentLink = new OrganizationToContagentDocumentLink(this);
	return contagentDocumentLink;
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getContragentDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getContragentDocumentLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getContragentDocumentLink() {
	if (contragentDocumentLink == null)
		contragentDocumentLink = new OrganizationToContragentDocumentLink(this);
	return contragentDocumentLink;
}
/**
 * Getter method for directorinfo
 * @return java.lang.String
 */
public java.lang.String getDirectorinfo() {
	return directorinfo;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getDocumentPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getDocumentPositionLink() {
	if (documentPositionLink == null)
		documentPositionLink = new OrganizationToDocumentPositionLink(this);
	return documentPositionLink;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getExpedition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getExpeditionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getExpeditionLink() {
	if (expeditionLink == null)
		expeditionLink = new OrganizationToExpeditionLink(this);
	return expeditionLink;
}
/**
 * Getter method for fax
 * @return java.lang.String
 */
public java.lang.String getFax() {
	return fax;
}
/**
 * Getter method for inn
 * @return java.lang.String
 */
public java.lang.String getInn() {
	return inn;
}
/**
 * Getter method for isprovider
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsprovider() {
	return isprovider;
}
/**
 * Getter method for isrenter
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsrenter() {
	return isrenter;
}
/**
 * Getter method for issupplier
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIssupplier() {
	return issupplier;
}
/**
 * Getter method for koraccount
 */
public java.lang.String getKoraccount() {
	return koraccount;
}
/**
 * Getter method for kpp
 */
public java.lang.String getKpp() {
	return kpp;
}
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeasePayRule4orgtopay() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeasePayRule4orgtopayLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeasePayRule4orgtopayLink() {
	if (leasePayRule4orgtopayLink == null)
		leasePayRule4orgtopayLink = new OrganizationToLeasePayRule4orgtopayLink(this);
	return leasePayRule4orgtopayLink;
}
/**
 * Getter method for legaladdress
 * @return java.lang.String
 */
public java.lang.String getLegaladdress() {
	return legaladdress;
}
/**
 * Getter method for name
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Getter method for okonh
 * @return java.lang.String
 */
public java.lang.String getOkonh() {
	return okonh;
}
/**
 * Getter method for okpo
 * @return java.lang.String
 */
public java.lang.String getOkpo() {
	return okpo;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2002 20:25:21)
 * @return int
 */
public int getOrganization() {
	return organization;
}
/**
 * Getter method for organizationType
 */
public java.lang.String getOrganizationType() {
	return organizationType;
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOwnedDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getOwnedDocumentLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getOwnedDocumentLink() {
	if (ownedDocumentLink == null)
		ownedDocumentLink = new OrganizationToOwnedDocumentLink(this);
	return ownedDocumentLink;
}
/**
 * Getter method for phisicaladdress
 * @return java.lang.String
 */
public java.lang.String getPhisicaladdress() {
	return phisicaladdress;
}
/**
 * Getter method for phone
 * @return java.lang.String
 */
public java.lang.String getPhone() {
	return phone;
}
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEMxranPlatinums() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPIEMxranPlatinumsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPIEMxranPlatinumsLink() {
	if (pIEMxranPlatinumsLink == null)
		pIEMxranPlatinumsLink = new OrganizationToPIEMxranPlatinumsLink(this);
	return pIEMxranPlatinumsLink;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPositionResponsibleWorker() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getPositionResponsibleWorkerLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getPositionResponsibleWorkerLink() {
	if (positionResponsibleWorkerLink == null)
		positionResponsibleWorkerLink = new OrganizationToPositionResponsibleWorkerLink(this);
	return positionResponsibleWorkerLink;
}
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getProjects() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getProjectsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getProjectsLink() {
	if (projectsLink == null)
		projectsLink = new OrganizationToProjectsLink(this);
	return projectsLink;
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRenteePosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getRenteePositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getRenteePositionLink() {
	if (renteePositionLink == null)
		renteePositionLink = new OrganizationToRenteePositionLink(this);
	return renteePositionLink;
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSearches() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getSearchesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getSearchesLink() {
	if (searchesLink == null)
		searchesLink = new OrganizationToSearchesLink(this);
	return searchesLink;
}
/**
 * Getter method for shortname
 * @return java.lang.String
 */
public java.lang.String getShortname() {
	return shortname;
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getStorageCardLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getStorageCardLink() {
	if (storageCardLink == null)
		storageCardLink = new OrganizationToStorageCardLink(this);
	return storageCardLink;
}
/**
 * Getter method for swift
 */
public java.lang.String getSwift() {
	return swift;
}
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getVcprojects() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getVcprojectsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getVcprojectsLink() {
	if (vcprojectsLink == null)
		vcprojectsLink = new OrganizationToVcprojectsLink(this);
	return vcprojectsLink;
}
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getWorkersLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getWorkersLink() {
	if (workersLink == null)
		workersLink = new OrganizationToWorkersLink(this);
	return workersLink;
}
/**
 * Getter method for zip
 */
public java.lang.String getZip() {
	return zip;
}
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCompanyKey(com.hps.july.persistence.CompanyKey inKey) {
	boolean company_NULLTEST = (inKey == null);
	if (company_NULLTEST) company_company = null; else company_company = (new Integer(inKey.company));
}
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException {
	this.getCarsLink().removeElement(aCars);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removePositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) throws java.rmi.RemoteException {
	this.getPositionResponsibleWorkerLink().removeElement(aPositionResponsibleWorker);
}
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException {
	this.getProjectsLink().removeElement(aProjects);
}
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeVcprojects(com.hps.july.persistence.Project aVcprojects) throws java.rmi.RemoteException {
	this.getVcprojectsLink().removeElement(aVcprojects);
}
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException {
	this.getWorkersLink().removeElement(aWorkers);
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAccount(com.hps.july.persistence.Account anAccount) {
	this.getAccountLink().secondaryAddElement(anAccount);
}
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCars(com.hps.july.persistence.Car aCars) {
	this.getCarsLink().secondaryAddElement(aCars);
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddContagentDocument(com.hps.july.persistence.Document aContagentDocument) {
	this.getContagentDocumentLink().secondaryAddElement(aContagentDocument);
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddContragentDocument(com.hps.july.persistence.Document aContragentDocument) {
	this.getContragentDocumentLink().secondaryAddElement(aContragentDocument);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) {
	this.getDocumentPositionLink().secondaryAddElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddExpedition(com.hps.july.persistence.Expedition anExpedition) {
	this.getExpeditionLink().secondaryAddElement(anExpedition);
}
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeasePayRule4orgtopay(com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay) {
	this.getLeasePayRule4orgtopayLink().secondaryAddElement(aLeasePayRule4orgtopay);
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOwnedDocument(com.hps.july.persistence.Document anOwnedDocument) {
	this.getOwnedDocumentLink().secondaryAddElement(anOwnedDocument);
}
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEMxranPlatinums(com.hps.july.persistence.PIEMxranPlatinum aPIEMxranPlatinums) {
	this.getPIEMxranPlatinumsLink().secondaryAddElement(aPIEMxranPlatinums);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) {
	this.getPositionResponsibleWorkerLink().secondaryAddElement(aPositionResponsibleWorker);
}
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddProjects(com.hps.july.persistence.Project aProjects) {
	this.getProjectsLink().secondaryAddElement(aProjects);
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRenteePosition(com.hps.july.persistence.Position aRenteePosition) {
	this.getRenteePositionLink().secondaryAddElement(aRenteePosition);
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSearches(com.hps.july.persistence.Searches aSearches) {
	this.getSearchesLink().secondaryAddElement(aSearches);
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryAddElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddVcprojects(com.hps.july.persistence.Project aVcprojects) {
	this.getVcprojectsLink().secondaryAddElement(aVcprojects);
}
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddWorkers(com.hps.july.persistence.Worker aWorkers) {
	this.getWorkersLink().secondaryAddElement(aWorkers);
}
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAccount(com.hps.july.persistence.Account anAccount) {
	this.getAccountLink().secondaryRemoveElement(anAccount);
}
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCars(com.hps.july.persistence.Car aCars) {
	this.getCarsLink().secondaryRemoveElement(aCars);
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveContagentDocument(com.hps.july.persistence.Document aContagentDocument) {
	this.getContagentDocumentLink().secondaryRemoveElement(aContagentDocument);
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveContragentDocument(com.hps.july.persistence.Document aContragentDocument) {
	this.getContragentDocumentLink().secondaryRemoveElement(aContragentDocument);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) {
	this.getDocumentPositionLink().secondaryRemoveElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveExpedition(com.hps.july.persistence.Expedition anExpedition) {
	this.getExpeditionLink().secondaryRemoveElement(anExpedition);
}
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeasePayRule4orgtopay(com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay) {
	this.getLeasePayRule4orgtopayLink().secondaryRemoveElement(aLeasePayRule4orgtopay);
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOwnedDocument(com.hps.july.persistence.Document anOwnedDocument) {
	this.getOwnedDocumentLink().secondaryRemoveElement(anOwnedDocument);
}
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEMxranPlatinums(com.hps.july.persistence.PIEMxranPlatinum aPIEMxranPlatinums) {
	this.getPIEMxranPlatinumsLink().secondaryRemoveElement(aPIEMxranPlatinums);
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) {
	this.getPositionResponsibleWorkerLink().secondaryRemoveElement(aPositionResponsibleWorker);
}
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveProjects(com.hps.july.persistence.Project aProjects) {
	this.getProjectsLink().secondaryRemoveElement(aProjects);
}
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRenteePosition(com.hps.july.persistence.Position aRenteePosition) {
	this.getRenteePositionLink().secondaryRemoveElement(aRenteePosition);
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSearches(com.hps.july.persistence.Searches aSearches) {
	this.getSearchesLink().secondaryRemoveElement(aSearches);
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryRemoveElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveVcprojects(com.hps.july.persistence.Project aVcprojects) {
	this.getVcprojectsLink().secondaryRemoveElement(aVcprojects);
}
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveWorkers(com.hps.july.persistence.Worker aWorkers) {
	this.getWorkersLink().secondaryRemoveElement(aWorkers);
}
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException {
	this.getCompanyLink().secondarySet(aCompany);
}
/**
 * Setter method for accauntmanagerinfo
 * @param newValue java.lang.String
 */
public void setAccauntmanagerinfo(java.lang.String newValue) {
	this.accauntmanagerinfo = newValue;
}
/**
 * Setter method for bank
 */
public void setBank(java.lang.Boolean newValue) {
	this.bank = newValue;
}
/**
 * Setter method for bik
 */
public void setBik(java.lang.String newValue) {
	this.bik = newValue;
}
/**
 * Setter method for bossPosition
 */
public void setBossPosition(java.lang.String newValue) {
	this.bossPosition = newValue;
}
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException {
	this.getCompanyLink().set(aCompany);
}
/**
 * Setter method for contactList
 */
public void setContactList(java.lang.String newValue) {
	this.contactList = newValue;
}
/**
 * Setter method for directorinfo
 * @param newValue java.lang.String
 */
public void setDirectorinfo(java.lang.String newValue) {
	this.directorinfo = newValue;
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * Setter method for fax
 * @param newValue java.lang.String
 */
public void setFax(java.lang.String newValue) {
	this.fax = newValue;
}
/**
 * Setter method for inn
 * @param newValue java.lang.String
 */
public void setInn(java.lang.String newValue) {
	this.inn = newValue;
}
/**
 * Setter method for isprovider
 * @param newValue java.lang.Boolean
 */
public void setIsprovider(java.lang.Boolean newValue) {
	this.isprovider = newValue;
}
/**
 * Setter method for isrenter
 * @param newValue java.lang.Boolean
 */
public void setIsrenter(java.lang.Boolean newValue) {
	this.isrenter = newValue;
}
/**
 * Setter method for issupplier
 * @param newValue java.lang.Boolean
 */
public void setIssupplier(java.lang.Boolean newValue) {
	this.issupplier = newValue;
}
/**
 * Setter method for koraccount
 */
public void setKoraccount(java.lang.String newValue) {
	this.koraccount = newValue;
}
/**
 * Setter method for kpp
 */
public void setKpp(java.lang.String newValue) {
	this.kpp = newValue;
}
/**
 * Setter method for legaladdress
 * @param newValue java.lang.String
 */
public void setLegaladdress(java.lang.String newValue) {
	this.legaladdress = newValue;
}
/**
 * Setter method for name
 * @param newValue java.lang.String
 */
public void setName(java.lang.String newValue) {
	this.name = newValue;
}
/**
 * Setter method for okonh
 * @param newValue java.lang.String
 */
public void setOkonh(java.lang.String newValue) {
	this.okonh = newValue;
}
/**
 * Setter method for okpo
 * @param newValue java.lang.String
 */
public void setOkpo(java.lang.String newValue) {
	this.okpo = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2002 20:25:21)
 * @param newOrganization int
 */
public void setOrganization(int newOrganization) {
	organization = newOrganization;
}
/**
 * Setter method for organizationType
 */
public void setOrganizationType(java.lang.String newValue) {
	this.organizationType = newValue;
}
/**
 * Setter method for phisicaladdress
 * @param newValue java.lang.String
 */
public void setPhisicaladdress(java.lang.String newValue) {
	this.phisicaladdress = newValue;
}
/**
 * Setter method for phone
 * @param newValue java.lang.String
 */
public void setPhone(java.lang.String newValue) {
	this.phone = newValue;
}
/**
 * Setter method for shortname
 * @param newValue java.lang.String
 */
public void setShortname(java.lang.String newValue) {
	this.shortname = newValue;
}
/**
 * Setter method for swift
 */
public void setSwift(java.lang.String newValue) {
	this.swift = newValue;
}
/**
 * Setter method for zip
 */
public void setZip(java.lang.String newValue) {
	this.zip = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence.OrganizationKey ejbCreate(
		int organization,
		com.hps.july.persistence.Company argCompany)
		throws javax.ejb.CreateException {
		_initLinks();
		this.organization = organization;
		try {
			setCompany(argCompany);
		} catch (java.rmi.RemoteException remoteEx) {
			throw new javax.ejb.CreateException(remoteEx.getMessage());
		}
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int organization,
		com.hps.july.persistence.Company argCompany)
		throws javax.ejb.CreateException {
		try {
			setCompany(argCompany);
		} catch (java.rmi.RemoteException remoteEx) {
			throw new javax.ejb.CreateException(remoteEx.getMessage());
		}
	}
	/**
	 * Get accessor for persistent attribute: ischannalrenter
	 */
	public java.lang.Boolean getIschannalrenter() {
		return ischannalrenter;
	}
	/**
	 * Set accessor for persistent attribute: ischannalrenter
	 */
	public void setIschannalrenter(java.lang.Boolean newIschannalrenter) {
		ischannalrenter = newIschannalrenter;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("contactList", getContactList());
		h.put("ischannalrenter", getIschannalrenter());
		h.put("isprovider", getIsprovider());
		h.put("accauntmanagerinfo", getAccauntmanagerinfo());
		h.put("phone", getPhone());
		h.put("issupplier", getIssupplier());
		h.put("bik", getBik());
		h.put("fax", getFax());
		h.put("isrenter", getIsrenter());
		h.put("name", getName());
		h.put("legaladdress", getLegaladdress());
		h.put("companyKey", getCompanyKey());
		h.put("bossPosition", getBossPosition());
		h.put("zip", getZip());
		h.put("okpo", getOkpo());
		h.put("directorinfo", getDirectorinfo());
		h.put("koraccount", getKoraccount());
		h.put("organization", new Integer(getOrganization()));
		h.put("organizationType", getOrganizationType());
		h.put("okonh", getOkonh());
		h.put("swift", getSwift());
		h.put("inn", getInn());
		h.put("shortname", getShortname());
		h.put("kpp", getKpp());
		h.put("phisicaladdress", getPhisicaladdress());
		h.put("bank", getBank());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localContactList =
			(java.lang.String) h.get("contactList");
		java.lang.Boolean localIschannalrenter =
			(java.lang.Boolean) h.get("ischannalrenter");
		java.lang.Boolean localIsprovider =
			(java.lang.Boolean) h.get("isprovider");
		java.lang.String localAccauntmanagerinfo =
			(java.lang.String) h.get("accauntmanagerinfo");
		java.lang.String localPhone = (java.lang.String) h.get("phone");
		java.lang.Boolean localIssupplier =
			(java.lang.Boolean) h.get("issupplier");
		java.lang.String localBik = (java.lang.String) h.get("bik");
		java.lang.String localFax = (java.lang.String) h.get("fax");
		java.lang.Boolean localIsrenter = (java.lang.Boolean) h.get("isrenter");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.String localLegaladdress =
			(java.lang.String) h.get("legaladdress");
		java.lang.String localBossPosition =
			(java.lang.String) h.get("bossPosition");
		java.lang.String localZip = (java.lang.String) h.get("zip");
		java.lang.String localOkpo = (java.lang.String) h.get("okpo");
		java.lang.String localDirectorinfo =
			(java.lang.String) h.get("directorinfo");
		java.lang.String localKoraccount =
			(java.lang.String) h.get("koraccount");
		Integer localOrganization = (Integer) h.get("organization");
		java.lang.String localOrganizationType =
			(java.lang.String) h.get("organizationType");
		java.lang.String localOkonh = (java.lang.String) h.get("okonh");
		java.lang.String localSwift = (java.lang.String) h.get("swift");
		java.lang.String localInn = (java.lang.String) h.get("inn");
		java.lang.String localShortname = (java.lang.String) h.get("shortname");
		java.lang.String localKpp = (java.lang.String) h.get("kpp");
		java.lang.String localPhisicaladdress =
			(java.lang.String) h.get("phisicaladdress");
		java.lang.Boolean localBank = (java.lang.Boolean) h.get("bank");

		if (h.containsKey("contactList"))
			setContactList((localContactList));
		if (h.containsKey("ischannalrenter"))
			setIschannalrenter((localIschannalrenter));
		if (h.containsKey("isprovider"))
			setIsprovider((localIsprovider));
		if (h.containsKey("accauntmanagerinfo"))
			setAccauntmanagerinfo((localAccauntmanagerinfo));
		if (h.containsKey("phone"))
			setPhone((localPhone));
		if (h.containsKey("issupplier"))
			setIssupplier((localIssupplier));
		if (h.containsKey("bik"))
			setBik((localBik));
		if (h.containsKey("fax"))
			setFax((localFax));
		if (h.containsKey("isrenter"))
			setIsrenter((localIsrenter));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("legaladdress"))
			setLegaladdress((localLegaladdress));
		if (h.containsKey("bossPosition"))
			setBossPosition((localBossPosition));
		if (h.containsKey("zip"))
			setZip((localZip));
		if (h.containsKey("okpo"))
			setOkpo((localOkpo));
		if (h.containsKey("directorinfo"))
			setDirectorinfo((localDirectorinfo));
		if (h.containsKey("koraccount"))
			setKoraccount((localKoraccount));
		if (h.containsKey("organization"))
			setOrganization((localOrganization).intValue());
		if (h.containsKey("organizationType"))
			setOrganizationType((localOrganizationType));
		if (h.containsKey("okonh"))
			setOkonh((localOkonh));
		if (h.containsKey("swift"))
			setSwift((localSwift));
		if (h.containsKey("inn"))
			setInn((localInn));
		if (h.containsKey("shortname"))
			setShortname((localShortname));
		if (h.containsKey("kpp"))
			setKpp((localKpp));
		if (h.containsKey("phisicaladdress"))
			setPhisicaladdress((localPhisicaladdress));
		if (h.containsKey("bank"))
			setBank((localBank));
	}
}
