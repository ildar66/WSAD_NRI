package com.hps.july.persistence;

/**
 * EJSCMPSearchGroupHomeBean
 */
public class EJSCMPSearchGroupHomeBean extends com.hps.july.persistence.EJSCMPSearchGroupHomeBean_59f80681 {
	/**
	 * EJSCMPSearchGroupHomeBean
	 */
	public EJSCMPSearchGroupHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SearchGroup postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SearchGroup) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
