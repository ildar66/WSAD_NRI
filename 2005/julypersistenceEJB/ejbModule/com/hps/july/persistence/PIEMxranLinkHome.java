package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEMxranLinkHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEMxranLink
 * @param argMxrannri int
 * @param argOwner int
 * @param argMxranplatinum java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEMxranLink create(int argMxrannri, int argOwner, java.lang.String argMxranplatinum) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByMxrannriOwner(Integer mxrannri, Integer owner)
	 throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEMxranLink
 * @param key com.hps.july.persistence.PIEMxranLinkKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEMxranLink findByPrimaryKey(com.hps.july.persistence.PIEMxranLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPIEMxranLinksByMxranplatinum(com.hps.july.persistence.PIEMxranPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
