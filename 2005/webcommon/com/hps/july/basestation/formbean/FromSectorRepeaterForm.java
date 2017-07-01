package com.hps.july.basestation.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;

/**
 * Форма редактирования репитера при переходе из сектора
 */
public class FromSectorRepeaterForm extends RepeaterForm {
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws Exception
{
	return super.constructBean(request);
/*	
	DebugSupport.printlnTest("RepeaterForm constructBean getPositionId()=" + getPositionId());
	
//	setStorageplace(new KeyGeneratorAccessBean().getNextKey("tables.storageplaces"));
	System.out.println("getPositionId() - " + getPositionId());
	System.out.println("getPosition() - " + getPosition());
	
	return new RepiterAccessBean(
		getStorageplace(),	// argStorageplace int
		null,				// argDivision java.lang.Integer
		getName(),			// argName java.lang.String
		null,				// argAddress java.lang.String
		getPositionId(),	// argPosition java.lang.Integer
		new Integer(getDonor_sectCode()),	// argDonor_sect java.lang.Integer
		getDonor_type(),	// argDonor_type java.lang.String
		getRepiter_class(),	// argRepiter_class java.lang.String
		getResourcecode(),	// argResource java.lang.Integer
		getReppower()		// argReppower java.math.BigDecimal
	);
*/
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2003 11:21:17)
 * @return java.lang.String
 */
public String getListAttributeName() {
	return "FromSectorRepeaterList";
}
public int getState() {
    return com.hps.july.basestation.APPStates.FROMSECTOR_REPEATER_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	super.initRecord(request);
	
	FromSectorRepeaterList list = (FromSectorRepeaterList) request.getSession().getAttribute("FromSectorRepeaterList");
	setDonor_sectCode(list.getIdsect());
	
	setDonor_type(null);
	setRepiter_class(null);
	setReppower(null);
	setResourcecode(null);
	setAntennadonorcode(null);
	setDonorresourcename(null);
	setAzimut(null);
	setResourcename(null);
	setNumchanals(null);
	setBandwidth(null);

//	setPosition(null);
}
}
