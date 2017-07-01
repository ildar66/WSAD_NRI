package com.hps.july.persistence;

/**
 * EJSCMPContractPositionHomeBean
 */
public class EJSCMPContractPositionHomeBean extends com.hps.july.persistence.EJSCMPContractPositionHomeBean_d1d2b2d1 {
	/**
	 * EJSCMPContractPositionHomeBean
	 */
	public EJSCMPContractPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ContractPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ContractPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
