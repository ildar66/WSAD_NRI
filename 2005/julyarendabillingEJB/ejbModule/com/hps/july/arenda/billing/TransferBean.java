package com.hps.july.arenda.billing;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Алгоритм переноса данных из биллинга в систему NRI
 */
public class TransferBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
/**
Object[4]
Состав: Integer, Boolean, Integer, Boolean
Первые два элемента код задачи и результат ее выполнения для moveAllPie2BufferNri
Вторые два элемента код задачи и результат ее выполнения для moveAllBufferNri2Nri
Все элементы надо проверять на null
*/	 
	private Object[] result = null;
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {

	result = null;
}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {

	result = null;
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {
	
	result = null;	
}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {
	result = null;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
public boolean moveAllBufferNri2Nri(int operator)throws java.rmi.RemoteException{
// Передача всех данных из буфера системы Nri в систему Nri
	try{
		BufferNri2NriAccessBean ab = new BufferNri2NriAccessBean();
		int idtask = ab.taskStart(operator, "7");
		result[2] = new Integer(idtask);
		
		if(!ab.moveAllPaymentBufferNri2Nri(idtask, true))
			return false;
		if(!ab.moveAllBillBufferNri2Nri(idtask))
			return false;
		if(!ab.moveAllDnopBufferNri2Nri(idtask))
			return false;
		
		ab.taskEnd(idtask);

		result[3] = new Boolean(true);
		return true;		
	}catch(Exception ex){
		pr(ex, "moveAllBufferNri2Nri");
	}
	result[3] = new Boolean(false);
	return false;
}
public boolean moveAllPie2BufferNri(int operator)throws java.rmi.RemoteException{
	// Перенос данных из PIE в буфер NRI
	try{
		Pie2NriAccessBean ab = new Pie2NriAccessBean();
		int idtask = ab.taskStart(operator, "6");
		result[0] = new Integer(idtask);
 
		ab.moveAbonentDogovorsPie2BufferNri(idtask);
		ab.moveAllPaymentPie2BufferNri(idtask);
		ab.moveAllBillPie2BufferNri(idtask);
		ab.moveAllDnopPie2BufferNri(idtask);
		ab.checkWorkBanInPie(idtask);
		
		ab.taskEnd(idtask);
		
		result[1] = new Boolean(true);
		return true;
	}catch(Exception ex){
		pr(ex, "moveAllPie2BufferNri");
	}
	result[1] = new Boolean(false);
	return false;
}
public Object[] moveAllPie2Nri(int operator)throws java.rmi.RemoteException{
// Перенос данных из биллинга в нашу систему
	result = new Object[4];
	if(!moveAllPie2BufferNri(operator))
		return result;
	if(!moveAllBufferNri2Nri(operator))
		return result;

	return result;
}
void pr(Exception ex, String str) {
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
	System.out.println(new java.util.Date());
	if(ex != null){
		System.out.println(ex.getClass().getName() + " in " + this.getClass().getName() +"."+ str + 
		". Message is:" + ex.getMessage());
		ex.printStackTrace();
	}
	else
		System.out.println(this.getClass().getName() +"."+ str);
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
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
