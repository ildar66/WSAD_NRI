package com.hps.july.persistence2;

/**
 * EJSCMPLeaseZPHomeBean
 */
public class EJSCMPLeaseZPHomeBean extends com.hps.july.persistence2.EJSCMPLeaseZPHomeBean_93845009 {
	/**
	 * EJSCMPLeaseZPHomeBean
	 */
	public EJSCMPLeaseZPHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.LeaseZP postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.LeaseZP) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
