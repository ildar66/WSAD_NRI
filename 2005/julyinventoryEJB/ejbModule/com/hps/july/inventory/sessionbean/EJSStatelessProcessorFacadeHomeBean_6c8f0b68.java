package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessProcessorFacadeHomeBean_6c8f0b68
 */
public class EJSStatelessProcessorFacadeHomeBean_6c8f0b68 extends EJSHome {
	/**
	 * EJSStatelessProcessorFacadeHomeBean_6c8f0b68
	 */
	public EJSStatelessProcessorFacadeHomeBean_6c8f0b68() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.ProcessorFacade create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.ProcessorFacade _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.inventory.sessionbean.ProcessorFacade) super.createWrapper(new BeanId(this, null));
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
