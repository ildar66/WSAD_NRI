package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * RegionAccFactory
 * @generated
 */
public class RegionAccFactory extends AbstractEJBFactory {
	/**
	 * RegionAccFactory
	 * @generated
	 */
	public RegionAccFactory() {
		super();
	}
	/**
	 * _acquireRegionAccHome
	 * @generated
	 */
	protected com.hps.july.persistence.RegionAccHome _acquireRegionAccHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.RegionAccHome) _acquireEJBHome();
	}
	/**
	 * acquireRegionAccHome
	 * @generated
	 */
	public com.hps.july.persistence.RegionAccHome acquireRegionAccHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.RegionAccHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/RegionAcc";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.RegionAccHome.class;
	}
	/**
	 * resetRegionAccHome
	 * @generated
	 */
	public void resetRegionAccHome() {
		resetEJBHome();
	}
	/**
	 * setRegionAccHome
	 * @generated
	 */
	public void setRegionAccHome(com.hps.july.persistence.RegionAccHome home) {
		setEJBHome(home);
	}
	/**
	 * findByOperatorAndId
	 * @generated
	 */
	public java.util.Enumeration findByOperatorAndId(
		java.lang.Integer argOperator,
		java.lang.Integer argRegionID)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRegionAccHome().findByOperatorAndId(
			argOperator,
			argRegionID);
	}
	/**
	 * findRegionAccsByOperator
	 * @generated
	 */
	public java.util.Enumeration findRegionAccsByOperator(
		com.hps.july.persistence.OperatorKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRegionAccHome().findRegionAccsByOperator(inKey);
	}
	/**
	 * findRegionAccsByRegion
	 * @generated
	 */
	public java.util.Enumeration findRegionAccsByRegion(
		com.hps.july.persistence.RegionKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRegionAccHome().findRegionAccsByRegion(inKey);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Integer argOperator,
		java.lang.Boolean isSuperregion,
		java.lang.Integer argSupregion,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRegionAccHome().findByQBE(
			argOperator,
			isSuperregion,
			argSupregion,
			order);
	}
	/**
	 * findBySuperregionOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findBySuperregionOrderByCodeAsc(
		java.lang.Integer argSupregion)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRegionAccHome().findBySuperregionOrderByCodeAsc(
			argSupregion);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.RegionAcc findByPrimaryKey(
		com.hps.july.persistence.RegionAccKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRegionAccHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RegionAcc create(
		int argAccessid,
		int argOperatorId,
		int argRegionId,
		boolean argViewPlan,
		boolean argViewFact,
		boolean argEditPlan,
		boolean argEditFact)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRegionAccHome().create(
			argAccessid,
			argOperatorId,
			argRegionId,
			argViewPlan,
			argViewFact,
			argEditPlan,
			argEditFact);
	}
}
