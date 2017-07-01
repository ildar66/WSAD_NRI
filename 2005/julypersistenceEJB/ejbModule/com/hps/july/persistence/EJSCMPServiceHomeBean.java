package com.hps.july.persistence;

/**
 * EJSCMPServiceHomeBean
 */
public class EJSCMPServiceHomeBean extends com.hps.july.persistence.EJSCMPServiceHomeBean_5badf6ae {
	/**
	 * EJSCMPServiceHomeBean
	 */
	public EJSCMPServiceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Service postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Service) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
