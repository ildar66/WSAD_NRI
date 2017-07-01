package com.hps.july.persistence;

/**
 * EJSCMPContractBLOBHomeBean
 */
public class EJSCMPContractBLOBHomeBean extends com.hps.july.persistence.EJSCMPContractBLOBHomeBean_a15f3a15 {
	/**
	 * EJSCMPContractBLOBHomeBean
	 */
	public EJSCMPContractBLOBHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ContractBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ContractBLOB) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
