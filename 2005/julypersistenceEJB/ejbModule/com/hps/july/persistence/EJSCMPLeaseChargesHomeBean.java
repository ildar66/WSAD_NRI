package com.hps.july.persistence;

/**
 * EJSCMPLeaseChargesHomeBean
 */
public class EJSCMPLeaseChargesHomeBean extends com.hps.july.persistence.EJSCMPLeaseChargesHomeBean_4bfbae00 {
	/**
	 * EJSCMPLeaseChargesHomeBean
	 */
	public EJSCMPLeaseChargesHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseCharges postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseCharges) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
