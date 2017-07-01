package com.hps.july.persistence;

/**
 * EJSCMPPIEBudjetHomeBean
 */
public class EJSCMPPIEBudjetHomeBean extends com.hps.july.persistence.EJSCMPPIEBudjetHomeBean_740d54eb {
	/**
	 * EJSCMPPIEBudjetHomeBean
	 */
	public EJSCMPPIEBudjetHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEBudjet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEBudjet) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
