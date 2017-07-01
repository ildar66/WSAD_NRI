package com.hps.july.persistence;

/**
 * EJSCMPRequestHomeBean
 */
public class EJSCMPRequestHomeBean extends com.hps.july.persistence.EJSCMPRequestHomeBean_0e6db469 {
	/**
	 * EJSCMPRequestHomeBean
	 */
	public EJSCMPRequestHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Request postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Request) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
