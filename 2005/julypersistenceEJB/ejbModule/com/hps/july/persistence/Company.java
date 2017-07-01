package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Company extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addDivisions(com.hps.july.persistence.Division aDivisions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getCompany() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getDivisions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for shortname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getShortname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddDivisions(com.hps.july.persistence.Division aDivisions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveDivisions(com.hps.july.persistence.Division aDivisions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newCompany int
 * @exception String The exception description.
 */
void setCompany(int newCompany) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for shortname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setShortname(java.lang.String newValue) throws java.rmi.RemoteException;
}
