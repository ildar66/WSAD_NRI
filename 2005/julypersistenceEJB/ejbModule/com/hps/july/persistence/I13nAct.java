package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: I13nAct
 */
public interface I13nAct extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StorageCard getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StorageCardKey getAgregateKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAgregateresource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getAgregateserial() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nActResourceSet() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nDateSaving() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getRecalcagrprice() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getTechStuff() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getTechStuffKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAgregateKey(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetTechStuffKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAgregate(com.hps.july.persistence.StorageCard anAgregate) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAgregate(com.hps.july.persistence.StorageCard anAgregate) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAgregateresource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setAgregateserial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setRecalcagrprice(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException;
}
