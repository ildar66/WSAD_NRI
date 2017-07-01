package com.hps.july.persistence2;

/**
 * EJSCMPUserRequestsHomeBean
 */
public class EJSCMPUserRequestsHomeBean extends com.hps.july.persistence2.EJSCMPUserRequestsHomeBean_1c968d68 {
	/**
	 * EJSCMPUserRequestsHomeBean
	 */
	public EJSCMPUserRequestsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.UserRequests postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.UserRequests) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
