package com.hps.july.persistence;

/**
 * EJSCMPPIEResPlatinumHomeBean
 */
public class EJSCMPPIEResPlatinumHomeBean extends com.hps.july.persistence.EJSCMPPIEResPlatinumHomeBean_54515811 {
	/**
	 * EJSCMPPIEResPlatinumHomeBean
	 */
	public EJSCMPPIEResPlatinumHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEResPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEResPlatinum) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
