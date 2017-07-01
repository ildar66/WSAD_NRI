package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.basestation.valueobject.ReportRequestLetterValue;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.NamedValueAccessBean;
import java.sql.*;
import javax.servlet.http.*;
/**
 * Action для получения документа "Письмо-заявка"
 */
public class GetReportRequestLetterAction extends GetReportAction {
/**
 * 
 */
public ReportRequestLetterValue constructReportLine(Object[] params) throws java.lang.Exception {
	if(params == null)
		return null;
	if(params[0] == null) 
		return null;
	ResultSet rs = (ResultSet)params[0];
	ReportRequestLetterValue value = (ReportRequestLetterValue)params[1];
	String parameter = rs.getString("model");
	if(parameter != null && parameter.length() != 0)
		value.addModel(parameter.trim());
	parameter = rs.getString("speed_doc");
	if(parameter != null && parameter.length() != 0)
		value.addSpeed(parameter.trim());
	value.increaseQuantity();
	return value;
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:46:25)
 * @return java.lang.String
 */
public String getAddressee() {
	return "ReportRequestLetterAddressee";
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:56:44)
 * @return java.lang.String
 */
public String getPerformer() {
	return "ReportRequestLetterPerformer";
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:56:44)
 * @return java.lang.String
 */
public String getPerformerTel() {
	return "ReportRequestLetterPerformerTel";
}
public String getQueryString(int filenumber) {
	StringBuffer buffer = new StringBuffer("SELECT rh.resource_doc, r.model, rh.speed_doc ");
	buffer.append("FROM freqpermissions f, perm2hops p2h, rrl_hops2 rh, outer resources r ");
	buffer.append("WHERE f.filenumber = ");
	buffer.append(filenumber);
	buffer.append("AND p2h.freqpermid = f.freqpermid AND rh.hopsid = p2h.hopsid AND r.resource=rh.resource_doc ");
	return buffer.toString();
}
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws java.lang.Exception {
	if(null == finderForm)
		return null;
	int filenumber = finderForm.getFilenumber();
	ReportRequestLetterValue reportValue = new ReportRequestLetterValue();
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(this.getQueryString(filenumber));
		while(resultSet.next()) {
			reportValue = constructReportLine(new Object[] {resultSet, reportValue});
		}
	} catch(Exception e) {
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		throw new Exception();
	} finally {
		try { resultSet.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
		try { statement.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
		try { connection.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
	}
	return reportValue;
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:37:16)
 * @return java.lang.String
 */
public String getUnderlineName() {
	return "ReportRequestLetterName";
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:37:36)
 * @return java.lang.String
 */
public String getUnderlineTitle() {
	return "ReportRequestLetterTitle";
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 16:46:48)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void setUnderlineParamsToRequest(HttpServletRequest request) {
	NamedValueAccessBean nab = new NamedValueAccessBean();
	try{
		nab.setInitKey_id(getAddressee());
		nab.refreshCopyHelper();
		request.setAttribute("addressee", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("addressee", "");
		System.out.println("System constant 'ReportRequestLetterAddressee' is missing!");
	}
	try{
		nab = new NamedValueAccessBean();
		nab.setInitKey_id(getUnderlineTitle());
		nab.refreshCopyHelper();
		request.setAttribute("underlinetitle", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("underlinetitle", "");
		System.out.println("System constant 'ReportRequestLetterTitle' is missing!");
	}
	try {
		nab = new NamedValueAccessBean();
		nab.setInitKey_id(getUnderlineName());
		nab.refreshCopyHelper();
		request.setAttribute("underlinename", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("underlinename", "");
		System.out.println("System constant 'ReportRequestLetterName' is missing!");
	}
	try{
		nab = new NamedValueAccessBean();
		nab.setInitKey_id(getPerformer());
		nab.refreshCopyHelper();
		request.setAttribute("performer", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("performer", "ReportRequestLetterPerformer");
		System.out.println("System constant 'ReportRequestLetterPerformer' is missing!");
	}
	try{
		nab = new NamedValueAccessBean();
		nab.setInitKey_id(getPerformerTel());
		nab.refreshCopyHelper();
		request.setAttribute("performertel", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("performer", "ReportRequestLetterPerformerTel");
		System.out.println("System constant 'ReportRequestLetterPerformerTel' is missing!");
	}
}
}
