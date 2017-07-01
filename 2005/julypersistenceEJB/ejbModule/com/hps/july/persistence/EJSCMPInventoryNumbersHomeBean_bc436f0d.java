package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPInventoryNumbersHomeBean_bc436f0d
 */
public class EJSCMPInventoryNumbersHomeBean_bc436f0d extends EJSHome {
	/**
	 * EJSCMPInventoryNumbersHomeBean_bc436f0d
	 */
	public EJSCMPInventoryNumbersHomeBean_bc436f0d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InventoryNumbers postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InventoryNumbers) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findOrderBySerstartAsc
	 */
	public java.util.Enumeration findOrderBySerstartAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInventoryNumbersBean)persister).findOrderBySerstartAsc());	}
	/**
	 * findOrderBySerprefixDesc
	 */
	public java.util.Enumeration findOrderBySerprefixDesc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInventoryNumbersBean)persister).findOrderBySerprefixDesc());	}
	/**
	 * findInventoryNumbersBySerworker
	 */
	public java.util.Enumeration findInventoryNumbersBySerworker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInventoryNumbersBean)persister).findInventoryNumbersBySerworker(inKey));	}
	/**
	 * findOrderBySerstartDesc
	 */
	public java.util.Enumeration findOrderBySerstartDesc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInventoryNumbersBean)persister).findOrderBySerstartDesc());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.InventoryNumbers create(int argSerid, java.sql.Date serdate, java.lang.String serend, java.lang.String serprefix, java.lang.String serstart, java.lang.Integer serworker) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InventoryNumbers _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InventoryNumbersBean bean = (com.hps.july.persistence.InventoryNumbersBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSerid, serdate, serend, serprefix, serstart, serworker);
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
	public com.hps.july.persistence.InventoryNumbers findByPrimaryKey(com.hps.july.persistence.InventoryNumbersKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPInventoryNumbersBean_bc436f0d) persister).findByPrimaryKey(key);
	}
	/**
	 * findOrderBySerprefixAsc
	 */
	public java.util.Enumeration findOrderBySerprefixAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInventoryNumbersBean)persister).findOrderBySerprefixAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.InventoryNumbersBean tmpEJB = (com.hps.july.persistence.InventoryNumbersBean) generalEJB;
		com.hps.july.persistence.InventoryNumbersKey keyClass = new com.hps.july.persistence.InventoryNumbersKey();
		keyClass.serid = tmpEJB.serid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.InventoryNumbersKey keyFromFields(int f0) {
		com.hps.july.persistence.InventoryNumbersKey keyClass = new com.hps.july.persistence.InventoryNumbersKey();
		keyClass.serid = f0;
		return keyClass;
	}
}
