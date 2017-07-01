package com.hps.july.persistence;

/**
 * EJSCMPPIEMxranLinkHomeBean
 */
public class EJSCMPPIEMxranLinkHomeBean extends com.hps.july.persistence.EJSCMPPIEMxranLinkHomeBean_8e0472a7 {
	/**
	 * EJSCMPPIEMxranLinkHomeBean
	 */
	public EJSCMPPIEMxranLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEMxranLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEMxranLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
