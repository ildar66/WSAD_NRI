package com.hps.july.persistence2;

/**
 * EJSCMPFreqPermissionHomeBean
 */
public class EJSCMPFreqPermissionHomeBean extends com.hps.july.persistence2.EJSCMPFreqPermissionHomeBean_85b7d5de {
	/**
	 * EJSCMPFreqPermissionHomeBean
	 */
	public EJSCMPFreqPermissionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.FreqPermission postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.FreqPermission) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
