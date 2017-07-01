package com.hps.july.dataimport.beans;

/**
 * Клиентский интерфейс импорта xls файлов
 */
public interface DataImport extends javax.ejb.EJBObject {

/**
 * 
 * @return int
 * @param xlsFileName java.lang.String
 * @param file byte []
 * @param taskId int
 * @param operId int
 * @exception String The exception description.
 */
int process(java.lang.String xlsFileName, byte [] file, int taskId, int operId) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @param xlsFileName java.lang.String
 * @param file byte []
 * @param taskId int
 * @param operId int
 * @param prop java.util.Map
 * @exception String The exception description.
 */
int processBs(java.lang.String xlsFileName, byte [] file, int taskId, int operId, java.util.Map prop) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int processTest() throws java.rmi.RemoteException;
}
