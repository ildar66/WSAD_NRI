package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportRRLListValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;

/**
 * Action для получения отчета о наличии "выкопировок".
 */
public class GetReportRRLListAction extends GetReportAction {
/**
 * Конструирует value объект, соответствующий одной строке отчета
 * Creation date: (11.08.2004 14:39:43)
 * @param rs1 java.sql.ResultSet
 * @param rs2 java.sql.ResultSet
 * @param rs3 java.sql.ResultSet
 * @exception java.lang.Exception The exception description.
 */
public ReportRRLListValue constructReportLine(ResultSet rs)
	throws java.lang.Exception
{
	ReportRRLListValue reportLine = new ReportRRLListValue();
	reportLine.setPosAgsmid(rs.getString("posida"));
	reportLine.setPosAname(rs.getString("posnamea"));
	reportLine.setPosBgsmid(rs.getString("posidb"));
	reportLine.setPosBname(rs.getString("posnameb"));
	reportLine.setResource(rs.getString("rrlresource"));
	reportLine.setEtap4n(rs.getString("etap4n"));
	reportLine.setEtap13n(rs.getString("etap13n"));
	reportLine.setEtap15n(rs.getString("etap15n"));
	reportLine.setEtap16na(rs.getString("etap16na"));
	reportLine.setEtap16da(rs.getDate("etap16da"));
	reportLine.setEtap16nb(rs.getString("etap16nb"));
	reportLine.setEtap16db(rs.getDate("etap16db"));
	return reportLine;
}
public String getPreparationalReportSql() {
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT pa.gsmid posida, pb.gsmid posidb, TRIM(spa.name) posnamea, TRIM(spb.name) posnameb, TRIM(clr.model) rrlresource, ");
	sb.append("(SELECT TRIM(blanknumber) FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv WHERE sd.sitedoc = ed.sitedoc AND ed.etaptypeid = 4 AND ed.freqpermid = fp.freqpermid AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.etaptypeid = ed.etaptypeid AND edd.freqpermid = fp.freqpermid) )) etap4n, ");
	sb.append("(SELECT TRIM(blanknumber) FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv WHERE sd.sitedoc = ed.sitedoc AND ed.etaptypeid = 13 AND ed.freqpermid = fp.freqpermid AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.etaptypeid = ed.etaptypeid AND edd.freqpermid = fp.freqpermid) )) etap13n, ");
	sb.append("(SELECT TRIM(blanknumber) FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv WHERE sd.sitedoc = ed.sitedoc AND ed.etaptypeid = 15 AND ed.freqpermid = fp.freqpermid AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.etaptypeid = ed.etaptypeid AND edd.freqpermid = fp.freqpermid) )) etap15n, ");
	sb.append("(SELECT TRIM(blanknumber) FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv  WHERE sd.sitedoc = ed.sitedoc AND ed.equiplink = 'A'  AND ed.etaptypeid = 16 AND ed.freqpermid = fp.freqpermid AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.equiplink = 'A' AND edd.etaptypeid = ed.etaptypeid AND edd.freqpermid = ed.freqpermid))) etap16na, ");
	sb.append("(SELECT blankdate FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv  WHERE sd.sitedoc = ed.sitedoc AND ed.equiplink = 'A'  AND ed.etaptypeid = 16 AND ed.freqpermid = fp.freqpermid AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.equiplink = 'A' AND edd.etaptypeid = ed.etaptypeid AND edd.freqpermid = ed.freqpermid))) etap16da, ");
	sb.append("(SELECT TRIM(blanknumber) FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv  WHERE sd.sitedoc = ed.sitedoc AND ed.equiplink = 'B'  AND ed.etaptypeid = 16 AND ed.freqpermid = fp.freqpermid AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.equiplink = 'B' AND edd.etaptypeid = ed.etaptypeid AND edd.freqpermid = ed.freqpermid))) etap16nb, ");
	sb.append("(SELECT blankdate FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv  WHERE sd.sitedoc = ed.sitedoc AND ed.equiplink = 'B'  AND ed.etaptypeid = 16 AND ed.freqpermid = fp.freqpermid AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.equiplink = 'B' AND edd.etaptypeid = ed.etaptypeid AND edd.freqpermid = ed.freqpermid))) etap16db ");
	sb.append("FROM freqpermissions fp, perm2hops p2h, hops h, rrl_hops2 h2, equipment eqea, equipment eqeb, positions pa, positions pb, storageplaces spa, storageplaces spb, outer resources clr ");
	sb.append("WHERE p2h.freqpermid = fp.freqpermid AND h.hopsid = p2h.hopsid AND h.hopsid = h2.hopsid AND h2.resource_doc = clr.resource ");
	sb.append("AND eqea.equipment = h.equipmentid_enda AND eqeb.equipment = h.equipmentid_endb AND eqea.position = pa.storageplace AND eqeb.position = pb.storageplace ");
	sb.append("AND spa.storageplace = pa.storageplace AND spb.storageplace = pb.storageplace ");
	sb.append("AND fp.filenumber = ? ");
System.out.println("GetRRLList:SQL = " + sb.toString());
	return sb.toString();
}
/**
 * создание отчета в виде коллекции value объектов(линий будущей таблицы)
 * Creation date: (11.08.2004 10:46:18)
 * @return java.util.LinkedList
 */
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws Exception {
	if(null == finderForm)
		return null;
	int filenumber = finderForm.getFilenumber();
	ReportRRLListValue reportPart = null;
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
