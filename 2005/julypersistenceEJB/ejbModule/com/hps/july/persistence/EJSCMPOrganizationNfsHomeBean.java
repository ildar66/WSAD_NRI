package com.hps.july.persistence;

/**
 * EJSCMPOrganizationNfsHomeBean
 */
public class EJSCMPOrganizationNfsHomeBean extends com.hps.july.persistence.EJSCMPOrganizationNfsHomeBean_96ffa1c2 {
	/**
	 * EJSCMPOrganizationNfsHomeBean
	 */
	public EJSCMPOrganizationNfsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OrganizationNfs postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OrganizationNfs) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
