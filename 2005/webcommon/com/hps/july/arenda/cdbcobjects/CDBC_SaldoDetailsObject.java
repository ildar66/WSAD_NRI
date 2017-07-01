/*
 * Created on 20.02.2007
 *
 * "Сальдо для договоров аренды" CDBC_Object
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.cdbcobjects;

import java.math.BigDecimal;
import java.util.*;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;

/**
 * @author IShaffigulin
 *
 * "Сальдо для договоров аренды" CDBC_Object
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_SaldoDetailsObject {
	private static final String FIND_SQL =
		"SELECT idSldDetail, leaseContract, salDate, resource, getNameResource(resource) resourceName, mainCurrency, getNameCurrency(mainCurrency, 0, 0) mainCurrencyName, additionalCurrency, getNameCurrency(additionalCurrency, 0, 0) additionalCurrencyName, act, mainSum, mainNdsSum, additionalSum, additionalNdsSum, rateNds, groupRec, saldoByHand, notes, "
			+ "mSumCalc, mNDSCalc, aSumCalc, aNDSCalc, operator "
			+ "FROM LeaseSaldoDetail ";
	private static final String FIND_LIST_SQL =
		"SELECT idSldDetail, leaseContract, salDate, resource, getNameResource(resource) resourceName, mainCurrency, getNameCurrency(mainCurrency, 0, 0) mainCurrencyName, additionalCurrency, getNameCurrency(additionalCurrency, 0, 0) additionalCurrencyName, act, mainSum, mainNdsSum, additionalSum, additionalNdsSum, rateNds, groupRec, saldoByHand, notes, "
			+ "mSumCalc, mNDSCalc, aSumCalc, aNDSCalc, operator "
			+ "FROM LeaseSaldoDetail ";
	private static final String PROCEDURE_SQL = "execute procedure SaveLeaseSaldoDetail (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getList(Integer idContract, String sortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idContract };
		String sql = FIND_LIST_SQL + " WHERE leaseContract = ? ";
		//append order by clause:
		if (sortBy != null)
			sql += " order by " + sortBy;
		System.out.println("SQL(idContract=" + idContract + ")=" + sql); //temp
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		SaldoDetail_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new SaldoDetail_TO(CDBC_Helper.createSaldoDetail(ro));
			to.setResourceName(ro.getColumn("resourceName").asString());
			to.setMainCurrencyName(ro.getColumn("mainCurrencyName").asString());
			to.setAdditionalCurrencyName(ro.getColumn("additionalCurrencyName").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * @param id int
	 */
	public final static SaldoDetail_TO findTO(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " WHERE idSldDetail = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		SaldoDetail_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			to = new SaldoDetail_TO(CDBC_Helper.createSaldoDetail(ro));
			//vo.setCreatedByName(ro.getColumn("createdByName").asString());
			//vo.setModifiedByName(ro.getColumn("modifiedByName").asString());
		}
		return to;
	}

	/**
	 * 
	 * @param vo
	 * @param i_Operator
	 * @param operation
	 * @return
		 create procedure SaveLeasesaldodetail(
		--*************************************************************************
		-- Запишем сальдо по договору и услуге
		--*************************************************************************
		i_contract integer,  --код договора
		i_date     date,     --дата
		i_resource integer,  --код услуги
		i_idslddetail integer, -- идентификатор сальдо
		i_maincurrency integer,
		i_mainSum decimal(15,2), --сумма в основной валюте
		i_mainndssum decimal(15,2),  --ндс в основной валюте
		i_additionalcurrency integer,
		i_additionalsum  decimal(15,2),  --сумма в дополнительной валюте
		i_additionalndssum  decimal(15,2),   -- ндс в дополнительной валюте
		i_rateNds decimal(15,2),  --
		i_groupRec   integer,     --
		i_Action  char(1),       --'I', 'U', 'D' (insert update delete)
		i_operator   integer,   --
		i_act integer,          -- код акта по которому расчитано сальдо
		i_saldobyhand CHAR(1),  --
		i_notes varchar(255),   --
		i_taskstart integer     --
		)* 
	 */
	public static String procedure(com.hps.july.arenda.valueobject.SaldoDetail_VO vo, Integer i_Operator, String operation) {
		System.out.println(vo); //temp
		String returnStr = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getLeaseContract(),
				vo.getSalDate(),
				vo.getResource(),
				vo.getIdSldDetail(),
				(vo.getMainCurrency() == null) ? new Integer(0) : vo.getMainCurrency(),
				vo.getMainSum(),
				vo.getMainNdsSum(),
				(vo.getAdditionalCurrency() == null) ? new Integer(0) : vo.getAdditionalCurrency(),
				(vo.getAdditionalSum() == null) ? new BigDecimal(0) : vo.getAdditionalSum(),
				(vo.getAdditionalNdsSum() == null) ? new BigDecimal(0) : vo.getAdditionalNdsSum(),
				vo.getRateNds(),
				vo.getGroupRec(),
				operation,
				i_Operator,
				(vo.getAct() == null) ? new Integer(0) : vo.getAct(),
				vo.getSaldoByHand(),
				vo.getNotes(),
				new Integer(0)};
		res.executeQuery(PROCEDURE_SQL, params);
		ListIterator iter = res.listIterator();
		if (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			int id = ((Integer) ro.getColumn("col1").asObject()).intValue();
			if (id >= 0){
				//в процедуре меняется ключ(id=0 - Это успешное удаление):
				vo.setIdSldDetail(new Integer(id));
			}else{
				returnStr = ro.getColumn("col2").asString();
			}
		} else {
			returnStr = "Ошибка записи(смотри лог)";
		}
		return returnStr;
	}
}
