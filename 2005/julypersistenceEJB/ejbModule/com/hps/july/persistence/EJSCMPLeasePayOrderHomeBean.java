package com.hps.july.persistence;

/**
 * EJSCMPLeasePayOrderHomeBean
 */
public class EJSCMPLeasePayOrderHomeBean extends com.hps.july.persistence.EJSCMPLeasePayOrderHomeBean_45cd0b0b {
	/**
	 * EJSCMPLeasePayOrderHomeBean
	 */
	public EJSCMPLeasePayOrderHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePayOrder postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePayOrder) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
