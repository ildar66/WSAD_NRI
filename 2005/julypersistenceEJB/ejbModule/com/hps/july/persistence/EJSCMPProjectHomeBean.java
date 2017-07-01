package com.hps.july.persistence;

/**
 * EJSCMPProjectHomeBean
 */
public class EJSCMPProjectHomeBean extends com.hps.july.persistence.EJSCMPProjectHomeBean_9b5157cc {
	/**
	 * EJSCMPProjectHomeBean
	 */
	public EJSCMPProjectHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Project postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Project) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
