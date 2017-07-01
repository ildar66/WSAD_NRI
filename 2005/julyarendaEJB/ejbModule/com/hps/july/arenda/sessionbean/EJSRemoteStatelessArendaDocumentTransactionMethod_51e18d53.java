package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessArendaDocumentTransactionMethod_51e18d53
 */
public class EJSRemoteStatelessArendaDocumentTransactionMethod_51e18d53 extends EJSWrapper implements ArendaDocumentTransactionMethod {
	/**
	 * EJSRemoteStatelessArendaDocumentTransactionMethod_51e18d53
	 */
	public EJSRemoteStatelessArendaDocumentTransactionMethod_51e18d53() throws java.rmi.RemoteException {
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
	 * calcNds
	 */
	public java.math.BigDecimal calcNds(java.lang.Integer resource, java.sql.Date localDate, java.math.BigDecimal localSum, java.lang.String typeCalc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.calcNds(resource, localDate, localSum, typeCalc);
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
	 * makeAutoChargeOneContract
	 */
	public void makeAutoChargeOneContract(java.sql.Date dateFinish, java.lang.Integer baseContract, int codeTask) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean)container.preInvoke(this, 1, _EJS_s);
			beanRef.makeAutoChargeOneContract(dateFinish, baseContract, codeTask);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
		return ;
	}
	/**
	 * makeAutoPaymentOneContract
	 */
	public void makeAutoPaymentOneContract(java.sql.Date dateStart, java.sql.Date dateFinish, java.lang.Integer baseContract, int codeTask) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean)container.preInvoke(this, 2, _EJS_s);
			beanRef.makeAutoPaymentOneContract(dateStart, dateFinish, baseContract, codeTask);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
		return ;
	}
	/**
	 * makeProlongationOneContract
	 */
	public void makeProlongationOneContract(javax.ejb.Handle docHandle, int codeTask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.makeProlongationOneContract(docHandle, codeTask);
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
		return ;
	}
}
