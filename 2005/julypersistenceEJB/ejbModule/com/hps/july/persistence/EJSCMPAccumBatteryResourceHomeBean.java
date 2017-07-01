package com.hps.july.persistence;

/**
 * EJSCMPAccumBatteryResourceHomeBean
 */
public class EJSCMPAccumBatteryResourceHomeBean extends com.hps.july.persistence.EJSCMPAccumBatteryResourceHomeBean_5ca25302 {
	/**
	 * EJSCMPAccumBatteryResourceHomeBean
	 */
	public EJSCMPAccumBatteryResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AccumBatteryResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AccumBatteryResource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
