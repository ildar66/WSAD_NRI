package com.hps.july.persistence2;

/**
 * EJSCMPBeenetCategoryHomeBean
 */
public class EJSCMPBeenetCategoryHomeBean extends com.hps.july.persistence2.EJSCMPBeenetCategoryHomeBean_df18e43e {
	/**
	 * EJSCMPBeenetCategoryHomeBean
	 */
	public EJSCMPBeenetCategoryHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.BeenetCategory postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.BeenetCategory) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
