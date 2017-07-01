package com.hps.july.basestation.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;
import com.hps.july.trailcom.beans.*;

/**
 * Служебный класс-контейнер с информацией о смежных линиях связи
 */
public class NestedHopInfo {
	private int hopid;
	private int nestedPositionid;
	private String nestedPositionName;
	private String hopName;
public NestedHopInfo(HopAccessBean b, int myPosition)
{
	try {
		hopid = b.getHopsid();

		Enumeration el = (new HopLabelAccessBean()).findHopLabelsByHopid(new HopKey(hopid));
		if(el.hasMoreElements()) {
			HopLabelAccessBean hl = (HopLabelAccessBean)el.nextElement();
			hopName = hl.getHopsname();
		} else {
			hopName = "?";
		}
		
		int ea = b.getEquipmentid_enda();
		int eb = b.getEquipmentid_endb();

		int pAid = 0;
		int pBid = 0;
		String pAname = "";
		String pBname = "";

		// check ea
		ComEquipmentAccessBean comA = new ComEquipmentAccessBean();
		comA.setInitKey_storageplace(ea);
		comA.refreshCopyHelper();
		
		PositionAccessBean pA = comA.getPosition();
		if(pA != null) {
			pAid = pA.getStorageplace();
			pAname = getPositionName(pA);
		}

		// check eb
		ComEquipmentAccessBean comB = new ComEquipmentAccessBean();
		comB.setInitKey_storageplace(eb);
		comB.refreshCopyHelper();
		PositionAccessBean pB = comB.getPosition();
		if(pB != null) {
			pBid = pB.getStorageplace();
			pBname = getPositionName(pB);
		}

		if(pAid == myPosition) {
			nestedPositionid = pBid;
			nestedPositionName = pBname;
		} else if(pBid == myPosition) {
			nestedPositionid = pAid;
			nestedPositionName = pAname;
		} else {
			nestedPositionid = 0;
			nestedPositionName = null;
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * 
 * @return int
 */
public int getHopid() {
	return hopid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHopName() {
	return hopName;
}
/**
 * 
 * @return int
 */
public int getNestedPositionid() {
	return nestedPositionid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNestedPositionName() {
	return nestedPositionName;
}
public String getPositionName(PositionAccessBean p)
{
	String res = "";
	try {
		if(p.getGsmid() != null) {
			res += "D" + p.getGsmid() + " ";
		}
		if(p.getDampsid() != null) {
			res += "A" + p.getDampsid() + " ";
		}
		res += p.getName();
		return res;
	} catch(Exception e) {
		return "?";
	}
}
/**
 * 
 * @param newHopid int
 */
public void setHopid(int newHopid) {
	hopid = newHopid;
}
/**
 * 
 * @param newHopName java.lang.String
 */
public void setHopName(java.lang.String newHopName) {
	hopName = newHopName;
}
/**
 * 
 * @param newNestedPositionid int
 */
public void setNestedPositionid(int newNestedPositionid) {
	nestedPositionid = newNestedPositionid;
}
/**
 * 
 * @param newNestedPositionName java.lang.String
 */
public void setNestedPositionName(java.lang.String newNestedPositionName) {
	nestedPositionName = newNestedPositionName;
}
}
