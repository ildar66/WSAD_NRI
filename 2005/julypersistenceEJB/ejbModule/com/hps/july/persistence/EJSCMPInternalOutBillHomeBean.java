package com.hps.july.persistence;

/**
 * EJSCMPInternalOutBillHomeBean
 */
public class EJSCMPInternalOutBillHomeBean extends com.hps.july.persistence.EJSCMPInternalOutBillHomeBean_f359097d {
	/**
	 * EJSCMPInternalOutBillHomeBean
	 */
	public EJSCMPInternalOutBillHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InternalOutBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InternalOutBill) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
