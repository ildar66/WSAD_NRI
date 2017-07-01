package com.hps.july.arenda.billing;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Pie2Nri extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean checkWorkBanInPie(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveAbonentDogovorsPie2BufferNri(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveAllBillPie2BufferNri(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean moveAllDnopPie2BufferNri(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @exception String The exception description.
 */
boolean moveAllNri2PIE(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveAllPaymentPie2BufferNri(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param bil java.lang.String
 * @param billid int
 * @param idtask int
 * @exception String The exception description.
 */
boolean moveBilFromBilling(java.lang.String bil, int billid, int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveListBanFromNri2Pie(int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param idtask int
 * @param rsP java.sql.ResultSet
 * @param leasebill int
 * @param idPaymentNri int
 * @param ent_seq_no int
 * @param ban int
 * @param insert java.sql.PreparedStatement
 * @param update java.sql.PreparedStatement
 * @param stateP2 java.sql.Statement
 * @param keygen com.hps.july.commonbean.KeyGeneratorAccessBean
 * @exception String The exception description.
 * @exception String The exception description.
 */
void moveOneDnop(int idtask, java.sql.ResultSet rsP, int leasebill, int idPaymentNri, int ent_seq_no, int ban, java.sql.PreparedStatement insert, java.sql.PreparedStatement update, java.sql.Statement stateP2, com.hps.july.commonbean.KeyGeneratorAccessBean keygen) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param payid int
 * @param idtask int
 * @param autolink java.lang.String
 * @exception String The exception description.
 */
boolean movePayFromBilling(int payid, int idtask, java.lang.String autolink) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean movePayOnAktBufferNri2Pie(int idtask) throws java.rmi.RemoteException;
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
 */
int taskStart(int operator, java.lang.String taskType) throws java.rmi.RemoteException;
}
