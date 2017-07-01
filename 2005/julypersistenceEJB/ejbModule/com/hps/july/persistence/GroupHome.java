package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface GroupHome extends javax.ejb.EJBHome {
/**
 * 
 * @return com.hps.july.persistence.Group
 * @param argDivision int
 * @param argName java.lang.String
 * @param argShortName java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Group create(int argDivision, String argName, String argShortName, Integer argParent) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByParentOrderByNameAsc( Integer parent ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByParentOrderByNameDesc( Integer parent ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.Group
 * @param key com.hps.july.persistence.DivisionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Group findByPrimaryKey(DivisionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByQBE(
    Boolean isParent, Integer parent,
    Boolean isIsActive, Boolean isActive,
    Integer order
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
