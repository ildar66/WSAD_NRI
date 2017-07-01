package com.hps.july.persistence;

/**
 * EJSCMPPIEOtvUserPlatinumHomeBean
 */
public class EJSCMPPIEOtvUserPlatinumHomeBean extends com.hps.july.persistence.EJSCMPPIEOtvUserPlatinumHomeBean_379c5e7f {
	/**
	 * EJSCMPPIEOtvUserPlatinumHomeBean
	 */
	public EJSCMPPIEOtvUserPlatinumHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEOtvUserPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEOtvUserPlatinum) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
