package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CounterFactory
 * @generated
 */
public class CounterFactory extends AbstractEJBFactory {
	/**
	 * CounterFactory
	 * @generated
	 */
	public CounterFactory() {
		super();
	}
	/**
	 * _acquireCounterHome
	 * @generated
	 */
	protected com.hps.july.persistence2.CounterHome _acquireCounterHome() throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.CounterHome) _acquireEJBHome();
	}
	/**
	 * acquireCounterHome
	 * @generated
	 */
	public com.hps.july.persistence2.CounterHome acquireCounterHome() throws javax.naming.NamingException {
		return (com.hps.july.persistence2.CounterHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence2/Counter";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.CounterHome.class;
	}
	/**
	 * resetCounterHome
	 * @generated
	 */
	public void resetCounterHome() {
		resetEJBHome();
	}
	/**
	 * setCounterHome
	 * @generated
	 */
	public void setCounterHome(com.hps.july.persistence2.CounterHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.Counter findByPrimaryKey(com.hps.july.persistence2.CounterKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireCounterHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.Counter create(int argCounterid, int argCounterInfoId, int argPositionId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCounterHome().create(argCounterid, argCounterInfoId, argPositionId);
	}
}
