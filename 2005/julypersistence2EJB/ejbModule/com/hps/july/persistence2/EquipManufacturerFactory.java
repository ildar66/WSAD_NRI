package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * EquipManufacturerFactory
 * @generated
 */
public class EquipManufacturerFactory extends AbstractEJBFactory {
	/**
	 * EquipManufacturerFactory
	 * @generated
	 */
	public EquipManufacturerFactory() {
		super();
	}
	/**
	 * _acquireEquipManufacturerHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence2
		.EquipManufacturerHome _acquireEquipManufacturerHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence2
			.EquipManufacturerHome) _acquireEJBHome();
	}
	/**
	 * acquireEquipManufacturerHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence2
		.EquipManufacturerHome acquireEquipManufacturerHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence2
			.EquipManufacturerHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/EquipManufacturerHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.EquipManufacturerHome.class;
	}
	/**
	 * resetEquipManufacturerHome
	 * @generated
	 */
	public void resetEquipManufacturerHome() {
		resetEJBHome();
	}
	/**
	 * setEquipManufacturerHome
	 * @generated
	 */
	public void setEquipManufacturerHome(
		com.hps.july.persistence2.EquipManufacturerHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.EquipManufacturer findByPrimaryKey(
		java.lang.Integer primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireEquipManufacturerHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.EquipManufacturer create(
		java.lang.Integer manufid,
		java.lang.String name,
		java.lang.String shortname)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireEquipManufacturerHome().create(manufid, name, shortname);
	}
}
