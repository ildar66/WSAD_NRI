package com.hps.july.persistence;

/**
 * EJSCMPLeaseArendaAgreementNewHomeBean
 */
public class EJSCMPLeaseArendaAgreementNewHomeBean extends com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 {
	/**
	 * EJSCMPLeaseArendaAgreementNewHomeBean
	 */
	public EJSCMPLeaseArendaAgreementNewHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseArendaAgreementNew) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
