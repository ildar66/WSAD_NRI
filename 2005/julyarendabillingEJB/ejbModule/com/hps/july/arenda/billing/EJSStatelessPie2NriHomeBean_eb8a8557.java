package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessPie2NriHomeBean_eb8a8557
 */
public class EJSStatelessPie2NriHomeBean_eb8a8557 extends EJSHome {
	/**
	 * EJSStatelessPie2NriHomeBean_eb8a8557
	 */
	public EJSStatelessPie2NriHomeBean_eb8a8557() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.billing.Pie2Nri create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.billing.Pie2Nri _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.billing.Pie2Nri) super.createWrapper(new BeanId(this, null));
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
