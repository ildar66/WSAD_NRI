package com.hps.july.persistence2;

/**
 * EJSCMPSitedoc2RegionHomeBean
 */
public class EJSCMPSitedoc2RegionHomeBean extends com.hps.july.persistence2.EJSCMPSitedoc2RegionHomeBean_3b145ede {
	/**
	 * EJSCMPSitedoc2RegionHomeBean
	 */
	public EJSCMPSitedoc2RegionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Sitedoc2Region postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Sitedoc2Region) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
