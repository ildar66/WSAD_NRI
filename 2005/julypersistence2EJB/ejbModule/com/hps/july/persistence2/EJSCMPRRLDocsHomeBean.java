package com.hps.july.persistence2;

/**
 * EJSCMPRRLDocsHomeBean
 */
public class EJSCMPRRLDocsHomeBean extends com.hps.july.persistence2.EJSCMPRRLDocsHomeBean_d716392c {
	/**
	 * EJSCMPRRLDocsHomeBean
	 */
	public EJSCMPRRLDocsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.RRLDocs postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.RRLDocs) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
