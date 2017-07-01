package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessLeaseArendaAgreementProcessorHomeBean_03acdd81
 */
public class EJSStatelessLeaseArendaAgreementProcessorHomeBean_03acdd81 extends EJSHome {
	/**
	 * EJSStatelessLeaseArendaAgreementProcessorHomeBean_03acdd81
	 */
	public EJSStatelessLeaseArendaAgreementProcessorHomeBean_03acdd81() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessor) super.createWrapper(new BeanId(this, null));
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
