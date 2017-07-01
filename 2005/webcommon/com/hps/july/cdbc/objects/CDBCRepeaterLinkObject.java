/*
 * Created on 10.01.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;

import com.hps.july.commonbean.*;

/**
 * Объект для работы с связями репитеров и донорных блоков.
 * Creation date: (10.01.2007 12:25:45)
 * @author: Alexander Ermolov
 */
public class CDBCRepeaterLinkObject {
	public CDBCRepeaterLinkObject(){
		super();
	}
	public static int getNewKey() throws java.lang.Exception {
		return new KeyGeneratorAccessBean().getNextKey("tables.repiter2repdonorunit");
	}
	/**
	 * Возвращает список донорных блоков, соответствующих 
	 * редактируемому репитеру по значениям рабочей и линковой частот
	 */
	public static CDBCResultSet findDonorunitsByBands(
		Integer linkband,
		Integer workband)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, ");
		sqlb.append("d.power, d.workband, d.linkband, d.gainfactor, d.voltageid, d.usedpower, d.entriescount, d.antgatescount, d.signaldelay, d.noisefactor ");
		sqlb.append("FROM resources r, repdonorunitres d, units u, outer organizations o ");
		sqlb.append("WHERE d.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

		if(linkband != null && !"*".equals(linkband)) {
			sqlb.append("AND d.linkband = ? ");
			params.add(linkband);
		}
		if(workband != null && !"*".equals(workband)) {
			sqlb.append("AND d.workband = ? ");
			params.add(workband);
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает список донорных блоков, соответствующих 
	 * редактируемому репитеру по значениям рабочей и линковой частот
	 */
	public static boolean findRepeaterLinkedDonorUnit(Integer repiterres, Integer donorunitres)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT * FROM repiter2repdonorunit WHERE idresrepiter = ? AND idresrepdonorunit = ?");		params.add(repiterres);
		params.add(donorunitres);
	
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res.getRowsCount()>0;
	}
	/**
	 * Разрывает связи репитера с донорными блоками при 
	 * редактировании репитера из списка оборудования 
	 * (в случае изменения параметров репитера)
	 */
	public static boolean dropRepeaterLinks(Integer repiterres){
		boolean result = false;
		Connection con = null;
		try{
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			con.setAutoCommit(false);
			CDBCResultSet rs = new CDBCResultSet();
			rs.executeUpdate(con, "DELETE FROM repiter2repdonorunit WHERE idresrepiter = ?", new Object[] {repiterres});
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
	 * Разрывает связи репитера с донорными блоками при 
	 * редактировании донорного блока из списка оборудования 
	 * (в случае изменения параметров донорного блока)
	 */
	public static boolean dropDonorUnitLinks(Integer donorunitres){
		boolean result = false;
		Connection con = null;
		try{
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			con.setAutoCommit(false);
			CDBCResultSet rs = new CDBCResultSet();
			rs.executeUpdate(con, "DELETE FROM repiter2repdonorunit WHERE idresrepdonorunit = ?)", new Object[] {donorunitres});
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
	 * Создает записи в таблице связей репитеров и донорных блоков
	 * после установки связей на форме редактирования оборудования
	 * репитера  
	 */
	public static boolean setRepDonorUnitLinks(Integer repiterres, Integer[] donorunit_keys){
		boolean result = false;
		Integer newkey = new Integer(0);
		Connection con = null;
		try{
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			con.setAutoCommit(false);
			CDBCResultSet rs = new CDBCResultSet();
			for (int i=0; i<donorunit_keys.length; i++)
				rs.executeUpdate(con, "INSERT INTO repiter2repdonorunit (idrecrepiter2repdonorunit, idresrepiter, idresrepdonorunit)" + 
					"VALUES (?, ?, ?)", new Object[] {new Integer(getNewKey()), repiterres, donorunit_keys[i]});
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
}