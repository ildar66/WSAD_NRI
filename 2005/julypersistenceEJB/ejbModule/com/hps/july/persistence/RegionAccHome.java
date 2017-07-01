package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RegionAccHome extends javax.ejb.EJBHome {
/**
 * 
 * @return com.hps.july.persistence.RegionAcc
 * @param argAccessid int
 * @param argOperatorId int
 * @param argRegionId int
 * @param argViewPlan boolean
 * @param argViewFact boolean
 * @param argEditPlan boolean
 * @param argEditFact boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.RegionAcc create(int argAccessid, int argOperatorId, int argRegionId, boolean argViewPlan, boolean argViewFact, boolean argEditPlan, boolean argEditFact) throws javax.ejb.CreateException, java.rmi.RemoteException;
	java.util.Enumeration findByOperatorAndId(Integer argOperator, Integer argRegionID) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.RegionAcc
 * @param key com.hps.july.persistence.RegionAccKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.RegionAcc findByPrimaryKey(com.hps.july.persistence.RegionAccKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Integer argOperator,
	Boolean isSuperregion, Integer argSupregion,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findBySuperregionOrderByCodeAsc(Integer argSupregion) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named RegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRegionAccsByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named RegionAcc2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRegionAccsByRegion(com.hps.july.persistence.RegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
