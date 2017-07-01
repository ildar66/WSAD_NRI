package com.hps.july.dictionary.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.dictionary.formbean.*;
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
 * Обработчик формы включения юр. лиц в группы
 */
public class ProcessOrganizationMulti
	extends NavigatedAction
{
public boolean isAddtoHistory() {
	return false;
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

		OrganizationMultiListForm fmo = (OrganizationMultiListForm)request.getSession().getAttribute( "OrganizationMultiListForm" );
		GrouporgListForm fgr = (GrouporgListForm)request.getSession().getAttribute( "GrouporgListForm" );
		
	    // Add all organizations to our group
		for (int i = 0; i<fmo.getSelectedOrg().length; i++) {
			int code = fmo.getSelectedOrg() [i];
			if (code != 0) {
				int group = fgr.getSearchgroup();
				int groupping = fgr.getSearchgroupping();
				try {
					SearchesAccessBean sab = new SearchesAccessBean();
					sab.setInitKey_group_searchgroup(new Integer(group));
					sab.setInitKey_organization_organization(new Integer(code));
					sab.refreshCopyHelper();

					// If we are here, then organization is already in searches
					//   for another group - report its name and code
					OrganizationAccessBean org = new OrganizationAccessBean();
					org.setInitKey_organization(code);
					org.refreshCopyHelper();
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dup.grouporg.group.multi", new Integer(code), org.getName()));
				} catch(Exception e) {
					try {			
						SearchesAccessBean sab = new SearchesAccessBean(new Integer(group), new Integer(groupping), 
							new Integer(code), new Integer(1));
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
