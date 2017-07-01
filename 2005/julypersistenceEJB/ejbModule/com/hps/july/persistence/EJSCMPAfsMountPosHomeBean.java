package com.hps.july.persistence;

/**
 * EJSCMPAfsMountPosHomeBean
 */
public class EJSCMPAfsMountPosHomeBean extends com.hps.july.persistence.EJSCMPAfsMountPosHomeBean_2f48d5de {
	/**
	 * EJSCMPAfsMountPosHomeBean
	 */
	public EJSCMPAfsMountPosHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AfsMountPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AfsMountPos) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
