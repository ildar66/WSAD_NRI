package com.hps.july.arenda.billing;

import java.math.BigDecimal;
import java.util.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/** 
 * This is a Session Bean Class
 * ������� ������ �������� �� ������ NRI � ������� NRI
 */
public class BufferNri2NriBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	private JournalAccessBean journal = null;
	private BillingRequiredNewAccessBean brab = null;
private boolean addMsgInJournal(int idtask, String jrnType, String jrnMsg){

	try{
		return getJournal().addMsgInJournal(idtask, jrnType, jrnMsg);
	}catch(Exception ex){
		pr(ex, "addMsgInJournal");
	}
	return false;
}
public boolean dismissAbonentContract(int idtask, Integer ban, Date dateStart)  throws java.rmi.RemoteException {
// �������� �������� ��������� ������ � ������ ������� NRI
	try{
		Object[] abPayments = getBillingRequired().getDeletingAbonentPayment(idtask, ban, dateStart);
		if(abPayments != null)
			for(int i=0; i< abPayments.length; i++)
				if(!getBillingRequired().removePayments2DocPos(idtask, ((Integer)abPayments[i]).intValue())){
					String msg="�� ������� ������� ����� ������������ ������� "+(Integer)abPayments[i];
					addMsgInJournal(idtask, "E", msg);
					return false;
				}
		Object[] abBills = getBillingRequired().getDeletingAbonentBill(idtask, ban, dateStart);
		if(abBills != null)
			for(int i=0; i<abBills.length; i++)
				if(!getBillingRequired().removeBillPos2DocPos(idtask, (Integer)abBills[i])){
					String msg="�� ������� ������� ����� ������������ ����� "+(Integer)abBills[i];
					addMsgInJournal(idtask, "E", msg);
					return false;
				}
		return true;
	}catch(Exception ex){
		String msg="����������� ������ � dismissAbonentContract";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "dismissAbonentContract");
	}
	return false;
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	journal = null;
	brab = null;
}
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
public void ejbPassivate() throws java.rmi.RemoteException {
	journal = null;
	brab = null;
}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {
	journal = null;
	brab = null;
}
private BillingRequiredNewAccessBean getBillingRequired(){
	if(brab != null)
		return brab;
	brab = new BillingRequiredNewAccessBean();
	return brab;
}
private JournalAccessBean getJournal() {
    try {
	    if(journal != null) return journal;
	    else {
		    journal = new JournalAccessBean();
		    return journal;
	    }
    } catch (Exception ex) {
        pr(ex, "getJournal()");
    }
    return null;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
public boolean moveAllBillBufferNri2Nri(int idtask) throws java.rmi.RemoteException{
// ��������� ������ �� ������ �� ������ ������� NRI � ������� NRI
	try{
		Object[] bills = getBillingRequired().getAllAbonentBillsByFlag(idtask, "N");
		for(int i=0; i<bills.length; i++)
			if(!moveOneBillBufferNri2Nri(idtask, (Integer)bills[i])){
				String msg="���� "+(Integer)bills[i]+" �� ���������";
				addMsgInJournal(idtask, "E", msg);
			}
		
		return true;
	}catch(Exception ex){
		String msg="����������� ������ � moveAllBillBufferNri2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveAllBillBufferNri2Nri");
	}
	return false;
}
public boolean moveAllDnopBufferNri2Nri(int idtask) throws java.rmi.RemoteException{
// ������� ������ �� ����� ������ � �������� �� ������ ������� NRI � ������� NRI
	try{
		Object[] dnops = getBillingRequired().getAllAbonentDnopByFlag(idtask, "N");
		for(int i=0; i < dnops.length; i++)
			if(!getBillingRequired().moveOneDnopBufferNri2Nri(idtask, (Integer)dnops[i])){
				String msg="C���� "+((Integer)dnops[i])+" �� ����������";
				addMsgInJournal(idtask, "E", msg);
			}
		return true;
	}catch(Exception ex){
		String msg="����������� ������ � moveAllDnopBufferNri2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveAllDnopBufferNri2Nri");
	}
	return false;
}
public boolean moveAllPaymentBufferNri2Nri(int idtask, boolean autoLinkPaymentBen) throws java.rmi.RemoteException{
// ��������� ������ �� ������ ������� NRI � ������� NRI
	try{
		Object[] payments = getBillingRequired().getAllPaymentByFlag(idtask, "N");
		for(int i=0; i<payments.length; i++)
			if(!moveOnePaymentBufferNri2Nri(idtask, (Integer)payments[i], autoLinkPaymentBen)){
				String msg="������ "+(Integer)payments[i]+" �� ���������";
				addMsgInJournal(idtask, "E", msg);
			}
		
		return true;
	}catch(Exception ex){
		String msg="����������� ������ � moveAllPaymentBufferNri2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveAllPaymentBufferNri2Nri");
	}
	return false;
}
public boolean moveOneBillBufferNri2Nri(int idtask, Integer idBill){
// ��������� ������ �� ����� �� ������ ������� NRI � ������� NRI
	try{
		////if(!getBillingRequired().setParamBillForMoveBill2Nri(idtask, idBill))
			////return false;
		//if(!getBillingRequired().setParamBillForMoveBill2Nri(idtask, idBill))
			//return false;
		//Boolean flagNeed = getBillingRequired().getBillFlagNeed(idtask, idBill);
		//if(flagNeed == null){
			//String msg="� ����� "+idBill+" �� ���������� ���� '������������ � NRI'";
			//addMsgInJournal(idtask, "E", msg);
			//return false;
		//} else if(!flagNeed.booleanValue())
			//return true;			
		//if(!getBillingRequired().checkPossibleMoveBill2Nri(idtask, idBill))
			//return false;
		//if(!getBillingRequired().workAbonentBillPos(idtask, idBill))
			//return false;
		//return true;
		Pie2NriAccessBean ab = new Pie2NriAccessBean();
		return ab.moveBilFromBilling("L", idBill.intValue(), idtask);
	}catch(Exception ex){
		String msg="����������� ������ � moveOneBillBufferNri2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveOneBillBufferNri2Nri");
	}
	return false;
}
public boolean moveOnePaymentBufferNri2Nri(int idtask, Integer idPay, boolean autoLinkPaymentBen){
// ��������� ������ �� ������ ������� NRI � ������� NRI
	try{
		//if(getBillingRequired().getAbonentPaymentByHand(idtask, idPay) || autoLinkPaymentBen == true)
			//getBillingRequired().defineSumPayNeedForNri(idtask, idPay);
			
		//if(!getBillingRequired().checkPossibleMovePayment2Nri(idtask, idPay))
			//return false;
			
		//if(!getBillingRequired().workAbonentPayment(idtask, idPay))
			//return false;
			
		//return true;
		String autolink = autoLinkPaymentBen ? "Y" : "N";
		Pie2NriAccessBean ab = new Pie2NriAccessBean();
		return ab.movePayFromBilling(idPay.intValue(), idtask, autolink);
	}catch(Exception ex){
		String msg="����������� ������ � moveOnePaymentBufferNri2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveOnePaymentBufferNri2Nri");
	}
	return false;
}
void pr(Exception ex, String str) {
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
	System.out.println(new java.util.Date());
	if(ex != null){
		System.out.println(ex.getClass().getName() + " in " + this.getClass().getName() +"."+ str + 
		". Message is:" + ex.getMessage());
		processEx(ex);
		ex.printStackTrace();
	}
	else
		System.out.println(this.getClass().getName() +"."+ str);
	processEx(ex);
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
}
void pr(String str) {
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
		System.out.println(this.getClass().getName() +"."+ str);
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
}
private void processEx(Exception ex) {
    if (!(ex instanceof RemoteException) && !(ex instanceof EJBException) && !(ex instanceof RuntimeException))
        mySessionCtx.setRollbackOnly();

    	try{
    if (ex instanceof java.rmi.ServerException) {
        if (((java.rmi.ServerException) ex).detail instanceof com.ibm.ejs.persistence.EJSPersistenceException) {
            if (((com.ibm.ejs.persistence.EJSPersistenceException)
	            (((java.rmi.ServerException) ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.ejs.persistence.EJSPersistenceException)
	                (((java.rmi.ServerException) ex).detail)).detail)).getErrorCode();
                pr("Error code = " + code);
            }
        } else if (((java.rmi.ServerException)ex).detail instanceof com.ibm.websphere.cpi.CPIException) {
            if (((com.ibm.websphere.cpi.CPIException) 
	            (((java.rmi.ServerException)ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.websphere.cpi.CPIException)
	                (((java.rmi.ServerException)ex).detail)).detail)).getErrorCode();
                pr("Error code = " + code);
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
public void taskEnd(int idtask) throws java.rmi.RemoteException {
    try {
        getJournal().taskEnd(idtask);
    } catch (Exception ex) {
        pr(ex, "taskEnd. idtask=" + idtask);
        String msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
    }
}
public int taskStart(int operator, String taskType) throws java.rmi.RemoteException{
    try {
	    return getJournal().taskStart(operator, taskType);
    } catch (Exception ex) {
        pr(ex, "taskStart()");
        String msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
    }
}
}
