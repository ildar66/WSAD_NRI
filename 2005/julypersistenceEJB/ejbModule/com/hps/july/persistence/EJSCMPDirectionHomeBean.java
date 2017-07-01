package com.hps.july.persistence;

/**
 * EJSCMPDirectionHomeBean
 */
public class EJSCMPDirectionHomeBean extends com.hps.july.persistence.EJSCMPDirectionHomeBean_ef0dc99a {
	/**
	 * EJSCMPDirectionHomeBean
	 */
	public EJSCMPDirectionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Direction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Direction) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
