package com.hps.july.persistence;

/**
 * EJSCMPNamedValueHomeBean
 */
public class EJSCMPNamedValueHomeBean extends com.hps.july.persistence.EJSCMPNamedValueHomeBean_f02f46b8 {
	/**
	 * EJSCMPNamedValueHomeBean
	 */
	public EJSCMPNamedValueHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.NamedValue postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.NamedValue) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
