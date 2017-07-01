package com.hps.july.project.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.project.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.hps.july.commonbean.*;
import java.util.*;
import com.hps.july.project.valueobject.*;

/**
 * Форма редактирования проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class ProjectForm extends com.hps.july.web.util.EditForm {
	private int project;
	private String name="";
	
	private StringAndIntegerProperty position = new StringAndIntegerProperty();
    private String positionname;
    private String positionid;


    private StringAndIntegerProperty contructerCode =
        new StringAndIntegerProperty();
    private StringAndIntegerProperty vccontructerCode =
        new StringAndIntegerProperty();
    private String contructerName;
    private String vccontructerName;

    private StringAndSqlDateProperty datestart=new StringAndSqlDateProperty();
    private StringAndIntegerProperty projecttypeCode =
        new StringAndIntegerProperty();
    private Organization contructer;
    private Organization vccontructer;
    private PositionAccessBean posbean;
    private ProjectType projecttype;
    private String projectstate;
	//private byte[] notes;
	private String noteStr;
	private java.lang.String postype;
	private int regioncode;
	private int netzonecode;
	private java.lang.String posnumberFrm;
	private java.lang.String posaddr;
	private String poslatFrm;
	private java.lang.String poslongFrm;
	private java.lang.String posdetails;
	private java.lang.String vctext;
	private Integer yearfinish;
	private Short monthfinish;
	private java.util.Enumeration projecttypes;
	private java.util.Enumeration allregionscoll;
	private java.util.Enumeration allnetzonescoll;
	private java.lang.String oldstate;
	private java.lang.String netzonemame;
	private java.lang.String regionname;
	private boolean finish;
/**
 * Constructing field objects.
 * Creation date: (03.07.2003 9:20:17)
 */
