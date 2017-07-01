package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEDogovorLinkHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEDogovorLink
 * @param argIddogovornri int
 * @param argTypedogovornri java.lang.String
 * @param argOwner int
 * @param argIdDogovorPlatinum java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEDogovorLink create(int argIddogovornri, java.lang.String argTypedogovornri, int argOwner, java.lang.String argIdDogovorPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEDogovorLink
 * @param key com.hps.july.persistence.PIEDogovorLinkKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEDogovorLink findByPrimaryKey(com.hps.july.persistence.PIEDogovorLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
