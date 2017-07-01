package com.hps.july.trailcom.beans;

/**
 * EJSCMPAddressSpaceHomeBean
 */
public class EJSCMPAddressSpaceHomeBean extends com.hps.july.trailcom.beans.EJSCMPAddressSpaceHomeBean_4288f116 {
	/**
	 * EJSCMPAddressSpaceHomeBean
	 */
	public EJSCMPAddressSpaceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.AddressSpace postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.AddressSpace) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
