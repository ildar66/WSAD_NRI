package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessJournalHomeBean_408185ce
 */
public class EJSStatelessJournalHomeBean_408185ce extends EJSHome {
	/**
	 * EJSStatelessJournalHomeBean_408185ce
	 */
	public EJSStatelessJournalHomeBean_408185ce() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.sessionbean.Journal create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.sessionbean.Journal _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.arenda.sessionbean.Journal) super.createWrapper(new BeanId(this, null));
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
