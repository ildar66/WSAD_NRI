package com.hps.july.persistence;

/**
 * EJSCMPResourceTypeHomeBean
 */
public class EJSCMPResourceTypeHomeBean extends com.hps.july.persistence.EJSCMPResourceTypeHomeBean_482c8901 {
	/**
	 * EJSCMPResourceTypeHomeBean
	 */
	public EJSCMPResourceTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
