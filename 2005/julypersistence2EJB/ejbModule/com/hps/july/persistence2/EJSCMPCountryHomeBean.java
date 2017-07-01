package com.hps.july.persistence2;

/**
 * EJSCMPCountryHomeBean
 */
public class EJSCMPCountryHomeBean extends com.hps.july.persistence2.EJSCMPCountryHomeBean_26349d7e {
	/**
	 * EJSCMPCountryHomeBean
	 */
	public EJSCMPCountryHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Country postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Country) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
