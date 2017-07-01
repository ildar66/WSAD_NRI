package com.hps.july.persistence;

/**
 * EJSCMPAfsMountActHomeBean
 */
public class EJSCMPAfsMountActHomeBean extends com.hps.july.persistence.EJSCMPAfsMountActHomeBean_cf191c99 {
	/**
	 * EJSCMPAfsMountActHomeBean
	 */
	public EJSCMPAfsMountActHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AfsMountAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AfsMountAct) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
