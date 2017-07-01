package com.hps.july.persistence;

/**
 * EJSCMPProjectActionCommentsHomeBean
 */
public class EJSCMPProjectActionCommentsHomeBean extends com.hps.july.persistence.EJSCMPProjectActionCommentsHomeBean_0cd9cc41 {
	/**
	 * EJSCMPProjectActionCommentsHomeBean
	 */
	public EJSCMPProjectActionCommentsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectActionComments postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectActionComments) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
