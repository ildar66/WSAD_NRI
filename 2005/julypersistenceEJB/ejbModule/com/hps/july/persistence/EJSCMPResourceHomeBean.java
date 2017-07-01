package com.hps.july.persistence;

/**
 * EJSCMPResourceHomeBean
 */
public class EJSCMPResourceHomeBean extends com.hps.july.persistence.EJSCMPResourceHomeBean_5b81bc6d {
	/**
	 * EJSCMPResourceHomeBean
	 */
	public EJSCMPResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Resource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Resource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
