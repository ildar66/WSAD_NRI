package com.hps.july.persistence;

/**
 * EJSCMPChangeLogHomeBean
 */
public class EJSCMPChangeLogHomeBean extends com.hps.july.persistence.EJSCMPChangeLogHomeBean_7a6fd283 {
	/**
	 * EJSCMPChangeLogHomeBean
	 */
	public EJSCMPChangeLogHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChangeLog postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChangeLog) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
