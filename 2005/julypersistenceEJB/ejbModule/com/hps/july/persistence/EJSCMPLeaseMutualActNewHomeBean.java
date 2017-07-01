package com.hps.july.persistence;

/**
 * EJSCMPLeaseMutualActNewHomeBean
 */
public class EJSCMPLeaseMutualActNewHomeBean extends com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 {
	/**
	 * EJSCMPLeaseMutualActNewHomeBean
	 */
	public EJSCMPLeaseMutualActNewHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualActNew postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualActNew) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
