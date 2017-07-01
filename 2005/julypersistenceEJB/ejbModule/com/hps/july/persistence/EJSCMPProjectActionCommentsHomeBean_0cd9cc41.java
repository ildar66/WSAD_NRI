package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectActionCommentsHomeBean_0cd9cc41
 */
public class EJSCMPProjectActionCommentsHomeBean_0cd9cc41 extends EJSHome {
	/**
	 * EJSCMPProjectActionCommentsHomeBean_0cd9cc41
	 */
	public EJSCMPProjectActionCommentsHomeBean_0cd9cc41() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectActionComments postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectActionComments) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ProjectActionComments findByPrimaryKey(com.hps.july.persistence.ProjectActionCommentsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectActionCommentsBean_0cd9cc41) persister).findByPrimaryKey(key);
	}
	/**
	 * findProjectActionCommentsByProjectaction
	 */
	public java.util.Enumeration findProjectActionCommentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionCommentsBean)persister).findProjectActionCommentsByProjectaction(inKey));	}
	/**
	 * findProjectActionCommentsByDivision
	 */
	public java.util.Enumeration findProjectActionCommentsByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionCommentsBean)persister).findProjectActionCommentsByDivision(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ProjectActionComments create(int argProjectaction, int argDivision) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectActionComments _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectActionCommentsBean bean = (com.hps.july.persistence.ProjectActionCommentsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjectaction, argDivision);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ProjectActionCommentsBean tmpEJB = (com.hps.july.persistence.ProjectActionCommentsBean) generalEJB;
		com.hps.july.persistence.ProjectActionCommentsKey keyClass = new com.hps.july.persistence.ProjectActionCommentsKey();
		keyClass.projectaction_projectaction = tmpEJB.projectaction_projectaction;
		keyClass.division_division = tmpEJB.division_division;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectActionCommentsKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.ProjectActionCommentsKey keyClass = new com.hps.july.persistence.ProjectActionCommentsKey();
		keyClass.projectaction_projectaction = f0;
		keyClass.division_division = f1;
		return keyClass;
	}
}
