package com.hps.july.persistence;

/**
 * EJSCMPAbonentBillPosHomeBean
 */
public class EJSCMPAbonentBillPosHomeBean extends com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f {
	/**
	 * EJSCMPAbonentBillPosHomeBean
	 */
	public EJSCMPAbonentBillPosHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonentBillPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonentBillPos) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
