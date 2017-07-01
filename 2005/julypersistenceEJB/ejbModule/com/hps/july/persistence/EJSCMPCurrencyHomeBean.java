package com.hps.july.persistence;

/**
 * EJSCMPCurrencyHomeBean
 */
public class EJSCMPCurrencyHomeBean extends com.hps.july.persistence.EJSCMPCurrencyHomeBean_bce2196f {
	/**
	 * EJSCMPCurrencyHomeBean
	 */
	public EJSCMPCurrencyHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Currency postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Currency) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
