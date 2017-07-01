package com.hps.july.arenda.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.sql.*;
import javax.sql.*;
import com.hps.july.arenda.sessionbean.*;
/**
 * Печать актов в Word-e.
 * Creation date: (30.07.2002 17:33:08)
 * @author: Shafigullin Ildar
 */
public class MutactWordAction extends com.hps.july.web.util.NavigatedAction {
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 16:06:38)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @exception java.lang.Exception The exception description.
	 */
	private MutualHeaderValueObject getHeader(Statement stmt, String actcode) throws java.lang.Exception {
		MutualHeaderValueObject vo = new MutualHeaderValueObject();
		String s = "execute procedure MakeMutualHeader(" + actcode + ")";
		ResultSet r = stmt.executeQuery(s);
		try {
			if (r.next()) {
				vo.setCodeAkt(new Integer(r.getInt(1))); // INTEGER,	CodeAkt
				vo.setNumberAkt(r.getString(2)); // CHAR(30),	NumberAkt
				vo.setDateAkt(r.getDate(3)); // DATE,	DateAkt
				vo.setPosition(r.getString(4)); // CHAR(30),	Position
				vo.setHeader1(r.getString(5)); // CHAR(1000),	Header1
				vo.setHeader2(r.getString(6)); // CHAR(1000),	Header2
				vo.setDateStartAkt(r.getDate(7)); // DATE,	DateStartAkt
				vo.setDateEndAkt(r.getDate(8)); // DATE,	DateEndAkt
				vo.setIsCommonRate(r.getString(9)); // CHAR(1),	isCommonRate
				vo.setCommonRate(r.getBigDecimal(10)); // decimal(15,4),	CommonRate
				vo.setCommonRateDate(r.getDate(11)); // DATE,	CommonRateDate
				vo.setUserHeader(r.getString(12)); // CHAR(80),	UserHeader
				vo.setUserFooter(r.getString(13)); // CHAR(80),	UserFooter
				vo.setOtvUser(r.getString(14)); // CHAR(80),	OtvUser
				vo.setMainCurr(r.getString(15)); // CHAR(30),	mainCurr
				vo.setDopCurr(r.getString(16)); // CHAR(30),	dopCurr
				vo.setCustomer(r.getString(17)); // CHAR(80),	Customer
				vo.setExecutor(r.getString(18)); // CHAR(80),	Executor
				vo.setJobCustomer(r.getString(19)); // CHAR(80),	JobCustomer
				vo.setJobExecutor(r.getString(20)); // CHAR(80),	JobExecutor
				vo.setFioCustomer(r.getString(21)); // CHAR(80),	FioCustomer
				vo.setFioExecutor(r.getString(22)); // CHAR(80),	FioExecutor
				vo.setOtvEconomist(r.getString(23)); // char(80),	OtvEconomist
				vo.setCountPayments(new Integer(r.getInt(24))); // INTEGER,	CountPayments
				vo.setCountStartDebt(new Integer(r.getInt(25))); // INTEGER,	CountStartDebt
				vo.setCountcharges(new Integer(r.getInt(26))); // INTEGER,	countcharges
				vo.setCountenddebt(new Integer(r.getInt(27))); // INTEGER, countenddebt
				vo.setHeader3(r.getString(28)); // char (1000),	Header3
				vo.setMutualSumMain(r.getBigDecimal(29)); // decimal(15,2),	MutualSumMain
				vo.setMutualNdsMain(r.getBigDecimal(30)); // decimal(15,2),	MutualNdsMain
				vo.setMutualSumDop(r.getBigDecimal(31)); // decimal(15,2),	MutualSumDop
				vo.setMutualNdsDop(r.getBigDecimal(32)); // decimal(15,2),	MutualNdsDop
				vo.setHeaderId(new Integer(r.getInt(33))); //integer, порядковый номер записи
				vo.setHighColontitul(r.getString(34)); //char(80), верхний колонтитул
				vo.setTown(r.getString(35)); //char(80) town
				vo.setPurposePayNds(r.getString(36)); //char(255); назначение платежа НДС
			} else {
				System.out.println("Отчет не может быть распечатан: actcode=" + actcode);
			}
		} finally {
			if (r != null)
				r.close();
		}

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 16:06:38)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getHeaderAccList(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure makeAccMutualHeader(" + actcode + ")";
		ResultSet r = stmt.executeQuery(s);
		try {
			while (r.next()) {
				MutualHeaderAccValueObject vo = new MutualHeaderAccValueObject();
				vo.setCodeAkt(new Integer(r.getInt(1))); // INTEGER,	CodeAkt
				vo.setNumberAkt(r.getString(2)); // CHAR(30),	NumberAkt
				vo.setDateAkt(r.getDate(3)); // DATE,	DateAkt
				vo.setPosition(r.getString(4)); // CHAR(30),	Position
				vo.setHeader1(r.getString(5)); // CHAR(1000),	Header1
				vo.setHeader2(r.getString(6)); // CHAR(1000),	Header2
				vo.setHeader3(r.getString(7)); // CHAR(1000),	Header3
				vo.setHeader4(r.getString(8)); // CHAR(1000),	Header4
				vo.setDateStartAkt(r.getDate(9)); // DATE,	DateStartAkt
				vo.setDateEndAkt(r.getDate(10)); // DATE,	DateEndAkt
				vo.setIsCommonRate(r.getString(11)); // CHAR(1),	isCommonRate
				vo.setCommonRate(r.getBigDecimal(12)); // decimal(15,4),	CommonRate
				vo.setCommonRateDate(r.getDate(13)); // DATE,	CommonRateDate
				vo.setUserHeader(r.getString(14)); // CHAR(80),	UserHeader
				vo.setUserFooter(r.getString(15)); // CHAR(80),	UserFooter
				vo.setOtvUser(r.getString(16)); // CHAR(80),	OtvUser
				vo.setMainCurr(r.getString(17)); // CHAR(30),	mainCurr
				vo.setDopCurr(r.getString(18)); // CHAR(30),	dopCurr
				vo.setNameOrg1(r.getString(19)); // CHAR(80)	nameOrg1
				vo.setNameOrg2(r.getString(20)); // CHAR(80)	nameOrg2
				vo.setNameOrg3(r.getString(21)); // CHAR(30)	nameOrg3
				vo.setJobOrg1(r.getString(22)); // CHAR(80)	JobOrg1
				vo.setJobOrg2(r.getString(23)); // CHAR(80)	JobOrg2
				vo.setJobOrg3(r.getString(24)); // CHAR(80)	JobOrg3
				vo.setFioOrg1(r.getString(25)); // CHAR(80)	FioOrg1
				vo.setFioOrg2(r.getString(26)); // CHAR(80)	FioOrg2
				vo.setFioOrg3(r.getString(27)); // CHAR(80)	FioOrg3
				vo.setOtvEconomist(r.getString(28)); // char(80),	OtvEconomist
				vo.setCountPayments(new Integer(r.getInt(29))); // INTEGER,	CountPayments
				vo.setCountStartDebt(new Integer(r.getInt(30))); // INTEGER,	CountStartDebt
				vo.setCountCharges(new Integer(r.getInt(31))); // INTEGER,	countCharges
				vo.setCountEndDebt(new Integer(r.getInt(32))); // INTEGER, countEndDebt
				vo.setMutualSumMain(r.getBigDecimal(33)); // decimal(15,2),	MutualSumMain
				vo.setMutualNdsMain(r.getBigDecimal(34)); // decimal(15,2),	MutualNdsMain
				vo.setMutualSumDop(r.getBigDecimal(35)); // decimal(15,2),	MutualSumDop
				vo.setMutualNdsDop(r.getBigDecimal(36)); // decimal(15,2),	MutualNdsDop
				vo.setHeaderId(new Integer(r.getInt(37))); //integer, порядковый номер
				vo.setHighColontitul(r.getString(38)); //char(80), HighColontitul Верхний колонтитул
				vo.setTown(r.getString(39)); //char(80),  город
				vo.setPurposePayNds(r.getString(40)); //char(255); назначение платежа НДС
				list.add(vo);
			}
		} finally {
			if (r != null)
				r.close();
		}

		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 18:43:44)
	 * @return int
	 */
	private int getIdTask(HttpServletRequest request, int actcode) {
		int operator = 0; // only for wte!!! set operator = 0 for ws!!!
		try {
			operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int idTask = 3836; //return 3836;3836;3841(codeakt=29) //temp
		//int idTask = -1; 
		try {
			idTask = new ArendaDocumentProcessorAccessBean().makeCalcForReport(actcode, operator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idTask;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 19:15:20)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param actcode java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getList1(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure MakeMutStartDebt(" + actcode + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				MutualStartDebtValueObject ao1 = new MutualStartDebtValueObject();
				ao1.setCustomer(rs.getString(1)); // CHAR(80)	l_Customer
				ao1.setExecutor(rs.getString(2)); // CHAR(80)	l_Executor
				ao1.setResname(rs.getString(3)); // char(80)	l_resName
				ao1.setContractNumber(rs.getString(4)); // char(30)	l_ContractNumber
				ao1.setContractDate(rs.getDate(5)); // date	l_ContractDate
				ao1.setSumm(rs.getBigDecimal(6)); // dec(15,2)	l_Summ
				ao1.setCur(rs.getString(7)); // CHAR(30)	l_Curr
				ao1.setSummain(rs.getBigDecimal(8)); // dec(15,2)	l_SumMain
				ao1.setCurrMain(rs.getString(9)); // char(30)	l_CurrMain
				ao1.setDateStartAkt(rs.getDate(10)); // date	DateStartAkt
				ao1.setNumberAct(rs.getString(11)); // char(30)	NumberAkt
				ao1.setDateAct(rs.getDate(12)); // date	dateAkt
				ao1.setHeaderId(new Integer(rs.getInt(13)));
				ao1.setNds(rs.getBigDecimal(14)); // dec(15,2)	l_nds
				ao1.setNdsRub(rs.getBigDecimal(15)); // dec(15,2)	l_ndsRUB
				ao1.setSumWithoutMain(rs.getBigDecimal(16)); //dec(15,2) SumWithoutMain         
				list.add(ao1);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 19:15:20)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param actcode java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getList2(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure MakeMutualCharges(" + actcode + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				MutualChargesValueObject ao2 = new MutualChargesValueObject();
				ao2.setCodeAkt(new Integer(rs.getInt(1))); // INTEGER,	CodeAkt
				ao2.setCodeContract(new Integer(rs.getInt(2))); // integer,	CodeContract
				ao2.setCodeResource(new Integer(rs.getInt(3))); // INTEGER,	CodeResource
				ao2.setCustomer(rs.getString(4)); // CHAR(80),	Customer
				ao2.setExecutor(rs.getString(5)); // CHAR(80),	Executor
				ao2.setResName(rs.getString(6)); // CHAR(80),	ResName
				ao2.setContractNumber(rs.getString(7)); // CHAR(30),	ContractNumber
				ao2.setContractDate(rs.getDate(8)); // DATE,	ContractDate
				ao2.setBillNumber(rs.getString(9)); // CHAR(30),	BillNumber
				ao2.setBillDate(rs.getDate(10)); // DATE,	BillDate
				ao2.setDateCharge(rs.getDate(11)); // DATE,	DateCharge
				ao2.setDateStart(rs.getDate(12)); // DATE,	DateStart
				ao2.setDateEnd(rs.getDate(13)); // DATE,	DateEnd
				ao2.setSumContract(rs.getBigDecimal(14)); // decimal(15,2),	SumContract
				ao2.setNdsContract(rs.getBigDecimal(15)); // decimal(15,2),	NdsContract
				ao2.setCurrContract(rs.getString(16)); // CHAR(30),	CurrContract
				ao2.setRateContract(rs.getBigDecimal(17)); // decimal(15,4),	RateContract
				ao2.setSumRub(rs.getBigDecimal(18)); // decimal(15,2),	SumRub
				ao2.setNdsRub(rs.getBigDecimal(19)); // decimal(15,2),	NdsRub
				ao2.setMainCurr(rs.getString(20)); // CHAR(30),	mainCurr
				ao2.setRateMainCurr(rs.getBigDecimal(21)); // decimal(15,4),	rateMainCurr
				ao2.setSumMainCurr(rs.getBigDecimal(22)); // decimal(15,2),	SumMainCurr
				ao2.setNdsMainCurr(rs.getBigDecimal(23)); //  decimal(15,2),	NdsMainCurr
				ao2.setDopCurr(rs.getString(24)); // CHAR(30),	DopCurr
				ao2.setRateDopCurr(rs.getBigDecimal(25)); // decimal(15,4),	rateDopCurr
				ao2.setSumDopCurr(rs.getBigDecimal(26)); // decimal(15,2),	SumDopCurr
				ao2.setNdsDopCurr(rs.getBigDecimal(27)); // decimal(15,2),	NdsDopCurr
				ao2.setIsCustomerBeeline(new Integer(rs.getInt(28))); // integer,"isCustomerBeeline"
				ao2.setSumRubDifference(rs.getBigDecimal(29)); // decimal(15,2),"SumRubDifference"
				ao2.setHeaderId(new Integer(rs.getInt(30))); //
				ao2.setSumWithoutMain(rs.getBigDecimal(31)); //decimal(15,2), " сумма без НДС  в валюте акта"
				list.add(ao2);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 19:15:20)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param actcode java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getList3(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure MakeMutualPayments(" + actcode + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				MutualPaymentsValueObject ao3 = new MutualPaymentsValueObject();
				ao3.setCodeResource(new Integer(rs.getInt(1))); // integer,	CodeResource
				ao3.setCodeContract(new Integer(rs.getInt(2))); // integer,	CodeContract
				ao3.setCodeAkt(new Integer(rs.getInt(3))); // integer,	CodeAkt
				ao3.setPayDate(rs.getDate(4)); // DATE,	PayDate
				ao3.setPayNumber(rs.getString(5)); // CHAR(30),	PayNumber
				ao3.setContractNumber(rs.getString(6)); // CHAR(30),	ContractNumber
				ao3.setContractDate(rs.getDate(7)); // DATE,	ContractDate
				ao3.setOrgPayer(rs.getString(8)); // CHAR(80),	OrgPayer
				ao3.setResName(rs.getString(9)); // CHAR(80),	ResName
				ao3.setDateStart(rs.getDate(10)); // DATE,	DateStart
				ao3.setDateEnd(rs.getDate(11)); // DATE,	DateEnd
				ao3.setSumRub(rs.getBigDecimal(12)); // decimal(15,2),	SumRub
				ao3.setNdsRub(rs.getBigDecimal(13)); // decimal(15,2),	NdsRub
				ao3.setCurrContract(rs.getString(14)); // CHAR(30),	CurrContract
				ao3.setRateContract(rs.getBigDecimal(15)); // decimal(15,4),	RateContract
				ao3.setSumContract(rs.getBigDecimal(16)); // decimal(15,2),	SumContract
				ao3.setNdsContract(rs.getBigDecimal(17)); // decimal(15,2),	NdsContract
				ao3.setMainCurr(rs.getString(18)); // CHAR(30),	mainCurr
				ao3.setRateMainCurr(rs.getBigDecimal(19)); // decimal(15,4),	rateMainCurr
				ao3.setSumMainCurr(rs.getBigDecimal(20)); // decimal(15,2),	SumMainCurr
				ao3.setNdsMainCurr(rs.getBigDecimal(21)); // decimal(15,2),	NdsMainCurr
				ao3.setDopCurr(rs.getString(22)); // CHAR(30),	DopCurr
				ao3.setRateDopCurr(rs.getBigDecimal(23)); // decimal(15,4),	RateDopCurr
				ao3.setSumDopCurr(rs.getBigDecimal(24)); // decimal(15,2),	SumDopCurr
				ao3.setNdsDopCurr(rs.getBigDecimal(25)); // decimal(15,2),	NdsDopCurr
				ao3.setHeaderId(new Integer(rs.getInt(26)));
				//System.out.println( "agent: "+rs.getString(27) );//temp
				ao3.setAgent(rs.getString(27)); //"в счет расчетов с кем?"
				ao3.setSumWithoutMain(rs.getBigDecimal(28)); //decimal(15,2), " сумма без НДС  в валюте акта"
				list.add(ao3);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 19:19:58)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param actcode java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getList4(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure MakeMutualEndDebt(" + actcode + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				MutualEndDebtValueObject ao4 = new MutualEndDebtValueObject();
				ao4.setCustomer(rs.getString(1)); // CHAR(80),	Customer
				ao4.setExecutor(rs.getString(2)); // CHAR(80),	Executor
				ao4.setResName(rs.getString(3)); // CHAR(50),	ResName
				ao4.setContractNumber(rs.getString(4)); // CHAR(30),	ContractNumber
				ao4.setContractDate(rs.getDate(5)); // DATE,	ContractDate
				ao4.setSumMain(rs.getBigDecimal(6)); // dec(15,2),	SumMain
				ao4.setNdsMain(rs.getBigDecimal(7)); // dec(15,2),	NdsMain
				ao4.setCurrMain(rs.getString(8).trim()); // char(30),	CurrMain
				ao4.setSumDop(rs.getBigDecimal(9)); // dec(15,2),	SumDop
				ao4.setNdsDop(rs.getBigDecimal(10)); // dec(15,2),	NdsDop
				ao4.setCurrDop(rs.getString(11)); // char(30),	CurrDop
				ao4.setDateStartAkt(rs.getDate(12)); // date,	DateStartAkt
				ao4.setDateEndAkt(rs.getDate(13)); // date,	DateEndAkt
				ao4.setHeaderId(new Integer(rs.getInt(14)));
				ao4.setSumWithoutMain(rs.getBigDecimal(15)); //dec(15,2) SumWithoutMain
				list.add(ao4);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 19:15:20)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param actcode java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getList5(Statement stmt, int idTask) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "SELECT * FROM _SverkaChrgAndPay WHERE IdTaskStart = " + idTask;
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				SverkaChrgAndPayValueObject vo = new SverkaChrgAndPayValueObject();
				vo.setCodeResource(new Integer(rs.getInt("CodeResource"))); // integer
				vo.setCodeContract(new Integer(rs.getInt("CodeContract"))); // integer
				vo.setCodeAkt(new Integer(rs.getInt("CodeAkt"))); // integer,	CodeAkt
				vo.setCustomer(rs.getString("Customer")); //CHAR(80)
				vo.setExecutor(rs.getString("Executor")); //CHAR(80)
				vo.setMainCurr(rs.getString("mainCurr")); //CHAR(30)
				vo.setDopCurr(rs.getString("dopCurr")); //CHAR(30)
				vo.setResName(rs.getString("ResName")); //CHAR(80)
				vo.setPeriodContract(new Integer(rs.getInt("PeriodContract"))); //Integer
				vo.setPeriodResource(new Integer(rs.getInt("PeriodResource"))); //Integer
				vo.setPeriodStart(rs.getDate("PeriodStart")); //Date
				vo.setPeriodEnd(rs.getDate("PeriodEnd")); //Date
				vo.setBillNumber(rs.getString("BillNumber")); //char(30)
				vo.setBillDate(rs.getDate("BillDate")); //DATE,
				vo.setSumCharge(rs.getBigDecimal("SumCharge")); //decimal(15,2)
				vo.setNdsCharge(rs.getBigDecimal("NdsCharge")); //decimal(15,2)
				vo.setMainSumCharge(rs.getBigDecimal("mainSumCharge")); //decimal(15,2)
				vo.setMainNdsCharge(rs.getBigDecimal("mainNdsCharge")); //decimal(15, 2)
				vo.setPayNumber(rs.getString("PayNumber")); //CHAR(30)
				vo.setPayDate(rs.getDate("PayDate")); //Date
				vo.setSumRubPay(rs.getBigDecimal("SumRubPay")); //decimal(15, 2)
				vo.setNdsRubPay(rs.getBigDecimal("NdsRubPay")); //decimal(15, 2)
				vo.setRateContractPay(rs.getBigDecimal("RateContractPay")); //decimal(15, 2)
				vo.setSumContractPay(rs.getBigDecimal("SumContractPay")); //decimal(15, 2)
				vo.setNdsContractPay(rs.getBigDecimal("NdsContractPay")); //decimal(15, 2)
				vo.setRateMainPay(rs.getBigDecimal("RateMainPay")); //decimal(15, 2)
				vo.setSumMainPay(rs.getBigDecimal("SumMainPay")); //decimal(15, 2)
				vo.setNdsMainPay(rs.getBigDecimal("NdsMainPay")); //decimal(15, 2)
				vo.setStartSaldoMain(rs.getBigDecimal("startSaldoMain")); //decimal(15, 2)
				vo.setStartNdsSaldoMain(rs.getBigDecimal("startNdsSaldoMain"));
				//decimal(15, 2)
				vo.setEndSaldoMain(rs.getBigDecimal("endSaldoMain")); //decimal(15, 2)
				vo.setEndNdsSaldoMain(rs.getBigDecimal("endNdsSaldoMain")); //decimal(15, 2)
				vo.setEndSaldoDop(rs.getBigDecimal("endSaldoDop")); //decimal(15, 2)
				vo.setEndNdsSaldoDop(rs.getBigDecimal("endNdsSaldoDop")); //decimal(15, 2)
				vo.setSumRubDifference(rs.getBigDecimal("SumRubDifference")); //decimal(15, 2)
				vo.setDateStartAkt(rs.getDate("datestartakt")); //date
				vo.setDateEndAkt(rs.getDate("dateendakt")); //date
				//new data:
				vo.setCurrCharge(rs.getString("currCharge"));
				//System.out.println("currCharge" + rs.getString("currCharge"));//temp
				vo.setRateCharge(rs.getBigDecimal("rateCharge"));
				//System.out.println("rateCharge" + rs.getBigDecimal("rateCharge"));//temp

				list.add(vo);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 16:06:38)
	 * @return SverkaHeaderValueObject
	 * @param stmt java.sql.Statement
	 * @exception java.lang.Exception The exception description.
	 */
	private SverkaContrResValueObject getSverkaContrRes(Statement stmt, int idTask) throws java.lang.Exception {
		SverkaContrResValueObject vo = new SverkaContrResValueObject();
		String s = "SELECT * FROM _SverkaContrRes WHERE IdTaskStart = " + idTask;
		ResultSet r = stmt.executeQuery(s);
		try {
			if (r.next()) {
				vo.setCodeContract(new Integer(r.getInt("codecontract"))); // INTEGER
				vo.setCodeResource(new Integer(r.getInt("coderesource"))); //INTEGER
				vo.setCodeAkt(new Integer(r.getInt("codeakt"))); //INTEGER
				vo.setNumberContract(r.getString("numbercontract")); // CHAR(30)
				vo.setDateContract(r.getDate("datecontract")); // DATE
				vo.setCustomer(r.getString("customer")); // CHAR(80),	Customer
				vo.setExecutor(r.getString("executor")); // CHAR(80),	Executor
				vo.setResName(r.getString("resname")); // CHAR(50),
				vo.setMainCurr(r.getString("maincurr")); // CHAR(30),	mainCurr
				vo.setStartSumMainCurr(r.getBigDecimal("startsummaincurr")); //decimal(15,2)
				vo.setStartNdsMainCurr(r.getBigDecimal("startndsmaincurr")); //decimal(15,2)
				vo.setEndSumMainCurr(r.getBigDecimal("endsummaincurr")); //decimal(15,2)
				vo.setEndNdsMainCurr(r.getBigDecimal("endndsmaincurr")); //decimal(15,2)
				vo.setDopCurr(r.getString("dopcurr")); //CHAR(30)
				vo.setStartSumDopCurr(r.getBigDecimal("startsumdopcurr")); //decimal(15,2)
				vo.setStartNdsDopCurr(r.getBigDecimal("startndsdopcurr")); //decimal(15,2)
				vo.setEndSumDopCurr(r.getBigDecimal("endsumdopcurr")); //decimal(15,2)
				vo.setEndNdsDopCurr(r.getBigDecimal("endndsdopcurr")); //decimal(15,2)
				vo.setSumRubDifference(r.getBigDecimal("sumrubdifference")); //decimal(15,2)
				vo.setDateStartAkt(r.getDate("datestartakt")); // DATE,	DateStartAkt
				vo.setDateEndAkt(r.getDate("dateendakt")); // DATE,	DateEndAkt
			} else {
				System.out.println("Отчет не может быть распечатан: idTask=" + idTask);
			}
		} finally {
			if (r != null)
				r.close();
		}

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 16:06:38)
	 * @return SverkaHeaderValueObject
	 * @param stmt java.sql.Statement
	 * @exception java.lang.Exception The exception description.
	 */
	private SverkaHeaderValueObject getSverkaHeader(Statement stmt, int idTask) throws java.lang.Exception {
		SverkaHeaderValueObject vo = new SverkaHeaderValueObject();
		String s = "SELECT * FROM _SverkaHeader WHERE IdTaskStart = " + idTask;
		ResultSet r = stmt.executeQuery(s);
		try {
			if (r.next()) {
				vo.setCodeAkt(new Integer(r.getInt("codeakt"))); // INTEGER,	CodeAkt
				vo.setNumberAkt(r.getString("numberakt")); // CHAR(30),	NumberAkt
				vo.setDateAkt(r.getDate("dateakt")); // DATE,	DateAkt
				vo.setPosition(r.getString("position")); // CHAR(30),	Position
				vo.setHeader1(r.getString("header1")); // CHAR(1000),	Header1
				vo.setHeader2(r.getString("header2")); // CHAR(1000),	Header2
				vo.setDateStartAkt(r.getDate("datestartakt")); // DATE,	DateStartAkt
				vo.setDateEndAkt(r.getDate("dateendakt")); // DATE,	DateEndAkt
				vo.setIsCommonRate(r.getString("iscommonrate")); // CHAR(1),	isCommonRate
				vo.setCommonRate(r.getBigDecimal("commonrate")); // decimal(15,4),	CommonRate
				vo.setCommonRateDate(r.getDate("commonratedate")); // DATE,	CommonRateDate
				vo.setUserHeader(r.getString("userheader")); // CHAR(80),	UserHeader
				vo.setUserFooter(r.getString("userfooter")); // CHAR(80),	UserFooter
				vo.setOtvUser(r.getString("otvuser")); // CHAR(80),	OtvUser
				vo.setMainCurr(r.getString("maincurr")); // CHAR(30),	mainCurr
				vo.setDopCurr(r.getString("dopcurr")); // CHAR(30),	dopCurr
				vo.setContractNumber(r.getString("contractnumber")); //CHAR(30)
				vo.setContractDate(r.getDate("contractdate")); //DATE
				vo.setCustomer(r.getString("customer")); // CHAR(80),	Customer
				vo.setExecutor(r.getString("executor")); // CHAR(80),	Executor
				vo.setJobCustomer(r.getString("jobcustomer")); // CHAR(80),	JobCustomer
				vo.setJobExecutor(r.getString("jobexecutor")); // CHAR(80),	JobExecutor
				vo.setFioCustomer(r.getString("fiocustomer")); // CHAR(80),	FioCustomer
				vo.setFioExecutor(r.getString("fioexecutor")); // CHAR(80),	FioExecutor
				vo.setOtvEconomist(r.getString("otveconomist")); // char(80),	OtvEconomist
				vo.setHighColontitul(r.getString("highcolontitul")); //
				vo.setTypeView(r.getInt("typeview"));
				vo.setTown(r.getString("town"));
			} else {
				System.out.println("Отчет не может быть распечатан: idTask=" + idTask);
			}
		} finally {
			if (r != null)
				r.close();
		}

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 15:45:21)
	 * @return java.lang.String
	 */
	private String getTypeAkt(Statement stmt, String actcode) throws java.lang.Exception {
		/**
		String s =
			"select leasemutualrglmnt.acttype from leasemutualrglmnt, leasemutualacts "
				+ "where leasemutualrglmnt.leasedocument = leasemutualacts.mutualreglament "
				+ "and leasemutualacts.leasedocument ="
				+ actcode;
		*/
		String s = "execute procedure getTypeAct(" + actcode + ")";
		ResultSet r = stmt.executeQuery(s);
		String result = "";
		try {
			r.next();
			return r.getString(1);

		} finally {
			if (r != null)
				r.close();
		}
	}
	/**
	 * Shows if to add current URL to history.
	 * Creation date: (08.10.2003 17:21:05)
	 * @return boolean
	 */
	public boolean isAddtoHistory() {
		return false;
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//response.setContentType("application/msword; name=mutAct1.doc");
		//response.setHeader("Cache-Control", "no-cache");
		//response.setHeader("Content-Disposition", "inline; filename=mutAct1.doc");

		super.perform(mapping, form, request, response);

		MutactWordPrintForm eform = (MutactWordPrintForm) form;
		String actCode = eform.getActcode();
		String typeAkt = null;

		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		Statement st = null;
		try {
			con = jcon.getConnection();
			st = con.createStatement();

			typeAkt = getTypeAkt(st, actCode);
			System.out.println("Type akt: " + typeAkt); //temp
			System.out.println("Act code: " + actCode); //temp

			//"акт взаимозачета";               ActMutual.rpt    
			if (typeAkt.equals("A")) { //"A"
				MutualHeaderValueObject vo = getHeader(st, actCode);
				eform.setHeader(vo);
				//for MutStartDebt SubReport
				eform.setTable1(getList1(st, actCode));
				//for MutCharges SubReport
				eform.setTable2(getList2(st, actCode));
				//for MutualPayments SubReport
				eform.setTable3(getList3(st, actCode));
				//for MutEndDebt SubReport
				eform.setTable4(getList4(st, actCode));
				//for MutTempDebt SubReport
				eform.setTable6(getList6(st, actCode));
				//for ListSumMutualForPrintAct:
				eform.setListSumMutualForPrintAct(getListSumMutualForPrintAct(st, actCode));
				//Конечная задолженность по договорам и услугам, участвующим в акте (взаимозачета и взаимных требований):
				eform.setListMutualDebtNds(getListMutualDebtNds(st, actCode));
			}
			//"акт зачета взаимных требований"; ActAccMutual.rpt
			else if (typeAkt.equals("M")) { //"M"
				ArrayList list = getHeaderAccList(st, actCode);
				eform.setHeaderAccList(list);
				eform.setHeaderAcc((MutualHeaderAccValueObject) list.get(0));
				//for MutStartDebt SubReport
				eform.setTable1(getList1(st, actCode));
				//for MutCharges SubReport
				eform.setTable2(getList2(st, actCode));
				//for MutualPayments SubReport
				eform.setTable3(getList3(st, actCode));
				//for MutEndDebt SubReport
				eform.setTable4(getList4(st, actCode));
				//for MutTempDebt SubReport
				eform.setTable6(getList6(st, actCode));
				//for ListSumMutualForPrintAct:
				eform.setListSumMutualForPrintAct(getListSumMutualForPrintAct(st, actCode));
				//Конечная задолженность по договорам и услугам, участвующим в акте (взаимозачета и взаимных требований):
				eform.setListMutualDebtNds(getListMutualDebtNds(st, actCode));
			}
			//"акт сверки";                     ActSverkaHeader.rpt  
			else if (typeAkt.equals("S")) { //"S"
				int idTask = getIdTask(request, Integer.parseInt(actCode));
				eform.setIdTask(idTask);
				System.out.println("idTask: " + idTask); //temp
				eform.setSverkaHeader(getSverkaHeader(st, idTask));
				//for SverkaContrRes SubReport
				eform.setSverkaContrRes(getSverkaContrRes(st, idTask));
				//for SverkaChrgAndPay SubReport
				eform.setTable5(getList5(st, idTask));
				//System.out.println("form.getList5(): " + eform.getTable5().size()); //temp
			}
		} catch (SQLException sqlExc) {
			System.out.println("SQLException SQLcode=" + sqlExc.getErrorCode());
			sqlExc.printStackTrace(System.out);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}

		String mappingStr = "error";
		//ActMutual.rpt
		if (typeAkt.equals("A")) { //"A"
			mappingStr = "actword";
		}
		//ActAccMutual.rpt
		else if (typeAkt.equals("M")) { //"M"
			mappingStr = "actaccword";
		}
		//ActSverkaHeader.rpt  
		else if (typeAkt.equals("S")) {
			mappingStr = "actsverkaword_" + eform.getSverkaHeader().getTypeView();
		}
		return mapping.findForward(mappingStr);
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 19:19:58)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param actcode java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getList6(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure makeMutTempDebt(" + actcode + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				MutTempDebtValueObject vo = new MutTempDebtValueObject();
				vo.setDebitor(rs.getString(1)); // CHAR(80),	Debitor
				vo.setCreditor(rs.getString(2)); // CHAR(80),	Creditor
				vo.setSumMain(rs.getBigDecimal(3)); // dec(15,2),	SumMain
				vo.setNdsMain(rs.getBigDecimal(4)); // dec(15,2),	NdsMain
				vo.setCurrMain(rs.getString(5).trim()); // char(30),	CurrMain
				vo.setHeaderId(new Integer(rs.getInt(6)));
				list.add(vo);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	drop procedure getListSumMutualForPrintAct;
	create procedure getListSumMutualForPrintAct(
	--execute procedure getListSumMutualForPrintAct(1);
	-- Процедура рассчитывает сумму взаимозачета для печати акта
	-- входные параметры
	i_act integer         -- код акта
	) returning
	varchar(40),         -- номер договора  аренды
	date,                -- дата договора аренды
	varchar(255),        -- список абонентских договоров
	varchar(80),         -- основная валюта
	varchar(80),         -- дополнительная валюта
	char(500),           -- вся строка
	decimal(15,2),       -- сумма взамозачета акта в основной валюте
	decimal(15,2),       -- НДС взамозачета акта в основной валюте
	decimal(15,2),       -- сумма взамозачета акта в дополнительной валюте
	decimal(15,2);       -- НДС взамозачета акта в дополнительной валюте
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param actcode java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getListSumMutualForPrintAct(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure getListSumMutualForPrintAct(" + actcode + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				SumMutualForPrintAct_VO vo = new SumMutualForPrintAct_VO();
				vo.setNumberDoc(rs.getString(1)); // номер договора  аренды
				vo.setDateDoc(rs.getDate(2)); // дата договора аренды
				vo.setListAbonentDog(rs.getString(3)); //  список абонентских договоров
				vo.setCurrMain(rs.getString(4)); // основная валюта
				vo.setCurrDop(rs.getString(5)); // дополнительная валюта
				vo.setAllString(rs.getString(6)); // вся строка
				vo.setSummMain(rs.getBigDecimal(7)); // сумма взамозачета акта в основной валюте
				vo.setNdsMain(rs.getBigDecimal(8)); // НДС взамозачета акта в основной валюте
				vo.setSummDop(rs.getBigDecimal(9)); // сумма взамозачета акта в дополнительной валюте
				vo.setNdsDop(rs.getBigDecimal(10)); // НДС взамозачета акта в дополнительной валюте
				list.add(vo);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}

	/**
	 * 
	 * @param stmt
	 * @param actcode
	 * @return
	 * @throws java.lang.Exception
	 */
	private ArrayList getListMutualDebtNds(Statement stmt, String actcode) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure makeMutualDebtNds(" + actcode + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				MutualDebtNds_VO vo = new MutualDebtNds_VO();
				vo.setCustomer(rs.getString(1));
				vo.setExecutor(rs.getString(2));
				vo.setSumMain(rs.getBigDecimal(3));
				vo.setCurrMain(rs.getString(4));
				vo.setHeaderId(new Integer(rs.getInt(5)));
				list.add(vo);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
}