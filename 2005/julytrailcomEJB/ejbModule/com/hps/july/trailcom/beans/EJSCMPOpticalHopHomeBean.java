package com.hps.july.trailcom.beans;

/**
 * EJSCMPOpticalHopHomeBean
 */
public class EJSCMPOpticalHopHomeBean extends com.hps.july.trailcom.beans.EJSCMPOpticalHopHomeBean_4fccb61b {
	/**
	 * EJSCMPOpticalHopHomeBean
	 */
	public EJSCMPOpticalHopHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.OpticalHop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.OpticalHop) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
