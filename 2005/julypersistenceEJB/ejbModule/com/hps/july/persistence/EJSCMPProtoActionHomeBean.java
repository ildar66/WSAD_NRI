package com.hps.july.persistence;

/**
 * EJSCMPProtoActionHomeBean
 */
public class EJSCMPProtoActionHomeBean extends com.hps.july.persistence.EJSCMPProtoActionHomeBean_80500ecc {
	/**
	 * EJSCMPProtoActionHomeBean
	 */
	public EJSCMPProtoActionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProtoAction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProtoAction) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
