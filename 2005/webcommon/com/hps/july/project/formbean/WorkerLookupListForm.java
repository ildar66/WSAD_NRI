package com.hps.july.project.formbean;

import com.hps.july.persistence.*;

/**
 * Форма lookup по выбору работника.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkerLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String lastname;
	private java.lang.Integer divcode;
	private java.lang.String divname;
	private java.lang.String searchby;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerLookupListForm() {
	this.setFinderMethodName( "findByQBE" );
	lastname = "";
	divname = "";
	searchby = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 11:02:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getDivcode() {
	return divcode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 10:06:16)
 * @return java.lang.String
 */
public java.lang.String getDivname() {
	return divname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	if ("N".equals(searchby))
		return new Object[] { Boolean.FALSE, new Integer(0), Boolean.TRUE, lastname, Boolean.TRUE, Boolean.TRUE, new Integer(1) };
	else
		return new Object[] { Boolean.TRUE, divcode==null?new Integer(0):divcode, Boolean.FALSE, "", Boolean.TRUE, Boolean.TRUE, new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 11:20:12)
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 11:04:23)
 * @return java.lang.String
 */
public java.lang.String getSearchby() {
	return searchby;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 11:02:36)
 * @param newDivcode java.lang.Integer
 */
public void setDivcode(java.lang.Integer newDivcode)throws Exception {
	divcode = newDivcode;
	DivisionAccessBean bean=new DivisionAccessBean();
	bean.setInitKey_division(divcode.intValue());
	bean.refreshCopyHelper();
	divname=bean.getName();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 10:06:16)
 * @param newDivname java.lang.String
 */
public void setDivname(java.lang.String newDivname) {
	divname = newDivname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 11:20:12)
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 22:31:22)
 * @param newProjectactiontypeCode java.lang.Integer
 */
public void setProjectactiontypeCode(int newProjectactiontypeCode)throws Exception {
System.out.println("setProjectactiontypeCode "+newProjectactiontypeCode);
    ProjectActionTypeAccessBean bean = new ProjectActionTypeAccessBean();
    bean.setInitKey_projectactiontype(newProjectactiontypeCode);
    bean.refreshCopyHelper();
    setDivcode(new Integer(bean.getAction2division().getDivision()));

}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 11:04:23)
 * @param newSearchby java.lang.String
 */
public void setSearchby(java.lang.String newSearchby) {
	searchby = newSearchby;
}
}
