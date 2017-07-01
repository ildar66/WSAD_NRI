package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface CableResourceBandHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.CableResourceBand
 * @param argResource int
 * @param argBand short
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.CableResourceBand create(int argResource, short argBand) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByCableResAndAntennaOrderByBand(Integer cable, Integer antenna) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByCableResOrderByBand(Integer cable) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.CableResourceBand
 * @param key com.hps.july.persistence.CableResourceBandKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.CableResourceBand findByPrimaryKey(com.hps.july.persistence.CableResourceBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findCableResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
