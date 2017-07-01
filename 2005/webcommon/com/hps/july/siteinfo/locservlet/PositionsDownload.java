package com.hps.july.siteinfo.locservlet;

import com.hps.july.trailcom.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.util.*;
import java.lang.reflect.*;
import org.apache.struts.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionObject;
import com.hps.july.siteinfo.valueobject.SuperRegionObject;

import java.sql.*;
import com.hps.july.siteinfo.valueobject.Position;
import com.hps.july.cdbc.objects.CDBCPositionObject;

/**
 * Сервлет выгружающий список позиций в виде Excel файла
 */
public class PositionsDownload 
	extends javax.servlet.http.HttpServlet
{
	public static final String encoding = "Cp1251";
	public static final java.text.DateFormat df = new java.text.SimpleDateFormat("dd.MM.yyyy");

	static class Resptype {
		public int id;
		public String name;
	}
public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	performTask(request, response);
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	performTask(request, response);
}
public PreparedStatement findPositionsData(Connection con, PositionListForm form, ArrayList resplist, String remoteUser, int mapvar)
	throws Exception
{
System.out.println("RemoteUSER:"+remoteUser);
	if(form == null) {
		return null;
	}
	ArrayList params = new ArrayList();
	boolean isSupregs = !form.getRegionsSelector().isAllSuperregions();
	boolean isRegions = !form.getRegionsSelector().isAllRegions();
	boolean isNetzone = !form.getRegionsSelector().isAllNetzones();
	boolean isAdmin = (form.isAdmin() != null?form.isAdmin().booleanValue():false);
	boolean isWorker = form.getIsWorker() != null?!form.getIsWorker().booleanValue():true;
	int order = form.getFinderMethodOrder();
	int mapdoctype = com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType");
System.out.println("WAY_MAP_DOCTYPE:"+mapdoctype);

	StringBuffer sqlstr = new StringBuffer();
	sqlstr.append("SELECT p.date_beginbuild datebeginbuild, \n");
	sqlstr.append(" p.storageplace, \n");
	sqlstr.append(" p.gsmid, p.dcsid, p.dampsid, TRIM(s.name) name, TRIM(p.dampsname) dampsname, \n");
	sqlstr.append("	TRIM(r.regname) regname, TRIM(s.address) address, TRIM(n.zonecode) zonecode, TRIM(n.name) zonename,  \n");
	sqlstr.append("	p.latitude, p.longitude, \n");
	sqlstr.append(" TRIM(p.details) details, \n");
	// BLOB. @TODO Необходимо учитывать флаг при их выводе.
	if(mapvar != 2) {
		sqlstr.append(" p.contactphones contactphones, p.pathtype pathtype, p.equipmentplaces equipmentplaces, p.engenering engenering, \n");
	} else {
		sqlstr.append(" sdf1.sitedocfilename docfilename, \n");
		
//		sqlstr.append(" (SELECT sdf1.sitedocfilename FROM sitedocfiles sdf1 WHERE sdf1.sitedocfile = (SELECT max(sitedocfile) FROM sitedocs2splace sds, sitedocs sd, sitedocfiles sdf  WHERE  sds.storageplace = p.storageplace AND sd.sitedoc = sds.sitedoc AND sitedoctype = ");
//		sqlstr.append(mapdoctype);
//		sqlstr.append(" AND sdf.sitedoc = sd.sitedoc)) docfilename, ");
	}
	sqlstr.append(" p.accesslistexp, o.organization renterorg, TRIM(o.name) rentername, TRIM(p.rentvolume) rentervolume, p.inaction inaction, \n");
	sqlstr.append(" (SELECT count(hops.hopsid) FROM hops, equipment equ WHERE (hops.equipmentid_enda = equ.equipment OR hops.equipmentid_endb = equ.equipment) AND hops.hopstype = 'R' AND equ.position = p.storageplace) rrlhops, \n");
	sqlstr.append(" (SELECT count(hops.hopsid) FROM hops, equipment equ WHERE (hops.equipmentid_enda = equ.equipment OR hops.equipmentid_endb = equ.equipment) AND hops.hopstype = 'O' AND equ.position = p.storageplace) vothops, \n");
	// Добавляем список ответственных
	for(int i = 0; i < resplist.size(); i++) {
		Resptype t = (Resptype)resplist.get(i);
		sqlstr.append(" respfullname(p.storageplace,");
		sqlstr.append(t.id);
		sqlstr.append(") workresp");
		sqlstr.append(t.id);
		sqlstr.append(", \n");
	}
	if(isAdmin) {
		sqlstr.append("	'Y' srvp, 'Y' rvp, \n");
		sqlstr.append(" 'Y' srvf, 'Y' rvf, \n");
		sqlstr.append(" 'Y' srep, 'Y' rep, \n");
		sqlstr.append(" 'Y' sref, 'Y' ref \n");
	} else {
		sqlstr.append("	sra.viewplan srvp, ra.viewplan rvp, \n");
		sqlstr.append(" sra.viewfact srvf, ra.viewfact rvf, \n");
		sqlstr.append(" sra.editplan srep, ra.editplan rep, \n");
		sqlstr.append(" sra.editfact sref, ra.editfact ref \n");
	}
	sqlstr.append("FROM positions p, storageplaces s, netzones n, Regions r,SuperRegions sr, OUTER organizations o \n");
	if(mapvar == 2) {
		sqlstr.append(" ,OUTER (sitedocfiles sdf1, sitedocs2splace sds, sitedocs sd) \n");
	}
	// Admin cut
	if(!isAdmin) {
		sqlstr.append(" ,OUTER RegionsAccess sra, OUTER RegionsAccess ra, operators op \n");
	}
	// End of amin cut
	sqlstr.append("WHERE \n");
	sqlstr.append("	s.storageplace = p.storageplace \n");
	sqlstr.append("	AND n.netzone = p.netzone \n");
	sqlstr.append("	AND r.regionid = p.regionid \n");
	sqlstr.append("	AND sr.supregid = r.supregid \n");
	sqlstr.append("	AND o.organization = p.renter \n");
	sqlstr.append("	AND p.planstate <> '0' \n");
	if(mapvar == 2) {
		sqlstr.append(" AND sds.storageplace = p.storageplace AND sd.sitedoc = sds.sitedoc AND sitedoctype = ");
		sqlstr.append(mapdoctype);
		sqlstr.append(" AND sdf1.sitedocfile = (SELECT max(sdf.sitedocfile) FROM sitedocfiles sdf WHERE sdf.sitedoc = sd.sitedoc) ");
	}
	// Admin cut
	if(!isAdmin) {
		sqlstr.append(" AND sra.accesstype = 'S' \n");
		sqlstr.append(" AND ra.accesstype = 'R' \n");
		sqlstr.append(" AND sra.supregionid = sr.supregid \n");
		sqlstr.append(" AND ra.regionid = r.regionid \n");
		sqlstr.append(" AND ra.operatorid = op.operator \n");
		sqlstr.append(" AND sra.operatorid = op.operator \n");
		sqlstr.append(" AND ((p.planstate='1' AND (ra.viewplan='Y' OR ra.editplan='Y' OR sra.viewplan='Y' OR sra.editplan='Y' )) OR (p.planstate='2' AND (ra.viewfact='Y' OR ra.editfact='Y' OR sra.viewfact='Y' OR sra.editfact='Y'))) ");
		sqlstr.append(" AND op.loiginid = ? ");
		params.add(remoteUser);
	}
	// End of admin cut

	if (isSupregs && !isRegions) {
		sqlstr.append("AND sr.supregid IN ");
		sqlstr.append(getArrayString(form.getRegionsSelector().getSuperregioncodes()));
	}
    if (isRegions) {
		sqlstr.append("AND p.regionid IN ");
		sqlstr.append(getArrayString(form.getRegionsSelector().getRegioncodes()));
    }
    if (form.getPosstate() != null && !"*".equals(form.getPosstate())) {
		CDBCPositionObject.appendIN(sqlstr,"AND p.posstate ",CDBCPositionObject.getPosstateList(form.getPosstate()));
		sqlstr.append("\n");
    }

    if (isNetzone) {
        sqlstr.append("AND p.netzone IN ");
        sqlstr.append(getArrayString(form.getRegionsSelector().getNetzonecodes()));
    }

    if(form.getSearchBy() != null) {
		if ("F".equals(form.getSearchBy())) { // Все GSM/DCS
			sqlstr.append("AND p.gsmid IS NOT NULL ");
		} else if ("G".equals(form.getSearchBy())) { // Все DAMPS
			sqlstr.append("AND p.dampsid IS NOT NULL ");
		} else if ("H".equals(form.getSearchBy())) { // Позиции без БС
			sqlstr.append("AND p.gsmid IS NULL AND p.dampsid IS NULL ");
		} else if ("B".equals(form.getSearchBy())) { // По № GSM/DCS
			sqlstr.append("AND p.gsmid = ? ");
			params.add(form.getSearchString());
		} else if ("C".equals(form.getSearchBy())) { // По № DAMPS
			sqlstr.append("AND p.dampsid = ? ");
			params.add(form.getSearchString());
		} else if ("D".equals(form.getSearchBy())) { // По названию
			sqlstr.append("AND (UPPER(s.name) MATCHES UPPER(?) OR UPPER(p.dampsname) MATCHES UPPER(?)) ");
			params.add(form.getSearchString());
			params.add(form.getSearchString());
		} else if ("E".equals(form.getSearchBy())) { // По адресу
			sqlstr.append("AND upper(s.address) matches upper(?) ");
			params.add(form.getSearchString());
		} else if ("I".equals(form.getSearchBy())) { // По адресу
			sqlstr.append(" AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1, storageplaces sp1 " +
	        " WHERE ce1.equipment = e1.equipment AND sp1.storageplace = e1.equipment AND upper(sp1.name) matches upper(?)) ");
			params.add(form.getSearchString());
		} else if ("K".equals(form.getSearchBy())) { // По адресу
			sqlstr.append(" AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 " +
	        	" WHERE ce1.equipment = e1.equipment) ");
		} else if ("L".equals(form.getSearchBy())) { // По адресу
			sqlstr.append(" AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 " +
	        " WHERE ce1.equipment = e1.equipment AND ce1.type='R') ");
		} else if ("M".equals(form.getSearchBy())) { // По адресу
			sqlstr.append(" AND p.storageplace IN (SELECT e1.position FROM equipment e1, comequipment ce1 " +
	        " WHERE ce1.equipment = e1.equipment AND ce1.type='O') ");
		} 
	}

	if (Position.RENTER_Specify.equals(form.getRenterSearchType())) {
		sqlstr.append("AND renter = ? ");
		params.add(form.getOrganization());
	} else if (Position.RENTER_NotNull.equals(form.getRenterSearchType())) {
		sqlstr.append("AND renter IS NOT NULL ");
	}

    if (isWorker) {
		sqlstr.append("AND exists (select w.worker from workresponsibility w where s.storageplace=w.storageplace AND w.worker = ?) \n");
		params.add(form.getWorker());
    }
    
	if (!Position.INACTION_All.equals(form.getInaction())) {
		sqlstr.append("AND p.inaction = ? \n");
		params.add(form.getInaction());
	}
    
    //append order by clause
	String orderBy = null;
	switch (order) {
		case 1 :
			orderBy = "p.storageplace ASC";
			break;
		case 2 :
			orderBy = "p.storageplace DESC";
			break;
		case 3 :
			orderBy = "name ASC";
			break;
		case 4 :
			orderBy = "name DESC";
			break;
		case 5 :
			orderBy = "p.gsmid ASC";
			break;
		case 6 :
			orderBy = "p.gsmid DESC";
			break;
		case 7 :
			orderBy = "p.dampsid ASC";
			break;
		case 8 :
			orderBy = "p.dampsid DESC";
			break;
    }
    if(orderBy != null) {
		sqlstr.append(" ORDER BY " + orderBy);
    }
System.out.println("POSITION DOWNLOAD SQL");
System.out.println(sqlstr.toString());
System.out.println();
	PreparedStatement ps = con.prepareStatement(sqlstr.toString());
	// set params
	for(int i = 0; i < params.size(); i++) {
		Object p = params.get(i);
// ??? Надо подумать
		if(p instanceof String) {
			if(p == null) {
				ps.setNull(i+1,Types.VARCHAR);
			} else {
				ps.setString(i+1,(String)p);
			}
		} else
		if(p instanceof Integer) {
			if(p == null) {
				ps.setNull(i+1,Types.INTEGER);
			} else {
				ps.setInt(i+1,((Integer)p).intValue());
			}
		} else {
			if(p == null) {
System.out.println("UNPROCESSED TYPE: NULL ["+i+"]");
			} else {
System.out.println("UNPROCESSED TYPE:"+p.getClass().getName()+" ["+i+"]");
			}
			ps.setNull(i+1,Types.NULL);
		}
	}
	return ps;
}
/**
 * Получаем список ответсвенных типов.
 * Эти типы будут использоватся для составления SQL получения данных по позициям
 */
