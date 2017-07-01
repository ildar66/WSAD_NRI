package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * OperatorFactory
 * @generated
 */
public class OperatorFactory extends AbstractEJBFactory {
	/**
	 * OperatorFactory
	 * @generated
	 */
	public OperatorFactory() {
		super();
	}
	/**
	 * _acquireOperatorHome
	 * @generated
	 */
	protected com.hps.july.persistence.OperatorHome _acquireOperatorHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.OperatorHome) _acquireEJBHome();
	}
	/**
	 * acquireOperatorHome
	 * @generated
	 */
	public com.hps.july.persistence.OperatorHome acquireOperatorHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.OperatorHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Operator";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.OperatorHome.class;
	}
	/**
	 * resetOperatorHome
	 * @generated
	 */
	public void resetOperatorHome() {
		resetEJBHome();
	}
	/**
	 * setOperatorHome
	 * @generated
	 */
	public void setOperatorHome(com.hps.july.persistence.OperatorHome home) {
		setEJBHome(home);
	}
	/**
	 * findOperatorsByMan
	 * @generated
	 */
	public java.util.Enumeration findOperatorsByMan(
		com.hps.july.persistence.PeopleKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOperatorHome().findOperatorsByMan(inKey);
	}
	/**
	 * findOperatorByLastNameOrderByLoginAsc
	 * @generated
	 */
	public java.util.Enumeration findOperatorByLastNameOrderByLoginAsc(
		java.lang.String lastName)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOperatorHome().findOperatorByLastNameOrderByLoginAsc(
			lastName);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Operator findByPrimaryKey(
		com.hps.july.persistence.OperatorKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOperatorHome().findByPrimaryKey(key);
	}
	/**
	 * findByLogin
	 * @generated
	 */
	public com.hps.july.persistence.Operator findByLogin(
		java.lang.String login)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOperatorHome().findByLogin(login);
	}
	/**
	 * findOperatorsWithImportSessions
	 * @generated
	 */
	public java.util.Enumeration findOperatorsWithImportSessions()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOperatorHome().findOperatorsWithImportSessions();
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Operator create(
		int argOperator,
		java.lang.Integer argMan,
		java.lang.String argLogin,
		java.lang.String argPassword,
		java.lang.Boolean argEnabled)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOperatorHome().create(
			argOperator,
			argMan,
			argLogin,
			argPassword,
			argEnabled);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Operator create(int argOperator)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOperatorHome().create(argOperator);
	}
}
