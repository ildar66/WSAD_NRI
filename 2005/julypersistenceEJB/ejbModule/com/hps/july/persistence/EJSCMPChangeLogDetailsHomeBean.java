package com.hps.july.persistence;

/**
 * EJSCMPChangeLogDetailsHomeBean
 */
public class EJSCMPChangeLogDetailsHomeBean extends com.hps.july.persistence.EJSCMPChangeLogDetailsHomeBean_f1d1fd8b {
	/**
	 * EJSCMPChangeLogDetailsHomeBean
	 */
	public EJSCMPChangeLogDetailsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChangeLogDetails postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChangeLogDetails) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
