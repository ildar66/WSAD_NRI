package com.hps.july.persistence;

/**
 * EJSCMPLeaseTaskJournalHomeBean
 */
public class EJSCMPLeaseTaskJournalHomeBean extends com.hps.july.persistence.EJSCMPLeaseTaskJournalHomeBean_d1845446 {
	/**
	 * EJSCMPLeaseTaskJournalHomeBean
	 */
	public EJSCMPLeaseTaskJournalHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseTaskJournal postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseTaskJournal) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
