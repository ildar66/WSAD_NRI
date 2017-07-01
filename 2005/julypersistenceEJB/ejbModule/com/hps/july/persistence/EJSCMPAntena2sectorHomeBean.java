package com.hps.july.persistence;

/**
 * EJSCMPAntena2sectorHomeBean
 */
public class EJSCMPAntena2sectorHomeBean extends com.hps.july.persistence.EJSCMPAntena2sectorHomeBean_7186a7b4 {
	/**
	 * EJSCMPAntena2sectorHomeBean
	 */
	public EJSCMPAntena2sectorHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Antena2sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Antena2sector) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
