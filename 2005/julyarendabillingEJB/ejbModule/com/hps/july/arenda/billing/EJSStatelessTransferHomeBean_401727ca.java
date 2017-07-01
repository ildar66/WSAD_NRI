package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessTransferHomeBean_401727ca
 */
public class EJSStatelessTransferHomeBean_401727ca extends EJSHome {
	/**
	 * EJSStatelessTransferHomeBean_401727ca
	 */
	public EJSStatelessTransferHomeBean_401727ca() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.billing.Transfer create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.billing.Transfer _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.billing.Transfer) super.createWrapper(new BeanId(this, null));
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
