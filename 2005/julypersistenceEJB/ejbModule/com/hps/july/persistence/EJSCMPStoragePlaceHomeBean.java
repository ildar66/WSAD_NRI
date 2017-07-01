package com.hps.july.persistence;

/**
 * EJSCMPStoragePlaceHomeBean
 */
public class EJSCMPStoragePlaceHomeBean extends com.hps.july.persistence.EJSCMPStoragePlaceHomeBean_f3647562 {
	/**
	 * EJSCMPStoragePlaceHomeBean
	 */
	public EJSCMPStoragePlaceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.StoragePlace postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.StoragePlace) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
