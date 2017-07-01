package com.hps.july.persistence;

/**
 * EJSCMPComplectHomeBean
 */
public class EJSCMPComplectHomeBean extends com.hps.july.persistence.EJSCMPComplectHomeBean_a8aaa080 {
	/**
	 * EJSCMPComplectHomeBean
	 */
	public EJSCMPComplectHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Complect postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Complect) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
