package com.hps.july.persistence;

/**
 * EJSCMPProjectTypeHomeBean
 */
public class EJSCMPProjectTypeHomeBean extends com.hps.july.persistence.EJSCMPProjectTypeHomeBean_35a970e0 {
	/**
	 * EJSCMPProjectTypeHomeBean
	 */
	public EJSCMPProjectTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
