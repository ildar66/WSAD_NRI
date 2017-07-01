package com.hps.july.project.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.ValidationException;
import com.hps.july.project.*;
import com.hps.july.web.util.*;
import com.hps.july.commonbean.*;
import java.util.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * Форма редактирования события проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class ProjectActionForm extends EditForm implements Securities{
    private Vector projectactiontypes = new Vector();
    private java.util.Vector equipments;
    private int projectaction;
    private int order;
    private java.sql.Date plandate;
    private StringAndSqlDateProperty suggplandate = new StringAndSqlDateProperty();
    private StringAndSqlDateProperty factdate = new StringAndSqlDateProperty();
    private ProjectActionType projectactiontype;
    private EquipmentSet equipment;
    private StringAndIntegerProperty projectactiontypeCode =
        new StringAndIntegerProperty();
    private Boolean agreement;
    private String noteStr;
	private com.hps.july.project.ProjectAdv fieldProject = new ProjectAdv();
	private boolean hasproblems;
	private Integer equipmentcode;
	private boolean haveequipment;
	private java.lang.String departmentname;
	private java.lang.String responsiblename;
	private java.lang.Integer stdduration;
	private boolean caneditform;
	private java.lang.String projectactiontypeName;
	private int projectCode;
	private java.lang.Boolean completed;
	private java.lang.Boolean isNewplandate;
	private int projecttype;
	private javax.servlet.http.HttpServletRequest locrequest;
	private int storageplace;
	private java.lang.String fullPosition;
	private java.lang.String notes;
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 17:58:10)
 */
