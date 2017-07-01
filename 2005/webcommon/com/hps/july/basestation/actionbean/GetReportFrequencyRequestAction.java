package com.hps.july.basestation.actionbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.valueobject.ReportFrequencyRequestValue;
import com.hps.july.basestation.formbean.ReportFinderForm;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.NamedValueAccessBean;
/**
 * Action для получения документа "заявка на частоты".
 */
public class GetReportFrequencyRequestAction extends GetReportAction {
	private java.util.Hashtable regionCol = new java.util.Hashtable(); // названия регионов для последующего формирования "названия региона"
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 12:06:32)
 * @param params java.lang.Object[]
 * @exception java.lang.Exception The exception description.
 */
public ReportFrequencyRequestValue addReportLineParams(Object[] params) throws java.lang.Exception {
	if(params == null)
		return null;
	if((params[0] == null) || (params[1] == null))
		return null;
	ReportFrequencyRequestValue reportPart = (ReportFrequencyRequestValue)params[0];
	ResultSet rs = (ResultSet)params[1];
	reportPart.setName1(rs.getString("name1"));
	reportPart.setName2(rs.getString("name2"));
	reportPart.setAddress1(rs.getString("address1"));
	reportPart.setAddress2(rs.getString("address2"));
	reportPart.setDocaddress_a(rs.getString("docaddress1"));
	reportPart.setDocaddress_b(rs.getString("docaddress2"));
	reportPart.setGsmid1(rs.getInt("gsmid1"));
	reportPart.setGsmid2(rs.getInt("gsmid2"));
	reportPart.setLinktogosnet_lat1(rs.getString("linktogosnet_lat1"));
	reportPart.setLinktogosnet_lat2(rs.getString("linktogosnet_lat2"));
	reportPart.setLinktogosnet_lon1(rs.getString("linktogosnet_lon1"));
	reportPart.setLinktogosnet_lon2(rs.getString("linktogosnet_lon2"));
	java.math.BigDecimal latitude1 = rs.getBigDecimal("latitude1");
	java.math.BigDecimal longitude1 = rs.getBigDecimal("longitude1");
	java.math.BigDecimal latitude2 = rs.getBigDecimal("latitude2");
	java.math.BigDecimal longitude2 = rs.getBigDecimal("longitude2");
	reportPart.setDistance(latitude1, longitude1, latitude2, longitude2);
	int regionid1 = rs.getInt("regionid1");
	String regionname1 = rs.getString("regname1");
	regionCol.put(new Integer(regionid1), regionname1.trim());
	//reportPart.setRegionObj1(new com.hps.july.basestation.valueobject.RegionObject(regionid1, -1, regionname1));
	int regionid2 = rs.getInt("regionid2");
	String regionname2 = rs.getString("regname2");
	regionCol.put(new Integer(regionid2), regionname2.trim());
	//reportPart.setRegionObj2(new com.hps.july.basestation.valueobject.RegionObject(regionid2, -1, regionname2));
	return reportPart;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 17:04:02)
 * @return com.hps.july.basestation.beans.ReportFrequencyRequestValue
 * @param params java.lang.Object[]
 * @exception java.lang.Exception The exception description.
 */
