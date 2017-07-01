package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPI13nActResourceSetHomeBean_1b32abe9
 */
public class EJSCMPI13nActResourceSetHomeBean_1b32abe9 extends EJSHome {
	/**
	 * EJSCMPI13nActResourceSetHomeBean_1b32abe9
	 */
	public EJSCMPI13nActResourceSetHomeBean_1b32abe9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nActResourceSet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nActResourceSet) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.I13nActResourceSet findByPrimaryKey(com.hps.july.persistence.I13nActResourceSetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nActResourceSetBean_1b32abe9) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.I13nActResourceSet create(java.lang.Integer argDocument, java.lang.Integer argResource) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nActResourceSet _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nActResourceSetBean bean = (com.hps.july.persistence.I13nActResourceSetBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argResource);
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
	 * create
	 */
	public com.hps.july.persistence.I13nActResourceSet create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nActResourceSet _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nActResourceSetBean bean = (com.hps.july.persistence.I13nActResourceSetBean) beanO.getEnterpriseBean();
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
	 * findI13nActResourceSetByI13nAct
	 */
	public java.util.Enumeration findI13nActResourceSetByI13nAct(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nActResourceSetBean)persister).findI13nActResourceSetByI13nAct(inKey));	}
	/**
	 * findI13nActResourceSetByResource
	 */
	public java.util.Enumeration findI13nActResourceSetByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nActResourceSetBean)persister).findI13nActResourceSetByResource(inKey));	}
	/**
	 * findBlockingRecord
	 */
	public com.hps.july.persistence.I13nActResourceSet findBlockingRecord(java.lang.Integer argResource, java.lang.Integer argStorage, java.sql.Date docDate, java.lang.Integer argCurrentDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nActResourceSetBean_1b32abe9)persister).findBlockingRecord(argResource, argStorage, docDate, argCurrentDocument);	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.I13nActResourceSetBean tmpEJB = (com.hps.july.persistence.I13nActResourceSetBean) generalEJB;
		com.hps.july.persistence.I13nActResourceSetKey keyClass = new com.hps.july.persistence.I13nActResourceSetKey();
		keyClass.resource_resource = tmpEJB.resource_resource;
		keyClass.i13nAct_document = tmpEJB.i13nAct_document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.I13nActResourceSetKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.I13nActResourceSetKey keyClass = new com.hps.july.persistence.I13nActResourceSetKey();
		keyClass.resource_resource = f0;
		keyClass.i13nAct_document = f1;
		return keyClass;
	}
}
