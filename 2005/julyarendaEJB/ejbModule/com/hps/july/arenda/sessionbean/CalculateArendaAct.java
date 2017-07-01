package com.hps.july.arenda.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface CalculateArendaAct extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param operator int
 * @param economist java.lang.Integer
 * @exception String The exception description.
 */
boolean calcAct(java.lang.Integer idAct, int operator, java.lang.Integer economist) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param operator int
 * @param economist java.lang.Integer
 * @param argIdtask int
 * @exception String The exception description.
 */
boolean calcAct(java.lang.Integer idAct, int operator, java.lang.Integer economist, int argIdtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean calculateContractSaldo(java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean checkAllResourcesInPaymentsTemp(java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean checkOplChargesTemp(java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idPayment java.lang.Integer
 * @param idCharge java.lang.Integer
 * @exception String The exception description.
 */
boolean clearCharge2Pay(java.lang.Integer idPayment, java.lang.Integer idCharge) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param idPayment java.lang.Integer
 * @param idCharge java.lang.Integer
 * @exception String The exception description.
 */
boolean clearCharge2PayTemp(java.lang.Integer idAct, java.lang.Integer idPayment, java.lang.Integer idCharge) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean closeChargesInPeriodAct() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param idContract1 int
 * @param idContract2 int
 * @exception String The exception description.
 */
boolean compareContracts(java.lang.Integer idAct, int idContract1, int idContract2) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean createPayChargeSaldo(java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean findAndCalcComplementaryContracts() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean findAndCalcComplementaryContractsTemp(java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param idAct int
 * @param idCharges int
 * @param paramCurrency int
 * @param onlyRead boolean
 * @exception String The exception description.
 */
java.math.BigDecimal getChargeRateTemp(int idAct, int idCharges, int paramCurrency, boolean onlyRead) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param idAct java.lang.Integer
 * @param level int
 * @param paymentId java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
int getComplementaryChargeByPayTemp(java.lang.Integer idAct, int level, java.lang.Integer paymentId) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param idPaiment int
 * @param inCurrency int
 * @param idAct int
 * @param flagAutoSaveRate boolean
 * @exception String The exception description.
 */
java.math.BigDecimal getPaymentRateTemp(int idPaiment, int inCurrency, int idAct, boolean flagAutoSaveRate) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean getPreviousSaldoTemp(java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal []
 * @param idAct java.lang.Integer
 * @param idContract java.lang.Integer
 * @param resource java.lang.Integer
 * @param currency int
 * @exception String The exception description.
 */
java.math.BigDecimal [] getSaldoContractResourceTemp(java.lang.Integer idAct, java.lang.Integer idContract, java.lang.Integer resource, int currency) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param idAct java.lang.Integer
 * @param contract java.lang.Integer
 * @exception String The exception description.
 */
java.math.BigDecimal getSaldoContractTemp(java.lang.Integer idAct, java.lang.Integer contract) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param organization com.hps.july.persistence.OrganizationAccessBean
 * @exception String The exception description.
 */
boolean isMemberBeelineTemp(java.lang.Integer idAct, com.hps.july.persistence.OrganizationAccessBean organization) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param idPayment java.lang.Integer
 * @param idCharge java.lang.Integer
 * @exception String The exception description.
 */
boolean linkCharge2PayTemp(java.lang.Integer idAct, java.lang.Integer idPayment, java.lang.Integer idCharge) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idAct java.lang.Integer
 * @param idCharges int
 * @exception String The exception description.
 */
boolean setChargesRURRateTemp(java.lang.Integer idAct, int idCharges) throws java.rmi.RemoteException;
}
