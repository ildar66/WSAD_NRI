package com.hps.july.persistence;

/**
 * EJSCMPAntennaResourceBandHomeBean
 */
public class EJSCMPAntennaResourceBandHomeBean extends com.hps.july.persistence.EJSCMPAntennaResourceBandHomeBean_b73af947 {
	/**
	 * EJSCMPAntennaResourceBandHomeBean
	 */
	public EJSCMPAntennaResourceBandHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AntennaResourceBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AntennaResourceBand) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
