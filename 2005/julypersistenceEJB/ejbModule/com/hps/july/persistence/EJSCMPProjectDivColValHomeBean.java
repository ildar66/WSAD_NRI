package com.hps.july.persistence;

/**
 * EJSCMPProjectDivColValHomeBean
 */
public class EJSCMPProjectDivColValHomeBean extends com.hps.july.persistence.EJSCMPProjectDivColValHomeBean_8858482b {
	/**
	 * EJSCMPProjectDivColValHomeBean
	 */
	public EJSCMPProjectDivColValHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectDivColVal postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectDivColVal) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
