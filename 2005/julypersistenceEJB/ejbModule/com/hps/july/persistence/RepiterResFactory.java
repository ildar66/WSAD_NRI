package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * RepiterResFactory
 * @generated
 */
public class RepiterResFactory extends AbstractEJBFactory {
	/**
	 * RepiterResFactory
	 * @generated
	 */
	public RepiterResFactory() {
		super();
	}
	/**
	 * _acquireRepiterResHome
	 * @generated
	 */
	protected com.hps.july.persistence.RepiterResHome _acquireRepiterResHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.RepiterResHome) _acquireEJBHome();
	}
	/**
	 * acquireRepiterResHome
	 * @generated
	 */
	public com.hps.july.persistence.RepiterResHome acquireRepiterResHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.RepiterResHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/RepiterRes";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.RepiterResHome.class;
	}
	/**
	 * resetRepiterResHome
	 * @generated
	 */
	public void resetRepiterResHome() {
		resetEJBHome();
	}
	/**
	 * setRepiterResHome
	 * @generated
	 */
	public void setRepiterResHome(
		com.hps.july.persistence.RepiterResHome home) {
		setEJBHome(home);
	}
	/**
	 * findResourcesByLeasePayRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeasePayRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourcesByLeasePayRules(
			listContracts);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RepiterRes create(
		int argResource,
		java.lang.String argName,
		java.lang.String argModel,
		java.lang.String argNotes,
		java.lang.Boolean argComplect,
		java.lang.String argCountpolicy,
		java.lang.Boolean argBoxable,
		java.lang.Boolean argPriceable,
		java.lang.Boolean argComplectpart,
		java.lang.Boolean argActive,
		int argSubType,
		java.lang.Boolean argIslinear)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRepiterResHome().create(
			argResource,
			argName,
			argModel,
			argNotes,
			argComplect,
			argCountpolicy,
			argBoxable,
			argPriceable,
			argComplectpart,
			argActive,
			argSubType,
			argIslinear);
	}
	/**
	 * findResourcesByQBE2
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE2(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourcesByQBE2(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			isManufacturer,
			manufacturer,
			isManucode,
			manucode,
			order);
	}
	/**
	 * findResourcesByQBE
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourcesByQBE(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			order);
	}
	/**
	 * findResourcesByQBE3
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE3(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Integer connected,
		java.lang.Integer owner,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourcesByQBE3(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			isManufacturer,
			manufacturer,
			isManucode,
			manucode,
			connected,
			owner,
			order);
	}
	/**
	 * findResourcesByQBE4
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE4(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Boolean IsIslinear,
		java.lang.Boolean islinear,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourcesByQBE4(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			isManufacturer,
			manufacturer,
			isManucode,
			manucode,
			IsIslinear,
			islinear,
			order);
	}
	/**
	 * findResourcesForBrowse
	 * @generated
	 */
	public java.util.Enumeration findResourcesForBrowse(
		java.lang.Boolean isResourcetype,
		java.lang.Integer resourcetype,
		java.lang.Boolean isResourcesubtype,
		java.lang.Integer resourcesubtype,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.String active,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourcesForBrowse(
			isResourcetype,
			resourcetype,
			isResourcesubtype,
			resourcesubtype,
			isModel,
			model,
			isName,
			name,
			isManufacturer,
			manufacturer,
			isManucode,
			manucode,
			active,
			order);
	}
	/**
	 * findActiveResourceBySubtype
	 * @generated
	 */
	public java.util.Enumeration findActiveResourceBySubtype(
		java.lang.Integer argSubtype,
		java.lang.String argActive)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findActiveResourceBySubtype(
			argSubtype,
			argActive);
	}
	/**
	 * findResourceByBrowse1
	 * @generated
	 */
	public java.util.Enumeration findResourceByBrowse1(
		java.lang.Boolean isType,
		java.lang.Integer type,
		java.lang.Boolean isSubtype,
		java.lang.Integer subtype,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isManu,
		java.lang.String manu,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourceByBrowse1(
			isType,
			type,
			isSubtype,
			subtype,
			isModel,
			model,
			isManu,
			manu,
			order);
	}
	/**
	 * findResourcesByLeaseChargeRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeaseChargeRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourcesByLeaseChargeRules(
			listContracts);
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findResourceByReglamentOrderByCodeAsc(
			argReglament);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RepiterRes create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRepiterResHome().create(resource, argUnit, argSubtype);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RepiterRes create(int argResource)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRepiterResHome().create(argResource);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.RepiterRes findByPrimaryKey(
		com.hps.july.persistence.ResourceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRepiterResHome().findByPrimaryKey(key);
	}
}
