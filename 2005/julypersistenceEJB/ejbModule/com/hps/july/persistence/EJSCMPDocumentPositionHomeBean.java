package com.hps.july.persistence;

/**
 * EJSCMPDocumentPositionHomeBean
 */
public class EJSCMPDocumentPositionHomeBean extends com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 {
	/**
	 * EJSCMPDocumentPositionHomeBean
	 */
	public EJSCMPDocumentPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DocumentPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DocumentPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
