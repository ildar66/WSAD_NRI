/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;


public interface NetZoneAccessBeanData {



    public int getNetzone() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setNetzone( int newValue );
    public int getRegionid() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setRegionid( int newValue );
    public java.lang.String getZonecode() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setZonecode( java.lang.String newValue );
    public java.lang.String getName() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException;
    public void setName( java.lang.String newValue );

	/**
	 * getTcode
	 * @generated
	 */
	public java.math.BigDecimal getTcode()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException;
	/**
	 * setTcode
	 * @generated
	 */
	public void setTcode(java.math.BigDecimal newValue);
}
