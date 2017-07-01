package com.hps.july.inventory.formbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.web.util.*;
import com.hps.july.inventory.APPStates;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCComProjectsObject;
import com.hps.july.constants.Applications;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * ������ ���������� �� �������
 */
public class DocsByComprojectListForm extends BrowseForm {

	private Integer projectid;

	public DocsByComprojectListForm() {
		projectid = new Integer(0);
	}

	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("TechStuff");
		roles.add("siteExploitor");
		roles.add("siteStation");
		roles.add("siteTransport");
		roles.add("BSProjectUser");
		roles.add("BSProjectAdmin");
		roles.add("BSProjectManager");
		return roles;
	}

	/**
	 * ��������� ������� ������ ����������
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object [] { projectid, new Integer(1) };
	}

	/**
	 * ����� ������ ����������
	 */
	public String getFinderMethodName() {
		return "listDocsByProject";
	}

	/**
	 * ���������� ��� bean ��� ������.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCComProjectsObject";
	}
	
	/**
	 * ��� ������� �� �������������/������������ ��
	 * @return
	 */
	public Integer getProjectid() {
		return projectid;
	}

	/**
	 * ��� ������� �� �������������/������������ ��
	 * @param integer
	 */
	public void setProjectid(Integer integer) {
		projectid = integer;
	}
	
	/**
	 * ������������ ������� �� �������������/������������ ��
	 * @param integer
	 */
	public String getProjectname() {
		CDBCRowObject ro = CDBCComProjectsObject.findByPrimaryKey(getProjectid());
		if (ro != null)
			return ro.getColumn("name").asString();
		else return "";
	}
	
	/**
	 * ������������� ������ ��������� ������.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
				ParamsParser.setState(request, Applications.INVENTORY, APPStates.DOCSBYCOMPROJLIST);
		return null;
	}

}
