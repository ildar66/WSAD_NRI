package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseSchetFaktFactory
 * @generated
 */
public class LeaseSchetFaktFactory extends AbstractEJBFactory {
	/**
	 * LeaseSchetFaktFactory
	 * @generated
	 */
	public LeaseSchetFaktFactory() {
		super();
	}
	/**
	 * _acquireLeaseSchetFaktHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseSchetFaktHome _acquireLeaseSchetFaktHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.LeaseSchetFaktHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseSchetFaktHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseSchetFaktHome acquireLeaseSchetFaktHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.LeaseSchetFaktHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseSchetFakt";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseSchetFaktHome.class;
	}
	/**
	 * resetLeaseSchetFaktHome
	 * @generated
	 */
	public void resetLeaseSchetFaktHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseSchetFaktHome
	 * @generated
	 */
	public void setLeaseSchetFaktHome(
		com.hps.july.persistence.LeaseSchetFaktHome home) {
		setEJBHome(home);
	}
	/**
	 * findLeaseSchetFaktsByIdAct
	 * @generated
	 */
	public java.util.Enumeration findLeaseSchetFaktsByIdAct(
		com.hps.july.persistence.LeaseDocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome().findLeaseSchetFaktsByIdAct(inKey);
	}
	/**
	 * findByIdActOrderByNumberSchetFaktAsc
	 * @generated
	 */
	public java.util.Enumeration findByIdActOrderByNumberSchetFaktAsc(
		java.lang.Integer idAct)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome()
			.findByIdActOrderByNumberSchetFaktAsc(
			idAct);
	}
	/**
	 * findLeaseSchetFaktsByIdContract
	 * @generated
	 */
	public java.util.Enumeration findLeaseSchetFaktsByIdContract(
		com.hps.july.persistence.LeaseDocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome().findLeaseSchetFaktsByIdContract(
			inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseSchetFakt findByPrimaryKey(
		com.hps.july.persistence.LeaseSchetFaktKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome().findByPrimaryKey(key);
	}
	/**
	 * findByIdContractOrderByDateSchetFaktAsc
	 * @generated
	 */
	public java.util.Enumeration findByIdContractOrderByDateSchetFaktAsc(
		java.lang.Integer idContract)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome()
			.findByIdContractOrderByDateSchetFaktAsc(
			idContract);
	}
	/**
	 * findByIdContractOrderByDateSchetFaktDesc
	 * @generated
	 */
	public java.util.Enumeration findByIdContractOrderByDateSchetFaktDesc(
		java.lang.Integer idContract)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome()
			.findByIdContractOrderByDateSchetFaktDesc(
			idContract);
	}
	/**
	 * findByIdContractOrderByNumberSchetFaktDesc
	 * @generated
	 */
	public java.util.Enumeration findByIdContractOrderByNumberSchetFaktDesc(
		java.lang.Integer idContract)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome()
			.findByIdContractOrderByNumberSchetFaktDesc(
			idContract);
	}
	/**
	 * findByIdActOrderByDateSchetFaktDesc
	 * @generated
	 */
	public java.util.Enumeration findByIdActOrderByDateSchetFaktDesc(
		java.lang.Integer idAct)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome()
			.findByIdActOrderByDateSchetFaktDesc(
			idAct);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseSchetFakt create(
		java.lang.Integer argIdSchetFakt,
		java.lang.Integer idContract,
		java.lang.Integer idCurrency)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseSchetFaktHome().create(
			argIdSchetFakt,
			idContract,
			idCurrency);
	}
	/**
	 * findByIdActOrderByDateSchetFaktAsc
	 * @generated
	 */
	public java.util.Enumeration findByIdActOrderByDateSchetFaktAsc(
		java.lang.Integer idAct)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome().findByIdActOrderByDateSchetFaktAsc(
			idAct);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Integer idAct,
		java.lang.Boolean isContractType,
		java.lang.String typeContract,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome().findByQBE(
			idAct,
			isContractType,
			typeContract,
			order);
	}
	/**
	 * findByIdContractOrderByNumberSchetFaktAsc
	 * @generated
	 */
	public java.util.Enumeration findByIdContractOrderByNumberSchetFaktAsc(
		java.lang.Integer idContract)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome()
			.findByIdContractOrderByNumberSchetFaktAsc(
			idContract);
	}
	/**
	 * findLeaseSchetFaktsByIdCurrency
	 * @generated
	 */
	public java.util.Enumeration findLeaseSchetFaktsByIdCurrency(
		com.hps.july.persistence.CurrencyKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome().findLeaseSchetFaktsByIdCurrency(
			inKey);
	}
	/**
	 * findByIdActOrderByNumberSchetFaktDesc
	 * @generated
	 */
	public java.util.Enumeration findByIdActOrderByNumberSchetFaktDesc(
		java.lang.Integer idAct)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseSchetFaktHome()
			.findByIdActOrderByNumberSchetFaktDesc(
			idAct);
	}
}
