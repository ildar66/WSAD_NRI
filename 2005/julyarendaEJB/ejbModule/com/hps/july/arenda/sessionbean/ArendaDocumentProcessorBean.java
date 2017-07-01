package com.hps.july.arenda.sessionbean;

//import com.hps.july.jdbcpersistence.*;
//import com.hps.july.jdbcpersistence.lib.*;
import javax.transaction.*;
//import com.hps.july.inventory.sessionbean.*;
import java.sql.*;
import java.sql.Date;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.commonbean.*;
import java.math.*;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.*;
import java.util.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Процессор документов аренды. Алгоритмы расчета
 */
public class ArendaDocumentProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 15:47:35)
 * @return java.math.BigDecimal
 * @param idPayment java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
private BigDecimal defineRatePaymentOnContract(Integer idPayment, Integer currency) throws java.lang.Exception {
/*	NamedValueAccessBean namedValue = new NamedValueAccessBean();
	namedValue.setInitKey_id("RUR");
	namedValue.refreshCopyHelper();
	
	if (currency.intValue() == namedValue.getIntvalue()) {
		return new BigDecimal(1);
	}

	LeasePaymentAccessBean payBean = new LeasePaymentAccessBean();
	payBean.setInitKey_leaseDocPosition(idPayment.intValue());
	payBean.refreshCopyHelper();
	
	LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
	laanBean.setInitKey_leaseDocument(payBean.getLeaseContractKey().leaseDocument);
	laanBean.refreshCopyHelper();

	Date dateRate = null;
	
	if (laanBean.getRatecalcrule().equals("A")) {
		LeasePayOrderAccessBean lpoBean = new LeasePayOrderAccessBean();
		lpoBean.setInitKey_leaseDocPosition(idPayment.intValue());
		lpoBean.refreshCopyHelper();
		dateRate = lpoBean.getBillDate();
	} else if (laanBean.getRatecalcrule().equals("B")) {
		dateRate = payBean.getPayDate();
	} else if (laanBean.getRatecalcrule().equals("C")) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(payBean.getPayDate());
		c.add(Calendar.DAY_OF_MONTH, -1);
		dateRate.setTime(c.getTime().getTime());
	} else if (laanBean.getRatecalcrule().equals("D")) {
		dateRate.setTime(payBean.getEndDate());
	} else if (laanBean.getRatecalcrule().equals("E")) {
		dateRate.setTime(payBean.getBeginDate());
	} else if (laanBean.getRatecalcrule().equals("F")) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(payBean.getBeginDate());
		c.add(Calendar.MONTH, -1);
		c.add(Calendar.DAY_OF_MONTH, laanBean.getRateCalcRuleDate());
		dateRate.setTime(c.getTime().getTime());
	} else if (laanBean.getRatecalcrule().equals("G")) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(payBean.getBeginDate());
		
		GregorianCalendar quarter = new GregorianCalendar();
		quarter.clear();
		quarter.set(c.get(Calendar.YEAR), 3, 1);
		while (c.getTime().compareTo(quarter.getTime()) >= 0) {
			quarter.add(Calendar.MONTH, 3);
		}
		quarter.add(Calendar.MONTH, -4);
		quarter.add(Calendar.DAY_OF_MONTH, laanBean.getRateCalcRuleDate());
		dateRate.setTime(quarter.getTime().getTime());
	}

	namedValue = new NamedValueAccessBean();
	namedValue.setInitKey_id("BASE_RATETYPE_ARENDA");
	namedValue.refreshCopyHelper();
	
	// Integer type, Integer currency, java.sql.Date date
	RateAccessBean rateBean = new RateAccessBean().findByTypeCurrencyForDate(new Integer(namedValue.getIntvalue()),
		currency, dateRate);

	if (rateBean.getDate().compareTo(dateRate) < 0) {
		GregorianCalendar now = new GregorianCalendar();
		now.clear(Calendar.HOUR_OF_DAY);
		now.clear(Calendar.MINUTE);
		now.clear(Calendar.SECOND);
		now.clear(Calendar.MILLISECOND);
		now.add(Calendar.DAY_OF_MONTH, -1);
		if (dateRate.compareTo(now.getTime()) > 0) {
			// msg error - в системе NRI не установлен курс на дату dateRate
			return null;
		} else {
			// msg warning - на дату dateRate курс не найден, используем курс на дату rateBean.getDate()
			// и продолжаем вычисления
		}
	}
	
	BigDecimal ratePay = (rateBean.getValue().multiply(laanBean.getRateDelta().add(100))).divide(100);
	ratePay = ratePay.setScale(4, BigDecimal.ROUND_HALF_UP);
	
	return ratePay;*/
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 19:05:13)
 * @return java.lang.Object[]
 */
