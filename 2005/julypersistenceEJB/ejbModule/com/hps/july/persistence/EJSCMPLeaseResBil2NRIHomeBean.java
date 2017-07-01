package com.hps.july.persistence;

/**
 * EJSCMPLeaseResBil2NRIHomeBean
 */
public class EJSCMPLeaseResBil2NRIHomeBean extends com.hps.july.persistence.EJSCMPLeaseResBil2NRIHomeBean_395277e9 {
	/**
	 * EJSCMPLeaseResBil2NRIHomeBean
	 */
	public EJSCMPLeaseResBil2NRIHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseResBil2NRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseResBil2NRI) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
