package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessArendaDocumentProcessorHomeBean_49b89b95
 */
public class EJSStatelessArendaDocumentProcessorHomeBean_49b89b95 extends EJSHome {
	/**
	 * EJSStatelessArendaDocumentProcessorHomeBean_49b89b95
	 */
	public EJSStatelessArendaDocumentProcessorHomeBean_49b89b95() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.sessionbean.ArendaDocumentProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.sessionbean.ArendaDocumentProcessor _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessor) super.createWrapper(new BeanId(this, null));
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
