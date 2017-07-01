package com.hps.july.persistence;

/**
 * EJSCMPContrParamsHomeBean
 */
public class EJSCMPContrParamsHomeBean extends com.hps.july.persistence.EJSCMPContrParamsHomeBean_7788f282 {
	/**
	 * EJSCMPContrParamsHomeBean
	 */
	public EJSCMPContrParamsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ContrParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ContrParams) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
