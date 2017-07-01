package com.hps.july.project;

import java.util.*;
import com.hps.july.persistence.*;

/**
 * Объект-wrapper для класса ProjectAccessBean.
 * Creation date: (04.12.2002 11:35:50)
 * @author: Alexander Shrago
 */
public class ProjectAdv
    extends com.hps.july.persistence.ProjectAccessBean
    implements Securities {

    private Vector actionVector = new Vector();
    public final static String SYMBOL_COMPLETED = "+";
    public final static String SYMBOL_NONE = "x";
    private org.apache.struts.util.MessageResources messageResources;
    private Vector settings;
    private Vector reportRow=new Vector();
    private Vector actionTypeVector;
/**
 * ProtoActionAdv constructor comment.
 */
public ProjectAdv() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 11:45:17)
 * @param protoActionAdv com.hps.july.project.ProtoActionAdv
 */
public ProjectAdv(com.hps.july.persistence.ProjectAccessBean project)
    throws Exception {
    super(project.getEJBRef());

}
/**
 * ProtoActionAdv constructor comment.
 */
public ProjectAdv(javax.ejb.EJBObject o)throws java.rmi.RemoteException {
	super(o);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 22:11:38)
 * @return java.util.Vector
 */
public java.util.Vector getActionVector() {
	return actionVector;
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 20:51:35)
 * @return java.lang.String
 */
public String getBsName() throws Exception {

    int code = getPosition().getStorageplace();
    /*
    StoragePlaceAccessBean storageplace = new StoragePlaceAccessBean();
    storageplace.setInitKey_storageplace(code);
    
    String name1 = "";
    try {
        storageplace.refreshCopyHelper();
        name1 = storageplace.getName();
    } catch (Exception e) {
        name1 = "StoragePlaceBean is invalid";
    }
    */

    String name1 = getPosition().getName();
    String name2 = getPosition().getDampsname();

    return name1
        + ((name2 == null || name2.trim().equals("")) ? "" : ("/" + name2));

}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 20:30:05)
 * @return boolean
 */
public String getCanDelete(javax.servlet.http.HttpServletRequest request) throws Exception {
System.out.println("getCanDelete started");
    String stateId =
        new ProjectStateAccessBean()
            .findCurrentForProject(new Integer(getProject()))
            .getState();
System.out.println("state "+stateId);
    return (stateId.equals("I")
        && Util_Alex.isUserInSecurity(SECURITY_ADMIN, request)) ? "true" : "false";
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 14:18:10)
 * @return java.lang.String
 */
public String getContructerName() throws Exception {
    OrganizationAccessBean bean = getContructer();
    if (bean==null) return "error! there no contructer";
    
    return bean.getName();
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 21:53:55)
 * @return java.lang.String
 */
public java.lang.String getDampsid() throws Exception{
	 Integer c=getPosition().getDampsid();
	 if(c==null)return "";
	 return c.intValue()+"";
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 21:53:55)
 * @return java.lang.String
 */
public java.lang.String getDcsid() throws Exception{
	 Integer c = getPosition().getDcsid();
	 if(c==null)return "";
	 return c.intValue()+"";
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 21:53:55)
 * @return java.lang.String
 */
public java.lang.String getDetails() throws Exception{
	  String c = getPosition().getDetails();
	 if(c==null)return "";
	 return c;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 14:18:10)
 * @return java.lang.String
 */
public String getFullEquipment() throws Exception {

	return "";

	/*
    EquipmentSetAccessBean bean = getEquipment();
    if (bean==null) return "error! there no equipment";
    String equipmentSetName = "";
    
        equipmentSetName =
            com.hps.july.project.EquipmentObject.getEquipmentSetName(bean);
    

    return equipmentSetName;
    */
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 14:18:10)
 * @return java.lang.String
 */
public String getFullPosition() throws Exception {
    
	PositionAccessBean pos = getPosition();
   
    String positionname = pos.getName();
    
    String positionid = "";
    if (pos.getGsmid() != null) {
        positionid = positionid + "D" + pos.getGsmid();
    }
    
    if (pos.getDampsid() != null) {
        positionid = positionid + " A" + pos.getDampsid();
    }
	return positionid + " " + positionname;
    
    
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 21:53:55)
 * @return java.lang.String
 */
public java.lang.String getNotesString() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
	return getNotes()==null?"":new String(super.getNotes());
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 21:37:12)
 * @return java.lang.String
 */
public String getPrintRow() {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 12:40:42)
 * @return java.util.Vector
 */
public java.util.Vector getReportRow() {
	return reportRow;
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 21:26:46)
 * @return java.lang.String
 */
public String getState() throws Exception {

    String stateId =
        new ProjectStateAccessBean()
            .findCurrentForProject(new Integer(getProject()))
            .getState();

    return stateId;

}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 20:36:15)
 */
private void initActionVector(
    Vector actionTypeVector,
    org.apache.struts.util.MessageResources messageResources)
    throws Exception {
    ProjectActionAccessBean action = null;
    Enumeration enum = actionTypeVector.elements();
    java.sql.Date date = null;
    actionVector=new Vector();
    while (enum.hasMoreElements()) {
        try {
            action = new ProjectActionAccessBean(); //temp
            Enumeration enum1 =
                action.findByProjectAndProjectActionType(
                    new Integer(getProject()),
                    new Integer(
                        ((ProjectActionTypeAccessBean) enum.nextElement()).getProjectactiontype()));

            if (enum1 == null||!enum1.hasMoreElements()) {
                throw new javax.ejb.FinderException();
            }
            action = (ProjectActionAccessBean) enum1.nextElement();
            if (action.getFactdate() == null) {
                if (action.getPlandate() == null) {
                    actionVector.add("");
                    continue;
                }
                date = (java.sql.Date) action.getPlandate();
		        GregorianCalendar gc = new GregorianCalendar();
		        gc.setTime(date);
                actionVector.add(
                    gc.get(GregorianCalendar.DAY_OF_MONTH) + messageResources.getMessage("label.month_" + 
	                    gc.get(GregorianCalendar.MONTH)));
                continue;

            } else {
                actionVector.add(SYMBOL_COMPLETED);
            }

        } catch (javax.ejb.FinderException e) {
            actionVector.add(SYMBOL_NONE);
        }

    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 16:12:38)
 * @return boolean
 */
public boolean isFull() throws Exception {

    Enumeration enum1 = new ProjectActionAccessBean().findByProjectOrderByOrderAsc(new Integer(getProject()));
    Enumeration enum2 = new ProtoActionAccessBean().findByProjecttypeOrderByOrderAsc(new Integer(getProjecttype().getProjecttype()));
    int real = 0;
    int templ = 0;
    while (enum1.hasMoreElements()) {
        real++;
        enum1.nextElement();
    }
    while (enum2.hasMoreElements()) {
        templ++;
        enum2.nextElement();
    }

    return real >= templ;

}
}
