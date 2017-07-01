package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Party extends javax.ejb.EJBObject {

/**
 * 
 * @return java.util.ArrayList
 * @param isSubType java.lang.Boolean
 * @param resourceSubType java.lang.Integer
 * @param isModel java.lang.Boolean
 * @param model java.lang.String
 * @param isName java.lang.Boolean
 * @param name java.lang.String
 * @param isManufacturer java.lang.Boolean
 * @param manufacturer java.lang.Integer
 * @param isManucode java.lang.Boolean
 * @param manucode java.lang.String
 * @param connected java.lang.Integer
 * @param owner java.lang.Integer
 * @param order java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
java.util.ArrayList findPartyByQBE2(java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOwner() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getParty() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getResource() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newOwner java.lang.Integer
 * @exception String The exception description.
 */
void setOwner(java.lang.Integer newOwner) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newParty java.lang.String
 * @exception String The exception description.
 */
void setParty(java.lang.String newParty) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newResource java.lang.Integer
 * @exception String The exception description.
 */
void setResource(java.lang.Integer newResource) throws java.rmi.RemoteException;
}
