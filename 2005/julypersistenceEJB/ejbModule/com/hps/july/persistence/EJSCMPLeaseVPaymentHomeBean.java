package com.hps.july.persistence;

/**
 * EJSCMPLeaseVPaymentHomeBean
 */
public class EJSCMPLeaseVPaymentHomeBean extends com.hps.july.persistence.EJSCMPLeaseVPaymentHomeBean_86f8b53d {
	/**
	 * EJSCMPLeaseVPaymentHomeBean
	 */
	public EJSCMPLeaseVPaymentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseVPayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseVPayment) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
