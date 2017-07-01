package com.hps.july.persistence;

/**
 * EJSCMPSiteDocFileHomeBean
 */
public class EJSCMPSiteDocFileHomeBean extends com.hps.july.persistence.EJSCMPSiteDocFileHomeBean_3813d797 {
	/**
	 * EJSCMPSiteDocFileHomeBean
	 */
	public EJSCMPSiteDocFileHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDocFile postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDocFile) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
