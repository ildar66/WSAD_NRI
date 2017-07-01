/*
 * Created on 23.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.BrowseForm;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Форма списка антенных ресурсов
 * 
 */
public class ResAntennaListForm extends BrowseForm{
	private Boolean hasgroup;
	
	public ResAntennaListForm(){
		this.setFinderMethodName("findAllAntennes");
		setLastVisited(true);
		setHasgroup(Boolean.FALSE);
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] {hasgroup};
	}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("developer");
		roles.add("confResAdmin");
		return roles;
	}
	public void setHasgroup(Boolean newHasgroup){
		hasgroup = newHasgroup;
	}
	public Boolean getHasgroup(){
		return hasgroup;
	}
}