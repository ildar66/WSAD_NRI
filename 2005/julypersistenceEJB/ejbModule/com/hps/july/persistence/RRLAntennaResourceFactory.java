package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * RRLAntennaResourceFactory
 * @generated
 */
public class RRLAntennaResourceFactory extends AbstractEJBFactory {
	/**
	 * RRLAntennaResourceFactory
	 * @generated
	 */
	public RRLAntennaResourceFactory() {
		super();
	}
	/**
	 * _acquireRRLAntennaResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.RRLAntennaResourceHome _acquireRRLAntennaResourceHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.RRLAntennaResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireRRLAntennaResourceHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.RRLAntennaResourceHome acquireRRLAntennaResourceHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.RRLAntennaResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/RRLAntennaResource";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.RRLAntennaResourceHome.class;
	}
	/**
	 * resetRRLAntennaResourceHome
	 * @generated
	 */
	public void resetRRLAntennaResourceHome() {
		resetEJBHome();
	}
	/**
	 * setRRLAntennaResourceHome
	 * @generated
	 */
	public void setRRLAntennaResourceHome(
		com.hps.july.persistence.RRLAntennaResourceHome home) {
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
		return _acquireRRLAntennaResourceHome().findResourcesByQBE3(
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
	public com.hps.july.persistence.RRLAntennaResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRRLAntennaResourceHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RRLAntennaResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRRLAntennaResourceHome().create(
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
		return _acquireRRLAntennaResourceHome().findResourcesByLeasePayRules(
			listContracts);
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRRLAntennaResourceHome()
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
		return _acquireRRLAntennaResourceHome().findResourcesByQBE2(
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
		return _acquireRRLAntennaResourceHome().findResourcesForBrowse(
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
		return _acquireRRLAntennaResourceHome().findActiveResourceBySubtype(
			argSubtype,
			argActive);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RRLAntennaResource create(
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
		java.math.BigDecimal argFreqDevLowK,
		int argFreqDevLowLog10,
		java.math.BigDecimal argFreqDevHighK,
		int argFreqDevHighLog10,
		java.lang.String argMkkrRecomm,
		java.lang.String argProtocolNum,
		java.sql.Date argProtocolDate)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRRLAntennaResourceHome().create(
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
			argFreqDevLowK,
			argFreqDevLowLog10,
			argFreqDevHighK,
			argFreqDevHighLog10,
			argMkkrRecomm,
			argProtocolNum,
			argProtocolDate);
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
		return _acquireRRLAntennaResourceHome().findResourcesByQBE(
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
		return _acquireRRLAntennaResourceHome()
			.findResourcesByLeaseChargeRules(
			listContracts);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RRLAntennaResource create(int argResource)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRRLAntennaResourceHome().create(argResource);
	}
}