public Object[] delShfOnAkt(int type, int actcode) throws java.rmi.RemoteException {
	try {
		Object[] ret = new Object[] { new Integer(0), "error: no data" };
		Connection con = null;
		Statement statement = null;
		
		try {
			con = getConnection();
			statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery("execute procedure delShfOnAkt(" + type + ", " + actcode + ")");
			
			if (rs.next()) {
				ret[0] = new Integer(rs.getInt(1));
				ret[1] = rs.getString(2);
			}
		} finally {
			try {
				if (statement != null) statement.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While delete schet on act, ", ex);
	}
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 15:43:09)
 * @return int
 */
public String getActNumber(int reglamentcode) throws java.rmi.RemoteException {
	try {
		String ret = "";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String s = "execute procedure DefNumberAct(?)";
			ps = con.prepareStatement(s);
			
			ps.setInt(1, reglamentcode);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) ret = rs.getString(1);
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While get act number, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.03.2003 11:52:39)
 * @return java.sql.Connection
 * @exception java.lang.Exception The exception description.
 */

private Connection getConnection() throws java.lang.Exception {
	JdbcConnection jcon = new JdbcConnection();
	return jcon.getConnection();
	/*
	Properties prp = new EnvironmentAccessBean().getEnvironmentProperties();
	String dsName = prp.getProperty("DATASOURCE_NAME");
	String factoryClass = prp.getProperty("FACTORY_CLASS");
	
	javax.naming.InitialContext ctx = null;
	Properties prop = new Properties();
	prop.put(javax.naming.Context.PROVIDER_URL, "iiop://");
	prop.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass);
	ctx = new javax.naming.InitialContext();
	
	return ((javax.sql.DataSource) ctx.lookup(dsName)).getConnection();
	*/
}

/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 11:53:06)
 * @return int
 * @param organization int
 */
public int getDefaultBudjet(int organization) throws java.rmi.RemoteException {
	try {
		int ret = 0;
		Connection con = null;
		Statement statement = null;
		
		try {
			con = getConnection();
			statement = con.createStatement();
			String s = "execute procedure getDefaultBudjet(" + organization + ")";
			
			ResultSet rs = statement.executeQuery(s);
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (statement != null) statement.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While get default budjet, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 11:53:42)
 * @return int
 * @param organization int
 */
public int getDefaultExpence(int organization) throws java.rmi.RemoteException {
	try {
		int ret = 0;
		Connection con = null;
		Statement statement = null;
		
		try {
			con = getConnection();
			statement = con.createStatement();
			String s = "execute procedure getDefaultExpence(" + organization + ")";
			
			ResultSet rs = statement.executeQuery(s);
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (statement != null) statement.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While get default expence, ", ex);
	}
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 18:07:59)
 * @param dateFinish java.sql.Date
 * @param economist java.lang.Integer
 * @param contract java.lang.Integer
 */
public int makeAutomaticCharges(Date dateFinish, Integer economist, Integer contract, Integer operator) throws java.rmi.RemoteException {
	try {
		if (true) {
			
			int ret = 0;
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				String s = "execute procedure autoMakeCharges(" + economist + ", " + contract + ", ?, ?)";
				ps = con.prepareStatement(s);
				
				ps.setDate(1, dateFinish);
				ps.setInt(2, operator.intValue());
				System.out.println("SQL=" + s);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) ret = rs.getInt(1);
			} finally {
				try {
					if (ps != null) ps.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
			return ret;
		}
		JournalAccessBean journal = new JournalAccessBean();
		int codeTask = journal.taskStart(operator.intValue(), "2", null, dateFinish, economist, contract);
		
		Vector v = new Vector();
		if (contract != null) {
			LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
			laanBean.setInitKey_leaseDocument(contract.intValue());
			laanBean.refreshCopyHelper();
			v.addElement(new Integer(new LeaseArendaAgreementProcessorAccessBean().getBaseContract(contract.intValue())));
		} else {
			Enumeration n = new LeaseArendaAgreementNewAccessBean().findByQBE4(new Boolean(economist != null), economist);
			while (n.hasMoreElements()) {
				v.addElement(new Integer(((LeaseArendaAgreementNewAccessBean) n.nextElement()).getLeaseDocument()));
			}
		}
		
		Enumeration e = v.elements();
		if (e.hasMoreElements()) {
			while (e.hasMoreElements()) {
				Integer i = (Integer) e.nextElement();
				new ArendaDocumentTransactionMethodAccessBean().makeAutoChargeOneContract(dateFinish, i, codeTask);
			}
		} else {
			journal.addMsgInJournal(25, "W", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
		}
		
		journal.taskEnd(codeTask);
		return codeTask;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While process automatic charges", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2002 11:57:54)
 * @param dateStart java.sql.Date
 * @param dateFinish java.sql.Date
 * @param economist java.lang.Integer
 * @param contract java.lang.Integer
 * @param operator java.lang.Integer
 */
public int makeAutomaticPayments(Date dateStart, Date dateFinish, Integer economist, Integer contract, Integer operator) throws java.rmi.RemoteException {
	try {
		if (true) {
			
			int ret = 0;
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				String s = "execute procedure autoMakePayments(" + economist + ", " + contract + ", ?, ?, ?)";
				ps = con.prepareStatement(s);
				
				ps.setDate(1, dateStart);
				ps.setDate(2, dateFinish);
				ps.setInt(3, operator.intValue());
				System.out.println("SQL=" + s);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) ret = rs.getInt(1);
			} finally {
				try {
					if (ps != null) ps.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
			return ret;
		}
		
		JournalAccessBean journal = new JournalAccessBean();
		int codeTask = journal.taskStart(operator.intValue(), "3", dateStart, dateFinish, economist, contract);
		
		Vector v = new Vector();
		if (contract != null) {
			LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
			laanBean.setInitKey_leaseDocument(contract.intValue());
			laanBean.refreshCopyHelper();
			v.addElement(new Integer(new LeaseArendaAgreementProcessorAccessBean().getBaseContract(contract.intValue())));
		} else {
			Enumeration n = new LeaseArendaAgreementNewAccessBean().findByQBE4(new Boolean(economist != null), economist);
			while (n.hasMoreElements()) {
				v.addElement(new Integer(((LeaseArendaAgreementNewAccessBean) n.nextElement()).getLeaseDocument()));
			}
		}
		
		Enumeration e = v.elements();
		if (e.hasMoreElements()) {
			while (e.hasMoreElements()) {
				Integer i = (Integer) e.nextElement();
				new ArendaDocumentTransactionMethodAccessBean().makeAutoPaymentOneContract(dateStart, dateFinish, i, codeTask);
			}
		} else {
			journal.addMsgInJournal(64, "W", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
		}
		
		journal.taskEnd(codeTask);
		return codeTask;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While process automatic payments", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2003 16:12:26)
 * @return boolean
 */
public int makeCalcForReport(int actCode, int operator) throws java.rmi.RemoteException {
	try {
		int ret = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String s = "execute procedure printSverka(?, ?)";
			ps = con.prepareStatement(s);
			
			ps.setInt(1, actCode);
			ps.setInt(2, operator);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While make calc for report, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 14:41:44)
 * @return int
 * @param operator int
 * @param contract int
 * @param payment int
 */
public int makeQryGetPays(int operator, Integer contract, Integer payment, Date dstart, Date dfinish) throws java.rmi.RemoteException {
	try {
		int ret = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String s = "execute procedure makeQryGetPays(" + operator + ", " + contract + ", " + payment + ", ?, ?)";
			ps = con.prepareStatement(s);
			
			ps.setDate(1, dstart);
			ps.setDate(2, dfinish);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While make qry get pays, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 19:05:13)
 * @return java.lang.Object[]
 */
public Object[] makeSchfOnAkt(int type, int actcode, int rule) throws java.rmi.RemoteException {
	try {
		Object[] ret = new Object[] { new Integer(0), "error: no data" };
		Connection con = null;
		Statement statement = null;
		
		try {
			con = getConnection();
			statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery("execute procedure makeShfOnAkt("+type+","+actcode+","+rule+")");
			
			if (rs.next()) {
				ret[0] = new Integer(rs.getInt(1));
				ret[1] = rs.getString(2);
			}
		} finally {
			try {
				if (statement != null) statement.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While make schet on act, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.05.2003 17:50:24)
 * @return int
 * @param contractcode int
 */
public int moveBanToBilling(int contractcode) throws java.rmi.RemoteException {
	try {
		int ret = 0;
		Connection con = null;
		Statement statement = null;
		
		try {
			con = getConnection();
			statement = con.createStatement();
			String s = "execute procedure moveBanToBilling(" + contractcode + ")";
			
			ResultSet rs = statement.executeQuery(s);
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (statement != null) statement.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While move ban to billing, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 12:08:57)
 * @return int
 * @param stateFrom java.lang.String
 * @param stateTo java.lang.String
 */
public Object[] moveContractToPie(int leaseDocument, String stateFrom, String stateTo) throws java.rmi.RemoteException {
	try {
		Object[] ret = new Object[] { new Integer(0), "error: no data" };
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String s = "execute procedure moveContractToPie(?, ?, ?)";
			ps = con.prepareStatement(s);
			
			ps.setInt(1, leaseDocument);
			ps.setString(2, stateFrom);
			ps.setString(3, stateTo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ret[0] = new Integer(rs.getInt(1));
				ret[1] = rs.getString(2);
			}
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While move contract to pie, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 12:55:52)
 * @return int
 * @param leaseDocPosition int
 * @param stateFrom java.lang.String
 * @param stateTo java.lang.String
 */
public Object[] movePayToPie(int leaseDocPosition, String stateFrom, String stateTo) throws java.rmi.RemoteException {
	try {
		Object[] ret = new Object[] { new Integer(0), "error: no data" };
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String s = "execute procedure movePayToPie(?, ?, ?)";
			ps = con.prepareStatement(s);
			
			ps.setInt(1, leaseDocPosition);
			ps.setString(2, stateFrom);
			ps.setString(3, stateTo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ret[0] = new Integer(rs.getInt(1));
				ret[1] = rs.getString(2);
			}
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While move pay to pie, ", ex);
	}
}
/**
 * Подготовка (предварительный расчет) счета-фактуры c валютой по умолчанию.
 * Creation date: (16.05.2003 14:49:47)
 * @return java.lang.Object[]
 */
public Object[] prepareShetFact(int chargecode) throws java.rmi.RemoteException {
	try {
		Object[] ret = new Object[] { new Integer(0), "error: no data" };
		Connection con = null;
		Statement statement = null;
		
		try {
			con = getConnection();
			statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery("execute procedure makeShfOnCharge(" + chargecode + ")");
			
			if (rs.next()) {
				ret[0] = new Integer(rs.getInt(1));
				ret[1] = rs.getString(2);
			}
		} finally {
			try {
				if (statement != null) statement.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While prepare shet-factura, ", ex);
	}
}
/**
 * Подготовка (предварительный расчет) счета-фактуры.
 * Creation date: (16.05.2003 14:49:47)
 * @return java.lang.Object[]
 */
public Object[] prepareShetFact(int chargecode, Integer argCurrency) throws java.rmi.RemoteException {
	try {
		Object[] ret = new Object[] { new Integer(0), "error: no data" };
		Connection con = null;
		Statement statement = null;
		
		try {
			con = getConnection();
			statement = con.createStatement();

			String s = "execute procedure makeShfOnCharge(" + chargecode;
			if (argCurrency != null)
				s = s + ", " + argCurrency.intValue();
			s = s + ");";
			ResultSet rs = statement.executeQuery( s );
			
			if (rs.next()) {
				ret[0] = new Integer(rs.getInt(1));
				ret[1] = rs.getString(2);
			}
		} finally {
			try {
				if (statement != null) statement.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While prepare shet-factura, ", ex);
	}
}
/**
 * Продление договоров аренды.
 * Creation date: (19.08.2002 14:55:13)
 */
public int prolongLeaseArendaAgreement(Date dateStart, Date dateFinish, Integer economist, Integer contract, Integer operator) throws java.rmi.RemoteException {

	// Новый алгоритм - вызов хранимой процедуры
	int result = 1; 

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		con = getConnection();
		ps = con.prepareStatement("EXECUTE PROCEDURE autoProlongDog(?, ?, ?, ?);");
		if (economist != null)
			ps.setInt(1, economist.intValue());
		else
			ps.setNull(1, java.sql.Types.INTEGER);
			
		if (contract != null)
			ps.setInt(2, contract.intValue());
		else
			ps.setNull(2, java.sql.Types.INTEGER);

		ps.setDate(3, dateFinish);
		ps.setInt(4, operator.intValue());

		rs = ps.executeQuery();
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
	} catch (Exception e) {
		e.printStackTrace(System.out);
	} finally {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			ps.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	return result;

/*	 Old algorithm
	try {
		JournalAccessBean journal = new JournalAccessBean();
		int codeTask = journal.taskStart(operator.intValue(), "1", dateStart, dateFinish, economist, contract);

		Vector v = new Vector();
		if (contract != null) {
			v.addElement(contract);
		} else {
			Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE3(new Boolean(true), dateStart, dateFinish,
				new Boolean(true), new Boolean(true), new Boolean(true), "B", new Boolean(true), "A",
				new Boolean(economist != null), economist);
			while (e.hasMoreElements()) {
				v.addElement(new Integer(((LeaseArendaAgreementNewAccessBean) e.nextElement()).getLeaseDocument()));
			}
		}
		
		Enumeration e = v.elements();
		if (e.hasMoreElements()) {
			while (e.hasMoreElements()) {
				Integer i = (Integer) e.nextElement();
				LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(i.intValue());
				bean.refreshCopyHelper();
				
				if (!bean.getIsActive().booleanValue()) {
					journal.addMsgInJournal(2, "E", -1, bean.getLeaseDocument(), -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
					continue;
				}
				if (!bean.getContractState().equals("B")) {
					journal.addMsgInJournal(3, "E", -1, bean.getLeaseDocument(), -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
					continue;
				}
				if (!bean.getExtendType().equals("A")) {
					journal.addMsgInJournal(4, "E", -1, bean.getLeaseDocument(), -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
					continue;
				}
				
				new ArendaDocumentTransactionMethodAccessBean().makeProlongationOneContract(bean.getEJBRef().getHandle(), codeTask);
			}				
		} else {
			journal.addMsgInJournal(7, "W", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
		}

		journal.taskEnd(codeTask);
		return codeTask;
	} catch (Exception exc) {
		exc.printStackTrace();
		throw new java.rmi.RemoteException("While prolongation document", exc);
	}
*/	
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
