package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Operator extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addDocumentAction(com.hps.july.persistence.DocumentAction aDocumentAction) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addImportSessions(com.hps.july.persistence.ImportSession anImportSessions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentAction() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getEnabled() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getImportSessions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseTaskStarts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for login
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLogin() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.People getMan() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PeopleKey getManKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getMsucode() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOperator() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOperators2Roles() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for password
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPassword() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRegionAccs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSuperRegionAccs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetManKey(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentAction(com.hps.july.persistence.DocumentAction aDocumentAction) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddImportSessions(com.hps.july.persistence.ImportSession anImportSessions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOperators2Roles(com.hps.july.persistence.Operators2Roles anOperators2Roles) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentAction(com.hps.july.persistence.DocumentAction aDocumentAction) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveImportSessions(com.hps.july.persistence.ImportSession anImportSessions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOperators2Roles(com.hps.july.persistence.Operators2Roles anOperators2Roles) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setEnabled(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for login
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLogin(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setMsucode(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newOperator int
 * @exception String The exception description.
 */
void setOperator(int newOperator) throws java.rmi.RemoteException;
/**
 * Setter method for password
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPassword(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: oldpwd
	 */
	public java.lang.String getOldpwd() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: oldpwd
	 */
	public void setOldpwd(java.lang.String newOldpwd)
		throws java.rmi.RemoteException;
}