public ProjectForm() {
    position = new StringAndIntegerProperty();
    projecttypeCode = new StringAndIntegerProperty();
    contructerCode = new StringAndIntegerProperty();
    datestart = new StringAndSqlDateProperty();
}
public void afterUpdate(
    com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean,
    javax.servlet.http.HttpServletRequest request)
    throws Exception {

    if (getAction().equals("Add")) {
        KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();

        boolean createActions = true; 
        ProjectListForm aform = (ProjectListForm)request.getSession().getAttribute("projectList");

		String prjParamsStr = Util_Alex.getCookie(aform.makeName("prjparams"), request);
        
		String name = aform.makeName("plandate");
		if(!Util_Alex.hasParam(name, prjParamsStr)) { 
            createActions = false;
		}
		
        ///create actions   
        ProjectAccessBean project = (ProjectAccessBean) bean;
        ProjectTypeAccessBean projectType = project.getProjecttype();
        ProtoActionAccessBean protoAction = new ProtoActionAccessBean();
        ProtoActionAccessBean stepbeforeProtoAction = new ProtoActionAccessBean();
        ProjectActionAccessBean stepbeforeAction = new ProjectActionAccessBean();
        java.util.Enumeration enum =
            protoAction.findByProjecttypeOrderByOrderAsc(
                new Integer(projectType.getProjecttype()));

        java.sql.Date dateStart = null;
        java.sql.Date datePlan = null;
        boolean haveStepsBefore = false;

        while (enum.hasMoreElements()) {
            protoAction = (ProtoActionAccessBean) enum.nextElement();
             ProjectActionTypeAccessBean projectActionType =
                protoAction.getProjectActionType();
            if (protoAction.getStepbefore() == null) {
                dateStart = project.getDatestart();
                haveStepsBefore = false;
            } else {
	            stepbeforeProtoAction = new ProtoActionAccessBean();
                stepbeforeProtoAction.setInitKey_projectaction(
                    protoAction.getStepbefore().intValue());
                stepbeforeProtoAction.refreshCopyHelper();
                Enumeration enum1 =
                    stepbeforeAction.findByProjectAndProjectActionType(
                        new Integer(project.getProject()),
                        new Integer(stepbeforeProtoAction.getProjectActionTypeKey().projectactiontype));
                if (enum1.hasMoreElements()) {
	                stepbeforeAction = (ProjectActionAccessBean) enum1.nextElement();
	                dateStart = stepbeforeAction.getPlandate();
	                haveStepsBefore = true;
                } else {
                	dateStart = project.getDatestart();
                	haveStepsBefore = false;
                }
            }

            if (createActions) {
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(dateStart);
	            if (haveStepsBefore)
	            	cal.add(Calendar.DATE, protoAction.getDuration());
	            datePlan = new java.sql.Date(cal.getTime().getTime());
            } else {
	            datePlan = null;
	            if (!haveStepsBefore) {
		            Calendar cal = Calendar.getInstance();
		            cal.setTime(dateStart);
	            	datePlan = new java.sql.Date(cal.getTime().getTime());
	            }
            }
            
            //responsable
            WorkerAccessBean bossBean = projectActionType.getAction2division().getBoss();

            //create projectaction here
            int projectaction = keygen.getNextKey(TablesRef.PROJECTACTIONS);

            ProjectActionAccessBean projectAction =
                new ProjectActionAccessBean(
                    projectaction,
                    project.getProject(),
                    projectActionType.getProjectactiontype(),
                    protoAction.getOrder(),
                    false);

			if(createActions || !haveStepsBefore) { 
            	projectAction.setPlandate(datePlan);
            	projectAction.setSuggplandate(datePlan);
            	projectAction.setIsNewplandate(Boolean.TRUE);
			}
            projectAction.setFactdate(null);
            projectAction.commitCopyHelper();
        }

        
        //create state

        int projectstate = keygen.getNextKey(TablesRef.PROJECTSTATES);

        String login = request.getRemoteUser();
        //String login = "dima";

        OperatorAccessBean operator = new OperatorAccessBean();
        operator = operator.findByLogin(login);

        /*
        int argProjectstate,
        String argState, 
        int argMan,
        java.sql.Timestamp argWhen,
        int argProject
        */
        ProjectStateAccessBean projectstateBean =
            new ProjectStateAccessBean(
                projectstate,
                "A",
                operator.getMan().getMan(),
                new java.sql.Timestamp(System.currentTimeMillis()),
                getProject());
            projectstateBean.commitCopyHelper();

    } else if("Edit".equalsIgnoreCase(getAction())) {
	    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
	    int code = keygen.getNextKey(TablesRef.PROJECTSTATES);

	    String login = request.getRemoteUser();
	    OperatorAccessBean operator = new OperatorAccessBean().findByLogin(login);

	    ProjectStateAccessBean projectstateBean =
	        new ProjectStateAccessBean(
	            code,
	            getProjectstate(),
	            operator.getMan().getMan(),
	            new java.sql.Timestamp(System.currentTimeMillis()),
	            getProject());
            projectstateBean.commitCopyHelper();
    }
}
/**
 * Before deleting project - remove linked records.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(
    com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean,
    javax.servlet.http.HttpServletRequest request)
    throws Exception {
    ProjectAccessBean project = (ProjectAccessBean) bean;

    //remove states
    ProjectStateAccessBeanTable table = new ProjectStateAccessBeanTable();
    ProjectStateAccessBean state = new ProjectStateAccessBean();
    table.setProjectStateAccessBean(
        state.findProjectStatesByProject(
            (ProjectKey) project.getEJBRef().getPrimaryKey()));

    int n = table.numberOfRows();
    for (int i = 0; i < n; i++) {
        table.getProjectStateAccessBean(i).getEJBRef().remove();
    }

    //remove action types
    ProjectActionAccessBeanTable table1 = new ProjectActionAccessBeanTable();
    ProjectActionAccessBean action = new ProjectActionAccessBean();
    table1.setProjectActionAccessBean(
        action.findProjectActionsByProject(
            (ProjectKey) project.getEJBRef().getPrimaryKey()));
    
    int n1 = table1.numberOfRows();
    for (int i = 0; i < n1; i++) {
		ProjectActionAccessBean prjact = table1.getProjectActionAccessBean(i);
		
		// remove projectaction comments
		Enumeration en2 = new ProjectActionCommentsAccessBean().findProjectActionCommentsByProjectaction(new ProjectActionKey(prjact.getProjectaction()));
		while (en2.hasMoreElements()) {
			ProjectActionCommentsAccessBean pac = (ProjectActionCommentsAccessBean)en2.nextElement();
			//ProjectActionCommentsAccessBean pac = new ProjectActionCommentsAccessBean((ProjectActionComments)(javax.rmi.PortableRemoteObject.narrow(en2.nextElement(), ProjectActionComments.class)));
			pac.getEJBRef().remove();
		}
		
		// remove projectaction
    	prjact.getEJBRef().remove();
    }

    // Remove user comments
	Enumeration en = new ProjectDivColValAccessBean().findProjectDivColValsByProject((ProjectKey) project.getEJBRef().getPrimaryKey());
	while (en.hasMoreElements()) {
		((ProjectDivColValAccessBean)en.nextElement()).getEJBRef().remove();
		//((ProjectDivColVal)(javax.rmi.PortableRemoteObject.narrow(en.nextElement(), ProjectDivColVal.class))).remove();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2003 11:42:52)
 * @return java.lang.String
 * @param argField java.lang.String
 */
