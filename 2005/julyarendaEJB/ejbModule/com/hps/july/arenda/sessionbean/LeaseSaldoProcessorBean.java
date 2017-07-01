package com.hps.july.arenda.sessionbean;

import java.math.*;
import java.sql.Date;
import com.hps.july.persistence.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Расчет сальдо договоров аренды
 */
public class LeaseSaldoProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 12:44:09)
 */
public void createSaldo(Integer leaseContract, Date salDate, Integer resource,
	Integer mainCurrency, BigDecimal mainSum, BigDecimal mainNdsSum,
	int additionalCurrencycode, BigDecimal additionalSum, BigDecimal additionalNdsSum) throws java.rmi.RemoteException {

	try {
		ArendaTransactionMethodAccessBean atab = new ArendaTransactionMethodAccessBean();
		atab.createSaldoSergey(leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum,
			additionalCurrencycode, additionalSum, additionalNdsSum);
		//if(!new ArendaTransactionMethodAccessBean().createSaldo(
			//leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum,
				//additionalCurrencycode, additionalSum, additionalNdsSum))
		//throw new Exception();

		//if (!new CalculateArendaActAccessBean().createChargeOrPaymentOnSaldo(leaseContract, salDate, resource)) {
			//throw new Exception();
		//}
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While create saldo", e);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 12:44:44)
 */
public void deleteSaldo(Integer leaseContract, Date salDate, Integer resource) throws java.rmi.RemoteException {
	try {
		if (!new ArendaTransactionMethodAccessBean().deleteChargeOrPaymentOnSaldo(leaseContract, salDate, resource)) {
			throw new Exception();
		}

		LeaseSaldoAccessBean bean = new LeaseSaldoAccessBean();
		bean.setInitKey_leaseContract(leaseContract);
		bean.setInitKey_SalDate(salDate);
		bean.setInitKey_resource_resource(resource);
		bean.refreshCopyHelper();
		bean.getEJBRef().remove();
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While delete saldo", e);
	}
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 12:44:24)
 */
public void updateSaldo(Integer leaseContract, Date salDate, Integer resource, int mainCurrency, BigDecimal mainSum,
	BigDecimal mainNdsSum, int additionalCurrencycode, BigDecimal additionalSum, BigDecimal additionalNdsSum) throws java.rmi.RemoteException {

	try	{
		ArendaTransactionMethodAccessBean atab = new ArendaTransactionMethodAccessBean();
		atab.updateSaldoSergey(leaseContract, salDate, resource, mainCurrency, mainSum,
			mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum);

			//if (!atab.deleteChargeOrPaymentOnSaldo(leaseContract, salDate, resource)) {
			//throw new Exception();
		//}
		//if(!atab.updateSaldo(leaseContract, salDate, resource, mainCurrency, mainSum,
			//mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum))
				//throw new Exception();

		//if (!new CalculateArendaActAccessBean().createChargeOrPaymentOnSaldo(leaseContract, salDate, resource)) {
			//throw new Exception();
		//}
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While update saldo", e);
	}
}
}
