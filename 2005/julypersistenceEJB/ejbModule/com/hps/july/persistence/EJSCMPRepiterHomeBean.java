package com.hps.july.persistence;

/**
 * EJSCMPRepiterHomeBean
 */
public class EJSCMPRepiterHomeBean extends com.hps.july.persistence.EJSCMPRepiterHomeBean_8d933516 {
	/**
	 * EJSCMPRepiterHomeBean
	 */
	public EJSCMPRepiterHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Repiter postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Repiter) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
