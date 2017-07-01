package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDocumentActionHomeBean_f5bd2b10
 */
public class EJSCMPDocumentActionHomeBean_f5bd2b10 extends EJSHome {
	/**
	 * EJSCMPDocumentActionHomeBean_f5bd2b10
	 */
	public EJSCMPDocumentActionHomeBean_f5bd2b10() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DocumentAction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DocumentAction) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.DocumentAction create(int argDocAction, java.lang.Integer argDocument, java.sql.Timestamp argWhen) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.DocumentAction _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DocumentActionBean bean = (com.hps.july.persistence.DocumentActionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocAction, argDocument, argWhen);
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
	public com.hps.july.persistence.DocumentAction findByPrimaryKey(com.hps.july.persistence.DocumentActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentActionBean_f5bd2b10) persister).findByPrimaryKey(key);
	}
	/**
	 * findDocumentActionByOperator
	 */
	public java.util.Enumeration findDocumentActionByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentActionBean)persister).findDocumentActionByOperator(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.DocumentActionBean tmpEJB = (com.hps.july.persistence.DocumentActionBean) generalEJB;
		com.hps.july.persistence.DocumentActionKey keyClass = new com.hps.july.persistence.DocumentActionKey();
		keyClass.docAction = tmpEJB.docAction;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentActionKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentActionKey keyClass = new com.hps.july.persistence.DocumentActionKey();
		keyClass.docAction = f0;
		return keyClass;
	}
}