public ReportFrequencyRequestValue constructReportLine(Object[] params) throws java.lang.Exception {
	if(params == null)
		return null;
	if(params[0] == null) 
		return null;
	ReportFrequencyRequestValue reportPart = new ReportFrequencyRequestValue();
	ResultSet rs = (ResultSet)params[0];
	reportPart.setAntdiam_a(rs.getBigDecimal("diam_a_doc"));
	reportPart.setAntdiam_b(rs.getBigDecimal("diam_b_doc"));
	reportPart.setSpeed(rs.getString("speed_doc"));
	reportPart.setAzimuth_a(new java.math.BigDecimal(rs.getFloat("azimuthab_doc")));
	reportPart.setAzimuth_b(new java.math.BigDecimal(rs.getFloat("azimuthba_doc")));
	reportPart.setHeight_a(new java.math.BigDecimal(rs.getFloat("height_a_doc")));
	reportPart.setHeight_b(new java.math.BigDecimal(rs.getFloat("height_b_doc")));
	reportPart.setFrequency_a(new java.math.BigDecimal(rs.getFloat("frequency_a_doc")));
	reportPart.setFrequency_b(new java.math.BigDecimal(rs.getFloat("frequency_b_doc")));
	reportPart.setPower(new java.math.BigDecimal(rs.getFloat("power_doc")));
	reportPart.setModel(rs.getString("model"));
	System.out.println("model = " + reportPart.getModel());
	reportPart.setAmplifkoeff_a(rs.getBigDecimal("amplifkoeff_a"));
	reportPart.setAmplifkoeff_b(rs.getBigDecimal("amplifkoeff_b"));
	reportPart.setDnangleh_a(rs.getBigDecimal("dnangleh_a"));
	reportPart.setDnangleh_b(rs.getBigDecimal("dnangleh_b"));
	reportPart.setDnanglew_a(rs.getBigDecimal("dnanglew_a"));
	reportPart.setDnanglew_b(rs.getBigDecimal("dnanglew_b"));
	reportPart.setRadiationclass_a(rs.getString("radiationclass_a"));
	reportPart.setRadiationclass_b(rs.getString("radiationclass_b"));
	return reportPart;
}
/**
 * Insert the method's description here.
 * Creation date: (17.08.2004 10:40:01)
 * @return java.lang.String
 */