public ArrayList findResptypes(Connection con) throws java.lang.Exception {
	ArrayList a = new ArrayList();
	Statement st = con.createStatement();
	ResultSet rs = null;
	try {
		rs = st.executeQuery("SELECT idresponsibility, name FROM typeresponsibility WHERE flagprint = 'Y' ORDER BY name");
		while(rs.next()) {
			Resptype rt = new Resptype();
			rt.id = rs.getInt("idresponsibility");
			if(rs.wasNull()) {
				continue;
			}
			rt.name = rs.getString("name");
			a.add(rt);
		}
	} finally {
		if(rs != null) try { rs.close(); } catch(Throwable t) {}
		if(st != null) try { st.close(); } catch(Throwable t) {}
	}
	return a;
}
public static String getArrayString(Object[] params) {
	StringBuffer b = new StringBuffer();
	b.append("(");
    if (params != null && params.length > 0) {
        for (int i = 0; i < params.length; i++) {
	        if(i!=0) { b.append(","); }
	        if(params[i] != null) {
		        b.append(params[i]);
	        } else {
		        b.append("NULL");
	        }
        }
    } else {
        b.append("NULL");
    }
	b.append(") ");
	return b.toString();
}
/**
 * Получает соединение с базой данных
 */
public Connection getConnection()
	throws SQLException
{
	return null;
}
public String getIntAsString(ResultSet rs, String fieldname)
	throws java.sql.SQLException
{
	int ri = rs.getInt(fieldname);
	if(rs.wasNull()) {
		return "";
	} else {
		return String.valueOf(ri);
	}
}
public String getServletInfo() {
	return super.getServletInfo();
}
public void init() {
	// insert code to initialize the servlet here
}
private Enumeration netzoneNames(Integer[] codes) throws Exception {
    Vector vec = new Vector();
    com.hps.july.persistence.NetZoneAccessBean bean = null;
    for (int i = 0; i < codes.length; i++) {
        bean = new com.hps.july.persistence.NetZoneAccessBean();
        bean.setInitKey_netzone(codes[i].intValue());
        bean.refreshCopyHelper();
        vec.add(bean.getName());
    }

    return vec.elements();
}
public void performTask(HttpServletRequest request, HttpServletResponse response)
{
	PositionListForm aform = (PositionListForm) request.getSession().getAttribute("PositionListForm");

	TimeCounter tc = new TimeCounter("POS_FLOW");
	TimeCounter tc1 = new TimeCounter("POSDOW_OVERALL");

	tc1.start();
	try {
		// Получаемвыборку по позициям
		// PositionAccessBean bean = new PositionAccessBean();
		DataUtil du = new DataUtil();
		Connection con = du.getConnection();
		tc.start();
		ArrayList resplist = findResptypes(con);
		tc.finish("Resptypes");
		PreparedStatement pst = null;
		int mapvar = com.hps.july.util.AppUtils.getNamedValueInt("WayMapVariant");
System.out.println("WAY_MAP_VAR:"+mapvar);

		ResultSet rs = null;
		try {
			tc.start();
			pst = findPositionsData(con,aform,resplist,request.getRemoteUser(),mapvar);
			tc.finish("Positions Data");
			tc.start();
			rs = pst.executeQuery();
			tc.finish("Positions Data Execute");
			tc.start();
			printResults(request,response,aform,rs,resplist,mapvar);
			tc.finish("Print results");
		} finally {
			if(rs != null) try { rs.close(); } catch(Throwable t) { t.printStackTrace(System.out); }
			if(pst != null) try { pst.close(); } catch(Throwable t) { t.printStackTrace(System.out); }
			if(con != null) try { con.close(); } catch(Throwable t) { t.printStackTrace(System.out); }
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	tc1.finish("Download done");
}
private void printFilterRow(String label, boolean isAll, Enumeration enum, ServletOutputStream out, MessageResources res)
	throws Exception
{
	StringBuffer buf = new StringBuffer("");
	String el=null;
	if (isAll) {
		buf.append(res.getMessage("label.search.all"));
	} else {
		while (enum.hasMoreElements()) {
			el=(String)enum.nextElement();
			buf.append((buf.length() != 0 ? "," : "") + el);
		}
	}
	out.println("<TR>");
	out.println("<TD valign='top'><B>");

    println(res.getMessage(label),out);
    
    out.println("</TD>");
    out.println("<TD>");

    println(buf.toString(),out);

    out.println("</TD>");
    out.println("</TR>");
}
private void println(Object ob, ServletOutputStream out) throws Exception {
	String str = ob == null ? "" : ob.toString();
	out.write(ResponseUtils.filter(str).getBytes(encoding));
}
public void printResults(HttpServletRequest request, HttpServletResponse response, PositionListForm aform, ResultSet rs, ArrayList resplist, int mapvar)
	throws Exception
{
	TimeCounter tc2 = new TimeCounter("POSDOW_RESULTS");
	ServletOutputStream out = response.getOutputStream();

	tc2.start();
	String name = "positions.xls";

	// Output result to stream
	response.setContentType("application/vnd.ms-excel; name=" + name);
	response.setHeader("Content-Disposition", "inline;filename=" + name);

	// Find message resources
	PropertyMessageResourcesFactory f = new PropertyMessageResourcesFactory();
	MessageResources m = f.createResources(getInitParameter("application"));

	out.println("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; CHARSET=windows-1251\">");
	out.println("<HTML><BODY><H2>");
	writeMessage(m, out, "label.position.ex.title");
	out.println("</H2><BR><H3>");
	writeMessage(m, out, "label.position.ex.searchcond");
	out.println("</H3>");

	// Print search conditions
	out.println("<TABLE>");
	//supregs
	printFilterRow("label.position.search.supregs", aform.getRegionsSelector().isAllSuperregions(), supregNames(aform.getRegionsSelector().getSuperregioncodes()), out, m);
	printFilterRow("label.position.search.regions",	aform.getRegionsSelector().isAllRegions(),	regionNames(aform.getRegionsSelector().getRegioncodes()), out, m);
	printFilterRow("label.position.netzonename", aform.getRegionsSelector().isAllNetzones(), netzoneNames(aform.getRegionsSelector().getNetzonecodes()), out, m);
	out.println("<TR>");

	// handle "search by"
	out.println("<TD><B>");
		writeMessage(m, out, "label.posrep.search");
	out.println("</B></TD><TD>");
	if ("A".equals(aform.getSearchBy())) { writeMessage(m, out, "label.posrep.search.all"); }
	if ("F".equals(aform.getSearchBy())) { writeMessage(m, out, "label.posrep.search.bsgsm"); }
	if ("G".equals(aform.getSearchBy())) { writeMessage(m, out, "label.posrep.search.bsdamps"); }
	if ("H".equals(aform.getSearchBy())) { writeMessage(m, out, "label.posrep.search.nobs"); }
	if ("B".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.posrep.search.gsmid");
		if(aform.getSearchString() != null) {
			writeMessage(out,": ");
			writeMessage(out,aform.getSearchString());
		}
	}
	if ("C".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.posrep.search.dampsid");
		if(aform.getSearchString() != null) {
			writeMessage(out,": ");
			writeMessage(out,aform.getSearchString());
		}
	}
	if ("D".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.posrep.search.name");
		if(aform.getSearchString() != null) {
			writeMessage(out," '");
			writeMessage(out,aform.getSearchString());
			writeMessage(out,"'");
		}
	}
	if ("E".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.posrep.search.addr");
		if(aform.getSearchString() != null) {
			writeMessage(out," '");
			writeMessage(out,aform.getSearchString());
			writeMessage(out,"'");
		}
	}
	if ("I".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.position.search.trid");
		if(aform.getSearchString() != null) {
			writeMessage(out,": '");
			writeMessage(out,aform.getSearchString());
			writeMessage(out,"'");
		}
	}
	if ("K".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.position.search.trall");
	}
	if ("L".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.position.search.trrrl");
	}
	if ("M".equals(aform.getSearchBy())) {
		writeMessage(m, out, "label.position.search.trvot");
	}
	out.println("</TD></TR>");
	
//	out.println("<TR><TD><B>");
//	writeMessage(m, out, "label.position.search.text");
//	out.println("</TD><TD>");
//	writeMessage(out,aform.getSearchString());
//	out.println("</TD></TR>");
	// end "search by" handling
	out.println("<TR>");
	out.println("<TD><B>");
	writeMessage(m, out, "label.position.renter");
	out.println("</TD>");
	out.println("<TD>");

	String renter = "";
	if (aform.getRenterSearchType().equals(Position.RENTER_Any)) {
		renter = m.getMessage("label.position.search.renter.any");
	} else if (aform.getRenterSearchType().equals(Position.RENTER_Any)) {
		renter = m.getMessage("label.position.search.renter.notNull");
	} else {
		renter = aform.getOrgname();
	}
	out.write(ResponseUtils.filter(renter).getBytes(encoding));
	out.println("</TD>");
	out.println("</TR>");
	out.println("<TR>");
	out.println("<TD><B>");
	writeMessage(m, out, "label.position.worker");
	out.println("</TD>");
	out.println("<TD>");
	if (aform.getIsWorker().booleanValue()) {
		writeMessage(m, out, "label.search.all");
	} else {
		writeMessage(out, aform.getWorkername());
	}
	out.println("</TD>");
	out.println("</TR>");
	out.println("<TR>");
	out.println("<TD><B>");
	writeMessage(m, out, "label.position.inactionlist");
	out.println("</TD>");
	out.println("<TD>");
	if (Position.INACTION_All.equals(aform.getInaction())) {
		writeMessage(m, out, "label.position.inaction.all");
	} else if (Position.INACTION_CHECK_Y.equals(aform.getInaction())) {
		writeMessage(m, out, "label.position.inaction.yes");
	} else if (Position.INACTION_CHECK_N.equals(aform.getInaction())) {
		writeMessage(m, out, "label.position.inaction.no");
	}
	out.println("</TD>");
	out.println("</TR>");

	//planstate
	out.println("<TR>");
	out.println("<TD><B>");
	writeMessage(m, out, "label.position.planstate");
	out.println("</TD>");
	out.println("<TD>");
	if(aform.getPosstate() != null) {
		writeMessage(m, out, "posstate."+aform.getPosstate().toLowerCase());
	} else {
		writeMessage(m, out, "position.unknown");
	}
	out.println("</TD>");
	out.println("</TR>");
	out.println("</TABLE><BR><BR>");
	// Draw table with data
	out.println("<TABLE BORDER=1>");
	// Print headers for columns
	out.println("<TR>");
	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.code");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.gsmid");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.dcsid");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.dampsid");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.name");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.dampsname");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.search.regions");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.addr");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.netcode");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m, out, "label.position.ex.netname");
	out.println("</TD>");

	if (request.isUserInRole("siteProjector")) {
		out.println("<TD VALIGN=top><B>");
		writeMessage(m, out, "label.position.ex.lat");
		out.println("</TD>");

		out.println("<TD VALIGN=top><B>");
		writeMessage(m, out, "label.position.ex.long");
		out.println("</TD>");
	}

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.details");
	out.println("</TD>");

	if(mapvar != 2) {
		out.println("<TD VALIGN=top><B>");
		writeMessage(m,out,"label.position.ex.contphone");
		out.println("</B></TD>");

		out.println("<TD VALIGN=top><B>");
		writeMessage(m,out,"label.position.ex.path");
		out.println("</B></TD>");

		out.println("<TD VALIGN=top><B>");
		writeMessage(m,out,"label.position.ex.equip");
		out.println("</B></TD>");

		out.println("<TD VALIGN=top><B>");
		writeMessage(m,out,"label.position.ex.engener");
		out.println("</B></TD>");
	} else {
		out.println("<TD VALIGN=top><B>");
		writeMessage(m,out,"label.posrep.docfile");
		out.println("</B></TD>");
	}

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.accdate");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.arcode");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.arname");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.volume");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.inaction");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.isrll");
	out.println("</TD>");

	out.println("<TD VALIGN=top><B>");
	writeMessage(m,out,"label.position.ex.isvot");
	out.println("</TD>");

	for (int i = 0; i < resplist.size(); i++) {
		Resptype t = (Resptype)resplist.get(i);
		out.println("<TD VALIGN=top><B>");
		out.write(ResponseUtils.filter(t.name).getBytes(encoding));
		out.println("</B></TD>");
	}

	out.println("</TR>");
	tc2.finish("Header");

	tc2.start();
	while (rs.next()) {
		out.println("<TR>");
		out.println("<TD VALIGN=top>" + rs.getInt("storageplace") + "</TD>");
		out.println("<TD VALIGN=top>");
		out.println(getIntAsString(rs,"gsmid"));
		out.println("</TD>");
		out.println("<TD VALIGN=top>");
		out.println(getIntAsString(rs,"dcsid"));
		out.println("</TD>");
		out.println("<TD VALIGN=top>");
		out.println(getIntAsString(rs,"dampsid"));
		out.println("</TD>");
		out.println("<TD VALIGN=top>");
		writeMessage(out,rs.getString("name"));
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		writeMessage(out,rs.getString("dampsname"));
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		println(rs.getString("regname"), out);
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		writeMessage(out,rs.getString("address"));
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		println(rs.getString("zonecode"), out);
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		println(rs.getString("zonename"), out);
		out.println("</TD>");

		if (request.isUserInRole("siteProjector")) {
			out.println("<TD VALIGN=top>" + rs.getString("latitude") + "</TD>");
			out.println("<TD VALIGN=top>" + rs.getString("longitude") + "</TD>");
		}

		out.println("<TD VALIGN=top>");
		println(rs.getString("details"), out);
		out.println("</TD>");

		if(mapvar != 2) {
			out.println("<TD VALIGN=top>");
			writeMessage(out,rs.getString("contactphones"));
			out.println("</TD>");

			out.println("<TD VALIGN=top>");
			writeMessage(out,rs.getString("pathtype"));
			out.println("</TD>");

			out.println("<TD VALIGN=top>");
			writeMessage(out,rs.getString("equipmentplaces"));
			out.println("</TD>");

			out.println("<TD VALIGN=top>");
			writeMessage(out,rs.getString("engenering"));
			out.println("</TD>");
		} else {
			out.println("<TD VALIGN=top>");
			if(rs.getString("docfilename") != null) {
				writeMessage(out,rs.getString("docfilename"));
			} else {
				writeMessage(m, out, "label.posrep.no");
			}
			out.println("</TD>");
		}

		out.println("<TD VALIGN=top>");
		java.sql.Date accesslistexp = rs.getDate("accesslistexp");
		if(accesslistexp != null) {
			writeMessage(out,df.format(rs.getDate("accesslistexp")));
		}
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		println(rs.getString("renterorg"), out);
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		println(rs.getString("rentername"), out);
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		println(rs.getString("rentervolume"), out);
		out.println(" &nbsp;");
		out.println("</TD>");

		out.println("<TD VALIGN=top>");
		if (rs.getString("inaction") != null) {
			if ("Y".equals(rs.getString("inaction"))) {
				writeMessage(m, out, "label.position.ex.yes");
			} else {
				writeMessage(m, out, "label.position.ex.no");
			}
		} else {
			out.println("&nbsp;");
		}
		out.println("</TD>");

		// Check if we have RRL equipment
		out.println("<TD VALIGN=top>");
		if(rs.getInt("rrlhops") > 0) {
			writeMessage(m, out, "label.posrep.have");
		} else {
			writeMessage(m, out, "label.posrep.no");
		}
		out.println("</TD>");

		// Check if we have VOT equipment
		out.println("<TD VALIGN=top>");
		if (rs.getInt("vothops") > 0) {
			writeMessage(m, out, "label.posrep.have");
		} else {
			writeMessage(m, out, "label.posrep.no");
		}
		out.println("</TD>");

		for (int j = 0; j < resplist.size(); j++) {
			Resptype t = (Resptype)resplist.get(j);
			out.println("<TD VALIGN=top>");
			writeMessage(out,rs.getString("workresp"+t.id));
			out.println("</TD>");
		}
		out.println("</TR>");
	}
	out.println("</TABLE>");
	tc2.finish("Body");
	out.flush();
	out.close();
}
private Enumeration regionNames(Integer[] codes) throws Exception {
    Vector res = new Vector();
    Query query =
        new Query(RegionObject.QUERY_SELECT_Admin, DataUtil.RESULT_JdbcObjectEnum);
    query.append("AND regionid IN", codes);
    Enumeration regs = new RegionObject().findEnumeration(query);
    while (regs.hasMoreElements()) {
        res.add(((RegionObject) regs.nextElement()).getName());
    }
    return res.elements();
}
private Enumeration supregNames(Integer[] codes)
	throws Exception
{
	Vector res = new Vector();
	String sql = "SELECT sr.supregid, sr.supregname FROM SuperRegions sr";

	Query query = new Query(sql, DataUtil.RESULT_JdbcObjectEnum);
	query.append("WHERE supregid IN", codes);

	Enumeration sregs = new SuperRegionObject().findEnumeration(query);
	while (sregs.hasMoreElements()) {
		res.add(((SuperRegionObject) sregs.nextElement()).getName());
	}
	return res.elements();
}
public void writeMessage(ServletOutputStream out, String message)
	throws java.io.IOException, java.io.UnsupportedEncodingException
{
	if(message != null) {
		out.write(ResponseUtils.filter(message).getBytes(encoding));
	}
}
public void writeMessage(MessageResources m, ServletOutputStream out, String key)
	throws java.io.IOException, java.io.UnsupportedEncodingException
{
	if(key != null) {
		writeMessage(out,m.getMessage(key));
	}
}
}
