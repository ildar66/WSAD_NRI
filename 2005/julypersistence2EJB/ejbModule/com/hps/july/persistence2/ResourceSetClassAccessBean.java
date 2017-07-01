package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * ResourceSetClassAccessBean
 * @generated
 */
public class ResourceSetClassAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.ResourceSetClassAccessBeanData {
	/**
	 * @generated
	 */
	private ResourceSetClass __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_classid;
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
	 * getClassname
	 * @generated
	 */
	public java.lang.String getClassname()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("classname")));
	}
	/**
	 * setClassname
	 * @generated
	 */
	public void setClassname(java.lang.String newValue) {
		__setCache("classname", newValue);
	}
	/**
	 * setInitKey_classid
	 * @generated
	 */
	public void setInitKey_classid(int newValue) {
		this.initKey_classid = (newValue);
	}
	/**
	 * ResourceSetClassAccessBean
	 * @generated
	 */
	public ResourceSetClassAccessBean() {
		super();
	}
	/**
	 * ResourceSetClassAccessBean
	 * @generated
	 */
	public ResourceSetClassAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ResourceSetClassHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.ResourceSetClassHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.ResourceSetClassHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.ResourceSetClassHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.ResourceSetClass ejbRef()
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
						.ResourceSetClass) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.ResourceSetClass.class);

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

		com.hps.july.persistence2.ResourceSetClassKey key =
			keyFromFields(initKey_classid);
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
			com.hps.july.persistence2.ResourceSetClassKey pKey =
				(com.hps.july.persistence2.ResourceSetClassKey) this.__getKey();
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
	private com.hps.july.persistence2.ResourceSetClassKey keyFromFields(
		int f0) {
		com.hps.july.persistence2.ResourceSetClassKey keyClass =
			new com.hps.july.persistence2.ResourceSetClassKey();
		keyClass.classid = f0;
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
	 * ResourceSetClassAccessBean
	 * @generated
	 */
	public ResourceSetClassAccessBean(
		int argClassid,
		java.lang.String argClassname)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argClassid, argClassname);
	}
}
