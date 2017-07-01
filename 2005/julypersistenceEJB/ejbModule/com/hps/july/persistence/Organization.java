package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: Organization
 */
public interface Organization extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {




/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAccount(com.hps.july.persistence.Account anAccount) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addContagentDocument(com.hps.july.persistence.Document aContagentDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addContragentDocument(com.hps.july.persistence.Document aContragentDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addExpedition(com.hps.july.persistence.Expedition anExpedition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeasePayRule4orgtopay(com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addOwnedDocument(com.hps.july.persistence.Document anOwnedDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRenteePosition(com.hps.july.persistence.Position aRenteePosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addVcprojects(com.hps.july.persistence.Project aVcprojects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * Getter method for accauntmanagerinfo
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAccauntmanagerinfo() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAccount() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getBank() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getBik() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getBossPosition() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getCars() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Company getCompany() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CompanyKey getCompanyKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getContactList() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getContagentDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getContragentDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for directorinfo
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDirectorinfo() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getExpedition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for fax
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFax() throws java.rmi.RemoteException;
/**
 * Getter method for inn
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getInn() throws java.rmi.RemoteException;
/**
 * Getter method for isprovider
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIsprovider() throws java.rmi.RemoteException;
/**
 * Getter method for isrenter
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIsrenter() throws java.rmi.RemoteException;
/**
 * Getter method for issupplier
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIssupplier() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getKoraccount() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getKpp() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeasePayRule4orgtopay() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for legaladdress
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLegaladdress() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * Getter method for okonh
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOkonh() throws java.rmi.RemoteException;
/**
 * Getter method for okpo
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOkpo() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOrganization() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOrganizationType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getOwnedDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for phisicaladdress
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPhisicaladdress() throws java.rmi.RemoteException;
/**
 * Getter method for phone
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPhone() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEMxranPlatinums() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPositionResponsibleWorker() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjects() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRenteePosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSearches() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for shortname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getShortname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getSwift() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getVcprojects() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getZip() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCompanyKey(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removePositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeVcprojects(com.hps.july.persistence.Project aVcprojects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAccount(com.hps.july.persistence.Account anAccount) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddContagentDocument(com.hps.july.persistence.Document aContagentDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddContragentDocument(com.hps.july.persistence.Document aContragentDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddExpedition(com.hps.july.persistence.Expedition anExpedition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeasePayRule4orgtopay(com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddOwnedDocument(com.hps.july.persistence.Document anOwnedDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEMxranPlatinums(com.hps.july.persistence.PIEMxranPlatinum aPIEMxranPlatinums) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRenteePosition(com.hps.july.persistence.Position aRenteePosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSearches(com.hps.july.persistence.Searches aSearches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddVcprojects(com.hps.july.persistence.Project aVcprojects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAccount(com.hps.july.persistence.Account anAccount) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveContagentDocument(com.hps.july.persistence.Document aContagentDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveContragentDocument(com.hps.july.persistence.Document aContragentDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveExpedition(com.hps.july.persistence.Expedition anExpedition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeasePayRule4orgtopay(com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveOwnedDocument(com.hps.july.persistence.Document anOwnedDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEMxranPlatinums(com.hps.july.persistence.PIEMxranPlatinum aPIEMxranPlatinums) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePositionResponsibleWorker(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRenteePosition(com.hps.july.persistence.Position aRenteePosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSearches(com.hps.july.persistence.Searches aSearches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveVcprojects(com.hps.july.persistence.Project aVcprojects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException;
/**
 * Setter method for accauntmanagerinfo
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAccauntmanagerinfo(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setBank(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setBik(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setBossPosition(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setContactList(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for directorinfo
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDirectorinfo(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for fax
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFax(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for inn
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setInn(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for isprovider
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsprovider(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for isrenter
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsrenter(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for issupplier
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIssupplier(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setKoraccount(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setKpp(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for legaladdress
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLegaladdress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for okonh
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOkonh(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for okpo
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOkpo(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newOrganization int
 * @exception String The exception description.
 */
void setOrganization(int newOrganization) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setOrganizationType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for phisicaladdress
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPhisicaladdress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for phone
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPhone(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for shortname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setShortname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setSwift(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setZip(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ischannalrenter
	 */
	public java.lang.Boolean getIschannalrenter() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ischannalrenter
	 */
	public void setIschannalrenter(java.lang.Boolean newIschannalrenter) throws java.rmi.RemoteException;
}
