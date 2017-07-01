package com.hps.july.persistence2;

/**
 * EJSCMPCableWorkParamsHomeBean
 */
public class EJSCMPCableWorkParamsHomeBean extends com.hps.july.persistence2.EJSCMPCableWorkParamsHomeBean_80ac4c0f {
	/**
	 * EJSCMPCableWorkParamsHomeBean
	 */
	public EJSCMPCableWorkParamsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.CableWorkParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.CableWorkParams) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
