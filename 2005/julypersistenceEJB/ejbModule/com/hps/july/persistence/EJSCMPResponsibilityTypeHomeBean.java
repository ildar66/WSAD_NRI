package com.hps.july.persistence;

/**
 * EJSCMPResponsibilityTypeHomeBean
 */
public class EJSCMPResponsibilityTypeHomeBean extends com.hps.july.persistence.EJSCMPResponsibilityTypeHomeBean_d47ca10c {
	/**
	 * EJSCMPResponsibilityTypeHomeBean
	 */
	public EJSCMPResponsibilityTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResponsibilityType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResponsibilityType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