public String getFirstSql() {
//	StringBuffer sql = new StringBuffer("select t3.equipmentid_enda, t3.equipmentid_endb, t4.diam_a_doc, ");
	StringBuffer sql = new StringBuffer("select t3.equipmentid_enda, t3.equipmentid_endb, t8.antdiam as diam_a_doc, ");
	sql.append("t9.antdiam as diam_b_doc, t4.speed_doc, t4.azimuthab_doc, t4.azimuthba_doc, t4.height_a_doc, ");
	sql.append("t4.height_b_doc, t4.frequency_a_doc, t4.frequency_b_doc, t4.power_doc, t5.model, ");
	sql.append("t6.radiationclass as radiationclass_a, t7.radiationclass as radiationclass_b, ");
	sql.append("t8.amplifkoeff as amplifkoeff_a, t9.amplifkoeff as amplifkoeff_b, t8.dnangleh as dnangleh_a, ");
	sql.append("t9.dnangleh as dnangleh_b, t8.dnanglew as dnanglew_a, t9.dnanglew as dnanglew_b ");
	sql.append("from freqpermissions t1, perm2hops t2, hops t3, rrl_hops2 t4, outer resources t5, ");
	sql.append("outer rrlspeedparams t6, outer rrlspeedparams t7, outer rrlantparams t8,outer rrlantparams t9 ");
	sql.append("where t1.filenumber=? and t2.freqpermid=t1.freqpermid and t3.hopsid=t2.hopsid and ");
	sql.append("t4.hopsid=t2.hopsid and t5.resource=t4.resource_doc and (t6.resource=t4.resource_doc and ");
	sql.append("t6.streamspeed=t4.speed_doc) and (t8.resource=t4.resource_doc and t8.antdiam=t4.diam_a_doc) and ");
	sql.append("(t7.resource=t4.resource_doc and t7.streamspeed=t4.speed_doc) and (t9.resource=t4.resource_doc and ");
	sql.append("t9.antdiam=t4.diam_b_doc) and t3.hopstype='R'");
	return sql.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2004 17:02:36)
 * @return java.util.LinkedList
 * @param finderForm com.hps.july.basestation.formbean.ReportFinderForm
 * @param errors org.apache.struts.action.ActionErrors
 * @exception java.lang.Exception The exception description.
 */
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws java.lang.Exception {
	regionCol.clear();
	if(null == finderForm)
		return null;
	int filenumber = finderForm.getFilenumber();
	//System.out.println("filenumber in showhaveplan action = " + filenumber);
	ReportFrequencyRequestValue reportPart = null;
	LinkedList reportList = new LinkedList();
	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(this.getFirstSql());
		prepstatement.setInt(1, filenumber);
		resultSet1 = prepstatement.executeQuery();
		while(resultSet1.next()) {
			reportPart = constructReportLine(new Object[] {resultSet1});
			prepstatement = connection.prepareStatement(this.getSecondSql());
			prepstatement.setInt(1, resultSet1.getInt("equipmentid_enda"));
			prepstatement.setInt(2, resultSet1.getInt("equipmentid_endb"));
			resultSet2 = prepstatement.executeQuery();
			while(resultSet2.next()) {
				reportPart = addReportLineParams(new Object[] {reportPart, resultSet2});
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
//
	//Set set = regionCol.keySet();
	//Iterator it = set.iterator();
	//while(it.hasNext()) {
		//System.out.println(" !!! " + regionCol.get(it.next()));
	//}
//

	
	return reportList;
}
/**
 * Insert the method's description here.
 * Creation date: (17.08.2004 10:40:33)
 * @return java.lang.String
 */
public String getSecondSql() {
	StringBuffer sql = new StringBuffer("select t3.name as name1, t3.address as address1, t2.gsmid as gsmid1, ");
	sql.append("t6.name as name2, t6.address as address2, t5.gsmid as gsmid2, t2.linktogosnet_lat as linktogosnet_lat1, ");
	sql.append("t2.linktogosnet_lon as linktogosnet_lon1, t5.linktogosnet_lat as linktogosnet_lat2, ");
	sql.append("t5.linktogosnet_lon as linktogosnet_lon2, ");
	sql.append("t2.latitude as latitude1, t2.longitude as longitude1, ");
	sql.append("t5.latitude as latitude2, t5.longitude as longitude2, ");
	sql.append("t7.regionid as regionid1, t7.regname as regname1, ");
	sql.append("t8.regionid as regionid2, t8.regname as regname2, ");
	sql.append("t2.docaddress as docaddress1, t5.docaddress as docaddress2 ");
	sql.append("from equipment t1, positions t2, ");
	sql.append("storageplaces t3, equipment t4, positions t5, storageplaces t6, ");
	sql.append("outer regions t7, outer regions t8 ");
	sql.append("where (t1.equipment=? and t2.storageplace=t1.position and t3.storageplace=t1.position ");
	sql.append("and t2.regionid=t7.regionid) and ");
	sql.append("(t4.equipment=? and t5.storageplace=t4.position and t6.storageplace=t4.position ");
	sql.append("and t5.regionid=t8.regionid)");
	return sql.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 14:12:03)
 * @return java.lang.String
 */
public String getUnderlineName() {
	return "ReportFrequencyRequestUnderlineName";
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 14:11:43)
 * @return java.lang.String
 */
public String getUnderlineTitle() {
	return "ReportFrequencyRequestUnderlineTitle";
}
/**
 * 
 * @param request javax.servlet.http.HttpServletRequest
 */
public void setRegionString(HttpServletRequest request) {
	StringBuffer regionBuf = new StringBuffer();
	Set regionids = regionCol.keySet();
	Iterator it = regionids.iterator();
	while(it.hasNext()) {
		String regname = (String)(regionCol.get(it.next()));
		regionBuf.append(regname + ", ");
	}
	String finalString = regionBuf.toString();
	if(regionBuf.charAt(regionBuf.length() - 2) == ',') {
		finalString = regionBuf.substring(0, regionBuf.length() - 2);
	}
	request.setAttribute("regionstr", finalString);
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2004 14:08:36)
 * @exception java.lang.Exception The exception description.
 */
public void setUnderlineParamsToRequest(HttpServletRequest request) {
	NamedValueAccessBean nab = new NamedValueAccessBean();
	try{
		nab.setInitKey_id(getUnderlineTitle());
		nab.refreshCopyHelper();
		request.setAttribute("underlinetitle", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("underlinetitle", "");
		System.out.println("System constant 'ReportFrequencyRequestUnderlineTitle is missing!");
	}
	try {
		nab = new NamedValueAccessBean();
		nab.setInitKey_id(getUnderlineName());
		nab.refreshCopyHelper();
		request.setAttribute("underlinename", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("underlinename", "");
		System.out.println("System constant 'ReportFrequencyRequestUnderlineName is missing!");
	}
}
}
