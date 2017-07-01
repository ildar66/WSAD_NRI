package com.hps.july.persistence;

/**
 * EJSCMPLeaseMutualActInfoHomeBean
 */
public class EJSCMPLeaseMutualActInfoHomeBean extends com.hps.july.persistence.EJSCMPLeaseMutualActInfoHomeBean_77a58df7 {
	/**
	 * EJSCMPLeaseMutualActInfoHomeBean
	 */
	public EJSCMPLeaseMutualActInfoHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualActInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualActInfo) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
