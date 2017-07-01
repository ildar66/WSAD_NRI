package com.hps.july.persistence;

/**
 * EJSCMPPIESerialResLinkHomeBean
 */
public class EJSCMPPIESerialResLinkHomeBean extends com.hps.july.persistence.EJSCMPPIESerialResLinkHomeBean_1a05d9b3 {
	/**
	 * EJSCMPPIESerialResLinkHomeBean
	 */
	public EJSCMPPIESerialResLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIESerialResLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIESerialResLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
