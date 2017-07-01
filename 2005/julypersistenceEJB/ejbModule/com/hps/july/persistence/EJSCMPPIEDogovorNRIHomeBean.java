package com.hps.july.persistence;

/**
 * EJSCMPPIEDogovorNRIHomeBean
 */
public class EJSCMPPIEDogovorNRIHomeBean extends com.hps.july.persistence.EJSCMPPIEDogovorNRIHomeBean_c9266334 {
	/**
	 * EJSCMPPIEDogovorNRIHomeBean
	 */
	public EJSCMPPIEDogovorNRIHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDogovorNRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDogovorNRI) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
