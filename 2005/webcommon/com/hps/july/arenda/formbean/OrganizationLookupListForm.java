package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.cdbc.lib.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Bean-form
 * ����� "����� �����������".
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class OrganizationLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String orgname;
	private java.lang.Boolean selissupplier;
	private java.lang.Boolean selisrenter;
	private java.lang.Boolean selisprovider;
	private java.lang.Boolean isorgname;
	private java.lang.Boolean isinn;
	private java.lang.String orginn;
	private java.lang.String sortBy;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public OrganizationLookupListForm() {
    this.setFinderMethodName("findListOrganizations");
    isorgname = java.lang.Boolean.TRUE;
    orgname = "";
    selisprovider = Boolean.FALSE;
    selisrenter = Boolean.FALSE;
    selissupplier = Boolean.FALSE;
    isinn = java.lang.Boolean.FALSE;
    orginn = "";
    sortBy = "name asc";
}
/**
 * ��� ������ ������ ������ ����� �������������� ������������ ������.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
   if (o == null) {
        return o;
    }
    if (!(o instanceof CDBCRowObject)) {
        System.out.println("OrganizationLookupListForm: CLASS_CAST: " + o.getClass().getName());
        return o;
    }
    CDBCRowObject ro = (CDBCRowObject) o;
    OrganizationVO vo = new OrganizationVO((Integer) ro.getColumn("organization").asObject());
    vo.setInn(ro.getColumn("inn").asString());
    vo.setName(ro.getColumn("name").asString());
    vo.setPhone(ro.getColumn("phone").asString());
    vo.setShortname(ro.getColumn("shortname").asString());
    vo.setDirectorfio(ro.getColumn("directorfio").asString());
    vo.setLegaladdress(ro.getColumn("legaladdress").asString());
    vo.setKpp(ro.getColumn("kpp").asString());
    return vo;
}
/**
 * ���������� ��� bean ��� ������.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.arenda.cdbcobjects.CDBC_OrganizationObject";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        isorgname.booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,        orgname,
        selissupplier,
        selisprovider,
        selisrenter,
        isinn.booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,
        orginn,
        getSortBy(),
        };
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:03)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsinn() {
	return isinn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:37:31)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsorgname() {
	return isorgname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:20)
 * @return java.lang.String
 */
public java.lang.String getOrginn() {
	return orginn;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:10:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSelisprovider() {
	return selisprovider;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:09:24)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSelisrenter() {
	return selisrenter;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:08:52)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSelissupplier() {
	return selissupplier;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2005 17:50:29)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * ������������� ������ ��������� ������.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.ORG_LOOKUP);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:03)
 * @param newIsinn java.lang.Boolean
 */
public void setIsinn(java.lang.Boolean newIsinn) {
	isinn = newIsinn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:37:31)
 * @param newIsorgname java.lang.Boolean
 */
public void setIsorgname(java.lang.Boolean newIsorgname) {
	isorgname = newIsorgname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:20)
 * @param newOrginn java.lang.String
 */
public void setOrginn(java.lang.String newOrginn) {
	orginn = newOrginn;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @param newName java.lang.String
 */
public void setOrgname(java.lang.String newName) {
	orgname = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:10:33)
 * @param newIsprovider java.lang.Boolean
 */
public void setSelisprovider(java.lang.Boolean newIsprovider) {
	selisprovider = newIsprovider;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:09:24)
 * @param newIsrenter java.lang.Boolean
 */
public void setSelisrenter(java.lang.Boolean newIsrenter) {
	selisrenter = newIsrenter;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:08:52)
 * @param newIssupplier java.lang.Boolean
 */
public void setSelissupplier(java.lang.Boolean newIssupplier) {
	selissupplier = newIssupplier;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2005 17:50:29)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
}
