package com.hps.july.arenda.billing;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface BillingRequiredNew extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @param idtask int
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean cancelMovePayOnAktNri2BufferNri(int idtask, java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idBill java.lang.Integer
 * @exception String The exception description.
 */
boolean checkPossibleMoveBill2Nri(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idPay java.lang.Integer
 * @exception String The exception description.
 */
boolean checkPossibleMovePayment2Nri(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idPay java.lang.Integer
 * @exception String The exception description.
 */
boolean defineSumPayNeedForNri(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idPay java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean getAbonentPaymentByHand(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param idtask int
 * @param flag java.lang.String
 * @exception String The exception description.
 */
java.lang.Object [] getAllAbonentBillsByFlag(int idtask, java.lang.String flag) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param idtask int
 * @param flag java.lang.String
 * @exception String The exception description.
 */
java.lang.Object [] getAllAbonentDnopByFlag(int idtask, java.lang.String flag) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param idtask int
 * @param flag java.lang.String
 * @exception String The exception description.
 */
java.lang.Object [] getAllPaymentByFlag(int idtask, java.lang.String flag) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @param idtask int
 * @param idBill java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Boolean getBillFlagNeed(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param idtask int
 * @param ban java.lang.Integer
 * @param dateStart java.util.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
java.lang.Object [] getDeletingAbonentBill(int idtask, java.lang.Integer ban, java.util.Date dateStart) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param idtask int
 * @param ban java.lang.Integer
 * @param dateStart java.util.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
java.lang.Object [] getDeletingAbonentPayment(int idtask, java.lang.Integer ban, java.util.Date dateStart) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idDnop java.lang.Integer
 * @exception String The exception description.
 */
boolean moveOneDnopBufferNri2Nri(int idtask, java.lang.Integer idDnop) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idAct java.lang.Integer
 * @exception String The exception description.
 */
boolean movePayOnAktNri2BufferNri(int idtask, java.lang.Integer idAct) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idBillPos java.lang.Integer
 * @exception String The exception description.
 */
boolean removeBillPos2DocPos(int idtask, java.lang.Integer idBillPos) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idPay int
 * @exception String The exception description.
 */
boolean removePayments2DocPos(int idtask, int idPay) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idBill java.lang.Integer
 * @exception String The exception description.
 */
boolean setParamBillForMoveBill2Nri(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param leaseBill java.lang.Integer
 * @exception String The exception description.
 */
boolean workAbonentBillPos(int idtask, java.lang.Integer leaseBill) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idPay java.lang.Integer
 * @exception String The exception description.
 */
boolean workAbonentPayment(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException;
}
