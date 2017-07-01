package com.hps.july.persistence2;

/**
 * EJSCMPResourceSetClassHomeBean
 */
public class EJSCMPResourceSetClassHomeBean extends com.hps.july.persistence2.EJSCMPResourceSetClassHomeBean_ec9cb440 {
	/**
	 * EJSCMPResourceSetClassHomeBean
	 */
	public EJSCMPResourceSetClassHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ResourceSetClass postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ResourceSetClass) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
