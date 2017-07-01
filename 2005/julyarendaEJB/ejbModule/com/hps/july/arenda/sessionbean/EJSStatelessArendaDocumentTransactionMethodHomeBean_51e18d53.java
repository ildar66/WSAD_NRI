package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessArendaDocumentTransactionMethodHomeBean_51e18d53
 */
public class EJSStatelessArendaDocumentTransactionMethodHomeBean_51e18d53 extends EJSHome {
	/**
	 * EJSStatelessArendaDocumentTransactionMethodHomeBean_51e18d53
	 */
	public EJSStatelessArendaDocumentTransactionMethodHomeBean_51e18d53() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethod create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethod _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethod) super.createWrapper(new BeanId(this, null));
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
