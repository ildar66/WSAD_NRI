package com.hps.july.persistence2;

/**
 * EJSCMPMSUserHomeBean
 */
public class EJSCMPMSUserHomeBean extends com.hps.july.persistence2.EJSCMPMSUserHomeBean_0350cd42 {
	/**
	 * EJSCMPMSUserHomeBean
	 */
	public EJSCMPMSUserHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.MSUser postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.MSUser) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
