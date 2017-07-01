/*
 * Created on 21.02.2007
 *
 */
package com.hps.july.arenda.formbean;

import java.util.Collection;

import com.hps.july.web.util.BrowseForm;

/**
 * @author vglushkov
 * ‘орма определ€юща€ выбор региона в модуле аренда
 */
public class AvailableRegionForm extends BrowseForm {
	
	private Collection availableRegions;
	private Integer curRegId;
	/**
	 * Insert the method's description here.
	 * Creation date: (09.01.2003 16:07:25)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { };
	}
	
	public Collection getAvailableRegions() {
		return availableRegions;
	}
	
	public void setAvailableRegions(Collection regions) {
		this.availableRegions = regions;
	}
	
	public Integer getCurRegId() {
		return curRegId;
	}
	
	public void setCurRegId(Integer regId) {
		this.curRegId = regId;
	}
	
	
}

