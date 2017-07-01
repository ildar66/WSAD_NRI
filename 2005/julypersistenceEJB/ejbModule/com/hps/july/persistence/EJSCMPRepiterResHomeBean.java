package com.hps.july.persistence;

/**
 * EJSCMPRepiterResHomeBean
 */
public class EJSCMPRepiterResHomeBean extends com.hps.july.persistence.EJSCMPRepiterResHomeBean_afbcb081 {
	/**
	 * EJSCMPRepiterResHomeBean
	 */
	public EJSCMPRepiterResHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RepiterRes postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RepiterRes) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
