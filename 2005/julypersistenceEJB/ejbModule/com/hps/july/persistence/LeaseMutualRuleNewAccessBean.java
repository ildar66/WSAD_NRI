package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * LeaseMutualRuleNewAccessBean
 * @generated
 */
public class LeaseMutualRuleNewAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.LeaseMutualRuleNewAccessBeanData {
	/**
	 * @generated
	 */
	private LeaseMutualRuleNew __ejbRef;
	/**
	 * @generated
	 */
	private java.lang.Integer initKey_resource_resource;
	/**
	 * @generated
	 */
	private java.lang.Integer initKey_reglament_leaseDocument;
	/**
	 * getRateType
	 * @generated
	 */
	public java.lang.Integer getRateType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("rateType")));
	}
	/**
	 * setRateType
	 * @generated
	 */
	public void setRateType(java.lang.Integer newValue) {
		__setCache("rateType", newValue);
	}
	/**
	 * getPaydaterule
	 * @generated
	 */
	public java.lang.String getPaydaterule()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("paydaterule")));
	}
	/**
	 * setPaydaterule
	 * @generated
	 */
	public void setPaydaterule(java.lang.String newValue) {
		__setCache("paydaterule", newValue);
	}
	/**
	 * getReglamentKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseDocumentKey getReglamentKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.LeaseDocumentKey) __getCache("reglamentKey")));
	}
	/**
	 * getChargedaterule
	 * @generated
	 */
	public java.lang.String getChargedaterule()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("chargedaterule")));
	}
	/**
	 * setChargedaterule
	 * @generated
	 */
	public void setChargedaterule(java.lang.String newValue) {
		__setCache("chargedaterule", newValue);
	}
	/**
	 * getResourceKey
	 * @generated
	 */
	public com.hps.july.persistence.ResourceKey getResourceKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com.hps.july.persistence.ResourceKey) __getCache("resourceKey")));
	}
	/**
	 * getDopchargdatrul
	 * @generated
	 */
	public boolean getDopchargdatrul()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("dopchargdatrul")).booleanValue());
	}
	/**
	 * setDopchargdatrul
	 * @generated
	 */
	public void setDopchargdatrul(boolean newValue) {
		__setCache("dopchargdatrul", new Boolean(newValue));
	}
	/**
	 * setInitKey_resource_resource
	 * @generated
	 */
	public void setInitKey_resource_resource(java.lang.Integer newValue) {
		this.initKey_resource_resource = (newValue);
	}
	/**
	 * setInitKey_reglament_leaseDocument
	 * @generated
	 */
	public void setInitKey_reglament_leaseDocument(
		java.lang.Integer newValue) {
		this.initKey_reglament_leaseDocument = (newValue);
	}
	/**
	 * LeaseMutualRuleNewAccessBean
	 * @generated
	 */
	public LeaseMutualRuleNewAccessBean() {
		super();
	}
	/**
	 * LeaseMutualRuleNewAccessBean
	 * @generated
	 */
	public LeaseMutualRuleNewAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence/LeaseMutualRuleNew";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.LeaseMutualRuleNewHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence
				.LeaseMutualRuleNewHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence.LeaseMutualRuleNewHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.LeaseMutualRuleNew ejbRef()
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
						.LeaseMutualRuleNew) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.LeaseMutualRuleNew.class);

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

		com.hps.july.persistence.LeaseMutualRuleNewKey key =
			keyFromFields(
				initKey_resource_resource,
				initKey_reglament_leaseDocument);
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
			com.hps.july.persistence.LeaseMutualRuleNewKey pKey =
				(com.hps.july.persistence.LeaseMutualRuleNewKey) this
					.__getKey();
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
	private com.hps.july.persistence.LeaseMutualRuleNewKey keyFromFields(
		java.lang.Integer f0,
		java.lang.Integer f1) {
		com.hps.july.persistence.LeaseMutualRuleNewKey keyClass =
			new com.hps.july.persistence.LeaseMutualRuleNewKey();
		keyClass.resource_resource = f0;
		keyClass.reglament_leaseDocument = f1;
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
	 * findLeaseMutualRuleNewsByReglamentOrderByResourceAsc
	 * @generated
	 */
	public java
		.util
		.Enumeration findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(
			java.lang.Integer argreglament)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseMutualRuleNewHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(
				argreglament);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findLeaseMutualRuleNewsByResource
	 * @generated
	 */
	public java.util.Enumeration findLeaseMutualRuleNewsByResource(
		com.hps.july.persistence.ResourceKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseMutualRuleNewHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findLeaseMutualRuleNewsByResource(inKey);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findLeaseMutualRulesByReglament
	 * @generated
	 */
	public java.util.Enumeration findLeaseMutualRulesByReglament(
		com.hps.july.persistence.LeaseDocumentKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseMutualRuleNewHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findLeaseMutualRulesByReglament(inKey);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * LeaseMutualRuleNewAccessBean
	 * @generated
	 */
	public LeaseMutualRuleNewAccessBean(
		java.lang.Integer argReglament,
		java.lang.Integer argResource,
		java.lang.String argChargeDateRule,
		java.lang.String argPayDateRule,
		boolean argDopChargeDateRule,
		int argRateType)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argReglament,
				argResource,
				argChargeDateRule,
				argPayDateRule,
				argDopChargeDateRule,
				argRateType);
	}
	/**
	 * getResource
	 * @generated
	 */
	public com.hps.july.persistence.ResourceAccessBean getResource()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Resource localEJBRef = ejbRef().getResource();
		if (localEJBRef != null)
			return new com.hps.july.persistence.ResourceAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * getReglament
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseMutualReglamentAccessBean getReglament()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.LeaseMutualReglament localEJBRef =
			ejbRef().getReglament();
		if (localEJBRef != null)
			return new com.hps.july.persistence.LeaseMutualReglamentAccessBean(
				localEJBRef);
		else
			return null;
	}
}
