/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface LeaseCalcRateAccessBeanData {



    public java.lang.Boolean getByhand() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setByhand( java.lang.Boolean newValue );
    public com.hps.july.persistence.CurrencyKey getCurrencyKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public com.hps.july.persistence.LeaseDocumentKey getActKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public com.hps.july.persistence.LeaseDocPositionKey getDocpositionKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public java.math.BigDecimal getRate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setRate( java.math.BigDecimal newValue );

}