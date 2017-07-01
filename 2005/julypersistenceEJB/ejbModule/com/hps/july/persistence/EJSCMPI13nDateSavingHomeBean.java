package com.hps.july.persistence;

/**
 * EJSCMPI13nDateSavingHomeBean
 */
public class EJSCMPI13nDateSavingHomeBean extends com.hps.july.persistence.EJSCMPI13nDateSavingHomeBean_85b3cc12 {
	/**
	 * EJSCMPI13nDateSavingHomeBean
	 */
	public EJSCMPI13nDateSavingHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nDateSaving postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nDateSaving) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
