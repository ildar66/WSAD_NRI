package com.hps.july.persistence2;

/**
 * EJSCMPEtap2HopHomeBean
 */
public class EJSCMPEtap2HopHomeBean extends com.hps.july.persistence2.EJSCMPEtap2HopHomeBean_9a16d484 {
	/**
	 * EJSCMPEtap2HopHomeBean
	 */
	public EJSCMPEtap2HopHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Etap2Hop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Etap2Hop) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
