package com.hps.july.persistence2;

/**
 * EJSCMPGKRCHDocHomeBean
 */
public class EJSCMPGKRCHDocHomeBean extends com.hps.july.persistence2.EJSCMPGKRCHDocHomeBean_1f693e3f {
	/**
	 * EJSCMPGKRCHDocHomeBean
	 */
	public EJSCMPGKRCHDocHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.GKRCHDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.GKRCHDoc) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
