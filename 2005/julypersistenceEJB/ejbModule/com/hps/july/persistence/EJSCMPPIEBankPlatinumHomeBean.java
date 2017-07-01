package com.hps.july.persistence;

/**
 * EJSCMPPIEBankPlatinumHomeBean
 */
public class EJSCMPPIEBankPlatinumHomeBean extends com.hps.july.persistence.EJSCMPPIEBankPlatinumHomeBean_7d2bd30b {
	/**
	 * EJSCMPPIEBankPlatinumHomeBean
	 */
	public EJSCMPPIEBankPlatinumHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEBankPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEBankPlatinum) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
