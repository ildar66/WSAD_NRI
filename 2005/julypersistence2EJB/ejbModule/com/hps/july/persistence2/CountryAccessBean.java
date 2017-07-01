package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CountryAccessBean
 * @generated
 */
public class CountryAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.CountryAccessBeanData {
	/**
	 * @generated
	 */
	private Country __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_country;
	/**
	 * getName
	 * @generated
	 */
	public java.lang.String getName()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("name")));
	}
	/**
	 * setName
	 * @generated
	 */
	public void setName(java.lang.String newValue) {
		__setCache("name", newValue);
	}
	/**
	 * getCcode
	 * @generated
	 */
	public java.math.BigDecimal getCcode()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("ccode")));
	}
	/**
	 * setCcode
	 * @generated
	 */
	public void setCcode(java.math.BigDecimal newValue) {
		__setCache("ccode", newValue);
	}
	/**
	 * getCountry
	 * @generated
	 */
	public int getCountry()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("country")).intValue());
	}
	/**
	 * setInitKey_country
	 * @generated
	 */
	public void setInitKey_country(int newValue) {
		this.initKey_country = (newValue);
	}
	/**
	 * CountryAccessBean
	 * @generated
	 */
	public CountryAccessBean() {
		super();
	}
	/**
	 * CountryAccessBean
	 * @generated
	 */
	public CountryAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/CountryHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.CountryHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com.hps.july.persistence2.CountryHome) PortableRemoteObject.narrow(
			getHome(),
			com.hps.july.persistence2.CountryHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.Country ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.persistence2
						.Country) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.Country.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		com.hps.july.persistence2.CountryKey key =
			keyFromFields(initKey_country);
		ejbRef = ejbHome().findByPrimaryKey(key);
	}
	/**
	 * instantiateEJBByPrimaryKey
	 * @generated
	 */
	protected boolean instantiateEJBByPrimaryKey()
		throws
			javax.ejb.CreateException,
			java.rmi.RemoteException,
			javax.naming.NamingException {
		boolean result = false;

		if (ejbRef() != null)
			return true;

		try {
			com.hps.july.persistence2.CountryKey pKey =
				(com.hps.july.persistence2.CountryKey) this.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * keyFromFields
	 * @generated
	 */
	private com.hps.july.persistence2.CountryKey keyFromFields(int f0) {
		com.hps.july.persistence2.CountryKey keyClass =
			new com.hps.july.persistence2.CountryKey();
		keyClass.country = f0;
		return keyClass;
	}
	/**
	 * refreshCopyHelper
	 * @generated
	 */
	public void refreshCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		refreshCopyHelper(ejbRef());
	}
	/**
	 * commitCopyHelper
	 * @generated
	 */
	public void commitCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		commitCopyHelper(ejbRef());
	}
	/**
	 * CountryAccessBean
	 * @generated
	 */
	public CountryAccessBean(
		int argCountry,
		java.lang.String argName,
		java.math.BigDecimal argCCode)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argCountry, argName, argCCode);
	}
}
