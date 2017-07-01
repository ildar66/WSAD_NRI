package com.hps.july.persistence;

/**
 * EJSCMPDocumentActionHomeBean
 */
public class EJSCMPDocumentActionHomeBean extends com.hps.july.persistence.EJSCMPDocumentActionHomeBean_f5bd2b10 {
	/**
	 * EJSCMPDocumentActionHomeBean
	 */
	public EJSCMPDocumentActionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DocumentAction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DocumentAction) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
