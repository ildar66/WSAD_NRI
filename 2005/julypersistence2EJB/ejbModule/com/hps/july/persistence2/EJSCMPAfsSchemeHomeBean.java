package com.hps.july.persistence2;

/**
 * EJSCMPAfsSchemeHomeBean
 */
public class EJSCMPAfsSchemeHomeBean extends com.hps.july.persistence2.EJSCMPAfsSchemeHomeBean_3edc0e87 {
	/**
	 * EJSCMPAfsSchemeHomeBean
	 */
	public EJSCMPAfsSchemeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.AfsScheme postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.AfsScheme) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
