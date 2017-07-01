package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface BeenetFacade extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param beenetid java.lang.String
 * @param categid int
 * @param position int
 * @param equipment int []
 * @exception String The exception description.
 */
void createBeenet(java.lang.String beenetid, int categid, int position, int [] equipment) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param beenetid java.lang.String
 * @exception String The exception description.
 */
void deleteBeenet(java.lang.String beenetid) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param beenetid java.lang.String
 * @param categid int
 * @param equipment int []
 * @exception String The exception description.
 */
void updateBeenet(java.lang.String beenetid, int categid, int [] equipment) throws java.rmi.RemoteException;
}
