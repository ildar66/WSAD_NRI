package com.hps.july.persistence2;

/**
 * EJSCMPContainerHomeBean
 */
public class EJSCMPContainerHomeBean extends com.hps.july.persistence2.EJSCMPContainerHomeBean_91f4bd0b {
	/**
	 * EJSCMPContainerHomeBean
	 */
	public EJSCMPContainerHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Container postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Container) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
