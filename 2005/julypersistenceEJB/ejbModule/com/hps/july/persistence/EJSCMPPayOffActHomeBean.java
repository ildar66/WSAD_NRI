package com.hps.july.persistence;

/**
 * EJSCMPPayOffActHomeBean
 */
public class EJSCMPPayOffActHomeBean extends com.hps.july.persistence.EJSCMPPayOffActHomeBean_99e86555 {
	/**
	 * EJSCMPPayOffActHomeBean
	 */
	public EJSCMPPayOffActHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PayOffAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PayOffAct) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
