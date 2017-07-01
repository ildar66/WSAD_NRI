package com.hps.july.persistence;

/**
 * EJSCMPPIEDopInfoDocHomeBean
 */
public class EJSCMPPIEDopInfoDocHomeBean extends com.hps.july.persistence.EJSCMPPIEDopInfoDocHomeBean_fc0be349 {
	/**
	 * EJSCMPPIEDopInfoDocHomeBean
	 */
	public EJSCMPPIEDopInfoDocHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDopInfoDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDopInfoDoc) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
