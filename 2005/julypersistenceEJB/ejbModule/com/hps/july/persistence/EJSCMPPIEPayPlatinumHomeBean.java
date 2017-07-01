package com.hps.july.persistence;

/**
 * EJSCMPPIEPayPlatinumHomeBean
 */
public class EJSCMPPIEPayPlatinumHomeBean extends com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d {
	/**
	 * EJSCMPPIEPayPlatinumHomeBean
	 */
	public EJSCMPPIEPayPlatinumHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPayPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPayPlatinum) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
