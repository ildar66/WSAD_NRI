package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface OperatorHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Operator
 * @param argOperator int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Operator create(int argOperator) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Operator
 * @param argOperator int
 * @param argMan java.lang.Integer
 * @param argLogin java.lang.String
 * @param argPassword java.lang.String
 * @param argEnabled java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Operator create(int argOperator, java.lang.Integer argMan, java.lang.String argLogin, java.lang.String argPassword, java.lang.Boolean argEnabled) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.security.persistence.Operators
 * @param key com.hps.july.security.persistence.OperatorsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Operator findByLogin( String login ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Operator
 * @param key com.hps.july.persistence.OperatorKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Operator findByPrimaryKey(com.hps.july.persistence.OperatorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.security.persistence.Operators
 * @param key com.hps.july.security.persistence.OperatorsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findOperatorByLastNameOrderByLoginAsc( String lastName ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOperatorsByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findOperatorsWithImportSessions( ) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
