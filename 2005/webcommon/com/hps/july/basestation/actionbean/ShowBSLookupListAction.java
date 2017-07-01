package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.formbean.*;
import java.sql.*;
import java.util.*;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик выбора донорной базовой станции
 */
public class ShowBSLookupListAction
	extends LookupBrowseAction
{
	private static final String QUERY_START =
		"SELECT bs.equipment, bs.type, bs.number, bs.name, s.address, nz.zonecode, bs.on_air "+
		"FROM basestations bs, equipment e, positions p, storageplaces s, netzones nz, regions r "+
		"WHERE bs.equipment = e.equipment "+
		"AND e.position = p.storageplace "+
		"AND p.storageplace = s.storageplace "+
		"AND p.netzone = nz.netzone "+
		"AND p.regionid = r.regionid ";
public Vector find(
	Boolean isSupregions, Integer [] supregions, 
	Boolean isRegions, Integer [] regions, 
	Boolean isNetzones, Integer [] netzones,
	String stationtype,
	String searchby, String searchstring,
	Boolean isController, Integer acontroller,
	Boolean isSwitch, Integer aswitch,
 	Integer order)
    throws java.lang.Exception
{
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection con = null;

	boolean addSearchBy = false;
	
    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer(QUERY_START);

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("");
    if (isSupregions != null && isSupregions.booleanValue()) {
	    String s = "";
	    for (i=0; i < supregions.length; i++) {
		    if (s.length() > 0) { s = s + ", "; }
		    s = s + supregions [i].toString();
	    }
	    if (s.length() > 0) {
	        whereClause.append("AND r.supregid IN ("+s+") ");
	    }
    }
    if (isRegions != null && isRegions.booleanValue()) {
	    String s = "";
	    for (i=0; i<regions.length; i++) {
			if (s.length() > 0) { s = s + ", "; }
		    s = s + regions [i].toString();
	    }
	    if (s.length() > 0) {
	        whereClause.append("AND p.regionid IN ("+s+") ");
	    }
    }
    if (isNetzones.booleanValue()) {
	    String s = "";
	    for (i=0; i<netzones.length; i++) {
		    if (s.length() > 0) { s = s + ", "; }
		    s = s + netzones [i].toString();
	    }
	    if (s.length() > 0) {
     		whereClause.append("AND p.netzone IN ("+s+") ");
	    }
    }
    if (stationtype != null) {
	    if("D".equals(stationtype)) {
			whereClause.append("AND bs.type IN ('S','C','G') ");
	    } else if("A".equals(stationtype)) {
			whereClause.append("AND bs.type = 'D' ");
	    }
    }
    /*
    if (planstate != null) {
	    if("0".equals(planstate)) {
		    whereClause.append("AND p.planstate = '0' ");
	    } else
	    if("1".equals(planstate)) {
		    whereClause.append("AND p.planstate = '1' ");
	    } else
	    if("2".equals(planstate)) {
		    whereClause.append("AND p.planstate = '2' ");
	    }
    }
   */
    if (searchby != null) {
	    if("1".equals(searchby)) { // By BS number
		    addSearchBy = true;
		    whereClause.append("AND bs.number = ? ");
	    } else if("2".equals(searchby)) { // By name
		    addSearchBy = true;
		    whereClause.append("AND bs.name matches ? ");
	    } else if("3".equals(searchby)) { // By address
		    addSearchBy = true;
		    whereClause.append("AND s.address matches ? ");
	    }
    }
        
	if (isController != null && isController.booleanValue()) {
        whereClause.append("AND bs.controller = ? ");
	}
        
    if (isSwitch != null && isSwitch.booleanValue()) {
		whereClause.append("AND bs.switch = ? ");
    }

    sb.append(whereClause.toString());

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "bs.name asc";
            break;
        case 2 :
            orderBy = "bs.name desc";
            break;
    }
    if(orderBy != null) {
	    sb.append(" ORDER BY " + orderBy);
    }

    System.out.println("SQL clause=" + sb);

	Vector result = new Vector();
    JdbcConnection jcon = new JdbcConnection();
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    ps = con.prepareStatement(sb.toString());

	    int j = 1;
	    if(addSearchBy) {
		    ps.setString(j++, searchstring);
	    }
	    if(isController != null && isController.booleanValue()) {
		    ps.setInt(j++, acontroller.intValue());
	    }
	    if(isSwitch != null && isSwitch.booleanValue()) {
		    ps.setInt(j++, aswitch.intValue());
	    }
	    
	    rs = ps.executeQuery();
	    while (rs.next()) {
			BasestationLookupObject blo = new BasestationLookupObject();
		    blo.setKey(rs.getInt("equipment"));
		    blo.setType(rs.getString("type"));
		    int number = rs.getInt("number");
		    if(rs.wasNull()) { blo.setNumber(null); }
			else { blo.setNumber(new Integer(number)); }
		    blo.setName(rs.getString("name"));
			blo.setAddress(rs.getString("address"));
			blo.setNetzone(rs.getString("zonecode"));
			String onair = rs.getString("on_air");
			if(onair == null) { blo.setOnair(null); }
			else { blo.setOnair(new Boolean("Y".equals(onair))); }
		    result.add(blo);
	    }
    } catch (Exception e) {
    	e.printStackTrace(System.out);
    } finally {
	    try {
		    rs.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
	    try {
		    ps.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
	    try {
		    con.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
    }
    return result;
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.basestation.actionbean.ShowBSLookupListAction";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.BS_LOOKUP);
	  	// update filter parameters
		BSLookupListForm aform = (BSLookupListForm)form;
		aform.getAcontroller().refresh();
		aform.getAswitch().refresh();
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
