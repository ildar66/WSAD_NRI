package com.hps.july.persistence;

/**
 * EJSCMPProjectStateHomeBean
 */
public class EJSCMPProjectStateHomeBean extends com.hps.july.persistence.EJSCMPProjectStateHomeBean_bf7cc4df {
	/**
	 * EJSCMPProjectStateHomeBean
	 */
	public EJSCMPProjectStateHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectState postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectState) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
