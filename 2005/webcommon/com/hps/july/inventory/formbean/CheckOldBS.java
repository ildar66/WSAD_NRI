/*
 * Created on 28.04.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.inventory.formbean;

import com.hps.july.cdbc.objects.*;

public class CheckOldBS {
	static boolean isEnabledCloseFKBS(){
		return (com.hps.july.util.AppUtils.getNamedValueInt("FlagNewFKBS")!=0);
	}
	public static boolean canProcessFKBS(Integer idComplect){
		boolean result = true;
		if (isEnabledCloseFKBS()){
			char type = CDBCDocuments.getStoragePlaceType(idComplect);
			if (type == 'B'){
				char typeBS = CDBCDocuments.getBaseStationType(idComplect);
				if (typeBS=='S' || typeBS=='C' || typeBS=='G')
					result = false;
			} 
		}
		return result;
	}
}
