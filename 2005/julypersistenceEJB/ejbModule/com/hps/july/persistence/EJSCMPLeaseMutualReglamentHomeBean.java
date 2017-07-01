package com.hps.july.persistence;

/**
 * EJSCMPLeaseMutualReglamentHomeBean
 */
public class EJSCMPLeaseMutualReglamentHomeBean extends com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 {
	/**
	 * EJSCMPLeaseMutualReglamentHomeBean
	 */
	public EJSCMPLeaseMutualReglamentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualReglament postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualReglament) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
