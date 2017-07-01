package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOperatorHomeBean_b06d3afd
 */
public class EJSCMPOperatorHomeBean_b06d3afd extends EJSHome {
	/**
	 * EJSCMPOperatorHomeBean_b06d3afd
	 */
	public EJSCMPOperatorHomeBean_b06d3afd() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Operator postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Operator) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findOperatorsByMan
	 */
	public java.util.Enumeration findOperatorsByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOperatorBean)persister).findOperatorsByMan(inKey));	}
	/**
	 * findOperatorByLastNameOrderByLoginAsc
	 */
	public java.util.Enumeration findOperatorByLastNameOrderByLoginAsc(java.lang.String lastName) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOperatorBean)persister).findOperatorByLastNameOrderByLoginAsc(lastName));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Operator findByPrimaryKey(com.hps.july.persistence.OperatorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPOperatorBean_b06d3afd) persister).findByPrimaryKey(key);
	}
	/**
	 * findByLogin
	 */
	public com.hps.july.persistence.Operator findByLogin(java.lang.String login) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPOperatorBean_b06d3afd)persister).findByLogin(login);	}
	/**
	 * findOperatorsWithImportSessions
	 */
	public java.util.Enumeration findOperatorsWithImportSessions() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOperatorBean)persister).findOperatorsWithImportSessions());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Operator create(int argOperator, java.lang.Integer argMan, java.lang.String argLogin, java.lang.String argPassword, java.lang.Boolean argEnabled) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Operator _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OperatorBean bean = (com.hps.july.persistence.OperatorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOperator, argMan, argLogin, argPassword, argEnabled);
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
	public com.hps.july.persistence.Operator create(int argOperator) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Operator _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OperatorBean bean = (com.hps.july.persistence.OperatorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOperator);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argOperator);
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
		com.hps.july.persistence.OperatorBean tmpEJB = (com.hps.july.persistence.OperatorBean) generalEJB;
		com.hps.july.persistence.OperatorKey keyClass = new com.hps.july.persistence.OperatorKey();
		keyClass.operator = tmpEJB.operator;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.OperatorKey keyFromFields(int f0) {
		com.hps.july.persistence.OperatorKey keyClass = new com.hps.july.persistence.OperatorKey();
		keyClass.operator = f0;
		return keyClass;
	}
}
