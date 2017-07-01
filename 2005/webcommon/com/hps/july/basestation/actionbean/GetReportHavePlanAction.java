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
public class GetReportHavePlanAction extends GetReportAction {
/**
 * Конструирует value объект, соответствующий одной строке отчета
 * Creation date: (11.08.2004 14:39:43)
 * @param rs1 java.sql.ResultSet
 * @param rs2 java.sql.ResultSet
 * @param rs3 java.sql.ResultSet
 * @exception java.lang.Exception The exception description.
 */
public ReportHavePlanValue constructReportLine(Object[] params) throws java.lang.Exception {
	if(params == null)
		return null;
	if((params[0] == null) || (params[1] == null))
		return null;
	ResultSet rs = (ResultSet)params[0];
	int numberinfile = ((Integer)params[1]).intValue();
	String hopsname = (String)params[2];
	ReportHavePlanValue reportLine = new ReportHavePlanValue();
	reportLine.setNumberinfile(numberinfile);
	reportLine.setHopsname(hopsname);
	reportLine.setGsmid1(rs.getInt("gsmid1"));
	reportLine.setName1(rs.getString("name1"));
	reportLine.setAddress1(rs.getString("address1"));
	reportLine.setLinktogosnet_lat1(rs.getString("linktogosnet_lat1"));
	reportLine.setLinktogosnet_lon1(rs.getString("linktogosnet_lon1"));
	reportLine.setHaveplan1(rs.getString("haveplan1"));
	if(rs.getInt("waymap1") > 0) {
		reportLine.setWaymap1("label.waymap.ya");
	} else {
		reportLine.setWaymap1("label.waymap.no");
	}
	reportLine.setGsmid2(rs.getInt("gsmid2"));
	reportLine.setName2(rs.getString("name2"));
	reportLine.setAddress2(rs.getString("address2"));
	reportLine.setLinktogosnet_lat2(rs.getString("linktogosnet_lat2"));
	reportLine.setLinktogosnet_lon2(rs.getString("linktogosnet_lon2"));
	reportLine.setHaveplan2(rs.getString("haveplan2"));
	if(rs.getInt("waymap2") > 0) {
		reportLine.setWaymap2("label.waymap.ya");
	} else {
		reportLine.setWaymap2("label.waymap.no");
	}
	return reportLine;
}
/**
 * получение финального sql, который дает все остальные данные (кроме номера пролета в файле)
 * Creation date: (11.08.2004 15:08:05)
 * @return java.lang.String
 */
public String getFinalReportSql() {
	StringBuffer sqlbuffer = new StringBuffer("select t3.name as name1,	t3.address as address1, t2.gsmid as gsmid1, ");
	sqlbuffer.append("t2.linktogosnet_lat as linktogosnet_lat1, t2.linktogosnet_lon as linktogosnet_lon1, t2.haveplan as haveplan1, ");
	sqlbuffer.append("(SELECT count(sd.sitedoc) FROM sitedocs2splace s2s, sitedocs sd WHERE s2s.storageplace = t2.storageplace AND s2s.sitedoc = sd.sitedoc AND sd.sitedoctype = (SELECT intvalue FROM namedvalues WHERE id = 'WayMapDocType')) waymap1, ");
	sqlbuffer.append("t6.name as name2, t6.address as address2, t5.gsmid as gsmid2, ");
	sqlbuffer.append("t5.linktogosnet_lat as linktogosnet_lat2, t5.linktogosnet_lon as linktogosnet_lon2, t5.haveplan as haveplan2, ");
	sqlbuffer.append("(SELECT count(sd.sitedoc) FROM sitedocs2splace s2s, sitedocs sd WHERE s2s.storageplace = t5.storageplace AND s2s.sitedoc = sd.sitedoc AND sd.sitedoctype = (SELECT intvalue FROM namedvalues WHERE id = 'WayMapDocType')) waymap2 ");	
	sqlbuffer.append("from equipment t1, positions t2, storageplaces t3, equipment t4, positions t5, storageplaces t6 ");
	sqlbuffer.append("where (t1.equipment=? and t2.storageplace=t1.position and t3.storageplace=t1.position) and ");
	sqlbuffer.append("(t4.equipment=? and t5.storageplace=t4.position and t6.storageplace=t4.position) ");
	sqlbuffer.append("order by gsmid1");
	//System.out.println("SQL2 = " + sqlbuffer.toString());
	return sqlbuffer.toString();
}
/**
 * получение подготовительсного sql, который дает номер пролета в файле и данные, 
 * необходимые для второго запроса
 * Creation date: (11.08.2004 15:08:42)
 * @return java.lang.String
 */
public String getPreparationalReportSql() {
	StringBuffer sqlbuffer = new StringBuffer("select  t2.numberinfile, t3.equipmentid_enda, ");
	sqlbuffer.append("t3.equipmentid_endb, t4.hopsname ");
	sqlbuffer.append("from freqpermissions t1, perm2hops t2, hops t3, hopslabel t4 ");
	sqlbuffer.append("where t1.filenumber=? ");
	sqlbuffer.append("and t2.freqpermid=t1.freqpermid and t3.hopsid=t2.hopsid and t4.hopsid=t3.hopsid ");
	sqlbuffer.append("order by numberinfile");
	//System.out.println("SQL1 = " + sqlbuffer.toString());
	return sqlbuffer.toString();
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
	ReportHavePlanValue reportPart = null;
	LinkedList reportList = new LinkedList();
	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(this.getPreparationalReportSql());
		prepstatement.setInt(1, filenumber);
		resultSet1 = prepstatement.executeQuery();
		while(resultSet1.next()) {
			int numberinfile = resultSet1.getInt("numberinfile");
			String hopsname = resultSet1.getString("hopsname");
			int equipmentid_enda = resultSet1.getInt("equipmentid_enda");
			int equipmentid_endb = resultSet1.getInt("equipmentid_endb");
			prepstatement = connection.prepareStatement(this.getFinalReportSql());
			prepstatement.setInt(1, equipmentid_enda);
			prepstatement.setInt(2, equipmentid_endb);
			resultSet2 = prepstatement.executeQuery();
			while(resultSet2.next()) {
				Object params[] = new Object[] {resultSet2, new Integer(numberinfile), hopsname};
				reportPart = this.constructReportLine(params);
				reportList.add(reportPart);
			}
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
}
