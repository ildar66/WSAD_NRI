package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface DocumentAction extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDocAction() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDocument() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Operator getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentAction2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OperatorKey getOperatorKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getType() throws java.rmi.RemoteException;
/**
 * Getter method for what
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getWhat() throws java.rmi.RemoteException;
/**
 * Getter method for when
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getWhen() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentAction2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newDocAction int
 * @exception String The exception description.
 */
void setDocAction(int newDocAction) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setDocument(int newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newType java.lang.String
 * @exception String The exception description.
 */
void setType(java.lang.String newType) throws java.rmi.RemoteException;
/**
 * Setter method for what
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setWhat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for when
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setWhen(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
}
