package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEBankPlatinum extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for address
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAddress() throws java.rmi.RemoteException;
/**
 * Getter method for bik
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBik() throws java.rmi.RemoteException;
/**
 * Getter method for flagworknri
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFlagworknri() throws java.rmi.RemoteException;
/**
 * Getter method for idbanknri
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdbanknri() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getIdbankplatinum() throws java.rmi.RemoteException;
/**
 * Getter method for korbank
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getKorbank() throws java.rmi.RemoteException;
/**
 * Getter method for korschet
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getKorschet() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * Getter method for p_status
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getP_status() throws java.rmi.RemoteException;
/**
 * Getter method for swift
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSwift() throws java.rmi.RemoteException;
/**
 * Setter method for address
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAddress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bik
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBik(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for flagworknri
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFlagworknri(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idbanknri
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdbanknri(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for korbank
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setKorbank(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for korschet
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setKorschet(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for p_status
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setP_status(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for swift
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSwift(java.lang.String newValue) throws java.rmi.RemoteException;
}
