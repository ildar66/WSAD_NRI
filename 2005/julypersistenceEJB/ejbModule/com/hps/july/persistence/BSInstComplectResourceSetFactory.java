package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * BSInstComplectResourceSetFactory
 * @generated
 */
public class BSInstComplectResourceSetFactory extends AbstractEJBFactory {
	/**
	 * BSInstComplectResourceSetFactory
	 * @generated
	 */
	public BSInstComplectResourceSetFactory() {
		super();
	}
	/**
	 * _acquireBSInstComplectResourceSetHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.BSInstComplectResourceSetHome _acquireBSInstComplectResourceSetHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.BSInstComplectResourceSetHome) _acquireEJBHome();
	}
	/**
	 * acquireBSInstComplectResourceSetHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.BSInstComplectResourceSetHome acquireBSInstComplectResourceSetHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.BSInstComplectResourceSetHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/BSInstComplectResourceSetHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.BSInstComplectResourceSetHome.class;
	}
	/**
	 * resetBSInstComplectResourceSetHome
	 * @generated
	 */
	public void resetBSInstComplectResourceSetHome() {
		resetEJBHome();
	}
	/**
	 * setBSInstComplectResourceSetHome
	 * @generated
	 */
	public void setBSInstComplectResourceSetHome(
		com.hps.july.persistence.BSInstComplectResourceSetHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.BSInstComplectResourceSet create(
		int argResourceset,
		java.lang.String argName,
		java.lang.Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		java.lang.String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireBSInstComplectResourceSetHome().create(
			argResourceset,
			argName,
			argMainPart,
			argMainPartQty,
			argType);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.BSInstComplectResourceSet findByPrimaryKey(
		com.hps.july.persistence.ResourceSetKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireBSInstComplectResourceSetHome().findByPrimaryKey(
			primaryKey);
	}
}
