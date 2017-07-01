package com.hps.july.persistence;

/**
 * EJSCMPWLANHomeBean
 */
public class EJSCMPWLANHomeBean extends com.hps.july.persistence.EJSCMPWLANHomeBean_a4ea2a90 {
	/**
	 * EJSCMPWLANHomeBean
	 */
	public EJSCMPWLANHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.WLAN postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.WLAN) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
