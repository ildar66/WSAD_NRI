package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEQueryLogHomeBean_a5116b49
 */
public class EJSCMPPIEQueryLogHomeBean_a5116b49 extends EJSHome {
	/**
	 * EJSCMPPIEQueryLogHomeBean_a5116b49
	 */
	public EJSCMPPIEQueryLogHomeBean_a5116b49() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEQueryLog postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEQueryLog) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEQueryLog findByPrimaryKey(com.hps.july.persistence.PIEQueryLogKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEQueryLogBean_a5116b49) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEQueryLog create(int argIdnriquerylog, int argQuery, java.lang.String argTypeMsg, int argErrorcode, java.lang.String argTextMsg, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEQueryLog _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEQueryLogBean bean = (com.hps.july.persistence.PIEQueryLogBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdnriquerylog, argQuery, argTypeMsg, argErrorcode, argTextMsg, argVdat);
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
	 * findByQueryTypeOrderByCodeAsc
	 */
	public java.util.Enumeration findByQueryTypeOrderByCodeAsc(java.lang.Integer argQuery, java.lang.String argType) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEQueryLogBean)persister).findByQueryTypeOrderByCodeAsc(argQuery, argType));	}
	/**
	 * findPIEQueryLogsByQuery
	 */
	public java.util.Enumeration findPIEQueryLogsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEQueryLogBean)persister).findPIEQueryLogsByQuery(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEQueryLogBean tmpEJB = (com.hps.july.persistence.PIEQueryLogBean) generalEJB;
		com.hps.july.persistence.PIEQueryLogKey keyClass = new com.hps.july.persistence.PIEQueryLogKey();
		keyClass.idnriquerylog = tmpEJB.idnriquerylog;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEQueryLogKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEQueryLogKey keyClass = new com.hps.july.persistence.PIEQueryLogKey();
		keyClass.idnriquerylog = f0;
		return keyClass;
	}
}
