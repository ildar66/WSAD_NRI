package com.hps.july.sitedoc.valueobject;

import org.apache.struts.util.MessageResources;
import javax.servlet.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.trailcom.beans.*;
import javax.servlet.http.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Класс определителя типа объекта и его параметров
 * Объет этого класса создаётся при получении objectId
 * из запросов и сохраняется в сессии
 * Используется JSP страницами для вывода информации
 * об объете с которым в данный момент работает пользователь
 */
public class DocObjectDef {
	public static final String DOCOBJECTDEF_ATTRIBUTE = "com.hps.july.sitedoc.DocObjectDef";
	
	private String objectType;
	private int objId;
	private String appHome;
	private boolean canModify = true;
	
	private String objectName = "";
	private String objectMenuKey = "";
	private String objectUrl = "";

	private Integer positionId = null;
	private Integer projectActionId = null;
	private Integer projectId = null;

	private String searchby;

	// Hops
	private Integer hopId = null;
	private HopEquipmentValue hopA;
	private HopEquipmentValue hopB;

	// Position
    private String regionName;
    private String netzoneName;
    private String address;
    private String positionName;

	// ProjectAction
    private String projectActionName;
	
	// Project
    private String projectName;

//    private MessageResources bsResources;
//    private MessageResources siteinfoResources;
public DocObjectDef(MessageResources bsResources, String objectType, int objectid, String appHome)
{
	this.objectType = objectType;
	this.objId = objectid;
	this.appHome = appHome;
    try {
		positionId = null;
		projectId = null;
		searchby = "P";
		if(isProjectAction()) {
			calculateProjectAction();
        } else if(isProject()) {
	        calculateProject();
        } else if(isPosition()) {
	        calculatePosition();
        } else if(isComline()) {
	        calculateHop(bsResources);
        } else if(isBaseStation()) {
			calculateBasestation(bsResources);
        } else if(isComEquipment()) {
			calculateComEquipment(bsResources);
        } else if(isController()) {
	        calculateController(bsResources);
        } else if(isRepiter()) {
	        calculateRepiter(bsResources);
        } else if(isSwitch()) {
	        calculateSwitch(bsResources);
        } else if(isOtherEquipment()) {
	        calculateOtherEquipment(bsResources);
        } else if(isWLAN()) {
	        calculateWLAN(bsResources);
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
}
public void calculateBasestation(MessageResources bsResources)
	throws Exception
{
	projectId = null;
	positionId = null;
	searchby = "O";
//	try {
		BaseStationAccessBean bs = new BaseStationAccessBean();
		bs.setInitKey_storageplace(objId);
		bs.refreshCopyHelper();
		PositionAccessBean position = bs.getPosition();
		positionId = new Integer(position.getStorageplace());

		objectName =
			bsResources.getMessage("label.equipment.type.basestation")
			+ ": "
			+ bsResources.getMessage("BaseStation.stationType." + bs.getStationType())
			+ " "
			+ bs.getNumber()
			+ " "
			+ bs.getStationName();

		objectMenuKey = "navigator.basestation";

		objectUrl =
			AppConstants.BASE_BASESTATION
				+ (position.getPlanstate()
					.equals(com.hps.july.siteinfo.valueobject.Position.PLANSTATE_CHECK_Fact)
						? "/Edit_ViewFactBaseStation.do" : "/Edit_ViewPlanBaseStation.do")
				+ "?action=View&basestation=" + objId
				+ "&appHome=" + appHome;
                        
		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateComEquipment(MessageResources bsResources)
	throws Exception
{
	PositionAccessBean position = null;
	projectId = null;
	positionId = null;
	searchby = "O";
//	try {
		ComEquipmentAccessBean ceq = new ComEquipmentAccessBean();
		ceq.setInitKey_storageplace(objId);
		ceq.refreshCopyHelper();

		position = ceq.getPosition();
		positionId = new Integer(position.getStorageplace());
		objectName =
			bsResources.getMessage("label.equipment.type.comequipment")
			+ ": "
			+ bsResources.getMessage("comequipment.type." + ceq.getComEquipmentType())
			+ " "
			+ ceq.getName();
		objectUrl = AppConstants.BASE_POSITION + "/EditEquipment.do?action=Edit&storageplace=" + objId;
		objectMenuKey = "navigator.comequipment";
		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateController(MessageResources bsResources)
	throws Exception
{
	PositionAccessBean position = null;
	projectId = null;
	positionId = null;
	searchby = "O";
//	try {
		if (!DebugSupport.isOldVersion()) {
			objectUrl =
				AppConstants.BASE_BASESTATION
					+ "/EditController.do?action=Edit&storageplace="
					+ objId
					+ "&appHome="
					+ appHome;
		}
		ControllerAccessBean contr = new ControllerAccessBean();
		contr.setInitKey_storageplace(objId);
		contr.refreshCopyHelper();
		position = contr.getPosition();
		positionId = new Integer(position.getStorageplace());
		objectName =
			bsResources.getMessage("label.equipment.type.controller")
			+ ": "
			+ contr.getNumber()
			+ " "
			+ contr.getName();
		objectUrl = AppConstants.BASE_POSITION + "/EditEquipment.do?action=Edit&storageplace=" + objId;
		objectMenuKey = "navigator.controller";
		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateHop(MessageResources bsResources)
	throws Exception
{
	String hopRegions = "";
	String hopZones = "";
	String hopAddress = "";
	String hopPositions = "";
	String hopEquipments = "";
	
	// fill in caption for comline
//	try {	
		HopAccessBean hop = new HopAccessBean();
		hop.setInitKey_hopsid(objId);
		hop.refreshCopyHelper();
		hopId = new Integer(hop.getHopsid());

		ComEquipmentAccessBean endA = new ComEquipmentAccessBean();
		endA.setInitKey_storageplace(hop.getEquipmentid_enda());
		endA.refreshCopyHelper();

		hopA = new HopEquipmentValue(endA);

		ComEquipmentAccessBean endB = new ComEquipmentAccessBean();
		endB.setInitKey_storageplace(hop.getEquipmentid_endb());
		endB.refreshCopyHelper();

		hopB = new HopEquipmentValue(endB);
		
		// Find hop label
		Enumeration en = (new HopLabelAccessBean()).findByHopsidOrderByHopslabelidAsc(hopId);
		if(!en.hasMoreElements()) {
			throw new Exception("hoplabel.not_found");
		}
		HopLabelAccessBean hol = (HopLabelAccessBean)en.nextElement();

//		RRLHops2AccessBean rrh = new RRLHops2AccessBean();
//		rrh.setInitKey_hopid_hopsid(hopId);
//		rrh.refreshCopyHelper();
//		positionName = hopPositions;
//		address = hopAddress;
//		regionName = hopRegions;
//		netzoneName = hopZones;

		objectName = bsResources.getMessage("label.equipment.comline")+" "+hol.getHopsname();
		objectMenuKey = "navigator.comline";
		objectUrl="";
		objectUrl =	AppConstants.BASE_BASESTATION+"/EditComlineR.do?action=View&hopsid="+objId+"&appHome="+appHome;
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateOtherEquipment(MessageResources bsResources)
	throws Exception
{
	PositionAccessBean position = null;
	projectId = null;
	positionId = null;
	searchby = "O";
//	try {
		OtherEquipmentAccessBean oeq = new OtherEquipmentAccessBean();
		oeq.setInitKey_storageplace(objId);
		oeq.refreshCopyHelper();
		position = oeq.getPosition();
		positionId = new Integer(position.getStorageplace());
		objectName =
			bsResources.getMessage("otherequipment.type." + oeq.getOtherEquipmentType());

		objectUrl = AppConstants.BASE_POSITION + "/EditEquipment.do?action=Edit&storageplace=" + objId;
		objectMenuKey = "navigator.otherequipment";
		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculatePosition()
	throws Exception
{
	projectId = null;
	positionId = null;
//	try {
		PositionAccessBean position = new PositionAccessBean();
		position.setInitKey_storageplace(objId);
		position.refreshCopyHelper();
		objectUrl =
			AppConstants.BASE_POSITION
			+ "/EditPosition.do?action=View&storageplace="
			+ objId;
		objectMenuKey = "navigator.position";
		positionId = new Integer(position.getStorageplace());

		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateProject()
	throws Exception
{
	projectId = null;
	positionId = null;
//	try {
		ProjectAccessBean project = new ProjectAccessBean();
		project.setInitKey_project(objId);
		project.refreshCopyHelper();
		projectId = new Integer(project.getProject());
		PositionAccessBean position = project.getPosition();
		positionId = new Integer(position.getStorageplace());
		objectMenuKey = "navigator.project";
		objectUrl = AppConstants.BASE_PROJECT + "/projectList.do";
		projectName = project.getProjecttype().getName();

        fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateProjectAction()
	throws Exception
{
	projectId = null;
	positionId = null;
//	try {
		ProjectActionAccessBean projectAction = new ProjectActionAccessBean();
		projectAction.setInitKey_projectaction(objId);
		projectAction.refreshCopyHelper();
		projectActionName = projectAction.getProjectactiontype().getName();
		ProjectAccessBean project = projectAction.getProject();
		projectId = new Integer(project.getProject());
		projectName = projectAction.getProject().getProjecttype().getName();
		PositionAccessBean position = projectAction.getProject().getPosition();
		positionId = new Integer(position.getStorageplace());
		objectMenuKey = "navigator.projectAction";
		objectUrl = AppConstants.BASE_PROJECT + "/projectActionList.do";

		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateRepiter(MessageResources bsResources)
	throws Exception
{
	PositionAccessBean position = null;
	projectId = null;
	positionId = null;
	searchby = "O";
//	try {
		objectUrl =
			AppConstants.BASE_BASESTATION
				+ "/EditRepiter.do?action=Edit&storageplace="+objId
				+ "&appHome="+appHome;
		RepiterAccessBean rep = new RepiterAccessBean();
		rep.setInitKey_storageplace(objId);
		rep.refreshCopyHelper();
		position = rep.getPosition();
		positionId = new Integer(position.getStorageplace());
		objectName =
			bsResources.getMessage("label.equipment.type.repeater");
		objectUrl = AppConstants.BASE_POSITION + "/EditEquipment.do?action=Edit&storageplace=" + objId;
		objectMenuKey = "navigator.repeater";
		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateSwitch(MessageResources bsResources)
	throws Exception
{
	PositionAccessBean position = null;
	projectId = null;
	positionId = null;
	searchby = "O";
//	try {
		objectUrl =
			AppConstants.BASE_BASESTATION
				+ "/EditFactSwitch.do?action=Edit&storageplace="
				+ objId
				+ "&appHome="
				+ appHome;
		SwitchAccessBean sw = new SwitchAccessBean();
		sw.setInitKey_storageplace(objId);
		sw.refreshCopyHelper();
		position = sw.getPosition();
		positionId = new Integer(position.getStorageplace());
//		DebugSupport.printlnTest("!!calculateObject sw.getSwitchType()=" + sw.getSwitchType());
		objectName =
                        bsResources.getMessage("label.equipment.type.switch")
                            + ": "
                            + bsResources.getMessage("switch_type_" + sw.getSwitchType())
                            + " "
                            + sw.getNumber();
		objectUrl = AppConstants.BASE_POSITION + "/EditEquipment.do?action=Edit&storageplace=" + objId;
		objectMenuKey = "navigator.switch";
		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void calculateWLAN(MessageResources bsResources)
	throws Exception
{
	PositionAccessBean position = null;
	projectId = null;
	positionId = null;
	searchby = "O";
//	try {
		WLANAccessBean ceq = new WLANAccessBean();
		ceq.setInitKey_storageplace(objId);
		ceq.refreshCopyHelper();

		position = ceq.getPosition();
		positionId = new Integer(position.getStorageplace());
		objectName =
			bsResources.getMessage("label.equipment.type.wlan")
			+ ": "
			+ ceq.getName() + ", " 
			+ ceq.getNumber();
		objectUrl = AppConstants.BASE_POSITION + "/EditEquipment.do?action=Edit&storageplace=" + objId;
		objectMenuKey = "navigator.wlan";
		fillPosition(position);
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//	}
}
public void fillPosition(PositionAccessBean position)
	throws java.lang.Exception
{
	if(position != null) {
		String gsm = position.getGsmid() != null ? "D" + position.getGsmid() : "";
		String damps = position.getDampsid() != null ? "A" + position.getDampsid() : "";

		positionName = gsm
			+ (gsm.length() > 0 && damps.length() > 0 ? " " : "")
			+ damps
			+ (gsm.length() > 0 || damps.length() > 0 ? " " : "")
			+ position.getName();

		regionName = position.getRegion().getRegname();
		NetZoneAccessBean netzone = position.getNetZone();
		netzone.refreshCopyHelper();
		netzoneName = netzone.getName();

		address = position.getAddress();
		/*
		DebugSupport.printlnTest(
			"!!!calculateObject getObjectType()="
			+ objectType
			+ " key="
			+ objectMenuKey
			+ " objId="
			+ objId
			+ "objectUrl="
			+ objectUrl
			+ " getProjectName="
			+ projectName);

		DebugSupport.printlnTest(
			"netzone id=" + netzone.getNetzone() + " netzone name=" + getNetzoneName());
		*/
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAppHome() {
	return appHome;
}
public static DocObjectDef getDef(HttpSession session)
{
	Object o = session.getAttribute(DOCOBJECTDEF_ATTRIBUTE);
	System.out.println("GET DEF: "+o);
	if(o != null && o instanceof DocObjectDef) {
		return (DocObjectDef)o;
	} else {
		return null;
	}
}
public static DocObjectDef getDef(ServletContext app, HttpSession session, String objectType, int objId, String appHome)
{
	System.out.println("GET NEW DEF: TYPE:"+objectType+", ID:"+objId+", APP:"+appHome);
	Object o = session.getAttribute(DOCOBJECTDEF_ATTRIBUTE);
	DocObjectDef d = null;
	boolean createnew = false;
	if(o != null && o instanceof DocObjectDef) {
		d = (DocObjectDef)o;
		if(objectType != null) {
			if(!objectType.equals(d.getObjectType())) {
				createnew = true;
			}
			if(d.getObjId() != objId) {
				createnew = true;
			}
		}
		System.out.println("Session DOF:["+d.getObjectType()+","+d.getObjId()+"] / Wanted:["+objectType+","+objId+"]");
	} else {
		createnew = true;
	}
	if(createnew) {
		System.out.println("NEW DEF CREATED: TYPE:"+objectType+", ID:"+objId+", APP:"+appHome);
		d = new DocObjectDef(TextResources.getBsResources(app), objectType, objId, appHome);
		session.setAttribute(DOCOBJECTDEF_ATTRIBUTE,d);
	}
	return d;
}
/**
 * 
 * @return com.hps.july.sitedoc.valueobject.HopEquipmentValue
 */
public HopEquipmentValue getHopA() {
	return hopA;
}
/**
 * 
 * @return com.hps.july.sitedoc.valueobject.HopEquipmentValue
 */
public HopEquipmentValue getHopB() {
	return hopB;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getHopId() {
	return hopId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNetzoneName() {
	return netzoneName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjectMenuKey() {
	return objectMenuKey;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjectName() {
	return objectName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjectType() {
	return objectType;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjectUrl() {
	return objectUrl;
}
/**
 * 
 * @return int
 */
public int getObjId() {
	return objId;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPositionId() {
	return positionId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionName() {
	return positionName;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getProjectActionId() {
	return projectActionId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getProjectActionName() {
	return projectActionName;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getProjectId() {
	return projectId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getProjectName() {
	return projectName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRegionName() {
	return regionName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSearchby() {
	return searchby;
}
public int getStorageplace()
	throws Exception
{
	int storageplace = 0;
	try {
		if (isProjectAction() || isProject()) {
			if(positionId == null) {
				System.out.println("DocOBJECTDef:PositionId id NULL!!!");
			} else {
				storageplace = positionId.intValue();
			}
		} else {
			storageplace = objId;
		}
		return storageplace;
	} catch(Exception e) {
		new DebugSupport().printlnError(e);
		throw e;
    }
}
public boolean isBaseStation()
{
	if(objectType == null) {
		return false;
	} else {
		return "BaseStation".equals(objectType);
	}
}
public boolean isCanModify() {
	return canModify;
}
public boolean isComEquipment()
{
	if(objectType == null) {
		return false;
	} else {
		return "ComEquipment".equals(objectType);
	}
}
public boolean isComline()
{
	if(objectType == null) {
		return false;
	} else {
		return "Comline".equals(objectType);
	}
}
public boolean isController()
{
	if(objectType == null) {
		return false;
	} else {
		return "Controller".equals(objectType);
	}
}
public boolean isEquipment() {
    return !isPosition() && !isProject() && !isProjectAction() && !isComline();
}
public boolean isOtherEquipment()
{
	if(objectType == null) {
		return false;
	} else {
		return "OtherEquipment".equals(objectType);
	}
}
public boolean isPosition()
{
	if(objectType == null) {
		return false;
	} else {
		return "Position".equals(objectType);
	}
}
public boolean isProject()
{
	if(objectType == null) {
		return false;
	} else {
		return "Project".equals(objectType);
	}
}
public boolean isProjectAction()
{
	if(objectType == null) {
		return false;
	} else {
		return "ProjectAction".equals(objectType);
	}
}
public boolean isRepiter()
{
	if(objectType == null) {
		return false;
	} else {
		return "Repiter".equals(objectType);
	}
}
public boolean isSwitch()
{
	if(objectType == null) {
		return false;
	} else {
		return "Switch".equals(objectType);
	}
}
public boolean isWLAN()
{
	if(objectType == null) {
		return false;
	} else {
		return "WLAN".equals(objectType);
	}
}
/**
 * 
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * 
 * @param newAppHome java.lang.String
 */
public void setAppHome(java.lang.String newAppHome) {
	appHome = newAppHome;
}
public void setCanModify(boolean newCanModify) {
	canModify = newCanModify;
}
/**
 * 
 * @param newHopA com.hps.july.sitedoc.valueobject.HopEquipmentValue
 */
public void setHopA(HopEquipmentValue newHopA) {
	hopA = newHopA;
}
/**
 * 
 * @param newHopB com.hps.july.sitedoc.valueobject.HopEquipmentValue
 */
public void setHopB(HopEquipmentValue newHopB) {
	hopB = newHopB;
}
/**
 * 
 * @param newHopId java.lang.Integer
 */
public void setHopId(java.lang.Integer newHopId) {
	hopId = newHopId;
}
/**
 * 
 * @param newNetzoneName java.lang.String
 */
public void setNetzoneName(java.lang.String newNetzoneName) {
	netzoneName = newNetzoneName;
}
/**
 * 
 * @param newObjectMenuKey java.lang.String
 */
public void setObjectMenuKey(java.lang.String newObjectMenuKey) {
	objectMenuKey = newObjectMenuKey;
}
/**
 * 
 * @param newObjectName java.lang.String
 */
public void setObjectName(java.lang.String newObjectName) {
	objectName = newObjectName;
}
/**
 * 
 * @param newObjectType java.lang.String
 */
public void setObjectType(java.lang.String newObjectType) {
	objectType = newObjectType;
}
/**
 * 
 * @param newObjectUrl java.lang.String
 */
public void setObjectUrl(java.lang.String newObjectUrl) {
	objectUrl = newObjectUrl;
}
/**
 * 
 * @param newObjId int
 */
public void setObjId(int newObjId) {
	objId = newObjId;
}
/**
 * 
 * @param newPositionId java.lang.Integer
 */
public void setPositionId(java.lang.Integer newPositionId) {
	positionId = newPositionId;
}
/**
 * 
 * @param newPositionName java.lang.String
 */
public void setPositionName(java.lang.String newPositionName) {
	positionName = newPositionName;
}
/**
 * 
 * @param newProjectActionId java.lang.Integer
 */
public void setProjectActionId(java.lang.Integer newProjectActionId) {
	projectActionId = newProjectActionId;
}
/**
 * 
 * @param newProjectActionName java.lang.String
 */
public void setProjectActionName(java.lang.String newProjectActionName) {
	projectActionName = newProjectActionName;
}
/**
 * 
 * @param newProjectId java.lang.Integer
 */
public void setProjectId(java.lang.Integer newProjectId) {
	projectId = newProjectId;
}
/**
 * 
 * @param newProjectName java.lang.String
 */
public void setProjectName(java.lang.String newProjectName) {
	projectName = newProjectName;
}
/**
 * 
 * @param newRegionName java.lang.String
 */
public void setRegionName(java.lang.String newRegionName) {
	regionName = newRegionName;
}
/**
 * 
 * @param newSearchby java.lang.String
 */
public void setSearchby(java.lang.String newSearchby) {
	searchby = newSearchby;
}
}
