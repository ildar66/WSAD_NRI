package com.hps.july.dataimport.beans;

import java.util.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
//import com.hps.july.dataimport.lib.*;
/**
 * This is a Session Bean Class
 * Алгоритм импорта данных по базовым станциям и оборудованию
 */
public class DataImportBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 13:57:54)
 * @return int
 */
public int process(String xlsFileName, byte[] file, int taskId, int operId) throws RemoteException {
	/**
    try {
        Importer importer = new Importer(xlsFileName, file, taskId, operId);
        return importer.process();
    } catch (Exception e) {
         throw new RemoteException("from DataImportBean process", e);
    }*/return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 13:57:54)
 * @return int
 */
public int processBs(String xlsFileName, byte[] file, int taskId, int operId,Map prop) throws RemoteException {
/**    try {
        Importer importer = new Importer(xlsFileName, file, taskId, operId,prop);
        return importer.process();
    } catch (Exception e) {
         throw new RemoteException("from DataImportBean process", e);
    }*/return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 13:57:54)
 * @return int
 */
public int processTest() throws RemoteException {
    try {

        //java.io.File file = new java.io.File("c:\\Development\\Excel\\EMS06N.xls");
                java.io.File file = new java.io.File("c:\\test2905.xls");
        long l = file.length();
        byte[] bt = new byte[new Long(l).intValue()];
        java.io.FileInputStream fInpstream = new java.io.FileInputStream(file);
        int res = fInpstream.read(bt);
        return process("test2905.xls", bt, 2, 1);
/*
        Importer imr = new Importer("EMS03N.xls", bt, 1, 72);
        return imp.process();
*/
        } catch (Exception e) {
        throw new RemoteException("from processTest", e);
    }
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
