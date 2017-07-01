package com.hps.july.persistence;

/**
 * EJSCMPPeopleHomeBean
 */
public class EJSCMPPeopleHomeBean extends com.hps.july.persistence.EJSCMPPeopleHomeBean_5bd41c74 {
	/**
	 * EJSCMPPeopleHomeBean
	 */
	public EJSCMPPeopleHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.People postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.People) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
