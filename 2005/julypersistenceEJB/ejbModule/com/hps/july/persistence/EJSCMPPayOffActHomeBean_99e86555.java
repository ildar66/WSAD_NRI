package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPayOffActHomeBean_99e86555
 */
public class EJSCMPPayOffActHomeBean_99e86555 extends EJSHome {
	/**
	 * EJSCMPPayOffActHomeBean_99e86555
	 */
	public EJSCMPPayOffActHomeBean_99e86555() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PayOffAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PayOffAct) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PayOffAct create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PayOffAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PayOffActBean bean = (com.hps.july.persistence.PayOffActBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination);
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
	 * findPayOffActMemberByMember1
	 */
	public java.util.Enumeration findPayOffActMemberByMember1(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPayOffActBean)persister).findPayOffActMemberByMember1(inKey));	}
	/**
	 * findPayOffActChairManByChairMan
	 */
	public java.util.Enumeration findPayOffActChairManByChairMan(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPayOffActBean)persister).findPayOffActChairManByChairMan(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PayOffAct findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPayOffActBean_99e86555) persister).findByPrimaryKey(key);
	}
	/**
	 * findDocumentByQBE
	 */
	public java.util.Enumeration findDocumentByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorageFrom, java.lang.Integer storageFrom, java.lang.Boolean isStorageTo, java.lang.Integer storageTo) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPayOffActBean)persister).findDocumentByQBE(isDate, datefrom, dateto, isOrganization, organization, isStorageFrom, storageFrom, isStorageTo, storageTo));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PayOffAct create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PayOffAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PayOffActBean bean = (com.hps.july.persistence.PayOffActBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argBlankDate, argBlankindex, argState);
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
	 * findPayOffActMember2ByMember2
	 */
	public java.util.Enumeration findPayOffActMember2ByMember2(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPayOffActBean)persister).findPayOffActMember2ByMember2(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PayOffAct create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PayOffAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PayOffActBean bean = (com.hps.july.persistence.PayOffActBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocument);
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
		com.hps.july.persistence.PayOffActBean tmpEJB = (com.hps.july.persistence.PayOffActBean) generalEJB;
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = tmpEJB.document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = f0;
		return keyClass;
	}
}
