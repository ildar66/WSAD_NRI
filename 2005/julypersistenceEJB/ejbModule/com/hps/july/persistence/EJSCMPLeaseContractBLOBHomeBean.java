package com.hps.july.persistence;

/**
 * EJSCMPLeaseContractBLOBHomeBean
 */
public class EJSCMPLeaseContractBLOBHomeBean extends com.hps.july.persistence.EJSCMPLeaseContractBLOBHomeBean_54b76cb3 {
	/**
	 * EJSCMPLeaseContractBLOBHomeBean
	 */
	public EJSCMPLeaseContractBLOBHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseContractBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseContractBLOB) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
