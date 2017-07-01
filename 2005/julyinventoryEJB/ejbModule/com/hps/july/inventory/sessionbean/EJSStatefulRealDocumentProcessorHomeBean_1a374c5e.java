package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatefulRealDocumentProcessorHomeBean_1a374c5e
 */
public class EJSStatefulRealDocumentProcessorHomeBean_1a374c5e extends EJSHome {
	/**
	 * EJSStatefulRealDocumentProcessorHomeBean_1a374c5e
	 */
	public EJSStatefulRealDocumentProcessorHomeBean_1a374c5e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.RealDocumentProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.RealDocumentProcessor _EJS_result = null;
boolean createFailed = false;
try {
	beanO = super.createBeanO();
	com.hps.july.inventory.sessionbean.RealDocumentProcessorBean bean = (com.hps.july.inventory.sessionbean.RealDocumentProcessorBean) beanO.getEnterpriseBean();
	bean.ejbCreate();
	_EJS_result = (com.hps.july.inventory.sessionbean.RealDocumentProcessor) super.postCreate(beanO);
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
