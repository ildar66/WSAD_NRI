package com.hps.july.arenda.formbean;

import java.util.Enumeration;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import java.sql.*;
import com.hps.july.persistence.*;
/**
 * Bean-form
 * Форма "Состояние регламента".
 * Creation date: (21.11.2002 11:38:03)
 * @author: Sergey Gourov
 */
public class ReglamentStateForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private java.lang.String mutState;
	private com.hps.july.web.util.StringAndSqlDateProperty documentDate;
	private java.lang.String documentNumber;
	private java.lang.String actType;
	protected java.lang.String initialState;
	private java.lang.Boolean commonRate;
	private java.lang.String contractList;
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:31:38)
 */
public ReglamentStateForm() {
	documentDate = new StringAndSqlDateProperty();
	setMutState("A");
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2005 12:08:42)
 */
private void changeStateReglam(ActionErrors errors) {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        String sql = "execute procedure changeStateReglam(?, ?, ?)";
        con = new com.hps.july.jdbcpersistence.lib.JdbcConnection().getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, getLeaseDocument());
        ps.setString(2, getInitialState());
        ps.setString(3, getMutState());
        System.out.println(
            "EXEC changeStateReglam(" + getLeaseDocument() + "," + getInitialState() + "," + getMutState() + ")");
        rs = ps.executeQuery();
        System.out.println("EXEC changeStateReglam: after executeQuery()"); //temp
        if (rs.next()) {
            int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
            if (result == 0) {
                //setIsMoveError(Boolean.FALSE);
                System.out.println("EXEC changeStateReglam ok: " + result); //temp
            } else {
                //setIsMoveError(Boolean.TRUE);
                String errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
                System.out.println("EXEC changeStateReglam Error: " + errorTxt); //temp
            }
        } else {
            String noData = "no DATA: execute procedure changeStateReglam(?, ?, ?)";
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", noData));
            System.out.println(noData);
        }

    } catch (Exception e) {
        System.out.println("Error in execute procedure changeStateReglam. ReglamentStateForm.changeStateReglam()");
        if (e instanceof SQLException) {
            SQLException sqlEx = (SQLException) e;
            e.printStackTrace();
            while (sqlEx != null) {
                System.out.println("SQLException:ErrorCode=" + sqlEx.getErrorCode());
                System.out.println("SQLException:message=" + sqlEx.getMessage());
                sqlEx = sqlEx.getNextException();
            }
        } else
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
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:38:03)
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
	initialState = getMutState();
	if (initialState == null) {
		initialState = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:37:11)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:38:03)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 12:54:51)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 15:29:01)
 * @return java.lang.String
 */
public java.lang.String getContractList() {
	return contractList;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:38:03)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	try {
		setContractList("");
		Enumeration e = new LeaseContractAccessBean().findLeaseContractsByReglamentOrderByCodeAsc(new Integer(getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseContractAccessBean lcBean = (LeaseContractAccessBean) e.nextElement();
			StringAndSqlDateProperty s = new StringAndSqlDateProperty();
			s.setSqlDate(lcBean.getDocumentDate());
			
			if (getContractList().equals("")) {
				setContractList(lcBean.getDocumentNumber() + "-" + s.getString());
			} else {
				setContractList(getContractList() + "; " + lcBean.getDocumentNumber() + "-" + s.getString());
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		setContractList("");
	}
	
	LeaseMutualReglamentAccessBean bean = new LeaseMutualReglamentAccessBean();
	bean.setInitKey_leaseDocument(getLeaseDocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:28:25)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:28:25)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:36:43)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 16:32:30)
 * @return java.lang.String
 */
public java.lang.String getInitialState() {
	return initialState;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:41:37)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:14:53)
 * @return java.lang.String
 */
public java.lang.String getMutState() {
	return mutState;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:38:03)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.STATE_MUTREGLMNT_EDIT;
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	validateValues(errors);
	changeStateReglam(errors);//вызов процедуры.
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:37:11)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 12:54:51)
 * @param newCommonRate java.lang.Boolean
 */
public void setCommonRate(java.lang.Boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 15:29:01)
 * @param newContractList java.lang.String
 */
