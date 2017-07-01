package com.hps.july.persistence;

/**
 * EJSCMPResourceSetHomeBean
 */
public class EJSCMPResourceSetHomeBean extends com.hps.july.persistence.EJSCMPResourceSetHomeBean_bc3c01ac {
	/**
	 * EJSCMPResourceSetHomeBean
	 */
	public EJSCMPResourceSetHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceSet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceSet) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
