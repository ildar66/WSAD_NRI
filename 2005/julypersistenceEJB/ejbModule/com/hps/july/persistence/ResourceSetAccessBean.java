package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * ResourceSetAccessBean
 * @generated
 */
public class ResourceSetAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.ResourceSetAccessBeanData {
	/**
	 * @generated
	 */
	private ResourceSet __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_resourceset;
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
	 * getMainpartKey
	 * @generated
	 */
	public com.hps.july.persistence.ResourceKey getMainpartKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com.hps.july.persistence.ResourceKey) __getCache("mainpartKey")));
	}
	/**
	 * getMainpartqty
	 * @generated
	 */
	public java.math.BigDecimal getMainpartqty()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("mainpartqty")));
	}
	/**
	 * setMainpartqty
	 * @generated
	 */
	public void setMainpartqty(java.math.BigDecimal newValue) {
		__setCache("mainpartqty", newValue);
	}
	/**
	 * getNfsitemid
	 * @generated
	 */
	public java.lang.String getNfsitemid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("nfsitemid")));
	}
	/**
	 * setNfsitemid
	 * @generated
	 */
	public void setNfsitemid(java.lang.String newValue) {
		__setCache("nfsitemid", newValue);
	}
	/**
	 * getType
	 * @generated
	 */
	public java.lang.String getType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("type")));
	}
	/**
	 * setType
	 * @generated
	 */
	public void setType(java.lang.String newValue) {
		__setCache("type", newValue);
	}
	/**
	 * getResourceset
	 * @generated
	 */
	public int getResourceset()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("resourceset")).intValue());
	}
	/**
	 * setResourceset
	 * @generated
	 */
	public void setResourceset(int newValue) {
		__setCache("resourceset", new Integer(newValue));
	}
	/**
	 * getResourcesetclass
	 * @generated
	 */
	public java.lang.Integer getResourcesetclass()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("resourcesetclass")));
	}
	/**
	 * setResourcesetclass
	 * @generated
	 */
	public void setResourcesetclass(java.lang.Integer newValue) {
		__setCache("resourcesetclass", newValue);
	}
	/**
	 * setInitKey_resourceset
	 * @generated
	 */
	public void setInitKey_resourceset(int newValue) {
		this.initKey_resourceset = (newValue);
	}
	/**
	 * ResourceSetAccessBean
	 * @generated
	 */
	public ResourceSetAccessBean() {
		super();
	}
	/**
	 * ResourceSetAccessBean
	 * @generated
	 */
	public ResourceSetAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence/ResourceSet";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.ResourceSetHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence
				.ResourceSetHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence.ResourceSetHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.ResourceSet ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.persistence
						.ResourceSet) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.ResourceSet.class);

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

		com.hps.july.persistence.ResourceSetKey key =
			keyFromFields(initKey_resourceset);
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
			com.hps.july.persistence.ResourceSetKey pKey =
				(com.hps.july.persistence.ResourceSetKey) this.__getKey();
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
	private com.hps.july.persistence.ResourceSetKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceSetKey keyClass =
			new com.hps.july.persistence.ResourceSetKey();
		keyClass.resourceset = f0;
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
	 * ResourceSetAccessBean
	 * @generated
	 */
	public ResourceSetAccessBean(
		int argResourceset,
		java.lang.String argName,
		java.lang.Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		java.lang.String argType)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argResourceset,
				argName,
				argMainPart,
				argMainPartQty,
				argType);
	}
	/**
	 * findResourceSetsBySubtype
	 * @generated
	 */
	public java.util.Enumeration findResourceSetsBySubtype(
		java.lang.Integer argSubtype)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceSetHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourceSetsBySubtype(argSubtype);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourceSetsByMainpart
	 * @generated
	 */
	public java.util.Enumeration findResourceSetsByMainpart(
		com.hps.july.persistence.ResourceKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceSetHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourceSetsByMainpart(inKey);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceSetHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE(
				isSubtypekey,
				subtypeKey,
				isModel,
				model,
				isName,
				name,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * ResourceSetAccessBean
	 * @generated
	 */
	public ResourceSetAccessBean(int argResourceset)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argResourceset);
	}
	/**
	 * getSetParts
	 * @generated
	 */
	public java.util.Enumeration getSetParts()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getSetParts();
	}
	/**
	 * privateSetMainpartKey
	 * @generated
	 */
	public void privateSetMainpartKey(
		com.hps.july.persistence.ResourceKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetMainpartKey(inKey);
	}
	/**
	 * secondaryRemoveSetParts
	 * @generated
	 */
	public void secondaryRemoveSetParts(
		com.hps.july.persistence.ResourceSetPart aSetParts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveSetParts(aSetParts);
	}
	/**
	 * setMainpart
	 * @generated
	 */
	public void setMainpart(com.hps.july.persistence.Resource aMainpart)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setMainpart(aMainpart);
	}
	/**
	 * getMainpart
	 * @generated
	 */
	public com.hps.july.persistence.ResourceAccessBean getMainpart()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Resource localEJBRef = ejbRef().getMainpart();
		if (localEJBRef != null)
			return new com.hps.july.persistence.ResourceAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryAddSetParts
	 * @generated
	 */
	public void secondaryAddSetParts(
		com.hps.july.persistence.ResourceSetPart aSetParts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddSetParts(aSetParts);
	}
	/**
	 * secondarySetMainpart
	 * @generated
	 */
	public void secondarySetMainpart(
		com.hps.july.persistence.Resource aMainpart)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetMainpart(aMainpart);
	}
}
