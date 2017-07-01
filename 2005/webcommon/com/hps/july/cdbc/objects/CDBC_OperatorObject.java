/*
 * Created on 22.06.2007
 *
 * Оператор NRI(CDBC_Object)
 */
package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.Operator_VO;

/**
 * @author IShaffigulin
 *
 * Оператор NRI(CDBC_Object)
 */
public class CDBC_OperatorObject {
	//private static final String _createString = "INSERT INTO operators (operator, password, loiginid, isenabled, msucode, oldpwd, man) VALUES (?, ?, ?, ?, ?, ?, ?)";
	//private static final String _removeString = "DELETE FROM operators  WHERE operator = ?";
	//private static final String _storeString = "UPDATE operators  SET password = ?, loiginid = ?, isenabled = ?, msucode = ?, oldpwd = ?, man = ? WHERE operator = ?";
	private static final String _loadString = "SELECT operator, man, loiginID, isEnabled, msuCode, lastLoginTime, lastRegionID FROM operators WHERE operator = ?";
	//private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String _updateLastRegionID = "UPDATE operators SET lastRegionID = ? WHERE operator = ?";

	/**
	 * 
	 * @param aID
	 * @return
	 */
	public final static Operator_VO find(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		res.executeQuery(_loadString, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Operator_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createOperator(ro);
		}
		return vo;
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static boolean updateLastRegionID(Operator_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getLastRegionID(), vo.getOperator()};
		return res.executeUpdate(_updateLastRegionID, params);
	}

	/**
	 * 
	 * @param aOperatorID
	 * @param aRegionID
	 * @return
	 */
	public static boolean updateLastRegionID(Integer aOperatorID, Integer aRegionID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aRegionID, aOperatorID };
		return res.executeUpdate(_updateLastRegionID, params);
	}
}
