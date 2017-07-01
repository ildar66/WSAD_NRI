package com.hps.july.persistence;

/**
 * EJSCMPOrganizationHomeBean
 */
public class EJSCMPOrganizationHomeBean extends com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 {
	/**
	 * EJSCMPOrganizationHomeBean
	 */
	public EJSCMPOrganizationHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Organization postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Organization) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
