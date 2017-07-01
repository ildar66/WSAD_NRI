package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SiteDocFileBLOB extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedocfile() throws java.rmi.RemoteException;
/**
 * Getter method for sitedocfilebody
 * @return byte[]
 * @exception java.rmi.RemoteException The exception description.
 */
byte[] getSitedocfilebody() throws java.rmi.RemoteException;
/**
 * Setter method for sitedocfilebody
 * @param newValue byte[]
 * @exception java.rmi.RemoteException The exception description.
 */
void setSitedocfilebody(byte[] newValue) throws java.rmi.RemoteException;
}
