package com.hps.july.persistence;

/**
 * EJSCMPLeasePosSchetFaktHomeBean
 */
public class EJSCMPLeasePosSchetFaktHomeBean extends com.hps.july.persistence.EJSCMPLeasePosSchetFaktHomeBean_13ea5e6d {
	/**
	 * EJSCMPLeasePosSchetFaktHomeBean
	 */
	public EJSCMPLeasePosSchetFaktHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePosSchetFakt postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePosSchetFakt) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
