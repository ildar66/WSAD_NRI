package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AntennaWorkBandHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.AntennaWorkBand
 * @param argIdanten int
 * @param argBand short
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AntennaWorkBand create(int argIdanten, short argBand) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAntennaWorkBandsByAntenna(com.hps.july.persistence.AntennaKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AntennaWorkBand
 * @param key com.hps.july.persistence.AntennaWorkBandKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AntennaWorkBand findByPrimaryKey(com.hps.july.persistence.AntennaWorkBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
