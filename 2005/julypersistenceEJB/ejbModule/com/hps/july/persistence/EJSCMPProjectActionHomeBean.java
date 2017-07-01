package com.hps.july.persistence;

/**
 * EJSCMPProjectActionHomeBean
 */
public class EJSCMPProjectActionHomeBean extends com.hps.july.persistence.EJSCMPProjectActionHomeBean_8e9b9227 {
	/**
	 * EJSCMPProjectActionHomeBean
	 */
	public EJSCMPProjectActionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectAction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectAction) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
