package com.hps.july.project.formbean;

import com.hps.july.persistence.*;

/**
 * Форма lookup по выбору комплекта оборудования.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class ComplectLookupListForm extends com.hps.july.web.util.BrowseForm {
	private int position;
	private String positionname;
	private String posid;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ComplectLookupListForm() {
	this.setFinderMethodName( "findEquipmentSetByPosition" );
	position = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new StoragePlaceKey(position) };
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 10:09:09)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 10:09:09)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
}
