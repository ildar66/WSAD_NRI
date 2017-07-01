package com.hps.july.persistence;

/**
 * EJSCMPPIEQueryLogHomeBean
 */
public class EJSCMPPIEQueryLogHomeBean extends com.hps.july.persistence.EJSCMPPIEQueryLogHomeBean_a5116b49 {
	/**
	 * EJSCMPPIEQueryLogHomeBean
	 */
	public EJSCMPPIEQueryLogHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEQueryLog postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEQueryLog) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
