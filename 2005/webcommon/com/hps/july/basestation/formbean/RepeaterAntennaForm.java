package com.hps.july.basestation.formbean;

import com.hps.july.basestation.valueobject.CableValue;
import com.hps.july.cdbc.objects.*;
import com.hps.july.persistence2.*;
import com.hps.july.commonbean.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.persistence.*;
import java.math.BigDecimal;

/**
 * Форма редактирования антенны репитера
 */
public class RepeaterAntennaForm 
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
	return com.hps.july.basestation.APPStates.REPEATER_ANTENNA_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (08.09.2003 10:03:15)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
public String getSumnakl() throws Exception {
/*
	try {
*/
        if (getAction().equals("Add"))
            return "";

		BigDecimal s1 = getNakl() == null ? new BigDecimal(0) : getNakl();
		return s1.toString();
/*
		if("D".equals(getBsForm().getStationType())) {
			if(getEa800()ea800.getBigDecimal() != null) {
				return s1.add(ea800.getBigDecimal()).toString();
			} else {
				return s1.toString();
			}
		} else {
			BigDecimal m1 = ea900.getBigDecimal() == null?new BigDecimal(0.0):ea900.getBigDecimal();
			BigDecimal m2 = ea1800.getBigDecimal() == null?new BigDecimal(0.0):ea1800.getBigDecimal();
			m1 = m1.add(s1);
			m2 = m2.add(s1);
			if(m1.equals(m2)) {
				return m1.toString();
			} else {
				return m1.toString() + "/" + m2.toString();
			}
		}
    } catch (Exception e) {
        DebugSupport.printlnError(e, "may be from validation");
        return "";
    }
*/
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	setStorageplace(((RepeaterForm) request.getSession().getAttribute("RepeaterForm")).getStorageplace());
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
//		super.initRecord(request);
		super.clearRecord(request);
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
public void setEquipment(EquipmentSetAccessBean newEq) throws Exception {
}
/**
 * Insert the method's description here.
 * Creation date: (08.09.2003 10:03:15)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
public void updateCables()
	throws Exception
{
	deleteCables();
	updateOneCable(getCab1());
	updateOneCable(getCab2());
}
public void updateOneCable(CableValue cv)
	throws Exception
{
	if(cv.getCabletype().getInteger() == null || cv.getCabletype().getInteger().intValue() == 0) {
		return;
	}
	CDBCResourcesObject ro = new CDBCResourcesObject();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	AntennaCableAccessBean ac;
	int argCable = keyGen.getNextKey("tables.antennacables");
	cv.setId(new Integer(argCable));
	ac = new AntennaCableAccessBean(
		argCable,
		getIdanten(),
		cv.getCabletype().getInteger().intValue(),
		cv.getLength().getBigDecimal()
	);
	ac.setGroundresource(ro.getCableGroundResource(new Integer(argCable)));
	ac.setGroundcnt(cv.getGnds().getInteger());
	ac.commitCopyHelper();
/*
	if(bandcodes != null && bandcodes.length > 0) {
		for(int i = 0; i < bandcodes.length; i++) {
//			short band = (short)bandcodes[i];
			BigDecimal bd = null;
			switch(bandcodes[i]) {
				case 800: bd = cv.getKsvn800().getBigDecimal(); break;
				case 900: bd = cv.getKsvn900().getBigDecimal(); break;
				case 1800: bd = cv.getKsvn1800().getBigDecimal(); break;
				case 2000: bd = cv.getKsvn2000().getBigDecimal(); break;
			}
			if(bd != null) {
					CableWorkParamsAccessBean cwp
						= new CableWorkParamsAccessBean((short)bandcodes[i],getIdanten(),cv.getId().intValue());
					cwp.setKsvn(bd);
					cwp.commitCopyHelper();
			}
		}
	}
*/
}
}
