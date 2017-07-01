/*
 * Created on 29.07.2006
 *
 * "тип объекта" из таблицы AdminRegionTypes
 */
package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.AdminRegionType_VO;

/**
 * @author IShaffigulin
 *
 * "тип объекта" из таблицы AdminRegionTypes
 */
public class CDBC_AdminRegionTypes_Object {
	private static ArrayList listAdminRegionTypes = null;
	private static final String FIND_SQL = "SELECT regionType, nameType FROM AdminRegionTypes order by nameType ";

	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2005 14:11:53)
	 */
	private final static void initListAdminRegionTypes() {
		try {
			listAdminRegionTypes = new ArrayList();
			CDBCResultSet res = new CDBCResultSet();
			res.executeQuery(FIND_SQL, null);
			ListIterator iter = res.listIterator();
			while (iter.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject) iter.next();
				Integer type = (Integer)ro.getColumn("regionType").asObject();
				String name = ro.getColumn("nameType").asString();
				AdminRegionType_VO vo = new AdminRegionType_VO(type, name);
				listAdminRegionTypes.add(vo);
			}
		} catch (Exception e) {
			System.out.println("CDBC_AdminRegionTypes_Object.initListAdminRegionTypes(): Ошибка формирования листа типов!!!");
			e.printStackTrace(System.out);
		}
	}
	/**
	 * @return
	 */
	public final static ArrayList getListAdminRegionTypes() {
		//if (listAdminRegionTypes == null) {
			initListAdminRegionTypes();
		//}
		return new ArrayList(listAdminRegionTypes);
	}

}
