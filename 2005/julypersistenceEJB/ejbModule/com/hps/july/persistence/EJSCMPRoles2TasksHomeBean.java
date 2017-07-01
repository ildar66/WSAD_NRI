package com.hps.july.persistence;

/**
 * EJSCMPRoles2TasksHomeBean
 */
public class EJSCMPRoles2TasksHomeBean extends com.hps.july.persistence.EJSCMPRoles2TasksHomeBean_76e15e86 {
	/**
	 * EJSCMPRoles2TasksHomeBean
	 */
	public EJSCMPRoles2TasksHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Roles2Tasks postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Roles2Tasks) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
