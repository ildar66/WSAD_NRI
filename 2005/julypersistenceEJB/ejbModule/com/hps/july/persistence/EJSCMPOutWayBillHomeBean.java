package com.hps.july.persistence;

/**
 * EJSCMPOutWayBillHomeBean
 */
public class EJSCMPOutWayBillHomeBean extends com.hps.july.persistence.EJSCMPOutWayBillHomeBean_5b0d6fb6 {
	/**
	 * EJSCMPOutWayBillHomeBean
	 */
	public EJSCMPOutWayBillHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OutWayBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OutWayBill) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
