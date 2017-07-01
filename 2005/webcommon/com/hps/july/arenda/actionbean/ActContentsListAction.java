package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.constants.Applications; //Заменить BeanName
import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.*;
import com.hps.july.persistence.*;
import java.io.IOException;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.math.*;

/**
 * Подбор начислений/платежей учавствующих в формировании акта.
 * Creation date: (04.11.2003 14:38:14)
 * @author: Dmitry Dneprov
 */
public class ActContentsListAction extends com.hps.july.web.util.NavigatedAction {
/**
 * Constructor
 * Creation date: (04.11.2003 14:38:44)
 */
public ActContentsListAction() {
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:13:05)
 * @return int[]
 * @param ar java.util.ArrayList
 */
private static int[] extractArray(ArrayList ar) {
	ArrayList goodels = new ArrayList();
	Iterator it = ar.iterator();
	while (it.hasNext()) {
		ActContentsValueObject ao = (ActContentsValueObject)it.next();
		if (ao.getWillbeinact() != 0)
			goodels.add(ao);
	}
	Iterator it2 = goodels.iterator();
	int [] res = new int [goodels.size()];
	int i = 0;
	while (it2.hasNext()) {
		ActContentsValueObject ao = (ActContentsValueObject)it2.next();
		res [i++] = ao.getLeasedocposition();
	}
	return res;
}

public java.util.ArrayList findCharges(int argActCode, String argContractType, boolean isViewOnly)
    throws java.lang.Exception {

	ResultSet rs = null;
	PreparedStatement ps = null;
	
    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer("SELECT dp.*, lch.*, lc.contracttype, ld.leasedocument, ");
    sb.append("ld.docnumber, ld.docdate, ld.doctype, ");
    sb.append("res.name resname, cur.shortname currname, org.name orgname ");
    sb.append("FROM leasedocpositions dp, leasecharges lch, leasecontracts lc, ");
    sb.append("leasemutualacts ma, leasemutcontracts lmc, leasedocuments ld, ");
    sb.append("resources res, currencies cur, vendorsites org ");
    sb.append("WHERE lch.leasedocposition = dp.leasedocposition ");
    sb.append(" AND lc.leasedocument = dp.leasecontract AND ld.leasedocument=lc.leasedocument ");
    sb.append(" AND ma.leasedocument=" + argActCode + " AND lmc.reglament = ma.mutualreglament ");
    sb.append(" AND dp.leasecontract = lmc.contract AND dp.resource=lmc.resource ");
    sb.append(" AND (");
    if (!isViewOnly)
    	sb.append("dp.usedinact IS NULL OR ");
    sb.append("dp.usedinact = " + argActCode + ") ");
    sb.append(" AND res.resource=dp.resource AND cur.currency=dp.currency ");
    sb.append(" AND org.idVendorSite=lc.orgexecutor ");
    sb.append(" AND dp.docPosVid IN ('N' ,'C') ");
    sb.append(" AND lc.contracttype = '" + argContractType + "' ");
    sb.append(" ORDER BY lc.contracttype, dp.leasecontract, dp.date, dp.leasedocposition");

    //System.out.println("SQL clause=" + sb);

	ArrayList result = new ArrayList();
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    ps = con.prepareStatement(sb.toString());

	    rs = ps.executeQuery();

	    while (rs.next()) {
		    ActContentsValueObject acvo = new ActContentsValueObject();

		    acvo.setLeasedocposition(rs.getInt("leasedocposition"));
		    acvo.setResource(rs.getInt("resource"));
		    acvo.setResname(jcon.getString(rs, "resname"));
		    acvo.setBegindate(rs.getDate("begindate"));
		    acvo.setEnddate(rs.getDate("enddate"));
		    acvo.setSumm(rs.getBigDecimal("summ"));
		    acvo.setCurrency(rs.getInt("currency"));
		    acvo.setCurrname(rs.getString("currname"));
		    acvo.setWillbeinact(rs.getInt("willbeinact"));

		    acvo.setLeasedocument(rs.getInt("leasedocument"));
		    acvo.setDocnumber(rs.getString("docnumber"));
		    acvo.setDocdate(rs.getDate("docdate"));
		    acvo.setOrgname(rs.getString("orgname"));
		    acvo.setContracttype(rs.getString("contracttype"));
		    acvo.setBillnumber(rs.getString("billnumber"));
		    acvo.setBilldate(rs.getDate("billdate"));

		    if ("B".equals(rs.getString("doctype"))) {
			    // Determine BAN & BENS
			    try {
				    LeaseAbonentBANAccessBean lab = new LeaseAbonentBANAccessBean();
				    lab.setInitKey_leaseDocument(acvo.getLeasedocument());
				    lab.refreshCopyHelper();
				    acvo.setBan("" + lab.getBan());
				    LeaseAbonentBANValue lav = new LeaseAbonentBANValue(lab);
				    acvo.setBen(lav.getBens());
			    } catch (Exception e) {
				    e.printStackTrace(System.out);
			    }
		    }
		    
		    result.add(acvo);
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

public java.util.ArrayList findPayments(int argActCode, String argContractType, boolean isViewOnly)
    throws java.lang.Exception {

	ResultSet rs = null;
	PreparedStatement ps = null;
	
    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer("SELECT dp.date paydate, dp.*, lpm.docnumber paynumber, ");
    sb.append("lpm.*, lc.contracttype, ld.leasedocument, ld.docnumber rdocnumber, ld.docdate, ld.doctype, ");
    sb.append("res.name resname, org.name orgname ");
    sb.append("FROM leasedocpositions dp, leasepayments lpm, leasecontracts lc, ");
    sb.append("leasemutualacts ma, leasemutcontracts lmc, leasedocuments ld, ");
    sb.append("resources res, vendorsites org ");
    sb.append("WHERE lpm.leasedocposition = dp.leasedocposition ");
    sb.append(" AND lc.leasedocument = dp.leasecontract AND ld.leasedocument=lc.leasedocument ");
    sb.append(" AND ma.leasedocument=" + argActCode + " AND lmc.reglament = ma.mutualreglament ");
    sb.append(" AND dp.leasecontract = lmc.contract AND dp.resource=lmc.resource ");
    sb.append(" AND (");
    if (!isViewOnly)
    	sb.append("dp.usedinact IS NULL OR ");
    sb.append("dp.usedinact = " + argActCode + ") ");
    sb.append(" AND res.resource=dp.resource ");
    sb.append(" AND org.idVendorSite=lc.orgexecutor ");
    sb.append(" AND lc.contracttype = '" + argContractType + "' ");
    sb.append(" AND dp.docPosVid IN ('N' ,'C') ");
    sb.append(" AND lpm.paymentstate = 'P' ");
    sb.append(" ORDER BY lc.contracttype, dp.leasecontract, dp.date, dp.leasedocposition");

    //System.out.println("SQL clause=" + sb);

	ArrayList result = new ArrayList();
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    ps = con.prepareStatement(sb.toString());

	    rs = ps.executeQuery();

	    while (rs.next()) {
		    ActContentsValueObject acvo = new ActContentsValueObject();

		    acvo.setLeasedocposition(rs.getInt("leasedocposition"));
		    acvo.setResource(rs.getInt("resource"));
		    acvo.setResname(jcon.getString(rs, "resname"));
		    acvo.setBilldate(rs.getDate("paydate"));
		    acvo.setBillnumber(rs.getString("paynumber"));
		    acvo.setSumm(rs.getBigDecimal("summrub"));
		    acvo.setWillbeinact(rs.getInt("willbeinact"));

		    acvo.setLeasedocument(rs.getInt("leasedocument"));
		    acvo.setDocnumber(rs.getString("rdocnumber"));
		    acvo.setDocdate(rs.getDate("docdate"));
		    acvo.setOrgname(rs.getString("orgname"));
		    acvo.setContracttype(rs.getString("contracttype"));
		    
		    if ("B".equals(rs.getString("doctype"))) {
			    // Determine BAN & BENS
			    try {
				    LeaseAbonentBANAccessBean lab = new LeaseAbonentBANAccessBean();
				    lab.setInitKey_leaseDocument(acvo.getLeasedocument());
				    lab.refreshCopyHelper();
				    acvo.setBan("" + lab.getBan());
				    LeaseAbonentBANValue lav = new LeaseAbonentBANValue(lab);
				    acvo.setBen(lav.getBens());
			    } catch (Exception e) {
				    e.printStackTrace(System.out);
			    }
		    }
		    
		    result.add(acvo);
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
/**
 * Создание перечисления элементов массива для использования в SQL.
 * Creation date: (24.12.2003 12:30:45)
 * @return java.lang.String
 * @param inAr int[]
 */
private String makeInString(String curInStr, int[] inAr) {
	String result = curInStr;
	for (int i=0; i < inAr.length; i++) {
		if (result.length() > 0)
			result = result + ",";
		result = result + inAr [i];
	}
	return result;
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

	// Calculate browse params
	ActContentsListForm bform = (ActContentsListForm)form;
	boolean readOnly = false;

	// Determine Act Params
	try {
		LeaseMutualActNewAccessBean lma = new LeaseMutualActNewAccessBean();
		lma.setInitKey_leaseDocument(bform.getActcode());
		lma.refreshCopyHelper();
		bform.setActdate(lma.getDocumentDate());
		bform.setActnumber(lma.getDocumentNumber());
		if (!"O".equals(lma.getActState()))
			readOnly = true;
	} catch (Exception e) {
		e.printStackTrace(System.out);
		bform.setActdate(null);
		bform.setActnumber("");
	}
	
	// Check if processing requested
	if (!readOnly) {
		if (bform.getAction_process() == 1) {
			saveResults(bform);
			// Reset process flag
			bform.setAction_process(0);
		}
	}
	
	try {
		ArrayList res = findCharges(bform.getActcode(), "A", readOnly);
		request.setAttribute("table1", res);
		bform.setSelchrgd(extractArray(res));
	} catch (Exception e) {
		e.printStackTrace(System.out);
		request.setAttribute("table1", new ArrayList());
		bform.setSelchrgd(new int[0]);
	}
	
	try {
		ArrayList res = findCharges(bform.getActcode(), "C", readOnly);
		request.setAttribute("table2", res);
		bform.setSelchrga(extractArray(res));
	} catch (Exception e) {
		e.printStackTrace(System.out);
		request.setAttribute("table2", new ArrayList());
		bform.setSelchrga(new int[0]);
	}

	try {
		ArrayList res = findPayments(bform.getActcode(), "A", readOnly);
		request.setAttribute("table3", res);
		bform.setSelpayd(extractArray(res));
	} catch (Exception e) {
		e.printStackTrace(System.out);
		request.setAttribute("table3", new ArrayList());
		bform.setSelpayd(new int[0]);
	}
	
	try {
		ArrayList res = findPayments(bform.getActcode(), "C", readOnly);
		request.setAttribute("table4", res);
		bform.setSelpaya(extractArray(res));
	} catch (Exception e) {
		e.printStackTrace(System.out);
		request.setAttribute("table4", new ArrayList());
		bform.setSelpaya(new int[0]);
	}

	// Check read-only state
	if (readOnly) {
		// Disable editing
		bform.setAction("View")	;
	}
	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ACT_CONTENTS_LIST);
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
	
}
/**
 * Сохранение выбранных элементов в БД.
 * Creation date: (24.12.2003 12:05:38)
 */
private void saveResults(ActContentsListForm aform) {
	// Это массовое обновление БД,
	// поэтому для ускорения работы реализовано через ODBC
	JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    Statement st = null;
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    st = con.createStatement();
        String s1 = "UPDATE leasedocpositions SET willbeinact = NULL WHERE willbeinact = " + aform.getActcode();
        System.out.println("SAVE SQL:" + s1);
	    st.execute(s1);
	    String inStr = "";
	    inStr = makeInString(inStr, aform.getSelchrgd());
	    inStr = makeInString(inStr, aform.getSelchrga());
	    inStr = makeInString(inStr, aform.getSelpayd());
	    inStr = makeInString(inStr, aform.getSelpaya());
	    String s2 = "UPDATE leasedocpositions SET willbeinact = " + aform.getActcode() + " WHERE leasedocposition IN (" + inStr + ")";
        System.out.println("SAVE SQL:" + s2);
	    st.execute(s2);
	    
    } catch (Exception e) {
    	e.printStackTrace(System.out);
    } finally {
	    try {
		    st.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
	    try {
		    con.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
    }
}
}
