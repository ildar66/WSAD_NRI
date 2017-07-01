package com.hps.july.persistence;

/**
 * EJSCMPTRXResourceHomeBean
 */
public class EJSCMPTRXResourceHomeBean extends com.hps.july.persistence.EJSCMPTRXResourceHomeBean_92b2ea12 {
	/**
	 * EJSCMPTRXResourceHomeBean
	 */
	public EJSCMPTRXResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.TRXResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.TRXResource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
