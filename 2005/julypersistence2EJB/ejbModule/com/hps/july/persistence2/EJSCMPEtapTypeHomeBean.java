package com.hps.july.persistence2;

/**
 * EJSCMPEtapTypeHomeBean
 */
public class EJSCMPEtapTypeHomeBean extends com.hps.july.persistence2.EJSCMPEtapTypeHomeBean_4abb9761 {
	/**
	 * EJSCMPEtapTypeHomeBean
	 */
	public EJSCMPEtapTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.EtapType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.EtapType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
