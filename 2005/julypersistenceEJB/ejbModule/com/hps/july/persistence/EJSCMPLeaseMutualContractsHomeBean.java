package com.hps.july.persistence;

/**
 * EJSCMPLeaseMutualContractsHomeBean
 */
public class EJSCMPLeaseMutualContractsHomeBean extends com.hps.july.persistence.EJSCMPLeaseMutualContractsHomeBean_0dc94a49 {
	/**
	 * EJSCMPLeaseMutualContractsHomeBean
	 */
	public EJSCMPLeaseMutualContractsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualContracts postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualContracts) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
