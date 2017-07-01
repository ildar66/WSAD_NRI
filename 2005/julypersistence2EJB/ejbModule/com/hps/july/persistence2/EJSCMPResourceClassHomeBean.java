package com.hps.july.persistence2;

/**
 * EJSCMPResourceClassHomeBean
 */
public class EJSCMPResourceClassHomeBean extends com.hps.july.persistence2.EJSCMPResourceClassHomeBean_1f74a117 {
	/**
	 * EJSCMPResourceClassHomeBean
	 */
	public EJSCMPResourceClassHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ResourceClass postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ResourceClass) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
