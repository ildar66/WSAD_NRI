package com.hps.july.persistence;

/**
 * EJSCMPPIEPayLinkHomeBean
 */
public class EJSCMPPIEPayLinkHomeBean extends com.hps.july.persistence.EJSCMPPIEPayLinkHomeBean_415658e8 {
	/**
	 * EJSCMPPIEPayLinkHomeBean
	 */
	public EJSCMPPIEPayLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPayLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPayLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
