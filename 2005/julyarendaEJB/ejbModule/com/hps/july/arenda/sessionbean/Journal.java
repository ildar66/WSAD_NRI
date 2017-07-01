package com.hps.july.arenda.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Journal extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @param jrnAction int
 * @param jrnType java.lang.String
 * @param leaseRule int
 * @param leaseDocument int
 * @param leaseDocPosition int
 * @param leaseDocPosition2 int
 * @param date1 java.util.Date
 * @param date2 java.util.Date
 * @param summ1 java.math.BigDecimal
 * @param summ2 java.math.BigDecimal
 * @param currency1 int
 * @param currency2 int
 * @param resource1 int
 * @param resource2 int
 * @param idtask int
 * @exception String The exception description.
 */
boolean addMsgInJournal(int jrnAction, java.lang.String jrnType, int leaseRule, int leaseDocument, int leaseDocPosition, int leaseDocPosition2, java.util.Date date1, java.util.Date date2, java.math.BigDecimal summ1, java.math.BigDecimal summ2, int currency1, int currency2, int resource1, int resource2, int idtask) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param idtask int
 * @param jrnType java.lang.String
 * @param jrnMsg java.lang.String
 * @exception String The exception description.
 */
boolean addMsgInJournal(int idtask, java.lang.String jrnType, java.lang.String jrnMsg) throws java.rmi.RemoteException;
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
/**
 * 
 * @return int
 * @param operator int
 * @param taskType java.lang.String
 * @param date1 java.util.Date
 * @param date2 java.util.Date
 * @param economist java.lang.Integer
 * @param document java.lang.Integer
 * @exception String The exception description.
 */
int taskStart(int operator, java.lang.String taskType, java.util.Date date1, java.util.Date date2, java.lang.Integer economist, java.lang.Integer document) throws java.rmi.RemoteException;
}
