package com.hps.july.persistence;

/**
 * EJSCMPInWayBillBLOBHomeBean
 */
public class EJSCMPInWayBillBLOBHomeBean extends com.hps.july.persistence.EJSCMPInWayBillBLOBHomeBean_cfd95fed {
	/**
	 * EJSCMPInWayBillBLOBHomeBean
	 */
	public EJSCMPInWayBillBLOBHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InWayBillBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InWayBillBLOB) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
