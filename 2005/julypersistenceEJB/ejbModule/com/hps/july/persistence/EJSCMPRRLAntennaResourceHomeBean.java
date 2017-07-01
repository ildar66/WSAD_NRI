package com.hps.july.persistence;

/**
 * EJSCMPRRLAntennaResourceHomeBean
 */
public class EJSCMPRRLAntennaResourceHomeBean extends com.hps.july.persistence.EJSCMPRRLAntennaResourceHomeBean_ad455fd7 {
	/**
	 * EJSCMPRRLAntennaResourceHomeBean
	 */
	public EJSCMPRRLAntennaResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RRLAntennaResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RRLAntennaResource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
