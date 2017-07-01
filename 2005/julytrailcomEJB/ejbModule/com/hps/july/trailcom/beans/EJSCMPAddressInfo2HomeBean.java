package com.hps.july.trailcom.beans;

/**
 * EJSCMPAddressInfo2HomeBean
 */
public class EJSCMPAddressInfo2HomeBean extends com.hps.july.trailcom.beans.EJSCMPAddressInfo2HomeBean_4b0a02cd {
	/**
	 * EJSCMPAddressInfo2HomeBean
	 */
	public EJSCMPAddressInfo2HomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.AddressInfo2 postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.AddressInfo2) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
