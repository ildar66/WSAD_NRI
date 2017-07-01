package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEMxranPlatinumHomeBean_928b152e
 */
public class EJSCMPPIEMxranPlatinumHomeBean_928b152e extends EJSHome {
	/**
	 * EJSCMPPIEMxranPlatinumHomeBean_928b152e
	 */
	public EJSCMPPIEMxranPlatinumHomeBean_928b152e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEMxranPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEMxranPlatinum) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByMxranNameOwner
	 */
	public java.util.Enumeration findByMxranNameOwner(java.lang.Boolean isMxranPlatinum, java.lang.String mxranplatinum, java.lang.Boolean isName, java.lang.String name, java.lang.Integer owner, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEMxranPlatinumBean)persister).findByMxranNameOwner(isMxranPlatinum, mxranplatinum, isName, name, owner, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEMxranPlatinum create(java.lang.String argMxranplatinum, int argOwner, java.lang.String argStatus, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEMxranPlatinum _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEMxranPlatinumBean bean = (com.hps.july.persistence.PIEMxranPlatinumBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argMxranplatinum, argOwner, argStatus, argName);
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
	 * findPIEMxranPlatinumsByOwner
	 */
	public java.util.Enumeration findPIEMxranPlatinumsByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEMxranPlatinumBean)persister).findPIEMxranPlatinumsByOwner(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEMxranPlatinum findByPrimaryKey(com.hps.july.persistence.PIEMxranPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEMxranPlatinumBean_928b152e) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEMxranPlatinumBean tmpEJB = (com.hps.july.persistence.PIEMxranPlatinumBean) generalEJB;
		com.hps.july.persistence.PIEMxranPlatinumKey keyClass = new com.hps.july.persistence.PIEMxranPlatinumKey();
		keyClass.mxranplatinum = tmpEJB.mxranplatinum;
		keyClass.owner_organization = tmpEJB.owner_organization;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEMxranPlatinumKey keyFromFields(java.lang.String f0, java.lang.Integer f1) {
		com.hps.july.persistence.PIEMxranPlatinumKey keyClass = new com.hps.july.persistence.PIEMxranPlatinumKey();
		keyClass.mxranplatinum = f0;
		keyClass.owner_organization = f1;
		return keyClass;
	}
}
