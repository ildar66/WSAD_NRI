package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
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
 * Action-class.
 * действие для "Лист истории начислений договоров"
 * Creation date: (04.11.2003 14:38:14)
 * @author: Dmitry Dneprov
 */
public class DogHistChargeListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Constructor
 * Creation date: (04.11.2003 14:38:44)
 */
public DogHistChargeListAction() {
}

public java.util.ArrayList findByQBE(Integer argIdHistArenda, Integer argOrder)
    throws java.lang.Exception {

	ResultSet rs = null;
	PreparedStatement ps = null;
	
    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer("SELECT abh.*, ldp.date actdate, lch.billnumber, lch.billdate, ");
    sb.append(" ldp.summ, ldp.begindate, ldp.enddate, bch.leasebill, cr.shortname crname, res.name resname ");
    sb.append("FROM abonenthistory abh, outer (leasedocpositions ldp, leasecharges lch, currencies cr), ");
    sb.append("outer (bills2charges bch), ");
    sb.append("outer (resources res) ");
    sb.append("WHERE abh.idhistoryarenda = ? AND abh.chargeabonent IS NOT NULL ");
    sb.append(" AND lch.leasedocposition = abh.chargeabonent AND ldp.leasedocposition = lch.leasedocposition ");
    sb.append(" AND bch.leasedocposition = abh.chargeabonent AND bch.resource = abh.resourceabonent ");
    sb.append(" AND cr.currency = ldp.currency ");
    sb.append(" AND res.resource = abh.resourceabonent ");

    //append order by clause
    String orderBy = null;
    switch (argOrder.intValue()) {
        case 1 :
            orderBy = "abh.idhistoryabonent asc";
            break;
        case 2 :
            orderBy = "abh.idhistoryabonent desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

	ArrayList result = new ArrayList();
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    ps = con.prepareStatement(sb.toString());

	    int j = 1;
	    ps.setInt(j++, argIdHistArenda.intValue());

	    rs = ps.executeQuery();

	    while (rs.next()) {
		    DogHistChargeObject dho = new DogHistChargeObject();

		    dho.setActdate(rs.getDate("actdate"));
		    dho.setBillnumber(jcon.getString(rs, "billnumber"));
		    dho.setBilldate(rs.getDate("billdate"));
		    dho.setSumm(rs.getBigDecimal("summ"));
		    dho.setCurrname(jcon.getString(rs, "crname"));
		    dho.setSdate(rs.getDate("begindate"));
		    dho.setEdate(rs.getDate("enddate"));
		    dho.setLeasebill(jcon.getInteger(rs, "leasebill"));
		    dho.setIdchargeabonent(jcon.getInteger(rs, "chargeabonent"));
		    dho.setIdpayabonent(jcon.getInteger(rs, "payabonent"));
		    dho.setIdresourceabonent(jcon.getInteger(rs, "resourceabonent"));
		    dho.setCrate(rs.getBigDecimal("crate"));
		    String s = jcon.getString(rs, "csummbyhand");
			if ("Y".equals(s))
				dho.setSumchanged(true);
			else
				dho.setSumchanged(false);
		    dho.setResname(jcon.getString(rs, "resname"));
		    
		    result.add(dho);
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
 * Insert the method's description here.
 * Creation date: (04.11.2003 14:38:14)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.arenda.actionbean.DogHistChargeListAction";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

	ParamsParser.setState(request, Applications.ARENDA, APPStates.DOG_HIST_CHRG_LIST);
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
	
}
}
