package com.hps.july.persistence;

/**
 * EJSCMPSwitchParamsHomeBean
 */
public class EJSCMPSwitchParamsHomeBean extends com.hps.july.persistence.EJSCMPSwitchParamsHomeBean_7de41f30 {
	/**
	 * EJSCMPSwitchParamsHomeBean
	 */
	public EJSCMPSwitchParamsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SwitchParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SwitchParams) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
