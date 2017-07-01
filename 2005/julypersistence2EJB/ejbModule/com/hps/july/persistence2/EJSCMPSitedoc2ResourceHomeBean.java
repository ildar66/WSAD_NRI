package com.hps.july.persistence2;

/**
 * EJSCMPSitedoc2ResourceHomeBean
 */
public class EJSCMPSitedoc2ResourceHomeBean extends com.hps.july.persistence2.EJSCMPSitedoc2ResourceHomeBean_8be96277 {
	/**
	 * EJSCMPSitedoc2ResourceHomeBean
	 */
	public EJSCMPSitedoc2ResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Sitedoc2Resource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Sitedoc2Resource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
