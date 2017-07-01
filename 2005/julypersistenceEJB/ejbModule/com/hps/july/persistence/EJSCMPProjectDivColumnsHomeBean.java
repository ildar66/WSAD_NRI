package com.hps.july.persistence;

/**
 * EJSCMPProjectDivColumnsHomeBean
 */
public class EJSCMPProjectDivColumnsHomeBean extends com.hps.july.persistence.EJSCMPProjectDivColumnsHomeBean_822983c0 {
	/**
	 * EJSCMPProjectDivColumnsHomeBean
	 */
	public EJSCMPProjectDivColumnsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectDivColumns postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectDivColumns) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
