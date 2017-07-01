package com.hps.july.persistence;

/**
 * EJSCMPImportRecordHomeBean
 */
public class EJSCMPImportRecordHomeBean extends com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd {
	/**
	 * EJSCMPImportRecordHomeBean
	 */
	public EJSCMPImportRecordHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ImportRecord postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ImportRecord) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
