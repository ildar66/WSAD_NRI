package com.hps.july.siteinfo.formbean;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;

/**
 * ����� ������ ���� ���������� ����.
 */
public class OporaPlacesListForm extends com.hps.july.web.util.BrowseForm {
public OporaPlacesListForm() {
	this.setFinderMethodName( "findAllOporaPlaces" );
	setLastVisited(true);
}
/**
 * ���������� ��� bean ��� ������.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCPositionObject";
}
/**
 * ������ �����, ������� ����������� ��������������.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	return roles;
}
/**
 * ������ ���������� ������.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
/**
 * ������������� ������.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request,
    	HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.SITEINFO, APPStates.OPORAPLACESLIST );
	return null; 
}
}
