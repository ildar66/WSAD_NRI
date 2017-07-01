package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeasePayOrderFactory
 * @generated
 */
public class LeasePayOrderFactory extends AbstractEJBFactory {
	/**
	 * LeasePayOrderFactory
	 * @generated
	 */
	public LeasePayOrderFactory() {
		super();
	}
	/**
	 * _acquireLeasePayOrderHome
	 * @generated
	 */
	protected com.hps.july.persistence.LeasePayOrderHome _acquireLeasePayOrderHome() throws java.rmi.RemoteException {
		return (com.hps.july.persistence.LeasePayOrderHome) _acquireEJBHome();
	}
	/**
	 * acquireLeasePayOrderHome
	 * @generated
	 */
	public com.hps.july.persistence.LeasePayOrderHome acquireLeasePayOrderHome() throws javax.naming.NamingException {
		return (com.hps.july.persistence.LeasePayOrderHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeasePayOrder";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeasePayOrderHome.class;
	}
	/**
	 * resetLeasePayOrderHome
	 * @generated
	 */
	public void resetLeasePayOrderHome() {
		resetEJBHome();
	}
	/**
	 * setLeasePayOrderHome
	 * @generated
	 */
	public void setLeasePayOrderHome(com.hps.july.persistence.LeasePayOrderHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeasePayOrder findByPrimaryKey(com.hps.july.persistence.LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePayOrderHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeasePayOrder create(
		int argLeaseDocPosition,
		java.sql.Date argDate,
		java.lang.Integer argLeaseContract,
		java.lang.String argSource,
		java.lang.String argVid,
		java.sql.Date argSDate,
		java.sql.Date argEDate,
		java.lang.Integer argResource,
		java.math.BigDecimal argSumm,
		java.lang.Integer argCurrency,
		java.math.BigDecimal argSumNds,
		java.lang.String argPaymentType,
		java.lang.String argPaymentState,
		java.lang.Integer argOrgAcc,
		java.lang.String argPayPurpoise,
		java.lang.String argppType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeasePayOrderHome().create(
			argLeaseDocPosition,
			argDate,
			argLeaseContract,
			argSource,
			argVid,
			argSDate,
			argEDate,
			argResource,
			argSumm,
			argCurrency,
			argSumNds,
			argPaymentType,
			argPaymentState,
			argOrgAcc,
			argPayPurpoise,
			argppType);
	}
	/**
	 * findLeasePayOrderByOrgAcc
	 * @generated
	 */
	public java.util.Enumeration findLeasePayOrderByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePayOrderHome().findLeasePayOrderByOrgAcc(inKey);
	}
}
