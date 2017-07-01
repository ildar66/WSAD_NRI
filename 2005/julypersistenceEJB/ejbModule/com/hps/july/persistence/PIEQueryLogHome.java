package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEQueryLogHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEQueryLog
 * @param argIdnriquerylog int
 * @param argQuery int
 * @param argTypeMsg java.lang.String
 * @param argErrorcode int
 * @param argTextMsg java.lang.String
 * @param argVdat java.sql.Timestamp
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEQueryLog create(int argIdnriquerylog, int argQuery, java.lang.String argTypeMsg, int argErrorcode, java.lang.String argTextMsg, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEQueryLog
 * @param key com.hps.july.persistence.PIEQueryLogKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEQueryLog findByPrimaryKey(com.hps.july.persistence.PIEQueryLogKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQueryTypeOrderByCodeAsc(Integer argQuery, String argType) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPIEQueryLogsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
