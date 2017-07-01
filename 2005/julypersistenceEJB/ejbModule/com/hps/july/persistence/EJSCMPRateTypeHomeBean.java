package com.hps.july.persistence;

/**
 * EJSCMPRateTypeHomeBean
 */
public class EJSCMPRateTypeHomeBean extends com.hps.july.persistence.EJSCMPRateTypeHomeBean_d51efcee {
	/**
	 * EJSCMPRateTypeHomeBean
	 */
	public EJSCMPRateTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RateType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RateType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
