package com.hps.july.persistence2;

/**
 * EJSCMPAntennaCableHomeBean
 */
public class EJSCMPAntennaCableHomeBean extends com.hps.july.persistence2.EJSCMPAntennaCableHomeBean_0c548ccb {
	/**
	 * EJSCMPAntennaCableHomeBean
	 */
	public EJSCMPAntennaCableHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.AntennaCable postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.AntennaCable) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
