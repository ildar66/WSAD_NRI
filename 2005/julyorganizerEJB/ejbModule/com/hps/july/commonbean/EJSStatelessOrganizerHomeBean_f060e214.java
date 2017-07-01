package com.hps.july.commonbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessOrganizerHomeBean_f060e214
 */
public class EJSStatelessOrganizerHomeBean_f060e214 extends EJSHome {
	/**
	 * EJSStatelessOrganizerHomeBean_f060e214
	 */
	public EJSStatelessOrganizerHomeBean_f060e214() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.commonbean.Organizer create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.commonbean.Organizer _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.commonbean.Organizer) super.createWrapper(new BeanId(this, null));
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
