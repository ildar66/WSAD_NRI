package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * SuperRegionAccFactory
 * @generated
 */
public class SuperRegionAccFactory extends AbstractEJBFactory {
	/**
	 * SuperRegionAccFactory
	 * @generated
	 */
	public SuperRegionAccFactory() {
		super();
	}
	/**
	 * _acquireSuperRegionAccHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.SuperRegionAccHome _acquireSuperRegionAccHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.SuperRegionAccHome) _acquireEJBHome();
	}
	/**
	 * acquireSuperRegionAccHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.SuperRegionAccHome acquireSuperRegionAccHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.SuperRegionAccHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/SuperRegionAcc";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.SuperRegionAccHome.class;
	}
	/**
	 * resetSuperRegionAccHome
	 * @generated
	 */
	public void resetSuperRegionAccHome() {
		resetEJBHome();
	}
	/**
	 * setSuperRegionAccHome
	 * @generated
	 */
	public void setSuperRegionAccHome(
		com.hps.july.persistence.SuperRegionAccHome home) {
		setEJBHome(home);
	}
	/**
	 * findSuperRegionAccsBySuperregion
	 * @generated
	 */
	public java.util.Enumeration findSuperRegionAccsBySuperregion(
		com.hps.july.persistence.SuperRegionKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionAccHome().findSuperRegionAccsBySuperregion(
			inKey);
	}
	/**
	 * findByOperatorAndId
	 * @generated
	 */
	public java.util.Enumeration findByOperatorAndId(
		java.lang.Integer argOperator,
		java.lang.Integer argSregionID)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionAccHome().findByOperatorAndId(
			argOperator,
			argSregionID);
	}
	/**
	 * findByOperator
	 * @generated
	 */
	public java.util.Enumeration findByOperator(java.lang.Integer argOperator)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionAccHome().findByOperator(argOperator);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.SuperRegionAcc findByPrimaryKey(
		com.hps.july.persistence.SuperRegionAccKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionAccHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.SuperRegionAcc create(
		int argAccessid,
		int argOperatorId,
		int argSupregionId,
		boolean argViewPlan,
		boolean argViewFact,
		boolean argEditPlan,
		boolean argEditFact)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSuperRegionAccHome().create(
			argAccessid,
			argOperatorId,
			argSupregionId,
			argViewPlan,
			argViewFact,
			argEditPlan,
			argEditFact);
	}
	/**
	 * findAllOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByCodeAsc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionAccHome().findAllOrderByCodeAsc();
	}
	/**
	 * findSuperRegionAccsByOperator
	 * @generated
	 */
	public java.util.Enumeration findSuperRegionAccsByOperator(
		com.hps.july.persistence.OperatorKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionAccHome().findSuperRegionAccsByOperator(
			inKey);
	}
}
