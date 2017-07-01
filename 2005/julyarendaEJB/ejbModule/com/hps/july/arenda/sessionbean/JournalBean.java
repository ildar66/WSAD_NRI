package com.hps.july.arenda.sessionbean;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import java.util.*;
import java.math.*;
import com.hps.july.persistence.*;
/**
 * This is a Session Bean Class
 * Журналирование операций аренды
 */
public class JournalBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

public boolean addMsgInJournal(
	int jrnAction, String jrnType, int leaseRule, int leaseDocument, 
	int leaseDocPosition, int leaseDocPosition2, Date date1, Date date2, BigDecimal summ1, BigDecimal summ2, 
	int currency1, int currency2, int resource1, int resource2, int idtask)throws java.rmi.RemoteException{

    try {
        LeaseTaskJournalAccessBean bean = new LeaseTaskJournalAccessBean(
	        new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leasetaskjournal"), 
	        idtask, 
	        new java.sql.Timestamp((new GregorianCalendar()).getTime().getTime()), 
	        jrnAction, 
	        jrnType
	        );
        if(leaseDocument != -1) bean.setLeasedocument(new Integer(leaseDocument));
        if(leaseRule != -1) bean.setLeaserule(new Integer(leaseRule));
        if(leaseDocPosition != -1) bean.setLeasedocposition(new Integer(leaseDocPosition));
        if(leaseDocPosition2 != -1) bean.setLeasedocposition2(new Integer(leaseDocPosition2));
        if(date1 != null) bean.setDate1(new java.sql.Date(date1.getTime()));
        if(date2 != null) bean.setDate2(new java.sql.Date(date2.getTime()));
        if(summ1 != null) bean.setSumm1(summ1);
        if(summ2 != null) bean.setSumm2(summ2);
        if(currency1 != -1) bean.setCurrency1(new Integer(currency1));
        if(currency2 != -1) bean.setCurrency2(new Integer(currency2));
        if(resource1 != -1) bean.setResource1(new Integer(resource1));
        if(resource2 != -1) bean.setResource2(new Integer(resource2));
        bean.commitCopyHelper();
        return true;      
    } catch (Exception ex) {
        pr(ex, "addmsgInJournal");
        return false;
    }
}
public boolean addMsgInJournal(int idtask, String jrnType, String jrnMsg)throws java.rmi.RemoteException{

    try {
        LeaseTaskJournalAccessBean bean = new LeaseTaskJournalAccessBean(
	        new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leasetaskjournal"), 
	        idtask, 
	        new java.sql.Timestamp((new GregorianCalendar()).getTime().getTime()), 
	        0,//jrnAction,
	        jrnType
	        );
        bean.setJrnmessage(jrnMsg);
        bean.commitCopyHelper();
        return true;      
    } catch (Exception ex) {
        pr(ex, "addmsgInJournal");
        return false;
    }
}
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
void pr(Exception ex, String str) {
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
	System.out.println(new java.util.Date());
	if(ex != null){
		System.out.println(ex.getClass().getName() + " in " + this.getClass().getName() +"."+ str + 
		". Message is:" + ex.getMessage());
		processEx(ex);
	}
	else
		System.out.println(this.getClass().getName() +"."+ str);
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
}
private void processEx(Exception ex) {
    if (!(ex instanceof RemoteException) && !(ex instanceof EJBException) && !(ex instanceof RuntimeException))
        mySessionCtx.setRollbackOnly();

    //if(ex instanceof java.sql.SQLException)
    	//pr("//////// Error code="+((java.sql.SQLException)ex).getErrorCode()+" \\\\\\\\\\");

    	try{
    if (ex instanceof java.rmi.ServerException) {
        if (((java.rmi.ServerException) ex).detail instanceof com.ibm.ejs.persistence.EJSPersistenceException) {
            if (((com.ibm.ejs.persistence.EJSPersistenceException)
	            (((java.rmi.ServerException) ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.ejs.persistence.EJSPersistenceException)
	                (((java.rmi.ServerException) ex).detail)).detail)).getErrorCode();
                System.out.println("Error code = " + code);
            }
        } else if (((java.rmi.ServerException)ex).detail instanceof com.ibm.websphere.cpi.CPIException) {
            if (((com.ibm.websphere.cpi.CPIException) 
	            (((java.rmi.ServerException)ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.websphere.cpi.CPIException)
	                (((java.rmi.ServerException)ex).detail)).detail)).getErrorCode();
                System.out.println("Error code = " + code);
            }
        }
    }
    	}catch(Exception exx){pr(exx, "processEx");}
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
public void taskEnd(int idtask)  throws java.rmi.RemoteException{
    try {
        LeaseTaskStartAccessBean taskStartBean = new LeaseTaskStartAccessBean();
        taskStartBean.setInitKey_taskstart(idtask);
        taskStartBean.refreshCopyHelper();
        taskStartBean.setEnddate(new java.sql.Timestamp((new GregorianCalendar()).getTime().getTime()));
        taskStartBean.commitCopyHelper();
    } catch (Exception ex) {
        pr(ex, "taskEnd. idtask=" + idtask);
    }
}
// Первые два параметра обязательные
public int taskStart(int operator, String taskType) throws java.rmi.RemoteException{
    try {
	    int idtask = new KeyGeneratorAccessBean().getNextKey("tables.leasetasksstarts");

        LeaseTaskStartAccessBean taskStartBean = new LeaseTaskStartAccessBean(
	        idtask,
	        new java.sql.Timestamp((new GregorianCalendar()).getTime().getTime()),
	        operator, 
	        taskType
	        );
        return idtask;
    } catch (Exception ex) {
        pr(ex, "taskStart(2 parameters)");
    }
    return -1;
}
// Первые два параметра обязательные
public int taskStart(int operator, String taskType, Date date1, Date date2,
	Integer economist, Integer document) throws java.rmi.RemoteException{
    try {
	    int idtask = new KeyGeneratorAccessBean().getNextKey("tables.leasetasksstarts");

        LeaseTaskStartAccessBean taskStartBean = new LeaseTaskStartAccessBean(
	        idtask,
	        new java.sql.Timestamp((new GregorianCalendar()).getTime().getTime()),
	        operator, 
	        taskType
	        );
        if(date1 != null) taskStartBean.setDate1(new java.sql.Date(date1.getTime()));
        if(date2 != null) taskStartBean.setDate2(new java.sql.Date(date2.getTime()));

        if(economist != null){
	        WorkerAccessBean workerBean = new WorkerAccessBean();
            workerBean.setInitKey_worker(economist.intValue());
            workerBean.refreshCopyHelper();
            taskStartBean.setEconomistWorker((Worker) workerBean.getEJBRef());
        }
		if(document != null){
			LeaseDocumentAccessBean ldab = new LeaseDocumentAccessBean();
			ldab.setInitKey_leaseDocument(document.intValue());
			ldab.refreshCopyHelper();
			taskStartBean.setLeasedocument((LeaseDocument)ldab.getEJBRef());
			//LeaseMutualActNewAccessBean lmaab = new LeaseMutualActNewAccessBean();//for WTE
			//lmaab.setInitKey_leaseDocument(document.intValue());
			//lmaab.refreshCopyHelper();
			//taskStartBean.setLeasedocument((LeaseDocument)lmaab.getEJBRef());
		}
        taskStartBean.commitCopyHelper();

        return idtask;
    } catch (Exception ex) {
        pr(ex, "taskStart()");
    }
    return -1;
}
}
