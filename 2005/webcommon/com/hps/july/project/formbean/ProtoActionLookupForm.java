package com.hps.july.project.formbean;

import com.hps.july.persistence.*;

/**
 * Форма lookup по выбору типового события.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class ProtoActionLookupForm extends com.hps.july.web.util.BrowseForm {
	private int projecttype;
	private int position;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ProtoActionLookupForm() {
	this.setFinderMethodName( "findByProjecttypeOrderByOrderAsc" );
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    Object[] ob = new Object[1];
    ob[0] = new Integer(projecttype);

    return ob;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:52:14)
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:52:14)
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2002 10:41:30)
 * @param newProjecttype int
 */
public void setProjecttype(int newProjecttype) {
	projecttype = newProjecttype;
}
}
