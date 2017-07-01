package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseMutualActNewFactory
 * @generated
 */
public class LeaseMutualActNewFactory extends AbstractEJBFactory {
	/**
	 * LeaseMutualActNewFactory
	 * @generated
	 */
	public LeaseMutualActNewFactory() {
		super();
	}
	/**
	 * _acquireLeaseMutualActNewHome
	 * @generated
	 */
	protected com.hps.july.persistence.LeaseMutualActNewHome _acquireLeaseMutualActNewHome() throws java.rmi.RemoteException {
		return (com.hps.july.persistence.LeaseMutualActNewHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseMutualActNewHome
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualActNewHome acquireLeaseMutualActNewHome() throws javax.naming.NamingException {
		return (com.hps.july.persistence.LeaseMutualActNewHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseMutualActNew";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseMutualActNewHome.class;
	}
	/**
	 * resetLeaseMutualActNewHome
	 * @generated
	 */
	public void resetLeaseMutualActNewHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseMutualActNewHome
	 * @generated
	 */
	public void setLeaseMutualActNewHome(com.hps.july.persistence.LeaseMutualActNewHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualActNew create(
		int argLeaseDocument,
		java.sql.Date argDocDate,
		java.lang.String argDocNumber,
		java.lang.Integer argLeaseMutualReglament,
		java.lang.String argState,
		java.sql.Date actstartdate,
		java.sql.Date actenddate,
		boolean argIsTemp,
		java.lang.Boolean argIsSchetFakt)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseMutualActNewHome().create(argLeaseDocument, argDocDate, argDocNumber, argLeaseMutualReglament, argState, actstartdate, actenddate, argIsTemp, argIsSchetFakt);
	}
	/**
	 * findLeaseMutualActNewByLeaseMutualReglament
	 * @generated
	 */
	public java.util.Enumeration findLeaseMutualActNewByLeaseMutualReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualActNewHome().findLeaseMutualActNewByLeaseMutualReglament(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualActNew create(
		int argLeaseDocument,
		java.sql.Date argDocDate,
		java.lang.String argDocNumber,
		java.lang.Integer argLeaseMutualReglament,
		java.lang.String argState,
		java.sql.Date actstartdate,
		java.sql.Date actenddate,
		boolean argIsTemp)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseMutualActNewHome().create(argLeaseDocument, argDocDate, argDocNumber, argLeaseMutualReglament, argState, actstartdate, actenddate, argIsTemp);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualActNew findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualActNewHome().findByPrimaryKey(key);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isMutualReglament,
		java.lang.Integer mutualReglament,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualActNewHome().findByQBE(isMutualReglament, mutualReglament, isDate, fromDate, toDate, order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseMutualActNewHome().create(argLeaseDocument);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer mutualReglament, java.lang.Boolean isEdit, java.lang.Boolean isRun, java.lang.Boolean isClose, java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualActNewHome().findByQBE2(mutualReglament, isEdit, isRun, isClose, order);
	}
}
