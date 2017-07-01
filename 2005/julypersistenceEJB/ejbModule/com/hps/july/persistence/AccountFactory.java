package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AccountFactory
 * @generated
 */
public class AccountFactory extends AbstractEJBFactory {
	/**
	 * AccountFactory
	 * @generated
	 */
	public AccountFactory() {
		super();
	}
	/**
	 * _acquireAccountHome
	 * @generated
	 */
	protected com.hps.july.persistence.AccountHome _acquireAccountHome() throws java.rmi.RemoteException {
		return (com.hps.july.persistence.AccountHome) _acquireEJBHome();
	}
	/**
	 * acquireAccountHome
	 * @generated
	 */
	public com.hps.july.persistence.AccountHome acquireAccountHome() throws javax.naming.NamingException {
		return (com.hps.july.persistence.AccountHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Account";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AccountHome.class;
	}
	/**
	 * resetAccountHome
	 * @generated
	 */
	public void resetAccountHome() {
		resetEJBHome();
	}
	/**
	 * setAccountHome
	 * @generated
	 */
	public void setAccountHome(com.hps.july.persistence.AccountHome home) {
		setEJBHome(home);
	}
	/**
	 * findAccountinbankByBank
	 * @generated
	 */
	public java.util.Enumeration findAccountinbankByBank(java.lang.Integer inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAccountHome().findAccountinbankByBank(inKey);
	}
	/**
	 * findAccountByOrganization
	 * @generated
	 */
	public java.util.Enumeration findAccountByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAccountHome().findAccountByOrganization(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Account findByPrimaryKey(com.hps.july.persistence.AccountKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAccountHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Account create(int account, com.hps.july.persistence.Organization argOrganization, com.hps.july.persistence.Bank argBank)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAccountHome().create(account, argOrganization, argBank);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Account create(int argAccount, java.lang.Integer argBank, java.lang.Integer argOrganization, java.lang.String argName, java.lang.Boolean argActive)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAccountHome().create(argAccount, argBank, argOrganization, argName, argActive);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Account create(int argAccount, java.lang.Integer argBank, java.lang.Integer argOrganization, java.lang.String argName)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAccountHome().create(argAccount, argBank, argOrganization, argName);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Account create(int argAccount) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAccountHome().create(argAccount);
	}
}
