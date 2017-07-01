package com.hps.july.persistence;

/**
 * EJSCMPChangeActHomeBean
 */
public class EJSCMPChangeActHomeBean extends com.hps.july.persistence.EJSCMPChangeActHomeBean_1004ca71 {
	/**
	 * EJSCMPChangeActHomeBean
	 */
	public EJSCMPChangeActHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChangeAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChangeAct) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
