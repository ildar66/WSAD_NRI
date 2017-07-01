package com.hps.july.project.formbean;

import com.hps.july.project.*;
import com.hps.july.persistence.*;

/**
 * Форма списка событий типа проекта.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class ActionsProjectListForm extends com.hps.july.web.util.BrowseForm {
    private int projecttype;
    private String projecttypeName;
/**
 * TypeProjectListForm constructor comment.
 */
public ActionsProjectListForm() {

	setFinderMethodName("findByProjecttypeOrderByOrderAsc");

}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2002 11:35:40)
 * @return java.lang.String
 */
public String getCanAdd() throws Exception {

    ProtoActionAccessBean protoAction = new ProtoActionAccessBean();
    ProtoActionAccessBeanTable table = new ProtoActionAccessBeanTable();

    table.setProtoActionAccessBean(
        protoAction.findByProjecttypeOrderByOrderAsc(
            new Integer(projecttype)));
    int n1 = table.numberOfRows();

    ProjectActionTypeAccessBean projectActionType =
        new ProjectActionTypeAccessBean();
    ProjectActionTypeAccessBeanTable table1 =
        new ProjectActionTypeAccessBeanTable();

    table1.setProjectActionTypeAccessBean(
        projectActionType.findAllOrderByCodeAsc());
    int n2 = table1.numberOfRows();

    if (n2 > n1)
        return "true";
    else
        return "false";
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {new Integer(projecttype) };
}
/**
 * Insert the method's description here.
 * Creation date: (09.10.2002 9:57:10)
 * @return int
 */
public int getProjecttype() {
	return projecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 18:49:34)
 * @return java.lang.String
 */
public java.lang.String getProjecttypeName() {
	return projecttypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.10.2002 9:57:10)
 * @param newProjecttype int
 */
public void setProjecttype(int newProjecttype) {
	projecttype = newProjecttype;
	// Get name
	try {
		ProjectTypeAccessBean bn = new ProjectTypeAccessBean();
		bn.setInitKey_projecttype(newProjecttype);
		bn.refreshCopyHelper();
		setProjecttypeName(bn.getName());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2002 18:49:34)
 * @param newProjecttypeName java.lang.String
 */
public void setProjecttypeName(java.lang.String newProjecttypeName) {
	projecttypeName = newProjecttypeName;
}
}
