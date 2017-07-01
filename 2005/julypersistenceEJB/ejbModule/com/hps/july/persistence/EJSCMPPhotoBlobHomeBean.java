package com.hps.july.persistence;

/**
 * EJSCMPPhotoBlobHomeBean
 */
public class EJSCMPPhotoBlobHomeBean extends com.hps.july.persistence.EJSCMPPhotoBlobHomeBean_e4daa2aa {
	/**
	 * EJSCMPPhotoBlobHomeBean
	 */
	public EJSCMPPhotoBlobHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PhotoBlob postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PhotoBlob) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
