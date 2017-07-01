package com.hps.july.persistence;

/**
 * EJSCMPLeaseRuleHomeBean
 */
public class EJSCMPLeaseRuleHomeBean extends com.hps.july.persistence.EJSCMPLeaseRuleHomeBean_75a2de69 {
	/**
	 * EJSCMPLeaseRuleHomeBean
	 */
	public EJSCMPLeaseRuleHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseRule postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseRule) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
