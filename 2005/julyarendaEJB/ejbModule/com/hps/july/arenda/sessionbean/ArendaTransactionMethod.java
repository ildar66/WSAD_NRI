package com.hps.july.arenda.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ArendaTransactionMethod extends javax.ejb.EJBObject{

/**
 * 
 * @return boolean
 * @param contractDebet java.lang.Integer
 * @param contractCredit java.lang.Integer
 * @param mutuallySum java.math.BigDecimal
 * @exception String The exception description.
 */
boolean _addMutuallyBetweenContract(java.lang.Integer contractDebet, java.lang.Integer contractCredit, java.math.BigDecimal mutuallySum) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param contract java.lang.Integer
 * @param resource java.lang.Integer
 * @param mainSum java.math.BigDecimal
 * @param additionalSum java.math.BigDecimal
 * @param ndsSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 * @exception String The exception description.
 */
boolean _addToLeaseSaldo(java.lang.Integer contract, java.lang.Integer resource, java.math.BigDecimal mainSum, java.math.BigDecimal additionalSum, java.math.BigDecimal ndsSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param payment javax.ejb.Handle
 * @param charge javax.ejb.Handle
 * @param payRate java.math.BigDecimal
 * @param tempAct java.lang.Integer
 * @param byhand java.lang.Boolean
 * @param source java.lang.String
 * @param idtask int
 * @exception String The exception description.
 */
boolean _linkCharge2Pay(javax.ejb.Handle payment, javax.ejb.Handle charge, java.math.BigDecimal payRate, java.lang.Integer tempAct, java.lang.Boolean byhand, java.lang.String source, int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @param payment javax.ejb.Handle
 * @exception String The exception description.
 */
java.lang.Integer _makeCompensationCharge(javax.ejb.Handle payment) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @param charge javax.ejb.Handle
 * @exception String The exception description.
 */
java.lang.Integer _makeCompensationPayment(javax.ejb.Handle charge) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @param payment javax.ejb.Handle
 * @param minSum java.math.BigDecimal
 * @exception String The exception description.
 */
java.lang.Integer _makeMutualCharge(javax.ejb.Handle payment, java.math.BigDecimal minSum) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @param charge javax.ejb.Handle
 * @param minSum java.math.BigDecimal
 * @exception String The exception description.
 */
java.lang.Integer _makeMutualPayment(javax.ejb.Handle charge, java.math.BigDecimal minSum) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param saldo javax.ejb.Handle
 * @exception String The exception description.
 */
boolean _makeSaldoCharge(javax.ejb.Handle saldo) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param saldo javax.ejb.Handle
 * @exception String The exception description.
 */
boolean _makeSaldoPayment(javax.ejb.Handle saldo) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param leaseDocPosition int
 * @param currency int
 * @param rate java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
void _newCalcRate(int leaseDocPosition, int currency, java.math.BigDecimal rate) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param charge javax.ejb.Handle
 * @param rate java.math.BigDecimal
 * @exception String The exception description.
 */
boolean _setLeaseChargesRemainderRate(javax.ejb.Handle charge, java.math.BigDecimal rate) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param dnop javax.ejb.Handle
 * @param rateCharge java.math.BigDecimal
 * @exception String The exception description.
 */
boolean _setLeaseDnopChargeRURSum(javax.ejb.Handle dnop, java.math.BigDecimal rateCharge) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param resource java.lang.Integer
 * @param localDate java.util.Date
 * @param localSum java.math.BigDecimal
 * @param typeCalc java.lang.String
 * @param idTask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
java.math.BigDecimal calcNds(java.lang.Integer resource, java.util.Date localDate, java.math.BigDecimal localSum, java.lang.String typeCalc, int idTask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param dnop javax.ejb.Handle
 * @param idtask int
 * @exception String The exception description.
 */
boolean clearCharge2Pay(javax.ejb.Handle dnop, int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAkt java.lang.Integer
 * @exception String The exception description.
 */
boolean clearCharge2PayOnAktLink(java.lang.Integer idAkt) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean clearLeasevpayment() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param contract java.lang.Integer
 * @param sldDate java.util.Date
 * @param resource java.lang.Integer
 * @exception String The exception description.
 */
boolean createChargeOrPaymentOnSaldo(java.lang.Integer contract, java.util.Date sldDate, java.lang.Integer resource) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param leaseContract java.lang.Integer
 * @param salDate java.util.Date
 * @param resource java.lang.Integer
 * @param mainCurrency java.lang.Integer
 * @param mainSum java.math.BigDecimal
 * @param mainNdsSum java.math.BigDecimal
 * @param additionalCurrencycode int
 * @param additionalSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 * @exception String The exception description.
 */
boolean createSaldo(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, java.lang.Integer mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param leaseContract java.lang.Integer
 * @param salDate java.util.Date
 * @param resource java.lang.Integer
 * @param mainCurrency java.lang.Integer
 * @param mainSum java.math.BigDecimal
 * @param mainNdsSum java.math.BigDecimal
 * @param additionalCurrencycode int
 * @param additionalSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 * @exception String The exception description.
 */
void createSaldoSergey(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, java.lang.Integer mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param idPayment java.lang.Integer
 * @param currency java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
java.lang.Object [] defineRatePaymentOnContract(java.lang.Integer idPayment, java.lang.Integer currency) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param currency java.lang.Integer
 * @param idContract java.lang.Integer
 * @param payDate java.util.Date
 * @param billDATE java.util.Date
 * @param beginDate java.util.Date
 * @param endDate java.util.Date
 * @param payId java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
java.lang.Object [] defineRatePaymentOnContract(java.lang.Integer currency, java.lang.Integer idContract, java.util.Date payDate, java.util.Date billDATE, java.util.Date beginDate, java.util.Date endDate, java.lang.Integer payId) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param contract java.lang.Integer
 * @param sldDate java.util.Date
 * @param resource java.lang.Integer
 * @exception String The exception description.
 */
boolean deleteChargeOrPaymentOnSaldo(java.lang.Integer contract, java.util.Date sldDate, java.lang.Integer resource) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param fill boolean
 * @exception String The exception description.
 */
boolean fillUsedInAct(boolean fill) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param charge javax.ejb.Handle
 * @param paramCurrency int
 * @param onlyRead boolean
 * @exception String The exception description.
 */
java.math.BigDecimal getChargeRate(javax.ejb.Handle charge, int paramCurrency, boolean onlyRead) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param charge javax.ejb.Handle
 * @param paramCurrency int
 * @param onlyRead boolean
 * @param idAct int
 * @exception String The exception description.
 */
java.math.BigDecimal getChargeRateTemp(javax.ejb.Handle charge, int paramCurrency, boolean onlyRead, int idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param payment javax.ejb.Handle
 * @param inCurrency int
 * @param readOnly boolean
 * @param actid java.lang.Integer
 * @param otherUser boolean
 * @exception String The exception description.
 */
java.math.BigDecimal getPaymentRate(javax.ejb.Handle payment, int inCurrency, boolean readOnly, java.lang.Integer actid, boolean otherUser) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param payment javax.ejb.Handle
 * @param inCurrency int
 * @param readOnly boolean
 * @param idAct int
 * @exception String The exception description.
 */
java.math.BigDecimal getPaymentRateTemp(javax.ejb.Handle payment, int inCurrency, boolean readOnly, int idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param contract java.lang.Integer
 * @param sldDate java.util.Date
 * @param resource java.lang.Integer
 * @exception String The exception description.
 */
boolean removeSaldo(java.lang.Integer contract, java.util.Date sldDate, java.lang.Integer resource) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean rollbackCalcAct(java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param idtask int
 * @exception String The exception description.
 */
boolean rollbackCalcAct(java.lang.Integer idAct, int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param handle javax.ejb.Handle
 * @exception String The exception description.
 */
java.math.BigDecimal setChargeRemainderRate(javax.ejb.Handle handle) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean setRateRurForPayment() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param leaseContract java.lang.Integer
 * @param salDate java.util.Date
 * @param resource java.lang.Integer
 * @param mainCurrency int
 * @param mainSum java.math.BigDecimal
 * @param mainNdsSum java.math.BigDecimal
 * @param additionalCurrencycode int
 * @param additionalSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 * @exception String The exception description.
 */
boolean updateSaldo(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, int mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param leaseContract java.lang.Integer
 * @param salDate java.util.Date
 * @param resource java.lang.Integer
 * @param mainCurrency int
 * @param mainSum java.math.BigDecimal
 * @param mainNdsSum java.math.BigDecimal
 * @param additionalCurrencycode int
 * @param additionalSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 * @exception String The exception description.
 */
void updateSaldoSergey(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, int mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException;
}
