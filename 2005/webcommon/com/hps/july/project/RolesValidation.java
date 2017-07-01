package com.hps.july.project;

import org.apache.struts.action.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hps.july.web.util.*;
/**
 * Класс для проверки ролей и прав доступа.
 * Creation date: (12.07.2002 11:41:36)
 * @author: Dmitry Dneprov
 */
public class RolesValidation {
/**
 * RolesValidation constructor comment.
 */
public RolesValidation() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2002 11:46:53)
 */
public static boolean canModify(PageContext pageContext) {
	boolean canEdit = true;
	if (com.hps.july.web.util.Constants.CHECK_ROLES) {
	    ActionForm aform = (ActionForm)pageContext.getAttribute(org.apache.struts.taglib.html.Constants.BEAN_KEY, PageContext.REQUEST_SCOPE);
	    if (aform instanceof BrowseForm) {
		    BrowseForm wrapForm = (BrowseForm)pageContext.getAttribute(org.apache.struts.taglib.html.Constants.BEAN_KEY, PageContext.REQUEST_SCOPE);
			if (wrapForm != null) {
				canEdit = false;
	            HttpServletRequest request =
	                (HttpServletRequest) pageContext.getRequest();
				for (Iterator i = wrapForm.getEditRoles().iterator();i.hasNext();) {
					String role = (String)i.next();
					if (request.isUserInRole(role)) {
						canEdit = true;
						break;
					}
				}
			}
	    }
	}

	return canEdit;

}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2002 11:46:53)
 */
public static boolean canModify(PageContext pageContext, String rolesProperty) {
	boolean canEdit = true;
	if (com.hps.july.web.util.Constants.CHECK_ROLES) {
		canEdit = false;
	    ActionForm aform = (ActionForm)pageContext.getAttribute(org.apache.struts.taglib.html.Constants.BEAN_KEY, PageContext.REQUEST_SCOPE);
	    if (aform != null) {
		    String [] rolesList = null;
		    try {
		    	rolesList = org.apache.struts.util.BeanUtils.getArrayProperty(aform, rolesProperty);
		    } catch (Exception e) {
				e.printStackTrace(System.out);
		    }
			if (rolesList != null) {
	            HttpServletRequest request =
	                (HttpServletRequest) pageContext.getRequest();
				for (int i = 0; i < rolesList.length; i++) {
					String role = rolesList [i];
					if (request.isUserInRole(role)) {
						canEdit = true;
						break;
					}
				}
			}
	    }
	}

	return canEdit;

}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2002 11:46:53)
 */
public static boolean canModify(PageContext pageContext, String rolesProperty,String property) {
	boolean canEdit = true;
	if (com.hps.july.web.util.Constants.CHECK_ROLES) {
		canEdit = false;
	    ActionForm aform = (ActionForm)pageContext.getAttribute(org.apache.struts.taglib.html.Constants.BEAN_KEY, PageContext.REQUEST_SCOPE);
	    if (aform != null) {
		    String [] rolesList = null;
		    try {
		    	rolesList = org.apache.struts.util.BeanUtils.getArrayProperty(aform, rolesProperty);
		    } catch (Exception e) {
				e.printStackTrace(System.out);
		    }
			if (rolesList != null) {
	            HttpServletRequest request =
	                (HttpServletRequest) pageContext.getRequest();
				for (int i = 0; i < rolesList.length; i++) {
					String role = rolesList [i];
					if (request.isUserInRole(role)) {
						canEdit = true;
						break;
					}
				}
			}
	    }
	}

	return canEdit;

}
}
