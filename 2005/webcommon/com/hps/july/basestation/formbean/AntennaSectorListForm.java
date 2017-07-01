package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBCEquipmentObject;
import java.util.*;
import java.sql.*;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма списка антенн сектора
 */
public class AntennaSectorListForm extends com.hps.july.web.util.BrowseForm {
	private FactBaseStationForm bsForm;
	private String state = BaseStationObject.STATE_CHECK_READY_R;	
public Enumeration getAntennes() {
    try {
        return new AntennaAccessBean().findByEquipmentOrderByNumAsc(new Integer(bsForm.getBasestation()));
    } catch (javax.ejb.FinderException e) {
        return new java.util.Vector().elements();
    } catch (Exception e1) {
	    e1.printStackTrace(System.out);
        return new java.util.Vector().elements();
//        new com.hps.july.jdbcpersistence.lib.DebugSupport().printlnError(e1,"findAntennes()",this);
//        throw new ServletException(e1);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 11:33:15)
 * @return com.hps.july.basestation.formbean.BaseStationForm
 */
public FactBaseStationForm getBsForm() {
	return bsForm;
}
/**
 * Insert the method's description here.
 * Creation date: (06.04.2003 20:35:47)
 * @return java.lang.Object
 */
public Object[] getFilterParams() {
	return null;
}
/**
 * Выдаёт список секторов для текущей базовой станции
 * @return java.util.Iterator - коллекция CDBCRowObject
 */
public Iterator getSectors() {
	CDBCEquipmentObject o = new CDBCEquipmentObject();
	CDBCResultSet rs = o.findBaseStationSectors(new Integer(bsForm.getBasestation()), new Integer(1));
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 11:33:15)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 11:33:15)
 * @param newBsForm com.hps.july.basestation.formbean.BaseStationForm
 */
public void setBsForm(FactBaseStationForm newBsForm) {
	bsForm = newBsForm;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 11:33:15)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
	DebugSupport.printlnTest("setState "+state);
}
}
