package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface CurrencySumProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return com.hps.july.inventory.sessionbean.CurrencySumProcessingError
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.CurrencySumProcessingError getBaseCurrency() throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.CurrencySumProcessingError
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.CurrencySumProcessingError getDefaultRateType() throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.CurrencySumProcessingError
 * @param sourceCurrency java.lang.Integer
 * @param sourceSum java.math.BigDecimal
 * @param destCurrency java.lang.Integer
 * @param currencyDate java.sql.Date
 * @param currencyRateType java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.CurrencySumProcessingError recalcSumToCurrency(java.lang.Integer sourceCurrency, java.math.BigDecimal sourceSum, java.lang.Integer destCurrency, java.sql.Date currencyDate, java.lang.Integer currencyRateType) throws java.rmi.RemoteException;
}
