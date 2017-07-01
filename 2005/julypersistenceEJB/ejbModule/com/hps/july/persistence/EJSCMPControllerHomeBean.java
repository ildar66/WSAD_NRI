package com.hps.july.persistence;

/**
 * EJSCMPControllerHomeBean
 */
public class EJSCMPControllerHomeBean extends com.hps.july.persistence.EJSCMPControllerHomeBean_7e6b4ceb {
	/**
	 * EJSCMPControllerHomeBean
	 */
	public EJSCMPControllerHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Controller postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Controller) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
