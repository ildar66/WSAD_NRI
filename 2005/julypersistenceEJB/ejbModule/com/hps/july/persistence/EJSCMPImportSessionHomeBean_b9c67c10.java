package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPImportSessionHomeBean_b9c67c10
 */
public class EJSCMPImportSessionHomeBean_b9c67c10 extends EJSHome {
	/**
	 * EJSCMPImportSessionHomeBean_b9c67c10
	 */
	public EJSCMPImportSessionHomeBean_b9c67c10() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ImportSession postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ImportSession) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findImportSessionsByOperator
	 */
	public java.util.Enumeration findImportSessionsByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderImportSessionBean)persister).findImportSessionsByOperator(inKey));	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Boolean isTaskid, java.lang.Integer argTaskId, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderImportSessionBean)persister).findByQBE2(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, isTaskid, argTaskId, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ImportSession create(int argImpsesid, int argImpTaskid, java.sql.Timestamp argImportStart, java.sql.Timestamp argImportEnd, int argOperator, java.lang.String argFilename, int argFilesize, int argReccount, int argErrcount) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ImportSession _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ImportSessionBean bean = (com.hps.july.persistence.ImportSessionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argImpsesid, argImpTaskid, argImportStart, argImportEnd, argOperator, argFilename, argFilesize, argReccount, argErrcount);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderImportSessionBean)persister).findByQBE(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ImportSession findByPrimaryKey(com.hps.july.persistence.ImportSessionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPImportSessionBean_b9c67c10) persister).findByPrimaryKey(key);
	}
	/**
	 * findImportSessionsByImporttask
	 */
	public java.util.Enumeration findImportSessionsByImporttask(com.hps.july.persistence.ImportTaskKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderImportSessionBean)persister).findImportSessionsByImporttask(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ImportSessionBean tmpEJB = (com.hps.july.persistence.ImportSessionBean) generalEJB;
		com.hps.july.persistence.ImportSessionKey keyClass = new com.hps.july.persistence.ImportSessionKey();
		keyClass.impsesid = tmpEJB.impsesid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ImportSessionKey keyFromFields(int f0) {
		com.hps.july.persistence.ImportSessionKey keyClass = new com.hps.july.persistence.ImportSessionKey();
		keyClass.impsesid = f0;
		return keyClass;
	}
}
