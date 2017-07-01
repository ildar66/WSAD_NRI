package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.ReportFinderForm;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.NamedValueAccessBean;
import java.sql.*;
import javax.servlet.http.*;
import java.util.*;
/**
 * Action для получения документа "Заявление на присвоение радиочастот "
 */
public class GetReportAppropriationRequestAction extends GetReportAction {
/**
 * 
 */
public String constructReportString(Set freqranges) throws java.lang.Exception {
	if(freqranges == null)
		return null;
	StringBuffer freqrangesBuff = new StringBuffer();
	String freqrange;
	Iterator it = freqranges.iterator();
	while(it.hasNext()) {
		freqrange = (String)it.next();
		if(freqrange != null && freqrange.length() != 0) {
			freqrangesBuff.append(freqrange.trim());
			freqrangesBuff.append(", ");
		}
	}
	if(freqrangesBuff.length() > 0) {
		return freqrangesBuff.substring(0, freqrangesBuff.length() - 2);
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 18:21:21)
 * @return java.lang.String
 */
public String getAddressee() {
	return "ReportAppropriationRequestAddressee";
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 18:11:54)
 * @return java.lang.String
 */
public String getPerformer() {
	return "ReportRequestLetterPerformer";
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 18:03:25)
 * @return java.lang.String
 * @param filenumber int
 */
public String getQueryString(int filenumber) {
	StringBuffer buffer = new StringBuffer("select s2r.freqrange ");
	buffer.append("from freqpermissions f, perm2hops p2h, rrl_hops2 rh, sitedocs2resources s2r, GKRCHDocs g ");
	buffer.append("where f.filenumber=");
	buffer.append(filenumber);
	buffer.append(" and p2h.freqpermid=f.freqpermid and rh.hopsid=p2h.hopsid and s2r.resource=rh.resource_doc and ");
	buffer.append("g.sitedoc=s2r.sitedoc");
	return buffer.toString();
}
/**
 * 
 */
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws java.lang.Exception {
		if(null == finderForm)
		return null;
	int filenumber = finderForm.getFilenumber();
	TreeSet set = new TreeSet();
	String freqrange = null;
	//String freqrangesString = null;
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(this.getQueryString(filenumber));
		while(resultSet.next()) {
			freqrange = resultSet.getString("freqrange");
			if(freqrange != null && freqrange.length() != 0) {
				set.add(freqrange);
			}
//			freqrangesString = constructReportLine(new Object[] {resultSet});
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
	return constructReportString(set);
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 18:12:56)
 * @return java.lang.String
 */
public String getUnderlineName() {
	return "ReportRequestLetterName";
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2004 18:12:32)
 * @return java.lang.String
 */
public String getUnderlineTitle() {
	return "ReportRequestLetterTitle";
}
/**
 * 
 */
public void setUnderlineParamsToRequest(HttpServletRequest request) {
	NamedValueAccessBean nab = new NamedValueAccessBean();
	try{
		nab.setInitKey_id(getAddressee());
		nab.refreshCopyHelper();
		request.setAttribute("addressee", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("addressee", "");
		System.out.println("System constant 'ReportAppropriationRequestAddressee' is missing!");
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
		request.setAttribute("performer", "");
		System.out.println("System constant 'ReportRequestLetterPerformer' is missing!");
	}
}
}
