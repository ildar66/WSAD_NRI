package com.hps.july.persistence;

/**
 * EJSCMPPIEMxranPlatinumHomeBean
 */
public class EJSCMPPIEMxranPlatinumHomeBean extends com.hps.july.persistence.EJSCMPPIEMxranPlatinumHomeBean_928b152e {
	/**
	 * EJSCMPPIEMxranPlatinumHomeBean
	 */
	public EJSCMPPIEMxranPlatinumHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEMxranPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEMxranPlatinum) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
