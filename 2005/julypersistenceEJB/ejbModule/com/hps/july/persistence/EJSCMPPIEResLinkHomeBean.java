package com.hps.july.persistence;

/**
 * EJSCMPPIEResLinkHomeBean
 */
public class EJSCMPPIEResLinkHomeBean extends com.hps.july.persistence.EJSCMPPIEResLinkHomeBean_3d13a75a {
	/**
	 * EJSCMPPIEResLinkHomeBean
	 */
	public EJSCMPPIEResLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEResLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEResLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
