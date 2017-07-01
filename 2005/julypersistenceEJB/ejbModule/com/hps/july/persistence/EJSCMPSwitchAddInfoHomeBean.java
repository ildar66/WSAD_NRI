package com.hps.july.persistence;

/**
 * EJSCMPSwitchAddInfoHomeBean
 */
public class EJSCMPSwitchAddInfoHomeBean extends com.hps.july.persistence.EJSCMPSwitchAddInfoHomeBean_5fbc6808 {
	/**
	 * EJSCMPSwitchAddInfoHomeBean
	 */
	public EJSCMPSwitchAddInfoHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SwitchAddInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SwitchAddInfo) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
