/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface SiteDocFileAccessBeanData {



    public java.sql.Timestamp getFilemodified() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setFilemodified( java.sql.Timestamp newValue );
    public java.sql.Timestamp getFilecreated() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setFilecreated( java.sql.Timestamp newValue );
    public int getSitedocfile() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public java.lang.String getSitedocfilename() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setSitedocfilename( java.lang.String newValue );
    public com.hps.july.persistence.SiteDocKey getSiteDocKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public java.lang.String getNote() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setNote( java.lang.String newValue );
    public java.lang.Integer getFilesize() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setFilesize( java.lang.Integer newValue );
    public java.sql.Date getSitedocfiledate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setSitedocfiledate( java.sql.Date newValue );

}
