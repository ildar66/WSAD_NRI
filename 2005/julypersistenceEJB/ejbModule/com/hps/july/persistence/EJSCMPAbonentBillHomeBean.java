package com.hps.july.persistence;

/**
 * EJSCMPAbonentBillHomeBean
 */
public class EJSCMPAbonentBillHomeBean extends com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f {
	/**
	 * EJSCMPAbonentBillHomeBean
	 */
	public EJSCMPAbonentBillHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonentBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonentBill) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
