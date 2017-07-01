package com.hps.july.siteinfo.formbean;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.*;
import org.apache.struts.util.*;

/**
 * Форма просмотра события в журнале
 */
public class JournalForm extends com.hps.july.web.util.EditForm {
	public static MessageResources messageRes = MessageResources.getMessageResources("com.hps.july.siteinfo.JournalResources");
	private int logid;
	private java.sql.Timestamp datetime;
	private String objecttype;
	private String objecttypename;
	private Integer objectid;
	private String objectname;
	private String userfullname;
	private String usertitle;
	private String eventtypecode;
	private String changes;
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception
{
    return null;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	ChangeLogAccessBean log = (ChangeLogAccessBean)bean;
	try {
		int oi = log.getObjid();
		short type = log.getObjtype();
		objecttypename = getObjecttypeName(""+type);
		objectname = getObjectName(""+type,oi);
		PeopleAccessBean p = log.getPeople();
		try {
			userfullname = p.getFullName();
			usertitle = null;
		} catch(Exception e) {
			userfullname = "Не удалось определить имя пользователя";
			usertitle = null;
		}
		datetime = log.getRecdate();
		eventtypecode = log.getEventtype();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
public java.lang.String getChanges() {
	return changes;
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
	ChangeLogAccessBean bean = new ChangeLogAccessBean();
	bean.setInitKey_logid(getLogid());
    return bean;
}
public java.sql.Timestamp getDatetime() {
	return datetime;
}
public static String getEquipmentSetName(EquipmentSetAccessBean eqset) throws java.lang.Exception {
	String result = "?";
	try {
		if (eqset.getEJBRef() instanceof BaseStation) {
			BaseStationAccessBean equipmentSet = new BaseStationAccessBean(eqset.getEJBRef());
			// setEquipmentType("A");
//			result = messageRes.getMessage("label.equipment.type.basestation") + " ";
			result = "";
			String stationType = equipmentSet.getStationType();
			if("D".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationdamps");
			} else if("S".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationgsm");
			} else if("C".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationdcs");
			} else if("G".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationboth");
			}
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof ComEquipment) {
			ComEquipmentAccessBean equipmentSet = new ComEquipmentAccessBean(eqset.getEJBRef());
			// setEquipmentType("B");
			result = messageRes.getMessage("label.equipment.type.comequipment") + " ";
			String type = equipmentSet.getComEquipmentType();
			if("R".equals(type)) {
				result += messageRes.getMessage("label.equipment.comequipmenttype.radio");
			} else if("O".equals(type)) {
				result += messageRes.getMessage("label.equipment.comequipmenttype.optic");
			}
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof Controller) {
			ControllerAccessBean equipmentSet = new ControllerAccessBean(eqset.getEJBRef());
			// setEquipmentType("C");
			result = messageRes.getMessage("label.equipment.type.controller");
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof Switch) {
			SwitchAccessBean equipmentSet = new SwitchAccessBean(eqset.getEJBRef());
			// setEquipmentType("D");
			result = messageRes.getMessage("label.equipment.type.switch") + " ";
			String type = equipmentSet.getSwitchType();
			if("1".equals(type)) {
				result += messageRes.getMessage("label.equipment.switchgsm");
			} else if("2".equals(type)) {
				result += messageRes.getMessage("label.equipment.switchdamps");
			}
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof OtherEquipment) {
			OtherEquipmentAccessBean equipmentSet = new OtherEquipmentAccessBean(eqset.getEJBRef());
			// setEquipmentType("E");
			result = ""; // messageRes.getMessage("label.equipment.type.other") + " ";
			String type = equipmentSet.getOtherEquipmentType();
			if("A".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertypea");
			} else if("B".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertypeb");
			} else if("C".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertypec");
			} else if("D".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertyped");
			}
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else {
			result = messageRes.getMessage("label.equipment.type.unknown") + " ";
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	return result;
}
public static String getEquipmentSetNameOnly(EquipmentSetAccessBean eqset) throws java.lang.Exception {
	String result = "?";
	try {
		if (eqset.getEJBRef() instanceof BaseStation) {
			BaseStationAccessBean equipmentSet = new BaseStationAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.basestation") + " ";
			String stationType = equipmentSet.getStationType();
			if("D".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationdamps");
			} else if("S".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationgsm");
			} else if("C".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationdcs");
			} else if("G".equals(stationType)) {
				result += messageRes.getMessage("label.equipment.stationboth");
			}
		} else
		if (eqset.getEJBRef() instanceof ComEquipment) {
			ComEquipmentAccessBean equipmentSet = new ComEquipmentAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.comequipment") + " ";
			String type = equipmentSet.getComEquipmentType();
			if("R".equals(type)) {
				result += messageRes.getMessage("label.equipment.comequipmenttype.radio");
			} else if("O".equals(type)) {
				result += messageRes.getMessage("label.equipment.comequipmenttype.optic");
			}
		} else
		if (eqset.getEJBRef() instanceof Controller) {
			ControllerAccessBean equipmentSet = new ControllerAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.controller");
		} else
		if (eqset.getEJBRef() instanceof Switch) {
			SwitchAccessBean equipmentSet = new SwitchAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.switch") + " ";
			String type = equipmentSet.getSwitchType();
			if("1".equals(type)) {
				result += messageRes.getMessage("label.equipment.switchgsm");
			} else if("2".equals(type)) {
				result += messageRes.getMessage("label.equipment.switchdamps");
			}
		} else
		if (eqset.getEJBRef() instanceof OtherEquipment) {
			OtherEquipmentAccessBean equipmentSet = new OtherEquipmentAccessBean(eqset.getEJBRef());
			result = "";
			String type = equipmentSet.getOtherEquipmentType();
			if("A".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertypea");
			} else if("B".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertypeb");
			} else if("C".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertypec");
			} else if("D".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertyped");
			}
		} else {
			result = messageRes.getMessage("label.equipment.type.unknown") + " ";
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	return result;
}
public java.lang.String getEventtypecode() {
	return eventtypecode;
}
public Enumeration getLogDetails() {
	try {
		ChangeLogDetailsAccessBean cld = new ChangeLogDetailsAccessBean();
		return cld.findChangeLogDetailsesByChangelog(new ChangeLogKey(logid));
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
public int getLogid() {
	return logid;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getObjectid() {
	return objectid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjectname() {
	return objectname;
}
public static String getObjectName(String objtype, int objid)
{
	try {
		if("1".equals(objtype)) {
//			setObjecttypename("Базовая станция");
			BaseStationAccessBean a = new BaseStationAccessBean();
			a.setInitKey_storageplace(objid);
			a.refreshCopyHelper();
			String name = "";
			if(a.getPosition().getGsmid() != null) {
				name += "D"+a.getPosition().getGsmid()+" ";
			}
			if(a.getPosition().getDampsid() != null) {
				name += "A"+a.getPosition().getDampsid()+" ";
			}
			name += a.getName();
			return name;
		} else if("2".equals(objtype)) {
//			setObjecttypename("Сектор");
			SectorAccessBean a = new SectorAccessBean();
			a.setInitKey_idsect(objid);
			a.refreshCopyHelper();
			String name = a.getNamesect() + " " + a.getNumsect();
			return name;
		} else if("3".equals(objtype)) {
//			setObjecttypename("Антена");
			AntennaAccessBean a = new AntennaAccessBean();
			a.setInitKey_idanten(objid);
			a.refreshCopyHelper();
			String name =
				(a.getResource().getModel() != null)?a.getResource().getModel():"";
			name += " "+a.getNumant();
			return name;
		} else if("4".equals(objtype)) {
//			setObjecttypename("Позиция");
			PositionAccessBean a = new PositionAccessBean();
			a.setInitKey_storageplace(objid);
			a.refreshCopyHelper();
			String name = "";
			if(a.getGsmid() != null) {
				name += "D"+a.getGsmid()+" ";
			}
			if(a.getDampsid() != null) {
				name += "A"+a.getDampsid()+" ";
			}
			name += a.getName();
			return name;
		} else if("5".equals(objtype)) {
//			setObjecttypename("Хранилище");
			StoragePlaceAccessBean a = new StoragePlaceAccessBean();
			a.setInitKey_storageplace(objid);
			a.refreshCopyHelper();
			return a.getName();
		} else if("6".equals(objtype)) {
//			setObjecttypename("Оборудование");
			EquipmentSetAccessBean a = new EquipmentSetAccessBean();
			a.setInitKey_storageplace(objid);
			a.refreshCopyHelper();
			return getEquipmentSetName(a);
		} else if("7".equals(objtype)) {
			PositionAccessBean a = new PositionAccessBean();
			a.setInitKey_storageplace(objid);
			a.refreshCopyHelper();
			String name = "";
			if(a.getGsmid() != null) {
				name += "D"+a.getGsmid()+" ";
			}
			if(a.getDampsid() != null) {
				name += "A"+a.getDampsid()+" ";
			}
			name += a.getName();
			return name;
		} else {
			return "Неизвестный тип объета";
		}
	} catch(Exception ex) {
		ex.printStackTrace(System.out);
	}
	return "Ошибка при определении имени объекта";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjecttype() {
	return objecttype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjecttypename() {
	return objecttypename;
}
public static String getObjecttypeName(String objtype)
{
	if("1".equals(objtype)) {
		return "Базовая станция";
	} else if("2".equals(objtype)) {
		return "Сектор";
	} else if("3".equals(objtype)) {
		return "Антена";
	} else if("4".equals(objtype)) {
		return "Позиция";
	} else if("5".equals(objtype)) {
		return "Хранилище";
	} else if("6".equals(objtype)) {
		return "Оборудование";
	} else if("7".equals(objtype)) {
		return "Ответственный для позиции";
	} else {
		return "Неизвестный тип";
	}
}
public int getState() {
	return com.hps.july.siteinfo.APPStates.JOURNAL_VIEW;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getUserfullname() {
	return userfullname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getUsertitle() {
	return usertitle;
}
/**
 * 
 * @param newChanges java.lang.String
 */
public void setChanges(java.lang.String newChanges) {
	changes = newChanges;
}
public void setDatetime(java.sql.Timestamp newDatetime) {
	datetime = newDatetime;
}
/**
 * 
 * @param newEventtypecode java.lang.String
 */
public void setEventtypecode(java.lang.String newEventtypecode) {
	eventtypecode = newEventtypecode;
}
/**
 * 
 * @param newLogid int
 */
public void setLogid(int newLogid) {
	logid = newLogid;
}
/**
 * 
 * @param newObjectid java.lang.Integer
 */
public void setObjectid(java.lang.Integer newObjectid) {
	objectid = newObjectid;
}
/**
 * 
 * @param newObjectname java.lang.String
 */
public void setObjectname(java.lang.String newObjectname) {
	objectname = newObjectname;
}
/**
 * 
 * @param newObjecttype java.lang.String
 */
public void setObjecttype(java.lang.String newObjecttype) {
	objecttype = newObjecttype;
}
/**
 * 
 * @param newObjecttypename java.lang.String
 */
public void setObjecttypename(java.lang.String newObjecttypename) {
	objecttypename = newObjecttypename;
}
/**
 * 
 * @param newUserfullname java.lang.String
 */
public void setUserfullname(java.lang.String newUserfullname) {
	userfullname = newUserfullname;
}
/**
 * 
 * @param newUsertitle java.lang.String
 */
public void setUsertitle(java.lang.String newUsertitle) {
	usertitle = newUsertitle;
}
public void validateValues(ActionErrors errors)
	throws Exception
{
	errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.journal.updatenotsupported"));

	if (!errors.empty())
		throw new ValidationException();
}
}
