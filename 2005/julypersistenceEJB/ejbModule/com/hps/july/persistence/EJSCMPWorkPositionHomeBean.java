package com.hps.july.persistence;

/**
 * EJSCMPWorkPositionHomeBean
 */
public class EJSCMPWorkPositionHomeBean extends com.hps.july.persistence.EJSCMPWorkPositionHomeBean_4a9a1b46 {
	/**
	 * EJSCMPWorkPositionHomeBean
	 */
	public EJSCMPWorkPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.WorkPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.WorkPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