public String canEditField(String argField) {
	String result = "true";

	/*
	if ("I".equalsIgnoreCase(projectstate)) {
		// all fields can be edited
	} else if ("A".equalsIgnoreCase(projectstate)) {
		if ("simple".equalsIgnoreCase(argField))
			result = "false";
	} else if ("D".equalsIgnoreCase(projectstate)) {
		if ("simple".equalsIgnoreCase(argField))
			result = "false";
	} else if ("F".equalsIgnoreCase(projectstate)) {
		// All fields disabled
		result = "false";
	}
	*/

	// Disable all fields in 'finished' state
	if ("D".equalsIgnoreCase(getOldstate())) {
		result = "false";
	}
	
	return result;
}
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

    // Start transaction
	//javax.naming.InitialContext ctx = new javax.naming.InitialContext();
	//javax.transaction.UserTransaction transact = (javax.transaction.UserTransaction)ctx.lookup("jta/usertransaction");
	//transact.begin();

    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    
    System.out.println(">>>>> POSTYPE=" + getPostype());
    if ("N".equalsIgnoreCase(getPostype())) {
		// Create position if required
	    StringAndIntegerProperty aint = new StringAndIntegerProperty();

	    StringAndBigDecimalProperty alat = new StringAndBigDecimalProperty();
	    //alat.setString(getPoslatFrm());
	    alat.setString("0");
	        
	    StringAndBigDecimalProperty along = new StringAndBigDecimalProperty();
	    along.setString("0");

	    int poscode = keygen.getNextKey(TablesRef.STORAGEPLACES);
		PositionAccessBean pos = new PositionAccessBean(poscode, 
			getPositionname(), getPosaddr(), new Integer(getNetzonecode()), 
			alat.getBigDecimal(), 
			along.getBigDecimal(), 
			getRegioncode(), "2");

		aint.setString(getPosnumberFrm());
		pos.setGsmid(aint.getInteger());
		pos.commitCopyHelper();
		position.setInteger(new Integer(poscode));
		System.out.println(">>> Position created: " + position.getInteger());
	    try {
	        posbean = receivePosition();
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
	    }
		System.out.println(">>> Posbean found: " + position.getInteger());
    }
    
	// Create project
    setProject(keygen.getNextKey(TablesRef.PROJECTS));
    ProjectAccessBean bean =
        new ProjectAccessBean(project, projecttypeCode.getInteger().intValue(), name, 
	        position.getInteger()==null?0:position.getInteger().intValue());

	System.out.println(">>> After create project: " + position.getInteger());
       
	//transact.commit();
	
    return bean;
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
    try {
        ProjectStateAccessBean stateBean =
            new ProjectStateAccessBean().findCurrentForProject(new Integer(getProject()));
        projectstate = stateBean.getState();
    } catch (Exception e) {
        Util_Alex.pr(e, "fillRecord", this);
    }

    // Store old project state to use in validation
    setOldstate(getProjectstate());
    
    // When changing - position always existing
    setPostype("E");

    StringAndBigDecimalProperty dprp = new StringAndBigDecimalProperty();
    StringAndIntegerProperty iprp = new StringAndIntegerProperty();
    try {
	    setProjecttypeCode("" + ((ProjectAccessBean)bean).getProjecttype().getProjecttype());
    	setRegioncode(posbean.getRegion().getRegionid());
    	setNetzonecode(posbean.getNetZone().getNetzone());
    	iprp.setInteger(posbean.getGsmid());
    	setPosnumberFrm(iprp.getString());
    	setPosaddr(posbean.getAddress());
    	dprp.setBigDecimal(posbean.getLatitude());
    	setPoslatFrm(dprp.getString());
    	dprp.setBigDecimal(posbean.getLongitude());
    	setPoslongFrm(dprp.getString());
    } catch (Exception e) {
	    e.printStackTrace(System.out);
	    setRegioncode(0);
	    setNetzonecode(0);
	    setPosnumberFrm("");
	    setPosaddr("");
	    setPoslatFrm("");
	    setPoslongFrm("");
    }

    // Set finish
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(new Date());
    if (getYearfinish() == null) {
	    setFinish(false);
		setYearfinish(new Integer(cal.get(Calendar.YEAR)));
		setMonthfinish(new Short((short)cal.get(Calendar.MONTH)));
    } else {
	    setFinish(true);
    }
    
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:56:07)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getAllnetzones() {
	return allnetzonescoll;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2003 11:56:07)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getAllregions() {
	return allregionscoll;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.PROJECT;
}
public Organization getContructer() {
	return contructer;
}
public String getContructerCode() {
	return contructerCode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 19:23:01)
 * @return java.lang.String
 */
