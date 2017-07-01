package com.hps.july.persistence;

/**
 * EJSCMPLeaseDNOPHomeBean
 */
public class EJSCMPLeaseDNOPHomeBean extends com.hps.july.persistence.EJSCMPLeaseDNOPHomeBean_93b75ce3 {
	/**
	 * EJSCMPLeaseDNOPHomeBean
	 */
	public EJSCMPLeaseDNOPHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseDNOP postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseDNOP) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
