package com.hps.july.persistence;

/**
 * EJSCMPCableResourceBandHomeBean
 */
public class EJSCMPCableResourceBandHomeBean extends com.hps.july.persistence.EJSCMPCableResourceBandHomeBean_80c2af09 {
	/**
	 * EJSCMPCableResourceBandHomeBean
	 */
	public EJSCMPCableResourceBandHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.CableResourceBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.CableResourceBand) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
