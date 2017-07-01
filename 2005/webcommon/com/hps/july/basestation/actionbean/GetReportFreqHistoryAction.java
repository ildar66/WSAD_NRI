package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportFreqHistoryValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
/**
 * Action для получения отчета "история файла".
 */
public class GetReportFreqHistoryAction extends GetReportAction {
/**
 * Конструирует value объект, соответствующий одной строке отчета
 * Creation date: (11.08.2004 14:39:43)
 * @param rs1 java.sql.ResultSet
 * @param rs2 java.sql.ResultSet
 * @param rs3 java.sql.ResultSet
 * @exception java.lang.Exception The exception description.
 */
public ReportFreqHistoryValue constructReportLine(ResultSet rs) throws java.lang.Exception {
	ReportFreqHistoryValue reportLine = new ReportFreqHistoryValue();
	reportLine.setDocname(rs.getString("docname"));
	reportLine.setBlanknumber(rs.getString("blanknumber"));
	reportLine.setComment(rs.getString("comment"));
	reportLine.setDocdate(rs.getDate("docdate"));
	reportLine.setExpiredate(rs.getDate("expiredate"));
	return reportLine;
}
public String getPreparationalReportSql() {
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT ed.sitedoc, et.ettypename docname, sd.blanknumber blanknumber, sd.blankdate docdate, sd.expiredate expiredate, sd.comment comment ");
	sb.append("FROM etapdocs ed, sitedocs sd, etaptype et, freqpermissions fp ");
	sb.append("WHERE ed.sitedoc = sd.sitedoc AND et.etaptypeid = ed.etaptypeid ");
	sb.append("AND ed.freqpermid = fp.freqpermid AND fp.filenumber = ? ");
	sb.append("ORDER BY docdate ASC ");
System.out.println("GetFreqHistoryReport:SQL = " + sb.toString());
	return sb.toString();
}
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws Exception {
	if(null == finderForm)
		return null;
	int filenumber = finderForm.getFilenumber();
	ReportFreqHistoryValue reportPart = null;
	LinkedList reportList = new LinkedList();
	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet resultSet = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(this.getPreparationalReportSql());
		prepstatement.setInt(1, filenumber);
		resultSet = prepstatement.executeQuery();
		while(resultSet.next()) {
			reportPart = this.constructReportLine(resultSet);
			reportList.add(reportPart);
		}
	} catch(Exception e) {
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		throw new Exception();
	} finally {
		try { resultSet.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
		try { prepstatement.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
		try { connection.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
	}
	//if(reportList.size() == 0) {
		//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report.haveplan.notfound"));
		//throw new Exception();
	//}
	return reportList;
}
}
