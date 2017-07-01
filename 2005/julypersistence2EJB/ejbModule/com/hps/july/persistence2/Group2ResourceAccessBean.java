package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * Group2ResourceAccessBean
 * @generated
 */
public class Group2ResourceAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.Group2ResourceAccessBeanData {
	/**
	 * @generated
	 */
	private Group2Resource __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_groupid;
	/**
	 * @generated
	 */
	private int initKey_resource;
	/**
	 * getGroupid
	 * @generated
	 */
	public int getGroupid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("groupid")).intValue());
	}
	/**
	 * getResource
	 * @generated
	 */
	public int getResource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("resource")).intValue());
	}
	/**
	 * getQty
	 * @generated
	 */
	public java.math.BigDecimal getQty()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("qty")));
	}
	/**
	 * setQty
	 * @generated
	 */
	public void setQty(java.math.BigDecimal newValue) {
		__setCache("qty", newValue);
	}
	/**
	 * setInitKey_groupid
	 * @generated
	 */
	public void setInitKey_groupid(int newValue) {
		this.initKey_groupid = (newValue);
	}
	/**
	 * setInitKey_resource
	 * @generated
	 */
	public void setInitKey_resource(int newValue) {
		this.initKey_resource = (newValue);
	}
	/**
	 * Group2ResourceAccessBean
	 * @generated
	 */
	public Group2ResourceAccessBean() {
		super();
	}
	/**
	 * Group2ResourceAccessBean
	 * @generated
	 */
	public Group2ResourceAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/Group2ResourceHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.Group2ResourceHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.Group2ResourceHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.Group2ResourceHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.Group2Resource ejbRef()
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
						.Group2Resource) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.Group2Resource.class);

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

		com.hps.july.persistence2.Group2ResourceKey key =
			keyFromFields(initKey_groupid, initKey_resource);
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
			com.hps.july.persistence2.Group2ResourceKey pKey =
				(com.hps.july.persistence2.Group2ResourceKey) this.__getKey();
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
	private com.hps.july.persistence2.Group2ResourceKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.persistence2.Group2ResourceKey keyClass =
			new com.hps.july.persistence2.Group2ResourceKey();
		keyClass.groupid = f0;
		keyClass.resource = f1;
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
	 * Group2ResourceAccessBean
	 * @generated
	 */
	public Group2ResourceAccessBean(
		int groupid,
		int resource,
		java.math.BigDecimal qty)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(groupid, resource, qty);
	}
}
