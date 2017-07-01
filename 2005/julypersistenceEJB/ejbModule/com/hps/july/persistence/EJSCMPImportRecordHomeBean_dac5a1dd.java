package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPImportRecordHomeBean_dac5a1dd
 */
public class EJSCMPImportRecordHomeBean_dac5a1dd extends EJSHome {
	/**
	 * EJSCMPImportRecordHomeBean_dac5a1dd
	 */
	public EJSCMPImportRecordHomeBean_dac5a1dd() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ImportRecord postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ImportRecord) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findImportRecordsByImportsession
	 */
	public java.util.Enumeration findImportRecordsByImportsession(com.hps.july.persistence.ImportSessionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderImportRecordBean)persister).findImportRecordsByImportsession(inKey));	}
	/**
	 * findByQBE1
	 */
	public java.util.Enumeration findByQBE1(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Boolean isResult, java.lang.String result, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderImportRecordBean)persister).findByQBE1(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, isResult, result, order));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderImportRecordBean)persister).findByQBE(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ImportRecord create(int argImprecid, int argImpSesid, java.sql.Timestamp argRecendtime, java.lang.String argAction, java.lang.String argResult, java.lang.String argErrlabel) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ImportRecord _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ImportRecordBean bean = (com.hps.july.persistence.ImportRecordBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argImprecid, argImpSesid, argRecendtime, argAction, argResult, argErrlabel);
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
	public com.hps.july.persistence.ImportRecord findByPrimaryKey(com.hps.july.persistence.ImportRecordKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPImportRecordBean_dac5a1dd) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ImportRecordBean tmpEJB = (com.hps.july.persistence.ImportRecordBean) generalEJB;
		com.hps.july.persistence.ImportRecordKey keyClass = new com.hps.july.persistence.ImportRecordKey();
		keyClass.imprecid = tmpEJB.imprecid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ImportRecordKey keyFromFields(int f0) {
		com.hps.july.persistence.ImportRecordKey keyClass = new com.hps.july.persistence.ImportRecordKey();
		keyClass.imprecid = f0;
		return keyClass;
	}
}
