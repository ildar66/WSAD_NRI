package com.hps.july.persistence;

/**
 * EJSCMPLeaseResourceHomeBean
 */
public class EJSCMPLeaseResourceHomeBean extends com.hps.july.persistence.EJSCMPLeaseResourceHomeBean_37b5eaeb {
	/**
	 * EJSCMPLeaseResourceHomeBean
	 */
	public EJSCMPLeaseResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseResource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
