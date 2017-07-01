package com.hps.july.persistence;

/**
 * EJSCMPResourceTaxeHomeBean
 */
public class EJSCMPResourceTaxeHomeBean extends com.hps.july.persistence.EJSCMPResourceTaxeHomeBean_b32c2e5e {
	/**
	 * EJSCMPResourceTaxeHomeBean
	 */
	public EJSCMPResourceTaxeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceTaxe postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceTaxe) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
