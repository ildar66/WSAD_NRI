package com.hps.july.persistence;

/**
 * EJSCMPBankHomeBean
 */
public class EJSCMPBankHomeBean extends com.hps.july.persistence.EJSCMPBankHomeBean_96552406 {
	/**
	 * EJSCMPBankHomeBean
	 */
	public EJSCMPBankHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Bank postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Bank) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
