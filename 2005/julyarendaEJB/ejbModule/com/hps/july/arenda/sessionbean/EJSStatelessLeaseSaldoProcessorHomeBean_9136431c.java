package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessLeaseSaldoProcessorHomeBean_9136431c
 */
public class EJSStatelessLeaseSaldoProcessorHomeBean_9136431c extends EJSHome {
	/**
	 * EJSStatelessLeaseSaldoProcessorHomeBean_9136431c
	 */
	public EJSStatelessLeaseSaldoProcessorHomeBean_9136431c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.sessionbean.LeaseSaldoProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.sessionbean.LeaseSaldoProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.sessionbean.LeaseSaldoProcessor) super.createWrapper(new BeanId(this, null));
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
