package com.hps.july.persistence;

/**
 * EJSCMPResourceSubTypeHomeBean
 */
public class EJSCMPResourceSubTypeHomeBean extends com.hps.july.persistence.EJSCMPResourceSubTypeHomeBean_fc97d1dd {
	/**
	 * EJSCMPResourceSubTypeHomeBean
	 */
	public EJSCMPResourceSubTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceSubType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceSubType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
