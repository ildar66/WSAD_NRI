package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatefulDocumentProcessorHomeBean_9dc45a50
 */
public class EJSStatefulDocumentProcessorHomeBean_9dc45a50 extends EJSHome {
	/**
	 * EJSStatefulDocumentProcessorHomeBean_9dc45a50
	 */
	public EJSStatefulDocumentProcessorHomeBean_9dc45a50() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.inventory.sessionbean.DocumentProcessor _EJS_result = null;
boolean createFailed = false;
try {
	beanO = super.createBeanO();
	com.hps.july.inventory.sessionbean.DocumentProcessorBean bean = (com.hps.july.inventory.sessionbean.DocumentProcessorBean) beanO.getEnterpriseBean();
	bean.ejbCreate();
	_EJS_result = (com.hps.july.inventory.sessionbean.DocumentProcessor) super.postCreate(beanO);
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
