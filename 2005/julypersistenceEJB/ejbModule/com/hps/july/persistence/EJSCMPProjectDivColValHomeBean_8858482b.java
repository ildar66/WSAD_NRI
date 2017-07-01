package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectDivColValHomeBean_8858482b
 */
public class EJSCMPProjectDivColValHomeBean_8858482b extends EJSHome {
	/**
	 * EJSCMPProjectDivColValHomeBean_8858482b
	 */
	public EJSCMPProjectDivColValHomeBean_8858482b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectDivColVal postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectDivColVal) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ProjectDivColVal create(int divcolid, int project, java.lang.String argColvalue) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectDivColVal _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectDivColValBean bean = (com.hps.july.persistence.ProjectDivColValBean) beanO.getEnterpriseBean();
			bean.ejbCreate(divcolid, project, argColvalue);
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
	public com.hps.july.persistence.ProjectDivColVal findByPrimaryKey(com.hps.july.persistence.ProjectDivColValKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectDivColValBean_8858482b) persister).findByPrimaryKey(key);
	}
	/**
	 * findProjectDivColValsByProjectDivColumn
	 */
	public java.util.Enumeration findProjectDivColValsByProjectDivColumn(com.hps.july.persistence.ProjectDivColumnsKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectDivColValBean)persister).findProjectDivColValsByProjectDivColumn(inKey));	}
	/**
	 * findProjectDivColValsByProject
	 */
	public java.util.Enumeration findProjectDivColValsByProject(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectDivColValBean)persister).findProjectDivColValsByProject(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ProjectDivColValBean tmpEJB = (com.hps.july.persistence.ProjectDivColValBean) generalEJB;
		com.hps.july.persistence.ProjectDivColValKey keyClass = new com.hps.july.persistence.ProjectDivColValKey();
		keyClass.project_project = tmpEJB.project_project;
		keyClass.projectDivColumn_divcolid = tmpEJB.projectDivColumn_divcolid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectDivColValKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.ProjectDivColValKey keyClass = new com.hps.july.persistence.ProjectDivColValKey();
		keyClass.project_project = f0;
		keyClass.projectDivColumn_divcolid = f1;
		return keyClass;
	}
}
