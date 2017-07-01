package com.hps.july.persistence;

/**
 * EJSCMPRegionAccHomeBean
 */
public class EJSCMPRegionAccHomeBean extends com.hps.july.persistence.EJSCMPRegionAccHomeBean_7d950a32 {
	/**
	 * EJSCMPRegionAccHomeBean
	 */
	public EJSCMPRegionAccHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RegionAcc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RegionAcc) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
