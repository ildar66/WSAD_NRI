package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;
import java.util.Vector;
import java.util.Enumeration;
import com.hps.july.web.util.*;

/**
 * Форма списка базовых станций
 */
public class BasestationListForm
	extends ResourceListForm
{
	private Boolean isGeneration = Boolean.FALSE;
	private String generation = "";
public BasestationListForm() {
	super();
	
	generation = "";
	isGeneration = Boolean.FALSE;
	setShowType("Y");
	setIsResourcetype(Boolean.TRUE);
	getResourcetype().setInteger(null);
	setIsResourcesubtype(Boolean.TRUE);
	getResourcesubtype().setInteger(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("Dict_BSTYPE")));
	
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
		getIsResourcetype(), (getResourcetype().getInteger() != null)?getResourcetype().getInteger():new Integer(0),
		getIsResourcesubtype(), (getResourcesubtype().getInteger() != null)?getResourcesubtype().getInteger():new Integer(0),
		getIsModel(), getModel(),
		getIsName(), getName(),
		getIsManuf(), (getManuf().getInteger() != null)?getManuf().getInteger():new Integer(0),
		getIsManucode(), getManucode(),
		getIsNfscode(), getNfscode(),
		getIsNricode(), getNricode(),
		getShowType(),
        getIsGeneration(), getGeneration(),
		new Integer(getSortmode())
	};
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findBasestationResources";
}
public java.lang.String getGeneration() {
	return generation;
}
public java.lang.Boolean getIsGeneration() {
	return isGeneration;
}
public Enumeration getPolars() {
	Vector v = new Vector();
	v.add("*"); v.add("*");
	v.add("V"); v.add("Вертикальная");
	v.add("C"); v.add("Кросс");
	return v.elements();
}
	public Enumeration getRanges() {
		Vector v = new Vector();
		v.add("*"); v.add("*");
		v.add("1"); v.add("900");
		v.add("2"); v.add("1800");
		v.add("3"); v.add("900/1800");
		return v.elements();
	}
public void setGeneration(java.lang.String newGeneration) {
	generation = newGeneration;
}
public void setIsGeneration(java.lang.Boolean newIsGeneration) {
	isGeneration = newIsGeneration;
}
}
