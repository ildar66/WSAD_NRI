package com.hps.july.persistence;

/**
 * EJSCMPSearchesHomeBean
 */
public class EJSCMPSearchesHomeBean extends com.hps.july.persistence.EJSCMPSearchesHomeBean_cc646049 {
	/**
	 * EJSCMPSearchesHomeBean
	 */
	public EJSCMPSearchesHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Searches postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Searches) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
