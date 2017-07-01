package com.hps.july.persistence;

/**
 * EJSCMPSurplusActHomeBean
 */
public class EJSCMPSurplusActHomeBean extends com.hps.july.persistence.EJSCMPSurplusActHomeBean_ae43edd4 {
	/**
	 * EJSCMPSurplusActHomeBean
	 */
	public EJSCMPSurplusActHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SurplusAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SurplusAct) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
