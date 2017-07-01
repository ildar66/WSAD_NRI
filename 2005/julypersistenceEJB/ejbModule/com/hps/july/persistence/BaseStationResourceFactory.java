package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * BaseStationResourceFactory
 * @generated
 */
public class BaseStationResourceFactory extends AbstractEJBFactory {
	/**
	 * BaseStationResourceFactory
	 * @generated
	 */
	public BaseStationResourceFactory() {
		super();
	}
	/**
	 * _acquireBaseStationResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.BaseStationResourceHome _acquireBaseStationResourceHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.BaseStationResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireBaseStationResourceHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.BaseStationResourceHome acquireBaseStationResourceHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.BaseStationResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/BaseStationResource";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.BaseStationResourceHome.class;
	}
	/**
	 * resetBaseStationResourceHome
	 * @generated
	 */
	public void resetBaseStationResourceHome() {
		resetEJBHome();
	}
	/**
	 * setBaseStationResourceHome
	 * @generated
	 */
	public void setBaseStationResourceHome(
		com.hps.july.persistence.BaseStationResourceHome home) {
		setEJBHome(home);
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
		return _acquireBaseStationResourceHome().findResourcesByQBE3(
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
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.BaseStationResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseStationResourceHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.BaseStationResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireBaseStationResourceHome().create(
			resource,
			argUnit,
			argSubtype);
	}
	/**
	 * findResourcesByLeasePayRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeasePayRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseStationResourceHome().findResourcesByLeasePayRules(
			listContracts);
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseStationResourceHome()
			.findResourceByReglamentOrderByCodeAsc(
			argReglament);
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
		return _acquireBaseStationResourceHome().findResourcesByQBE2(
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
	 * findActiveResourceBySubtype
	 * @generated
	 */
	public java.util.Enumeration findActiveResourceBySubtype(
		java.lang.Integer argSubtype,
		java.lang.String argActive)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseStationResourceHome().findActiveResourceBySubtype(
			argSubtype,
			argActive);
	}
	/**
	 * findBasestationResourceForBowse
	 * @generated
	 */
	public java.util.Enumeration findBasestationResourceForBowse(
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
		java.lang.Boolean isGeneration,
		java.lang.String generation,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseStationResourceHome()
			.findBasestationResourceForBowse(
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
			isGeneration,
			generation,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.BaseStationResource create(
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
		int argSubType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireBaseStationResourceHome().create(
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
			argSubType);
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
		return _acquireBaseStationResourceHome().findResourcesByQBE(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			order);
	}
	/**
	 * findResourcesByLeaseChargeRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeaseChargeRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseStationResourceHome()
			.findResourcesByLeaseChargeRules(
			listContracts);
	}
	/**
	 * findBasestationByQBE
	 * @generated
	 */
	public java.util.Enumeration findBasestationByQBE(
		java.lang.Boolean isType,
		java.lang.Integer type,
		java.lang.Boolean isSubtype,
		java.lang.Integer subtype,
		java.lang.Boolean isGeneration,
		java.lang.String generation,
		java.lang.String active,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isManufacturer,
		java.lang.String manufacturer,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseStationResourceHome().findBasestationByQBE(
			isType,
			type,
			isSubtype,
			subtype,
			isGeneration,
			generation,
			active,
			isModel,
			model,
			isManufacturer,
			manufacturer,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.BaseStationResource create(int argResource)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireBaseStationResourceHome().create(argResource);
	}
}
