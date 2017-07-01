package com.hps.july.persistence;

/**
 * EJSCMPInventoryNumbersHomeBean
 */
public class EJSCMPInventoryNumbersHomeBean extends com.hps.july.persistence.EJSCMPInventoryNumbersHomeBean_bc436f0d {
	/**
	 * EJSCMPInventoryNumbersHomeBean
	 */
	public EJSCMPInventoryNumbersHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InventoryNumbers postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InventoryNumbers) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
