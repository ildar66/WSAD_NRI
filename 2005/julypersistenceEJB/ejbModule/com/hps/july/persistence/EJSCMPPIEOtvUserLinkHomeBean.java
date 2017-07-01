package com.hps.july.persistence;

/**
 * EJSCMPPIEOtvUserLinkHomeBean
 */
public class EJSCMPPIEOtvUserLinkHomeBean extends com.hps.july.persistence.EJSCMPPIEOtvUserLinkHomeBean_112a133a {
	/**
	 * EJSCMPPIEOtvUserLinkHomeBean
	 */
	public EJSCMPPIEOtvUserLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEOtvUserLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEOtvUserLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
