package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * TRXResourceFactory
 * @generated
 */
public class TRXResourceFactory extends AbstractEJBFactory {
	/**
	 * TRXResourceFactory
	 * @generated
	 */
	public TRXResourceFactory() {
		super();
	}
	/**
	 * _acquireTRXResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.TRXResourceHome _acquireTRXResourceHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.TRXResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireTRXResourceHome
	 * @generated
	 */
	public com.hps.july.persistence.TRXResourceHome acquireTRXResourceHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.TRXResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/TRXResourceHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.TRXResourceHome.class;
	}
	/**
	 * resetTRXResourceHome
	 * @generated
	 */
	public void resetTRXResourceHome() {
		resetEJBHome();
	}
	/**
	 * setTRXResourceHome
	 * @generated
	 */
	public void setTRXResourceHome(
		com.hps.july.persistence.TRXResourceHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.TRXResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireTRXResourceHome().create(resource, argUnit, argSubtype);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.TRXResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireTRXResourceHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.TRXResource create(
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
		boolean argDoubletrx)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireTRXResourceHome().create(
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
			argDoubletrx);
	}
}
