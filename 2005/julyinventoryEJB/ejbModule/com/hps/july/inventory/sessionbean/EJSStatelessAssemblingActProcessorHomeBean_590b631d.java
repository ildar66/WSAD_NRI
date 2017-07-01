package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessAssemblingActProcessorHomeBean_590b631d
 */
public class EJSStatelessAssemblingActProcessorHomeBean_590b631d extends EJSHome {
	/**
	 * EJSStatelessAssemblingActProcessorHomeBean_590b631d
	 */
	public EJSStatelessAssemblingActProcessorHomeBean_590b631d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.AssemblingActProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.AssemblingActProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.inventory.sessionbean.AssemblingActProcessor) super.createWrapper(new BeanId(this, null));
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
