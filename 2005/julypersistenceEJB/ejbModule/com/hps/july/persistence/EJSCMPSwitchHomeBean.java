package com.hps.july.persistence;

/**
 * EJSCMPSwitchHomeBean
 */
public class EJSCMPSwitchHomeBean extends com.hps.july.persistence.EJSCMPSwitchHomeBean_dc445190 {
	/**
	 * EJSCMPSwitchHomeBean
	 */
	public EJSCMPSwitchHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Switch postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Switch) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
