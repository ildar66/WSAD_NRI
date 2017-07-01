package com.hps.july.persistence;

/**
 * EJSCMPLeaseAbonentPhoneHomeBean
 */
public class EJSCMPLeaseAbonentPhoneHomeBean extends com.hps.july.persistence.EJSCMPLeaseAbonentPhoneHomeBean_7612459a {
	/**
	 * EJSCMPLeaseAbonentPhoneHomeBean
	 */
	public EJSCMPLeaseAbonentPhoneHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentPhone postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentPhone) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
