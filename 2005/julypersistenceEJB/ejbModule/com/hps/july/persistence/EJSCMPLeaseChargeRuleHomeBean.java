package com.hps.july.persistence;

/**
 * EJSCMPLeaseChargeRuleHomeBean
 */
public class EJSCMPLeaseChargeRuleHomeBean extends com.hps.july.persistence.EJSCMPLeaseChargeRuleHomeBean_b513c224 {
	/**
	 * EJSCMPLeaseChargeRuleHomeBean
	 */
	public EJSCMPLeaseChargeRuleHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseChargeRule postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseChargeRule) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
