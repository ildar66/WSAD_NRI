package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface UserReportHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.UserReport
 * @param argUserrepid int
 * @param usergrpid java.lang.Integer
 * @param argRepname java.lang.String
 * @param argClassname java.lang.String
 * @param argRptname java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.UserReport create(int argUserrepid, java.lang.Integer usergrpid, java.lang.String argRepname, java.lang.String argClassname, java.lang.String argRptname) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByGroupOrderByNameAsc(Integer argGroupId) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.UserReport
 * @param key com.hps.july.persistence.UserReportKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.UserReport findByPrimaryKey(com.hps.july.persistence.UserReportKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findUserReportsByUserRepGroup(com.hps.july.persistence.UserRepGroupKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
