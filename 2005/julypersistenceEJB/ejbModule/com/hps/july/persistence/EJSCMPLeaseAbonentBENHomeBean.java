package com.hps.july.persistence;

/**
 * EJSCMPLeaseAbonentBENHomeBean
 */
public class EJSCMPLeaseAbonentBENHomeBean extends com.hps.july.persistence.EJSCMPLeaseAbonentBENHomeBean_269c14e7 {
	/**
	 * EJSCMPLeaseAbonentBENHomeBean
	 */
	public EJSCMPLeaseAbonentBENHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentBEN postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentBEN) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
