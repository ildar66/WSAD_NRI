package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectActionTypeHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.ProjectActionType
 * @param argProjectactiontype int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ProjectActionType create(int argProjectactiontype) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ProjectActionType
 * @param argProjectactiontype int
 * @param argDivision int
 * @param argName java.lang.String
 * @param argResult java.lang.String
 * @param argEquiptype java.lang.String
 * @param argResponsibilitytype int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectActionType create(int argProjectactiontype, int argDivision, java.lang.String argName, java.lang.String argResult, java.lang.String argEquiptype, int argResponsibilitytype) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectActionType
 * @param key com.hps.july.persistence.ProjectActionTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectActionType findByPrimaryKey(com.hps.july.persistence.ProjectActionTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByProjecttypeOrderByCodeAsc(Integer argProjectType, Integer argProjectActionType) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectActionTypesByAction2division(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectActionTypesByResponsibilitytype(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
