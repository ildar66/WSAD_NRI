/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface AccountAccessBeanData {



    public int getAccount() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setAccount( int newValue );
    public com.hps.july.persistence.OrganizationKey getOrganizationKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public java.lang.String getAccountvalue() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setAccountvalue( java.lang.String newValue );
    public Integer getBankKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public java.lang.Boolean getActive() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setActive( java.lang.Boolean newValue );

	/**
	 * getIdVendorSite
	 * @generated
	 */
	public java.lang.Integer getIdVendorSite() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
	/**
	 * setIdVendorSite
	 * @generated
	 */
	public void setIdVendorSite(java.lang.Integer newValue);
}