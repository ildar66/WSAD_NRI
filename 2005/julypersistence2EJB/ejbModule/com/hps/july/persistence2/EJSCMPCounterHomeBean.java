package com.hps.july.persistence2;

/**
 * EJSCMPCounterHomeBean
 */
public class EJSCMPCounterHomeBean extends com.hps.july.persistence2.EJSCMPCounterHomeBean_b1595563 {
	/**
	 * EJSCMPCounterHomeBean
	 */
	public EJSCMPCounterHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Counter postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Counter) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
