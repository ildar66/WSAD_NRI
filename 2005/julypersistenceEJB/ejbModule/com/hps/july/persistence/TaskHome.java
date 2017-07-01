package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface TaskHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Task
 * @param argTask int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Task create(int argTask) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Task
 * @param argTask int
 * @param argName java.lang.String
 * @param ctx java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Task create(int argTask, java.lang.String argName, java.lang.String ctx) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Task
 * @param key com.hps.july.persistence.TaskKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Task findByPrimaryKey(com.hps.july.persistence.TaskKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
