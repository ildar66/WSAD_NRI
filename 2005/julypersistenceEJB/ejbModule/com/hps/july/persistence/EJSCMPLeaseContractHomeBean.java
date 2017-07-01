package com.hps.july.persistence;

/**
 * EJSCMPLeaseContractHomeBean
 */
public class EJSCMPLeaseContractHomeBean extends com.hps.july.persistence.EJSCMPLeaseContractHomeBean_62ebfc4f {
	/**
	 * EJSCMPLeaseContractHomeBean
	 */
	public EJSCMPLeaseContractHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseContract postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseContract) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
