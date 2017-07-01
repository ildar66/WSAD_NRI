package com.hps.july.persistence;

/**
 * EJSCMPLeaseCalcRateHomeBean
 */
public class EJSCMPLeaseCalcRateHomeBean extends com.hps.july.persistence.EJSCMPLeaseCalcRateHomeBean_be50a3fb {
	/**
	 * EJSCMPLeaseCalcRateHomeBean
	 */
	public EJSCMPLeaseCalcRateHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseCalcRate postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseCalcRate) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
