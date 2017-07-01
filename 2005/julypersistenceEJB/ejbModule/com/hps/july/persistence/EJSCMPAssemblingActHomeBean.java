package com.hps.july.persistence;

/**
 * EJSCMPAssemblingActHomeBean
 */
public class EJSCMPAssemblingActHomeBean extends com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 {
	/**
	 * EJSCMPAssemblingActHomeBean
	 */
	public EJSCMPAssemblingActHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AssemblingAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AssemblingAct) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
