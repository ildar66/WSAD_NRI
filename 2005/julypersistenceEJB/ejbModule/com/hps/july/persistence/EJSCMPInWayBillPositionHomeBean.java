package com.hps.july.persistence;

/**
 * EJSCMPInWayBillPositionHomeBean
 */
public class EJSCMPInWayBillPositionHomeBean extends com.hps.july.persistence.EJSCMPInWayBillPositionHomeBean_10168c1a {
	/**
	 * EJSCMPInWayBillPositionHomeBean
	 */
	public EJSCMPInWayBillPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InWayBillPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InWayBillPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
