package com.hps.july.platinum.valueobject;

import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.util.*;

public class EquipmentObject {
	public static MessageResources messageRes = MessageResources.getMessageResources("com.hps.july.platinum.ApplicationResources");
public static String getEquipmentSetName(EquipmentSetAccessBean eqset) throws java.lang.Exception {
	String result = "?";
	try {
		if (eqset.getEJBRef() instanceof BaseStation) {
			BaseStationAccessBean equipmentSet = new BaseStationAccessBean(eqset.getEJBRef());
			// setEquipmentType("A");
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
}
