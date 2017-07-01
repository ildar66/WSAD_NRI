package com.hps.july.persistence;

/**
 * EJSCMPImportTaskHomeBean
 */
public class EJSCMPImportTaskHomeBean extends com.hps.july.persistence.EJSCMPImportTaskHomeBean_d16625d7 {
	/**
	 * EJSCMPImportTaskHomeBean
	 */
	public EJSCMPImportTaskHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ImportTask postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ImportTask) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
