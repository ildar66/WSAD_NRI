package com.hps.july.persistence2;

/**
 * EJSCMPBeenetObjectHomeBean
 */
public class EJSCMPBeenetObjectHomeBean extends com.hps.july.persistence2.EJSCMPBeenetObjectHomeBean_f8cb309f {
	/**
	 * EJSCMPBeenetObjectHomeBean
	 */
	public EJSCMPBeenetObjectHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.BeenetObject postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.BeenetObject) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
