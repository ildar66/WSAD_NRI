package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Car extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getCar() throws java.rmi.RemoteException;
/**
 * Getter method for car_model
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCar_model() throws java.rmi.RemoteException;
/**
 * Getter method for car_number
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCar_number() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Division getDivision() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DivisionKey getDivisionKey() throws java.rmi.RemoteException;
/**
 * Getter method for isour
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIsour() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getOrganizationKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDivisionKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * Setter method for car_model
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCar_model(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for car_number
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCar_number(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * Setter method for isour
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsour(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
}
