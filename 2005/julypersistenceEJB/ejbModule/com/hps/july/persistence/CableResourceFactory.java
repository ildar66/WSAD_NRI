package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CableResourceFactory
 * @generated
 */
public class CableResourceFactory extends AbstractEJBFactory {
	/**
	 * CableResourceFactory
	 * @generated
	 */
	public CableResourceFactory() {
		super();
	}
	/**
	 * _acquireCableResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.CableResourceHome _acquireCableResourceHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.CableResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireCableResourceHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.CableResourceHome acquireCableResourceHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.CableResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/CableResource";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.CableResourceHome.class;
	}
	/**
	 * resetCableResourceHome
	 * @generated
	 */
	public void resetCableResourceHome() {
		resetEJBHome();
	}
	/**
	 * setCableResourceHome
	 * @generated
	 */
	public void setCableResourceHome(
		com.hps.july.persistence.CableResourceHome home) {
		setEJBHome(home);
	}
	/**
	 * findResourcesByLeasePayRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeasePayRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireCableResourceHome().findResourcesByLeasePayRules(
			listContracts);
	}
	/**
	 * findByQBE4
	 * @generated
	 */
	public java.util.Enumeration findByQBE4(
		java.lang.Boolean isType,
		java.lang.Integer typeId,
		java.lang.Boolean isSubType,
		java.lang.Integer subTypeId,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireCableResourceHome().findByQBE4(
			isType,
			typeId,
			isSubType,
			subTypeId,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.CableResource create(
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
		int argCableDiamId)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCableResourceHome().create(
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
			argCableDiamId);
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
		return _acquireCableResourceHome().findResourcesByQBE2(
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
		return _acquireCableResourceHome().findResourcesByQBE(
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
		return _acquireCableResourceHome().findResourcesByQBE3(
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
		return _acquireCableResourceHome().findResourcesForBrowse(
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
		return _acquireCableResourceHome().findActiveResourceBySubtype(
			argSubtype,
			argActive);
	}
	/**
	 * findResourcesByLeaseChargeRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeaseChargeRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireCableResourceHome().findResourcesByLeaseChargeRules(
			listContracts);
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireCableResourceHome()
			.findResourceByReglamentOrderByCodeAsc(
			argReglament);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.CableResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCableResourceHome().create(
			resource,
			argUnit,
			argSubtype);
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
		java.lang.Integer active,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireCableResourceHome().findResourcesByQBE4(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			active,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.CableResource create(int argResource)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCableResourceHome().create(argResource);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.CableResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireCableResourceHome().findByPrimaryKey(key);
	}
}
