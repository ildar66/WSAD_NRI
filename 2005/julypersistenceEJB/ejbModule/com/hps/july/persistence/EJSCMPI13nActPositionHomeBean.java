package com.hps.july.persistence;

/**
 * EJSCMPI13nActPositionHomeBean
 */
public class EJSCMPI13nActPositionHomeBean extends com.hps.july.persistence.EJSCMPI13nActPositionHomeBean_b594314c {
	/**
	 * EJSCMPI13nActPositionHomeBean
	 */
	public EJSCMPI13nActPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nActPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nActPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
