package com.hps.july.persistence;

/**
 * EJSCMPAbonPays2docposHomeBean
 */
public class EJSCMPAbonPays2docposHomeBean extends com.hps.july.persistence.EJSCMPAbonPays2docposHomeBean_10abaa1e {
	/**
	 * EJSCMPAbonPays2docposHomeBean
	 */
	public EJSCMPAbonPays2docposHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonPays2docpos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonPays2docpos) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
