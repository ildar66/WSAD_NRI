/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface SuperRegionAccAccessBeanData {



    public com.hps.july.persistence.SuperRegionKey getSuperregionKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public com.hps.july.persistence.OperatorKey getOperatorKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public boolean getEditfact() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setEditfact( boolean newValue );
    public boolean getViewfact() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setViewfact( boolean newValue );
    public boolean getEditplan() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setEditplan( boolean newValue );
    public int getAccessid() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public boolean getViewplan() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setViewplan( boolean newValue );

	/**
	 * getEditarenda
	 * @generated
	 */
	public java.lang.Boolean getEditarenda()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException;
	/**
	 * setEditarenda
	 * @generated
	 */
	public void setEditarenda(java.lang.Boolean newValue);
	/**
	 * getViewarenda
	 * @generated
	 */
	public java.lang.Boolean getViewarenda()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException;
	/**
	 * setViewarenda
	 * @generated
	 */
	public void setViewarenda(java.lang.Boolean newValue);
}
