package com.hps.july.inventory.service.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCBaseStationObject;
import com.hps.july.cdbc.objects.CDBCEquipmentObject;
import com.hps.july.inventory.formbean.BsVO;
import com.hps.july.inventory.valueobject.Complect;
import com.hps.july.jdbcpersistence.dao.JdbcDaoSupport;

/**
 * @author dimitry
 * Created 20.04.2006
 */
public class BaseStationDaoJdbc extends JdbcDaoSupport implements BaseStationDao {

	public List getBSResSetFromPosition(Integer positionId) {
	    List bsResSetList = new ArrayList();
		if (positionId == null) return bsResSetList; 
	    
		CDBCResultSet res = CDBCBaseStationObject.getBSResSetFromPosition(positionId.intValue(), null);
		Iterator it = res.listIterator();
		while(it.hasNext()) {	
			BsVO bs = new BsVO();	
			CDBCRowObject ro = (CDBCRowObject)it.next();
			String number = ro.getColumn("number").asString();		
			String type = ro.getColumn("type").asString();
			String name = ro.getColumn("name").asString();
			bs.setName(number + "    " + type + "  " + name);
			bs.setType(new Integer(number));
			bsResSetList.add(bs);
		}
		
		return bsResSetList;
	}
	
	
	public List findComplects(String positionNumber, String userName, Boolean isAdmin) {
		CDBCResultSet res = new CDBCEquipmentObject().findBaseStations(
				Boolean.TRUE, null,
				CDBCEquipmentObject.TYPE_SEARCH_GSM,
				Boolean.TRUE, null,
				Boolean.TRUE,	null,
				CDBCEquipmentObject.SEARCHBY_NUMBER,
				positionNumber,
				Boolean.TRUE,	null,
				Boolean.TRUE,	null,
				Boolean.FALSE,	 "PMRTW",
				"PE",
				null,
				isAdmin,
				userName,
				new Integer(CDBCEquipmentObject.ORDER_NAME_ASC));

		List result = new ArrayList();
		Iterator it = res.listIterator();
		while(it.hasNext()) {	
			Complect complect = new Complect();	
			CDBCRowObject row = (CDBCRowObject)it.next();
			complect.setId((Integer)row.getColumn("equipment").asObject());
			complect.setName(row.getColumn("name").asString());

			result.add(complect);
		}
		return result;
	}
	

	
	
}
