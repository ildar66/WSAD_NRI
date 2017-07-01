package com.hps.july.basestation.formbean;

/**
 * Форма работы с картой
 */
public class MapForm extends com.hps.july.web.util.BrowseForm {
	private boolean allZone;
	private Integer netzone;
	private boolean dcs;
	private boolean gsm;
	private boolean damps;
	private boolean allSuite;
	private boolean controllers;
	private boolean responsibleAll;
	private boolean comlinesRRL;
	private boolean comlinesVOLS;
	private String mappingOnmap;
	private Integer workerID;
	private String workername;
	private String whatToDo;
	private String x;
	private String y;
	private String zoom;
	private java.lang.String label;
	private java.lang.String changelabel = "false";
public MapForm() {
	super();
	//private boolean allZone;
	//private Integer netzone;
	//private boolean dcs;
	//private boolean gsm;
	//private boolean damps;
	//private boolean allSuite;
	//private boolean controllers;
	//private boolean responsibleAll;
	//private boolean comlinesRRL;
	//private boolean comlinesVOLS;
	//private String mappingOnmap;
	//private Integer workerID;
	//private String workername;
	//private String whatToDo;
	
	allZone = false;
	allSuite = false;
	damps = false;
	gsm = true;
	dcs = false;
	controllers = false;
	responsibleAll = true;
	comlinesRRL = true;
	comlinesVOLS = true;
	netzone = new Integer(1);
	mappingOnmap = "mappingOnmap";
	whatToDo = "first";
	//workerID = new Integer(-1);
	zoom="3.0";
	label = "posnothing";
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:14:10)
 * @return boolean
 */
public boolean getAllSuite() {
	return allSuite;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 11:43:03)
 * @return boolean
 */
public boolean getAllZone() {
	return allZone;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:34:00)
 * @return java.lang.String
 */
public java.lang.String getChangelabel() {
	return changelabel;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:37:00)
 * @return boolean
 */
public boolean getComlinesRRL() {
	return comlinesRRL;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:37:36)
 * @return boolean
 */
public boolean getComlinesVOLS() {
	return comlinesVOLS;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:22:13)
 * @return boolean
 */
public boolean getControllers() {
	return controllers;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:11:45)
 * @return boolean
 */
public boolean getDamps() {
	return damps;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:10:04)
 * @return boolean
 */
public boolean getDcs() {
	return dcs;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2002 17:05:13)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:11:11)
 * @return boolean
 */
public boolean getGsm() {
	return gsm;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:40:26)
 * @return java.lang.String
 */
public java.lang.String getLabel() {
	return label;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:42:30)
 * @return boolean
 */
public String getMappingOnmap() {
	return mappingOnmap;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 13:15:41)
 * @return java.lang.Integer
 */
public java.lang.Integer getNetzone() {
	return netzone;
}
public java.util.Enumeration getNetzones() {
	try {
		com.hps.july.persistence.NetZoneAccessBean bean = new com.hps.july.persistence.NetZoneAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:30:43)
 * @return boolean
 */
public boolean getResponsibleAll() {
	return responsibleAll;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 10:47:10)
 * @return java.lang.String
 */
public java.lang.String getWhatToDo() {
	return whatToDo;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 17:00:26)
 * @return boolean
 */
public Integer getWorkerID() {
	return workerID;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 17:04:28)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 16:43:44)
 * @return java.lang.String
 */
public java.lang.String getX() {
	return x;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 16:43:44)
 * @return java.lang.String
 */
public java.lang.String getY() {
	return y;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 16:43:44)
 * @return java.lang.String
 */
public java.lang.String getZoom() {
	return zoom;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:14:10)
 * @param newAllSuite boolean
 */
public void setAllSuite(boolean newAllSuite) {
	allSuite = newAllSuite;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 11:43:03)
 * @param newAllZone boolean
 */
public void setAllZone(boolean newAllZone) {
	allZone = newAllZone;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 19:34:00)
 * @param newChangelabel java.lang.String
 */
public void setChangelabel(java.lang.String newChangelabel) {
	changelabel = newChangelabel;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:37:00)
 * @param newComlinesRRL boolean
 */
public void setComlinesRRL(boolean newComlinesRRL) {
	comlinesRRL = newComlinesRRL;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:37:36)
 * @param newComlinesVOLS boolean
 */
public void setComlinesVOLS(boolean newComlinesVOLS) {
	comlinesVOLS = newComlinesVOLS;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:22:13)
 * @param newControllers boolean
 */
public void setControllers(boolean newControllers) {
	controllers = newControllers;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:11:45)
 * @param newDamps boolean
 */
public void setDamps(boolean newDamps) {
	damps = newDamps;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:10:04)
 * @param newDcs boolean
 */
public void setDcs(boolean newDcs) {
	dcs = newDcs;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:11:11)
 * @param newGsm boolean
 */
public void setGsm(boolean newGsm) {
	gsm = newGsm;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 17:40:26)
 * @param newLabel java.lang.String
 */
public void setLabel(java.lang.String newLabel) {
	label = newLabel;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:42:30)
 * @param newMappingOnmap boolean
 */
public void setMappingOnmap(String newMappingOnmap) {
	mappingOnmap = newMappingOnmap;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 13:15:41)
 * @param newNetzone java.lang.Integer
 */
public void setNetzone(java.lang.Integer newNetzone) {
	netzone = newNetzone;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 15:30:43)
 * @param newResponsibleAll boolean
 */
public void setResponsibleAll(boolean newResponsibleAll) {
	responsibleAll = newResponsibleAll;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 10:47:10)
 * @param newWhatToDo java.lang.String
 */
public void setWhatToDo(java.lang.String newWhatToDo) {
	whatToDo = newWhatToDo;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 17:00:26)
 * @param newWorkerID boolean
 */
public void setWorkerID(Integer newWorkerID) {
	workerID = newWorkerID;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 17:04:28)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 16:43:44)
 * @param newX java.lang.String
 */
public void setX(java.lang.String newX) {
	x = newX;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 16:43:44)
 * @param newY java.lang.String
 */
public void setY(java.lang.String newY) {
	y = newY;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 16:43:44)
 * @param newZoom java.lang.String
 */
public void setZoom(java.lang.String newZoom) {
	zoom = newZoom;
}
public String toString() {
	StringBuffer sb = new StringBuffer();
	sb.append("------------------\n");
	sb.append("allZone - " + allZone + "; netzone - " +netzone + "; dcs - " + dcs + "; damps - " + damps + "; gsm - " + gsm);
	sb.append("\nallSuite - " + allSuite + "; controllers - " + controllers);
	sb.append("\nresponsibleAll - " + responsibleAll + "; comlinesRRL - " + comlinesRRL);
	sb.append("\ncomlinesVOLS - " + comlinesVOLS + "; mappingOnmap - " + mappingOnmap);
	sb.append("\nworkerID - " + workerID + "; workername - " + workername + "; whatToDo - " + whatToDo);
	return sb.toString();
}
}
