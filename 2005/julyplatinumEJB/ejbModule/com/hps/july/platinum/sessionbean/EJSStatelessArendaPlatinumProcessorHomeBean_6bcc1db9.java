package com.hps.july.platinum.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessArendaPlatinumProcessorHomeBean_6bcc1db9
 */
public class EJSStatelessArendaPlatinumProcessorHomeBean_6bcc1db9 extends EJSHome {
	/**
	 * EJSStatelessArendaPlatinumProcessorHomeBean_6bcc1db9
	 */
	public EJSStatelessArendaPlatinumProcessorHomeBean_6bcc1db9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor) super.createWrapper(new BeanId(this, null));
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
