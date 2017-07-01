package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPowerSupplySetHomeBean_caaa5cc8
 */
public class EJSCMPPowerSupplySetHomeBean_caaa5cc8 extends EJSHome {
	/**
	 * EJSCMPPowerSupplySetHomeBean_caaa5cc8
	 */
	public EJSCMPPowerSupplySetHomeBean_caaa5cc8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PowerSupplySet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PowerSupplySet) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PowerSupplySet create(int argResourceset, java.lang.String argName, java.lang.Integer argMainPart, java.math.BigDecimal argMainPartQty, java.lang.String argType, java.math.BigDecimal argPower) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PowerSupplySet _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PowerSupplySetBean bean = (com.hps.july.persistence.PowerSupplySetBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResourceset, argName, argMainPart, argMainPartQty, argType, argPower);
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
	public com.hps.july.persistence.PowerSupplySet findByPrimaryKey(com.hps.july.persistence.ResourceSetKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPowerSupplySetBean_caaa5cc8) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PowerSupplySetBean tmpEJB = (com.hps.july.persistence.PowerSupplySetBean) generalEJB;
		com.hps.july.persistence.ResourceSetKey keyClass = new com.hps.july.persistence.ResourceSetKey();
		keyClass.resourceset = tmpEJB.resourceset;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceSetKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceSetKey keyClass = new com.hps.july.persistence.ResourceSetKey();
		keyClass.resourceset = f0;
		return keyClass;
	}
}
