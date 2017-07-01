package com.hps.july.persistence;

/**
 * EJSCMPAntennaHomeBean
 */
public class EJSCMPAntennaHomeBean extends com.hps.july.persistence.EJSCMPAntennaHomeBean_8f208dce {
	/**
	 * EJSCMPAntennaHomeBean
	 */
	public EJSCMPAntennaHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Antenna postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Antenna) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
