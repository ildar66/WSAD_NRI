package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
 * JDBC - Объект для работы с "Курсы зачета при расчете акта".
 * Creation date: (18.03.2005 14:43:39)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeaseCalcRates_Object {
    private final static java.lang.String findLeaseCalcRate_SQL =
        "SELECT leasedocposition, currency, rate, byhand, act, source, rateold, sourceold, getNameCurrency(currency,1,1) currName, getSumLeaseCalcRate(leasedocposition, currency) sumLeaseCalcRate "
            + "FROM leasecalcrates ";
    private final static java.lang.String addLeaseCalcRate_SQL =
        "INSERT INTO leasecalcrates(leasedocposition, currency, rate, byhand, act, source, rateold, sourceold) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
    private final static java.lang.String editLeaseCalcRate_SQL =
        "UPDATE leasecalcrates SET rate=?, byhand=?, act=?, source=?, rateold=?, sourceold=? "
            + "WHERE leasedocposition = ? AND currency = ?";
    private final static java.lang.String deleteLeaseCalcRate_SQL =
        "DELETE FROM leasecalcrates WHERE leasedocposition = ? AND currency = ?";
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:34:23)
 */
public static boolean addLeaseCalcRate(LeaseCalcRate_VO rateVO) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(addLeaseCalcRate_SQL);
		//обязательные поля(not null):
		st.setInt(1, rateVO.getLeaseDocPosition().intValue());
        st.setInt(2, rateVO.getCurrencyVO().getCurrency().intValue());
		st.setBigDecimal(3, rateVO.getRate());
		st.setString(4, rateVO.getByhand());
		 st.setInt(6, rateVO.getSource().intValue());
		//необязательные поля(null):		
		if (rateVO.getActVO() != null)
			st.setInt(5, rateVO.getActVO().getMutualreglament().intValue());
		else
			st.setObject(5, null);
		if (rateVO.getRateold() != null)
			st.setBigDecimal(7, rateVO.getRateold());
		else
			st.setObject(7, null);
		if (rateVO.getSourceold() != null)
			st.setInt(8, rateVO.getSourceold().intValue());
		else
			st.setObject(8, null);			

		if (st.executeUpdate() != 1) {
			System.out.println("Insert LeaseCalcRate:LeaseDocPosition=" + rateVO.getLeaseDocPosition()+ " failed");
			return false;
		}
		return true;
	} catch (SQLException e) {
		System.out.println("SQLException: CODE=" + e.getErrorCode());
		e.printStackTrace(System.out);
		return false;
	} finally {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
public static boolean deleteLeaseCalcRate(Integer leasedocposition, Integer currency) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(deleteLeaseCalcRate_SQL);
		st.setInt(1, leasedocposition.intValue());
		st.setInt(2, currency.intValue());

		if (st.executeUpdate() != 1) {
			System.out.println("deleteLeaseCalcRate  failed");
			return false;
		}
		return true;
	} catch (SQLException e) {
		System.out.println("SQLException: CODE=" + e.getErrorCode());
		e.printStackTrace(System.out);
		return false;
	} finally {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:34:23)
 */
public static boolean editLeaseCalcRate(LeaseCalcRate_VO rateVO) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(editLeaseCalcRate_SQL);
        //обязательные поля(not null):
        //st.setInt(1, rateVO.getCurrencyVO().getCurrency().intValue());
        st.setBigDecimal(1, rateVO.getRate());
        st.setString(2, rateVO.getByhand());
        st.setInt(4, rateVO.getSource().intValue());
        //необязательные поля(null):		
        if (rateVO.getActVO() != null)
            st.setInt(3, rateVO.getActVO().getLeaseDocument().intValue());
        else
            st.setObject(3, null);
        if (rateVO.getRateold() != null)
            st.setBigDecimal(5, rateVO.getRateold());
        else
            st.setObject(5, null);
        if (rateVO.getSourceold() != null)
            st.setInt(6, rateVO.getSourceold().intValue());
        else
            st.setObject(6, null);
        //входной параметр:
        st.setInt(7, rateVO.getLeaseDocPosition().intValue());
        st.setInt(8, rateVO.getCurrencyVO().getCurrency().intValue());        

        if (st.executeUpdate() != 1) {
            System.out.println("update LeaseCalcRate:LeaseDocPosition=" + rateVO.getLeaseDocPosition() + " failed");
            return false;
        }
        return true;
    } catch (SQLException e) {
        System.out.println("SQLException: CODE=" + e.getErrorCode());
        e.printStackTrace(System.out);
        return false;
    } finally {
        try {
            if (st != null)
                st.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:06:12)
 */
public static LeaseCalcRate_VO findLeaseCalcRate(Integer leasedocposition, Integer currency) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    LeaseCalcRate_VO vo = null;
    //add query string: 
    sqlb.append(findLeaseCalcRate_SQL);
    //calculate filter clause
    sqlb.append("WHERE leasedocposition= " + leasedocposition + " AND currency=" + currency);

    System.out.println("findLeaseCalcRate sql=" + sqlb.toString()); //temp
    res.executeQuery(sqlb.toString(), null);
    ListIterator iter = res.listIterator();
    if (iter.hasNext()) {
	    vo = new LeaseCalcRate_VO((CDBCRowObject)iter.next());
    }

    return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:06:12)
 */
public static CDBCResultSet findListLeaseCalcRates(Integer leasedocposition, String aSortBy) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    //add query string: 
    sqlb.append(findLeaseCalcRate_SQL);
    //calculate filter clause
    sqlb.append("WHERE leasedocposition= " + leasedocposition);
    //append order by clause:
    //sqlb.append("order by " + aSortBy);
    
	System.out.println("findListLeaseCalcRates sql="+ sqlb.toString());//temp
    res.executeQuery(sqlb.toString(), null);

    return res;
}
public static Object[] getHeaderUpdLeaseRates(Integer i_leasedocposition) {
    /**
    --Description: Вычисляем курс
    --Возвращаем курс и дату из которой взяли курс
    i_Currency integer, -- код валюты
    i_Date date,        --дата 
    i_TypeRate integer  --тип курса    
     */
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { i_leasedocposition};
    String sql = "execute procedure headerUpdLeaseRates(?)";
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    Object ret [] = {null, null};
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        String headerStr = ro.getColumn("col1").asString();
        Integer isCalcAct = (Integer)ro.getColumn("col2").asObject();
        ret[0]=headerStr;
        ret[1]=isCalcAct;
     }
    return ret;
}
public static RateOnDate_VO getRateOnDate(Integer i_Currency, java.sql.Date iFromDate, Integer i_TypeRate) {
    /**
    --Description: Вычисляем курс
    --Возвращаем курс и дату из которой взяли курс
    i_Currency integer, -- код валюты
    i_Date date,        --дата 
    i_TypeRate integer  --тип курса    
     */
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { i_Currency, iFromDate, i_TypeRate};
    String sql = "execute procedure getrate(?, ?, ?)";
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    RateOnDate_VO vo = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        java.math.BigDecimal rate = (java.math.BigDecimal) ro.getColumn("col1").asObject();
        java.sql.Date onDate = (java.sql.Date) ro.getColumn("col2").asObject();
        vo = new RateOnDate_VO(iFromDate, onDate, rate);
    }
    return vo;
}
}
