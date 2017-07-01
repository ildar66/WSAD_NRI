package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSStatefulArendaTransactionMethodHomeBean_7943be6e
 */
public class EJSStatefulArendaTransactionMethodHomeBean_7943be6e extends EJSHome {
	/**
	 * EJSStatefulArendaTransactionMethodHomeBean_7943be6e
	 */
	public EJSStatefulArendaTransactionMethodHomeBean_7943be6e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.hps.july.arenda.sessionbean.ArendaTransactionMethod create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.hps.july.arenda.sessionbean.ArendaTransactionMethod _EJS_result = null;
boolean createFailed = false;
try {
	beanO = super.createBeanO();
	com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean bean = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean) beanO.getEnterpriseBean();
	bean.ejbCreate();
	_EJS_result = (com.hps.july.arenda.sessionbean.ArendaTransactionMethod) super.postCreate(beanO);
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
