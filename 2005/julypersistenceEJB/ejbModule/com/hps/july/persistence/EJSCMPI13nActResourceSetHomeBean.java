package com.hps.july.persistence;

/**
 * EJSCMPI13nActResourceSetHomeBean
 */
public class EJSCMPI13nActResourceSetHomeBean extends com.hps.july.persistence.EJSCMPI13nActResourceSetHomeBean_1b32abe9 {
	/**
	 * EJSCMPI13nActResourceSetHomeBean
	 */
	public EJSCMPI13nActResourceSetHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nActResourceSet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nActResourceSet) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
