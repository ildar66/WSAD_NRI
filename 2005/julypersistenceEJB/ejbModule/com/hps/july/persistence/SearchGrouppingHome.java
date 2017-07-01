package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SearchGrouppingHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.SearchGroupping
 * @param argSearchGroupping int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.SearchGroupping create(int argSearchGroupping) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.SearchGroupping
 * @param argSearchGroupping int
 * @param argGroup java.lang.Integer
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SearchGroupping create(int argSearchGroupping, java.lang.Integer argGroup, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SearchGroupping
 * @param key com.hps.july.persistence.SearchGrouppingKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SearchGroupping findByPrimaryKey(com.hps.july.persistence.SearchGrouppingKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSearchGrouppingBySearchGroup(com.hps.july.persistence.SearchGroupKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
