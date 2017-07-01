package com.hps.july.jdbcpersistence;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessEnvironmentHomeBean_8f8f4d52
 */
public class EJSStatelessEnvironmentHomeBean_8f8f4d52 extends EJSHome {
	/**
	 * EJSStatelessEnvironmentHomeBean_8f8f4d52
	 */
	public EJSStatelessEnvironmentHomeBean_8f8f4d52() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.jdbcpersistence.Environment create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.jdbcpersistence.Environment _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.jdbcpersistence.Environment) super.createWrapper(new BeanId(this, null));
}
catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return _EJS_result;	}
}
