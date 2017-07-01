package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ResourceFactory
 * @generated
 */
public class ResourceFactory extends AbstractEJBFactory {
	/**
	 * ResourceFactory
	 * @generated
	 */
	public ResourceFactory() {
		super();
	}
	/**
	 * _acquireResourceHome
	 * @generated
	 */
	protected com.hps.july.persistence.ResourceHome _acquireResourceHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.ResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireResourceHome
	 * @generated
	 */
	public com.hps.july.persistence.ResourceHome acquireResourceHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.ResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Resource";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.ResourceHome.class;
	}
	/**
	 * resetResourceHome
	 * @generated
	 */
	public void resetResourceHome() {
		resetEJBHome();
	}
	/**
	 * setResourceHome
	 * @generated
	 */
	public void setResourceHome(com.hps.july.persistence.ResourceHome home) {
		setEJBHome(home);
	}
	/**
	 * findResourcesByLeasePayRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeasePayRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceHome().findResourcesByLeasePayRules(
			listContracts);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Resource create(
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
		int argResourceClass2)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceHome().create(
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
			argResourceClass2);
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
		return _acquireResourceHome().findResourcesByQBE2(
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
		return _acquireResourceHome().findResourcesByQBE(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			order);
	}
	/**
	 * findResourceBySubtype
	 * @generated
	 */
	public java.util.Enumeration findResourceBySubtype(
		com.hps.july.persistence.ResourceSubTypeKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceHome().findResourceBySubtype(inKey);
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
		return _acquireResourceHome().findResourcesByQBE3(
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
		return _acquireResourceHome().findResourcesForBrowse(
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
		return _acquireResourceHome().findActiveResourceBySubtype(
			argSubtype,
			argActive);
	}
	/**
	 * findResourcesByUnit
	 * @generated
	 */
	public java.util.Enumeration findResourcesByUnit(
		com.hps.july.persistence.UnitKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceHome().findResourcesByUnit(inKey);
	}
	/**
	 * findResourcesByLeaseChargeRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeaseChargeRules(
		java.util.Vector listContracts)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceHome().findResourcesByLeaseChargeRules(
			listContracts);
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceHome().findResourceByReglamentOrderByCodeAsc(
			argReglament);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Resource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceHome().create(resource, argUnit, argSubtype);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Resource create(int argResource)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceHome().create(argResource);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Resource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceHome().findByPrimaryKey(key);
	}
}
