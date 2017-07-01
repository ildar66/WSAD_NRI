package com.hps.july.trailcom.beans;

/**
 * EJSCMPHopLabelHomeBean
 */
public class EJSCMPHopLabelHomeBean extends com.hps.july.trailcom.beans.EJSCMPHopLabelHomeBean_ef74715e {
	/**
	 * EJSCMPHopLabelHomeBean
	 */
	public EJSCMPHopLabelHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.HopLabel postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.HopLabel) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
