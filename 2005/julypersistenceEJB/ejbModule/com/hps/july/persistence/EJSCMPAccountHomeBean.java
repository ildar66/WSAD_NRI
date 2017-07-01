package com.hps.july.persistence;

/**
 * EJSCMPAccountHomeBean
 */
public class EJSCMPAccountHomeBean extends com.hps.july.persistence.EJSCMPAccountHomeBean_d70748de {
	/**
	 * EJSCMPAccountHomeBean
	 */
	public EJSCMPAccountHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Account postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Account) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
