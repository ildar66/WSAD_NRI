package com.hps.july.project;

import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.project.formbean.*;

/**
 * Объект-wrapper для ProjectActionAccessBean.
 * Creation date: (04.12.2002 11:35:50)
 * @author: Alexander Shrago
 */
public class ProjectActionAdv extends ProjectActionAccessBean implements Securities {
public final static String SYMBOL_COMPLETED = "+";
    public final static String SYMBOL_NONE = "x";
/**
 * ProtoActionAdv constructor comment.
 */
public ProjectActionAdv() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 11:45:17)
 * @param protoActionAdv com.hps.july.project.ProtoActionAdv
 */
public ProjectActionAdv(
    com.hps.july.persistence.ProjectActionAccessBean projectAction)
    throws Exception {
    super(projectAction.getEJBRef());
    

}
/**
 * ProtoActionAdv constructor comment.
 */
public ProjectActionAdv(javax.ejb.EJBObject o)throws java.rmi.RemoteException {
	super(o);
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 18:20:55)
 * @return java.lang.String
 */
public String getAgreementString() throws Exception {
    
    return super.getAgreement()==null||!super.getAgreement().booleanValue()?"":"+";

}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 17:20:43)
 * @return java.lang.String
 */
public String getCanDelete(javax.servlet.http.HttpServletRequest request) throws Exception {

    if (Util_Alex.isUserInSecurity(SECURITY_ADMIN, request)) {
        if (getProjectState().equals("A") || getProjectState().equals("F"))
            return "true";
        else
            return "false";

    } else
        return "false";

}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 17:20:43)
 * @return java.lang.String
 */
public String getCanEdit(javax.servlet.http.HttpServletRequest request) throws Exception {

    if (Util_Alex.isUserInSecurity(SECURITY_ADMIN, request)) {
        if (getProjectState().equals("I") || getProjectState().equals("A") || getProjectState().equals("F") )
            return "true";
        else
            return "false";

    } else
        if (Util_Alex.isUserInSecurity(SECURITY_RESPONSIBLE, request)
            && Util_Alex.isUserInDivision(getDivision(), request)) {
            if (getProjectState().equals("I") || getProjectState().equals("A") || getProjectState().equals("F"))
                return "true";
            else
                return "false";
        } else
            return "false";

}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 15:13:02)
 * @return boolean
 */
public int getDivision() throws Exception {

    return getProjectactiontype().getAction2divisionKey().division;

}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 22:25:24)
 * @return java.lang.String
 */
public String getFactdateStr() throws Exception {
    
    return Util_Alex.sqlDateToString(getFactdate());

}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 22:25:24)
 * @return java.lang.String
 */
public String getPlandateStr() throws Exception {

    return Util_Alex.sqlDateToString(getPlandate());

}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 19:06:45)
 * @return java.lang.String
 */
public String getProjectactionStr() throws Exception {
    return String.valueOf(getProjectaction());
      //  ((ProjectActionKey) getEJBRef().getPrimaryKey()).projectaction);
}
/**
 * Gets the projectactiontype property (com.hps.july.persistence.ProjectActionTypeAccessBean) value.
 * @return The projectactiontype property value.
 */
public com.hps.july.persistence.ProjectActionTypeAccessBean getProjectactiontype() throws javax.naming.NamingException, java.rmi.RemoteException,javax.ejb.FinderException {
	return super.getProjectactiontype();
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 17:20:43)
 * @return java.lang.String
 */
public String getProjectState() throws Exception {
    int project = getProjectKey().project;
    return (
        new ProjectStateAccessBean().findCurrentForProject(new Integer(project)))
        .getState();

}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 12:01:42)
 * @return java.lang.String
 */
public String getReportComment() throws Exception {
    return getNotes() == null ? "" : new String(getNotes());

}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 12:01:42)
 * @return java.lang.String
 */
public String getReportMessage(org.apache.struts.util.MessageResources resources) throws Exception {
    if (getFactdate() == null) {
        if (getPlandate() == null) {
            return "";

        } else {
	        GregorianCalendar gc = new GregorianCalendar();
            java.sql.Date date = (java.sql.Date) getPlandate();
            gc.setTime(date);
            return "<font size='2'>"
                + gc.get(GregorianCalendar.DAY_OF_MONTH)    // date.getDate()
                + resources.getMessage("label.month_" + gc.get(GregorianCalendar.MONTH) )+ "</font>";
        }

    } else {
        return "<font size='2'>" + SYMBOL_COMPLETED + "</font>";
    }

    //header.add("<font size='1'>"+"A"+"</font>"); 
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 17:12:41)
 */
public String getResponsableName() throws Exception {
	String wrkname = "";
	try {
		PositionResponsibleWorkersAccessBean poswrk = new PositionResponsibleWorkersAccessBean();
		poswrk.setInitKey_type_responsibilityType(new Integer(getProjectactiontype().getResponsibilitytype().getResponsibilityType()));
		poswrk.setInitKey_position_storageplace(new Integer(getProject().getPosition().getStorageplace()));
		poswrk.setInitKey_resptype("W");
		poswrk.refreshCopyHelper();
		wrkname = poswrk.getWorker().getMan().getLastname();
	} catch (Exception e) {
		// No responsible set - skip
		e.printStackTrace(System.out);
	}
	return wrkname;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 17:12:41)
 */
public String getResult() throws Exception {
	String res=super.getProjectactiontype().getResult();
	return res==null?"":res;
	
	}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 15:48:08)
 * @return java.lang.String
 */
public String getUserComment(javax.servlet.http.HttpServletRequest request) {
	String result = "";
	try {
	    // Get comment for specified point of view
		ProjectListForm plform = (ProjectListForm)request.getSession().getAttribute("projectList");
		ProjectActionCommentsAccessBean comm = new ProjectActionCommentsAccessBean();
		comm.setInitKey_projectaction_projectaction(new Integer(getProjectaction()));
		comm.setInitKey_division_division(plform.getDivcode());
		comm.refreshCopyHelper();
		result = comm.getComment();
	} catch (Exception e) {
		// No comment - suppress
	}
	return result;
}
}
