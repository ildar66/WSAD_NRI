package com.hps.july.persistence;

/**
 * EJSCMPPIEValutesHomeBean
 */
public class EJSCMPPIEValutesHomeBean extends com.hps.july.persistence.EJSCMPPIEValutesHomeBean_ef13060b {
	/**
	 * EJSCMPPIEValutesHomeBean
	 */
	public EJSCMPPIEValutesHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEValutes postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEValutes) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
