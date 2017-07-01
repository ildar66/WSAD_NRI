package com.hps.july.project;

import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.project.*;

/**
 * Список отчетов по план-графику. Устарело. Не используется.
 * @deprecated
 * Creation date: (04.12.2002 11:35:50)
 * @author: Alexander Shrago
 */
public class ReportList   implements com.hps.july.project.Securities{
private ProjectTypeAccessBean projecttype;    

    private Vector actionTypeHeaderVector = new Vector();
    private org.apache.struts.util.MessageResources messageResources;
    private int countCol;
    private javax.servlet.http.HttpServletRequest request;
public ReportList(javax.servlet.http.HttpServletRequest request, org.apache.struts.util.MessageResources resources) {
super();
this.request=request;
messageResources=resources;	
	
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 17:42:51)
 * @return java.util.Vector
 */
private java.util.Vector getActionTypeHeaderVector() {
	
	return actionTypeHeaderVector;
}
/**
 * Insert the method's description here.
 * Creation date: (14.12.2002 15:19:10)
 * @return int
 */
public int getCountCol() {
	return countCol;
}
private java.util.Enumeration getNetzones() {
	try {
		com.hps.july.persistence.NetZoneAccessBean bean = new com.hps.july.persistence.NetZoneAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 17:45:29)
 */
private Vector initActionTypeVector() throws Exception {
    countCol = 0;
    actionTypeHeaderVector = new Vector();
    java.sql.Date date = null;
    Vector actionTypeVector = new Vector();
    ProtoActionAccessBeanTable table = new ProtoActionAccessBeanTable();
    ProtoActionAccessBean protoAction = new ProtoActionAccessBean();
    table.setProtoActionAccessBean(
        protoAction.findByProjecttypeOrderByOrderAsc(
            new Integer(projecttype.getProjecttype())));
    for (int i = 0; i < table.numberOfRows(); i++) {
        countCol++;
        protoAction = table.getProtoActionAccessBean(i);
        ProjectActionTypeAccessBean actionType = protoAction.getProjectActionType();
        actionTypeVector.add(actionType); //actionType

        actionTypeHeaderVector.add(
            actionType.getName()
                + (actionType.getResult() == null ? "" : " (" + actionType.getResult() + ")"));
        //: ("<b>" + actionType.getResult()) + "</b>"));
        //: ("&lt;"+"july:currmark"+"&gt;"+ actionType.getResult()) + "&lt;"+"/july:currmark"+"&gt;"));
        //: ("<july:currmark>"+ actionType.getResult()) + "</july:currmark>"));

    }
    return actionTypeVector;
}
}
