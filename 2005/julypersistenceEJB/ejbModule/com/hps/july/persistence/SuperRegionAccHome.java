package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SuperRegionAccHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.SuperRegionAcc
 * @param argAccessid int
 * @param argOperatorId int
 * @param argSupregionId int
 * @param argViewPlan boolean
 * @param argViewFact boolean
 * @param argEditPlan boolean
 * @param argEditFact boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SuperRegionAcc create(int argAccessid, int argOperatorId, int argSupregionId, boolean argViewPlan, boolean argViewFact, boolean argEditPlan, boolean argEditFact) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByOperator(Integer argOperator) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByOperatorAndId(Integer argOperator, Integer argSregionID) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SuperRegionAcc
 * @param key com.hps.july.persistence.SuperRegionAccKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SuperRegionAcc findByPrimaryKey(com.hps.july.persistence.SuperRegionAccKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSuperRegionAccsByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSuperRegionAccsBySuperregion(com.hps.july.persistence.SuperRegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
