package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ChangeActPositionFactory
 * @generated
 */
public class ChangeActPositionFactory extends AbstractEJBFactory {
	/**
	 * ChangeActPositionFactory
	 * @generated
	 */
	public ChangeActPositionFactory() {
		super();
	}
	/**
	 * _acquireChangeActPositionHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.ChangeActPositionHome _acquireChangeActPositionHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.ChangeActPositionHome) _acquireEJBHome();
	}
	/**
	 * acquireChangeActPositionHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.ChangeActPositionHome acquireChangeActPositionHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.ChangeActPositionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/ChangeActPosition";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.ChangeActPositionHome.class;
	}
	/**
	 * resetChangeActPositionHome
	 * @generated
	 */
	public void resetChangeActPositionHome() {
		resetEJBHome();
	}
	/**
	 * setChangeActPositionHome
	 * @generated
	 */
	public void setChangeActPositionHome(
		com.hps.july.persistence.ChangeActPositionHome home) {
		setEJBHome(home);
	}
	/**
	 * findByDocNewSerial
	 * @generated
	 */
	public java.util.Enumeration findByDocNewSerial(
		java.lang.Integer argDoc,
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActPositionHome().findByDocNewSerial(
			argDoc,
			argSerial);
	}
	/**
	 * findChangeActPositionByChangeAct
	 * @generated
	 */
	public java.util.Enumeration findChangeActPositionByChangeAct(
		com.hps.july.persistence.DocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActPositionHome()
			.findChangeActPositionByChangeAct(
			inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.ChangeActPosition findByPrimaryKey(
		com.hps.july.persistence.ChangeActPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActPositionHome().findByPrimaryKey(key);
	}
	/**
	 * findChangeActPositionsByNewresource
	 * @generated
	 */
	public java.util.Enumeration findChangeActPositionsByNewresource(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActPositionHome()
			.findChangeActPositionsByNewresource(
			inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.ChangeActPosition create(
		int argCode,
		java.lang.String argOldSerial,
		java.lang.String argNewSerial,
		java.lang.Integer argChangeAct)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireChangeActPositionHome().create(
			argCode,
			argOldSerial,
			argNewSerial,
			argChangeAct);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.ChangeActPosition create(int argCode)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireChangeActPositionHome().create(argCode);
	}
}
