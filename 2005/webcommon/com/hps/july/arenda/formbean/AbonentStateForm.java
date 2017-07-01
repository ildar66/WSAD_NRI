package com.hps.july.arenda.formbean;

import com.hps.july.arenda.sessionbean.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.valueobject.LeaseAbonentBANValue;
import com.ibm.ivj.ejb.runtime.*;
import java.text.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
/**
 * Form-Bean 
 * состояние "абонентских договоров"
 * Creation date: (04.10.2002 10:16:45)
 * @author: Sergey Gourov
 */
public class AbonentStateForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private java.lang.String contractState;
	private java.lang.String initialState;
	private java.lang.Boolean isMoveError;
	private boolean editDisabled = false;
	private boolean closedDisabled = false;
/**
 * Insert the method's description here.
 * Creation date: (10.02.2004 17:04:15)
 */
private void changeStateContract(ActionErrors errors) {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		String sql = "execute procedure changestatecontr(?, ?, ?)";
		con = new JdbcConnection().getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, getLeaseDocument());
		ps.setString(2, getInitialState());
		ps.setString(3, getContractState());
		System.out.println(
			"EXEC changestatecontr(" + getLeaseDocument() + "," + getInitialState() + "," + getContractState() + ")");
		rs = ps.executeQuery();
		//System.out.println("EXEC changestatecontr: after executeQuery()"); //temp
		if (rs.next()) {
			int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
			if (result == 0) {
				setIsMoveError(Boolean.FALSE);
				System.out.println("EXEC changestatecontr ok: " + result); //temp
			} else {
				setIsMoveError(Boolean.TRUE);
				String errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
				System.out.println("EXEC changestatecontr Error: " + errorTxt); 
			}
		} else {
			String noData = "no DATA: execute procedure changestatecontr(?, ?, ?)";
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", noData));
			System.out.println(noData);
		}

	} catch (Exception e) {
		System.out.println("Error in execute procedure changestatecontr. AbonentStateForm.changeStateContract()");
		if (e instanceof SQLException) {
			System.out.println("Error code=" + ((SQLException) e).getErrorCode());
		}
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
private boolean checkExistAbonentBills(LeaseAbonentBANAccessBean ban){
	try {
		Enumeration enum = ban.getAbonentBills();
		if(enum.hasMoreElements())
			return true;
		else
			return false;
	} catch (Exception e) {
		System.out.println("Error in AbonentStateForm.checkExistAbonentBills()");
		e.printStackTrace(System.out);
		return false;
	}	
}
private boolean checkExistAbonentPayments(LeaseAbonentBANAccessBean ban){
	try {
		Enumeration enum = ban.getAbonentPayments();
		if(enum.hasMoreElements())
			return true;
		else
			return false;
	} catch (Exception e) {
		System.out.println("Error in AbonentStateForm.checkExistAbonentPayments()");
		e.printStackTrace(System.out);
		return false;
	}	
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	setInitialState(getContractState() != null ? getContractState() : "");
	setIsMoveError(new Boolean(false));
	setDisabledRadio();
}
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2003 15:26:49)
 * @return java.lang.String
 */
public java.lang.String getContractState() {
	return contractState;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseAbonentBANAccessBean bean = new LeaseAbonentBANAccessBean();
	bean.setInitKey_leaseDocument(getLeaseDocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2003 15:27:37)
 * @return java.lang.String
 */
public java.lang.String getInitialState() {
	return initialState;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 11:47:32)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsMoveError() {
	return isMoveError;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:35:30)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_STATE;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 19:05:20)
 * @return boolean
 */
public boolean isClosedDisabled() {
	return closedDisabled;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 19:05:20)
 * @return boolean
 */
public boolean isEditDisabled() {
	return editDisabled;
}
/**
 * Insert the method's description here.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	validateValues(errors);
	changeStateContract(errors);//вызов процедуры.
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 19:05:20)
 * @param newClosedDisabled boolean
 */
public void setClosedDisabled(boolean newClosedDisabled) {
	closedDisabled = newClosedDisabled;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2003 15:26:49)
 * @param newContractState java.lang.String
 */
public void setContractState(java.lang.String newContractState) {
	contractState = newContractState;
}
private void setDisabledRadio(){
	if ("B".equals(getInitialState())){
		setEditDisabled(false);
		setClosedDisabled(false);
	}
	if ("A".equals(getInitialState())){
		setEditDisabled(false);
		setClosedDisabled(true);
	}
	if ("C".equals(getInitialState())){
		setEditDisabled(true);
		setClosedDisabled(false);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 19:05:20)
 * @param newEditDisabled boolean
 */
public void setEditDisabled(boolean newEditDisabled) {
	editDisabled = newEditDisabled;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2003 15:27:37)
 * @param newInitialState java.lang.String
 */
public void setInitialState(java.lang.String newInitialState) {
	initialState = newInitialState;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 11:47:32)
 * @param newIsMoveError java.lang.Boolean
 */
public void setIsMoveError(java.lang.Boolean newIsMoveError) {
	isMoveError = newIsMoveError;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:35:30)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {

	// Определение выключены ли чекбоксы
	setDisabledRadio();
	
/** patch SI 10.02.2004 временно сняли проверки	
	if(("B".equals(getInitialState()) && "A".equals(getContractState())) ){
	
		LeaseAbonentBANAccessBean ban = new LeaseAbonentBANAccessBean();
		ban.setInitKey_leaseDocument(getLeaseDocument());
		ban.refreshCopyHelper();

		if(checkExistAbonentBills(ban))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.state.invalid.bill"));
		if(checkExistAbonentPayments(ban))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.state.invalid.payment"));
			
	}


	//if (("B".equals(getInitialState()) && "A".equals(getContractState())) 
		//|| ("C".equals(getInitialState()) && "B".equals(getContractState()))) {
			
		//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.state.invalid"));
	//}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
	
	try {
		if (new ArendaDocumentProcessorAccessBean().moveBanToBilling(getLeaseDocument()) == 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.state.movebantobilling"));
		}
	} catch (Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.state.movebantobilling"));
	}
	
	if (!errors.empty()) {
		setIsMoveError(new Boolean(true));
		
		LeaseAbonentBANAccessBean bean = (LeaseAbonentBANAccessBean) getDataBean(null);
		bean.refreshCopyHelper();
		bean.setContractState(getContractState());
		bean.commitCopyHelper();
		
		throw new ValidationException();
	}
*/	
}
}
