package com.hps.july.persistence;

/**
 * EJSCMPAgregateContentHomeBean
 */
public class EJSCMPAgregateContentHomeBean extends com.hps.july.persistence.EJSCMPAgregateContentHomeBean_d4664c44 {
	/**
	 * EJSCMPAgregateContentHomeBean
	 */
	public EJSCMPAgregateContentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AgregateContent postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AgregateContent) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
