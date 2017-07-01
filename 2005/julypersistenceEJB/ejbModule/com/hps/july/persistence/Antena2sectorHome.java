package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Antena2sectorHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Antena2sector
 * @param argAnten int
 * @param argSector int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Antena2sector create(int argAnten, int argSector) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Antena2sector
 * @param argAnten int
 * @param argSector int
 * @param argByhand java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Antena2sector create(int argAnten, int argSector, java.lang.Boolean argByhand) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAntena2sectorsByAntenna(com.hps.july.persistence.AntennaKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antena2sector2sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAntena2sectorsBySector(com.hps.july.persistence.SectorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Antena2sector
 * @param key com.hps.july.persistence.Antena2sectorKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Antena2sector findByPrimaryKey(com.hps.july.persistence.Antena2sectorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
