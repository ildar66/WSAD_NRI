package com.hps.july.persistence;

/**
 * EJSCMPRoleHomeBean
 */
public class EJSCMPRoleHomeBean extends com.hps.july.persistence.EJSCMPRoleHomeBean_745b5a02 {
	/**
	 * EJSCMPRoleHomeBean
	 */
	public EJSCMPRoleHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Role postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Role) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
