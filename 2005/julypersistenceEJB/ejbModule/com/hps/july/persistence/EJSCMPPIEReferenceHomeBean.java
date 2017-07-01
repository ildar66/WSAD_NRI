package com.hps.july.persistence;

/**
 * EJSCMPPIEReferenceHomeBean
 */
public class EJSCMPPIEReferenceHomeBean extends com.hps.july.persistence.EJSCMPPIEReferenceHomeBean_9693a3c8 {
	/**
	 * EJSCMPPIEReferenceHomeBean
	 */
	public EJSCMPPIEReferenceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEReference postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEReference) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
