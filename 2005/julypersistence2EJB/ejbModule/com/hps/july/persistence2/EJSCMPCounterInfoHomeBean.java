package com.hps.july.persistence2;

/**
 * EJSCMPCounterInfoHomeBean
 */
public class EJSCMPCounterInfoHomeBean extends com.hps.july.persistence2.EJSCMPCounterInfoHomeBean_422c08e7 {
	/**
	 * EJSCMPCounterInfoHomeBean
	 */
	public EJSCMPCounterInfoHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.CounterInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.CounterInfo) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
