package com.hps.july.persistence2;

/**
 * EJSCMPConfBSNfsHomeBean
 */
public class EJSCMPConfBSNfsHomeBean extends com.hps.july.persistence2.EJSCMPConfBSNfsHomeBean_4e13be9f {
	/**
	 * EJSCMPConfBSNfsHomeBean
	 */
	public EJSCMPConfBSNfsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ConfBSNfs postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ConfBSNfs) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
