package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEReferenceHomeBean_9693a3c8
 */
public class EJSCMPPIEReferenceHomeBean_9693a3c8 extends EJSHome {
	/**
	 * EJSCMPPIEReferenceHomeBean_9693a3c8
	 */
	public EJSCMPPIEReferenceHomeBean_9693a3c8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEReference postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEReference) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEReference findByPrimaryKey(com.hps.july.persistence.PIEReferenceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEReferenceBean_9693a3c8) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEReference create(int argIdreference, int argOwner, java.lang.String argIdPlatinum, java.lang.String argPStatus, java.lang.String argSprav, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEReference _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEReferenceBean bean = (com.hps.july.persistence.PIEReferenceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdreference, argOwner, argIdPlatinum, argPStatus, argSprav, argName);
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
	 * findBySpravOrderByCodeAsc
	 */
	public java.util.Enumeration findBySpravOrderByCodeAsc(java.lang.String argSprav) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEReferenceBean)persister).findBySpravOrderByCodeAsc(argSprav));	}
	/**
	 * findByOwnerAndSpravOrderByNameAsc
	 */
	public java.util.Enumeration findByOwnerAndSpravOrderByNameAsc(java.lang.Integer argOwner, java.lang.String argSprav) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEReferenceBean)persister).findByOwnerAndSpravOrderByNameAsc(argOwner, argSprav));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEReferenceBean tmpEJB = (com.hps.july.persistence.PIEReferenceBean) generalEJB;
		com.hps.july.persistence.PIEReferenceKey keyClass = new com.hps.july.persistence.PIEReferenceKey();
		keyClass.idreference = tmpEJB.idreference;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEReferenceKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEReferenceKey keyClass = new com.hps.july.persistence.PIEReferenceKey();
		keyClass.idreference = f0;
		return keyClass;
	}
}
