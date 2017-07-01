package com.hps.july.persistence;

/**
 * EJSCMPContrAddInfoHomeBean
 */
public class EJSCMPContrAddInfoHomeBean extends com.hps.july.persistence.EJSCMPContrAddInfoHomeBean_bfd683b7 {
	/**
	 * EJSCMPContrAddInfoHomeBean
	 */
	public EJSCMPContrAddInfoHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ContrAddInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ContrAddInfo) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
