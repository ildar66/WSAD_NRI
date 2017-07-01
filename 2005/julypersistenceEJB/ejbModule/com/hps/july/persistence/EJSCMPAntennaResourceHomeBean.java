package com.hps.july.persistence;

/**
 * EJSCMPAntennaResourceHomeBean
 */
public class EJSCMPAntennaResourceHomeBean extends com.hps.july.persistence.EJSCMPAntennaResourceHomeBean_8763e04a {
	/**
	 * EJSCMPAntennaResourceHomeBean
	 */
	public EJSCMPAntennaResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AntennaResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AntennaResource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
