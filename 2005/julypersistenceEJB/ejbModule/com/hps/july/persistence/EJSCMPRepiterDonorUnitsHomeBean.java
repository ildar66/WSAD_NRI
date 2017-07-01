package com.hps.july.persistence;

/**
 * EJSCMPRepiterDonorUnitsHomeBean
 */
public class EJSCMPRepiterDonorUnitsHomeBean extends com.hps.july.persistence.EJSCMPRepiterDonorUnitsHomeBean_2f97607b {
	/**
	 * EJSCMPRepiterDonorUnitsHomeBean
	 */
	public EJSCMPRepiterDonorUnitsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RepiterDonorUnits postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RepiterDonorUnits) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
