package com.hps.july.dataimport.beans;

/**
 * Home ��������� ������� xls ������
 */
public interface DataImportHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.dataimport.beans.DataImport
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.dataimport.beans.DataImport create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
