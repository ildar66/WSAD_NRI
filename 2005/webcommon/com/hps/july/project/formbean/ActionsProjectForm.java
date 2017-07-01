package com.hps.july.project.formbean;

import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.ValidationException;
import com.hps.july.project.*;
import com.hps.july.web.util.*;

/**
 * Форма добавления события к типу проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class ActionsProjectForm extends EditForm {
    //from Access Bean fields
    private StringAndIntegerProperty order = new StringAndIntegerProperty();
    private String stepbefore_Order;
    private StringAndIntegerProperty duration = new StringAndIntegerProperty();
    private ProjectActionType projectActionType;
    private String projectActionType_Name;
    private int projectActionType_Code;
    private StringAndIntegerProperty stepbefore;
    //init for finderExcept... method
    private int projectaction=0;
private com.hps.july.persistence.ProjectType projectType;
							private org.apache.struts.util.MessageResources messageResources;	
	private java.lang.String divisionname;
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {

    //KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    //projecttype = keygen.getNextKey("tables.projecttype");
    //ProjectTypeAccessBean bean = new ProjectTypeAccessBean(projecttype, name);
    //return bean;

    //ActionsProjectListForm aform =
    //    (ActionsProjectListForm) request.getSession().getAttribute(
    //        "actionsProjectForm");
    //setProjecttype(aform.getProjecttype());

    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    setProjectaction(keygen.getNextKey(TablesRef.PROTOACTIONS_PK));
    if (order.isEmpty()) {
	    setOrder(
	        keygen.getNextKey(
	            TablesRef.PROTOACTIONS_ORDER + new Integer(projectType.getProjecttype()).toString()));
    }

    ProtoActionAccessBean bean =
        new ProtoActionAccessBean(
            getProjectaction(),
            getOrder(),
            projectType.getProjecttype(),
            projectActionType_Code,
            getDuration());

    return bean;
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
    try {
        

        ProtoActionAccessBean pBean = (ProtoActionAccessBean) bean;
        if (pBean.getStepbefore() == null) {
            stepbefore_Order = "0";
        } else {
            ProtoActionAccessBean sBean = new ProtoActionAccessBean();
            sBean.setInitKey_projectaction(pBean.getStepbefore().intValue());
            sBean.refreshCopyHelper();
            setStepbefore_Order(new Integer(sBean.getOrder()).toString());
        }
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
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {

    ProtoActionAccessBean bean = new ProtoActionAccessBean();
    bean.setInitKey_projectaction(getProjectaction());
    

    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 11:57:03)
 * @return java.lang.String
 */
