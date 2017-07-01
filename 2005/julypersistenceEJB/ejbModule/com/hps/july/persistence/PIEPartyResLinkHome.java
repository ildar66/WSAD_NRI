package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEPartyResLinkHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEPartyResLink
 * @param argParty java.lang.String
 * @param argOwner int
 * @param argPartyPlatinum java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEPartyResLink create(java.lang.String argParty, int argOwner, java.lang.String argPartyPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PIEPartyResLink
 * @param argParty java.lang.String
 * @param argOwner int
 * @param argPartyPlatinum java.lang.String
 * @param argIdResPlatinum java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEPartyResLink create(java.lang.String argParty, int argOwner, java.lang.String argPartyPlatinum, java.lang.String argIdResPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEPartyResLink
 * @param key com.hps.july.persistence.PIEPartyResLinkKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEPartyResLink findByPrimaryKey(com.hps.july.persistence.PIEPartyResLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
