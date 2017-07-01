/*
 * Created on 15.03.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.BrowseForm;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Форма списка классов ресурсов и комплектов
 * 
 */
public class ResourceClassListForm extends BrowseForm{
	private Boolean complects = Boolean.FALSE;
	private String classtype = "R";
	
	private int sortmode;	
	
	public ResourceClassListForm(){
		this.setFinderMethodName("1");
		setLastVisited(true);
		setComplects(Boolean.FALSE);
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] {complects, new Integer(getSortmode())};
	}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("dictResAdmin");
		return roles;
	}
	public void setComplects(Boolean newComplects){
		complects = newComplects;
	}
	public Boolean getComplects(){
		return complects;
	}
	public void setClasstype(String newClasstype){
		classtype = newClasstype;
		setComplects((classtype.equalsIgnoreCase("C")) ? Boolean.TRUE : Boolean.FALSE);
	}
	public String getClasstype(){
		return classtype;
	}
	public int getSortmode() {
		return sortmode;
	}
	public void setSortmode(int newSortmode) {
		sortmode = newSortmode;
	}
	public void setFinderMethodName(java.lang.String newFinderMethodName) {
		try {
			setSortmode(Integer.parseInt(newFinderMethodName));
		} catch(Exception e) {
		}
	}
	public java.lang.String getFinderMethodName() {
		return "findResourceClasses";
	}	
}