public java.lang.String getContructerName() {
	return contructerName;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {

    ProjectAccessBean bean = new ProjectAccessBean();
    bean.setInitKey_project(getProject());
    try {
	    bean.refreshCopyHelper();
        ProjectStateAccessBean stateBean =
            new ProjectStateAccessBean().findCurrentForProject(new Integer(getProject()));
        String oldprojectstate = stateBean.getState();
	    if ("D".equals(oldprojectstate)) {
		    // For completed contracts do not allow field modifications
		    setDatestart(bean.getDatestart());
		    setMonthfinish(bean.getMonthfinish());
		    setYearfinish(bean.getYearfinish());
		    setContructer(bean.getContructer());
		    setPosition(bean.getPosition());
		    setVccontructer(bean.getVccontructer());
		    setVctext(bean.getVctext());
	    }
    } catch (Exception e) {
	    e.printStackTrace(System.out);
    }
    return bean;
}
	public java.sql.Date getDatestart() {
		if (datestart.isEmpty())
			return null;
		return datestart.getSqlDate();
	}
public String getDatestartStr() {
	return datestart.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:27:07)
 * @return short
 */
public Short getMonthfinish() {
	return monthfinish;
}
/**
 * Insert the method's description here.
 * Creation date: (14.12.2002 20:54:40)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:06:59)
 * @return int
 */
public int getNetzonecode() {
	return netzonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 16:32:28)
 * @return java.lang.String
 */
public java.lang.String getNetzonemame() {
	return netzonemame;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 15:33:23)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return noteStr;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 16:28:31)
 * @return java.lang.String
 */
public java.lang.String getOldstate() {
	return oldstate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:14:59)
 * @return java.lang.String
 */
public java.lang.String getPosaddr() {
	return posaddr;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:17:09)
 * @return java.lang.String
 */
public java.lang.String getPosdetails() {
	return posdetails;
}
public Position getPosition() throws Exception {
	if (posbean != null)
		return (Position)posbean.getEJBRef();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 18:02:39)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getPositioncode() {
	return position.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 18:02:39)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 18:02:39)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:15:23)
 * @return int
 */
public String getPoslatFrm() {
	return poslatFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:15:39)
 * @return java.lang.String
 */
public java.lang.String getPoslongFrm() {
	return poslongFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:14:29)
 * @return java.lang.String
 */
public java.lang.String getPosnumberFrm() {
	return posnumberFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:05:02)
 * @return java.lang.String
 */
public java.lang.String getPostype() {
	return postype;
}
/**
 * Insert the method's description here.
 * Creation date: (14.12.2002 20:25:19)
 * @return int
 */
