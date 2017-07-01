package com.hps.july.persistence;

/**
 * EJSCMPLeaseSaldoHomeBean
 */
public class EJSCMPLeaseSaldoHomeBean extends com.hps.july.persistence.EJSCMPLeaseSaldoHomeBean_6f33cd6c {
	/**
	 * EJSCMPLeaseSaldoHomeBean
	 */
	public EJSCMPLeaseSaldoHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseSaldo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseSaldo) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
