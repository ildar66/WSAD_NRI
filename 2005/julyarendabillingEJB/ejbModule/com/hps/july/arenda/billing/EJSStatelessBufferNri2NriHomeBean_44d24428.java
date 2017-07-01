package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessBufferNri2NriHomeBean_44d24428
 */
public class EJSStatelessBufferNri2NriHomeBean_44d24428 extends EJSHome {
	/**
	 * EJSStatelessBufferNri2NriHomeBean_44d24428
	 */
	public EJSStatelessBufferNri2NriHomeBean_44d24428() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.billing.BufferNri2Nri create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.billing.BufferNri2Nri _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.billing.BufferNri2Nri) super.createWrapper(new BeanId(this, null));
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
