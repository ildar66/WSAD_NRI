package com.hps.july.persistence;

/**
 * EJSCMPInternalWayBillHomeBean
 */
public class EJSCMPInternalWayBillHomeBean extends com.hps.july.persistence.EJSCMPInternalWayBillHomeBean_e225b591 {
	/**
	 * EJSCMPInternalWayBillHomeBean
	 */
	public EJSCMPInternalWayBillHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InternalWayBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InternalWayBill) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
