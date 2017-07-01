package com.hps.july.persistence;

/**
 * EJSCMPPIEDocInfoDocPosHomeBean
 */
public class EJSCMPPIEDocInfoDocPosHomeBean extends com.hps.july.persistence.EJSCMPPIEDocInfoDocPosHomeBean_e77ba69e {
	/**
	 * EJSCMPPIEDocInfoDocPosHomeBean
	 */
	public EJSCMPPIEDocInfoDocPosHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDocInfoDocPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDocInfoDocPos) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
