package com.hps.july.arenda.formbean;

import com.hps.july.arenda.sessionbean.*;
import com.hps.july.web.util.*;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import javax.sql.*;
/**
 * Form-Bean
 * "Состояние актов"
 * Creation date: (12.12.2002 20:27:31)
 * @author: Sergey Gourov
 */
public class ActStateForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private java.lang.String actState;
	private java.lang.String initialState;
	private boolean isEdit;
	private boolean isClosed;
	public static final String HOWTO_CALCULATE_ACT = "DEFRULECALCACT";
	private boolean ignoreWarning = false;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {

	// Calculate act
	if (getInitialState().equals("O") && getActState().equals("R")) {
		if (!calculateAct(true, request)) {
			throw new UpdateValidationException("error.mutualact.calcact");
		}
	}

	// Decalculate act
	if ((getInitialState().equals("R") || getInitialState().equals("O")) && getActState().equals("O")) {
		if (!calculateAct(false, request)) {
			throw new UpdateValidationException("error.mutualact.rollbackcalcact");
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 12:50:47)
 */
private void calcActWarning(ActionErrors errors) { // Stored proc calculation
    System.out.println("ARENDA: Calling calcActWarning(?, ?, ?) - StoredProc method, act=" + getLeaseDocument());
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement ps = null;
    try {
        con = jcon.getConnection();
        ps = con.prepareStatement("EXECUTE PROCEDURE calcActWarning(?, ?, ?);");
        ps.setInt(1, getLeaseDocument()); // код акта
        ps.setString(2, getInitialState()); // исходное состояние
        ps.setString(3, getActState()); // конечное состояние
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt(1) != 0)
                errors.add("org.apache.struts.action.GLOBAL_WARNING", new ActionError("error.txt", rs.getString(2)));
        }
/**        
        if (!errors.empty())
            errors.add(
                "org.apache.struts.action.GLOBAL_WARNING",
                new ActionError("error.txt", "Для игнорирования этих предупреждений нажмите сохранить повторно!!!"));
*/                
            setIgnoreWarning(true);
        rs.close();
    } catch (Exception e) {
        e.printStackTrace(System.out);
    } finally {
        try {
            ps.close();
        } catch (Exception ee) {
            ee.printStackTrace(System.out);
        }
        try {
            con.close();
        } catch (Exception ee) {
            ee.printStackTrace(System.out);
        }
    }
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2003 14:55:37)
 * @return boolean
 * @param isForward boolean
 */
