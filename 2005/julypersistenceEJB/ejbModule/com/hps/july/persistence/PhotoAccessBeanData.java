/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface PhotoAccessBeanData {



    public java.lang.String getDescription() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setDescription( java.lang.String newValue );
    public java.sql.Date getDate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setDate( java.sql.Date newValue );
    public com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public int getPhoto() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setPhoto( int newValue );
    public com.hps.july.persistence.WorkerKey getPhotographerKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;

}
