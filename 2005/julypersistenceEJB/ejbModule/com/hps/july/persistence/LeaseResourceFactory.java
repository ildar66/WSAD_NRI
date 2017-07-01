package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseResourceFactory
 * @generated
 */
public class LeaseResourceFactory extends AbstractEJBFactory {
	/**
	 * LeaseResourceFactory
	 * @generated
	 */
	public LeaseResourceFactory() {
		super();
	}
	/**
	 * _acquireLeaseResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseResourceHome _acquireLeaseResourceHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.LeaseResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseResourceHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseResourceHome acquireLeaseResourceHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.LeaseResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/LeaseResourceHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseResourceHome.class;
	}
	/**
	 * resetLeaseResourceHome
	 * @generated
	 */
	public void resetLeaseResourceHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseResourceHome
	 * @generated
	 */
	public void setLeaseResourceHome(
		com.hps.july.persistence.LeaseResourceHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseResource create(
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
		boolean argNeedCwAct,
		boolean argUseInArendaContract,
		boolean argUseInAbonentContract)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseResourceHome().create(
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
			argNeedCwAct,
			argUseInArendaContract,
			argUseInAbonentContract);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseResourceHome().create(
			resource,
			argUnit,
			argSubtype);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireLeaseResourceHome().findByPrimaryKey(primaryKey);
	}
}
