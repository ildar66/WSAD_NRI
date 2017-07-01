package com.hps.july.persistence;

/**
 * EJSCMPLeaseSchetFaktHomeBean
 */
public class EJSCMPLeaseSchetFaktHomeBean extends com.hps.july.persistence.EJSCMPLeaseSchetFaktHomeBean_be4c2759 {
	/**
	 * EJSCMPLeaseSchetFaktHomeBean
	 */
	public EJSCMPLeaseSchetFaktHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseSchetFakt postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseSchetFakt) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
