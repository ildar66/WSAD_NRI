package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface CompanyHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Company
 * @param argCompany int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Company create(int argCompany) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Company
 * @param argCompany int
 * @param argName java.lang.String
 * @param argShortName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Company create(int argCompany, java.lang.String argName, java.lang.String argShortName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Company
 * @param key com.hps.july.persistence.CompanyKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Company findByPrimaryKey(com.hps.july.persistence.CompanyKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findOrderByNameDesc() throws java.rmi.RemoteException, javax.ejb.FinderException;
}
