package com.hps.july.persistence;

/**
 * EJSCMPRateHomeBean
 */
public class EJSCMPRateHomeBean extends com.hps.july.persistence.EJSCMPRateHomeBean_317b6ef3 {
	/**
	 * EJSCMPRateHomeBean
	 */
	public EJSCMPRateHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Rate postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Rate) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
