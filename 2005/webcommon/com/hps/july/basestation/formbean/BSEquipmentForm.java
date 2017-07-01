package com.hps.july.basestation.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.basestation.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.siteinfo.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;

/**
 * Базовая форма редактирования оборудования базовой станции
 */
public abstract class BSEquipmentForm extends EditCopyForm {
	private BaseStationAccessBean baseStation;
	private StringAndInteger bscode=new StringAndInteger();     
	private BaseStationForm bsForm;
	public java.lang.String path;
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:46:22)
 */
public BSEquipmentForm()
{
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
    try {
        refreshBaseStation();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public BaseStationAccessBean getBaseStation() throws Exception {
	return baseStation;
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:57:55)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getBscode() {
	return bscode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:57:55)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getBscodeFrm() {
	return bscode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:47:06)
 * @return com.hps.july.basestation.formbean.BaseStationForm
 */
public BaseStationForm getBsForm() {
    //DebugSupport.printlnTest("getBsForm started. bsForm=" + bsForm);
    return bsForm;
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2003 19:03:41)
 * @return java.lang.String
 */
public java.lang.String getPath() {
	return path;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		refreshBaseStation(); //refresh baseStation
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
private void refreshBaseStation()
	throws Exception
{
	try {
		System.out.println("BSEquipmentForm.baseStation:"+baseStation);
		if(baseStation != null) {
			System.out.println("BSEquipmentForm.baseStation.position:"+baseStation.getPosition());
			bsForm = new FactBaseStationForm();
			BeanUtils.copyProperties(bsForm, baseStation);
			bsForm.fillRecord(baseStation);
		}
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public void setBaseStation(BaseStationAccessBean val) throws Exception {
	baseStation=val;
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:57:55)
 * @param newBscode com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setBscode(Integer newBscode) {
	bscode.setInteger(newBscode);
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:57:55)
 * @param newBscode com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setBscodeFrm(String newBscode) throws Exception {
   // DebugSupport.printlnTest("setBscodeFrm started newBscode=" + newBscode);

    bscode.setString(newBscode);
    try {
        baseStation = new BaseStationAccessBean();
        baseStation.setInitKey_storageplace(getBscode().intValue());
        baseStation.refreshCopyHelper();
        DebugSupport.printlnTest("setBscodeFrm finished baseStation=" + baseStation);
    refreshBaseStation();
    DebugSupport.printlnTest("setBscodeFrm finished planstate=" + baseStation.getPosition().getPlanstate());
    
        } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:47:06)
 * @param newBsForm com.hps.july.basestation.formbean.BaseStationForm
 */
public void setBsForm(BaseStationForm newBsForm) {
	bsForm = newBsForm;
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2003 19:03:41)
 * @param newPath java.lang.String
 */
public void setPath(java.lang.String newPath) {
	path = newPath;
}
}
