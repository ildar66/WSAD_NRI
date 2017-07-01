package com.hps.july.persistence;

/**
 * EJSCMPInwayBillHomeBean
 */
public class EJSCMPInwayBillHomeBean extends com.hps.july.persistence.EJSCMPInwayBillHomeBean_643a3105 {
	/**
	 * EJSCMPInwayBillHomeBean
	 */
	public EJSCMPInwayBillHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InwayBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InwayBill) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
