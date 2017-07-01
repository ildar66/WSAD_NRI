package com.hps.july.journal.beans;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessJournalHomeBean_d19677f4
 */
public class EJSStatelessJournalHomeBean_d19677f4 extends EJSHome {
	/**
	 * EJSStatelessJournalHomeBean_d19677f4
	 */
	public EJSStatelessJournalHomeBean_d19677f4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.journal.beans.Journal create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.journal.beans.Journal _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.journal.beans.Journal) super.createWrapper(new BeanId(this, null));
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
