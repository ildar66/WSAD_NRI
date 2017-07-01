package com.hps.july.dataimport.beans;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessDataImportHomeBean_bdddcc6f
 */
public class EJSStatelessDataImportHomeBean_bdddcc6f extends EJSHome {
	/**
	 * EJSStatelessDataImportHomeBean_bdddcc6f
	 */
	public EJSStatelessDataImportHomeBean_bdddcc6f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.dataimport.beans.DataImport create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.dataimport.beans.DataImport _EJS_result = null;
boolean createFailed = false;
try {
	_EJS_result = (com.hps.july.dataimport.beans.DataImport) super.createWrapper(new BeanId(this, null));
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
