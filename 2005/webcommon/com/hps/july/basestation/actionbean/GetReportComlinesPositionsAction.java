package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportComlinesPositionsValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
/**
 * Action для получения отчета "история файла".
 */
public class GetReportComlinesPositionsAction extends GetReportAction {
public ReportComlinesPositionsValue constructReportLine(ResultSet rs) throws java.lang.Exception {
	ReportComlinesPositionsValue reportLine = new ReportComlinesPositionsValue();
	
	reportLine.setFilenumber(rs.getString("filenumber"));
	reportLine.setNumberinfile(rs.getString("numberinfile"));
	
	reportLine.setPaid(new Integer(rs.getInt("posaid")));
	if(rs.wasNull()) { reportLine.setPaid(null); }
	reportLine.setPaname(rs.getString("posaname"));
	reportLine.setPaadress(rs.getString("paaddress"));
	reportLine.setPalat(rs.getBigDecimal("palat"));
	reportLine.setPalong(rs.getBigDecimal("palong"));
	reportLine.setPaorderno(rs.getString("paorderno"));
	if(rs.wasNull()) { reportLine.setPaorderno(null); }
	reportLine.setPahaveplan(rs.getString("pahaveplan"));
	if(rs.wasNull()) { reportLine.setPahaveplan(null); }
	
	reportLine.setPbid(new Integer(rs.getInt("posbid")));
	if(rs.wasNull()) { reportLine.setPbid(null); }
	reportLine.setPbname(rs.getString("posbname"));
	reportLine.setPbadress(rs.getString("pbaddress"));
	reportLine.setPblat(rs.getBigDecimal("pblat"));
	reportLine.setPblong(rs.getBigDecimal("pblong"));
	reportLine.setPborderno(rs.getString("pborderno"));
	if(rs.wasNull()) { reportLine.setPborderno(null); }
	reportLine.setPbhaveplan(rs.getString("pbhaveplan"));
	if(rs.wasNull()) { reportLine.setPbhaveplan(null); }
	return reportLine;
}
public String getPreparationalReportSql() {
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT fp.filenumber, p2h.numberinfile, ");
	sb.append("pa.gsmid posaid, TRIM(sppa.name) posaname, sppa.address paaddress, pa.latitude palat, pa.longitude palong, pa.orderno paorderno, pa.haveplan pahaveplan, ");
	sb.append("pb.gsmid posbid, TRIM(sppb.name) posbname, sppb.address pbaddress, pb.latitude pblat, pb.longitude pblong, pb.orderno pborderno, pb.haveplan pbhaveplan ");
	sb.append("FROM perm2hops p2h, freqpermissions fp, hops h, equipment ea, equipment eb, storageplaces sppa, storageplaces sppb, positions pa, positions pb ");
	sb.append("WHERE p2h.freqpermid = fp.freqpermid AND h.hopsid = p2h.hopsid AND h.hopstype = 'R' ");
	sb.append("AND h.equipmentid_enda = ea.equipment AND ea.position = pa.storageplace AND pa.storageplace = sppa.storageplace ");
	sb.append("AND h.equipmentid_endb = eb.equipment AND eb.position = pb.storageplace AND pb.storageplace = sppb.storageplace ");
	sb.append("AND fp.filenumber = ? ");
	return sb.toString();
}
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws Exception {
	if(null == finderForm) {
		return null;
	}
	int filenumber = finderForm.getFilenumber();
	ReportComlinesPositionsValue reportPart = null;
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
		prepstatement.close();
		connection.close();
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
