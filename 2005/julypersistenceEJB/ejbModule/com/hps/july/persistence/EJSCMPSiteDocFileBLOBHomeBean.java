package com.hps.july.persistence;

/**
 * EJSCMPSiteDocFileBLOBHomeBean
 */
public class EJSCMPSiteDocFileBLOBHomeBean extends com.hps.july.persistence.EJSCMPSiteDocFileBLOBHomeBean_29f7bad5 {
	/**
	 * EJSCMPSiteDocFileBLOBHomeBean
	 */
	public EJSCMPSiteDocFileBLOBHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDocFileBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDocFileBLOB) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
