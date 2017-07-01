package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPComplectHomeBean_a8aaa080
 */
public class EJSCMPComplectHomeBean_a8aaa080 extends EJSHome {
	/**
	 * EJSCMPComplectHomeBean_a8aaa080
	 */
	public EJSCMPComplectHomeBean_a8aaa080() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Complect postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Complect) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findComplectsByComplect
	 */
	public java.util.Enumeration findComplectsByComplect(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderComplectBean)persister).findComplectsByComplect(inKey));	}
	/**
	 * findComplectpartsByParts
	 */
	public java.util.Enumeration findComplectpartsByParts(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderComplectBean)persister).findComplectpartsByParts(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Complect create(java.lang.Integer argComplect, java.lang.Integer argPart) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Complect _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ComplectBean bean = (com.hps.july.persistence.ComplectBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argComplect, argPart);
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
	public com.hps.july.persistence.Complect findByPrimaryKey(com.hps.july.persistence.ComplectKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPComplectBean_a8aaa080) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Complect create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Complect _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ComplectBean bean = (com.hps.july.persistence.ComplectBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ComplectBean tmpEJB = (com.hps.july.persistence.ComplectBean) generalEJB;
		com.hps.july.persistence.ComplectKey keyClass = new com.hps.july.persistence.ComplectKey();
		keyClass.parts_resource = tmpEJB.parts_resource;
		keyClass.complect_resource = tmpEJB.complect_resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ComplectKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.ComplectKey keyClass = new com.hps.july.persistence.ComplectKey();
		keyClass.parts_resource = f0;
		keyClass.complect_resource = f1;
		return keyClass;
	}
}
