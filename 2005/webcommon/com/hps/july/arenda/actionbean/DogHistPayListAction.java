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
 * действие для "Лист истории оплат договоров"
 * Creation date: (04.11.2003 14:38:14)
 * @author: Dmitry Dneprov
 */
public class DogHistPayListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Constructor
 * Creation date: (04.11.2003 14:38:44)
 */
public DogHistPayListAction() {
}

public java.util.ArrayList findByQBE(Integer argIdHistArenda, Integer argOrder)
    throws java.lang.Exception {

	ResultSet rs = null;
	PreparedStatement ps = null;
	
    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer("SELECT abh.*, ldp.date paydate, lpm.docnumber, ");
    sb.append(" cr.shortname crname, res.name resname, lpm.paymentstate ");
    sb.append("FROM abonenthistory abh, outer (leasedocpositions ldp, leasepayments lpm), ");
    sb.append("outer (currencies cr), ");
    sb.append("outer (resources res) ");
    sb.append("WHERE abh.idhistoryarenda = ? AND abh.payabonent IS NOT NULL ");
    sb.append(" AND lpm.leasedocposition = abh.payabonent AND ldp.leasedocposition = lpm.leasedocposition ");
    sb.append(" AND cr.currency = abh.currency AND res.resource = abh.resourceabonent ");

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
		    DogHistPayObject dho = new DogHistPayObject();

		    dho.setResname(jcon.getString(rs, "resname"));
		    dho.setState(jcon.getString(rs, "paymentstate"));
		    dho.setNumber(jcon.getString(rs, "docnumber"));
		    dho.setDate(rs.getDate("paydate"));
		    dho.setSumm(rs.getBigDecimal("summ"));
		    dho.setSummrub(rs.getBigDecimal("summrub"));
		    dho.setCurrname(jcon.getString(rs, "crname"));
		    dho.setRate(rs.getBigDecimal("rate"));
		    dho.setIdpayabonent(jcon.getInteger(rs, "payabonent"));
		    dho.setIdresourceabonent(jcon.getInteger(rs, "resourceabonent"));
		    
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
	return "com.hps.july.arenda.actionbean.DogHistPayListAction";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

	ParamsParser.setState(request, Applications.ARENDA, APPStates.DOG_HIST_PAY_LIST);
	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
	
}
}
