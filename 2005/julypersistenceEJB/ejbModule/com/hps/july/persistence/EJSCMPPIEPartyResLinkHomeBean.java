package com.hps.july.persistence;

/**
 * EJSCMPPIEPartyResLinkHomeBean
 */
public class EJSCMPPIEPartyResLinkHomeBean extends com.hps.july.persistence.EJSCMPPIEPartyResLinkHomeBean_35cfdc71 {
	/**
	 * EJSCMPPIEPartyResLinkHomeBean
	 */
	public EJSCMPPIEPartyResLinkHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPartyResLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPartyResLink) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
