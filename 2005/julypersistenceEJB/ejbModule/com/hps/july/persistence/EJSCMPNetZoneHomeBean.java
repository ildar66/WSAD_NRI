package com.hps.july.persistence;

/**
 * EJSCMPNetZoneHomeBean
 */
public class EJSCMPNetZoneHomeBean extends com.hps.july.persistence.EJSCMPNetZoneHomeBean_6ae04792 {
	/**
	 * EJSCMPNetZoneHomeBean
	 */
	public EJSCMPNetZoneHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.NetZone postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.NetZone) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
