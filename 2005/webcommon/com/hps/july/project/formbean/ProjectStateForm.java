package com.hps.july.project.formbean;

import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.ValidationException;
import com.hps.july.project.*;
import com.hps.july.web.util.*;

/**
 * Форма изменения состояния проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class ProjectStateForm extends EditForm {
    
    private String projectstate;
    private String projectName;
    private String positionName;
    private String contructerName;
    private int projectParameter;
    
    
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 14:32:25)
 * @return java.lang.String
 */
public java.lang.String canState() throws Exception{

    ProjectActionAccessBean projectAction = new ProjectActionAccessBean();
    ProjectActionAccessBeanTable table = new ProjectActionAccessBeanTable();
    table.setProjectActionAccessBean(
        projectAction.findByProjectOrderByOrderAsc(new Integer(projectParameter)));
    for (int i = 0; i < table.numberOfRows(); i++) {
        //if (table.getProjectActionAccessBean(i).getFactdate() == null) {
        if ( (table.getProjectActionAccessBean(i).getCompleted() == null) || 
	        (!table.getProjectActionAccessBean(i).getCompleted().booleanValue())) {
            return "false";
        }
    }

    return "true";
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {

    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    int code = keygen.getNextKey(TablesRef.PROJECTSTATES);

    String login = request.getRemoteUser();
    //String login = "dima";
    OperatorAccessBean operator = new OperatorAccessBean().findByLogin(login);

    ProjectStateAccessBean projectstateBean =
        new ProjectStateAccessBean(
            code,
            getProjectstate(),
            operator.getMan().getMan(),
            new java.sql.Timestamp(System.currentTimeMillis()),
            getProjectParameter());
    return projectstateBean;
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
System.out.println("fillRecord started");
    try {
        projectstate = ((ProjectStateAccessBean) bean).getState();
    } catch (Exception e) {
        Util_Alex.pr(e, "fillRecord", this);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.PROJECT;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 18:31:24)
 * @return java.lang.String
 */
public java.lang.String getContructerName() {
	return contructerName;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
    ProjectStateAccessBean bean = null;
    try {
        bean =
            new ProjectStateAccessBean().findCurrentForProject(
                new Integer(getProjectParameter()));
    } catch (Exception e) {
        Util_Alex.pr(e, "getDataBean", this);
    }
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 20:05:56)
 * @return java.lang.String
 */
public java.lang.String getPositionName() {
	return positionName;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 20:05:56)
 * @return java.lang.String
 */
public java.lang.String getProjectName() {
	return projectName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 19:48:49)
 * @return int
 */
public int getProjectParameter() {
	return projectParameter;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 19:23:22)
 * @return java.lang.String
 */
public java.lang.String getProjectstate() {
	return projectstate;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	setAction("Add");
	return com.hps.july.project.APPStates.PROJECTSTATEFORM;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 12:02:44)
 * @param newContructerName java.lang.String
 */
public void setContructerName(java.lang.String newContructerName) {
	contructerName = newContructerName;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 12:02:34)
 * @param newPositionName java.lang.String
 */
public void setPositionName(java.lang.String newPositionName) {
	positionName = newPositionName;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 19:03:50)
 * @param newProject com.hps.july.persistence.Project
 */
public void setProject(com.hps.july.persistence.ProjectAccessBean projectBean) throws Exception {
	
 	Project project=(Project)projectBean.getEJBRef();
 
	//projectName = project.getName();
	projectName = project.getProjecttype().getName();

    contructerName=project.getContructer().getName();
    
    
    //EquipmentSetAccessBean equipment =
    //    new EquipmentSetAccessBean(project.getEquipment());
    //equipmentName = "";
    //    com.hps.july.project.EquipmentObject.getEquipmentSetName(
    //        equipment);

    String positionname = null;
    String positionid = null;

    //PositionAccessBean pos = equipment.getPosition();
    PositionAccessBean pos = projectBean.getPosition();
    
    positionname = pos.getName();
    positionid = "";
    if (pos.getGsmid() != null) {
        positionid = positionid + "D" + pos.getGsmid();
    }
    positionid = positionid + " ";
    if (pos.getDampsid() != null) {
        positionid = positionid + "A" + pos.getDampsid();
    }
    positionName=positionname+" "+positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 12:01:53)
 * @param newProjectName java.lang.String
 */
public void setProjectName(java.lang.String newProjectName) {
	projectName = newProjectName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 19:48:49)
 * @param newProjectParameter int
 */
public void setProjectParameter(int newProjectParameter) {
	projectParameter = newProjectParameter;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 19:23:22)
 * @param newProjectstate java.lang.String
 */
public void setProjectstate(java.lang.String newProjectstate) {
	projectstate = newProjectstate;
}
public void validateValues(ActionErrors errors) throws Exception {
    try {
        if (!getProjectstate().equals("D"))
            return;
        ProjectActionAccessBean projectAction = new ProjectActionAccessBean();
        ProjectActionAccessBeanTable table = new ProjectActionAccessBeanTable();

        table.setProjectActionAccessBean(
            projectAction.findProjectActionsByProject(
                new ProjectKey(getProjectParameter())));

        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getProjectActionAccessBean(i).getFactdate() == null) {
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectstate.D"));
                throw new ValidationException();

            }

        }
    } catch (Exception e) {
        Util_Alex.pr(e, "validateValues", this);
        throw e;
    }
}
}
