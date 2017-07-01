package com.hps.july.persistence;

/**
 * EJSCMPSiteDocHomeBean
 */
public class EJSCMPSiteDocHomeBean extends com.hps.july.persistence.EJSCMPSiteDocHomeBean_92b2e4e2 {
	/**
	 * EJSCMPSiteDocHomeBean
	 */
	public EJSCMPSiteDocHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDoc) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
