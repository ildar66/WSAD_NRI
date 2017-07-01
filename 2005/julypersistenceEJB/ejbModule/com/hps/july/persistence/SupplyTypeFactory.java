package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * SupplyTypeFactory
 * @generated
 */
public class SupplyTypeFactory extends AbstractEJBFactory {
	/**
	 * SupplyTypeFactory
	 * @generated
	 */
	public SupplyTypeFactory() {
		super();
	}
	/**
	 * _acquireSupplyTypeHome
	 * @generated
	 */
	protected com.hps.july.persistence.SupplyTypeHome _acquireSupplyTypeHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.SupplyTypeHome) _acquireEJBHome();
	}
	/**
	 * acquireSupplyTypeHome
	 * @generated
	 */
	public com.hps.july.persistence.SupplyTypeHome acquireSupplyTypeHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.SupplyTypeHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/SupplyType";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.SupplyTypeHome.class;
	}
	/**
	 * resetSupplyTypeHome
	 * @generated
	 */
	public void resetSupplyTypeHome() {
		resetEJBHome();
	}
	/**
	 * setSupplyTypeHome
	 * @generated
	 */
	public void setSupplyTypeHome(
		com.hps.july.persistence.SupplyTypeHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.SupplyType findByPrimaryKey(
		com.hps.july.persistence.SupplyTypeKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSupplyTypeHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.SupplyType create(
		int argSupplyType,
		java.lang.String argName)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSupplyTypeHome().create(argSupplyType, argName);
	}
	/**
	 * findAllOrderByNameDesc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByNameDesc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSupplyTypeHome().findAllOrderByNameDesc();
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.SupplyType create(int argSupplyType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSupplyTypeHome().create(argSupplyType);
	}
	/**
	 * findAllOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByNameAsc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSupplyTypeHome().findAllOrderByNameAsc();
	}
}
