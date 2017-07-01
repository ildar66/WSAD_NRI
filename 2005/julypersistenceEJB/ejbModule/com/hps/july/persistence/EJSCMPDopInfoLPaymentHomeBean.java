package com.hps.july.persistence;

/**
 * EJSCMPDopInfoLPaymentHomeBean
 */
public class EJSCMPDopInfoLPaymentHomeBean extends com.hps.july.persistence.EJSCMPDopInfoLPaymentHomeBean_dc156731 {
	/**
	 * EJSCMPDopInfoLPaymentHomeBean
	 */
	public EJSCMPDopInfoLPaymentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DopInfoLPayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DopInfoLPayment) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
