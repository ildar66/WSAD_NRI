package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectStateHomeBean_bf7cc4df
 */
public class EJSCMPProjectStateHomeBean_bf7cc4df extends EJSHome {
	/**
	 * EJSCMPProjectStateHomeBean_bf7cc4df
	 */
	public EJSCMPProjectStateHomeBean_bf7cc4df() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectState postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectState) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ProjectState findByPrimaryKey(com.hps.july.persistence.ProjectStateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectStateBean_bf7cc4df) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ProjectState create(int argProjectstate, java.lang.String argState, int argMan, java.sql.Timestamp argWhen, int argProject) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectState _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectStateBean bean = (com.hps.july.persistence.ProjectStateBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjectstate, argState, argMan, argWhen, argProject);
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
	 * findCurrentForProject
	 */
	public com.hps.july.persistence.ProjectState findCurrentForProject(java.lang.Integer argProject) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectStateBean_bf7cc4df)persister).findCurrentForProject(argProject);	}
	/**
	 * findProjectStatesByProject
	 */
	public java.util.Enumeration findProjectStatesByProject(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectStateBean)persister).findProjectStatesByProject(inKey));	}
	/**
	 * findProjectStatesByMan
	 */
	public java.util.Enumeration findProjectStatesByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectStateBean)persister).findProjectStatesByMan(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ProjectStateBean tmpEJB = (com.hps.july.persistence.ProjectStateBean) generalEJB;
		com.hps.july.persistence.ProjectStateKey keyClass = new com.hps.july.persistence.ProjectStateKey();
		keyClass.projectstate = tmpEJB.projectstate;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectStateKey keyFromFields(int f0) {
		com.hps.july.persistence.ProjectStateKey keyClass = new com.hps.july.persistence.ProjectStateKey();
		keyClass.projectstate = f0;
		return keyClass;
	}
}
