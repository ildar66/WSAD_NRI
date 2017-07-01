package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * PositionFactory
 * @generated
 */
public class PositionFactory extends AbstractEJBFactory {
	/**
	 * PositionFactory
	 * @generated
	 */
	public PositionFactory() {
		super();
	}
	/**
	 * _acquirePositionHome
	 * @generated
	 */
	protected com.hps.july.persistence.PositionHome _acquirePositionHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.PositionHome) _acquireEJBHome();
	}
	/**
	 * acquirePositionHome
	 * @generated
	 */
	public com.hps.july.persistence.PositionHome acquirePositionHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.PositionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Position";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.PositionHome.class;
	}
	/**
	 * resetPositionHome
	 * @generated
	 */
	public void resetPositionHome() {
		resetEJBHome();
	}
	/**
	 * setPositionHome
	 * @generated
	 */
	public void setPositionHome(com.hps.july.persistence.PositionHome home) {
		setEJBHome(home);
	}
	/**
	 * findByQBE4
	 * @generated
	 */
	public java.util.Enumeration findByQBE4(
		java.lang.Boolean isNetZone,
		java.lang.Integer argNetZone,
		java.lang.Boolean isAllType,
		java.lang.Boolean isDAMPS,
		java.lang.Boolean isGSM900,
		java.lang.Boolean isDCS1800,
		java.lang.Boolean isControllers,
		java.lang.Boolean isWorker,
		java.lang.Integer argWorker)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findByQBE4(
			isNetZone,
			argNetZone,
			isAllType,
			isDAMPS,
			isGSM900,
			isDCS1800,
			isControllers,
			isWorker,
			argWorker);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isNetZone,
		java.lang.Integer argNetZone,
		java.lang.Boolean isGsmId,
		java.lang.String argGsmId,
		java.lang.Boolean isDampsId,
		java.lang.String argDampsId,
		java.lang.Boolean isName,
		java.lang.String argName,
		java.lang.Boolean isAddr,
		java.lang.String argAddr,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findByQBE(
			isNetZone,
			argNetZone,
			isGsmId,
			argGsmId,
			isDampsId,
			argDampsId,
			isName,
			argName,
			isAddr,
			argAddr,
			order);
	}
	/**
	 * findPositionsByRegion
	 * @generated
	 */
	public java.util.Enumeration findPositionsByRegion(
		com.hps.july.persistence.RegionKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findPositionsByRegion(inKey);
	}
	/**
	 * findRenteePositionByRenter
	 * @generated
	 */
	public java.util.Enumeration findRenteePositionByRenter(
		com.hps.july.persistence.OrganizationKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findRenteePositionByRenter(inKey);
	}
	/**
	 * findPositionByNetZone
	 * @generated
	 */
	public java.util.Enumeration findPositionByNetZone(
		com.hps.july.persistence.NetZoneKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findPositionByNetZone(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Position create(
		int argStorageplace,
		java.lang.String argName,
		java.lang.String argAddress,
		java.lang.Integer argNetZone,
		java.math.BigDecimal argLatitude,
		java.math.BigDecimal argLongitude)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquirePositionHome().create(
			argStorageplace,
			argName,
			argAddress,
			argNetZone,
			argLatitude,
			argLongitude);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Position findByPrimaryKey(
		com.hps.july.persistence.StoragePlaceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Position create(
		int argStorageplace,
		java.lang.String argName,
		java.lang.String argAddress,
		java.lang.Integer argNetZone,
		java.math.BigDecimal argLatitude,
		java.math.BigDecimal argLongitude,
		java.lang.String argPlanState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquirePositionHome().create(
			argStorageplace,
			argName,
			argAddress,
			argNetZone,
			argLatitude,
			argLongitude,
			argPlanState);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.lang.Boolean isNetZone,
		java.lang.Integer argNetZone,
		java.lang.Boolean isGsmId,
		java.lang.String argGsmId,
		java.lang.Boolean isDampsId,
		java.lang.String argDampsId,
		java.lang.Boolean isName,
		java.lang.String argName,
		java.lang.Boolean isAddr,
		java.lang.String argAddr,
		java.lang.Boolean isRenter,
		java.lang.Integer argRenter,
		java.lang.Boolean isResponsableWorker,
		java.lang.Integer argResponsableWorker,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findByQBE2(
			isNetZone,
			argNetZone,
			isGsmId,
			argGsmId,
			isDampsId,
			argDampsId,
			isName,
			argName,
			isAddr,
			argAddr,
			isRenter,
			argRenter,
			isResponsableWorker,
			argResponsableWorker,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Position create(
		int argStorageplace,
		java.lang.String argName,
		java.lang.String argAddress,
		java.lang.Integer argNetZone,
		java.math.BigDecimal argLatitude,
		java.math.BigDecimal argLongitude,
		int argRegionId,
		java.lang.String argPlanState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquirePositionHome().create(
			argStorageplace,
			argName,
			argAddress,
			argNetZone,
			argLatitude,
			argLongitude,
			argRegionId,
			argPlanState);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Position create(int argStorageplace)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquirePositionHome().create(argStorageplace);
	}
	/**
	 * findByQBE3
	 * @generated
	 */
	public java.util.Enumeration findByQBE3(
		java.lang.Boolean isNetZone,
		java.lang.Integer argNetZone,
		java.lang.Boolean isGsmId,
		java.lang.String argGsmId,
		java.lang.Boolean isDampsId,
		java.lang.String argDampsId,
		java.lang.Boolean isName,
		java.lang.String argName,
		java.lang.Boolean isAddr,
		java.lang.String argAddr,
		java.lang.Boolean isRenter,
		java.lang.Integer argRenter,
		java.lang.Boolean isResponsableWorker,
		java.lang.Integer argResponsableWorker,
		java.lang.Boolean isInAction,
		java.lang.String inAction,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePositionHome().findByQBE3(
			isNetZone,
			argNetZone,
			isGsmId,
			argGsmId,
			isDampsId,
			argDampsId,
			isName,
			argName,
			isAddr,
			argAddr,
			isRenter,
			argRenter,
			isResponsableWorker,
			argResponsableWorker,
			isInAction,
			inAction,
			order);
	}
}
