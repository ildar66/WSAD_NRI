package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;

/**
 * Action-class.
 * действие для "Лист абонентских договоров"
 * Creation date: (04.10.2002 10:10:20)
 * @author: Sergey Gourov
 */
public class DogAbonentsListAction extends com.hps.july.web.util.BrowseAction {
public Object constructRowModelBean(Object o) {
	if(o instanceof LeaseAbonentBANAccessBean) {
		return new LeaseAbonentBANValue((LeaseAbonentBANAccessBean)o);
	} else {
		return o;
	}
}
public java.util.ArrayList findByContract(
	Integer argContract,
    Integer argOrder) throws Exception {

	ResultSet rs = null;
	PreparedStatement ps = null;
	
    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer("SELECT ld.docnumber, ld.leasedocument ");
    sb.append("FROM leaseabonentban lab, leasedocuments ld ");
    sb.append(" WHERE ld.leasedocument = lab.leasedocument ");
    sb.append(" AND lab.leasedocument IN (SELECT lmc1.contract FROM leasemutcontracts lmc1, leasemutcontracts lmc2 ");
    sb.append("   WHERE lmc1.reglament = lmc2.reglament AND lmc2.contract = ?) ");

    //append order by clause
    String orderBy = null;
    switch (argOrder.intValue()) {
        case 1 :
            orderBy = "ld.docnumber asc";
            break;
        case 2 :
            orderBy = "ld.docnumber desc";
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
	    ps.setInt(j++, argContract.intValue());

	    rs = ps.executeQuery();

	    while (rs.next()) {
		    LeaseAbonentBANAccessBean labo = new LeaseAbonentBANAccessBean();
		    labo.setInitKey_leaseDocument(rs.getInt("leasedocument"));		    
		    result.add(labo);
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
public String getBrowseBeanName() {
	return "com.hps.july.arenda.actionbean.DogAbonentsListAction";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.DOG_ABONENTS_LIST);
	    super.perform(mapping, form, request, response);	
		return mapping.findForward("main");
	}
}
