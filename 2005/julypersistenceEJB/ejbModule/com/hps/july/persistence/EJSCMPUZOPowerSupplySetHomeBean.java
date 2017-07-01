package com.hps.july.persistence;

/**
 * EJSCMPUZOPowerSupplySetHomeBean
 */
public class EJSCMPUZOPowerSupplySetHomeBean extends com.hps.july.persistence.EJSCMPUZOPowerSupplySetHomeBean_d36d4692 {
	/**
	 * EJSCMPUZOPowerSupplySetHomeBean
	 */
	public EJSCMPUZOPowerSupplySetHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.UZOPowerSupplySet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.UZOPowerSupplySet) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
