package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeasePosSchetFaktHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeasePosSchetFakt
 * @param argIdPosSchetFakt int
 * @param idSchetFakt int
 * @param argPosorder int
 * @param resourceNri int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeasePosSchetFakt create(Integer argIdPosSchetFakt, Integer idSchetFakt, Integer argPosorder, Integer resourceNri) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdSchetFaktOrderByPosorderAsc(Integer idSchetFact) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdSchetFaktOrderByPosorderDesc(Integer idSchetFact) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeasePosSchetFakt
 * @param key com.hps.july.persistence.LeasePosSchetFaktKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeasePosSchetFakt findByPrimaryKey(com.hps.july.persistence.LeasePosSchetFaktKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeasePosSchetFaktByResourceNri(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeasePosSchetFaktsByIdSchetFakt(com.hps.july.persistence.LeaseSchetFaktKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
