package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessBillingRequiredNewHomeBean_5f114f3d
 */
public class EJSStatelessBillingRequiredNewHomeBean_5f114f3d extends EJSHome {
	/**
	 * EJSStatelessBillingRequiredNewHomeBean_5f114f3d
	 */
	public EJSStatelessBillingRequiredNewHomeBean_5f114f3d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.billing.BillingRequiredNew create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.billing.BillingRequiredNew _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.billing.BillingRequiredNew) super.createWrapper(new BeanId(this, null));
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
