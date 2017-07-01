package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface PositionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Position
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Position create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Position
 * @param argStorageplace int
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argNetZone java.lang.Integer
 * @param argLatitude java.math.BigDecimal
 * @param argLongitude java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Position
 * @param argStorageplace int
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argNetZone java.lang.Integer
 * @param argLatitude java.math.BigDecimal
 * @param argLongitude java.math.BigDecimal
 * @param argRegionId int
 * @param argPlanState java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, int argRegionId, java.lang.String argPlanState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Position
 * @param argStorageplace int
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argNetZone java.lang.Integer
 * @param argLatitude java.math.BigDecimal
 * @param argLongitude java.math.BigDecimal
 * @param argPlanState java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, java.lang.String argPlanState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Position
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Position findByPrimaryKey(StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE( Boolean isNetZone, Integer argNetZone, Boolean isGsmId, String argGsmId,
	Boolean isDampsId, String argDampsId, Boolean isName, String argName, 
	Boolean isAddr, String argAddr, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE2( Boolean isNetZone, Integer argNetZone,
Boolean isGsmId, String argGsmId,
 Boolean isDampsId, String argDampsId, Boolean isName, String argName,
 Boolean isAddr, String argAddr, Boolean isRenter, Integer argRenter, Boolean isResponsableWorker, Integer argResponsableWorker,
Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE3( Boolean isNetZone, Integer argNetZone,
Boolean isGsmId, String argGsmId,
 Boolean isDampsId, String argDampsId, Boolean isName, String argName,
 Boolean isAddr, String argAddr, Boolean isRenter, Integer argRenter, Boolean isResponsableWorker, 
 Integer argResponsableWorker, Boolean isInAction, String inAction,
 Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE4(
            Boolean isNetZone, Integer argNetZone,
            Boolean isAllType,
            Boolean isDAMPS,
            Boolean isGSM900,
            Boolean isDCS1800,
            Boolean isControllers,
            Boolean isWorker, Integer argWorker ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPositionByNetZone(com.hps.july.persistence.NetZoneKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPositionsByRegion(com.hps.july.persistence.RegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRenteePositionByRenter(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
