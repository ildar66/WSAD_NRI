package com.hps.july.security.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.security.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;



/**
 * —охранение ролей оператора - множественный выбор.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ProcessOperator2roleMulti extends org.apache.struts.action.Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

		RoleMultiListForm fmo = (RoleMultiListForm)request.getSession().getAttribute( "RoleMultiListForm" );
		Operator2roleListForm fgr = (Operator2roleListForm)request.getSession().getAttribute( "Operator2roleListForm" );
		
	    // Add all role to our operaotor
		for (int i = 0; i<fmo.getSelectedRole().length; i++) {
			String code = fmo.getSelectedRole() [i];
			if ("0".compareTo(code) != 0) {
				int oper = fgr.getOperator();
				try {
					Operators2RolesAccessBean sab = new Operators2RolesAccessBean();
					sab.setInitKey_operator_operator(new Integer(oper));
					sab.setInitKey_role_role(code);
					sab.refreshCopyHelper();

					// If we are here, then role is already in roleslist
					//    - report its name and code
					RoleAccessBean org = new RoleAccessBean();
					org.setInitKey_role(code);
					org.refreshCopyHelper();
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dup.role.multi", code, org.getRolename()));
				} catch(Exception e) {
					try {			
						Operators2RolesAccessBean sab = new Operators2RolesAccessBean(new Integer(oper), code);
					} catch(Exception ex) {
					    ErrorProcessor.processException( errors, ex );
					}
				}
			}
		}
	    
		//process errors
		if( !errors.empty() ) {
			saveErrors(request, errors);
			retVal = mapping.findForward( "errorgoback" );
  		} else {
			retVal = mapping.findForward( "success" ); 
		}
		
	    return retVal;    
	}
}
