package com.hps.july.persistence;

/**
 * EJSCMPChanalPowerHomeBean
 */
public class EJSCMPChanalPowerHomeBean extends com.hps.july.persistence.EJSCMPChanalPowerHomeBean_a231b69f {
	/**
	 * EJSCMPChanalPowerHomeBean
	 */
	public EJSCMPChanalPowerHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChanalPower postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChanalPower) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
