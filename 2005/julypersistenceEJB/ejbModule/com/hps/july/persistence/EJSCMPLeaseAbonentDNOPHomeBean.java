package com.hps.july.persistence;

/**
 * EJSCMPLeaseAbonentDNOPHomeBean
 */
public class EJSCMPLeaseAbonentDNOPHomeBean extends com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 {
	/**
	 * EJSCMPLeaseAbonentDNOPHomeBean
	 */
	public EJSCMPLeaseAbonentDNOPHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentDNOP postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentDNOP) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
