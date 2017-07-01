package com.hps.july.persistence;

/**
 * EJSCMPExpeditionHomeBean
 */
public class EJSCMPExpeditionHomeBean extends com.hps.july.persistence.EJSCMPExpeditionHomeBean_ced5a42e {
	/**
	 * EJSCMPExpeditionHomeBean
	 */
	public EJSCMPExpeditionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Expedition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Expedition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
