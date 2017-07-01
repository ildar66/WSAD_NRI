package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface OfficeMemoHeaderHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.OfficeMemoHeader
 * @param argIdheader int
 * @param argAbonentContract int
 * @param argNumber java.lang.String
 * @param argDate java.sql.Date
 * @param argMan int
 * @param argType java.lang.String
 * @param argTarget int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.OfficeMemoHeader create(int argIdheader, int argAbonentContract, java.lang.String argNumber, java.sql.Date argDate, int argMan, java.lang.String argType, int argTarget) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.OfficeMemoHeader
 * @param key com.hps.july.persistence2.OfficeMemoHeaderKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.OfficeMemoHeader findByPrimaryKey(com.hps.july.persistence2.OfficeMemoHeaderKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
