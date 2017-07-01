package com.hps.july.persistence;

/**
 * EJSCMPSuperRegionHomeBean
 */
public class EJSCMPSuperRegionHomeBean extends com.hps.july.persistence.EJSCMPSuperRegionHomeBean_2c43a25d {
	/**
	 * EJSCMPSuperRegionHomeBean
	 */
	public EJSCMPSuperRegionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SuperRegion postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SuperRegion) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
