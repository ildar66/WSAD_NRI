package com.hps.july.persistence;

/**
 * EJSCMPLeaseAbonentBANHomeBean
 */
public class EJSCMPLeaseAbonentBANHomeBean extends com.hps.july.persistence.EJSCMPLeaseAbonentBANHomeBean_9b9e6b10 {
	/**
	 * EJSCMPLeaseAbonentBANHomeBean
	 */
	public EJSCMPLeaseAbonentBANHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentBAN postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentBAN) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
