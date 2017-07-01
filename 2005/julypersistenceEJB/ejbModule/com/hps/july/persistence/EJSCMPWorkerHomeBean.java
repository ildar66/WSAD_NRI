package com.hps.july.persistence;

/**
 * EJSCMPWorkerHomeBean
 */
public class EJSCMPWorkerHomeBean extends com.hps.july.persistence.EJSCMPWorkerHomeBean_b6d39ea8 {
	/**
	 * EJSCMPWorkerHomeBean
	 */
	public EJSCMPWorkerHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Worker postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Worker) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
