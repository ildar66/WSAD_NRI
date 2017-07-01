package com.hps.july.persistence;

/**
 * EJSCMPAbonentPaymentHomeBean
 */
public class EJSCMPAbonentPaymentHomeBean extends com.hps.july.persistence.EJSCMPAbonentPaymentHomeBean_a0239318 {
	/**
	 * EJSCMPAbonentPaymentHomeBean
	 */
	public EJSCMPAbonentPaymentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonentPayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonentPayment) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
