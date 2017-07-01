package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDivisionHomeBean_8ba14c1f
 */
public class EJSCMPDivisionHomeBean_8ba14c1f extends EJSHome {
	/**
	 * EJSCMPDivisionHomeBean_8ba14c1f
	 */
	public EJSCMPDivisionHomeBean_8ba14c1f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Division postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Division) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findAllByProjectActionTypeOrderByNameAsc
	 */
	public java.util.Enumeration findAllByProjectActionTypeOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findAllByProjectActionTypeOrderByNameAsc());	}
	/**
	 * findChildsByParent
	 */
	public java.util.Enumeration findChildsByParent(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findChildsByParent(inKey));	}
	/**
	 * findByParentOrderByNameDesc
	 */
	public java.util.Enumeration findByParentOrderByNameDesc(java.lang.Integer parent) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findByParentOrderByNameDesc(parent));	}
	/**
	 * findDivisionsByCompany
	 */
	public java.util.Enumeration findDivisionsByCompany(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findDivisionsByCompany(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Division findByPrimaryKey(com.hps.july.persistence.DivisionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPDivisionBean_8ba14c1f) persister).findByPrimaryKey(key);
	}
	/**
	 * findControlleddivisionsByBoss
	 */
	public java.util.Enumeration findControlleddivisionsByBoss(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findControlleddivisionsByBoss(inKey));	}
	/**
	 * findByParentOrderByNameAsc
	 */
	public java.util.Enumeration findByParentOrderByNameAsc(java.lang.Integer parent) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findByParentOrderByNameAsc(parent));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Division create(int argDivision, java.lang.String argName, java.lang.String argShortName, java.lang.Integer argParent) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Division _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DivisionBean bean = (com.hps.july.persistence.DivisionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDivision, argName, argShortName, argParent);
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
	public com.hps.july.persistence.Division create(int argDivision, java.lang.String argName, java.lang.String argShortName, java.lang.Integer argCompany, char dummy) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Division _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DivisionBean bean = (com.hps.july.persistence.DivisionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDivision, argName, argShortName, argCompany, dummy);
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
	 * findAllByProjectCommsByNameAsc
	 */
	public java.util.Enumeration findAllByProjectCommsByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findAllByProjectCommsByNameAsc());	}
	/**
	 * findByParentCompany
	 */
	public java.util.Enumeration findByParentCompany(java.lang.Integer parent, java.lang.Integer company, java.lang.Boolean isRoot, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findByParentCompany(parent, company, isRoot, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Division create(int argDivision, java.lang.String argName, java.lang.Boolean argIsactive) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Division _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DivisionBean bean = (com.hps.july.persistence.DivisionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDivision, argName, argIsactive);
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
	public java.util.Enumeration findByQBE(java.lang.Boolean isParent, java.lang.Integer parent, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findByQBE(isParent, parent, isIsActive, isActive, order));	}
	/**
	 * findAllByProjectColumnsOrderByNameAsc
	 */
	public java.util.Enumeration findAllByProjectColumnsOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDivisionBean)persister).findAllByProjectColumnsOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.DivisionBean tmpEJB = (com.hps.july.persistence.DivisionBean) generalEJB;
		com.hps.july.persistence.DivisionKey keyClass = new com.hps.july.persistence.DivisionKey();
		keyClass.division = tmpEJB.division;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DivisionKey keyFromFields(int f0) {
		com.hps.july.persistence.DivisionKey keyClass = new com.hps.july.persistence.DivisionKey();
		keyClass.division = f0;
		return keyClass;
	}
}
