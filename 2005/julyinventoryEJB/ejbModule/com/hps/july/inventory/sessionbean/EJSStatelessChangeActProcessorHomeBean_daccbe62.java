package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessChangeActProcessorHomeBean_daccbe62
 */
public class EJSStatelessChangeActProcessorHomeBean_daccbe62 extends EJSHome {
	/**
	 * EJSStatelessChangeActProcessorHomeBean_daccbe62
	 */
	public EJSStatelessChangeActProcessorHomeBean_daccbe62() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.ChangeActProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.ChangeActProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.inventory.sessionbean.ChangeActProcessor) super.createWrapper(new BeanId(this, null));
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
