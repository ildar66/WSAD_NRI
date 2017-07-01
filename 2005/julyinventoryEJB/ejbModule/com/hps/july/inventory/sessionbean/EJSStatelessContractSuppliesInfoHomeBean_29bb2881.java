package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessContractSuppliesInfoHomeBean_29bb2881
 */
public class EJSStatelessContractSuppliesInfoHomeBean_29bb2881 extends EJSHome {
	/**
	 * EJSStatelessContractSuppliesInfoHomeBean_29bb2881
	 */
	public EJSStatelessContractSuppliesInfoHomeBean_29bb2881() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.ContractSuppliesInfo create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.ContractSuppliesInfo _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.inventory.sessionbean.ContractSuppliesInfo) super.createWrapper(new BeanId(this, null));
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
