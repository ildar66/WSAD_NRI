package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseSchetFaktHomeBean_be4c2759
 */
public class EJSCMPLeaseSchetFaktHomeBean_be4c2759 extends EJSHome {
	/**
	 * EJSCMPLeaseSchetFaktHomeBean_be4c2759
	 */
	public EJSCMPLeaseSchetFaktHomeBean_be4c2759() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseSchetFakt postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseSchetFakt) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeaseSchetFaktsByIdAct
	 */
	public java.util.Enumeration findLeaseSchetFaktsByIdAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findLeaseSchetFaktsByIdAct(inKey));	}
	/**
	 * findByIdActOrderByNumberSchetFaktAsc
	 */
	public java.util.Enumeration findByIdActOrderByNumberSchetFaktAsc(java.lang.Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdActOrderByNumberSchetFaktAsc(idAct));	}
	/**
	 * findLeaseSchetFaktsByIdContract
	 */
	public java.util.Enumeration findLeaseSchetFaktsByIdContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findLeaseSchetFaktsByIdContract(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseSchetFakt findByPrimaryKey(com.hps.july.persistence.LeaseSchetFaktKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseSchetFaktBean_be4c2759) persister).findByPrimaryKey(key);
	}
	/**
	 * findByIdContractOrderByDateSchetFaktAsc
	 */
	public java.util.Enumeration findByIdContractOrderByDateSchetFaktAsc(java.lang.Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdContractOrderByDateSchetFaktAsc(idContract));	}
	/**
	 * findByIdContractOrderByDateSchetFaktDesc
	 */
	public java.util.Enumeration findByIdContractOrderByDateSchetFaktDesc(java.lang.Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdContractOrderByDateSchetFaktDesc(idContract));	}
	/**
	 * findByIdContractOrderByNumberSchetFaktDesc
	 */
	public java.util.Enumeration findByIdContractOrderByNumberSchetFaktDesc(java.lang.Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdContractOrderByNumberSchetFaktDesc(idContract));	}
	/**
	 * findByIdActOrderByDateSchetFaktDesc
	 */
	public java.util.Enumeration findByIdActOrderByDateSchetFaktDesc(java.lang.Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdActOrderByDateSchetFaktDesc(idAct));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseSchetFakt create(java.lang.Integer argIdSchetFakt, java.lang.Integer idContract, java.lang.Integer idCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseSchetFakt _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseSchetFaktBean bean = (com.hps.july.persistence.LeaseSchetFaktBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdSchetFakt, idContract, idCurrency);
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
	 * findByIdActOrderByDateSchetFaktAsc
	 */
	public java.util.Enumeration findByIdActOrderByDateSchetFaktAsc(java.lang.Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdActOrderByDateSchetFaktAsc(idAct));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer idAct, java.lang.Boolean isContractType, java.lang.String typeContract, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByQBE(idAct, isContractType, typeContract, order));	}
	/**
	 * findByIdContractOrderByNumberSchetFaktAsc
	 */
	public java.util.Enumeration findByIdContractOrderByNumberSchetFaktAsc(java.lang.Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdContractOrderByNumberSchetFaktAsc(idContract));	}
	/**
	 * findLeaseSchetFaktsByIdCurrency
	 */
	public java.util.Enumeration findLeaseSchetFaktsByIdCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findLeaseSchetFaktsByIdCurrency(inKey));	}
	/**
	 * findByIdActOrderByNumberSchetFaktDesc
	 */
	public java.util.Enumeration findByIdActOrderByNumberSchetFaktDesc(java.lang.Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSchetFaktBean)persister).findByIdActOrderByNumberSchetFaktDesc(idAct));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseSchetFaktBean tmpEJB = (com.hps.july.persistence.LeaseSchetFaktBean) generalEJB;
		com.hps.july.persistence.LeaseSchetFaktKey keyClass = new com.hps.july.persistence.LeaseSchetFaktKey();
		keyClass.idSchetFakt = tmpEJB.idSchetFakt;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseSchetFaktKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseSchetFaktKey keyClass = new com.hps.july.persistence.LeaseSchetFaktKey();
		keyClass.idSchetFakt = f0;
		return keyClass;
	}
}
