package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import com.hps.july.siteinfo.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма списка элементов оборудования
 */
public class EquipdetListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private java.lang.String complectname;
	
	private String objectUrl;
	private String objectMenuKey;
	private String objectListUrl;
	private String objectListMenuKey;

	public EquipmentObject eqobj;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public EquipdetListForm() {
	this.setFinderMethodName( "findByStorageNotAgregatedOrderByResourceAsc" );
	storageplace = 0;
	posname = "";
	posid = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2003 19:35:40)
 */
public void calculateObject() {
    try {
        DebugSupport.printlnTest(
            "EquipdetListForm calculateObject new!! storageplace=" + storageplace);
        //int objId = Integer.parseInt(getStorageplace());

        EquipmentSetAccessBean eBean = new EquipmentSetAccessBean();
        eBean.setInitKey_storageplace(storageplace);
        eBean.refreshCopyHelper();
        DebugSupport.printlnTest(
            "EquipdetListForm calculateObject eBean.getEJBRef()=" + eBean.getEJBRef());

        if (eBean.getEJBRef() instanceof Switch) {
            objectMenuKey = "menu.switch";
            objectUrl = "/EditSwitch.do";
            objectListMenuKey = "menu.switchList";
            objectListUrl = "/ShowSwitchList.do";

        } else if (eBean.getEJBRef() instanceof BaseStation) {
            objectMenuKey = "label.equipment.type.basestation";
            objectUrl = "/Edit_ViewFactBaseStation.do";
            objectListMenuKey = "menu.baseStationList";
            objectListUrl = "/ShowBaseStationList.do";
        } else if (eBean.getEJBRef() instanceof Controller) {
            objectMenuKey = "menu.controller";
            objectUrl = "/EditController.do";
            objectListMenuKey = "menu.controllerlist";
            objectListUrl = "/ShowControllerList.do";
        } else if (eBean.getEJBRef() instanceof Repiter) {
            //objectMenuKey = "menu.controller";
            //objectUrl = "/EditController.do";
            //objectListMenuKey = "menu.controllerlist";
            //objectListUrl = "/ShowControllerList.do";
        }

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        //throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getBsRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteStation");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 11:13:37)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getComRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	roles.add("siteExploitor");
	roles.add("siteStation");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 14:16:45)
 * @return com.hps.july.siteinfo.valueobject.EquipmentObject
 */
public EquipmentObject getEqobj() {
	return eqobj;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(storageplace) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 16:45:15)
 * @return java.lang.String
 */
public java.lang.String getObjectListMenuKey() {
	return objectListMenuKey;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 16:45:15)
 * @return java.lang.String
 */
public java.lang.String getObjectListUrl() {
	return objectListUrl;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 14:19:07)
 * @return java.lang.String
 */
public java.lang.String getObjectMenuKey() {
	return objectMenuKey;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 14:19:07)
 * @return java.lang.String
 */
public java.lang.String getObjectUrl() {
	return objectUrl;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getOtherRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 18:31:02)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 11:13:37)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 14:16:45)
 * @param newEqobj com.hps.july.siteinfo.valueobject.EquipmentObject
 */
public void setEqobj(EquipmentObject newEqobj) {
	eqobj = newEqobj;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 16:45:15)
 * @param newObjectListMenuKey java.lang.String
 */
public void setObjectListMenuKey(java.lang.String newObjectListMenuKey) {
	objectListMenuKey = newObjectListMenuKey;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 16:45:15)
 * @param newObjectListUrl java.lang.String
 */
public void setObjectListUrl(java.lang.String newObjectListUrl) {
	objectListUrl = newObjectListUrl;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 14:19:07)
 * @param newObjectMenuKey java.lang.String
 */
public void setObjectMenuKey(java.lang.String newObjectMenuKey) {
	objectMenuKey = newObjectMenuKey;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 14:19:07)
 * @param newObjectUrl java.lang.String
 */
public void setObjectUrl(java.lang.String newObjectUrl) {
	objectUrl = newObjectUrl;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 18:31:02)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
