package com.hps.july.persistence;

/**
 * EJSCMPLeasePay2BillHomeBean
 */
public class EJSCMPLeasePay2BillHomeBean extends com.hps.july.persistence.EJSCMPLeasePay2BillHomeBean_9ec63793 {
	/**
	 * EJSCMPLeasePay2BillHomeBean
	 */
	public EJSCMPLeasePay2BillHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePay2Bill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePay2Bill) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
