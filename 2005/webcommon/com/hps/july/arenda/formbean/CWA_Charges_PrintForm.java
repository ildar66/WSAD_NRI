package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (16.11.2004 11:55:55)
 * @author: Shafigullin Ildar
 */
public class CWA_Charges_PrintForm extends ActionForm {
	private int idcwacode;
	private LinkedList list = new LinkedList();
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 12:46:18)
 * @return int
 */
public int getIdcwacode() {
	return idcwacode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 12:52:47)
 * @return java.util.ArrayList
 */
public LinkedList getList() {
	return list;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 12:34:35)
 * @exception java.lang.Exception The exception description.
 */
public void init() throws java.lang.Exception {

	CDBCResultSet rs = CDBCLeaseChargesObject.findByCWA(Boolean.TRUE, new Integer(getIdcwacode()), "date desc");
	java.util.ListIterator iter = rs.listIterator();
	while (iter.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject) iter.next();
		LeaseChargeVO vo = new LeaseChargeVO(ro);
		vo.setRate((java.math.BigDecimal)ro.getColumn("rate").asObject());
		list.add(vo);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 12:46:18)
 * @param newIdcwacode int
 */
public void setIdcwacode(int newIdcwacode) {
	idcwacode = newIdcwacode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.11.2004 12:52:47)
 * @param newList java.util.ArrayList
 */
public void setList(LinkedList newList) {
	list = newList;
}
}
