package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * BankFactory
 * @generated
 * 
 */
public class BankFactory extends AbstractEJBFactory {
	/**
	 * BankFactory
	 * @generated
	 */
	public BankFactory() {
		super();
	}
	/**
	 * _acquireBankHome
	 * @generated
	 */
	protected com.hps.july.persistence.BankHome _acquireBankHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.BankHome) _acquireEJBHome();
	}
	/**
	 * acquireBankHome
	 * @generated
	 */
	public com.hps.july.persistence.BankHome acquireBankHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.BankHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/BankHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.BankHome.class;
	}
	/**
	 * resetBankHome
	 * @generated
	 */
	public void resetBankHome() {
		resetEJBHome();
	}
	/**
	 * setBankHome
	 * @generated
	 */
	public void setBankHome(com.hps.july.persistence.BankHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Bank findByPrimaryKey(
		java.lang.Integer primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireBankHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Bank create(java.lang.Integer idBank)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireBankHome().create(idBank);
	}
	/**
	 * findBankByBik
	 * @generated
	 */
	public com.hps.july.persistence.Bank findBankByBik(java.lang.String argBik)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireBankHome().findBankByBik(argBik);
	}
}
