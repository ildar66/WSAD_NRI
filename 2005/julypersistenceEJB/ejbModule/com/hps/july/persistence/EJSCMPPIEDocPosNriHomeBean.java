package com.hps.july.persistence;

/**
 * EJSCMPPIEDocPosNriHomeBean
 */
public class EJSCMPPIEDocPosNriHomeBean extends com.hps.july.persistence.EJSCMPPIEDocPosNriHomeBean_b724c6bf {
	/**
	 * EJSCMPPIEDocPosNriHomeBean
	 */
	public EJSCMPPIEDocPosNriHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDocPosNri postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDocPosNri) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
