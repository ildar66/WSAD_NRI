package com.hps.july.persistence;

/**
 * EJSCMPCardTrackHomeBean
 */
public class EJSCMPCardTrackHomeBean extends com.hps.july.persistence.EJSCMPCardTrackHomeBean_f33ec78d {
	/**
	 * EJSCMPCardTrackHomeBean
	 */
	public EJSCMPCardTrackHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.CardTrack postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.CardTrack) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
