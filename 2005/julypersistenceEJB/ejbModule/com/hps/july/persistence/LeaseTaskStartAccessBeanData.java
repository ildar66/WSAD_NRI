/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface LeaseTaskStartAccessBeanData {



    public com.hps.july.persistence.WorkerKey getEconomistWorkerKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public java.lang.String getTasktype() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setTasktype( java.lang.String newValue );
    public java.sql.Timestamp getEnddate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setEnddate( java.sql.Timestamp newValue );
    public java.sql.Date getDate2() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setDate2( java.sql.Date newValue );
    public java.sql.Date getDate1() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setDate1( java.sql.Date newValue );
    public com.hps.july.persistence.OperatorKey getStartOperatorKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public int getTaskstart() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public java.sql.Timestamp getStartdate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setStartdate( java.sql.Timestamp newValue );
    public com.hps.july.persistence.LeaseDocumentKey getLeasedocumentKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;

}
