package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEMxranLinkHomeBean_8e0472a7
 */
public class EJSCMPPIEMxranLinkHomeBean_8e0472a7 extends EJSHome {
	/**
	 * EJSCMPPIEMxranLinkHomeBean_8e0472a7
	 */
	public EJSCMPPIEMxranLinkHomeBean_8e0472a7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEMxranLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEMxranLink) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findPIEMxranLinksByMxranplatinum
	 */
	public java.util.Enumeration findPIEMxranLinksByMxranplatinum(com.hps.july.persistence.PIEMxranPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEMxranLinkBean)persister).findPIEMxranLinksByMxranplatinum(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEMxranLink create(int argMxrannri, int argOwner, java.lang.String argMxranplatinum) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEMxranLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEMxranLinkBean bean = (com.hps.july.persistence.PIEMxranLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argMxrannri, argOwner, argMxranplatinum);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEMxranLink findByPrimaryKey(com.hps.july.persistence.PIEMxranLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEMxranLinkBean_8e0472a7) persister).findByPrimaryKey(key);
	}
	/**
	 * findByMxrannriOwner
	 */
	public java.util.Enumeration findByMxrannriOwner(java.lang.Integer mxrannri, java.lang.Integer owner) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEMxranLinkBean)persister).findByMxrannriOwner(mxrannri, owner));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEMxranLinkBean tmpEJB = (com.hps.july.persistence.PIEMxranLinkBean) generalEJB;
		com.hps.july.persistence.PIEMxranLinkKey keyClass = new com.hps.july.persistence.PIEMxranLinkKey();
		keyClass.mxrannri = tmpEJB.mxrannri;
		keyClass.mxranplatinum_mxranplatinum = tmpEJB.mxranplatinum_mxranplatinum;
		keyClass.mxranplatinum_owner_organization = tmpEJB.mxranplatinum_owner_organization;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEMxranLinkKey keyFromFields(int f0, java.lang.String f1, java.lang.Integer f2) {
		com.hps.july.persistence.PIEMxranLinkKey keyClass = new com.hps.july.persistence.PIEMxranLinkKey();
		keyClass.mxrannri = f0;
		keyClass.mxranplatinum_mxranplatinum = f1;
		keyClass.mxranplatinum_owner_organization = f2;
		return keyClass;
	}
}
