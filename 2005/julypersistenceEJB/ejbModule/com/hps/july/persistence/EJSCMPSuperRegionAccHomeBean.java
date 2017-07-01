package com.hps.july.persistence;

/**
 * EJSCMPSuperRegionAccHomeBean
 */
public class EJSCMPSuperRegionAccHomeBean extends com.hps.july.persistence.EJSCMPSuperRegionAccHomeBean_7cebb5ee {
	/**
	 * EJSCMPSuperRegionAccHomeBean
	 */
	public EJSCMPSuperRegionAccHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SuperRegionAcc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SuperRegionAcc) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
