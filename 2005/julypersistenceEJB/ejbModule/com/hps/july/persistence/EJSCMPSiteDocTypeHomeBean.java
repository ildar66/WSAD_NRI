package com.hps.july.persistence;

/**
 * EJSCMPSiteDocTypeHomeBean
 */
public class EJSCMPSiteDocTypeHomeBean extends com.hps.july.persistence.EJSCMPSiteDocTypeHomeBean_e7563d77 {
	/**
	 * EJSCMPSiteDocTypeHomeBean
	 */
	public EJSCMPSiteDocTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDocType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDocType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
