package com.hps.july.platinum.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessPlatinumProcessorHomeBean_4fefeba3
 */
public class EJSStatelessPlatinumProcessorHomeBean_4fefeba3 extends EJSHome {
	/**
	 * EJSStatelessPlatinumProcessorHomeBean_4fefeba3
	 */
	public EJSStatelessPlatinumProcessorHomeBean_4fefeba3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.platinum.sessionbean.PlatinumProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.platinum.sessionbean.PlatinumProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.platinum.sessionbean.PlatinumProcessor) super.createWrapper(new BeanId(this, null));
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
