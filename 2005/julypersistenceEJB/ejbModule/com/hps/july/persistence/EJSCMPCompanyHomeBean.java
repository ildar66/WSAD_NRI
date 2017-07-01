package com.hps.july.persistence;

/**
 * EJSCMPCompanyHomeBean
 */
public class EJSCMPCompanyHomeBean extends com.hps.july.persistence.EJSCMPCompanyHomeBean_d6330f7d {
	/**
	 * EJSCMPCompanyHomeBean
	 */
	public EJSCMPCompanyHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Company postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Company) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
