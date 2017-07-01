package com.hps.july.persistence2;

/**
 * EJSCMPResourceGroupHomeBean
 */
public class EJSCMPResourceGroupHomeBean extends com.hps.july.persistence2.EJSCMPResourceGroupHomeBean_34fe15dc {
	/**
	 * EJSCMPResourceGroupHomeBean
	 */
	public EJSCMPResourceGroupHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ResourceGroup postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ResourceGroup) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
