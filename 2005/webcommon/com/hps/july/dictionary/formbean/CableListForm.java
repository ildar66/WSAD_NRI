package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;
import java.util.Vector;
import java.util.Enumeration;
import com.hps.july.web.util.*;

/**
 * Форма списка кабелей р/ч
 */
public class CableListForm
	extends ResourceListForm
{
public CableListForm() {
	super();
	setIsResourcetype(Boolean.TRUE);
	getResourcetype().setInteger(null);
	setIsResourcesubtype(Boolean.TRUE);
	getResourcesubtype().setInteger(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("Dict_CABLETYPE")));
	
	setFinderMethodName("1");
}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList(2);
		roles.add("administrator");
		roles.add("dictResAdmin");
		//roles.add("dictResOperator");
		return roles;
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
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findCableResources";
}
}
