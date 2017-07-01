package com.hps.july.persistence;

/**
 * EJSCMPDocumentsLinkHomeBean
 */
public class EJSCMPDocumentsLinkHomeBean extends com.hps.july.persistence.EJSCMPDocumentsLinkHomeBean_27e6892f {
	/**
	 * EJSCMPDocumentsLinkHomeBean
	 */
	public EJSCMPDocumentsLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DocumentsLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DocumentsLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
