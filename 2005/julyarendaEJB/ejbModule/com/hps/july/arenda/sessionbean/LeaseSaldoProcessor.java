package com.hps.july.arenda.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseSaldoProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param leaseContract java.lang.Integer
 * @param salDate java.sql.Date
 * @param resource java.lang.Integer
 * @param mainCurrency java.lang.Integer
 * @param mainSum java.math.BigDecimal
 * @param mainNdsSum java.math.BigDecimal
 * @param additionalCurrencycode int
 * @param additionalSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
void createSaldo(java.lang.Integer leaseContract, java.sql.Date salDate, java.lang.Integer resource, java.lang.Integer mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param leaseContract java.lang.Integer
 * @param salDate java.sql.Date
 * @param resource java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
void deleteSaldo(java.lang.Integer leaseContract, java.sql.Date salDate, java.lang.Integer resource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param leaseContract java.lang.Integer
 * @param salDate java.sql.Date
 * @param resource java.lang.Integer
 * @param mainCurrency int
 * @param mainSum java.math.BigDecimal
 * @param mainNdsSum java.math.BigDecimal
 * @param additionalCurrencycode int
 * @param additionalSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 * @exception String The exception description.
 */
void updateSaldo(java.lang.Integer leaseContract, java.sql.Date salDate, java.lang.Integer resource, int mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException;
}
