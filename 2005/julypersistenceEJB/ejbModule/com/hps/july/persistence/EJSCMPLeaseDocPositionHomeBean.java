package com.hps.july.persistence;

/**
 * EJSCMPLeaseDocPositionHomeBean
 */
public class EJSCMPLeaseDocPositionHomeBean extends com.hps.july.persistence.EJSCMPLeaseDocPositionHomeBean_40024402 {
	/**
	 * EJSCMPLeaseDocPositionHomeBean
	 */
	public EJSCMPLeaseDocPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseDocPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseDocPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
