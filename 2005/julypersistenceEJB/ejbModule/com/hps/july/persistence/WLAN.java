package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface WLAN extends EquipmentSet {

/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getNumber() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setNumber(int newValue) throws java.rmi.RemoteException;
}
