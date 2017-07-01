package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: Country
 */
public interface CountryHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: Country
	 */
	public com.hps.july.persistence2.Country findByPrimaryKey(
		com.hps.july.persistence2.CountryKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence2.Country create(
		int argCountry,
		String argName,
		java.math.BigDecimal argCCode)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
