package com.hps.july.persistence;

/**
 * EJSCMPBaseAgreementHomeBean
 */
public class EJSCMPBaseAgreementHomeBean extends com.hps.july.persistence.EJSCMPBaseAgreementHomeBean_74ca5fa3 {
	/**
	 * EJSCMPBaseAgreementHomeBean
	 */
	public EJSCMPBaseAgreementHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.BaseAgreement postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.BaseAgreement) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
