package com.hps.july.persistence;

/**
 * EJSCMPSitedoc2SplaceHomeBean
 */
public class EJSCMPSitedoc2SplaceHomeBean extends com.hps.july.persistence.EJSCMPSitedoc2SplaceHomeBean_5aa991cc {
	/**
	 * EJSCMPSitedoc2SplaceHomeBean
	 */
	public EJSCMPSitedoc2SplaceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Sitedoc2Splace postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Sitedoc2Splace) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
