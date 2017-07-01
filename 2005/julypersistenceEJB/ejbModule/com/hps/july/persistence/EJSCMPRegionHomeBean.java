package com.hps.july.persistence;

/**
 * EJSCMPRegionHomeBean
 */
public class EJSCMPRegionHomeBean extends com.hps.july.persistence.EJSCMPRegionHomeBean_e2bb4e3f {
	/**
	 * EJSCMPRegionHomeBean
	 */
	public EJSCMPRegionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Region postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Region) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
