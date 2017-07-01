package com.hps.july.arenda.cdbcobjects;

import java.util.*;
import java.math.BigDecimal;
import java.sql.*;

import com.hps.july.jdbcpersistence.lib.*;
import com.hps.april.auth.object.AuthInfo;
import com.hps.april.auth.object.AuthInfoImpl;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.mail.JulyMailServiceFactory;
import com.hps.july.mail.service.JulyMailService;
import com.hps.july.util.*;
import com.hps.july.valueobject.*;

/**
 * «Проблемы ведения договоров» CDBC_Object.
 * Creation date: (07.11.2005 12:14:30)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeaseContractProblem_Object {
	//public final static String TypeActionZP_create = "I";
	//public final static String TypeActionZP_modify = "U";
	private static final String FIND_SQL =
		"SELECT cp.idProblem, cp.leaseContract, cp.Note, cp.TypeProblem, cp.State, cp.executor, cp.owner, cp.modified, cp.created, cp.createdby, cp.modifiedby, getNamePeople(cp.executor) executorName, getNamePeople(cp.owner) ownerName, getNamePeople(cp.createdby) createdByName, getNamePeople(cp.modifiedby) modifiedByName, getManMailAddress(cp.executor) mailAddressExecutor, getManMailAddress(cp.owner) mailAddressOwner, ld.docNumber, ld.docDate, getListPosContract(ld.leaseDocument, 1) listPosContract FROM leaseContractProblem cp, leaseDocuments ld WHERE cp.leaseContract = ld.leaseDocument ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE LeaseContractProblem SET leaseContract=?, Note=?, TypeProblem=?, State=?, executor=?, owner=?, modified=?, created=?, createdby=?, modifiedby=? WHERE idProblem =? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO LeaseContractProblem (idProblem, leaseContract, Note, TypeProblem, State, executor, owner, modified, created, createdby, modifiedby) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM LeaseContractProblem WHERE idProblem = ?";
	private static final String FIND_LIST_SQL =
		"SELECT cp.idProblem, cp.leaseContract, cp.Note, cp.TypeProblem, cp.State, cp.executor, cp.owner, cp.modified, cp.created, cp.createdby, cp.modifiedby, getNamePeople(cp.executor) executorName, getNamePeople(cp.owner) ownerName, getNamePeople(cp.createdby) createdByName, getNamePeople(cp.modifiedby) modifiedByName FROM leaseContractProblem cp WHERE 1 = 1 ";
	private static final String FIND_LIST_PROBLEM_SQL =
		"SELECT first 1000 cp.idProblem, cp.leaseContract, cp.Note, cp.TypeProblem, cp.State, cp.executor, cp.owner, cp.modified, cp.created, cp.createdby, cp.modifiedby, getNamePeople(cp.executor) executorName, getNamePeople(cp.owner) ownerName, getNamePeople(cp.createdby) createdByName, getNamePeople(cp.modifiedby) modifiedByName, ld.docNumber, ld.docDate, getListPosContract(ld.leaseDocument, 1) listPosContract FROM leaseContractProblem cp, leaseDocuments ld WHERE cp.leaseContract = ld.leaseDocument ";
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:04:50)
	 */
	public static final boolean add(LeaseContractProblem_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdProblem(),
				vo.getLeaseContract(),
				vo.getNote(),
				vo.getTypeProblem(),
				vo.getState(),
				vo.getExecutor(),
				vo.getOwner(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(LeaseContractProblem_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getIdProblem()};
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(LeaseContractProblem_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getLeaseContract(),
				vo.getNote(),
				vo.getTypeProblem(),
				vo.getState(),
				vo.getExecutor(),
				vo.getOwner(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy(),
				vo.getIdProblem()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static LeaseContractProblem_TO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " AND idProblem = ? ";
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		LeaseContractProblem_TO to = null;
		if (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			to = populate(ro);
			to.setDocNumber(ro.getColumn("docNumber").asString());
			to.setDocDate((java.sql.Date) ro.getColumn("docDate").asObject());
			to.setListPosContract(ro.getColumn("listPosContract").asString());
			to.setMailAddressOwner(ro.getColumn("mailAddressOwner").asString());
			to.setMailAddressExecutor(ro.getColumn("mailAddressExecutor").asString());
		}
		return to;
	}
	/**
		 * Insert the method's description here.
		 * Creation date: (07.11.2005 12:19:16)
		 */
	private static LeaseContractProblem_TO populate(CDBCRowObject ro) {
		LeaseContractProblem_TO to = new LeaseContractProblem_TO(CDBC_MapFactory.createLeaseContractProblem(ro));
		to.setExecutorName(ro.getColumn("executorName").asString());
		to.setOwnerName(ro.getColumn("ownerName").asString());
		to.setCreatedByName(ro.getColumn("createdByName").asString());
		to.setModifiedByName(ro.getColumn("modifiedByName").asString());

		return to;
	}
	/**
	 * Поиск по определенному контракту.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getList(Integer mainLeaseContractKey, Boolean isState, String state, Integer searchFilter, String searchString, String aSortBy) {
		List ret = new ArrayList();
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LIST_SQL);
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		filter.append(" AND leasecontract = ? ");
		params.add(mainLeaseContractKey);
		if (isState.booleanValue()) {
			filter.append(" AND state = ? ");
			params.add(state);
		}
		/**		
				if (searchFilter.intValue() == 0) {
					filter.append(" AND typeRegistry = ? ");
					params.add(searchString);
				}
				else if (searchFilter.intValue() == 0) {
					filter.append(" AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastname) matches upper(?) ) ");
					params.add(searchString);
				}
				else if (searchFilter.intValue() == 0) {
					filter.append(" AND regionID = ? ");
					params.add(searchString);
				}
				else if (searchFilter.intValue() == 0) {
					filter.append(" AND owner IN ( SELECT man FROM operators WHERE operator=? ) ");
					params.add(searchString);
				}
		*/
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		//System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseContractProblem_TO to = null;
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			to = populate(ro);
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Поиск по всем контрактам.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getListProblem(Boolean isState, String state, Integer searchFilter, String searchString, Boolean isRegionID, Integer regionID, String aSortBy) {
		List ret = new ArrayList();
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LIST_PROBLEM_SQL);
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		//состояние проблемы:
		if (isState.booleanValue()) {
			filter.append(" AND state = ? ");
			params.add(state);
		}
		//filter 2:
		if (searchFilter.intValue() == 1) {
			//filter.append(" AND executor IN ( SELECT man FROM people p WHERE  upper(p.lastname) matches upper(?) ) ");
			//params.add(searchString);
			addSQLforPeople("executor", searchString, params, filter);
		} else if (searchFilter.intValue() == 2) {
			//filter.append(" AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastname) matches upper(?) ) ");
			//params.add(searchString);
			addSQLforPeople("owner", searchString, params, filter);
		}
		//		//filter 3:
		if (isRegionID.booleanValue()) {
			filter.append("AND ld.regionId = ? ");
			params.add(regionID);
		}
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		//System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseContractProblem_TO to = null;
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			to = populate(ro);
			to.setDocNumber(ro.getColumn("docNumber").asString());
			to.setDocDate((java.sql.Date) ro.getColumn("docDate").asObject());
			to.setListPosContract(ro.getColumn("listPosContract").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * 
	 * @param people
	 * @param peopleName
	 * @param params
	 * @param filter
	 */
	private static void addSQLforPeople(String people, String peopleName, ArrayList params, StringBuffer filter) {
		//filter.append(" AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastname) matches upper(?) ) ");
		//params.add(ownerName);
		String strF = " AND " + people + " IN ( SELECT man FROM people p WHERE  upper(p.lastName) matches upper(?) ) ";
		String strFI = " AND " + people + " IN ( SELECT man FROM people p WHERE  upper(p.lastName) matches upper(?) AND upper(p.firstName) matches upper(?) ) ";
		String strFIO = " AND " + people + " IN ( SELECT man FROM people p WHERE  upper(p.lastName) matches upper(?) AND upper(p.firstName) matches upper(?) AND upper(p.middleName) matches upper(?) ) ";
		StringTokenizer st = new StringTokenizer(peopleName, "., ");
		if (st.countTokens() == 2) {
			filter.append(strFI);
			params.add(st.nextToken());
			params.add(st.nextToken() + "*");
		} else if (st.countTokens() == 3) {
			filter.append(strFIO);
			params.add(st.nextToken());
			params.add(st.nextToken() + "*");
			params.add(st.nextToken() + "*");
		} else {
			filter.append(strF);
			params.add(peopleName);
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:31:05)
	 */
	public static String changeStateLeaseContractProblem(int idCode, String toState, int codeOperator) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = ""; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure changeStateLeaseContractProblem(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, idCode); //код 
			cs.setString(2, toState); //желаемое состояние 
			cs.setInt(3, codeOperator); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("Процедура 'changeStateLeaseContractProblem' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'changeStateLeaseContractProblem' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'changeStateLeaseContractProblem'"); //temp
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'changeStateLeaseContractProblem(?, ?, ?)'";
			System.out.println(errorTxt);
			if (ex instanceof SQLException) {
				errorTxt += "Error code=" + ((SQLException) ex).getErrorCode();
				System.out.println(errorTxt);
			}
			ex.printStackTrace();
		} finally {
			finallyMetod(con, cs, rs);
		}
		return errorTxt;

	}
	/**
	 * 
	 * @param con
	 * @param cs
	 * @param rs
	 */
	private static void finallyMetod(Connection con, CallableStatement cs, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (cs != null)
				cs.close();
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

	/**
	 * Отправка сообщения об измении состояния проблемы.
	 *
	 */

	public static final void sendMail(Integer codeOperator, int codeID, String princName) {
		AuthInfoImpl info = new AuthInfoImpl(princName);
		info.setOperatorId(codeOperator);
		info.setOperatorLogin(princName);
		People_VO people_vo = CDBC_MapFactory.getPeopleVO_fromOperatorCode(princName);
		info.setPersonId(people_vo.getMan());

		//ArendaMailServiceFactory.createMailService().sendArendaTestMail(info);//test

		HashMap prop = new HashMap();
		LeaseContractProblem_TO to = CDBC_LeaseContractProblem_Object.find(codeID);

		prop.put("idProblem", to.getVo().getIdProblem()); //Проблема №
		//Проблема от:
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		String createdStr = "";
		Timestamp created = to.getVo().getCreated();
		if (created != null) {
			createdStr = format.format(new java.util.Date(created.getTime()));
		}
		prop.put("created", createdStr);

		prop.put("docNumber", to.getDocNumber()); //Договор №
		//Договор от:
		format = new java.text.SimpleDateFormat("dd.MM.yyyy");
		String docDateStr = "";
		java.sql.Date docDate = to.getDocDate();
		if (docDate != null) {
			docDateStr = format.format(new java.util.Date(docDate.getTime()));
		}
		prop.put("docDate", docDateStr);

		prop.put("listPosContract", to.getListPosContract()); //позиция
		prop.put("ownerName", to.getOwnerName()); //Инициатор
		prop.put("ownerMail", to.getMailAddressOwner()); //Инициатор mail
		prop.put("typeProblem", to.getVo().getTypeProblemStr()); // Тип проблемы
		prop.put("note", to.getVo().getNote()); //Описание проблемы 

		ArrayList recipientList = new ArrayList();
		//System.out.println("["+to.getMailAddressExecutor()+"] ["+to.getMailAddressOwner()+"]");
		recipientList.add(to.getMailAddressExecutor());
		//recipientList.add(to.getMailAddressOwner());

		JulyMailServiceFactory.createMailService().sendHTMLMailByTemplate(
			info,
			recipientList,
			"инцидент №" + to.getVo().getIdProblem() + " по договору аренды №" + to.getDocNumber() + " от " + to.getVo().getCreated(),
			"com/hps/july/mail/template/arenda/LeaseProblemMailTemplate.message",
			prop,
			JulyMailService.ARENDA_SERVICE_NAME);
	}

}
