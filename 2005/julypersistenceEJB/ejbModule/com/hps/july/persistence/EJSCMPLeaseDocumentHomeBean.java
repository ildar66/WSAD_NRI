package com.hps.july.persistence;

/**
 * EJSCMPLeaseDocumentHomeBean
 */
public class EJSCMPLeaseDocumentHomeBean extends com.hps.july.persistence.EJSCMPLeaseDocumentHomeBean_a05aa12e {
	/**
	 * EJSCMPLeaseDocumentHomeBean
	 */
	public EJSCMPLeaseDocumentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseDocument postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseDocument) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
