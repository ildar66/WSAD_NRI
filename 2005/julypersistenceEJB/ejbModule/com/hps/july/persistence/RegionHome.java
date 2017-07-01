package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RegionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Region
 * @param argRegionid int
 * @param argSupregid int
 * @param argRegName java.lang.String
 * @param argSectorPrefix java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Region create(int argRegionid, int argSupregid, java.lang.String argRegName, java.math.BigDecimal argSectorPrefix) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Region
 * @param key com.hps.july.persistence.RegionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Region findByPrimaryKey(com.hps.july.persistence.RegionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Boolean isSuperRegion, Integer superRegion, 
	Boolean isRegionName, String regionName,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRegionBySuperregion(com.hps.july.persistence.SuperRegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
