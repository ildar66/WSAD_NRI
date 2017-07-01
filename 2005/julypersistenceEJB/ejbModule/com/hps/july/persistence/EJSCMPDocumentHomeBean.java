package com.hps.july.persistence;

/**
 * EJSCMPDocumentHomeBean
 */
public class EJSCMPDocumentHomeBean extends com.hps.july.persistence.EJSCMPDocumentHomeBean_0fc4a4d2 {
	/**
	 * EJSCMPDocumentHomeBean
	 */
	public EJSCMPDocumentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Document postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Document) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
