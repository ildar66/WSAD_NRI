package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма lookup по выбору оператора.
 * Creation date: (01.04.2003 11:58:25)
 * @author: Alexander Makanin
 */
public class OperatorLookupListForm extends com.hps.july.web.util.BrowseForm {
    private Integer man;  //
	private java.lang.String loginid;
	private java.lang.String fullName;
    /**
     * OperatorLookupListForm constructor comment.
     */
    public OperatorLookupListForm() {
        this.setFinderMethodName("findOperatorsByMan");
    }
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 11:58:25)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    if (man != null) {
        return new Object[] { new PeopleKey(man.intValue())};
    } else {
        return new Object[] {
        };
    }
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 13:08:08)
 * @return java.lang.String
 */
public java.lang.String getFullName() {
	return fullName;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 18:05:57)
 * @return java.lang.String
 */
public java.lang.String getLoginid() {
	return loginid;
}
    /**
     * Insert the method's description here.
     * Creation date: (01.04.2003 12:04:06)
     * @return int
     */
    public Integer getMan() {
        return man;
    }
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 13:08:08)
 * @param newFullName java.lang.String
 */
public void setFullName(java.lang.String newFullName) {
	fullName = newFullName;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 18:05:57)
 * @param newLoginid java.lang.String
 */
public void setLoginid(java.lang.String newLoginid) {
	loginid = newLoginid;
}
    /**
     * Insert the method's description here.
     * Creation date: (01.04.2003 12:04:06)
     * @param newMan int
     */
    public void setMan(Integer newMan) {
        man = newMan;
    }
}
