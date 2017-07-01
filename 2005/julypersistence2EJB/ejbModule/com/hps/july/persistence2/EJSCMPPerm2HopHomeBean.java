package com.hps.july.persistence2;

/**
 * EJSCMPPerm2HopHomeBean
 */
public class EJSCMPPerm2HopHomeBean extends com.hps.july.persistence2.EJSCMPPerm2HopHomeBean_acbed29c {
	/**
	 * EJSCMPPerm2HopHomeBean
	 */
	public EJSCMPPerm2HopHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Perm2Hop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Perm2Hop) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
