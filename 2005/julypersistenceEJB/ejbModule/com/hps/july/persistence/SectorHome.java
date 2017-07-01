package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SectorHome extends javax.ejb.EJBHome {
/**
 * 
 * @return com.hps.july.persistence.Sector
 * @param argIdsect int
 * @param argEquipment int
 * @param argNamesect java.lang.String
 * @param argBand short
 * @param argNumsect java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Sector create(int argIdsect, int argEquipment, java.lang.String argNamesect, short argBand, java.lang.String argNumsect) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Sector
 * @param argIdsect int
 * @param argEquipment int
 * @param argNamesect java.lang.String
 * @param argBand short
 * @param argNumsect java.lang.String
 * @param argByhand java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Sector create(int argIdsect, int argEquipment, java.lang.String argNamesect, short argBand, java.lang.String argNumsect, java.lang.Boolean argByhand) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByBasestationOrderByNumberAsc(Integer argEquipment) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Sector
 * @param key com.hps.july.persistence.SectorKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Sector findByPrimaryKey(com.hps.july.persistence.SectorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
	java.util.Enumeration findByQBE(Integer argBSNum, String bsType,
		Boolean isPlanstate, String argPlanstate, 
		Boolean isState, String argState,
		Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSectorsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
