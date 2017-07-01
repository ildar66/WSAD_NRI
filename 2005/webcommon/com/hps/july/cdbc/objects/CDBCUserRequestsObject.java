/*
 * Created on 01.02.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.dictionary.valueobject.PeopleRow;
import com.hps.july.dictionary.valueobject.UserRequestRow;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBCUserRequestsObject {
	/**
	 * Выдаёт список запросов пользователей по параметрам поиска
	 */
	public static ArrayList findRequestsConditional(
		java.sql.Date datetimein_from,
		java.sql.Date datetimein_to,
		Boolean byrequesttype,
		Integer requesttype,
		Boolean byfilialtype,
		Integer filialtype,
		Boolean byfilial,		
		Integer filial,
		Boolean byregion,
		Integer region,
		Boolean byworker,
		Integer worker,
		Boolean bymodule,
		Integer module,
		Boolean bystatus,
		String status,
		Boolean byrfc,
		String rfc
	){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT * FROM userrequests WHERE (datetimein >= ? AND datetimein <= ?)");
		StringBuffer clauses = new StringBuffer();
		if (datetimein_from!=null && datetimein_to!=null) {
			clauses.append("");
			params.add(datetimein_from);
			params.add(datetimein_to);
		} 
		if (byrequesttype.booleanValue() && requesttype!=null) {
			clauses.append(" requesttype = ? AND");
			params.add(requesttype);
		} 
		if (byfilialtype.booleanValue() && filialtype!=null) {
			clauses.append(" filialtype = ? AND");
			params.add(filialtype);
		} 
		if (byfilial.booleanValue() && filial!=null) {
			clauses.append(" regionid = ? AND");
			params.add(filial);
		} 
		if (byregion.booleanValue() && region!=null) {
			clauses.append(" supregid = ? AND");
			params.add(region);
		} 
		if (byworker.booleanValue() && worker!=null) {
			clauses.append(" worker = ? AND");
			params.add(worker);
		} 
		if (bymodule.booleanValue() && module!=null) {
			clauses.append(" module = ? AND");
			params.add(module);
		} 
		if (bystatus.booleanValue() && status!=null) {
			clauses.append(" status = ? AND");
			params.add(status);
		} 
		if (byrfc.booleanValue() && rfc!=null && rfc.length()>0) {
			clauses.append(" rfc LIKE ? AND");
			params.add(rfc);
		} 
		if (clauses.length()>0){
			String cl = clauses.toString();
			if (cl.endsWith(" AND")) cl = cl.substring(0,cl.length()-" AND".length());
			sqlb.append(" AND ("+cl+")");
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ArrayList array = new ArrayList();
		ListIterator it = res.listIterator();
		while(it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			array.add(new UserRequestRow(row));
		}
		return array;
	}
	/**
	 * Выдаёт список запросов пользователей по дате занесения
	 */
	public static ArrayList findRequestsByDate(java.sql.Date datetimein){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT * FROM userrequests");
		if (datetimein!=null) {
			sqlb.append(" WHERE datetimein = ?");
			params.add(datetimein);
		} 
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ArrayList array = new ArrayList();
		ListIterator it = res.listIterator();
		while(it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			array.add(new UserRequestRow(row));
		}
		return array;
	}
	/**
	 * Выдаёт список значений типов запросов пользователей
	 */
	public static CDBCResultSet findRequestTypes(){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT requesttype, name FROM requesttypes");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Выдаёт список значений типов филиалов
	 */
	public static CDBCResultSet findFilialTypes(){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT filialtype, name FROM filialtype");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Выдаёт список значений модулей NRI
	 */
	public static CDBCResultSet findNRIModules(){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT module, name FROM nrimodules");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Выдаёт список филиалов
	 */
	public static CDBCResultSet findFilials(){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT regionid, regname FROM regions ORDER BY regname");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Выдаёт список регионов
	 */
	public static CDBCResultSet findRegions(){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT supregid, supregname FROM superregions ORDER BY supregname");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Выдаёт полное имя сотрудника по идентификатору
	 */
	public static String[] findMan(Integer man){
		CDBCResultSet res = new CDBCResultSet();
		String fullname = ""; 
		res.executeQuery(
			"SELECT w.worker worker, TRIM(p.lastname) || NVL(' ' || TRIM(p.firstname) || NVL(' ' || TRIM(p.middlename),''),'') fullname, w.workposition wp, TRIM(wp.name) wpname, w.division, TRIM(d.name) divisionname "+
			"FROM workers w, people p, divisions d, workpositions wp "+
			"WHERE w.man = p.man AND w.division = d.division AND w.workposition = wp.workposition AND w.worker = ? ",
			new Object[] { man }
		);
		ListIterator it = res.listIterator();
		String[] results=new String[2];
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			if (row.hasColumn("fullname")) 
				results[0] = row.getColumn("fullname").asString();
			if (row.hasColumn("wp")) 
				results[1] = row.getColumn("wpname").asString();
		}
		return results;
	}
	/**
	 * Выдаёт имя модуля NRI по идентификатору
	 */
	public static String getModule(Integer module){
		CDBCResultSet res = new CDBCResultSet();
		String name = "";
		res.executeQuery("SELECT name FROM nrimodules WHERE module = ?", new Object[] { module });
		ListIterator it = res.listIterator();
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			if (row.hasColumn("name")) 
				name = row.getColumn("name").asString();
		}
		return name;
	}
	/**
	 * Выдаёт строковое представление типа запроса по идентификатору
	 */
	public static String getRequesttype(Integer reqtype){
		CDBCResultSet res = new CDBCResultSet();
		String name = "";
		res.executeQuery("SELECT name FROM requesttypes WHERE requesttype = ?", new Object[] { reqtype });
		ListIterator it = res.listIterator();
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			if (row.hasColumn("name")) 
				name = row.getColumn("name").asString();
		}
		return name;
	}
}