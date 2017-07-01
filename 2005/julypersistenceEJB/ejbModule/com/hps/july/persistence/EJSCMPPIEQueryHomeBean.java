package com.hps.july.persistence;

/**
 * EJSCMPPIEQueryHomeBean
 */
public class EJSCMPPIEQueryHomeBean extends com.hps.july.persistence.EJSCMPPIEQueryHomeBean_3b29e425 {
	/**
	 * EJSCMPPIEQueryHomeBean
	 */
	public EJSCMPPIEQueryHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEQuery postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEQuery) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
