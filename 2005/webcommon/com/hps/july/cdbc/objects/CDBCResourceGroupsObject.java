/*
 * Created on 15.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.*;
import com.hps.july.basestation.actionbean.ParamsEditAction;
import com.hps.july.cdbc.lib.*;

import com.hps.july.commonbean.*;
import com.hps.july.dictionary.valueobject.AntennaRow;
import com.hps.july.dictionary.valueobject.ResourceGroupItemRow;
import com.hps.july.dictionary.valueobject.ResourceGroupRow;

/**
 * ������ ��� ������ � �������� ��������������� ������������.
 * Creation date: (15.01.2007 16:19:24)
 * @author: Alexander Ermolov
 */
public class CDBCResourceGroupsObject {
	public static final int ANTENNA_GROUP = 3;
	public static final int MSHU_GROUP = 9;
	public static final int RESOURCES_ANTENNA = 15;
	public static final int RESOURCES_MSHU = 15;
	
	public CDBCResourceGroupsObject(){
		super();
	}
	/**
	 * ���������� ������ ������������ ����� �������� ��� ������ ��
	 */
	public static ArrayList findAntennaEquipmentGroups(Boolean getEmpty){
		return findEquipmentGroups(getEmpty,ANTENNA_GROUP);
	}
	/**
	 * ���������� ������ ������������ ����� �������� ��� ���
	 */
	public static ArrayList findMSHUEquipmentGroups(Boolean getEmpty){
		return findEquipmentGroups(getEmpty,MSHU_GROUP);
	}
	/**
	 * ���������� ������ ���� ������������ ����� ��������
	 * �������� getEmpty ���������� ������ ������: ���� �� ����� ������,
	 * � ������ ���������� ������ ������ ������.
	 * �������� classid ����������, ��� ������ ������ ������� ������������ ������ ������������
	 */
	public static ArrayList findEquipmentGroups(Boolean getEmpty, int classid){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT groupid, name FROM resgroups ");
		sqlb.append("WHERE classid = ? ");
		params.add(new Integer(classid));
		if (getEmpty==Boolean.TRUE) 
			sqlb.append("AND groupid NOT IN (SELECT groupid FROM group2res)");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ArrayList arr = new ArrayList();
		ListIterator it = res.listIterator();
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			arr.add(new ResourceGroupRow(new Integer(Integer.parseInt(row.getColumn("groupid").asString())), row.getColumn("name").asString()));
		}
		return arr;
	}
	/**
	 * �������� ������� �� ������ ������������ ��������
	 */
	public static ArrayList findAllAntennes(Boolean hasgroup){
		return findEquipmentForGroups(hasgroup,ANTENNA_GROUP);
	}
	/**
	 * �������� ��� �� ������ ������������ ��������
	 */
	public static ArrayList findAllMSHU(Boolean hasgroup){
		return findEquipmentForGroups(hasgroup,MSHU_GROUP);
	}
	/**
	 * �������� �� ������ ������������ �������� ������� ��������� ������
	 */
	public static ArrayList findEquipmentForGroups(Boolean hasgroup, int resclassid){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		params.add(new Integer(resclassid));
		sqlb.append("SELECT r.resource, r.name, r.model, e.shortname, r.groupid ");
		sqlb.append("FROM resources r, outer equipmanufacturers e ");
		sqlb.append("WHERE r.resourceclass2 = ? AND e.manufid=r.manufid ");
		if (hasgroup==Boolean.TRUE) sqlb.append("AND r.groupid IS NOT NULL ");
		sqlb.append("ORDER BY r.resource");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ArrayList arr = new ArrayList();
		ListIterator it = res.listIterator();
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			arr.add(new AntennaRow(row,false));
		}
		return arr;
	}
	/**
	 * ����� ����� ����������� ��� ������ �� ��������� ��������, �������� � ������
	 */
	public static ArrayList findAntennaGroupsByAccessories(
		Integer code1,
		Integer code2,
		String model1,
		String model2,
		String manucode1,
		String manucode2
	){
		return findGroupsByAccessories(ANTENNA_GROUP, code1, code2, model1, model2, manucode1, manucode2);
	}
	/**
	 * ����� ����� ����������� ��� ��� �� ��������� ��������, �������� � ������
	 */
	public static ArrayList findMSHUGroupsByAccessories(
		Integer code1,
		Integer code2,
		String model1,
		String model2,
		String manucode1,
		String manucode2
	){
		return findGroupsByAccessories(MSHU_GROUP, code1, code2, model1, model2, manucode1, manucode2);
	}

	/**
	 * ���������� ������ ����� ����������� �� ���������� � �������� � ��� 
	 * �����������. �������� ����� �� ��������������, ������ � ���� �������������
	 * ������ ��� ���� �����������
	 * �������� ����� ������ �������� ��� ������� ����� ������������� ����� �����
	 */
	public static ArrayList findGroupsByAccessories(
		int resclassid,
		Integer code1,
		Integer code2,
		String model1,
		String model2,
		String manucode1,
		String manucode2
	){
		StringBuffer sqlb = new StringBuffer();
		SQLClauseBuilder codebuilder = new SQLClauseBuilder();
		SQLClauseBuilder modelbuilder = new SQLClauseBuilder();
		SQLClauseBuilder manucodebuilder = new SQLClauseBuilder();
		SQLClauseBuilder finalbuilder = new SQLClauseBuilder();
		sqlb.append("SELECT groupid, name FROM resgroups WHERE classid = "+new Integer(resclassid)+" ");
		if (code1 != null) codebuilder.addParametrizedClause("resource = ?", code1);
		if (code2 != null) codebuilder.addParametrizedClause("resource = ?", code2);
		codebuilder.setGlueOption("OR");
		codebuilder.setBrackets(true);
		if (model1 != null) modelbuilder.addParametrizedClause("UPPER(model) LIKE UPPER(?)", model1);
		if (model2 != null) modelbuilder.addParametrizedClause("UPPER(model) LIKE UPPER(?)", model2);
		modelbuilder.setGlueOption("OR");
		modelbuilder.setBrackets(true);
		if (manucode1 != null) manucodebuilder.addParametrizedClause("UPPER(manucode) LIKE UPPER(?)", manucode1);
		if (manucode2 != null) manucodebuilder.addParametrizedClause("UPPER(manucode) LIKE UPPER(?)", manucode2);
		manucodebuilder.setGlueOption("OR");
		manucodebuilder.setBrackets(true);
		finalbuilder.addParametrizedClause(codebuilder.glueClauses(), codebuilder.getParams());
		finalbuilder.addParametrizedClause(modelbuilder.glueClauses(), modelbuilder.getParams());
		finalbuilder.addParametrizedClause(manucodebuilder.glueClauses(), manucodebuilder.getParams());
		finalbuilder.setGlueOption("OR");
		CDBCResultSet res = new CDBCResultSet();
		if (!finalbuilder.isEmpty()){
			sqlb.append("AND groupid IN (SELECT groupid FROM group2res WHERE resource IN (SELECT resource FROM resources WHERE ");
			sqlb.append(finalbuilder.glueClauses());			sqlb.append("))");
			res.executeQuery(sqlb.toString(),finalbuilder.getParamsAsArray());
		} else {
			res.executeQuery(sqlb.toString());
		}
		ArrayList arr = new ArrayList();
		ListIterator it = res.listIterator();
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			arr.add(new ResourceGroupRow(new Integer(Integer.parseInt(row.getColumn("groupid").asString())), row.getColumn("name").asString()));
		}
		SQLTester tester = new SQLTester(sqlb, null);
		System.out.println(tester.printSQL());
		return arr;
	}
	/**
	 * ���������� ������ ��������������� ������������ ��� ���������� � ��������� ��������
	 */
	public static CDBCResultSet findAllAntennaAccessories(){
		return findAllLinkableAccessories(new Object[]{new Integer(15)});
	}
	/**
	 * ���������� ������ ��������������� ��� ���������� � ��������� ���
	 */
	public static CDBCResultSet findAllMSHUAccessories(){
		return findAllLinkableAccessories(new Object[]{new Integer(15)});
	}
	/**
	 * ���������� ������ ��������������� ������������ ��� ����������
	 * �������� ����� ���������� ������� ��������������� ������������
	 */
	public static CDBCResultSet findAllLinkableAccessories(Object[] resclasses){
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("SELECT r.resource, r.name, NVL(TRIM(e.name),'') manufname ");
		sqlb.append("FROM resources r, outer equipmanufacturers e  ");
		sqlb.append("WHERE e.manufid = r.manufid ");
		if (resclasses!=null && resclasses.length>0){
			String resclassesstr = "";
			for (int i=0; i<resclasses.length; i++){
				Integer resclass = (Integer) resclasses[i]; 
				resclassesstr+=resclass.toString()+", ";
			}
			resclassesstr=resclassesstr.substring(0,resclassesstr.length()-2);
			sqlb.append("AND resourceclass2 IN ("+resclassesstr+") ");		}
		sqlb.append("ORDER BY r.resource");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), null);
		return res;
	}
	/**
	 * ��������� ��������� ���������� � ������
	 * ���������� ��� ���� ����� �����
	 */
	public static boolean isAccessoryInGroup(Integer groupid, Integer resAccess){

		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT * FROM group2res WHERE groupid = ? AND resource = ?");
		params.add(groupid);
		params.add(resAccess);
	
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res.getRowsCount()>0;
	}
	/**
	 * ��������� ������������� ������ � �������� ���������������
	 * ����������� ��� ���� ����� �����
	 */
	public static boolean groupExists(Integer groupid){

		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT * FROM resgroups WHERE groupid = ?");
		params.add(groupid);
	
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res.getRowsCount()>0;
	}
	/**
	 * ���������� ���������� ����������� ���������� � ������
	 * ����������� ��� ���� ����� �����
	 */
	public static BigDecimal getAccessoryQuantity(Integer groupid, Integer resAccess){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT qty FROM group2res WHERE groupid = ? AND resource = ?");
		params.add(groupid);
		params.add(resAccess);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator it = res.listIterator();
		BigDecimal quantity = new BigDecimal(0);
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			quantity = new BigDecimal(row.getColumn("qty").asString());
		}
		return quantity;
	}	
	/**
	* ������������� ���������� ����������� ���������� � ������
	* ����������� ��� ���� ����� �����
	*/
   	public static boolean setAccessoryQuantity(Integer groupid, Integer resAccess, BigDecimal quantity){
		boolean result = false;
		Connection con = null;
		try{
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			con.setAutoCommit(false);
			CDBCResultSet rs = new CDBCResultSet();
			rs.executeUpdate(con, "UPDATE group2res SET qty = ? WHERE groupid = ? AND resource = ?", new Object[] {quantity, groupid, resAccess});
			con.commit();
			result = true;
		}
		catch (Exception e){
			try {con.rollback();} catch (Exception ee) {}
			e.printStackTrace(System.out);
		}
		finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (Exception ee) {}
		}
		return result;
   	}
	/**
	 * ������ ������ ������������� ������ (��������� ����� �����������
	 * � �������) 
	 * ����������� ��� ���� ����� �����
	 */
	public static boolean dropGroupLinks(Integer groupid){
		boolean result = false;
		Connection con = null;
		try{
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			con.setAutoCommit(false);
			CDBCResultSet rs = new CDBCResultSet();
			rs.executeUpdate(con, "DELETE FROM group2res WHERE groupid = ?", new Object[] {groupid});
			con.commit();
			result = true;
		}
		catch (Exception e){
			try {con.rollback();} catch (Exception ee) {}
			e.printStackTrace(System.out);
		}
		finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (Exception ee) {}
		}
		return result;
	}
	/**
	 * ������� ������ � ������� ������ ����� � �����������
	 * ����� ��������� ������ �� ����� �������������� 
	 * ����������� ������  
	 * ���������� ��� ���� ����� �����
	 */
	public static boolean setGroupAccessoryLinks(Integer groupid, ResourceGroupItemRow[] accessories){
		boolean result = false;
		Integer newkey = new Integer(0);
		Connection con = null;
		try{
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			con.setAutoCommit(false);
			CDBCResultSet rs = new CDBCResultSet();
			for (int i=0; i<accessories.length; i++)
				if (accessories[i].getChecked())
					rs.executeUpdate(con, "INSERT INTO group2res (groupid, resource, qty)" + 
						"VALUES (?, ?, ?)", new Object[] {groupid, accessories[i].getResource(),accessories[i].getQuantity()});
			con.commit();
			result = true;
		}
		catch (Exception e){
			try {con.rollback();} catch (Exception ee) {}
			e.printStackTrace(System.out);
		}
		finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (Exception ee) {}
		}
		return result;
	}
	/**
	 * ���������� �������� ������������� ������� �� ���� �������
	 */
	public static String getManufidFromResource(Integer resource){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		String result = "";

		sqlb.append("SELECT NVL(TRIM(e.shortname),'') manufname " +			"FROM resources r, outer equipmanufacturers e " +			"WHERE resource = ? AND e.manufid = r.manufid");
		if (resource.intValue()!=0)	params.add(resource);
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator it = res.listIterator();
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			if (row.hasColumn("manufname"))
				result = row.getColumn("manufname").asString();
		}
		return result;		
	}
}