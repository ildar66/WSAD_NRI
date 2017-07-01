package com.hps.july.trailcom.beans;

/**
 * EJSCMPAddressInfoHomeBean
 */
public class EJSCMPAddressInfoHomeBean extends com.hps.july.trailcom.beans.EJSCMPAddressInfoHomeBean_a0760d65 {
	/**
	 * EJSCMPAddressInfoHomeBean
	 */
	public EJSCMPAddressInfoHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.AddressInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.AddressInfo) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
