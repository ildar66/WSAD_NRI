package com.hps.july.persistence;

/**
 * EJSCMPLeaseOnPositionHomeBean
 */
public class EJSCMPLeaseOnPositionHomeBean extends com.hps.july.persistence.EJSCMPLeaseOnPositionHomeBean_1a97eb14 {
	/**
	 * EJSCMPLeaseOnPositionHomeBean
	 */
	public EJSCMPLeaseOnPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseOnPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseOnPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
