package com.hps.july.dictionary.formbean;

import java.util.Vector;
import java.util.Enumeration;
import com.hps.july.web.util.BrowseForm;
import com.hps.july.web.util.StringAndIntegerProperty;

/**
 * ����� ������ ������������ ���������
 */
public class RepeaterListForm
	extends ResourceListForm
{
public RepeaterListForm() {
	super();
	setShowType("Y");
	setIsResourcetype(Boolean.TRUE);
	getResourcetype().setInteger(null);
	setIsResourcesubtype(Boolean.TRUE);
	getResourcesubtype().setInteger(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("Dict_REPTYPE")));

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
/**
 * ���������� ��� ������ ������.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findRepeaterResources";
}
}
