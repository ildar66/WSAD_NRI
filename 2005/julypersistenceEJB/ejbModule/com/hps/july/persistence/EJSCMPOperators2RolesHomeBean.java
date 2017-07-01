package com.hps.july.persistence;

/**
 * EJSCMPOperators2RolesHomeBean
 */
public class EJSCMPOperators2RolesHomeBean extends com.hps.july.persistence.EJSCMPOperators2RolesHomeBean_a0bb30ab {
	/**
	 * EJSCMPOperators2RolesHomeBean
	 */
	public EJSCMPOperators2RolesHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Operators2Roles postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Operators2Roles) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
