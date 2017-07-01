package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AntennaResourceFactory
 * @generated
 */
public class AntennaResourceFactory extends AbstractEJBFactory {
	/**
	 * AntennaResourceFactory
	 * @generated
	 */
	public AntennaResourceFactory() {
		super();
	}
	/**
	 * _acquireAntennaResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.AntennaResourceHome _acquireAntennaResourceHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.AntennaResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireAntennaResourceHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.AntennaResourceHome acquireAntennaResourceHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.AntennaResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/AntennaResource";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AntennaResourceHome.class;
	}
	/**
	 * resetAntennaResourceHome
	 * @generated
	 */
	public void resetAntennaResourceHome() {
		resetEJBHome();
	}
	/**
	 * setAntennaResourceHome
	 * @generated
	 */
	public void setAntennaResourceHome(
		com.hps.july.persistence.AntennaResourceHome home) {
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
		return _acquireAntennaResourceHome().findResourcesByQBE3(
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
	public com.hps.july.persistence.AntennaResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAntennaResourceHome().findByPrimaryKey(key);
	}
	/**
	 * findAntennaResourceForBrowse
	 * @generated
	 */
	public java.util.Enumeration findAntennaResourceForBrowse(
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
		java.lang.String polarization,
		java.lang.Boolean isRange,
		java.lang.Integer[] ranges,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAntennaResourceHome().findAntennaResourceForBrowse(
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
			polarization,
			isRange,
			ranges,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AntennaResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAntennaResourceHome().create(
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
		return _acquireAntennaResourceHome().findResourcesByLeasePayRules(
			listContracts);
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAntennaResourceHome()
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
		return _acquireAntennaResourceHome().findResourcesByQBE2(
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
		return _acquireAntennaResourceHome().findActiveResourceBySubtype(
			argSubtype,
			argActive);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AntennaResource create(
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
		return _acquireAntennaResourceHome().create(
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
	 * findResourceByBrowse1
	 * @generated
	 */
	public java.util.Enumeration findResourceByBrowse1(
		java.lang.Boolean isType,
		java.lang.Integer type,
		java.lang.Boolean isSubtype,
		java.lang.Integer subtype,
		java.lang.Integer[] ranges,
		java.lang.String polar,
		java.lang.String active,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isManu,
		java.lang.String manu,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAntennaResourceHome().findResourceByBrowse1(
			isType,
			type,
			isSubtype,
			subtype,
			ranges,
			polar,
			active,
			isModel,
			model,
			isManu,
			manu,
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
		return _acquireAntennaResourceHome().findResourcesByQBE(
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
		return _acquireAntennaResourceHome().findResourcesByLeaseChargeRules(
			listContracts);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AntennaResource create(int argResource)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAntennaResourceHome().create(argResource);
	}
}
