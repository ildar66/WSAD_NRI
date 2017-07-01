package com.hps.july.persistence;

/**
 * EJSCMPAntennaWorkBandHomeBean
 */
public class EJSCMPAntennaWorkBandHomeBean extends com.hps.july.persistence.EJSCMPAntennaWorkBandHomeBean_8b2ccd86 {
	/**
	 * EJSCMPAntennaWorkBandHomeBean
	 */
	public EJSCMPAntennaWorkBandHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AntennaWorkBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AntennaWorkBand) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
