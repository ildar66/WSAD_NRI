package com.hps.july.dictionary.formbean;

import java.util.Vector;
import java.util.Enumeration;
import com.hps.july.web.util.*;

/**
 * Форма списка антенн
 */
public class AntenaListForm
	extends ResourceListForm
{
	private static int[] RANGES = { 800, 900, 1800, 2000 };
	
	private Boolean[] isRange = new Boolean[] {
		Boolean.TRUE,	// All range
		Boolean.FALSE,	// 800
		Boolean.FALSE,	// 900
		Boolean.FALSE,	// 1800
		Boolean.FALSE,	// 2000
	};

	private String polar = "*"; // 'A'll 'V'ertical 'C'ross
public AntenaListForm() {
	super();
	setFinderMethodName("1");

	setShowType("Y");
	setIsResourcetype(Boolean.TRUE);
	getResourcetype().setInteger(null);
	setIsResourcesubtype(Boolean.TRUE);
	getResourcesubtype().setInteger(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("Dict_ANTTYPE")));
}
public Integer[] createRangesFilter() {
	int i;
	Integer[] rng;
	if(!isRange[0].booleanValue()) {
		Vector v = new Vector(4);
		for(i = 0; i < 4; i++) {
			if(isRange[i+1].booleanValue()) {
				v.add(new Integer(RANGES[i]));
			}
		}
		rng = new Integer[v.size()];
		for(i = 0; i < rng.length; i++) {
			rng[i] = (Integer)v.get(i);
		}
	} else {
		rng = new Integer[0];
	}
	return rng;
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
		getIsName(), getName(),
		getIsManuf(), (getManuf().getInteger() != null)?getManuf().getInteger():new Integer(0),
		getIsManucode(), getManucode(),
		getIsNfscode(), getNfscode(),
		getIsNricode(), getNricode(),
		getShowType(),
		getPolar(),
		getIsRange(0).booleanValue()?Boolean.FALSE:Boolean.TRUE,
		createRangesFilter(),
		new Integer(getSortmode())
	};
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findAntennesResources";
}
public java.lang.Boolean getIsRange(int i) {
	return isRange[i];
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPolar() {
	return polar;
}
public Enumeration getPolars() {
	Vector v = new Vector();
	v.add("*"); v.add("Все");
	v.add("V"); v.add("Вертикальная");
	v.add("C"); v.add("Кросс");
	return v.elements();
}
public void setIsRange(int i, Boolean newIsRange) {
	isRange[i] = newIsRange;
}
/**
 * 
 * @param newPolar java.lang.String
 */
public void setPolar(java.lang.String newPolar) {
	polar = newPolar;
}
}