public int getProject() {
	return project;
}
    //private String complectmodel;
    public String getProjectstate(){
		if (projectstate == null)
			return "";
		return projectstate;

	
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 11:47:16)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getProjecttypeCode() {
	return projecttypeCode.getString();
}
public Enumeration getProjecttypes() {
	return projecttypes;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:06:32)
 * @return int
 */
public int getRegioncode() {
	return regioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 16:32:45)
 * @return java.lang.String
 */
public java.lang.String getRegionname() {
	return regionname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.PROJECTFORM;
}
public Organization getVccontructer() {
	return vccontructer;
}
public String getVccontructerCode() {
	return vccontructerCode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 19:23:01)
 * @return java.lang.String
 */
public java.lang.String getVccontructerName() {
	return vccontructerName;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:18:20)
 * @return java.lang.String
 */
public java.lang.String getVctext() {
	return vctext;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:26:28)
 * @return int
 */
public Integer getYearfinish() {
	return yearfinish;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 12:38:43)
 * @return java.util.Enumeration
 */
public Enumeration getYears() {
	Vector years = new Vector();
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(new Date());
	int startyear = 1998;
	int endyear = cal.get(Calendar.YEAR) + 5;
	for (int i=startyear; i < endyear; i++) {
		YearObject ayear = new YearObject();
		ayear.setYear(i);
		years.add(ayear);
	}	
	return years.elements();
}
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	// Init project types
	try {
		projecttypes = new ProjectTypeAccessBean().findAllOrderByCodeAsc();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

		
	// Init Regions
	try {
		allregionscoll = new RegionAccessBean().findByQBE(Boolean.FALSE, null, Boolean.FALSE, "", new Integer(1));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	
	// Init Netzones
	try {
		allnetzonescoll = new NetZoneAccessBean().findAllOrderByNameAsc();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
public void initRecord(javax.servlet.http.HttpServletRequest request) {

    ProjectListForm listForm =
        (ProjectListForm) (request.getSession().getAttribute("projectList"));

    positionid = ""; //listForm.getPositionid() != null ? listForm.getPositionid() : "";
    positionname = ""; //
        //listForm.getPositionname() != null ? listForm.getPositionname() : "";
    position.setString("");
        //listForm.getPositioncode() != null ? listForm.getPositioncode() : "");

    //projecttypeCode.setString(""); //listForm.getProjecttypeCode());

    project = 0;
    name = "";

    contructerName = null;

    contructer = null;
    projecttype = null;

    noteStr = null;

    projectstate = null;

    // Position type - new
    setPostype("N");

    // Init project finish date
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(new Date());
	setYearfinish(new Integer(cal.get(Calendar.YEAR)));
	setMonthfinish(new Short((short)cal.get(Calendar.MONTH)));
	setProjectstate("A"); // New project by default
	setFinish(false);
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 11:04:54)
 * @return boolean
 */
public boolean isFinish() {
	return finish;
}
public Organization receiveContructer(int code)
    throws java.lang.Exception {
    OrganizationAccessBean bean = new OrganizationAccessBean();
    bean.setInitKey_organization(code);
    bean.refreshCopyHelper();
    return (Organization)bean.getEJBRef();
}
public PositionAccessBean receivePosition() throws java.lang.Exception {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace(position.getInteger().intValue());
	bean.refreshCopyHelper();
	return bean;
}
    //private String complectmodel;
    public void setContructer(OrganizationAccessBean bean) throws Exception{
	
		contructerCode.setInteger(new Integer(bean.getOrganization()));
		contructerName = bean.getName();
	
}
public void setContructerCode(String code) {
	contructerCode.setString(code);
}
/**
 * Insert the method's description here.
 * Creation date: (21.10.2003 17:41:33)
 * @param newContructerName java.lang.String
 */
public void setContructerName(java.lang.String newContructerName) {
	contructerName = newContructerName;
}
public void setDatestart(java.sql.Date newDate) {
	datestart.setSqlDate(newDate);
}
public void setDatestartStr(String newDate) {
	datestart.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2003 11:04:54)
 * @param newFinish boolean
 */
public void setFinish(boolean newFinish) {
	finish = newFinish;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:27:07)
 * @param newMonthfinish short
 */
public void setMonthfinish(Short newMonthfinish) {
	monthfinish = newMonthfinish;
}
/**
 * Insert the method's description here.
 * Creation date: (14.12.2002 20:54:40)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:06:59)
 * @param newNetzonecode int
 */
public void setNetzonecode(int newNetzonecode) {
	netzonecode = newNetzonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 16:32:28)
 * @param newNetzonemame java.lang.String
 */
public void setNetzonemame(java.lang.String newNetzonemame) {
	netzonemame = newNetzonemame;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 15:33:23)
 * @param newNoteStr java.lang.String
 */
public void setNotes(java.lang.String newNoteStr) {
	noteStr = newNoteStr;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 16:28:31)
 * @param newOldstate java.lang.String
 */
public void setOldstate(java.lang.String newOldstate) {
	oldstate = newOldstate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:14:59)
 * @param newPosaddr java.lang.String
 */
public void setPosaddr(java.lang.String newPosaddr) {
	posaddr = newPosaddr;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:17:09)
 * @param newPosdetails java.lang.String
 */
public void setPosdetails(java.lang.String newPosdetails) {
	posdetails = newPosdetails;
}
public void setPosition(PositionAccessBean pos) throws Exception {

	posbean = pos;
    position.setInteger(new Integer(pos.getStorageplace()));
    positionid = "";
    if (pos.getGsmid() != null) {
        positionid = positionid + "D" + pos.getGsmid();
    }
    positionid = positionid + " ";
    if (pos.getDampsid() != null) {
        positionid = positionid + "A" + pos.getDampsid();
    }

    positionname = positionid + " " + pos.getName();
    setNetzonemame(pos.getNetZone().getName());
    setRegionname(pos.getRegion().getRegname());
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 18:02:39)
 * @param newPosition com.hps.july.web.util.StringAndIntegerProperty
 */
public void setPositioncode(String newPosition) {
    position.setString(newPosition);
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 18:02:39)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2002 18:02:39)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:15:23)
 * @param newPoslatFrm int
 */
public void setPoslatFrm(String newPoslatFrm) {
	poslatFrm = newPoslatFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:15:39)
 * @param newPoslongFrm java.lang.String
 */
public void setPoslongFrm(java.lang.String newPoslongFrm) {
	poslongFrm = newPoslongFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:14:29)
 * @param newPosnumberFrm java.lang.String
 */
public void setPosnumberFrm(java.lang.String newPosnumberFrm) {
	posnumberFrm = newPosnumberFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:05:02)
 * @param newPostype java.lang.String
 */
public void setPostype(java.lang.String newPostype) {
	postype = newPostype;
}
/**
 * Insert the method's description here.
 * Creation date: (14.12.2002 20:25:19)
 * @param newProject int
 */
public void setProject(int newProject) {
	project = newProject;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:18:20)
 * @param newVctext java.lang.String
 */
public void setProjectstate(java.lang.String newProjectstate) {
	projectstate = newProjectstate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 11:47:16)
 * @param newProjecttype com.hps.july.web.util.StringAndIntegerProperty
 */
public void setProjecttypeCode(String newProjecttype) {
	projecttypeCode.setString(newProjecttype);
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:06:32)
 * @param newRegioncode int
 */
public void setRegioncode(int newRegioncode) {
	regioncode = newRegioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 16:32:45)
 * @param newRegionname java.lang.String
 */
public void setRegionname(java.lang.String newRegionname) {
	regionname = newRegionname;
}
    //private String complectmodel;
    public void setVccontructer(OrganizationAccessBean bean) throws Exception{

	    if (bean != null) {
			vccontructerCode.setInteger(new Integer(bean.getOrganization()));
			vccontructerName = bean.getName();
	    } else {
		    vccontructerCode.setString("");
		    vccontructerName = "";
	    }
	
}
public void setVccontructerCode(String code) {
	vccontructerCode.setString(code);
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:18:20)
 * @param newVctext java.lang.String
 */
public void setVctext(java.lang.String newVctext) {
	vctext = newVctext;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2003 15:26:28)
 * @param newYearfinish int
 */
public void setYearfinish(Integer newYearfinish) {
	yearfinish = newYearfinish;
}
public void validateValues(ActionErrors errors) throws Exception {

	if ("Add".equals(getAction())) {
	    if (getProjecttypeCode() == null || getProjecttypeCode().trim().equals("")) {
	        errors.add(
	            ActionErrors.GLOBAL_ERROR,
	            new ActionError("error.empty.project.projecttype"));
	    }
	}

	setName("(empty)");

	/*
    if (getName().trim().equals("")) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.project.name"));
    }
    */

    System.out.println(">>>>> POSTYPE=" + getPostype());
    if ("E".equalsIgnoreCase(getPostype())) {
	    try {
	        posbean = receivePosition();
	    } catch (Exception e) {
	        errors.add(
	            ActionErrors.GLOBAL_ERROR,
	            new ActionError("error.invalid.project.position"));
	    }
    } else {
	    // Check position attributes
	    if (getPositionname().trim().equals(""))
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.posname"));

	    StringAndIntegerProperty aint = new StringAndIntegerProperty();
	    aint.setString(getPosnumberFrm());
	    if (!aint.isEmpty() && !aint.isOk())
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.posnumber"));

	    /*
	    StringAndBigDecimalProperty adec = new StringAndBigDecimalProperty();
	    adec.setString(getPoslatFrm());
	    if (adec.isEmpty() || !adec.isOk())
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.poslat"));
	    else if (adec.getBigDecimal().compareTo(new java.math.BigDecimal(0)) < 0)
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.poslat"));
	    else if (adec.getBigDecimal().compareTo(new java.math.BigDecimal(100)) >= 0)
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.poslat"));
	        
	    adec.setString(getPoslongFrm());
	    if (adec.isEmpty() || !adec.isOk())
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.poslong"));
	    else if (adec.getBigDecimal().compareTo(new java.math.BigDecimal(0)) < 0)
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.poslat"));
	    else if (adec.getBigDecimal().compareTo(new java.math.BigDecimal(100)) >= 0)
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.project.poslat"));
	    */
	    
    }
    if (!contructerCode.isEmpty() && contructerCode.isOk()) {
	    try {
	        contructer = receiveContructer(contructerCode.getInteger().intValue());
	    } catch (Exception e) {
	        errors.add(
	            ActionErrors.GLOBAL_ERROR,
	            new ActionError("error.invalid.project.contructer"));
	    }
    } else {
	        errors.add(
	            ActionErrors.GLOBAL_ERROR,
	            new ActionError("error.invalid.project.contructer"));
    }
    
    if (datestart == null) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.project.datestart"));
    }

    if (!vccontructerCode.isEmpty())
    	if (vccontructerCode.isOk()) {
		    try {
		        vccontructer = receiveContructer(vccontructerCode.getInteger().intValue());
		    } catch (Exception e) {
		        errors.add(
		            ActionErrors.GLOBAL_ERROR,
		            new ActionError("error.invalid.project.vccontructer"));
		    }
	    } else {
		        errors.add(
		            ActionErrors.GLOBAL_ERROR,
		            new ActionError("error.invalid.project.vccontructer"));
	    }
    
    try {
        if ("D".equalsIgnoreCase(getProjectstate())) {
	        ProjectActionAccessBean projectAction = new ProjectActionAccessBean();
	        ProjectActionAccessBeanTable table = new ProjectActionAccessBeanTable();

	        table.setProjectActionAccessBean(
	            projectAction.findProjectActionsByProject(
	                new ProjectKey(getProject())));

	        for (int i = 0; i < table.numberOfRows(); i++) {
	            if ( (table.getProjectActionAccessBean(i).getCompleted() != null) && 
		            	!table.getProjectActionAccessBean(i).getCompleted().booleanValue()) {
	                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectstate.D"));
					break;
	            }
        	}
        }
    } catch (Exception e) {
        Util_Alex.pr(e, "validateValues", this);
        throw e;
    }
    
    if (!errors.empty())
        throw new ValidationException();

    // Update month/year finish
    if (!isFinish()) {
	    setMonthfinish(null);
	    setYearfinish(null);
    }
}
}
