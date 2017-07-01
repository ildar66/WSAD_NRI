package com.hps.july.persistence;

/**
 * EJSCMPCfgDocumentHomeBean
 */
public class EJSCMPCfgDocumentHomeBean extends com.hps.july.persistence.EJSCMPCfgDocumentHomeBean_e68167a5 {
	/**
	 * EJSCMPCfgDocumentHomeBean
	 */
	public EJSCMPCfgDocumentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.CfgDocument postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.CfgDocument) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
