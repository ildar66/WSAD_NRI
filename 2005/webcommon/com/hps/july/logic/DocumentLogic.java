package com.hps.july.logic;

import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import java.math.BigDecimal;
import java.sql.*;
/**
* Логика работы с документами(доп. соглашениями).
* Creation date: (15.03.2004 16:33:17)
* @author: Shafigullin Ildar
*/
public class DocumentLogic {
	/**
	 * DocumentLogic constructor comment.
	 */
	public DocumentLogic() {
		super();
	}
	/**
	 * Изменение состояния документа.Возвращает ошибку или пустую строку(если окей).
	 * Creation date: (18.03.2004 14:19:41)
	 * @param document java.lang.Integer
	 * @param fromState java.lang.String
	 * @param toState java.lang.String
	 * @deprecated
	 */
	public final static String changeStateDocument(Integer document, String fromState, String toState, String datecloseStr) throws java.lang.Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String result = "";
		try {
			// Get JDBC connection
			con = jcon.getConnection();

			st = con.createStatement();
			if (!datecloseStr.equalsIgnoreCase(""))
				rs = st.executeQuery("EXECUTE PROCEDURE changeStateContr(" + document + ", '" + fromState + "', '" + toState + "', '" + datecloseStr + "');");
			else
				rs = st.executeQuery("EXECUTE PROCEDURE changeStateContr(" + document + ", '" + fromState + "', '" + toState + "', null);");
			if (rs.next()) {
				int isok = rs.getInt(1);
				if (isok != 0)
					result = rs.getString(2);
			}
			//if (!con.getAutoCommit())
			//con.commit();
		} catch (Exception e) {
			System.out.println("Error in execute procedure changeStateContr(" + document + ", '" + fromState + "', '" + toState + "', '" + datecloseStr + "');");
			catchMetod(e);
		} finally {
			finallyMetod(con, st, rs);
		}
		return result;
	}
	/**
	 * Изменение состояния документа.Возвращает ошибку или пустую строку(если окей).
	 * Creation date: (18.03.2004 14:19:41)
	 * @param document java.lang.Integer
	 * @param fromState java.lang.String
	 * @param toState java.lang.String
	 */
	public final static String changeStateDocument(Integer document, String fromState, String toState, java.sql.Date dateclose) throws java.lang.Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String result = "";
		try {
			String sql = "execute procedure changeStateContr(?, ?, ?, ?)";
			// Get JDBC connection
			con = jcon.getConnection();
			cs = con.prepareCall(sql);
			cs.setInt(1, document.intValue());
			cs.setString(2, fromState);
			cs.setString(3, toState);
			cs.setDate(4, dateclose);
			
			rs = cs.executeQuery();
			if (rs.next()) {
				int isok = rs.getInt(1);
				if (isok != 0)
					result = rs.getString(2);
			}
			//if (!con.getAutoCommit())
			//con.commit();
		} catch (Exception e) {
			System.out.println("Error in execute procedure changeStateContr(" + document + ", '" + fromState + "', '" + toState + "', '" + dateclose + "');");
			catchMetod(e);
		} finally {
			finallyMetod(con, cs, rs);
		}
		return result;
	}	
	/**
	 * 
	 * @param e
	 */
	private final static void catchMetod(Exception e) {
		if (e instanceof SQLException) {
			SQLException sqlExec = (SQLException) e;
			while (sqlExec != null) {
				System.out.println("Error code=" + sqlExec.getErrorCode());
				sqlExec = sqlExec.getNextException();
			}
		}
		e.printStackTrace(System.out);
	}
	/**
	 * Находит активное доп. соглашение по главному документу.
	 * Creation date: (15.03.2004 16:38:10)
	 * @return java.lang.Integer
	 * @param inBean LeaseArendaAgreementNewAccessBean 
	 * @param mainDocument java.lang.Integer
	 * @exception java.lang.Exception The exception description.
	 */
	public static LeaseArendaAgreementNewAccessBean getActiveDocument(LeaseArendaAgreementNewAccessBean inBean, Integer mainDocument_) throws Exception {
		//параметр _mainDocument не используется(используеться только в старой логике) а вычисляеться из inBean:
		//поиск активного документа:
		LeaseArendaAgreementNewAccessBean mainDoc = null; //главный:
		LeaseArendaAgreementNewAccessBean activeDoc = null; //активный:
		//сначало ищем главный(mainDoc):
		Integer mainDocumentKey = inBean.getMainDocument();
		if (mainDocumentKey != null) {
			//inBean - это доп соглашение - ищем главный:
			mainDoc = new LeaseArendaAgreementNewAccessBean();
			mainDoc.setInitKey_leaseDocument(mainDocumentKey.intValue());
			mainDoc.refreshCopyHelper();
		} else {
			//inBean - это главный:
			mainDoc = inBean;
		}
		//ищем активный(activeDoc):
		Integer activeDocumentKey = mainDoc.getActivecontract();
		if (activeDocumentKey != null) {
			activeDoc = new LeaseArendaAgreementNewAccessBean();
			activeDoc.setInitKey_leaseDocument(activeDocumentKey.intValue());
			activeDoc.refreshCopyHelper();
		} else {
			String errorStr = "Не найден активный документ для mainDocumentKey= " + mainDocumentKey + ", getLeaseDocument= " + inBean.getLeaseDocument();
			System.err.println(errorStr);
			System.out.println(errorStr);
		}
		/**
		 * отправляем в старую логику поиска активного документа:
		 */
		if (activeDoc == null) {
			System.out.println("Oтправляем в старую логику поиска активного документа для mainDocumentKey=" + mainDocumentKey);
			Enumeration e = inBean.findByQBE2(mainDocument_, new Boolean(true), new Boolean(true), new Boolean(false), null, new Integer(1));
			if (e.hasMoreElements()) {
				activeDoc = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			}
		}
		if (activeDoc == null) {
			//activeDocument = activeDoc.getLeaseDocument();
			activeDoc = new LeaseArendaAgreementNewAccessBean();
			activeDoc.setInitKey_leaseDocument(mainDocument_.intValue());
			activeDoc.refreshCopyHelper();
		}
		/**
		 * конец старой логики поиска
		 */

		return activeDoc;
	}
	/**
	 * Находит активное доп. соглашение по коду документа(доп соглашения).
	 * Creation date: (15.05.2006 16:38:10)
	 * @return LeaseArendaAgreementNewAccessBean
	 * @param mainDocument java.lang.Integer
	 * @exception java.lang.Exception The exception description.
	 */
	public final static LeaseArendaAgreementNewAccessBean getActiveDocument(int aLeaseDocument) {
		LeaseArendaAgreementNewAccessBean activeDoc = null; //активный:
		try {
			Integer activeCode = getCodeActiveDocument(aLeaseDocument);
			activeDoc = new LeaseArendaAgreementNewAccessBean();
			activeDoc.setInitKey_leaseDocument(activeCode.intValue());
			activeDoc.refreshCopyHelper();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка getActiveDocument для aLeaseDocument =" + aLeaseDocument);
			return null;
		}
		return activeDoc;
	}
	/**
	 * Находит главный документ по коду документа(доп соглашения)..
	 * Creation date: (15.05.2006 16:38:10)
	 * @return LeaseArendaAgreementNewAccessBean
	 * @param mainDocument java.lang.Integer
	 * @exception java.lang.Exception The exception description.
	 */
	public final static LeaseArendaAgreementNewAccessBean getMainDocument(int aLeaseDocument) {
		LeaseArendaAgreementNewAccessBean beanMain = null;
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(aLeaseDocument);
			bean.refreshCopyHelper();
			if (bean.getMainDocument() != null) {
				beanMain = new LeaseArendaAgreementNewAccessBean();
				beanMain.setInitKey_leaseDocument(bean.getMainDocument().intValue());
				beanMain.refreshCopyHelper();
			} else {
				beanMain = bean;
			}
			return beanMain;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка getMainDocument для aLeaseDocument =" + aLeaseDocument);
			return null;
		}
	}
	/**
	 * @deprecated
	 * Находит активное доп. соглашение по главному документу.* 
	 * Creation date: (15.03.2004 16:38:10)
	 * @return LeaseArendaAgreementNewAccessBean
	 * @param mainDocument java.lang.Integer
	 * @exception java.lang.Exception The exception description.
	 */
	public static LeaseArendaAgreementNewAccessBean getActiveDocument(Integer mainDocument) throws java.lang.Exception {
		return getActiveDocument(new LeaseArendaAgreementNewAccessBean(), mainDocument);
	}
	/**
	 * Находит активное доп. соглашение по главному документу.
	 * Creation date: (15.03.2004 16:38:10)
	 * @return java.lang.Integer
	 * @param inBean LeaseArendaAgreementNewAccessBean 
	 * @param mainDocument java.lang.Integer
	 * @exception java.lang.Exception The exception description.
	 * @deprecated
	 */
	public static Integer getCodeActiveDocument(Integer mainDocument) throws Exception {
		LeaseArendaAgreementNewAccessBean inBean = new LeaseArendaAgreementNewAccessBean();
		Enumeration e = inBean.findByQBE2(mainDocument, new Boolean(true), new Boolean(true), new Boolean(false), null, new Integer(1));
		if (e.hasMoreElements()) {
			LeaseArendaAgreementNewAccessBean activeDoc = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			return new Integer(activeDoc.getLeaseDocument());
		} else {
			return mainDocument;
		}
	}
	/**
	 * Поиск главной позиции.
	 * Creation date: (01.06.2004 15:59:25)
	 */

	public final static String getNameMainPosition(LeaseArendaAgreementNewAccessBean arendaBean) throws Exception {
		String name = "";
		PositionAccessBean bean = arendaBean.getMainposition();
		if (bean != null) {
			name = com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(bean);
		}
		return name;
	}
	/**
	 * Creation date: (18.03.2004 15:04:29)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		Integer mainDocument = new Integer(2595);
		String fromSate = "A";
		String toState = "B";
		try {
			String result = DocumentLogic.changeStateDocument(mainDocument, fromSate, toState, "");
			System.out.println("result: " + result);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}
	/**
	 * 
	 * @param aLeaseDocument
	 * @return Integer
	 */
	public final static Integer getCodeActiveDocument(int aLeaseDocument) {
		try {
			LeaseArendaAgreementNewAccessBean beanMain = getMainDocument(aLeaseDocument);
			return beanMain.getActivecontract();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка getCodeActiveDocument для getIdContract =" + aLeaseDocument);
			return null;
		}
	}
	/**
	 * Сумма НДС.
	 * Creation date: (04.05.2006 14:31:05)
	 */
	public final static BigDecimal calcSumNds(BigDecimal sum, BigDecimal rateNds, String flag) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		BigDecimal result = null; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure CalcSumNds(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setBigDecimal(1, sum); //сумма договора 
			cs.setBigDecimal(2, rateNds); //ставка ндс договора 
			cs.setString(3, flag); //флаг как считать НДС(Y-в том числе, N - не в том числе)		

			rs = cs.executeQuery();
			if (rs.next()) {
				result = rs.getBigDecimal(1); //integer, -- Признак ошибки (0 без ошибок)
			} else {
				System.out.println("no DATA: execute procedure 'CalcSumNds'");
			}
		} catch (Exception ex) {
			System.out.println("Error in execute procedure 'CalcSumNds(?, ?, ?)'");
			catchMetod(ex);
		} finally {
			finallyMetod(con, cs, rs);
		}
		return result;

	}	
	/**
	 * 
	 * @param con
	 * @param ps
	 * @param rs
	 */
	private final static void finallyMetod(Connection con, Statement stat, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (stat != null)
			stat.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