private boolean calculateAct(boolean isForward, javax.servlet.http.HttpServletRequest request) 
		throws Exception {
	boolean result = false;

	// Check calculation method - by EJB/ by Procedure
	boolean calcByEJB = true;

	try {
		NamedValueAccessBean nv = new NamedValueAccessBean();
		nv.setInitKey_id(HOWTO_CALCULATE_ACT);
		nv.refreshCopyHelper();
		if (nv.getIntvalue() == 1)
			calcByEJB = false;
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	
	// Calculate / Decalculate act
	if (isForward) {
		// Calculate act
		if (calcByEJB) {
			// Regular calculation
			System.out.println("ARENDA: Calling calcAct - EJB method, act=" + getLeaseDocument());
			if (new CalculateArendaActAccessBean().calcAct(new Integer(getLeaseDocument()), getCurrOperator(request), null)) {
				result = true;
			}
		} else {
			// Stored proc calculation
			System.out.println("ARENDA: Calling calcAct - StoredProc method, act=" + getLeaseDocument());
			JdbcConnection jcon = new JdbcConnection();
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = jcon.getConnection();
				ps = con.prepareStatement("EXECUTE PROCEDURE calcAct(?, ?, ?, ?);");
				ps.setInt(1, getLeaseDocument()); // id_Act
				ps.setInt(2, 0); // Task start
				ps.setInt(3, getCurrOperator(request)); // Operator
				ps.setInt(4, 0); // 1=Temp act, 0=Persist act
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					if (rs.getInt(1) == 0)
						result = true;
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			} finally {
				try {
					ps.close();
				} catch (Exception ee) {
					ee.printStackTrace(System.out);
				}
				try {
					con.close();
				} catch (Exception ee) {
					ee.printStackTrace(System.out);
				}
			}
		}
	} else {
		// De-Calculate act
		if (calcByEJB) {
			// Regular de-calculation
			System.out.println("ARENDA: Calling rollbackAct - EJB method, act=" + getLeaseDocument());
			if (new ArendaTransactionMethodAccessBean().rollbackCalcAct(new Integer(getLeaseDocument()))) {
				result = true;
			}
		} else {
			// Stored proc de-calculation
			System.out.println("ARENDA: Calling rollbackAct - StoredProc method, act=" + getLeaseDocument());
			JdbcConnection jcon = new JdbcConnection();
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = jcon.getConnection();
				ps = con.prepareStatement("EXECUTE PROCEDURE freeact(?, ?, ?);");
				ps.setInt(1, getLeaseDocument()); // id_Act
				ps.setInt(2, 0); // Task start
				ps.setInt(3, getCurrOperator(request)); // Operator
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					if (rs.getInt(1) == 0)
						result = true;
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			} finally {
				try {
					ps.close();
				} catch (Exception ee) {
					ee.printStackTrace(System.out);
				}
				try {
					con.close();
				} catch (Exception ee) {
					ee.printStackTrace(System.out);
				}
			}
		}
	}
	
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:27:31)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	setIsEdit(!"C".equals(getActState()));
	setIsClosed(!"O".equals(getActState()));
	
	setInitialState(getActState());
	if (getInitialState() == null) {
		setInitialState("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:43:33)
 * @return java.lang.String
 */
public java.lang.String getActState() {
	return actState;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:27:31)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2003 15:05:13)
 * @return int
 */
private int getCurrOperator(javax.servlet.http.HttpServletRequest request) {
	// Determine operator
	int operator = 1;
	try {
		operator = new OperatorAccessBean().findByLogin(request.getRemoteUser()).getOperator();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:27:31)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseMutualActNewAccessBean bean = new LeaseMutualActNewAccessBean();
	bean.setInitKey_leaseDocument(getLeaseDocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2002 13:18:27)
 * @return java.lang.String
 */
public java.lang.String getInitialState() {
	return initialState;
}
/**
 * Insert the method's description here.
 * Creation date: (30.06.2003 12:39:01)
 * @return boolean
 */
public boolean getIsClosed() {
	return isClosed;
}
/**
 * Insert the method's description here.
 * Creation date: (30.06.2003 12:37:45)
 * @return boolean
 */
public boolean getIsEdit() {
	return isEdit;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:29:03)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:27:31)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.STATE_MUTACT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 13:10:48)
 * @return boolean
 */
public boolean isIgnoreWarning() {
	return ignoreWarning;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:43:33)
 * @param newActState java.lang.String
 */
public void setActState(java.lang.String newActState) {
	actState = newActState;
}
/**
 * Insert the method's description here.
 * Creation date: (01.12.2004 13:10:48)
 * @param newIgnoreWarning boolean
 */
public void setIgnoreWarning(boolean newIgnoreWarning) {
	ignoreWarning = newIgnoreWarning;
}
/**
 * Insert the method's description here.
 * Creation date: (29.12.2002 13:18:27)
 * @param newInitialState java.lang.String
 */
public void setInitialState(java.lang.String newInitialState) {
	initialState = newInitialState;
}
/**
 * Insert the method's description here.
 * Creation date: (30.06.2003 12:39:01)
 * @param newIsClosed boolean
 */
public void setIsClosed(boolean newIsClosed) {
	isClosed = newIsClosed;
}
/**
 * Insert the method's description here.
 * Creation date: (30.06.2003 12:37:45)
 * @param newIsEdit boolean
 */
public void setIsEdit(boolean newIsEdit) {
	isEdit = newIsEdit;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 20:29:03)
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
    if (!isIgnoreWarning())
        calcActWarning(errors);
    if (!errors.empty()) {
        throw new ValidationException();
    }
}
}
