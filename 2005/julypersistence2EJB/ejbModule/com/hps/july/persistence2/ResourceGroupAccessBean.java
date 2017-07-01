package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * ResourceGroupAccessBean
 * @generated
 */
public class ResourceGroupAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.ResourceGroupAccessBeanData {
	/**
	 * @generated
	 */
	private ResourceGroup __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_groupid;
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
	 * getClassid
	 * @generated
	 */
	public int getClassid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("classid")).intValue());
	}
	/**
	 * setClassid
	 * @generated
	 */
	public void setClassid(int newValue) {
		__setCache("classid", new Integer(newValue));
	}
	/**
	 * setInitKey_groupid
	 * @generated
	 */
	public void setInitKey_groupid(int newValue) {
		this.initKey_groupid = (newValue);
	}
	/**
	 * ResourceGroupAccessBean
	 * @generated
	 */
	public ResourceGroupAccessBean() {
		super();
	}
	/**
	 * ResourceGroupAccessBean
	 * @generated
	 */
	public ResourceGroupAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ResourceGroupHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.ResourceGroupHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.ResourceGroupHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.ResourceGroupHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.ResourceGroup ejbRef()
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
						.ResourceGroup) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.ResourceGroup.class);

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

		com.hps.july.persistence2.ResourceGroupKey key =
			keyFromFields(initKey_groupid);
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
			com.hps.july.persistence2.ResourceGroupKey pKey =
				(com.hps.july.persistence2.ResourceGroupKey) this.__getKey();
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
	private com.hps.july.persistence2.ResourceGroupKey keyFromFields(int f0) {
		com.hps.july.persistence2.ResourceGroupKey keyClass =
			new com.hps.july.persistence2.ResourceGroupKey();
		keyClass.groupid = f0;
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
	 * ResourceGroupAccessBean
	 * @generated
	 */
	public ResourceGroupAccessBean(int groupid)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(groupid);
	}
}
