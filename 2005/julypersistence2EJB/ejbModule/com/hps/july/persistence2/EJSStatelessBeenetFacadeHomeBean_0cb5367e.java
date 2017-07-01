package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessBeenetFacadeHomeBean_0cb5367e
 */
public class EJSStatelessBeenetFacadeHomeBean_0cb5367e extends EJSHome {
	/**
	 * EJSStatelessBeenetFacadeHomeBean_0cb5367e
	 */
	public EJSStatelessBeenetFacadeHomeBean_0cb5367e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.BeenetFacade create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.persistence2.BeenetFacade _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.persistence2.BeenetFacade) super.createWrapper(new BeanId(this, null));
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
