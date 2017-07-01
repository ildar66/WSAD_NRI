package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPI13nActPositionHomeBean_b594314c
 */
public class EJSCMPI13nActPositionHomeBean_b594314c extends EJSHome {
	/**
	 * EJSCMPI13nActPositionHomeBean_b594314c
	 */
	public EJSCMPI13nActPositionHomeBean_b594314c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nActPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nActPosition) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.I13nActPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nActPositionBean_b594314c) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.I13nActPosition create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.String argState, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nActPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nActPositionBean bean = (com.hps.july.persistence.I13nActPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocposition, argResource, argOwner, argDocument, argOrder, argQty, argPrice, argSourceBoxed, argResultBoxed, argSourceBroken, argResultBroken, argState, argSourceClosed, argResultClosed);
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
	public com.hps.july.persistence.I13nActPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nActPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nActPositionBean bean = (com.hps.july.persistence.I13nActPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocposition);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocposition);
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
	 * findI13nActPositionByContract
	 */
	public java.util.Enumeration findI13nActPositionByContract(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nActPositionBean)persister).findI13nActPositionByContract(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.I13nActPositionBean tmpEJB = (com.hps.july.persistence.I13nActPositionBean) generalEJB;
		com.hps.july.persistence.DocumentPositionKey keyClass = new com.hps.july.persistence.DocumentPositionKey();
		keyClass.docposition = tmpEJB.docposition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentPositionKey keyClass = new com.hps.july.persistence.DocumentPositionKey();
		keyClass.docposition = f0;
		return keyClass;
	}
}
