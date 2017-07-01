package com.hps.july.persistence;

/**
 * EJSCMPPositionHomeBean
 */
public class EJSCMPPositionHomeBean extends com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 {
	/**
	 * EJSCMPPositionHomeBean
	 */
	public EJSCMPPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Position postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Position) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
