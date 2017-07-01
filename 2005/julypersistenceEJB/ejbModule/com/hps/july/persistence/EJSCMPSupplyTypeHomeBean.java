package com.hps.july.persistence;

/**
 * EJSCMPSupplyTypeHomeBean
 */
public class EJSCMPSupplyTypeHomeBean extends com.hps.july.persistence.EJSCMPSupplyTypeHomeBean_ef5af5dc {
	/**
	 * EJSCMPSupplyTypeHomeBean
	 */
	public EJSCMPSupplyTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SupplyType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SupplyType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
