package com.hps.july.project.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications; 
import com.hps.july.project.APPStates;
import com.hps.july.project.formbean.*;
import com.hps.july.project.*;
import com.hps.july.persistence.*;
import java.io.IOException;
import java.util.*;
import com.hps.july.project.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.math.*;
import java.util.*;

/**
 * Обработчик списка проектов.
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class ShowProjectListAction
    extends com.hps.july.web.util.BrowseAction {
//private Vector actionTypeVector;
//private ProjectListForm form;
//private HttpServletRequest request;
	    
public Object constructRowModelBean(Object o) {

	//TimeCounter tmcnt = new TimeCounter("PROJECT:");
	//tmcnt.start();


	//tmcnt.finish("ConstructRowModelBean");
	
	return o;
}
public Vector findByQBE2(Integer division, Integer projecttype,
	Boolean isSupregions, Integer [] supregions, 
	Boolean isRegions, Integer [] regions, 
	Boolean isNetzones, Integer [] netzones,
	Boolean isPosition, Integer argPosition,
	Boolean isResponsible, Integer argResponsible,
	Boolean isProvider, Integer argProvider,
	Boolean isEndDate, Short endMonth, Integer endYear,
	Boolean isProjectstate, String argProjectstate, 
	Vector actionTypeVector,
	Vector responsibleVector,
 	Integer order)
    throws java.lang.Exception {

	ResultSet rs = null;
	PreparedStatement ps = null;
    PreparedStatement st = null;
    PreparedStatement actst = null;
    PreparedStatement divst = null;
	
    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer("SELECT pr.*, sp.name posname, ps.*, NVL(o.shortname, o.name) oname, pt.*, ");
    sb.append("NVL(o2.shortname,o2.name) vcname, ");
    sb.append("NVL(pr.yearfinish, 9999) yearf, NVL(pr.monthfinish, 99) monthf, ");
    sb.append("CASE WHEN pra.factdate IS NOT NULL THEN pra.factdate ELSE NVL(pra.suggplandate, MDY(12,31,2999)) END pradate ");
    sb.append("FROM projects pr, positions ps, storageplaces sp, outer organizations o, projectstates pt, ");
    sb.append("outer projectactions pra, outer organizations o2 ");
    sb.append("WHERE sp.storageplace = ps.storageplace AND pr.position = ps.storageplace AND " +
	    "o.organization = pr.contructer AND pt.project = pr.project AND " +
	    "pt.projectstate = (SELECT max(pt1.projectstate) FROM projectstates pt1 WHERE pt1.project = pr.project) AND ");
    sb.append("pra.projectaction = (SELECT min(pr1.projectaction) FROM projectactions pr1 WHERE pr1.project = pr.project AND "+
	    "pr1.projectactiontype = (SELECT min(pr2.projectactiontype) FROM protoactions pr2 WHERE "+
	    "pr2.projecttype = pr.projecttype AND pr2.order = (SELECT min(pr3.order) FROM protoactions pr3 WHERE " +
	    "pr3.projecttype = pr.projecttype))) AND pra.project = pr.project AND ");
    sb.append("o2.organization = pr.vccontructer ");

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("AND pr.projecttype=? ");
    if (isSupregions.booleanValue()) {
	    String s = "";
	    for (i=0; i<supregions.length; i++) {
		    if (s.length() > 0)
		    	s = s + ", ";
		    s = s + supregions [i].toString();
	    }
	    if (s.length() > 0)
        whereClause.append(" AND pr.position IN (SELECT p.storageplace FROM positions p, regions r " +
	        "WHERE r.regionid = p.regionid AND r.supregid IN (" + s + "))");
    }
    if (isRegions.booleanValue()) {
	    String s = "";
	    for (i=0; i<regions.length; i++) {
		    if (s.length() > 0)
		    	s = s + ", ";
		    s = s + regions [i].toString();
	    }
	    if (s.length() > 0)
        whereClause.append(" AND pr.position IN (SELECT p.storageplace FROM positions p " +
	        "WHERE p.regionid IN (" + s + "))");
    }
    if (isNetzones.booleanValue()) {
	    String s = "";
	    for (i=0; i<netzones.length; i++) {
		    if (s.length() > 0)
		    	s = s + ", ";
		    s = s + netzones [i].toString();
	    }
	    if (s.length() > 0)
        whereClause.append(" AND pr.position IN (SELECT p.storageplace FROM positions p " +
	        "WHERE p.netzone IN (" + s + "))");
    }
    if (isPosition.booleanValue())
        whereClause.append(" AND pr.position = ?");
        
    if (isResponsible.booleanValue())
        whereClause.append(" AND pr.project IN (SELECT p.project FROM projectactions p, projectactiontypes t, " +
	        "workresponsibility w WHERE t.projectactiontype = p.projectactiontype AND " +
	        "w.idresponsibility = t.typeresponsibility AND w.storageplace = pr.position AND w.worker=?)");
        
    if (isProvider.booleanValue())
        whereClause.append(" AND pr.contructer = ? ");
	        
    if (isEndDate.booleanValue())
        whereClause.append(" AND pr.monthfinish = ? AND pr.yearfinish = ?");

    if (isProjectstate.booleanValue())
        whereClause.append(
            " AND "
                + "(SELECT max(p.state) "
                + "FROM projectstates p "
                + "WHERE p.project = pr.project AND p.when ="
                + "(SELECT max(p1.when) "
                + "FROM projectstates p1 "
                + "WHERE p1.project = pr.project)) = ?");
        
    sb.append(whereClause.toString());

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "sp.name asc";
            break;
        case 2 :
            orderBy = "sp.name desc";
            break;
        case 3 :
            orderBy = "yearf asc, monthf asc, sp.name asc";
            break;
        case 4 :
            orderBy = "yearf desc, monthf desc, sp.name desc";
            break;
        case 5 :
            orderBy = "pradate asc, sp.name asc";
            break;
        case 6 :
            orderBy = "pradate desc, sp.name desc";
            break;
    }
    sb.append(" order by " + orderBy);

    System.out.println("SQL clause=" + sb);

	Vector result = new Vector();
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    ps = con.prepareStatement(sb.toString());

	    int j = 1;
	    ps.setInt(j++, projecttype.intValue());
	    if (isPosition.booleanValue())
	        ps.setInt(j++, argPosition.intValue());
	    if (isResponsible.booleanValue())
	        ps.setInt(j++, argResponsible.intValue());
	    if (isProvider.booleanValue())
	        ps.setInt(j++, argProvider.intValue());
	    if (isEndDate.booleanValue()) {
	        ps.setShort(j++, endMonth.shortValue());
	        ps.setInt(j++, endYear.intValue());
	    }
	    if (isProjectstate.booleanValue())
	        ps.setString(j++, argProjectstate);

	    rs = ps.executeQuery();


	    // Initialize vectors & prepared statements
	    
	    String POSRESP_QUERY = "SELECT FIRST 1 * FROM WorkResponsibility wr, workers wk, people p " +
	    	"WHERE storageplace = ? AND idresponsibility = ? AND " +
	    	"  wk.worker = wr.worker AND p.man = wk.man AND wr.resptype = 'W' ";

		st = con.prepareStatement(POSRESP_QUERY);


	    String PRJACT_QUERY = "SELECT FIRST 1 pa.*, pc.*, pa.projectaction projectactionid FROM projectactions pa, outer projectactioncomms pc " +
	    	"WHERE pa.project = ? AND pa.projectactiontype = ? AND pc.projectaction = pa.projectaction AND " +
	    	"pc.division = ?";
		
		actst = con.prepareStatement(PRJACT_QUERY);
		
	    String USRDIV_QUERY = "SELECT FIRST 1 * FROM projectdivcolvals pv " +
	    	"WHERE pv.project = ? AND pv.divcolid = ? ";
		
		divst = con.prepareStatement(USRDIV_QUERY);
	    
	    while (rs.next()) {
		    ProjectObject po = new ProjectObject();
		    po.setDivcode(division.intValue());
		    po.setProject(rs.getInt("project"));
		    int gsmid = rs.getInt("gsmid");
		    if (rs.wasNull())
		    	po.setPosgsmid(null);
		    else
		    	po.setPosgsmid(new Integer(gsmid));

		    if (rs.getString("posname") != null)
		    	po.setPosname(rs.getString("posname").trim());
		    else
		    	po.setPosname("");
		    
		    po.setPosstorageplace(rs.getInt("position"));

		    if (rs.getString("vctext") != null)
		    	po.setVctext(rs.getString("vctext").trim());
		    else
		    	po.setVctext("");
		    po.setPosdetails(rs.getString("details"));

		    byte [] notes = rs.getBytes("notes");
		    if (rs.wasNull() || (notes == null))
		    	po.setNotes("");
		    else
		    	po.setNotes(new String(notes, "Cp1251").trim());

		    po.setMonthfinish(new Integer(rs.getInt("monthfinish")));
		    if (rs.wasNull())
		    	po.setMonthfinish(null);
		    	
		    po.setYearfinish(new Integer(rs.getInt("yearfinish")));
		    if (rs.wasNull())
		    	po.setYearfinish(null);

		    if (rs.getString("oname") != null)
		    	po.setContrname(rs.getString("oname").trim());
		    else
		    	po.setContrname("");

		    if (rs.getString("vcname") != null)
		    	po.setVcname(rs.getString("vcname").trim());
		    else
		    	po.setVcname("");
		    	
		    po.setState(rs.getString("state").trim());
		    
			po.initActionVector(actionTypeVector, actst, divst);
			po.initResponsibleVector(responsibleVector, st);
			
		    result.add(po);
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
		    st.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
	    try {
		    actst.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
	    try {
		    divst.close();
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
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.project.actionbean.ShowProjectListAction";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

    
	TimeCounter tmcnt = new TimeCounter("PROJECT:");
	tmcnt.start();

	ProjectListForm aform = (ProjectListForm)form;


	// Update Refresh counter from application
	javax.servlet.ServletContext application = getServlet().getServletContext();
	String refrcnt = (String)application.getAttribute("REFRCNT");
	if (refrcnt == null) {
		refrcnt = "0";
		application.setAttribute("REFRCNT", refrcnt);
	}
	request.getSession().setAttribute("REFRCNT", refrcnt);
	
    // Check for accept all dates request
    if (request.getParameter("acceptall.x") != null) {
	    // Accept all new plan dates
	    System.out.println("PROJECT: accepting all dates for project=" + aform.getAcceptcode());
	    try {
		    ProjectActionObject.changeAllPlanDates(true, new Integer(aform.getAcceptcode()));
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectaction.acceptall"));
	    }
    }
    
    try {
	    aform.initCollections(request);

	    // Init Action types
	    try {
	        aform.con_actionTypeVector = aform.initActionTypeVector(request);

	    } catch (Exception e) {
	        throw new ServletException(e);
	    }

	    // Init Responsible types
	    try {
	        aform.con_responsibleVector = aform.initResponsibleVector(request);

	    } catch (Exception e) {
	        throw new ServletException(e);
	    }
	    
		StringAndIntegerProperty probj = new StringAndIntegerProperty();

	    // Calculate position name
	    if (!aform.getPositionsAll().booleanValue()) {
			probj.setString(aform.getPoscode());
			if (!probj.isEmpty())
				if (probj.isOk()) {
					try {
						PositionAccessBean pos = new PositionAccessBean();
						pos.setInitKey_storageplace(probj.getInteger().intValue());
						pos.refreshCopyHelper();
						String posnum = "";
						if (pos.getGsmid() != null)
							posnum = posnum + "D" + pos.getGsmid();
						if (pos.getDampsid() != null)
							posnum = posnum + " A" + pos.getDampsid();
						aform.setPosnum(posnum);
						aform.setPosname(posnum + " " + pos.getName());
					} catch (Exception e) {
						e.printStackTrace(System.out);
						aform.setRespname("");
					}
				}
	    }

	    // Calculate responsible name
	    if (!aform.getResponsibleAll().booleanValue()) {
			Integer respint = new Integer(0);
			probj.setString(aform.getRespcode());
			if (!probj.isEmpty())
				if (probj.isOk()) {
					try {
						WorkerAccessBean wrk = new WorkerAccessBean();
						wrk.setInitKey_worker(probj.getInteger().intValue());
						wrk.refreshCopyHelper();
						aform.setRespname(wrk.getMan().getFullName());
					} catch (Exception e) {
						e.printStackTrace(System.out);
						aform.setRespname("");
					}
				}
	    }
	    
	    // Calculate provider name
	    if (!aform.getProviderAll().booleanValue()) {
			Integer print = new Integer(0);
			probj.setString(aform.getContructerCode());
			if (!probj.isEmpty())
				if (probj.isOk()) {
					try {
						OrganizationAccessBean org = new OrganizationAccessBean();
						org.setInitKey_organization(probj.getInteger().intValue());
						org.refreshCopyHelper();
						aform.setContructerName(org.getName());
					} catch (Exception e) {
						e.printStackTrace(System.out);
						aform.setContructerName("");
					}
				}
	    }
		
	    super.perform(mapping, form, request, response);
	    ParamsParser.setState(request, Applications.PROJECT, APPStates.PROJECTLIST);
    
    } catch (Exception e) {
    	e.printStackTrace(System.out);
    }
    tmcnt.finish("Perform");
    
    return mapping.findForward("main");
}
}
