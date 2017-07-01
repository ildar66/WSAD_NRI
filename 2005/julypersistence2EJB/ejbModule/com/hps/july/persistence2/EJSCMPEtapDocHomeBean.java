package com.hps.july.persistence2;

/**
 * EJSCMPEtapDocHomeBean
 */
public class EJSCMPEtapDocHomeBean extends com.hps.july.persistence2.EJSCMPEtapDocHomeBean_273da4f8 {
	/**
	 * EJSCMPEtapDocHomeBean
	 */
	public EJSCMPEtapDocHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.EtapDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.EtapDoc) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
