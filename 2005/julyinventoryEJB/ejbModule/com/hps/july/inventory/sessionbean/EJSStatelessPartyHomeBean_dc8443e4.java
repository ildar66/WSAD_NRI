package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessPartyHomeBean_dc8443e4
 */
public class EJSStatelessPartyHomeBean_dc8443e4 extends EJSHome {
	/**
	 * EJSStatelessPartyHomeBean_dc8443e4
	 */
	public EJSStatelessPartyHomeBean_dc8443e4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.Party create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.Party _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.inventory.sessionbean.Party) super.createWrapper(new BeanId(this, null));
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
