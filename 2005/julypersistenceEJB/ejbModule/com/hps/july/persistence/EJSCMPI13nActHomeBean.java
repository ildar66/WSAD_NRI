package com.hps.july.persistence;

/**
 * EJSCMPI13nActHomeBean
 */
public class EJSCMPI13nActHomeBean extends com.hps.july.persistence.EJSCMPI13nActHomeBean_90887391 {
	/**
	 * EJSCMPI13nActHomeBean
	 */
	public EJSCMPI13nActHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nAct) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
