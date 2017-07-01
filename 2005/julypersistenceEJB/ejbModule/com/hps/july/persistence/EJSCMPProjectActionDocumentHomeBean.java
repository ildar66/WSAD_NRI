package com.hps.july.persistence;

/**
 * EJSCMPProjectActionDocumentHomeBean
 */
public class EJSCMPProjectActionDocumentHomeBean extends com.hps.july.persistence.EJSCMPProjectActionDocumentHomeBean_957d9470 {
	/**
	 * EJSCMPProjectActionDocumentHomeBean
	 */
	public EJSCMPProjectActionDocumentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectActionDocument postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectActionDocument) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
