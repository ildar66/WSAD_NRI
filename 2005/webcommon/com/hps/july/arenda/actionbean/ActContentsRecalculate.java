package com.hps.july.arenda.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import java.sql.*;
import javax.sql.*;

/**
 * Печать параметров акта.
 * Creation date: (30.07.2002 17:33:08)
 * @author: Dmitry Dneprov
 */
public class ActContentsRecalculate extends com.hps.july.web.util.NavigatedAction {
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException {

	super.perform( mapping, form, request, response );
	
	int actCode = Integer.parseInt(request.getParameter("actcode"));
	
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	try {
		con = jcon.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("execute procedure defPosWillBeInAct(" + actCode + ");");
		if (rs.next()) {
			// Error handling
		}
		rs.close();
		
	} catch (Exception e) {
		e.printStackTrace(System.out);
	} finally {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
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
	
	return  mapping.findForward("success");
}
}
