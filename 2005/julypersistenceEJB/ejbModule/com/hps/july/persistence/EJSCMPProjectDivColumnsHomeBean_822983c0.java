package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectDivColumnsHomeBean_822983c0
 */
public class EJSCMPProjectDivColumnsHomeBean_822983c0 extends EJSHome {
	/**
	 * EJSCMPProjectDivColumnsHomeBean_822983c0
	 */
	public EJSCMPProjectDivColumnsHomeBean_822983c0() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectDivColumns postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectDivColumns) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findProjectDivColumnsByDivision
	 */
	public java.util.Enumeration findProjectDivColumnsByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectDivColumnsBean)persister).findProjectDivColumnsByDivision(inKey));	}
	/**
	 * findByColDivisionActtypeOrderByAfterColAsc
	 */
	public java.util.Enumeration findByColDivisionActtypeOrderByAfterColAsc(java.lang.Integer argAfterCol, java.lang.Integer argDivision, java.lang.Integer argProjectType) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectDivColumnsBean)persister).findByColDivisionActtypeOrderByAfterColAsc(argAfterCol, argDivision, argProjectType));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectDivColumns findByPrimaryKey(com.hps.july.persistence.ProjectDivColumnsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectDivColumnsBean_822983c0) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ProjectDivColumns create(int argDivcolid, int projectType, int division, java.lang.String argColname, int argAftercol) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectDivColumns _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectDivColumnsBean bean = (com.hps.july.persistence.ProjectDivColumnsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDivcolid, projectType, division, argColname, argAftercol);
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
	 * findProjectDivColumnsByProjectType
	 */
	public java.util.Enumeration findProjectDivColumnsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectDivColumnsBean)persister).findProjectDivColumnsByProjectType(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ProjectDivColumnsBean tmpEJB = (com.hps.july.persistence.ProjectDivColumnsBean) generalEJB;
		com.hps.july.persistence.ProjectDivColumnsKey keyClass = new com.hps.july.persistence.ProjectDivColumnsKey();
		keyClass.divcolid = tmpEJB.divcolid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectDivColumnsKey keyFromFields(int f0) {
		com.hps.july.persistence.ProjectDivColumnsKey keyClass = new com.hps.july.persistence.ProjectDivColumnsKey();
		keyClass.divcolid = f0;
		return keyClass;
	}
}
