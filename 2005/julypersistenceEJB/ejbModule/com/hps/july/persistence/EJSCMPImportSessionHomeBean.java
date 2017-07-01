package com.hps.july.persistence;

/**
 * EJSCMPImportSessionHomeBean
 */
public class EJSCMPImportSessionHomeBean extends com.hps.july.persistence.EJSCMPImportSessionHomeBean_b9c67c10 {
	/**
	 * EJSCMPImportSessionHomeBean
	 */
	public EJSCMPImportSessionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ImportSession postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ImportSession) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
