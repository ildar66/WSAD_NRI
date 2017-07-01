package com.hps.july.trailcom.beans;

/**
 * EJSCMPHopHomeBean
 */
public class EJSCMPHopHomeBean extends com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 {
	/**
	 * EJSCMPHopHomeBean
	 */
	public EJSCMPHopHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.Hop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.Hop) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
