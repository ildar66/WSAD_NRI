package com.hps.july.persistence;

/**
 * EJSCMPProjectActionTypeHomeBean
 */
public class EJSCMPProjectActionTypeHomeBean extends com.hps.july.persistence.EJSCMPProjectActionTypeHomeBean_c8c0ae31 {
	/**
	 * EJSCMPProjectActionTypeHomeBean
	 */
	public EJSCMPProjectActionTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectActionType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectActionType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