public java.lang.String getDivisionname() {
	return divisionname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @return int
 */
public int getDuration() {
	return duration.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @return int
 */
public String getDurationString() {
	return duration.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @return int
 */
public int getOrder() {
	return order.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @return int
 */
public String getOrderString() {
	return order.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2002 19:39:23)
 * @return int
 */
public int getProjectaction() {
	return projectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:50:34)
 * @return com.hps.july.persistence.ProjectActionType
 */
public com.hps.july.persistence.ProjectActionType getProjectActionType()throws Exception {
	return projectActionType;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:50:34)
 * @return int
 */
public int getProjectActionType_Code()throws Exception {
	return projectActionType_Code;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:50:34)
 * @return java.lang.String
 */
public java.lang.String getProjectActionType_Name() throws Exception {
	return projectActionType_Name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.ACTIONSPROJECTFORM;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @return int
 */
public Integer getStepbefore() throws java.rmi.RemoteException{
	return stepbefore==null?null:stepbefore.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:50:34)
 * @return int
 */
public String getStepbefore_Order() throws Exception{
	return stepbefore_Order;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @return int
 */
public int getStepbeforeInt() throws java.rmi.RemoteException{
	return stepbefore==null?0:stepbefore.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @return int
 */
public String getStepbeforeString() throws java.rmi.RemoteException{
	return stepbefore==null?"":stepbefore.getString().trim();
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {
    setProjectActionType_Code(0);
    setProjectActionType_Name("");
    setOrderString("");
    setStepbeforeString("");
    setDurationString("0");
    setStepbefore_Order("0");
    projectType =
        (ProjectType) (((ProjectTypeAccessBean) request
            .getSession()
            .getAttribute("projecttypeBean"))
            .getEJBRef());
    setProjectaction(0);

    // Calculate new order
    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    setOrder(
        keygen.getNextKey(
            TablesRef.PROTOACTIONS_ORDER + new Integer(projectType.getProjecttype()).toString()));

}
private ProjectActionType receiveProjectActionTypeBean() throws Exception {

    ProjectActionTypeAccessBean ab = new ProjectActionTypeAccessBean();
    ab.setInitKey_projectactiontype(projectActionType_Code);
    ab.refreshCopyHelper();
    projectActionType=(ProjectActionType) ab.getEJBRef();
    return projectActionType;

}
private ProtoAction receiveStepbeforeProtoAction() throws Exception {

     if (stepbefore == null) {
        return null;
    }
    ProtoActionAccessBean ab = new ProtoActionAccessBean();
    ab.setInitKey_projectaction(stepbefore.getInteger().intValue());
    ab.refreshCopyHelper();
    return (ProtoAction) ab.getEJBRef();
    

}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 11:57:03)
 * @param newDivisionname java.lang.String
 */
public void setDivisionname(java.lang.String newDivisionname) {
	divisionname = newDivisionname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @param newDuration int
 */
public void setDuration(int newDuration) {
	duration.setInteger(new Integer(newDuration));
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @param newDuration int
 */
public void setDurationString(String newDuration) {
	duration.setString(newDuration);
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @param newOrder int
 */
public void setOrder(int newOrder) {
	order.setInteger(new Integer(newOrder));
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 15:01:39)
 * @param newDuration int
 */
public void setOrderString(String newOrder) {
	order.setString(newOrder);
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2002 19:39:23)
 * @param newProjectaction int
 */
public void setProjectaction(int newProjectaction) {
	projectaction=newProjectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:50:34)
 * @param newProjectActionTypeBean com.hps.july.persistence.ProjectActionType
 */
public void setProjectActionType(com.hps.july.persistence.ProjectActionTypeAccessBean bean) throws Exception{
	projectActionType_Code=bean.getProjectactiontype();
	projectActionType_Name=bean.getName() + " / " + bean.getResult();
	setDivisionname(bean.getAction2division().getName());
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:50:34)
 * @param newProjectActionType_Code int
 */
public void setProjectActionType_Code(int newProjectActionType_Code) {
	projectActionType_Code=newProjectActionType_Code;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:50:34)
 * @param newProjectActionType_Name java.lang.String
 */
public void setProjectActionType_Name(java.lang.String newProjectActionType_Name) {
	projectActionType_Name = Util_Alex.convertString(newProjectActionType_Name);
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 14:37:29)
 * @param newProjectType com.hps.july.persistence.ProjectType
 */
public void setProjectType(com.hps.july.persistence.ProjectType newProjectType) {
	projectType = newProjectType;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @param newStepbefore_Code int
 */
public void setStepbefore(Integer newStepbefore) {

    if (newStepbefore != null) {
        stepbefore = new StringAndIntegerProperty();
        stepbefore.setInteger(newStepbefore);
    }else stepbefore=null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @param newStepbefore_Code int
 */
public void setStepbefore_Order(String order) {
        stepbefore_Order = order;
  
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @param newStepbefore_Code int
 */
public void setStepbeforeInt(int newStepbefore) {

    if (newStepbefore == 0) {
        stepbefore = null;
    } else {
        stepbefore = new StringAndIntegerProperty();
        stepbefore.setInteger(new Integer(newStepbefore));

    }
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @param newStepbefore_Code int
 */
public void setStepbeforeInt(String newStepbefore) {

    if (newStepbefore == null || newStepbefore.equals("")) {
        stepbefore = null;
    } else {
        stepbefore = new StringAndIntegerProperty();
        stepbefore.setString(newStepbefore);

    }
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:27:20)
 * @param newStepbefore_Code int
 */
public void setStepbeforeString(String newStepbefore) {

    if (newStepbefore == null || newStepbefore.equals("")||newStepbefore.equals("0")) {
        stepbefore = null;
    } else {
        stepbefore = new StringAndIntegerProperty();
        stepbefore.setString(newStepbefore.trim());

    }
}
public void validateValues(ActionErrors errors) throws Exception {

    if ( !order.isEmpty() && !order.isOk() )
     errors.add(
        ActionErrors.GLOBAL_ERROR,
        new ActionError("error.invalid.projectaction.order"));

    try {
        receiveProjectActionTypeBean();
    } catch (Exception e1) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.invalid.projectaction.projectactiontype"));
    }
    try {
        receiveStepbeforeProtoAction();
    } catch (Exception e2) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.invalid.projectaction.stepbefore"));
    }

    if ((!duration.isOk()) || (duration.isEmpty()))
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.invalid.projectaction.duration"));

    if (!errors.empty())
        throw new ValidationException();

}
}
