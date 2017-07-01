package com.hps.july.persistence2;
/**
 * Group2ResourceAccessBeanData
 * @generated
 */
public interface Group2ResourceAccessBeanData {
	/**
	 * getGroupid
	 * @generated
	 */
	public int getGroupid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException;
	/**
	 * getResource
	 * @generated
	 */
	public int getResource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException;
	/**
	 * getQty
	 * @generated
	 */
	public java.math.BigDecimal getQty()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException;
	/**
	 * setQty
	 * @generated
	 */
	public void setQty(java.math.BigDecimal newValue);
}
