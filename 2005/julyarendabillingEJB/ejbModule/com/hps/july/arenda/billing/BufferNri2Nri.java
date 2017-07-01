package com.hps.july.arenda.billing;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface BufferNri2Nri extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @param idtask int
 * @param ban java.lang.Integer
 * @param dateStart java.util.Date
 * @exception String The exception description.
 */
boolean dismissAbonentContract(int idtask, java.lang.Integer ban, java.util.Date dateStart) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @exception String The exception description.
 */
boolean moveAllBillBufferNri2Nri(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @exception String The exception description.
 */
boolean moveAllDnopBufferNri2Nri(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param autoLinkPaymentBen boolean
 * @exception String The exception description.
 */
boolean moveAllPaymentBufferNri2Nri(int idtask, boolean autoLinkPaymentBen) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idBill java.lang.Integer
 * @exception String The exception description.
 */
boolean moveOneBillBufferNri2Nri(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param idPay java.lang.Integer
 * @param autoLinkPaymentBen boolean
 * @exception String The exception description.
 */
boolean moveOnePaymentBufferNri2Nri(int idtask, java.lang.Integer idPay, boolean autoLinkPaymentBen) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void taskEnd(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param operator int
 * @param taskType java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
int taskStart(int operator, java.lang.String taskType) throws java.rmi.RemoteException;
}
