package com.hps.july.persistence;

/**
 * EJSCMPLeaseMutualRuleNewHomeBean
 */
public class EJSCMPLeaseMutualRuleNewHomeBean extends com.hps.july.persistence.EJSCMPLeaseMutualRuleNewHomeBean_ed76f092 {
	/**
	 * EJSCMPLeaseMutualRuleNewHomeBean
	 */
	public EJSCMPLeaseMutualRuleNewHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualRuleNew) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
