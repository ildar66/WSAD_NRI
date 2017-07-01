package com.hps.july.persistence;

/**
 * EJSCMPPIEDogovorLinkHomeBean
 */
public class EJSCMPPIEDogovorLinkHomeBean extends com.hps.july.persistence.EJSCMPPIEDogovorLinkHomeBean_cfdd92a1 {
	/**
	 * EJSCMPPIEDogovorLinkHomeBean
	 */
	public EJSCMPPIEDogovorLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDogovorLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDogovorLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
