package com.hps.july.persistence;

/**
 * EJSCMPGroupHomeBean
 */
public class EJSCMPGroupHomeBean extends com.hps.july.persistence.EJSCMPGroupHomeBean_191efb78 {
	/**
	 * EJSCMPGroupHomeBean
	 */
	public EJSCMPGroupHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Group postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Group) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
