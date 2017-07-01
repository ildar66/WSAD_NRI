package com.hps.july.persistence;

/**
 * EJSCMPUnitHomeBean
 */
public class EJSCMPUnitHomeBean extends com.hps.july.persistence.EJSCMPUnitHomeBean_7609fbf2 {
	/**
	 * EJSCMPUnitHomeBean
	 */
	public EJSCMPUnitHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Unit postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Unit) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
