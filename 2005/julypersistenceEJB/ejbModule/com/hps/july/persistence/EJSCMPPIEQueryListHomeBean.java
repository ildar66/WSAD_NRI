package com.hps.july.persistence;

/**
 * EJSCMPPIEQueryListHomeBean
 */
public class EJSCMPPIEQueryListHomeBean extends com.hps.july.persistence.EJSCMPPIEQueryListHomeBean_543889f5 {
	/**
	 * EJSCMPPIEQueryListHomeBean
	 */
	public EJSCMPPIEQueryListHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEQueryList postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEQueryList) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
