package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface DivisionHome extends javax.ejb.EJBHome {
/**
 * 
 * @return com.hps.july.persistence.Division
 * @param argDivision int
 * @param argName java.lang.String
 * @param argIsactive java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Division create(int argDivision, java.lang.String argName, java.lang.Boolean argIsactive) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Division
 * @param argDivision int
 * @param argName java.lang.String
 * @param argShortName java.lang.String
 * @param argParent java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Division create(int argDivision, java.lang.String argName, java.lang.String argShortName, java.lang.Integer argParent) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Division
 * @param argDivision int
 * @param argName java.lang.String
 * @param argShortName java.lang.String
 * @param argCompany java.lang.Integer
 * @param dummy char
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Division create(int argDivision, java.lang.String argName, java.lang.String argShortName, java.lang.Integer argCompany, char dummy) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAllByProjectActionTypeOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findAllByProjectColumnsOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findAllByProjectCommsByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByParentCompany( Integer parent, Integer company,
Boolean isRoot, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByParentOrderByNameAsc( Integer parent ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByParentOrderByNameDesc( Integer parent ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Division
 * @param key com.hps.july.persistence.DivisionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Division findByPrimaryKey(com.hps.july.persistence.DivisionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByQBE(
    Boolean isParent, Integer parent,
    Boolean isIsActive, Boolean isActive,
    Integer order
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findChildsByParent(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findControlleddivisionsByBoss(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDivisionsByCompany(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
