package com.hps.july.persistence;

/**
 * EJSCMPResourceSetPartHomeBean
 */
public class EJSCMPResourceSetPartHomeBean extends com.hps.july.persistence.EJSCMPResourceSetPartHomeBean_6281eecd {
	/**
	 * EJSCMPResourceSetPartHomeBean
	 */
	public EJSCMPResourceSetPartHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceSetPart postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceSetPart) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
