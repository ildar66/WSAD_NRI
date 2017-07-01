package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessInWayBillProcessorHomeBean_25d43716
 */
public class EJSStatelessInWayBillProcessorHomeBean_25d43716 extends EJSHome {
	/**
	 * EJSStatelessInWayBillProcessorHomeBean_25d43716
	 */
	public EJSStatelessInWayBillProcessorHomeBean_25d43716() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.InWayBillProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.InWayBillProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.inventory.sessionbean.InWayBillProcessor) super.createWrapper(new BeanId(this, null));
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
