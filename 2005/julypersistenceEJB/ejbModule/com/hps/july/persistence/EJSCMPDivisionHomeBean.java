package com.hps.july.persistence;

/**
 * EJSCMPDivisionHomeBean
 */
public class EJSCMPDivisionHomeBean extends com.hps.july.persistence.EJSCMPDivisionHomeBean_8ba14c1f {
	/**
	 * EJSCMPDivisionHomeBean
	 */
	public EJSCMPDivisionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Division postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Division) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
