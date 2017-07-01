package com.hps.july.basestation.formbean;

/**
 * Форма просмотра позиций на карте
 */
public class PositionOnMapForm
	extends com.hps.july.web.util.BrowseForm
{
	private java.lang.String whatToDo;
	private String zoom;
	private java.lang.String label;
	private boolean searchbutton = false;
	private java.lang.String changelabel = "false";
/**
 * PositionOnMapForm constructor comment.
 */
public PositionOnMapForm() {
	super();
	whatToDo = "nothing";
	zoom="3.0";
	label = "posnothing";
}
/**
 * Insert the method's description here.
 * Creation date: (27.11.2002 11:41:40)
 * @return java.lang.String
 */
public java.lang.String getChangelabel() {
	return changelabel;
}
/**
 * Insert the method's description here.
 * Creation date: (27.11.2002 11:41:40)
 * @return java.lang.String
 */
public boolean getChangelabelAsBoolean() {
	try{
		return new Boolean(changelabel).booleanValue();
	}catch(Exception ex){
		System.out.println("!!!!! Error in getChangelabelAsBoolean() !!!!!");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 9:44:14)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 19:50:35)
 * @return java.lang.String
 */
public java.lang.String getLabel() {
	return label;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 9:47:40)
 * @return java.lang.String
 */
public java.lang.String getWhatToDo() {
	return whatToDo;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 9:48:32)
 * @return double
 */
public String getZoom() {
	return zoom;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 12:13:08)
 * @return boolean
 */
public boolean isSearchbutton() {
	return searchbutton;
}
/**
 * Insert the method's description here.
 * Creation date: (27.11.2002 11:41:40)
 * @param newChangelabel java.lang.String
 */
public void setChangelabel(java.lang.String newChangelabel) {
	changelabel = newChangelabel;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 19:50:35)
 * @param newLabel java.lang.String
 */
public void setLabel(java.lang.String newLabel) {
	label = newLabel;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 12:13:08)
 * @param newSearchbutton boolean
 */
public void setSearchbutton(boolean newSearchbutton) {
	searchbutton = newSearchbutton;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 9:47:40)
 * @param newWhatToDo java.lang.String
 */
public void setWhatToDo(java.lang.String newWhatToDo) {
	whatToDo = newWhatToDo;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 9:48:32)
 * @param newZoom double
 */
public void setZoom(String newZoom) {

	zoom = newZoom;
}
}
