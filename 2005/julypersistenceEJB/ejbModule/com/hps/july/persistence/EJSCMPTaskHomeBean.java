package com.hps.july.persistence;

/**
 * EJSCMPTaskHomeBean
 */
public class EJSCMPTaskHomeBean extends com.hps.july.persistence.EJSCMPTaskHomeBean_316560a8 {
	/**
	 * EJSCMPTaskHomeBean
	 */
	public EJSCMPTaskHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Task postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Task) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