public ProjectActionForm() {
	caneditform = false;
	setEquipmentcode(null);
	setHaveequipment(false);
	setNoteStr("");
	setDepartmentname("");
	setResponsiblename("");
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {

	// Update comment for specified point of view
	ProjectListForm plform = (ProjectListForm)request.getSession().getAttribute("projectList");
	System.out.println("PROJECT: Storing comment for division = "  + plform.getDivcode());
	try {
	    // Get comment for specified point of view
		ProjectActionCommentsAccessBean comm = new ProjectActionCommentsAccessBean();
		comm.setInitKey_projectaction_projectaction(new Integer(getProjectaction()));
		comm.setInitKey_division_division(plform.getDivcode());
		comm.refreshCopyHelper();

		// Update comment
		comm.setComment(getNoteStr());
		comm.commitCopyHelper();
		
	} catch (javax.ejb.ObjectNotFoundException e) {
		ProjectActionCommentsAccessBean comm = new ProjectActionCommentsAccessBean(getProjectaction(), plform.getDivcode().intValue());
		comm.setComment(getNoteStr());
		comm.commitCopyHelper();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
		
    // Delete comment for ALL points of view  - Change to finder
	ProjectListForm plform = (ProjectListForm)request.getSession().getAttribute("projectList");
	javax.naming.InitialContext ctx = new javax.naming.InitialContext();
	javax.transaction.UserTransaction transact = (javax.transaction.UserTransaction)ctx.lookup("jta/usertransaction");
	transact.begin();
	try {
		Enumeration en = new ProjectActionCommentsAccessBean().findProjectActionCommentsByProjectaction(new ProjectActionKey(getProjectaction()));
		while (en.hasMoreElements()) {
			ProjectActionCommentsAccessBean comm = (ProjectActionCommentsAccessBean)javax.rmi.PortableRemoteObject.narrow(en.nextElement(), ProjectActionCommentsAccessBean.class);
			comm.getEJBRef().remove();
		}
		transact.commit();
		
	} catch (Exception e) {
		transact.rollback();
		e.printStackTrace(System.out);
	}
		
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {

		if (getSuggplandate() != null) {
			if (!getSuggplandate().equals(getPlandate())) {
				setIsNewplandate(Boolean.TRUE);
				((ProjectActionAccessBean)bean).setIsNewplandate(Boolean.TRUE);
			}
		} else if (getPlandate() != null) {
			setIsNewplandate(Boolean.TRUE);
			((ProjectActionAccessBean)bean).setIsNewplandate(Boolean.TRUE);
		}
}
/**
 * Determines if the field can be edited
 * Creation date: (24.12.2002 10:43:01)
 * @param field java.lang.String
 */
public String canEditField(
    String field,
    javax.servlet.http.HttpServletRequest request)
    throws Exception {


	String result = "true";

    String state =
        (new ProjectStateAccessBean()
            .findCurrentForProject(new Integer(getProjectCode())))
            .getState();

    if (Util_Alex.isUserInSecurity(SECURITY_ADMIN, request)) {

            if (state.equals("D")) {
                result = "false";
            }
            
    } else if (Util_Alex.isUserInSecurity(SECURITY_RESPONSIBLE, request)) {

            if (state.equals("D")) {
                result = "false";
            } else {
                if (field.equals("notes"))
                    result = "true";
                else if (caneditform && (field.equals("plandate") ||
	                field.equals("factdate") ||
                    field.equals("completed") ||
                    field.equals("agreement") ||
                    field.equals("hasproblems") )
                   )
                    result = "true";
                else
                    result = "false";
            }

    }
	System.out.println("CANEDIT: field=" + field + ", result=" + result);
    return result;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {
	    
    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    setProjectaction(keygen.getNextKey(TablesRef.PROJECTACTIONS));

    ProjectActionAccessBean bean =
        new ProjectActionAccessBean(
            projectaction,
            getProjectCode(),
            projectactiontype.getProjectactiontype(),
            order, false);
    bean.setFactdate(null);

    return bean;

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
	
    try {
        ProjectActionAdv pa = (ProjectActionAdv) bean;
    	projectactiontypes.add(pa.getProjectactiontype());
    } catch (Exception e) {
        Util_Alex.pr(e, "fillRecord", this);
    }

	try {
		PositionResponsibleWorkersAccessBean poswrk = new PositionResponsibleWorkersAccessBean();
		poswrk.setInitKey_type_responsibilityType(new Integer(getProjectactiontype().getResponsibilitytype().getResponsibilityType()));
		poswrk.setInitKey_position_storageplace(new Integer(getStorageplace()));
		poswrk.setInitKey_resptype("W");
		poswrk.refreshCopyHelper();
		setResponsiblename(poswrk.getWorker().getMan().getFullName());
	} catch (Exception e) {

		// No responsible set - skip
	}
	
	try {
		setDepartmentname(getProjectactiontype().getAction2division().getName());
	} catch (Exception e) {
		setDepartmentname("");
		e.printStackTrace(System.out);
	}
	
	try {
		java.util.Enumeration en = new ProtoActionAccessBean().findByProjectactiontypeOrderByOrderAsc(projectactiontypeCode.getInteger());
		if (en.hasMoreElements()) {
			ProtoActionAccessBean paction = (ProtoActionAccessBean)en.nextElement();
			setStdduration(new Integer(paction.getDuration()));
		}
	} catch (Exception e) {
		setStdduration(null);
		e.printStackTrace(System.out);
	}
	
	try {
	    // Get comment for specified point of view
		ProjectListForm plform = (ProjectListForm)locrequest.getSession().getAttribute("projectList");
		ProjectActionCommentsAccessBean comm = new ProjectActionCommentsAccessBean();
		comm.setInitKey_projectaction_projectaction(new Integer(getProjectaction()));
		comm.setInitKey_division_division(plform.getDivcode());
		comm.refreshCopyHelper();
		setNoteStr(comm.getComment());
	} catch (Exception e) {
		setNoteStr("");
	}

	try {
		    ProjectAdv pbean = new ProjectAdv();
		    pbean.setInitKey_project(projectCode);
		    pbean.refreshCopyHelper();
		    setFullPosition(pbean.getFullPosition());
	} catch (Exception e) {
		// Ignore error
		    setFullPosition("");
	}
	
	locrequest = null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 22:00:31)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getAgreement() {
	return agreement;
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
 * Creation date: (04.09.2003 14:22:03)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCompleted() {
	return completed;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {

	locrequest = request;
	
    ProjectActionAdv bean = new ProjectActionAdv();
    try {
        bean.setInitKey_projectaction(projectaction);
        bean.refreshCopyHelper();
        setPlandate(bean.getPlandate());
        setIsNewplandate(bean.getIsNewplandate());
    	caneditform = new Boolean(bean.getCanEdit(request)).booleanValue();
    	if (!caneditform) {
	    	setAgreement(bean.getAgreement());
	    	setCompleted(bean.getCompleted());
	    	setEquipment(bean.getEquipment());
	    	setFactdate(bean.getFactdate());
	    	setHasproblems(bean.getHasproblems());
	    	setSuggplandate(bean.getSuggplandate());
    	}
    } catch (Exception e) {
        Util_Alex.pr(e, "getDataBean", this);
    }
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 13:53:50)
 * @return java.lang.String
 */
public java.lang.String getDepartmentname() {
	return departmentname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 22:49:36)
 * @return com.hps.july.persistence.ProjectActionType
 */
public com.hps.july.persistence.EquipmentSet getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 16:08:47)
 * @return int
 */
public Integer getEquipmentcode() {
	return equipmentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 18:41:26)
 * @return java.util.Vector
 */
public java.util.Enumeration getEquipments() {
	return Collections.enumeration(equipments);
}
	public java.sql.Date getFactdate() {
	return factdate.getSqlDate();
}
public String getFactdateStr() {
	return factdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {};
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 19:21:53)
 * @return java.lang.String
 */
public java.lang.String getFullPosition() {
	return fullPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 16:07:29)
 * @return boolean
 */
public boolean getHasproblems() {
	return hasproblems;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 11:23:13)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsNewplandate() {
	return isNewplandate;
}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2003 11:05:21)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 15:33:23)
 * @return java.lang.String
 */
public java.lang.String getNoteStr() {
	return noteStr;
}
	public java.sql.Date getPlandate() {
	return plandate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 17:42:19)
 * @return int
 */
public int getProjectaction() {
	return projectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 22:49:36)
 * @return com.hps.july.persistence.ProjectActionType
 */
public com.hps.july.persistence.ProjectActionType getProjectactiontype() {
	return projectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 11:47:16)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getProjectactiontypeCode() {
	return projectactiontypeCode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 16:56:54)
 * @return java.lang.String
 */
public java.lang.String getProjectactiontypeName() {
	return projectactiontypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 18:41:26)
 * @return java.util.Vector
 */
public java.util.Vector getProjectactiontypes() {
	return projectactiontypes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2003 17:24:00)
 * @return int
 */
public int getProjectCode() {
	return projectCode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:54:25)
 * @return int
 */
public int getProjecttype() {
	return projecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 13:54:16)
 * @return java.lang.String
 */
public java.lang.String getResponsiblename() {
	return responsiblename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.PROJECTACTIONFORM;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 13:55:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getStdduration() {
	return stdduration;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 15:25:28)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
	public java.sql.Date getSuggplandate() {
	return suggplandate.getSqlDate();
}
public String getSuggplandateStr() {
	return suggplandate.getString();
}
public void initCollections(javax.servlet.http.HttpServletRequest request)
    throws Exception {

    initProjectactiontypes(request);
    initEquipments(request);
}
private void initEquipments(
    javax.servlet.http.HttpServletRequest request)
    throws Exception {

    //receive project
    //ProjectActionListForm listForm =
        //(ProjectActionListForm) request.getSession().getAttribute("projectActionList");
    //projecttype = listForm.getProjecttype();
	//storageplace = listForm.getStorageplace();

    //receive project
    
    try {
	    ProjectAccessBean aprj = null;
	    if (getProjectaction() != 0) {
		    ProjectActionAccessBean pab = new ProjectActionAccessBean();
		    pab.setInitKey_projectaction(getProjectaction());
		    pab.refreshCopyHelper();
		    aprj = pab.getProject();
		    setProjectCode(aprj.getProject());
	    } else {
		    aprj = new ProjectAccessBean();
		    aprj.setInitKey_project(getProjectCode());
		    aprj.refreshCopyHelper();
	    }
	    
	    projecttype = aprj.getProjecttype().getProjecttype();
		storageplace = aprj.getPosition().getStorageplace();
		
    } catch (Exception e) {
	    e.printStackTrace(System.out);
	    projecttype = 0;
	    storageplace = 0;
    }
        
    equipments = new java.util.Vector();
    Enumeration en = new EquipmentSetAccessBean().findEquipmentSetByPosition(new StoragePlaceKey(storageplace));
    while (en.hasMoreElements()) {
	    EquipmentValue oo = new EquipmentValue((EquipmentSetAccessBean)en.nextElement());
    	equipments.add(oo);
    }
}
private void initProjectactiontypes(
    javax.servlet.http.HttpServletRequest request)
    throws Exception {

    ProjectActionTypeAccessBean actionType;
    projectactiontypes = new Vector();
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {

	caneditform = true;
    projectaction = 0;
    order = 0;
    //projectactiontypeCode = new StringAndIntegerProperty();

    //suggplandate = new StringAndSqlDateProperty();
    //factdate = new StringAndSqlDateProperty();

    noteStr = "";
    agreement = Boolean.FALSE;

	//ProjectActionListForm aform = (ProjectActionListForm)request.getSession().getAttribute("projectActionList");
	//project = aform.getProjectParameter();
	//setProjectCode(project);
	setIsNewplandate(Boolean.FALSE);

	try {
		    ProjectActionTypeAccessBean bean = new ProjectActionTypeAccessBean();
		    bean.setInitKey_projectactiontype(projectactiontypeCode.getInteger().intValue());
		    bean.refreshCopyHelper();
		    setProjectactiontypeName(bean.getName());
	} catch (Exception e) {
		// Ignore error
	}
	
	try {
		    ProjectAdv bean = new ProjectAdv();
		    bean.setInitKey_project(projectCode);
		    bean.refreshCopyHelper();
		    setFullPosition(bean.getFullPosition());
	} catch (Exception e) {
		// Ignore error
		    setFullPosition("");
	}

}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 16:07:29)
 * @return boolean
 */
public boolean isHasproblems() {
	return hasproblems;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 11:29:15)
 * @return boolean
 */
public boolean isHaveequipment() {
	return haveequipment;
}
public EquipmentSet receiveEquipment()
    throws java.lang.Exception {
    EquipmentSetAccessBean bean = new EquipmentSetAccessBean();
    if (getEquipmentcode() != null)
    	bean.setInitKey_storageplace(getEquipmentcode().intValue());
    else
    	bean.setInitKey_storageplace(0);
    bean.refreshCopyHelper();
    return (EquipmentSet)bean.getEJBRef();
}
public int receiveOrder() throws java.lang.Exception {
    if (order != 0)
        return order;

    ProtoActionAccessBean protoAction = new ProtoActionAccessBean();
    ProtoActionAccessBeanTable table = new ProtoActionAccessBeanTable();
    table.setProtoActionAccessBean(
        protoAction.findProtoActionsByProjectType(new ProjectTypeKey(getProjecttype())));

    for (int i = 0; i < table.numberOfRows(); i++) {
        protoAction = table.getProtoActionAccessBean(i);
        if (protoAction.getProjectActionType().getProjectactiontype()
            == projectactiontype.getProjectactiontype()) {
            return protoAction.getOrder();
        }

    }
    throw new Exception("projectActionForm.receiveOrder()");

}
public ProjectActionType receiveProjectactiontype()
    throws java.lang.Exception {
    ProjectActionTypeAccessBean bean = new ProjectActionTypeAccessBean();
    bean.setInitKey_projectactiontype(projectactiontypeCode.getInteger().intValue());
    bean.refreshCopyHelper();
    return (ProjectActionType)bean.getEJBRef();
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 22:00:31)
 * @param newAgreement java.lang.Boolean
 */
public void setAgreement(java.lang.Boolean newAgreement) {
	agreement = newAgreement;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2003 14:22:03)
 * @param newCompleted java.lang.Boolean
 */
public void setCompleted(java.lang.Boolean newCompleted) {
	completed = newCompleted;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 13:53:50)
 * @param newDepartmentname java.lang.String
 */
public void setDepartmentname(java.lang.String newDepartmentname) {
	departmentname = newDepartmentname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 22:49:36)
 * @param newProjectActionType com.hps.july.persistence.ProjectActionType
 */
public void setEquipment(com.hps.july.persistence.EquipmentSetAccessBean bean)throws Exception {
	if (bean != null) {
		setEquipmentcode(new Integer(bean.getStorageplace()));
		setHaveequipment(true);
	} else {
		setEquipmentcode(null);
		setHaveequipment(false);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 16:08:47)
 * @param newEquipmentcode int
 */
public void setEquipmentcode(Integer newEquipmentcode) {
	equipmentcode = newEquipmentcode;
}
public void setFactdate(java.sql.Date newDate) {
	factdate.setSqlDate(newDate);
}
public void setFactdateStr(String newDate) {
	factdate.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 19:21:53)
 * @param newFullPosition java.lang.String
 */
public void setFullPosition(java.lang.String newFullPosition) {
	fullPosition = newFullPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 16:07:29)
 * @param newHasproblems boolean
 */
public void setHasproblems(boolean newHasproblems) {
	hasproblems = newHasproblems;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 11:29:15)
 * @param newHaveequipment boolean
 */
public void setHaveequipment(boolean newHaveequipment) {
	haveequipment = newHaveequipment;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 11:23:13)
 * @param newIsNewplandate java.lang.Boolean
 */
public void setIsNewplandate(java.lang.Boolean newIsNewplandate) {
	isNewplandate = newIsNewplandate;
}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2003 11:05:21)
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 15:33:23)
 * @param newNoteStr java.lang.String
 */
public void setNoteStr(java.lang.String newNoteStr) {
	noteStr = newNoteStr;
}
public void setPlandate(java.sql.Date newDate) {
	plandate = newDate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 17:42:19)
 * @param newProjectaction int
 */
public void setProjectaction(int newProjectaction) {
	projectaction = newProjectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 22:49:36)
 * @param newProjectActionType com.hps.july.persistence.ProjectActionType
 */
public void setProjectactiontype(com.hps.july.persistence.ProjectActionTypeAccessBean bean)throws Exception {
	projectactiontypeCode.setInteger(new Integer(bean.getProjectactiontype()));
	setProjectactiontypeName(bean.getName());
	projectactiontype = (ProjectActionType)bean.getEJBRef();
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 11:47:16)
 * @param newProjecttype com.hps.july.web.util.StringAndIntegerProperty
 */
public void setProjectactiontypeCode(String value) {
	projectactiontypeCode.setString(value);
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 16:56:54)
 * @param newProjectactiontypeName java.lang.String
 */
public void setProjectactiontypeName(java.lang.String newProjectactiontypeName) {
	projectactiontypeName = newProjectactiontypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 18:41:26)
 * @param newProjectactiontypes java.util.Vector
 */
public void setProjectactiontypes(java.util.Vector newProjectactiontypes) {
	projectactiontypes = newProjectactiontypes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2003 17:24:00)
 * @param newProjectCode int
 */
public void setProjectCode(int newProjectCode) {
	projectCode = newProjectCode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:54:25)
 * @param newProjecttype int
 */
public void setProjecttype(int newProjecttype) {
	projecttype = newProjecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 13:54:16)
 * @param newResponsiblename java.lang.String
 */
public void setResponsiblename(java.lang.String newResponsiblename) {
	responsiblename = newResponsiblename;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 13:55:09)
 * @param newStdduration java.lang.Integer
 */
public void setStdduration(java.lang.Integer newStdduration) {
	stdduration = newStdduration;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 15:25:28)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
public void setSuggplandate(java.sql.Date newDate) {
	suggplandate.setSqlDate(newDate);
}
public void setSuggplandateStr(String newDate) {
	suggplandate.setString(newDate);
}
public void validateValues(ActionErrors errors) throws Exception {

    try {
    	projectactiontype = receiveProjectactiontype();
    } catch (Exception e) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.invalid.projectaction.projecttype"));
    }

    if (isHaveequipment()) {
	    try {
	    	equipment = receiveEquipment();
	    } catch (Exception e) {
	        errors.add(
	            ActionErrors.GLOBAL_ERROR,
	            new ActionError("error.invalid.projectaction.equipment"));
	    }
    }

    // Check for duplicate projectactiontypes
    if ("Add".equalsIgnoreCase(getAction())) {
	    System.out.println(">>>> ProjectActionForm: #1");
	    if (projectactiontype != null) {
	    	System.out.println(">>>> ProjectActionForm: #2");
		    Enumeration en = new ProjectActionAccessBean().findByProjectAndProjectActionType(new Integer(getProjectCode()), 
			    projectactiontypeCode.getInteger());
		    if (en.hasMoreElements())
		        errors.add(
		            ActionErrors.GLOBAL_ERROR,
		            new ActionError("error.duplicate.projectaction.projectactiontype"));
	    }
    }
    
    if (!errors.empty())
        throw new ValidationException();
}
}
