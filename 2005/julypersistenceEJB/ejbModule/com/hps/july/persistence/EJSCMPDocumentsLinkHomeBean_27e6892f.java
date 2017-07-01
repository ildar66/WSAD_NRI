package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDocumentsLinkHomeBean_27e6892f
 */
public class EJSCMPDocumentsLinkHomeBean_27e6892f extends EJSHome {
	/**
	 * EJSCMPDocumentsLinkHomeBean_27e6892f
	 */
	public EJSCMPDocumentsLinkHomeBean_27e6892f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DocumentsLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DocumentsLink) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByTypeAndDocFrom
	 */
	public java.util.Enumeration findByTypeAndDocFrom(java.lang.String argType, java.lang.Integer argDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentsLinkBean)persister).findByTypeAndDocFrom(argType, argDoc));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.DocumentsLink findByPrimaryKey(com.hps.july.persistence.DocumentsLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentsLinkBean_27e6892f) persister).findByPrimaryKey(key);
	}
	/**
	 * findDocumentsLinkToByDocumentTo
	 */
	public java.util.Enumeration findDocumentsLinkToByDocumentTo(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentsLinkBean)persister).findDocumentsLinkToByDocumentTo(inKey));	}
	/**
	 * findDocumentsLinkFromByDocumentfrom
	 */
	public java.util.Enumeration findDocumentsLinkFromByDocumentfrom(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentsLinkBean)persister).findDocumentsLinkFromByDocumentfrom(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.DocumentsLink create(java.lang.String argType, java.lang.Integer docFrom, java.lang.Integer docTo) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.DocumentsLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DocumentsLinkBean bean = (com.hps.july.persistence.DocumentsLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argType, docFrom, docTo);
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
	 * findByTypeAndDocTo
	 */
	public java.util.Enumeration findByTypeAndDocTo(java.lang.String argType, java.lang.Integer argDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentsLinkBean)persister).findByTypeAndDocTo(argType, argDoc));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.DocumentsLink create(java.lang.String argType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.DocumentsLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DocumentsLinkBean bean = (com.hps.july.persistence.DocumentsLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argType);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argType);
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
		com.hps.july.persistence.DocumentsLinkBean tmpEJB = (com.hps.july.persistence.DocumentsLinkBean) generalEJB;
		com.hps.july.persistence.DocumentsLinkKey keyClass = new com.hps.july.persistence.DocumentsLinkKey();
		keyClass.type = tmpEJB.type;
		keyClass.documentTo_document = tmpEJB.documentTo_document;
		keyClass.documentfrom_document = tmpEJB.documentfrom_document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentsLinkKey keyFromFields(java.lang.String f0, java.lang.Integer f1, java.lang.Integer f2) {
		com.hps.july.persistence.DocumentsLinkKey keyClass = new com.hps.july.persistence.DocumentsLinkKey();
		keyClass.type = f0;
		keyClass.documentTo_document = f1;
		keyClass.documentfrom_document = f2;
		return keyClass;
	}
}
