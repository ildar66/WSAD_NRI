/*
 * Created on 30.03.2007
 *
 * История изменения описей CDBC_Object.
 */
package com.hps.july.arenda.cdbcobjects;

import java.util.*;

import com.hps.july.arenda.valueobject.LeaseRegistryBuchDocsHistory_TO;
import com.hps.july.cdbc.lib.*;

/**
 * @author IShaffigulin
 *
 * История изменения описей CDBC_Object.
 */
public class CDBC_LeaseRegistryBuchDocsHistory_Object {
	private static final String FIND_SQL = "SELECT historyId, idRegistryDoc, man, actionTime, state, getNamePeople(man) peopleName FROM leaseRegistryBuchDocsHistory ";

	/**
	 * 
	 * @param aIdRegistryDoc
	 * @param aSortBy
	 * @return
	 */
	public static final List getList(Integer aIdRegistryDoc, String aSortBy) {
		List ret = new ArrayList();
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_SQL + " WHERE idRegistryDoc = ? ");
		params.add(aIdRegistryDoc);
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseRegistryBuchDocsHistory_TO to = null;
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			to = new LeaseRegistryBuchDocsHistory_TO(CDBC_Helper.createLeaseRegistryBuchDocsHistory(ro));
			to.setPeopleName(ro.getColumn("peopleName").asString());
			ret.add(to);
		}
		return ret;
	}
}
