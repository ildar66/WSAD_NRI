package com.hps.july.persistence;

/**
 * EJSCMPLeaseMutualPhoneHomeBean
 */
public class EJSCMPLeaseMutualPhoneHomeBean extends com.hps.july.persistence.EJSCMPLeaseMutualPhoneHomeBean_a18d2f5c {
	/**
	 * EJSCMPLeaseMutualPhoneHomeBean
	 */
	public EJSCMPLeaseMutualPhoneHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualPhone postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualPhone) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
