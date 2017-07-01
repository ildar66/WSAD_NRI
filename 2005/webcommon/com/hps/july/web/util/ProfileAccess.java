package com.hps.july.web.util;

import java.util.*;

import com.hps.july.cdbc.objects.*;
import com.hps.july.valueobject.*;
/**
 * дл€ модул€ јренды(разделение по регионам и др.).
 * Creation date: (21.11.2005 13:42:40)
 * @author: Shafigullin Ildar
 */
public class ProfileAccess {
	private Integer operatorId = null;
	private List regionAccessList = null;
	private RegionsAccess_TO currRegion = null;
	/**
	 * ProfileArenda constructor comment.
	 */
	public ProfileAccess(Integer operId) {
		super();
		setOperatorId(operId);
		regionAccessList = CDBC_RegionsAccess_Object.findRegionAccsByOperator(operId, " regname ");
		initCurRegion(operId, regionAccessList);
	}

	/**
	 * 
	 * @param operId
	 */
	private void initCurRegion(Integer operId, List aRegionAccessList) {
		Integer currRegionID = CDBC_OperatorObject.find(operId).getLastRegionID();
		if (regionAccessList.size() > 0) {
			if (currRegionID != null) {
				for (int i = 0; i < aRegionAccessList.size(); i++) {
					com.hps.july.valueobject.RegionsAccess_TO to = (com.hps.july.valueobject.RegionsAccess_TO) regionAccessList.get(i);
					int regionID = to.getVo().getRegionid().intValue();
					if (regionID == currRegionID.intValue()) {
						setCurrRegion(to);
						break;
					}
				}
			}
			if (getCurrRegion() == null) {
				currRegion = (RegionsAccess_TO) regionAccessList.get(0);
			}
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.11.2005 14:51:24)
	 * @return com.hps.july.valueobject.RegionsAccess_TO
	 */
	public com.hps.july.valueobject.RegionsAccess_TO getCurrRegion() {
		return currRegion;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2005 13:55:10)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getOperatorId() {
		return operatorId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2005 15:36:39)
	 * @return java.util.List
	 */
	public java.util.List getRegionAccessList() {
		return regionAccessList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.11.2005 14:51:24)
	 * @param newCurrRegion com.hps.july.valueobject.RegionsAccess_TO
	 */
	private void setCurrRegion(com.hps.july.valueobject.RegionsAccess_TO newCurrRegion) {
		currRegion = newCurrRegion;
	}
	/**
	 * ”станавливаем текущий регион из списка доступных.
	 * Creation date: (22.11.2005 16:26:28)
	 */
	public boolean setCurrRegionID(Integer currRegionID) {
		for (int i = 0; i < regionAccessList.size(); i++) {
			com.hps.july.valueobject.RegionsAccess_TO to = (com.hps.july.valueobject.RegionsAccess_TO) regionAccessList.get(i);
			int regionID = to.getVo().getRegionid().intValue();
			if (regionID == currRegionID.intValue()) {
				setCurrRegion(to);
				CDBC_OperatorObject.updateLastRegionID(getOperatorId(), currRegionID);
				return true;
			}
		}
		return false;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2005 13:55:10)
	 * @param newOperatorId java.lang.Integer
	 */
	private void setOperatorId(java.lang.Integer newOperatorId) {
		operatorId = newOperatorId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2005 15:36:39)
	 * @param newRegionAccessList java.util.List
	 */
	private void setRegionAccessList(java.util.List newRegionAccessList) {
		regionAccessList = newRegionAccessList;
	}
}
