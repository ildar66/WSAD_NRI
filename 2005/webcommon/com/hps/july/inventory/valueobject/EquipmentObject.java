package com.hps.july.inventory.valueobject;

import javax.rmi.PortableRemoteObject;

import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.util.*;

/**
 * Служебный класс для получения наименований комплектов оборудования
 */
public class EquipmentObject {
	public static MessageResources messageRes = MessageResources.getMessageResources("com.hps.july.inventory.ApplicationResources");
public static String getEquipmentSetName(EquipmentSetAccessBean eqset) throws java.lang.Exception {
	String result = "?";
	String prefix = "equipment";
//	String prefix = "equshort";
	try {
		eqset.refreshCopyHelper();
		if (eqset.getEJBRef() instanceof BaseStation) {
			BaseStationAccessBean equipmentSet = new BaseStationAccessBean(eqset.getEJBRef());
			// setEquipmentType("A");
			result = messageRes.getMessage("label."+prefix+".type.basestation") + " ";
			String stationType = equipmentSet.getStationType();
			if("D".equals(stationType)) {
				result += messageRes.getMessage("label."+prefix+".stationdamps");
			} else if("S".equals(stationType)) {
				result += messageRes.getMessage("label."+prefix+".stationgsm");
			} else if("C".equals(stationType)) {
				result += messageRes.getMessage("label."+prefix+".stationdcs");
			} else if("G".equals(stationType)) {
				result += messageRes.getMessage("label."+prefix+".stationboth");
			}
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof ComEquipment) {
			ComEquipmentAccessBean equipmentSet = new ComEquipmentAccessBean(eqset.getEJBRef());
			// setEquipmentType("B");
			result = messageRes.getMessage("label."+prefix+".type.comequipment");
			String type = equipmentSet.getComEquipmentType();
			if("R".equals(type)) {
				result += " " + messageRes.getMessage("label."+prefix+".comequipmenttype.radio");
			} else if("O".equals(type)) {
				result += " " + messageRes.getMessage("label."+prefix+".comequipmenttype.optic");
			} else if("A".equals(type)) {
//				result += messageRes.getMessage("label."+prefix+".comequipmenttype.other");
			}
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
			if("O".equals(type) && equipmentSet.getOsinvname() != null && !"".equals(equipmentSet.getOsinvname())) {
				result += " ("+equipmentSet.getOsinvname();
			}
		} else
		if (eqset.getEJBRef() instanceof Controller) {
			ControllerAccessBean equipmentSet = new ControllerAccessBean(eqset.getEJBRef());
			// setEquipmentType("C");
			result = messageRes.getMessage("label."+prefix+".type.controller");
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof Switch) {
			SwitchAccessBean equipmentSet = new SwitchAccessBean(eqset.getEJBRef());
			// setEquipmentType("D");
			result = messageRes.getMessage("label."+prefix+".type.switch") + " ";
			String type = equipmentSet.getSwitchType();
			if("1".equals(type)) {
				result += messageRes.getMessage("label."+prefix+".switchdamps");
			} else if("2".equals(type)) {
				result += messageRes.getMessage("label."+prefix+".switchgsm");
			}
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof Repiter) {
			RepiterAccessBean rep = new RepiterAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label."+prefix+".type.repeater");
			if(rep.getName() != null) {
				result += ", " + rep.getResource().getModel();
			}
		} else
		if (eqset.getEJBRef() instanceof OtherEquipment) {
			OtherEquipmentAccessBean equipmentSet = new OtherEquipmentAccessBean(eqset.getEJBRef());
			// setEquipmentType("E");
			result = ""; // messageRes.getMessage("label."+prefix+".type.other") + " ";
			String type = equipmentSet.getOtherEquipmentType();
			if("A".equals(type)) {
				result += messageRes.getMessage("label."+prefix+".othertypea");
			} else if("B".equals(type)) {
				result += messageRes.getMessage("label."+prefix+".othertypeb");
			} else if("C".equals(type)) {
				result += messageRes.getMessage("label."+prefix+".othertypec");
			} else if("D".equals(type)) {
				result += messageRes.getMessage("label."+prefix+".othertyped");
			} else if("E".equals(type)) {
				result += messageRes.getMessage("label."+prefix+".othertypee");
			}
//			if(equipmentSet.getName() != null) {
//				result += ", " + equipmentSet.getName();
//			}
		} else 
		if (eqset.getEJBRef() instanceof WLAN) {
			WLANAccessBean equipmentSet = new WLANAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label."+prefix+".type.wlan");
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else {
			String clzname = (eqset.getEJBRef() != null)?" : "+eqset.getEJBRef().getClass().getName():"";
			result = messageRes.getMessage("label."+prefix+".type.unknown") + clzname;
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	return result;
}
public static String getEquipmentSetNameOnly(EquipmentSetAccessBean eqset) throws java.lang.Exception {
	String result = "?";
	try {
		eqset.refreshCopyHelper();
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
			} else if("A".equals(type)) {
				result += messageRes.getMessage("label.equipment.comequipmenttype.other");
			}
		} else
		if (eqset.getEJBRef() instanceof Controller) {
//			ControllerAccessBean equipmentSet = new ControllerAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.controller");
		} else
		if (eqset.getEJBRef() instanceof Switch) {
			SwitchAccessBean equipmentSet = new SwitchAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.switch") + " ";
			String type = equipmentSet.getSwitchType();
			if("1".equals(type)) {
				result += messageRes.getMessage("label.equipment.switchdamps");
			} else if("2".equals(type)) {
				result += messageRes.getMessage("label.equipment.switchgsm");
			}
		} else
		if (eqset.getEJBRef() instanceof Repiter) {
//			RepiterAccessBean rep = new RepiterAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.repeater");
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
			} else if("E".equals(type)) {
				result += messageRes.getMessage("label.equipment.othertypee");
			}
		} else 
		if (eqset.getEJBRef() instanceof WLAN) {
			WLANAccessBean equipmentSet = new WLANAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equipment.type.wlan");
			/*
			if(equipmentSet.getName() != null) {
				result += " " + equipmentSet.getName();
			}
			result += " " + equipmentSet.getNumber();
			*/
		} else {
			String clzname = (eqset.getEJBRef() != null)?" : "+eqset.getEJBRef().getClass().getName():"";
			result = messageRes.getMessage("label.equipment.type.unknown") + clzname;
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	return result;
}
public static String getShortEquipmentTypeName(EquipmentSetAccessBean eqset) throws java.lang.Exception {
	String result = "?";
	try {
		eqset.refreshCopyHelper();
		if (eqset.getEJBRef() instanceof BaseStation) {
			BaseStationAccessBean equipmentSet = new BaseStationAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equshort.type.basestation") + " ";
			String stationType = equipmentSet.getStationType();
			if("D".equals(stationType)) {
				result += messageRes.getMessage("label.equshort.stationdamps");
			} else if("S".equals(stationType)) {
				result += messageRes.getMessage("label.equshort.stationgsm");
			} else if("C".equals(stationType)) {
				result += messageRes.getMessage("label.equshort.stationdcs");
			} else if("G".equals(stationType)) {
				result += messageRes.getMessage("label.equshort.stationboth");
			}
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof ComEquipment) {
			ComEquipmentAccessBean equipmentSet = new ComEquipmentAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equshort.type.comequipment") + " ";
			String type = equipmentSet.getComEquipmentType();
			if("R".equals(type)) {
				result += messageRes.getMessage("label.equshort.comequipmenttype.radio");
			} else if("O".equals(type)) {
				result += messageRes.getMessage("label.equshort.comequipmenttype.optic");
			} else if("A".equals(type)) {
//				result += messageRes.getMessage("label.equshort.comequipmenttype.other");
			}
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof Controller) {
			ControllerAccessBean equipmentSet = new ControllerAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equshort.type.controller");
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof Switch) {
			SwitchAccessBean equipmentSet = new SwitchAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equshort.type.switch") + " ";
			String type = equipmentSet.getSwitchType();
			if("1".equals(type)) {
				result += messageRes.getMessage("label.equshort.switchdamps");
			} else if("2".equals(type)) {
				result += messageRes.getMessage("label.equshort.switchgsm");
			}
			result += " " + equipmentSet.getNumber();
			if(equipmentSet.getName() != null) {
				result += ", " + equipmentSet.getName();
			}
		} else
		if (eqset.getEJBRef() instanceof Repiter) {
			result = messageRes.getMessage("label.equshort.type.repeater");
		} else
		if (eqset.getEJBRef() instanceof OtherEquipment) {
			OtherEquipmentAccessBean equipmentSet = new OtherEquipmentAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equshort.type.other") + " ";
			String type = equipmentSet.getOtherEquipmentType();
			if("A".equals(type)) {
				result += messageRes.getMessage("label.equshort.othertypea");
			} else if("B".equals(type)) {
				result += messageRes.getMessage("label.equshort.othertypeb");
			} else if("C".equals(type)) {
				result += messageRes.getMessage("label.equshort.othertypec");
			} else if("D".equals(type)) {
				result += messageRes.getMessage("label.equshort.othertyped");
			} else if("E".equals(type)) {
				result += messageRes.getMessage("label.equshort.othertypee");
			}
		} else
		if (eqset.getEJBRef() instanceof WLAN) {
			WLANAccessBean equipmentSet = new WLANAccessBean(eqset.getEJBRef());
			result = messageRes.getMessage("label.equshort.type.wlan");
		}
		else {
			String clzname = (eqset.getEJBRef() != null)?" : "+eqset.getEJBRef().getClass().getName():"";
			result = messageRes.getMessage("label.equshort.type.unknown") + clzname;
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	return result;
}
}
