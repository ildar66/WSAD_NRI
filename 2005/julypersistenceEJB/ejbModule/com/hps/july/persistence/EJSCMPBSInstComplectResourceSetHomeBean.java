package com.hps.july.persistence;

/**
 * EJSCMPBSInstComplectResourceSetHomeBean
 */
public class EJSCMPBSInstComplectResourceSetHomeBean extends com.hps.july.persistence.EJSCMPBSInstComplectResourceSetHomeBean_c1bebc4d {
	/**
	 * EJSCMPBSInstComplectResourceSetHomeBean
	 */
	public EJSCMPBSInstComplectResourceSetHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.BSInstComplectResourceSet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.BSInstComplectResourceSet) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
