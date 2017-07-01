package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIELinkPrihRashHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIELinkPrihRash
 * @param argIdlinkprihodrashod int
 * @param argDocposPrihod int
 * @param argFromStoragePrihod int
 * @param argDocposRashod int
 * @param argQty java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIELinkPrihRash create(int argIdlinkprihodrashod, int argDocposPrihod, int argFromStoragePrihod, int argDocposRashod, java.math.BigDecimal argQty) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByDocposPrihod(Integer argDocpos) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByDocposRashod(Integer argDocpos) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIELinkPrihRash
 * @param key com.hps.july.persistence.PIELinkPrihRashKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIELinkPrihRash findByPrimaryKey(com.hps.july.persistence.PIELinkPrihRashKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
