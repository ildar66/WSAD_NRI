package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSitedocFacadeHomeBean_41d8fcb3
 */
public class EJSStatelessSitedocFacadeHomeBean_41d8fcb3 extends EJSHome {
	/**
	 * EJSStatelessSitedocFacadeHomeBean_41d8fcb3
	 */
	public EJSStatelessSitedocFacadeHomeBean_41d8fcb3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.SitedocFacade create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.persistence2.SitedocFacade _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.persistence2.SitedocFacade) super.createWrapper(new BeanId(this, null));
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
