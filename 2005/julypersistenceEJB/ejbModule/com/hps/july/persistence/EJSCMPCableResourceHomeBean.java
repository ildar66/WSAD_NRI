package com.hps.july.persistence;

/**
 * EJSCMPCableResourceHomeBean
 */
public class EJSCMPCableResourceHomeBean extends com.hps.july.persistence.EJSCMPCableResourceHomeBean_df1d097a {
	/**
	 * EJSCMPCableResourceHomeBean
	 */
	public EJSCMPCableResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.CableResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.CableResource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
