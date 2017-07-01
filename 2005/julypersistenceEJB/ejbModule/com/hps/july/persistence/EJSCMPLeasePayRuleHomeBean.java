package com.hps.july.persistence;

/**
 * EJSCMPLeasePayRuleHomeBean
 */
public class EJSCMPLeasePayRuleHomeBean extends com.hps.july.persistence.EJSCMPLeasePayRuleHomeBean_0016f96c {
	/**
	 * EJSCMPLeasePayRuleHomeBean
	 */
	public EJSCMPLeasePayRuleHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePayRule postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePayRule) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
