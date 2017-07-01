package com.hps.july.cdbc.objects;

import java.util.LinkedList;
import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с номерами BeeNet
 */
public class CDBCBeenetObject {
public CDBCBeenetObject() {
	super();
}
public boolean deleteEquipmentLinks(Integer equipment)
	throws Exception
{
	CDBCResultSet res = new CDBCResultSet();

	if(equipment == null) {
		throw new Exception("emptyequipment");
	}
	// Delete beenet links for this equipment
	return res.executeUpdate("DELETE FROM beenet2equip WHERE equipment = ?", new Object[] {equipment});
}
/**
 * Возвращает полный список категорий BeeNet
 */
public CDBCResultSet findBeeNetCategories() {
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(
		"SELECT categid, categname, pattern FROM beenetcategory ORDER BY categname ASC",
		new Object[] { }
	);
	return res;
}
/**
 * Возвращает список BeeNet номеров на указаннном оборудовании.
 * Возвращаемые поля: (String beenetid)
 * @param Integer equipment - код оборудования
 * @param Integer order - код варианта сортировки
 *		1 - Номер BeeNet ASC
 *		2 - Номер BeeNet DESC
 */
public CDBCResultSet findEquipmentBeeNets(Integer equipment, Integer order) {
	CDBCResultSet res = new CDBCResultSet();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT be.beenetid FROM beenet2equip be WHERE ");
	if(equipment != null) {
		sqlb.append("be.equipment = ? ");
		params.add(equipment);
	} else {
		sqlb.append("be.equipment IS NULL ");
	}
	if(order != null) {
		switch(order.intValue()) {
		case 1:
			sqlb.append("ORDER BY be.beenetid ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY be.beenetid DESC ");
			break;
		}
	}
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public String findOtherBeenetsString(Integer equipment, String beenetid)
{
	if(equipment == null) {
		return "";
	}
	if(beenetid == null) {
		beenetid = "";
	}
	
	CDBCResultSet res = new CDBCResultSet();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT beenetid FROM beenet2equip WHERE equipment = ? AND beenetid <> ?");
	params.add(equipment);
	params.add(beenetid);
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.ListIterator li = res.listIterator();
	String result = "";
	while(li.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)li.next();
		result += org.apache.struts.util.ResponseUtils.filter(ro.getColumn("beenetid").asString());
		if(li.hasNext()) {
			result += ",<BR>";
		}
	}
	return result;
}
/**
 * Возвращает список уникальных BeeNet номеров на указанной позиции.
 * Возвращаемые поля: (Integer)"categid", (String)"categname", (String)"pattern"
 * @param Integer position - код позиции
 * @param Integer order - код варианта сортировки
 *		1 - Номер BeeNet ASC
 *		2 - Номер BeeNet DESC
 */
public CDBCResultSet findPositionBeeNets(Integer position, Integer order) {
	CDBCResultSet res = new CDBCResultSet();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT bo.beenetid, bc.categname FROM beenetobjects bo, beenetcategory bc WHERE bo.categid = bc.categid ");
	if(position != null) {
		sqlb.append("AND bo.position = ? ");
		params.add(position);
	} else {
		sqlb.append("AND bo.position IS NULL ");
	}
	if(order != null) {
		switch(order.intValue()) {
		case 1:
			sqlb.append("ORDER BY bo.beenetid ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY bo.beenetid DESC ");
			break;
		}
	}
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public boolean isBeenetExist(String beenetid) {
	if(beenetid == null) {
		return true;
	}
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(
		"SELECT bo.beenetid, bo.categid, bo.position FROM beenetobjects bo WHERE bo.beenetid = ?",
		new Object[] { beenetid }
	);
	return (res.getRowsCount() > 0);
}
public boolean isBeenetUnique(String beenetid) {
	if(beenetid == null) {
		return true;
	}
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(
		"SELECT bo.beenetid, bo.categid, bo.position FROM beenetobjects bo WHERE bo.beenetid = ?",
		new Object[] { beenetid }
	);
	java.util.Iterator it = res.listIterator();
	return !it.hasNext();
}
public boolean isBeenetUnique(String beenetid, Integer equipment) {
	if(equipment == null) {
		return isBeenetUnique(beenetid);
	} else {
		if(beenetid == null) {
			return true;
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(
			"SELECT bo.beenetid, bo.categid, bo.position  FROM beenetobjects bo, beenet2equip b2e WHERE bo.beenetid = ? AND b2e.equipment = ? AND bo.beenetid <> b2e.beenetid ",
			new Object[] { beenetid, equipment }
		);
		java.util.Iterator it = res.listIterator();
		return !it.hasNext();
	}
}
public void updateEquipmentBeenet(String beenetid, Integer equipment)
	throws Exception
{
	CDBCResultSet res = new CDBCResultSet();

	if(equipment == null) {
		throw new Exception("emptyequipment");
	}
	// Delete beenet links for this equipment
	deleteEquipmentLinks(equipment);
	// if beenet != null create new link
	if(beenetid != null && !"".equals(beenetid.trim())) {
		res.executeUpdate("INSERT INTO beenet2equip(beenetid,equipment) VALUES (?,?)", new Object[] {beenetid, equipment});
/*
		if(!) {
			throw new Exception("createlink");
		}
*/
	}
}
}
