package com.hps.july.persistence;

/**
 * EJSCMPSearchGrouppingHomeBean
 */
public class EJSCMPSearchGrouppingHomeBean extends com.hps.july.persistence.EJSCMPSearchGrouppingHomeBean_251bf269 {
	/**
	 * EJSCMPSearchGrouppingHomeBean
	 */
	public EJSCMPSearchGrouppingHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SearchGroupping postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SearchGroupping) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
