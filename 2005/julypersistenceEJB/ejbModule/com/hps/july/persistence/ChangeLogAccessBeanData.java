/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface ChangeLogAccessBeanData {



    public java.sql.Timestamp getRecdate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setRecdate( java.sql.Timestamp newValue );
    public short getObjtype() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setObjtype( short newValue );
    public java.lang.String getEventtype() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setEventtype( java.lang.String newValue );
    public int getObjid() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setObjid( int newValue );
    public int getLogid() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public com.hps.july.persistence.PeopleKey getPeopleKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;

}
