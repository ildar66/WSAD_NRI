package com.hps.july.persistence;

/**
 * EJSCMPInternalWayBillPositionHomeBean
 */
public class EJSCMPInternalWayBillPositionHomeBean extends com.hps.july.persistence.EJSCMPInternalWayBillPositionHomeBean_18be2d9e {
	/**
	 * EJSCMPInternalWayBillPositionHomeBean
	 */
	public EJSCMPInternalWayBillPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InternalWayBillPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InternalWayBillPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
