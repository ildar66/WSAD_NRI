package com.hps.july.persistence;

/**
 * EJSCMPSectorHomeBean
 */
public class EJSCMPSectorHomeBean extends com.hps.july.persistence.EJSCMPSectorHomeBean_905f53fa {
	/**
	 * EJSCMPSectorHomeBean
	 */
	public EJSCMPSectorHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Sector) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
