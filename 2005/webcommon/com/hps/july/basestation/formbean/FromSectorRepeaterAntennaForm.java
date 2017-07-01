package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма редактирования антены репитера при переходе из сектора
 */
public class FromSectorRepeaterAntennaForm	
	extends AntennaForm
{
	private int storageplace;
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
    setIdanten(new KeyGeneratorAccessBean().getNextKey(TablesRef.ANTENNES));
	
    return new AntennaAccessBean(
    /*int argIdanten,*/ getIdanten(),
    /*int argResource,*/ getResourceId().intValue(),
    /*String argNumant,*/ getNumant(),
    /*String argKindant,*/ getKindant(),
    /*java.math.BigDecimal argNakl,*/ getNakl(),
    /*java.math.BigDecimal argAzant,*/ getAzant(),
    /*java.math.BigDecimal argHset1,*/ getHset1(),
    /*java.math.BigDecimal argLencable,*/ new java.math.BigDecimal(0.0),//getLencable(),
    /*int argEquipment*/ getStorageplace());
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public EquipmentSet getEquipment() throws Exception {
	RepiterAccessBean repeaterBean = new RepiterAccessBean();
	repeaterBean.setInitKey_storageplace(getStorageplace());
	repeaterBean.refreshCopyHelper();
	
    return (EquipmentSet) repeaterBean.getEJBRef();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.FROMSECTOR_REPEATER_ANTENNA_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (08.09.2003 10:02:45)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	setStorageplace(((FromSectorRepeaterForm) request.getSession().getAttribute("FromSectorRepeaterForm")).getStorageplace());
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	try {
		super.initRecord(request);
	} catch (Exception e) {
	}
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @param newBaseStation com.hps.july.persistence.BaseStationAccessBean
 */
public void setEquipment(EquipmentSetAccessBean newEq) throws Exception {
}
/**
 * Insert the method's description here.
 * Creation date: (08.09.2003 10:02:45)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
