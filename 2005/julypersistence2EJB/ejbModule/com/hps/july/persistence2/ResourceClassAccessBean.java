package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * ResourceClassAccessBean
 * @generated
 */
public class ResourceClassAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.ResourceClassAccessBeanData {
	/**
	 * @generated
	 */
	private ResourceClass __ejbRef;
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
	 * ResourceClassAccessBean
	 * @generated
	 */
	public ResourceClassAccessBean() {
		super();
	}
	/**
	 * ResourceClassAccessBean
	 * @generated
	 */
	public ResourceClassAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ResourceClassHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.ResourceClassHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.ResourceClassHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.ResourceClassHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.ResourceClass ejbRef()
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
						.ResourceClass) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.ResourceClass.class);

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

		com.hps.july.persistence2.ResourceClassKey key =
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
			com.hps.july.persistence2.ResourceClassKey pKey =
				(com.hps.july.persistence2.ResourceClassKey) this.__getKey();
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
	private com.hps.july.persistence2.ResourceClassKey keyFromFields(int f0) {
		com.hps.july.persistence2.ResourceClassKey keyClass =
			new com.hps.july.persistence2.ResourceClassKey();
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
	 * ResourceClassAccessBean
	 * @generated
	 */
	public ResourceClassAccessBean(
		int argClassid,
		java.lang.String argClassname)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argClassid, argClassname);
	}
}
