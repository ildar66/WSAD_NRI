package com.hps.july.persistence2;

/**
 * EJSCMPGroup2ResourceHomeBean
 */
public class EJSCMPGroup2ResourceHomeBean extends com.hps.july.persistence2.EJSCMPGroup2ResourceHomeBean_ebda9379 {
	/**
	 * EJSCMPGroup2ResourceHomeBean
	 */
	public EJSCMPGroup2ResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Group2Resource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Group2Resource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
