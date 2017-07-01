package com.hps.july.persistence;

/**
 * EJSCMPContractHomeBean
 */
public class EJSCMPContractHomeBean extends com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 {
	/**
	 * EJSCMPContractHomeBean
	 */
	public EJSCMPContractHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Contract postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Contract) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
