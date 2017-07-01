package com.hps.july.persistence;

/**
 * EJSCMPIBPMountPosHomeBean
 */
public class EJSCMPIBPMountPosHomeBean extends com.hps.july.persistence.EJSCMPIBPMountPosHomeBean_8792ede8 {
	/**
	 * EJSCMPIBPMountPosHomeBean
	 */
	public EJSCMPIBPMountPosHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.IBPMountPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.IBPMountPos) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
