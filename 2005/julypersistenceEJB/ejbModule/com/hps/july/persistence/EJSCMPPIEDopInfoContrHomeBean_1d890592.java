package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEDopInfoContrHomeBean_1d890592
 */
public class EJSCMPPIEDopInfoContrHomeBean_1d890592 extends EJSHome {
	/**
	 * EJSCMPPIEDopInfoContrHomeBean_1d890592
	 */
	public EJSCMPPIEDopInfoContrHomeBean_1d890592() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDopInfoContr postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDopInfoContr) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEDopInfoContr create(int argLeasedocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEDopInfoContr _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEDopInfoContrBean bean = (com.hps.july.persistence.PIEDopInfoContrBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeasedocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeasedocument);
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
	public com.hps.july.persistence.PIEDopInfoContr findByPrimaryKey(com.hps.july.persistence.PIEDopInfoContrKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEDopInfoContrBean_1d890592) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEDopInfoContrBean tmpEJB = (com.hps.july.persistence.PIEDopInfoContrBean) generalEJB;
		com.hps.july.persistence.PIEDopInfoContrKey keyClass = new com.hps.july.persistence.PIEDopInfoContrKey();
		keyClass.leasedocument = tmpEJB.leasedocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEDopInfoContrKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEDopInfoContrKey keyClass = new com.hps.july.persistence.PIEDopInfoContrKey();
		keyClass.leasedocument = f0;
		return keyClass;
	}
}
