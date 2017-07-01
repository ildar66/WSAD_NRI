package com.hps.july.persistence;

/**
 * EJSCMPStorageCardHomeBean
 */
public class EJSCMPStorageCardHomeBean extends com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca {
	/**
	 * EJSCMPStorageCardHomeBean
	 */
	public EJSCMPStorageCardHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.StorageCard postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.StorageCard) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
