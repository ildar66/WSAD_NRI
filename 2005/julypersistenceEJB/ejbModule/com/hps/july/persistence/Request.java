package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: Request
 */
public interface Request extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getChecker() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getCheckerKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Division getDivisionRequester() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DivisionKey getDivisionRequesterKey() throws java.rmi.RemoteException;
/**
 * Getter method for nAvto
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNAvto() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException;
/**
 * Getter method for requeststate
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRequeststate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getSender() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getSenderKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCheckerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDivisionRequesterKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSenderKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetChecker(com.hps.july.persistence.Worker aChecker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDivisionRequester(com.hps.july.persistence.Division aDivisionRequester) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSender(com.hps.july.persistence.Worker aSender) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setChecker(com.hps.july.persistence.Worker aChecker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDivisionRequester(com.hps.july.persistence.Division aDivisionRequester) throws java.rmi.RemoteException;
/**
 * Setter method for nAvto
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNAvto(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * Setter method for requeststate
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRequeststate(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSender(com.hps.july.persistence.Worker aSender) throws java.rmi.RemoteException;
}
