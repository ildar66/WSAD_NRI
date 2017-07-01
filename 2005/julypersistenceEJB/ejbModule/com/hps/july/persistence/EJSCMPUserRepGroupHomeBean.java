package com.hps.july.persistence;

/**
 * EJSCMPUserRepGroupHomeBean
 */
public class EJSCMPUserRepGroupHomeBean extends com.hps.july.persistence.EJSCMPUserRepGroupHomeBean_1512cf12 {
	/**
	 * EJSCMPUserRepGroupHomeBean
	 */
	public EJSCMPUserRepGroupHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.UserRepGroup postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.UserRepGroup) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
