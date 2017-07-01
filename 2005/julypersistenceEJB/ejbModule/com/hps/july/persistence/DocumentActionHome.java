package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface DocumentActionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.DocumentAction
 * @param argDocAction int
 * @param argDocument java.lang.Integer
 * @param argWhen java.sql.Timestamp
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.DocumentAction create(int argDocAction, java.lang.Integer argDocument, java.sql.Timestamp argWhen) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.DocumentAction
 * @param key com.hps.july.persistence.DocumentActionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.DocumentAction findByPrimaryKey(com.hps.july.persistence.DocumentActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentAction2Operators.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findDocumentActionByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
