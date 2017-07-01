package com.hps.july.persistence;

/**
 * EJSCMPLeasePaymentHomeBean
 */
public class EJSCMPLeasePaymentHomeBean extends com.hps.july.persistence.EJSCMPLeasePaymentHomeBean_ca59e9e2 {
	/**
	 * EJSCMPLeasePaymentHomeBean
	 */
	public EJSCMPLeasePaymentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePayment) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
