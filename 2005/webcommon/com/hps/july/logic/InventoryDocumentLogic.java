/*
 * Created on 30.05.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.logic;

/**
 * @author ria
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class InventoryDocumentLogic {
	
	public static boolean isAssembleForEditMountAct2(Integer visualType) {
		boolean outBool = com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ALCATEL.equals(visualType) ||
					  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ERIC.equals(visualType) ||
					  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_NOKIA.equals(visualType) ||
					  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_SIEMENS.equals(visualType) ||
					  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_HUAWEI.equals(visualType);
		return outBool;		
	}
	
	public static boolean isDocForEdit(String docState, String isAutoDocStr) {
		boolean isAutoDoc = "Y".equals(isAutoDocStr);
		boolean outBool = "1".equals(docState) && !isAutoDoc;
		return outBool;
	}

	public static boolean isAssembleForMountAct2Edit2(Integer visualType) {
		boolean outBool = com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ALCATEL_N.equals(visualType) ||
						  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ERIC_N.equals(visualType) ||
						  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_NOKIA_N.equals(visualType) ||
						  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_SIEMENS_N.equals(visualType) ||
						  com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_HUAWEI_N.equals(visualType);
		return outBool;						   
	}	
	
	public static boolean isAFS1800or900(Integer visualType) {
		boolean outBool = com.hps.july.logic.VisualDocTypes.AFS_MOUNT_ACT_1800.equals(visualType) ||
					  com.hps.july.logic.VisualDocTypes.AFS_MOUNT_ACT_900.equals(visualType);
		return outBool;
	}
	
	public static boolean isAFS1800and900(Integer visualType) {
		boolean outBool = com.hps.july.logic.VisualDocTypes.AFS_MOUNT_ACT_1800_900.equals(visualType);
		return outBool;
	}
		
}
