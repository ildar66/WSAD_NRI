/*
 * Created on 12.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.dictionary.valueobject.*;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DonorUnitListForm extends ResourceListForm {
	public DonorUnitListForm(){
		super();
		setIsResourcetype(Boolean.TRUE);
		getResourcetype().setInteger(null);
		setIsResourcesubtype(Boolean.TRUE);
		getResourcesubtype().setInteger(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("Dict_DONORTYPE")));

		this.setFinderMethodName("1");
	}
	public java.lang.Object[] getFilterParams() {
		return new Object[] {
			getIsResourcetype(),
			(getResourcetype().getInteger() != null)?getResourcetype().getInteger():new Integer(0),
			getIsResourcesubtype(),
			(getResourcesubtype().getInteger() != null)?getResourcesubtype().getInteger():new Integer(0),
			getIsModel(), getModel(),
			getIsName(),getName(),
			getIsManuf(), (getManuf().getInteger() != null)?getManuf().getInteger():new Integer(0),
			getIsManucode(), getManucode(),
			getIsNfscode(), getNfscode(),
			getIsNricode(), getNricode(),
			getShowType(),
			new Integer(getSortmode())
		};
	}
	public java.lang.String getFinderMethodName() {
		return "findDonorunitResources";
	}
}