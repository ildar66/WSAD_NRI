package com.hps.july.persistence;

/**
 * EJSCMPCarHomeBean
 */
public class EJSCMPCarHomeBean extends com.hps.july.persistence.EJSCMPCarHomeBean_b17f05e2 {
	/**
	 * EJSCMPCarHomeBean
	 */
	public EJSCMPCarHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Car postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Car) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
