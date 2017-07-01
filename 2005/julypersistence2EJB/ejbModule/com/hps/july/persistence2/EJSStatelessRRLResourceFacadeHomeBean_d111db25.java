package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessRRLResourceFacadeHomeBean_d111db25
 */
public class EJSStatelessRRLResourceFacadeHomeBean_d111db25 extends EJSHome {
	/**
	 * EJSStatelessRRLResourceFacadeHomeBean_d111db25
	 */
	public EJSStatelessRRLResourceFacadeHomeBean_d111db25() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.RRLResourceFacade create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.persistence2.RRLResourceFacade _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.persistence2.RRLResourceFacade) super.createWrapper(new BeanId(this, null));
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
