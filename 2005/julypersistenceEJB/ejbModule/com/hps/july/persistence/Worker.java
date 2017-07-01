package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Worker extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addControlledContract(com.hps.july.persistence.Contract aControlledContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addControlleddivisions(com.hps.july.persistence.Division aControlleddivisions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addDocumentforstorager(com.hps.july.persistence.Document aDocumentforstorager) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addExpedition(com.hps.july.persistence.Expedition anExpedition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addI13nActTech(com.hps.july.persistence.I13nAct anI13nActTech) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalOutBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInventoryNumbers(com.hps.july.persistence.InventoryNumbers anInventoryNumbers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInwayBills(com.hps.july.persistence.InwayBill anInwayBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInwayBillstorManagers(com.hps.july.persistence.InwayBill anInwayBillstorManagers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInwayBilltechstuf(com.hps.july.persistence.InwayBill anInwayBilltechstuf) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseContractEconomist(com.hps.july.persistence.LeaseContract aLeaseContractEconomist) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseContracts(com.hps.july.persistence.LeaseContract aLeaseContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseTaskStartEconomists(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStartEconomists) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPayOffActChairMan(com.hps.july.persistence.PayOffAct aPayOffActChairMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPayOffActMember(com.hps.july.persistence.PayOffAct aPayOffActMember) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPayOffActMember2(com.hps.july.persistence.PayOffAct aPayOffActMember2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addPositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRequestSender(com.hps.july.persistence.Request aRequestSender) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addWorkedContract(com.hps.july.persistence.Contract aWorkedContract) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getActive() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAssemblingAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Company getCompany() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CompanyKey getCompanyKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getControlledContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getControlleddivisions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Division getDivision() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DivisionKey getDivisionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getDocumentforstorager() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for email
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getEmail() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getExpedition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getFaultReport() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for fax
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFax() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getI13nActTech() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalOutBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInternalOutBill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInternalWayBill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInventoryNumbers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInwayBills() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInwayBillstorManagers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInwayBilltechstuf() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsour() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsservicestuff() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseContractEconomist() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseContracts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseTaskStartEconomists() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getLocalphone() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getLotusaddress() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.People getMan() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PeopleKey getManKey() throws java.rmi.RemoteException;
/**
 * Getter method for mobilephone
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getMobilephone() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getOrganizationKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPayOffActChairMan() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPayOffActMember() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPayOffActMember2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for phone1
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPhone1() throws java.rmi.RemoteException;
/**
 * Getter method for phone2
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPhone2() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPhoto() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkPosition getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkPositionKey getPositionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPositionResponsibleWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRequest() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRequestSender() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getWorkedContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getWorker() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCompanyKey(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDivisionKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetManKey(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPositionKey(com.hps.july.persistence.WorkPositionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseContracts(com.hps.july.persistence.LeaseContract aLeaseContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removePhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removePositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddControlledContract(com.hps.july.persistence.Contract aControlledContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddControlleddivisions(com.hps.july.persistence.Division aControlleddivisions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddDocumentforstorager(com.hps.july.persistence.Document aDocumentforstorager) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddExpedition(com.hps.july.persistence.Expedition anExpedition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddI13nActTech(com.hps.july.persistence.I13nAct anI13nActTech) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalOutBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInventoryNumbers(com.hps.july.persistence.InventoryNumbers anInventoryNumbers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInwayBills(com.hps.july.persistence.InwayBill anInwayBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInwayBillstorManagers(com.hps.july.persistence.InwayBill anInwayBillstorManagers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInwayBilltechstuf(com.hps.july.persistence.InwayBill anInwayBilltechstuf) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseContractEconomist(com.hps.july.persistence.LeaseContract aLeaseContractEconomist) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseContracts(com.hps.july.persistence.LeaseContract aLeaseContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseTaskStartEconomists(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStartEconomists) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPayOffActChairMan(com.hps.july.persistence.PayOffAct aPayOffActChairMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPayOffActMember(com.hps.july.persistence.PayOffAct aPayOffActMember) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPayOffActMember2(com.hps.july.persistence.PayOffAct aPayOffActMember2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRequestSender(com.hps.july.persistence.Request aRequestSender) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddWorkedContract(com.hps.july.persistence.Contract aWorkedContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveControlledContract(com.hps.july.persistence.Contract aControlledContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveControlleddivisions(com.hps.july.persistence.Division aControlleddivisions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveDocumentforstorager(com.hps.july.persistence.Document aDocumentforstorager) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveExpedition(com.hps.july.persistence.Expedition anExpedition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveI13nActTech(com.hps.july.persistence.I13nAct anI13nActTech) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalOutBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInventoryNumbers(com.hps.july.persistence.InventoryNumbers anInventoryNumbers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInwayBills(com.hps.july.persistence.InwayBill anInwayBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInwayBillstorManagers(com.hps.july.persistence.InwayBill anInwayBillstorManagers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInwayBilltechstuf(com.hps.july.persistence.InwayBill anInwayBilltechstuf) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseContractEconomist(com.hps.july.persistence.LeaseContract aLeaseContractEconomist) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseContracts(com.hps.july.persistence.LeaseContract aLeaseContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseTaskStartEconomists(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStartEconomists) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePayOffActChairMan(com.hps.july.persistence.PayOffAct aPayOffActChairMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePayOffActMember(com.hps.july.persistence.PayOffAct aPayOffActMember) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePayOffActMember2(com.hps.july.persistence.PayOffAct aPayOffActMember2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRequestSender(com.hps.july.persistence.Request aRequestSender) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveWorkedContract(com.hps.july.persistence.Contract aWorkedContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPosition(com.hps.july.persistence.WorkPosition aPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setActive(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * Setter method for email
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setEmail(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for fax
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFax(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsour(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsservicestuff(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setLocalphone(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setLotusaddress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * Setter method for mobilephone
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setMobilephone(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * Setter method for phone1
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPhone1(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for phone2
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPhone2(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPosition(com.hps.july.persistence.WorkPosition aPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newWorker int
 * @exception String The exception description.
 */
void setWorker(int newWorker) throws java.rmi.RemoteException;
}
