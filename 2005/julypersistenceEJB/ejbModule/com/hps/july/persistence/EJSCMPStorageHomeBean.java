package com.hps.july.persistence;

/**
 * EJSCMPStorageHomeBean
 */
public class EJSCMPStorageHomeBean extends com.hps.july.persistence.EJSCMPStorageHomeBean_930d19ef {
	/**
	 * EJSCMPStorageHomeBean
	 */
	public EJSCMPStorageHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Storage postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Storage) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
