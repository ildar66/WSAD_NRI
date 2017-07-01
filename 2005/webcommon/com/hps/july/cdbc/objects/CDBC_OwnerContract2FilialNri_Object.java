/*
 * Created on 05.04.2006
 *
 * "Заказчик" CDBC_Object.
 */
package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.valueobject.OwnerContract2FilialNri_VO;

/**
 * @author IShaffigulin
 *
 * "Заказчик" CDBC_Object.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_OwnerContract2FilialNri_Object {

	private static final String FIND_SQL =
		"SELECT idOwnerContract, getNameOrg(idOwnerContract,0) name FROM OwnerContract2FilialNri WHERE regionid = ? ";
	/**
	 * Список заказчиков.
	 * Creation date: (18.08.2005 14:29:42)
	 */
	public static List getList(Integer regID, String sortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(FIND_SQL);
		params.add(regID);
		//append order by clause:
		if (sortBy != null && !sortBy.trim().equals("")) {
			sb.append(" order by " + sortBy);
		}
		//System.err.println(sb.toString()); //temp
		res.executeQuery(sb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			OwnerContract2FilialNri_VO vo = new OwnerContract2FilialNri_VO((Integer)ro.getColumn("idOwnerContract").asObject(), ro.getColumn("name").asString());
			ret.add(vo);
		}
		return ret;
	}

}
