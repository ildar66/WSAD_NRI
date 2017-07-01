package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPOrganizationHome_afa7f9a6
 */
public class EJSRemoteCMPOrganizationHome_afa7f9a6 extends EJSWrapper implements com.hps.july.persistence.OrganizationHome {
	/**
	 * EJSRemoteCMPOrganizationHome_afa7f9a6
	 */
	public EJSRemoteCMPOrganizationHome_afa7f9a6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Organization create(int argOrganization) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Organization _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argOrganization);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Organization create(int organization, com.hps.july.persistence.Company argCompany) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Organization _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(organization, argCompany);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Organization create(int argOrganization, java.lang.String argName, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter, java.lang.Boolean argBank) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Organization _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.create(argOrganization, argName, argIsSupplier, argIsProvider, argIsRenter, argBank);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Organization create(int argOrganization, java.lang.String argName, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter, java.lang.Boolean argIsChannalRenter, java.lang.Boolean argBank) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Organization _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.create(argOrganization, argName, argIsSupplier, argIsProvider, argIsRenter, argIsChannalRenter, argBank);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Organization findByPrimaryKey(com.hps.july.persistence.OrganizationKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Organization _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findByPrimaryKey(key);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBanksByNameOrderByNameAsc
	 */
	public java.util.Enumeration findBanksByNameOrderByNameAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findBanksByNameOrderByNameAsc(name);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBanksByQBE
	 */
	public java.util.Enumeration findBanksByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isBic, java.lang.String argBic, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findBanksByQBE(isName, argName, isBic, argBic, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByInnOrderByInnAsc
	 */
	public java.util.Enumeration findByInnOrderByInnAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findByInnOrderByInnAsc(name);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByNameOrderByNameAsc
	 */
	public java.util.Enumeration findByNameOrderByNameAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findByNameOrderByNameAsc(name);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationByCompany
	 */
	public java.util.Enumeration findOrganizationByCompany(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.findOrganizationByCompany(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationsButBanksByCompany
	 */
	public java.util.Enumeration findOrganizationsButBanksByCompany(java.lang.Integer argCompany) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.findOrganizationsButBanksByCompany(argCompany);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationsButBanksByCompanyAndGroup
	 */
	public java.util.Enumeration findOrganizationsButBanksByCompanyAndGroup(java.lang.Integer argCompany, java.lang.Boolean isGroup, java.lang.Integer searchgroup, java.lang.Integer searchGroupping) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.findOrganizationsButBanksByCompanyAndGroup(argCompany, isGroup, searchgroup, searchGroupping);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationsByNameOrderByNameAsc
	 */
	public java.util.Enumeration findOrganizationsByNameOrderByNameAsc(java.lang.String name, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.findOrganizationsByNameOrderByNameAsc(name, argIsSupplier, argIsProvider, argIsRenter);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationsByQBE
	 */
	public java.util.Enumeration findOrganizationsByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.findOrganizationsByQBE(isName, argName, isSupplier, isProvider, isRenter, isInn, argInn, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationsByQBE2
	 */
	public java.util.Enumeration findOrganizationsByQBE2(java.lang.Boolean isHaveBans, java.lang.Boolean isRenter, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Boolean isBan, java.lang.Integer ban, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.findOrganizationsByQBE2(isHaveBans, isRenter, isName, argName, isInn, argInn, isBan, ban, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationsByQBEAndGroup
	 */
	public java.util.Enumeration findOrganizationsByQBEAndGroup(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order, java.lang.Boolean isGroup, java.lang.Integer group, java.lang.Integer groupping) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.findOrganizationsByQBEAndGroup(isName, argName, isSupplier, isProvider, isRenter, isInn, argInn, order, isGroup, group, groupping);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrganizationsByReglament
	 */
	public java.util.Enumeration findOrganizationsByReglament(java.lang.Integer argCustReglament, java.lang.Integer argExecReglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.findOrganizationsByReglament(argCustReglament, argExecReglament);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOurOrganizations
	 */
	public java.util.Enumeration findOurOrganizations() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.findOurOrganizations();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getEJBMetaData();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getHomeHandle
	 */
	public javax.ejb.HomeHandle getHomeHandle() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.HomeHandle _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getHomeHandle();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 20, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * remove
	 */
	public void remove(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6 beanRef = (com.hps.july.persistence.EJSCMPOrganizationHomeBean_afa7f9a6)container.preInvoke(this, 21, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
