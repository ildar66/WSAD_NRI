package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectActionDocumentHomeBean_957d9470
 */
public class EJSCMPProjectActionDocumentHomeBean_957d9470 extends EJSHome {
	/**
	 * EJSCMPProjectActionDocumentHomeBean_957d9470
	 */
	public EJSCMPProjectActionDocumentHomeBean_957d9470() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectActionDocument postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectActionDocument) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer argProject, java.lang.Boolean isProjectAction, java.lang.Integer argProjectaction, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionDocumentBean)persister).findByQBE(argProject, isProjectAction, argProjectaction, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ProjectActionDocument create(int argProjectactiondocument, int argProjectAction, java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectActionDocument _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectActionDocumentBean bean = (com.hps.july.persistence.ProjectActionDocumentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjectactiondocument, argProjectAction, argDate);
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
	 * findProjectActionDocumentsByProjectaction
	 */
	public java.util.Enumeration findProjectActionDocumentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionDocumentBean)persister).findProjectActionDocumentsByProjectaction(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectActionDocument findByPrimaryKey(com.hps.july.persistence.ProjectActionDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectActionDocumentBean_957d9470) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ProjectActionDocumentBean tmpEJB = (com.hps.july.persistence.ProjectActionDocumentBean) generalEJB;
		com.hps.july.persistence.ProjectActionDocumentKey keyClass = new com.hps.july.persistence.ProjectActionDocumentKey();
		keyClass.projectactiondocument = tmpEJB.projectactiondocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectActionDocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.ProjectActionDocumentKey keyClass = new com.hps.july.persistence.ProjectActionDocumentKey();
		keyClass.projectactiondocument = f0;
		return keyClass;
	}
}
