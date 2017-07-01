package com.hps.july.commonbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessKeyGeneratorHomeBean_96ee1f72
 */
public class EJSStatelessKeyGeneratorHomeBean_96ee1f72 extends EJSHome {
	/**
	 * EJSStatelessKeyGeneratorHomeBean_96ee1f72
	 */
	public EJSStatelessKeyGeneratorHomeBean_96ee1f72() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.commonbean.KeyGenerator create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.commonbean.KeyGenerator _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.commonbean.KeyGenerator) super.createWrapper(new BeanId(this, null));
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
