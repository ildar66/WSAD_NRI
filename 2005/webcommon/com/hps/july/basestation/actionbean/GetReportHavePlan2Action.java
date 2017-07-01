package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportHavePlanValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
/**
 * Action для получения отчета о наличии "выкопировок".
 */
public class GetReportHavePlan2Action
	extends GetReportAction
{
/**
 * Конструирует value объект, соответствующий одной строке отчета
 * Creation date: (11.08.2004 14:39:43)
 * @param rs1 java.sql.ResultSet
 * @param rs2 java.sql.ResultSet
 * @param rs3 java.sql.ResultSet
 * @exception java.lang.Exception The exception description.
 */
public ReportHavePlanValue constructReportLine(ResultSet rs)
	throws java.lang.Exception
{
	ReportHavePlanValue reportLine = new ReportHavePlanValue();
	reportLine.setGsmid1(rs.getInt("gsmid"));
	reportLine.setName1(rs.getString("name"));
	reportLine.setAddress1(rs.getString("address"));
	reportLine.setLinktogosnet_lat1(rs.getString("linktogosnet_lat"));
	reportLine.setLinktogosnet_lon1(rs.getString("linktogosnet_lon"));
	reportLine.setHaveplan1(rs.getString("haveplan"));
	if(rs.getInt("waymap") > 0) {
		reportLine.setWaymap1("есть");
	} else {
		String s = getRSString(rs,"workresp");
		String m = getRSString(rs,"workrespmobile");
		if(s != null && !"".equals(s)) {
			reportLine.setWaymap1(s+"<br>Мобильный:"+m);
		}
	}
	return reportLine;
}
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws Exception {
	if(null == finderForm)
		return null;
	int filenumber = finderForm.getFilenumber();
	ReportHavePlanValue reportPart = null;
	LinkedList reportList = new LinkedList();
	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(this.getReportSql());
		prepstatement.setInt(1, filenumber);
		resultSet1 = prepstatement.executeQuery();
		while(resultSet1.next()) {
			reportPart = this.constructReportLine(resultSet1);
			reportList.add(reportPart);
		}
	} catch(Exception e) {
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		throw new Exception();
	} finally {
		try { resultSet1.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
		try { resultSet2.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
		try { prepstatement.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
		try { connection.close(); } catch(NullPointerException npe) {} catch(Exception e) { e.printStackTrace(); }
	}
	return reportList;
}
/**
 * получение подготовительсного sql, который дает номер пролета в файле и данные, 
 * необходимые для второго запроса
 * Creation date: (11.08.2004 15:08:42)
 * @return java.lang.String
 */
public String getReportSql() {
	StringBuffer sqlbuffer = new StringBuffer("SELECT DISTINCT sp.name, sp.address, p.gsmid, p.linktogosnet_lat, p.linktogosnet_lon, p.haveplan, ");
	sqlbuffer.append("(SELECT count(sd.sitedoc) FROM sitedocs2splace s2s, sitedocs sd WHERE s2s.storageplace = p.storageplace AND s2s.sitedoc = sd.sitedoc AND sd.sitedoctype = (SELECT intvalue FROM namedvalues WHERE id = 'WayMapDocType')) waymap, ");
	sqlbuffer.append("(SELECT TRIM(p.lastname) || ' ' || SUBSTR(p.firstname,1,1) || '. ' || SUBSTR(p.middlename,1,1) || '.' FROM workresponsibility wr, workers w, people p WHERE w.man = p.man AND wr.worker = w.worker AND wr.idresponsibility = (SELECT intvalue FROM namedvalues WHERE id = 'RESPONSIBLE_EXPL') AND storageplace = sp.storageplace) workresp, ");
	sqlbuffer.append("(SELECT w.mobilephone FROM workresponsibility wr, workers w WHERE wr.worker = w.worker AND wr.idresponsibility = (SELECT intvalue FROM namedvalues WHERE id = 'RESPONSIBLE_EXPL') AND wr.storageplace = sp.storageplace) workrespmobile ");
	sqlbuffer.append("FROM positions p, storageplaces sp, freqpermissions fp, perm2hops p2h, hops h, equipment e ");
	sqlbuffer.append("WHERE fp.filenumber = ? AND p2h.freqpermid=fp.freqpermid AND h.hopsid=p2h.hopsid AND (e.equipment = h.equipmentid_endb OR e.equipment = h.equipmentid_enda) ");
	sqlbuffer.append("AND p.storageplace = e.position AND sp.storageplace=e.position ");
	sqlbuffer.append("ORDER BY p.gsmid ASC ");
	//System.out.println("SQL1 = " + sqlbuffer.toString());
	return sqlbuffer.toString();
}
public String getRSString(ResultSet rs, String field) {
	String s = "";
	try {
		s = rs.getString(field);
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	if(s != null) {
		return s.trim();
	} else {
		return "";
	}
}
}
