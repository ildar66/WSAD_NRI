package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProtoActionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ProtoAction
 * @param argProjectaction int
 * @param argOrder int
 * @param argProjecttype int
 * @param argProjectactiontype int
 * @param argDuration int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProtoAction create(int argProjectaction, int argOrder, int argProjecttype, int argProjectactiontype, int argDuration) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProtoAction
 * @param key com.hps.july.persistence.ProtoActionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProtoAction findByPrimaryKey(com.hps.july.persistence.ProtoActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByProjectactiontypeOrderByOrderAsc(Integer projectactiontype) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByProjecttypeOrderByOrderAsc(Integer projecttype) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProtoActionsByProjectActionType(com.hps.july.persistence.ProjectActionTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProtoActionsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;

java.util.Enumeration findStepsBeforeOrderByOrderAsc(Integer argProjectType, Integer argProjectAction) 
	throws java.rmi.RemoteException, javax.ejb.FinderException;
}
