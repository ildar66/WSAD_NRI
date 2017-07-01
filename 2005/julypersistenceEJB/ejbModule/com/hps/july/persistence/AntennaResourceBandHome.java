package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AntennaResourceBandHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.AntennaResourceBand
 * @param argResource int
 * @param argBand short
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AntennaResourceBand create(int argResource, short argBand) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAntennaResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AntennaResourceBand
 * @param key com.hps.july.persistence.AntennaResourceBandKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AntennaResourceBand findByPrimaryKey(com.hps.july.persistence.AntennaResourceBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