public void setContractList(java.lang.String newContractList) {
	contractList = newContractList;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:28:25)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:28:25)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:36:43)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 16:32:30)
 * @param newInitialState java.lang.String
 */
public void setInitialState(java.lang.String newInitialState) {
	initialState = newInitialState;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 11:41:37)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 12:14:53)
 * @param newMutState java.lang.String
 */
public void setMutState(java.lang.String newMutState) {
	mutState = newMutState;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
/**	
	if (initialState.equals("B") && getMutState().equals("A")) {
		java.util.Enumeration e = new LeaseMutualActNewAccessBean().findLeaseMutualActNewByLeaseMutualReglament(
			new LeaseDocumentKey(getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseMutualActNewAccessBean lmaBean = (LeaseMutualActNewAccessBean) e.nextElement();
			if (!lmaBean.getActState().equals("O")) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.state.haswrongact"));
			}
		}
	}
	
	if (getMutState().equals("B")) {
		if (getCommonRate().booleanValue()) {
			Enumeration e = new LeaseMutualRuleNewAccessBean().findLeaseMutualRulesByReglament(new LeaseDocumentKey(getLeaseDocument()));
			while (e.hasMoreElements()) {
				((LeaseMutualRuleNewAccessBean) e.nextElement()).getEJBRef().remove();
			}
		} else {
			Enumeration e = new ResourceAccessBean().findResourceByReglamentOrderByCodeAsc(new Integer(getLeaseDocument()));
			while (e.hasMoreElements()) {
				ResourceAccessBean bean = (ResourceAccessBean) e.nextElement();
				try {
					LeaseMutualRuleNewAccessBean lmrBean = new LeaseMutualRuleNewAccessBean();
					lmrBean.setInitKey_reglament_leaseDocument(new Integer(getLeaseDocument()));
					lmrBean.setInitKey_resource_resource(new Integer(bean.getResource()));
					lmrBean.refreshCopyHelper();
				} catch (javax.ejb.ObjectNotFoundException ex) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.norule"));
					break;
				}
			}
		}
		
		Enumeration e = new LeaseMutualReglamentAccessBean().findConcurentReglamentsByReglament(new Integer(getLeaseDocument()));
		if (e.hasMoreElements()) {
			String reglaments = "";
			while (e.hasMoreElements()) {
				LeaseMutualReglamentAccessBean lmrBean = (LeaseMutualReglamentAccessBean) e.nextElement();
				reglaments = (reglaments.equals("") ? "" : (reglaments + ", ")) + lmrBean.getDocumentNumber();
			}
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.double", reglaments));
		}
		
		LeaseMutualReglamentAccessBean lmrBean = new LeaseMutualReglamentAccessBean();
		lmrBean.setInitKey_leaseDocument(getLeaseDocument());
		lmrBean.refreshCopyHelper();
		
		e = new LeaseMutualActNewAccessBean().findLeaseMutualActNewByLeaseMutualReglament(new LeaseDocumentKey(getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseMutualActNewAccessBean bean = (LeaseMutualActNewAccessBean) e.nextElement();
			if (bean.getActstartdate().compareTo(lmrBean.getStartdate()) < 0 ||
				bean.getActstartdate().compareTo(lmrBean.getEnddate()) > 0 ||
				bean.getActenddate().compareTo(lmrBean.getStartdate()) < 0 ||
				bean.getActenddate().compareTo(lmrBean.getEnddate()) > 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.haswrongactperiod"));
				break;
			}
		}
		
		if (lmrBean.getActType().equals("S")) {
			// не более одного договора
			int i = 0;
			e = new LeaseContractAccessBean().findLeaseContractsByReglamentOrderByCodeAsc(new Integer(getLeaseDocument()));
			while (e.hasMoreElements()) {
				e.nextElement();
				if (++i > 1) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.actsverki"));
					break;
				}
			}
		} else if (lmrBean.getActType().equals("A")) {
 			// более 2 юр лиц...
 			int i = 0;
 			e = new OrganizationAccessBean().findOrganizationsByReglament(new Integer(getLeaseDocument()), new Integer(getLeaseDocument()));
			while (e.hasMoreElements()) {
				e.nextElement();
				if (++i > 2) {
		 			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.moretwoorg"));
		 			break;
	 			}
 			}
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
*/	
}
}
