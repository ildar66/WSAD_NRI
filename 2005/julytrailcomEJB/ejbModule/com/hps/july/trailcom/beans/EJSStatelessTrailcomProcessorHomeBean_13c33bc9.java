package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessTrailcomProcessorHomeBean_13c33bc9
 */
public class EJSStatelessTrailcomProcessorHomeBean_13c33bc9 extends EJSHome {
	/**
	 * EJSStatelessTrailcomProcessorHomeBean_13c33bc9
	 */
	public EJSStatelessTrailcomProcessorHomeBean_13c33bc9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.trailcom.beans.TrailcomProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.trailcom.beans.TrailcomProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.trailcom.beans.TrailcomProcessor) super.createWrapper(new BeanId(this, null));
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
