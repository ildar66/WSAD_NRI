package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEDocPosNriHomeBean_b724c6bf
 */
public class EJSCMPPIEDocPosNriHomeBean_b724c6bf extends EJSHome {
	/**
	 * EJSCMPPIEDocPosNriHomeBean_b724c6bf
	 */
	public EJSCMPPIEDocPosNriHomeBean_b724c6bf() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDocPosNri postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDocPosNri) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEDocPosNri findByPrimaryKey(com.hps.july.persistence.PIEDocPosNriKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEDocPosNriBean_b724c6bf) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEDocPosNri create(int argIdrecdocpos, int argIdRecDoc, int argIdResNri, java.math.BigDecimal argQty, java.lang.String argCountpolicy) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEDocPosNri _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEDocPosNriBean bean = (com.hps.july.persistence.PIEDocPosNriBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdrecdocpos, argIdRecDoc, argIdResNri, argQty, argCountpolicy);
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
	 * findPIEDocPosNrisByPiedocnri
	 */
	public java.util.Enumeration findPIEDocPosNrisByPiedocnri(com.hps.july.persistence.PIEDocNriKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEDocPosNriBean)persister).findPIEDocPosNrisByPiedocnri(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEDocPosNriBean tmpEJB = (com.hps.july.persistence.PIEDocPosNriBean) generalEJB;
		com.hps.july.persistence.PIEDocPosNriKey keyClass = new com.hps.july.persistence.PIEDocPosNriKey();
		keyClass.idrecdocpos = tmpEJB.idrecdocpos;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEDocPosNriKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEDocPosNriKey keyClass = new com.hps.july.persistence.PIEDocPosNriKey();
		keyClass.idrecdocpos = f0;
		return keyClass;
	}
}
