package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectDivColumnsHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ProjectDivColumns
 * @param argDivcolid int
 * @param projectType int
 * @param division int
 * @param argColname java.lang.String
 * @param argAftercol int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectDivColumns create(int argDivcolid, int projectType, int division, java.lang.String argColname, int argAftercol) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public java.util.Enumeration findByColDivisionActtypeOrderByAfterColAsc(
		Integer argAfterCol, Integer argDivision, Integer argProjectType) 
	throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectDivColumns
 * @param key com.hps.july.persistence.ProjectDivColumnsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectDivColumns findByPrimaryKey(com.hps.july.persistence.ProjectDivColumnsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectDivColumnsByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findProjectDivColumnsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
