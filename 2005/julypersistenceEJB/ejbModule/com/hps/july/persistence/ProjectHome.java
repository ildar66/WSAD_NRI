package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Project
 * @param argProject int
 * @param argProjectType int
 * @param argName java.lang.String
 * @param position int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Project create(int argProject, int argProjectType, java.lang.String argName, int position) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Project
 * @param key com.hps.july.persistence.ProjectKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Project findByPrimaryKey(com.hps.july.persistence.ProjectKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE1(Integer projecttype, 
	Boolean isProjectstate, String argProjectstate, 
	Boolean isPosition, Integer argPosition,
 	Boolean isNetzone, Integer argNetzone,  
 	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE2(Integer division, Integer projecttype,
	Boolean isSupregions, Integer [] supregions, 
	Boolean isRegions, Integer [] regions, 
	Boolean isNetzones, Integer [] netzones,
	Boolean isPosition, Integer argPosition,
	Boolean isResponsible, Integer argResponsible,
	Boolean isEndDate, Short endMonth, Integer endYear,
	Boolean isProjectstate, String argProjectstate, 
 	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectsByContructer(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectsByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectsByProjecttype(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findVcprojectsByVccontructer(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
