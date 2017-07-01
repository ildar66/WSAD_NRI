package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportComlinesValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
/**
 * Action для получения отчета "история файла".
 */
public class GetReportComlinesAction extends GetReportAction {
public ReportComlinesValue constructReportLine(ResultSet rs) throws java.lang.Exception {
	ReportComlinesValue reportLine = new ReportComlinesValue();
	reportLine.setFilenumber(rs.getString("filenumber"));
	reportLine.setNumberinfile(rs.getString("numberinfile"));
	reportLine.setPosaid(new Integer(rs.getInt("posaid")));
	if(rs.wasNull()) { reportLine.setPosaid(null); }
	reportLine.setPosaname(rs.getString("posaname"));
	reportLine.setPosbid(new Integer(rs.getInt("posbid")));
	if(rs.wasNull()) { reportLine.setPosbid(null); }
	reportLine.setPosbname(rs.getString("posbname"));
	reportLine.setResmodel(rs.getString("resmodel"));
	reportLine.setHeight_a(rs.getBigDecimal("height_a_doc"));
	reportLine.setHeight_b(rs.getBigDecimal("height_b_doc"));
	reportLine.setPalat(rs.getBigDecimal("palat"));
	reportLine.setPalong(rs.getBigDecimal("palong"));
	reportLine.setPblat(rs.getBigDecimal("pblat"));
	reportLine.setPblong(rs.getBigDecimal("pblong"));
	reportLine.setPower(rs.getBigDecimal("power_doc"));
	reportLine.setSpeed(rs.getString("speed_doc"));
	reportLine.setDiam_a(rs.getBigDecimal("diam_a_doc"));
	reportLine.setDiam_b(rs.getBigDecimal("diam_b_doc"));
	reportLine.setFrequency_a(rs.getBigDecimal("frequency_a_doc"));
	reportLine.setFrequency_b(rs.getBigDecimal("frequency_b_doc"));
	return reportLine;
}
public String getPreparationalReportSql() {
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT fp.filenumber, p2h.numberinfile, ");
	sb.append("pa.gsmid posaid, TRIM(sppa.name) posaname, pb.gsmid posbid, TRIM(sppb.name) posbname, TRIM(r.model) resmodel, ");
	sb.append("rh2.height_a_doc, rh2.height_b_doc, ");
	sb.append("pa.latitude palat, pa.longitude palong, pb.latitude pblat, pb.longitude pblong, ");
	sb.append("rh2.power_doc, rh2.speed_doc, rh2.diam_a_doc, rh2.diam_b_doc, rh2.frequency_a_doc, rh2.frequency_b_doc ");
	sb.append("FROM perm2hops p2h, freqpermissions fp, hops h, rrl_hops2 rh2, equipment ea, equipment eb, storageplaces sppa, storageplaces sppb, positions pa, positions pb, ");
	sb.append("outer resources r ");
	sb.append("WHERE p2h.freqpermid = fp.freqpermid AND h.hopsid = p2h.hopsid AND rh2.hopsid = h.hopsid AND h.hopstype = 'R' ");
	sb.append("AND h.equipmentid_enda = ea.equipment AND ea.position = pa.storageplace AND pa.storageplace = sppa.storageplace ");
	sb.append("AND h.equipmentid_endb = eb.equipment AND eb.position = pb.storageplace AND pb.storageplace = sppb.storageplace ");
	sb.append("AND rh2.resource_doc = r.resource ");
	sb.append("AND fp.filenumber = ? ");
		
System.out.println("GetFreqHistoryReport:SQL = " + sb.toString());
	return sb.toString();
}
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws Exception {
	if(null == finderForm) {
		return null;
	}
	int filenumber = finderForm.getFilenumber();
	ReportComlinesValue reportPart = null;
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
	return reportList;
}
}
